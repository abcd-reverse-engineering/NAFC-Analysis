package com.alibaba.sdk.android.oss.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected long mLastPartSize;
    protected Object mLock;
    protected int[] mPartAttr;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadFilePath;
    protected String mUploadId;
    protected Uri mUploadUri;
    protected long mUploadedLength;

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int i2 = this.CPU_SIZE;
        this.MAX_CORE_POOL_SIZE = i2 >= 5 ? 5 : i2;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.MAX_QUEUE_SIZE = 5000;
        this.mPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, 3000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0L;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES;
    }

    protected abstract void abortThisUpload();

    protected void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    protected void checkException() throws ServiceException, ClientException, IOException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            }
            if (!(exc instanceof ClientException)) {
                throw new ClientException(exc.getMessage(), this.mUploadException);
            }
            throw ((ClientException) exc);
        }
    }

    protected void checkInitData() throws ClientException, IOException {
        if (this.mRequest.getUploadFilePath() != null) {
            this.mUploadFilePath = this.mRequest.getUploadFilePath();
            this.mUploadedLength = 0L;
            this.mUploadFile = new File(this.mUploadFilePath);
            this.mFileLength = this.mUploadFile.length();
        } else if (this.mRequest.getUploadUri() != null) {
            this.mUploadUri = this.mRequest.getUploadUri();
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = null;
            try {
                try {
                    parcelFileDescriptorOpenFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                    this.mFileLength = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                } catch (IOException e2) {
                    throw new ClientException(e2.getMessage(), e2, true);
                }
            } finally {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (IOException e3) {
                        OSSLog.logThrowable2Local(e3);
                    }
                }
            }
        }
        if (this.mFileLength == 0) {
            throw new ClientException("file length must not be 0");
        }
        checkPartSize(this.mPartAttr);
        long partSize = this.mRequest.getPartSize();
        int i2 = this.mPartAttr[1];
        OSSLog.logDebug("[checkInitData] - partNumber : " + i2);
        OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
        if (i2 > 1 && partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
            throw new ClientException("Part size must be greater than or equal to 100KB!");
        }
    }

    protected void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j2 = this.mFileLength;
        int i2 = (int) (j2 / partSize);
        if (j2 % partSize != 0) {
            i2++;
        }
        if (i2 == 1) {
            partSize = this.mFileLength;
        } else if (i2 > 5000) {
            partSize = this.mFileLength / 5000;
            i2 = 5000;
        }
        int i3 = (int) partSize;
        iArr[0] = i3;
        iArr[1] = i2;
        this.mRequest.setPartSize(i3);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + i2);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i3);
        long j3 = this.mFileLength % partSize;
        if (j3 != 0) {
            partSize = j3;
        }
        this.mLastPartSize = partSize;
    }

    protected boolean checkWaitCondition(int i2) {
        return this.mPartETags.size() != i2;
    }

    protected CompleteMultipartUploadResult completeMultipartUploadResult() throws ServiceException, ClientException {
        CompleteMultipartUploadResult completeMultipartUploadResultSyncCompleteMultipartUpload;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.2
                @Override // java.util.Comparator
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            if (this.mRequest.getMetadata() != null) {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                for (String str : this.mRequest.getMetadata().getRawMetadata().keySet()) {
                    if (!str.equals(OSSHeaders.STORAGE_CLASS)) {
                        objectMetadata.setHeader(str, this.mRequest.getMetadata().getRawMetadata().get(str));
                    }
                }
                completeMultipartUploadRequest.setMetadata(objectMetadata);
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResultSyncCompleteMultipartUpload = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResultSyncCompleteMultipartUpload = null;
        }
        this.mUploadedLength = 0L;
        return completeMultipartUploadResultSyncCompleteMultipartUpload;
    }

    protected abstract Result doMultipartUpload() throws ServiceException, ClientException, InterruptedException, IOException;

    protected abstract void initMultipartUploadId() throws ServiceException, ClientException, IOException;

    protected void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    protected void onProgressCallback(Request request, long j2, long j3) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j2, j3);
        }
    }

    protected void preUploadPart(int i2, int i3, int i4) throws Exception {
    }

    protected abstract void processException(Exception exc);

    protected void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0153 A[Catch: IOException -> 0x0157, TRY_ENTER, TryCatch #0 {IOException -> 0x0157, blocks: (B:48:0x0120, B:50:0x0125, B:52:0x012a, B:74:0x0153, B:78:0x015b, B:80:0x0160), top: B:97:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015b A[Catch: IOException -> 0x0157, TryCatch #0 {IOException -> 0x0157, blocks: (B:48:0x0120, B:50:0x0125, B:52:0x012a, B:74:0x0153, B:78:0x015b, B:80:0x0160), top: B:97:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0160 A[Catch: IOException -> 0x0157, TRY_LEAVE, TryCatch #0 {IOException -> 0x0157, blocks: (B:48:0x0120, B:50:0x0125, B:52:0x012a, B:74:0x0153, B:78:0x015b, B:80:0x0160), top: B:97:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0174 A[Catch: IOException -> 0x0170, TryCatch #5 {IOException -> 0x0170, blocks: (B:87:0x016c, B:91:0x0174, B:93:0x0179), top: B:102:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0179 A[Catch: IOException -> 0x0170, TRY_LEAVE, TryCatch #5 {IOException -> 0x0170, blocks: (B:87:0x016c, B:91:0x0174, B:93:0x0179), top: B:102:0x016c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void uploadPart(int r15, int r16, int r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.uploadPart(int, int, int):void");
    }

    protected void uploadPartFinish(PartETag partETag) throws Exception {
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        try {
            checkInitData();
            initMultipartUploadId();
            Result result = (Result) doMultipartUpload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, result);
            }
            return result;
        } catch (ServiceException e2) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(this.mRequest, null, e2);
            }
            throw e2;
        } catch (Exception e3) {
            ClientException clientException = e3 instanceof ClientException ? (ClientException) e3 : new ClientException(e3.toString(), e3);
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }
}
