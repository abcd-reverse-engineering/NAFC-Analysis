package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new ArrayList();
        this.mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void abortThisUpload() throws ExecutionException, InterruptedException {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void checkException() throws Throwable {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else {
                List<PartETag> list = this.mPartETags;
                if (list != null && list.size() > 0 && this.mCheckCRC64 && ((ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                    HashMap map = new HashMap();
                    for (PartETag partETag : this.mPartETags) {
                        map.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
                    }
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        try {
                            this.mCRC64RecordFile = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                            if (!this.mCRC64RecordFile.exists()) {
                                this.mCRC64RecordFile.createNewFile();
                            }
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.mCRC64RecordFile));
                            try {
                                objectOutputStream2.writeObject(map);
                                objectOutputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                OSSLog.logThrowable2Local(e);
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                super.checkException();
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream = objectOutputStream2;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
            }
        }
        super.checkException();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0182 A[Catch: ClientException -> 0x01ed, ServiceException -> 0x01ef, TryCatch #6 {ClientException -> 0x01ed, ServiceException -> 0x01ef, blocks: (B:48:0x0169, B:49:0x017c, B:51:0x0182, B:53:0x019e, B:55:0x01a4, B:57:0x01b2, B:58:0x01c7, B:60:0x01e4), top: B:93:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x023d  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void initMultipartUploadId() throws java.util.concurrent.ExecutionException, com.alibaba.sdk.android.oss.ServiceException, java.lang.InterruptedException, com.alibaba.sdk.android.oss.ClientException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.initMultipartUploadId():void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mIsCancel) {
            return;
        }
        this.mIsCancel = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf A[Catch: IOException -> 0x01c6, TRY_LEAVE, TryCatch #9 {IOException -> 0x01c6, blocks: (B:95:0x01c2, B:99:0x01ca, B:101:0x01cf), top: B:106:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6 A[Catch: ServiceException -> 0x011a, all -> 0x011c, Exception -> 0x011e, TryCatch #11 {ServiceException -> 0x011a, blocks: (B:30:0x0096, B:32:0x00c6, B:33:0x00d1, B:35:0x00ea, B:43:0x0105, B:44:0x0119), top: B:108:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea A[Catch: ServiceException -> 0x011a, all -> 0x011c, Exception -> 0x011e, TRY_LEAVE, TryCatch #11 {ServiceException -> 0x011a, blocks: (B:30:0x0096, B:32:0x00c6, B:33:0x00d1, B:35:0x00ea, B:43:0x0105, B:44:0x0119), top: B:108:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105 A[Catch: ServiceException -> 0x011a, all -> 0x011c, Exception -> 0x011e, TRY_ENTER, TryCatch #11 {ServiceException -> 0x011a, blocks: (B:30:0x0096, B:32:0x00c6, B:33:0x00d1, B:35:0x00ea, B:43:0x0105, B:44:0x0119), top: B:108:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144 A[Catch: IOException -> 0x0148, TRY_ENTER, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c A[Catch: IOException -> 0x0148, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0165 A[Catch: all -> 0x01bc, TryCatch #15 {all -> 0x01bc, blocks: (B:65:0x013f, B:78:0x015d, B:80:0x0165, B:81:0x0169, B:83:0x0183, B:84:0x01a1), top: B:109:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0169 A[Catch: all -> 0x01bc, TryCatch #15 {all -> 0x01bc, blocks: (B:65:0x013f, B:78:0x015d, B:80:0x0165, B:81:0x0169, B:83:0x0183, B:84:0x01a1), top: B:109:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ae A[Catch: IOException -> 0x0148, TRY_ENTER, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b3 A[Catch: IOException -> 0x0148, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b8 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ca A[Catch: IOException -> 0x01c6, TryCatch #9 {IOException -> 0x01c6, blocks: (B:95:0x01c2, B:99:0x01ca, B:101:0x01cf), top: B:106:0x01c2 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.alibaba.sdk.android.oss.model.UploadPartRequest] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask, com.alibaba.sdk.android.oss.internal.SequenceUploadTask] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadPart(int r16, int r17, int r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.uploadPart(int, int, int):void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void uploadPartFinish(PartETag partETag) throws Exception {
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mSp.contains(this.mUploadId)) {
            return;
        }
        this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws Throwable {
        long j2 = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long jLongValue = this.mUploadedLength;
            if (jLongValue > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.mFirstPartSize != i2) {
                throw new ClientException("The part size setting is inconsistent with before");
            }
            if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                jLongValue = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j3 = jLongValue;
            OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
            if (oSSProgressCallback != 0) {
                oSSProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
            }
            this.mSp.removeKey(this.mUploadId);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i4 + 1))) {
                if (i4 == i3 - 1) {
                    i2 = (int) (this.mFileLength - j2);
                }
                OSSLog.logDebug("upload part readByte : " + i2);
                j2 += (long) i2;
                uploadPart(i4, i2, i3);
                if (this.mUploadException != null) {
                    break;
                }
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new ResumableUploadResult(completeMultipartUploadResult) : null;
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        return resumableUploadResult;
    }
}
