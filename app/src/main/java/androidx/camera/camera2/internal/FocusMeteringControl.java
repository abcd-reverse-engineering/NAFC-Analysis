package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.CaptureConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class FocusMeteringControl {
    private static final String TAG = "FocusMeteringControl";
    private ScheduledFuture<?> mAutoCancelHandle;
    private final Camera2CameraControl mCameraControl;
    private FocusMeteringAction mCurrentFocusMeteringAction;
    final Executor mExecutor;
    private final ScheduledExecutorService mScheduler;
    private volatile boolean mIsActive = false;
    private boolean mIsInAfAutoMode = false;
    Integer mCurrentAfState = 0;
    long mFocusTimeoutCounter = 0;
    boolean mIsAutoFocusCompleted = false;
    boolean mIsFocusSuccessful = false;
    private Camera2CameraControl.CaptureResultListener mSessionListenerForFocus = null;
    private Camera2CameraControl.CaptureResultListener mSessionListenerForCancel = null;
    private MeteringRectangle[] mAfRects = new MeteringRectangle[0];
    private MeteringRectangle[] mAeRects = new MeteringRectangle[0];
    private MeteringRectangle[] mAwbRects = new MeteringRectangle[0];
    MeteringRectangle[] mDefaultAfRects = new MeteringRectangle[0];
    MeteringRectangle[] mDefaultAeRects = new MeteringRectangle[0];
    MeteringRectangle[] mDefaultAwbRects = new MeteringRectangle[0];
    CallbackToFutureAdapter.Completer<FocusMeteringResult> mRunningActionCompleter = null;
    CallbackToFutureAdapter.Completer<Void> mRunningCancelCompleter = null;

    FocusMeteringControl(@NonNull Camera2CameraControl camera2CameraControl, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor) {
        this.mCameraControl = camera2CameraControl;
        this.mExecutor = executor;
        this.mScheduler = scheduledExecutorService;
    }

    @WorkerThread
    private void completeActionFuture(boolean z) {
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.set(FocusMeteringResult.create(z));
            this.mRunningActionCompleter = null;
        }
    }

    @WorkerThread
    private void completeCancelFuture() {
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.set(null);
            this.mRunningCancelCompleter = null;
        }
    }

    @WorkerThread
    private void disableAutoCancel() {
        ScheduledFuture<?> scheduledFuture = this.mAutoCancelHandle;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.mAutoCancelHandle = null;
        }
    }

    @WorkerThread
    private void executeMeteringAction(@NonNull final MeteringRectangle[] meteringRectangleArr, @NonNull final MeteringRectangle[] meteringRectangleArr2, @NonNull final MeteringRectangle[] meteringRectangleArr3, FocusMeteringAction focusMeteringAction) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        disableAutoCancel();
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr2;
        this.mAwbRects = meteringRectangleArr3;
        if (shouldTriggerAF()) {
            this.mIsInAfAutoMode = true;
            this.mIsAutoFocusCompleted = false;
            this.mIsFocusSuccessful = false;
            this.mCameraControl.updateSessionConfig();
            triggerAf();
        } else {
            this.mIsInAfAutoMode = false;
            this.mIsAutoFocusCompleted = true;
            this.mIsFocusSuccessful = false;
            this.mCameraControl.updateSessionConfig();
        }
        this.mCurrentAfState = 0;
        final boolean zIsAfModeSupported = isAfModeSupported();
        this.mSessionListenerForFocus = new Camera2CameraControl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.w
            @Override // androidx.camera.camera2.internal.Camera2CameraControl.CaptureResultListener
            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                return this.f1434a.a(zIsAfModeSupported, meteringRectangleArr, meteringRectangleArr2, meteringRectangleArr3, totalCaptureResult);
            }
        };
        this.mCameraControl.addCaptureResultListener(this.mSessionListenerForFocus);
        if (focusMeteringAction.isAutoCancelEnabled()) {
            final long j2 = this.mFocusTimeoutCounter + 1;
            this.mFocusTimeoutCounter = j2;
            this.mAutoCancelHandle = this.mScheduler.schedule(new Runnable() { // from class: androidx.camera.camera2.internal.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1430a.a(j2);
                }
            }, focusMeteringAction.getAutoCancelDurationInMillis(), TimeUnit.MILLISECONDS);
        }
    }

    @WorkerThread
    private void failActionFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningActionCompleter = null;
        }
    }

    @WorkerThread
    private void failCancelFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForCancel);
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningCancelCompleter = null;
        }
    }

    @WorkerThread
    private int getDefaultTemplate() {
        return 1;
    }

    @WorkerThread
    private PointF getFovAdjustedPoint(@NonNull MeteringPoint meteringPoint, @NonNull Rational rational, @NonNull Rational rational2) {
        if (meteringPoint.getSurfaceAspectRatio() != null) {
            rational2 = meteringPoint.getSurfaceAspectRatio();
        }
        PointF pointF = new PointF(meteringPoint.getX(), meteringPoint.getY());
        if (!rational2.equals(rational)) {
            if (rational2.compareTo(rational) > 0) {
                float fDoubleValue = (float) (rational2.doubleValue() / rational.doubleValue());
                pointF.y = (((float) ((fDoubleValue - 1.0d) / 2.0d)) + pointF.y) * (1.0f / fDoubleValue);
            } else {
                float fDoubleValue2 = (float) (rational.doubleValue() / rational2.doubleValue());
                pointF.x = (((float) ((fDoubleValue2 - 1.0d) / 2.0d)) + pointF.x) * (1.0f / fDoubleValue2);
            }
        }
        return pointF;
    }

    @WorkerThread
    private MeteringRectangle getMeteringRect(MeteringPoint meteringPoint, PointF pointF, Rect rect) {
        int iWidth = (int) (rect.left + (pointF.x * rect.width()));
        int iHeight = (int) (rect.top + (pointF.y * rect.height()));
        int size = ((int) (meteringPoint.getSize() * rect.width())) / 2;
        int size2 = ((int) (meteringPoint.getSize() * rect.height())) / 2;
        Rect rect2 = new Rect(iWidth - size, iHeight - size2, iWidth + size, iHeight + size2);
        rect2.left = rangeLimit(rect2.left, rect.right, rect.left);
        rect2.right = rangeLimit(rect2.right, rect.right, rect.left);
        rect2.top = rangeLimit(rect2.top, rect.bottom, rect.top);
        rect2.bottom = rangeLimit(rect2.bottom, rect.bottom, rect.top);
        return new MeteringRectangle(rect2, 1000);
    }

    private static int getRegionCount(@Nullable MeteringRectangle[] meteringRectangleArr) {
        if (meteringRectangleArr == null) {
            return 0;
        }
        return meteringRectangleArr.length;
    }

    private static boolean hasEqualRegions(@Nullable MeteringRectangle[] meteringRectangleArr, @Nullable MeteringRectangle[] meteringRectangleArr2) {
        if (getRegionCount(meteringRectangleArr) == 0 && getRegionCount(meteringRectangleArr2) == 0) {
            return true;
        }
        if (getRegionCount(meteringRectangleArr) != getRegionCount(meteringRectangleArr2)) {
            return false;
        }
        if (meteringRectangleArr != null && meteringRectangleArr2 != null) {
            for (int i2 = 0; i2 < meteringRectangleArr.length; i2++) {
                if (!meteringRectangleArr[i2].equals(meteringRectangleArr2[i2])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAfModeSupported() {
        return this.mCameraControl.getSupportedAfMode(1) == 1;
    }

    @WorkerThread
    private int rangeLimit(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i4), i3);
    }

    @WorkerThread
    private boolean shouldTriggerAF() {
        return this.mAfRects.length > 0;
    }

    @WorkerThread
    void addFocusMeteringOptions(@NonNull Camera2ImplConfig.Builder builder) {
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.mCameraControl.getSupportedAfMode(this.mIsInAfAutoMode ? 1 : 4)));
        MeteringRectangle[] meteringRectangleArr = this.mAfRects;
        if (meteringRectangleArr.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        MeteringRectangle[] meteringRectangleArr2 = this.mAeRects;
        if (meteringRectangleArr2.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        }
        MeteringRectangle[] meteringRectangleArr3 = this.mAwbRects;
        if (meteringRectangleArr3.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3);
        }
    }

    public /* synthetic */ void b(long j2) {
        if (j2 == this.mFocusTimeoutCounter) {
            a();
        }
    }

    @WorkerThread
    void cancelAfAeTrigger(boolean z, boolean z2) {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setUseRepeatingSurface(true);
            builder.setTemplateType(getDefaultTemplate());
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (z) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (Build.VERSION.SDK_INT >= 23 && z2) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.a(Collections.singletonList(builder.build()));
        }
    }

    c.b.b.a.a.a<Void> cancelFocusAndMetering() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.p
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f1419a.a(completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: cancelFocusAndMeteringInternal, reason: merged with bridge method [inline-methods] */
    public void b(@Nullable CallbackToFutureAdapter.Completer<Void> completer) {
        failCancelFuture("Cancelled by another cancelFocusAndMetering()");
        failActionFuture("Cancelled by cancelFocusAndMetering()");
        this.mRunningCancelCompleter = completer;
        disableAutoCancel();
        if (this.mRunningCancelCompleter != null) {
            final int supportedAfMode = this.mCameraControl.getSupportedAfMode(4);
            this.mSessionListenerForCancel = new Camera2CameraControl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.x
                @Override // androidx.camera.camera2.internal.Camera2CameraControl.CaptureResultListener
                public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                    return this.f1439a.a(supportedAfMode, totalCaptureResult);
                }
            };
            this.mCameraControl.addCaptureResultListener(this.mSessionListenerForCancel);
        }
        if (shouldTriggerAF()) {
            cancelAfAeTrigger(true, false);
        }
        this.mAfRects = new MeteringRectangle[0];
        this.mAeRects = new MeteringRectangle[0];
        this.mAwbRects = new MeteringRectangle[0];
        this.mIsInAfAutoMode = false;
        this.mCameraControl.updateSessionConfig();
        this.mCurrentFocusMeteringAction = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: cancelFocusAndMeteringWithoutAsyncResult, reason: merged with bridge method [inline-methods] */
    public void a() {
        b(null);
    }

    void setActive(boolean z) {
        if (z == this.mIsActive) {
            return;
        }
        this.mIsActive = z;
        if (this.mIsActive) {
            return;
        }
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f1420a.a();
            }
        });
    }

    void setDefaultRequestBuilder(@NonNull CaptureRequest.Builder builder) {
        this.mDefaultAfRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AF_REGIONS);
        this.mDefaultAeRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AE_REGIONS);
        this.mDefaultAwbRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AWB_REGIONS);
    }

    c.b.b.a.a.a<FocusMeteringResult> startFocusAndMetering(@NonNull final FocusMeteringAction focusMeteringAction, @Nullable final Rational rational) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.r
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f1421a.a(focusMeteringAction, rational, completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: startFocusAndMeteringInternal, reason: merged with bridge method [inline-methods] */
    public void a(@NonNull CallbackToFutureAdapter.Completer<FocusMeteringResult> completer, @NonNull FocusMeteringAction focusMeteringAction, @Nullable Rational rational) {
        if (!this.mIsActive) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        if (focusMeteringAction.getMeteringPointsAf().isEmpty() && focusMeteringAction.getMeteringPointsAe().isEmpty() && focusMeteringAction.getMeteringPointsAwb().isEmpty()) {
            completer.setException(new IllegalArgumentException("No AF/AE/AWB MeteringPoints are added."));
            return;
        }
        int iMin = Math.min(focusMeteringAction.getMeteringPointsAf().size(), this.mCameraControl.getMaxAfRegionCount());
        int iMin2 = Math.min(focusMeteringAction.getMeteringPointsAe().size(), this.mCameraControl.getMaxAeRegionCount());
        int iMin3 = Math.min(focusMeteringAction.getMeteringPointsAwb().size(), this.mCameraControl.getMaxAwbRegionCount());
        if (iMin + iMin2 + iMin3 <= 0) {
            completer.setException(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
            return;
        }
        ArrayList<MeteringPoint> arrayList = new ArrayList();
        ArrayList<MeteringPoint> arrayList2 = new ArrayList();
        ArrayList<MeteringPoint> arrayList3 = new ArrayList();
        if (iMin > 0) {
            arrayList.addAll(focusMeteringAction.getMeteringPointsAf().subList(0, iMin));
        }
        if (iMin2 > 0) {
            arrayList2.addAll(focusMeteringAction.getMeteringPointsAe().subList(0, iMin2));
        }
        if (iMin3 > 0) {
            arrayList3.addAll(focusMeteringAction.getMeteringPointsAwb().subList(0, iMin3));
        }
        failActionFuture("Cancelled by another startFocusAndMetering()");
        failCancelFuture("Cancelled by another startFocusAndMetering()");
        if (this.mCurrentFocusMeteringAction != null) {
            a();
        }
        disableAutoCancel();
        this.mCurrentFocusMeteringAction = focusMeteringAction;
        this.mRunningActionCompleter = completer;
        Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
        Rational rational2 = new Rational(cropSensorRegion.width(), cropSensorRegion.height());
        if (rational == null) {
            rational = rational2;
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (MeteringPoint meteringPoint : arrayList) {
            arrayList4.add(getMeteringRect(meteringPoint, getFovAdjustedPoint(meteringPoint, rational2, rational), cropSensorRegion));
        }
        for (MeteringPoint meteringPoint2 : arrayList2) {
            arrayList5.add(getMeteringRect(meteringPoint2, getFovAdjustedPoint(meteringPoint2, rational2, rational), cropSensorRegion));
        }
        for (MeteringPoint meteringPoint3 : arrayList3) {
            arrayList6.add(getMeteringRect(meteringPoint3, getFovAdjustedPoint(meteringPoint3, rational2, rational), cropSensorRegion));
        }
        executeMeteringAction((MeteringRectangle[]) arrayList4.toArray(new MeteringRectangle[0]), (MeteringRectangle[]) arrayList5.toArray(new MeteringRectangle[0]), (MeteringRectangle[]) arrayList6.toArray(new MeteringRectangle[0]), focusMeteringAction);
    }

    @WorkerThread
    void triggerAePrecapture() {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(getDefaultTemplate());
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.a(Collections.singletonList(builder.build()));
        }
    }

    @WorkerThread
    void triggerAf() {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(getDefaultTemplate());
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.a(Collections.singletonList(builder.build()));
        }
    }

    public /* synthetic */ Object a(final FocusMeteringAction focusMeteringAction, final Rational rational, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f1424a.a(completer, focusMeteringAction, rational);
            }
        });
        return "startFocusAndMetering";
    }

    public /* synthetic */ boolean a(boolean z, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, MeteringRectangle[] meteringRectangleArr3, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (shouldTriggerAF()) {
            if (this.mCurrentAfState.intValue() == 3) {
                if (num.intValue() == 4) {
                    this.mIsFocusSuccessful = true;
                    this.mIsAutoFocusCompleted = true;
                } else if (num.intValue() == 5) {
                    this.mIsFocusSuccessful = false;
                    this.mIsAutoFocusCompleted = true;
                }
            } else if (!z) {
                this.mIsFocusSuccessful = true;
                this.mIsAutoFocusCompleted = true;
            }
        }
        if (this.mIsAutoFocusCompleted && totalCaptureResult.getRequest() != null) {
            if (meteringRectangleArr.length == 0) {
                meteringRectangleArr = this.mDefaultAfRects;
            }
            if (meteringRectangleArr2.length == 0) {
                meteringRectangleArr2 = this.mDefaultAeRects;
            }
            if (meteringRectangleArr3.length == 0) {
                meteringRectangleArr3 = this.mDefaultAwbRects;
            }
            CaptureRequest request = totalCaptureResult.getRequest();
            if (hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AF_REGIONS), meteringRectangleArr) && hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AE_REGIONS), meteringRectangleArr2) && hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AWB_REGIONS), meteringRectangleArr3)) {
                completeActionFuture(this.mIsFocusSuccessful);
                return true;
            }
        }
        if (!this.mCurrentAfState.equals(num)) {
            this.mCurrentAfState = num;
        }
        return false;
    }

    public /* synthetic */ void a(final long j2) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f1428a.b(j2);
            }
        });
    }

    public /* synthetic */ Object a(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f1432a.b(completer);
            }
        });
        return "cancelFocusAndMetering";
    }

    public /* synthetic */ boolean a(int i2, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        CaptureRequest request = totalCaptureResult.getRequest();
        MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AF_REGIONS);
        MeteringRectangle[] meteringRectangleArr2 = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AE_REGIONS);
        MeteringRectangle[] meteringRectangleArr3 = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AWB_REGIONS);
        if (num.intValue() != i2 || !hasEqualRegions(meteringRectangleArr, this.mDefaultAfRects) || !hasEqualRegions(meteringRectangleArr2, this.mDefaultAeRects) || !hasEqualRegions(meteringRectangleArr3, this.mDefaultAwbRects)) {
            return false;
        }
        completeCancelFuture();
        return true;
    }
}
