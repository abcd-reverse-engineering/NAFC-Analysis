package cn.cloudwalk.libproject;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Camera;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.cloudwalk.CloudwalkSDK;
import cn.cloudwalk.FaceInterface;
import cn.cloudwalk.callback.FaceInfoCallback;
import cn.cloudwalk.callback.LivessCallBack;
import cn.cloudwalk.exception.InitializeException;
import cn.cloudwalk.jni.FaceInfo;
import cn.cloudwalk.jni.FaceParam;
import cn.cloudwalk.libproject.callback.FrontDetectCallback;
import cn.cloudwalk.libproject.callback.FrontLiveCallback;
import cn.cloudwalk.libproject.callback.InitializeCallBack;
import cn.cloudwalk.libproject.callback.ResultCallBack;
import cn.cloudwalk.libproject.camera.CameraPreview;
import cn.cloudwalk.libproject.camera.Delegate;
import cn.cloudwalk.libproject.dialog.LivenessTimeOutDialog;
import cn.cloudwalk.libproject.dialog.OnDialogClickListener;
import cn.cloudwalk.libproject.util.CameraUtil;
import cn.cloudwalk.libproject.util.NullUtils;
import cn.cloudwalk.libproject.util.PermissionUtils;
import cn.cloudwalk.libproject.util.ScreenListener;
import cn.cloudwalk.libproject.view.CircleMarkView;
import cn.cloudwalk.libproject.view.CircleView;
import cn.cloudwalk.libproject.view.RoundFrameLayout;
import cn.cloudwalk.libproject.view.RoundTextureView;
import cn.cloudwalk.util.LogUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import util.permissionutil.a;

/* loaded from: classes.dex */
public class LiveActivity extends BaseActivity implements LivessCallBack, FaceInfoCallback, CameraPreview.CWPreviewCallback, ViewTreeObserver.OnGlobalLayoutListener {
    static final int DETECT_READY = 126;
    static final int FRAME_INFO = 201;
    static final int NEXT_STEP = 101;
    private static final int OPEN_PERMISSIONS_MANUALLY = 1011;
    private static final int PERMISSION_REQUEST_CODE = 136;
    static final int PLAYMAIN_END = 125;
    static final int READYINFO = 127;
    static final int SAVE_DATA = 202;
    static final int SET_RESULT = 122;
    static final int SOUND_AGAIN = 200;
    static final int UPDATESTEPLAYOUT = 124;
    static final int UPDATE_STEP_PROCRESS = 106;
    private Timer animTimer;
    private AnimationDrawable animationDrawable;
    int caremaId;
    private CircleMarkView circle_mark;
    private CircleView circle_view;
    public CloudwalkSDK cloudwalkSDK;
    private int currentLivessType;
    int currentPlaySoundId;
    int currentStep;
    int currentStreamID;
    public List<Integer> execLiveList;
    TimerRunnable faceTimerRunnable;
    private FrameLayout fl_content;
    private ImageView img_tip;
    public int initRet;
    private RoundFrameLayout insertFrameLayout;
    boolean isLivePass;
    boolean isLoadmain;
    volatile boolean isStartDetectFace;
    boolean isStop;
    LiveBroadcastReceiver liveBroadcastReceiver;
    LiveServerBroadcastReceiver liveServerBroadcastReceiver;
    LocalBroadcastManager localBroadcastManager;
    DetectSoundRunnable mDetectSoundRunnable;
    MainHandler mMainHandler;
    CameraPreview mPreview;
    private LivenessTimeOutDialog mTimeOutdialog;
    private int orientation;
    public Map<String, Integer> poolMap;
    private ScreenListener screenListener;
    public SoundPool sndPool;
    private TextSwitcher textSwitcher;
    private RoundTextureView textureView;
    private TextView tv_time_tips;
    private final String TAG = LogUtils.makeLogTag(Builder.FACE_DETECT_ACTIVITY);
    private final String[] PERMISSIONS = {a.f20909c};
    boolean isSetResult = false;
    boolean isPlayMain = true;
    int totalStep = 0;
    long mLastPrepareInfoTime = 0;
    private boolean lockScreen = false;
    private boolean foreground = true;
    private boolean isAnimFirst = true;
    private int animIndex = 0;
    private boolean isStartAnimEnd = false;
    private String[] livenessAbis = {"armeabi", "armeabi-v7a", "arm64-v8a"};
    private boolean mIsHasPermission = false;
    private int preLivessCode = 0;
    private Delegate delegate = new Delegate() { // from class: cn.cloudwalk.libproject.LiveActivity.1
        @Override // cn.cloudwalk.libproject.camera.Delegate
        public void onFocus(float f2, float f3) {
        }

        @Override // cn.cloudwalk.libproject.camera.Delegate
        public void onFocused() {
        }

        @Override // cn.cloudwalk.libproject.camera.Delegate
        public void onOpenCameraError() {
            LiveActivity.this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_OPEN_CAMERA_FAIL)).sendToTarget();
        }

        @Override // cn.cloudwalk.libproject.camera.Delegate
        public void startPreview() {
            Camera.Size previewSize = LiveActivity.this.mPreview.getPreviewSize();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) LiveActivity.this.textureView.getLayoutParams();
            int i2 = layoutParams.width;
            int i3 = LiveActivity.this.getResources().getConfiguration().orientation == 2 ? (layoutParams.width * previewSize.height) / previewSize.width : (layoutParams.width * previewSize.width) / previewSize.height;
            if (i3 != layoutParams.height) {
                LiveActivity liveActivity = LiveActivity.this;
                liveActivity.insertFrameLayout = new RoundFrameLayout(liveActivity);
                int iMin = Math.min(i2, i3);
                LiveActivity.this.insertFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(iMin, iMin));
                FrameLayout frameLayout = (FrameLayout) LiveActivity.this.textureView.getParent();
                frameLayout.removeView(LiveActivity.this.textureView);
                frameLayout.addView(LiveActivity.this.insertFrameLayout);
                LiveActivity.this.insertFrameLayout.addView(LiveActivity.this.textureView);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i3);
                if (LiveActivity.this.getResources().getConfiguration().orientation == 2) {
                    layoutParams2.leftMargin = (i3 - i2) / 2;
                } else {
                    layoutParams2.topMargin = (-(i3 - i2)) / 2;
                }
                LiveActivity.this.textureView.setLayoutParams(layoutParams2);
            }
            (LiveActivity.this.insertFrameLayout != null ? LiveActivity.this.insertFrameLayout : LiveActivity.this.textureView).post(new Runnable() { // from class: cn.cloudwalk.libproject.LiveActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveActivity.this.insertFrameLayout != null) {
                        LiveActivity.this.insertFrameLayout.setRadius(Math.min(LiveActivity.this.insertFrameLayout.getWidth(), LiveActivity.this.insertFrameLayout.getHeight()) / 2);
                        LiveActivity.this.insertFrameLayout.turnRound();
                    } else {
                        LiveActivity.this.textureView.setRadius(Math.min(LiveActivity.this.textureView.getWidth(), LiveActivity.this.textureView.getHeight()) / 2);
                        LiveActivity.this.textureView.turnRound();
                    }
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) LiveActivity.this.circle_mark.getLayoutParams();
                    layoutParams3.width = LiveActivity.this.fl_content.getWidth() + (LiveActivity.this.circle_mark.lineHeight * 2);
                    layoutParams3.height = LiveActivity.this.fl_content.getWidth() + (LiveActivity.this.circle_mark.lineHeight * 2);
                    LiveActivity.this.circle_mark.setLayoutParams(layoutParams3);
                    LiveActivity.this.circle_mark.setRadius(layoutParams3.width / 2);
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) LiveActivity.this.circle_view.getLayoutParams();
                    layoutParams4.width = LiveActivity.this.fl_content.getWidth();
                    layoutParams4.height = LiveActivity.this.fl_content.getWidth();
                    LiveActivity.this.circle_view.setLayoutParams(layoutParams4);
                    LiveActivity.this.circle_view.setRadius(layoutParams3.width / 2);
                    if (LiveActivity.this.isAnimFirst) {
                        LiveActivity.this.isAnimFirst = false;
                        LiveActivity.this.circleMarkAnim();
                    }
                }
            });
        }
    };
    private PermissionUtils.IPermissionsResult mIPermissionsResult = new PermissionUtils.IPermissionsResult() { // from class: cn.cloudwalk.libproject.LiveActivity.2
        @Override // cn.cloudwalk.libproject.util.PermissionUtils.IPermissionsResult
        public void forbidPermissions() {
            LiveActivity.this.mIsHasPermission = false;
            LiveActivity.this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_LACK_CAMERA_PERMISSION)).sendToTarget();
        }

        @Override // cn.cloudwalk.libproject.util.PermissionUtils.IPermissionsResult
        public void passPermissions() {
            LiveActivity.this.mIsHasPermission = true;
            LiveActivity liveActivity = LiveActivity.this;
            liveActivity.initSoundPool(liveActivity.getApplicationContext());
            LiveActivity.this.initCloudwalkSDK();
            LiveActivity.this.initCallBack();
            LiveActivity liveActivity2 = LiveActivity.this;
            liveActivity2.mPreview.setDelegate(liveActivity2.delegate);
        }
    };

    public static class DetectSoundRunnable implements Runnable {
        private boolean flag = true;
        private final WeakReference<LiveActivity> mActivity;

        public DetectSoundRunnable(LiveActivity liveActivity) {
            this.mActivity = new WeakReference<>(liveActivity);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.flag) {
                LiveActivity liveActivity = this.mActivity.get();
                liveActivity.startTimerRunnable(Builder.timerCount, false);
                liveActivity.cloudwalkSDK.cwStartLivess(liveActivity.currentLivessType);
            }
        }

        public void setFlag(boolean z) {
            this.flag = z;
        }
    }

    public class LiveBroadcastReceiver extends BroadcastReceiver {
        public LiveBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("isFaceComparePass", 6);
            String stringExtra = intent.getStringExtra("faceSessionId");
            String stringExtra2 = intent.getStringExtra("faceCompareTipMsg");
            LiveActivity.this.setFaceResult(intExtra, intent.getDoubleExtra("faceCompareScore", 0.0d), stringExtra, stringExtra2);
        }
    }

    public class LiveServerBroadcastReceiver extends BroadcastReceiver {
        public LiveServerBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LiveActivity.this.setFaceLiveResult(intent.getIntExtra("extInfo", 9), intent.getIntExtra("result", 9));
        }
    }

    private static class MainHandler extends Handler {
        private final WeakReference<LiveActivity> mActivity;

        public MainHandler(LiveActivity liveActivity) {
            this.mActivity = new WeakReference<>(liveActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LiveActivity liveActivity = this.mActivity.get();
            if (liveActivity == null) {
                return;
            }
            int i2 = message.what;
            if (i2 == 101) {
                int i3 = liveActivity.totalStep;
                int i4 = liveActivity.currentStep;
                if (i3 == i4) {
                    liveActivity.cloudwalkSDK.setPushFrame(false);
                    liveActivity.getBestFace();
                    if (Builder.antiHackMethod == 2 || Builder.isServerLive) {
                        liveActivity.doFaceSerLivess();
                    } else if (Builder.antiHackMethod == 1 || Builder.isFrontHack) {
                        liveActivity.doFrontFaceLivess();
                    }
                } else {
                    liveActivity.startLivessDetect(liveActivity.execLiveList.get(i4 - 1).intValue());
                }
            } else if (i2 == 106) {
                Integer num = (Integer) message.obj;
                if (num.intValue() <= Builder.timerCount / 2) {
                    liveActivity.tv_time_tips.setTextColor(liveActivity.getResources().getColor(R.color.color_fffbc400));
                    liveActivity.tv_time_tips.setTextSize(2, 18.0f);
                } else {
                    liveActivity.tv_time_tips.setTextColor(liveActivity.getResources().getColor(R.color.color_ffffff));
                    liveActivity.tv_time_tips.setTextSize(2, 14.0f);
                }
                liveActivity.tv_time_tips.setText("超时提示：" + num + ExifInterface.LATITUDE_SOUTH);
            } else if (i2 != 122) {
                switch (i2) {
                    case 124:
                        List<Integer> list = liveActivity.execLiveList;
                        if (list != null && list.size() > 0) {
                            liveActivity.updateStepLayout(liveActivity.execLiveList.get(liveActivity.currentStep - 1).intValue());
                            break;
                        }
                        break;
                    case LiveActivity.PLAYMAIN_END /* 125 */:
                        liveActivity.isStartDetectFace = true;
                        break;
                    case LiveActivity.DETECT_READY /* 126 */:
                        removeMessages(LiveActivity.DETECT_READY);
                        if (liveActivity.isStartDetectFace && Builder.execLiveCount > 0) {
                            liveActivity.doNextStep();
                            break;
                        } else {
                            sendEmptyMessageDelayed(LiveActivity.DETECT_READY, 400L);
                            break;
                        }
                        break;
                    case 127:
                        liveActivity.showReadyInfo(((Integer) message.obj).intValue());
                        break;
                    default:
                        switch (i2) {
                            case 202:
                                Builder.liveDatas.put(Integer.valueOf(message.arg1), (byte[]) message.obj);
                                break;
                        }
                }
            } else {
                Integer num2 = (Integer) message.obj;
                if (num2.intValue() == 703) {
                    liveActivity.showTimeOutDialog();
                    return;
                }
                liveActivity.setFaceResult(false, 0.0d, "", num2.intValue(), null);
                if (Builder.mFrontDetectCallback != null && liveActivity.isDetectAttack(num2.intValue())) {
                    Builder.mFrontDetectCallback.onLivenessFail(num2.intValue());
                }
                if (Builder.mFrontLiveCallback != null && liveActivity.isDetectAttack(num2.intValue())) {
                    Builder.mFrontLiveCallback.onFrontLivessFinished(null, "", null, "", null, false);
                }
            }
            super.handleMessage(message);
        }
    }

    protected interface PermissionCallback {
        void onCall(boolean z);
    }

    static class TimerRunnable implements Runnable {
        private final int currentStreamID;
        private int djsCount;
        private boolean flag = true;
        private boolean isReadyStage;
        private final WeakReference<LiveActivity> mActivity;
        private final int oriCount;
        private final Map<String, Integer> poolMap;
        private final SoundPool sndPool;

        public TimerRunnable(int i2, LiveActivity liveActivity, SoundPool soundPool, Map<String, Integer> map, int i3, boolean z) {
            this.isReadyStage = false;
            this.isReadyStage = z;
            this.djsCount = i2;
            this.oriCount = i2;
            this.mActivity = new WeakReference<>(liveActivity);
            this.sndPool = soundPool;
            this.poolMap = map;
            this.currentStreamID = i3;
        }

        public boolean isFlag() {
            return this.flag;
        }

        @Override // java.lang.Runnable
        public void run() {
            LiveActivity liveActivity = this.mActivity.get();
            if (!this.flag || liveActivity == null) {
                return;
            }
            liveActivity.mMainHandler.obtainMessage(106, Integer.valueOf(this.djsCount)).sendToTarget();
            this.djsCount--;
            if (this.djsCount < 0) {
                CloudwalkSDK cloudwalkSDK = liveActivity.cloudwalkSDK;
                if (cloudwalkSDK != null) {
                    cloudwalkSDK.cwStopLivess();
                }
                liveActivity.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_OVERTIME)).sendToTarget();
                return;
            }
            liveActivity.mMainHandler.postDelayed(liveActivity.faceTimerRunnable, 1000L);
            if (Builder.timerCount < 7 || (this.oriCount / 2) - 1 != this.djsCount) {
                return;
            }
            if (this.currentStreamID == this.poolMap.get(Contants.POOL_MAP_MOUTH_OPEN).intValue()) {
                SoundPool soundPool = this.sndPool;
                if (soundPool == null || !Builder.playSound || this.isReadyStage) {
                    return;
                }
                liveActivity.currentPlaySoundId = soundPool.play(this.poolMap.get(Contants.POOL_MAP_MOUTH_OPEN_WIDTHLY).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
                return;
            }
            SoundPool soundPool2 = this.sndPool;
            if (soundPool2 == null || !Builder.playSound || this.isReadyStage) {
                return;
            }
            liveActivity.currentPlaySoundId = soundPool2.play(this.poolMap.get(Contants.POOL_MAP_TRY_AGAIN).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
        }

        public void setFlag(boolean z) {
            this.flag = z;
        }
    }

    static /* synthetic */ int access$1608(LiveActivity liveActivity) {
        int i2 = liveActivity.animIndex;
        liveActivity.animIndex = i2 + 1;
        return i2;
    }

    private void checkRuntimeEnvironment() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_SDK_INIT_TOO_LOW)).sendToTarget();
            return;
        }
        PermissionUtils.getInstance().checkPermissions(this, this.PERMISSIONS, this.mIPermissionsResult);
        String[] strArr = Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        if (strArr != null) {
            boolean z = false;
            for (String str : strArr) {
                String[] strArr2 = this.livenessAbis;
                int length = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (TextUtils.equals(str, strArr2[i2])) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    break;
                }
            }
            if (z) {
                return;
            }
            this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_NOT_SUPPORT_CPU_ARCH)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFaceSerLivess() {
        this.isLivePass = true;
        FrontLiveCallback frontLiveCallback = Builder.mFrontLiveCallback;
        Integer numValueOf = Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FACEDEC_OK);
        if (frontLiveCallback == null && Builder.mFrontDetectCallback == null) {
            this.mMainHandler.obtainMessage(122, numValueOf).sendToTarget();
            return;
        }
        if (Builder.antiHackMethod != 2 && !Builder.isServerLive) {
            this.mMainHandler.obtainMessage(122, numValueOf).sendToTarget();
            return;
        }
        this.localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Contants.ACTION_BROADCAST_SERVER_LIVE);
        this.liveServerBroadcastReceiver = new LiveServerBroadcastReceiver();
        this.localBroadcastManager.registerReceiver(this.liveServerBroadcastReceiver, intentFilter);
        this.tv_time_tips.setVisibility(8);
        this.img_tip.setVisibility(8);
        this.circle_mark.startAnim(0, 25);
        this.textSwitcher.setCurrentText("正在检测.  ");
        startTestingAnim();
        FrontLiveCallback frontLiveCallback2 = Builder.mFrontLiveCallback;
        if (frontLiveCallback2 != null) {
            frontLiveCallback2.onFrontLivessFinished(Builder.bestFaceData, Builder.bestInfo, Builder.nextFaceData, Builder.nextInfo, Builder.clipedBestFaceData, true);
        }
        FrontDetectCallback frontDetectCallback = Builder.mFrontDetectCallback;
        if (frontDetectCallback != null) {
            frontDetectCallback.onLivenessSuccess(Builder.bestFaceData, Builder.bestInfo, Builder.nextFaceData, Builder.nextInfo, Builder.clipedBestFaceData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFrontFaceLivess() {
        this.isLivePass = this.cloudwalkSDK.cwVerifyBestImg() == 0;
        if (Builder.mFrontLiveCallback == null && Builder.mFrontDetectCallback == null) {
            this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FACEDEC_OK)).sendToTarget();
            return;
        }
        if (Builder.antiHackMethod != 1 && !Builder.isFrontHack) {
            this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FACEDEC_OK)).sendToTarget();
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Contants.ACTION_BROADCAST_LIVE);
        this.liveBroadcastReceiver = new LiveBroadcastReceiver();
        this.localBroadcastManager = LocalBroadcastManager.getInstance(this);
        this.localBroadcastManager.registerReceiver(this.liveBroadcastReceiver, intentFilter);
        this.tv_time_tips.setVisibility(8);
        this.img_tip.setVisibility(8);
        this.circle_mark.startAnim(0, 25);
        this.textSwitcher.setCurrentText("正在检测.  ");
        startTestingAnim();
        FrontLiveCallback frontLiveCallback = Builder.mFrontLiveCallback;
        if (frontLiveCallback != null) {
            frontLiveCallback.onFrontLivessFinished(Builder.bestFaceData, Builder.bestInfo, Builder.nextFaceData, Builder.nextInfo, Builder.clipedBestFaceData, this.isLivePass);
        }
        FrontDetectCallback frontDetectCallback = Builder.mFrontDetectCallback;
        if (frontDetectCallback != null) {
            if (this.isLivePass) {
                frontDetectCallback.onLivenessSuccess(Builder.bestFaceData, Builder.bestInfo, Builder.nextFaceData, Builder.nextInfo, Builder.clipedBestFaceData);
            } else {
                frontDetectCallback.onLivenessFail(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FRONT_ATTACK_FAIL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNextStep() {
        int i2 = this.currentStep;
        int i3 = 500;
        if (i2 == 1) {
            this.mMainHandler.sendEmptyMessageDelayed(124, 250);
        } else if (this.totalStep == i2) {
            this.isLivePass = true;
            this.currentStreamID = this.poolMap.get("good").intValue();
            SoundPool soundPool = this.sndPool;
            if (soundPool != null && Builder.playSound) {
                this.currentPlaySoundId = soundPool.play(this.currentStreamID, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else {
            this.currentStreamID = this.poolMap.get("good").intValue();
            SoundPool soundPool2 = this.sndPool;
            if (soundPool2 != null && Builder.playSound) {
                this.currentPlaySoundId = soundPool2.play(this.currentStreamID, 1.0f, 1.0f, 0, 0, 1.0f);
            }
            this.mMainHandler.sendEmptyMessageDelayed(124, 500);
            i3 = 1000;
        }
        this.mMainHandler.sendEmptyMessageDelayed(101, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBestFace() {
        Builder.clipedBestFaceData = this.cloudwalkSDK.cwGetClipedBestFace();
        Builder.bestFaceData = this.cloudwalkSDK.cwGetOriBestFace();
        Builder.nextFaceData = this.cloudwalkSDK.cwGetNextFace();
        Builder.bestInfo = this.cloudwalkSDK.cwGetBestInfo();
        Builder.nextInfo = this.cloudwalkSDK.cwGetNextInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getExecLive() {
        boolean z;
        boolean z2;
        boolean z3;
        int i2 = Builder.execLiveCount;
        if (1 >= i2 || i2 > 4) {
            Collections.shuffle(Builder.totalLiveList);
            this.execLiveList = new CopyOnWriteArrayList(Builder.totalLiveList.subList(0, Builder.execLiveCount));
            return;
        }
        boolean z4 = Builder.totalLiveList.contains(1000) || Builder.totalLiveList.contains(1001);
        boolean z5 = Builder.totalLiveList.contains(1005) || Builder.totalLiveList.contains(1004);
        if (z4 && z5) {
            while (true) {
                while (!z3) {
                    Collections.shuffle(Builder.totalLiveList);
                    this.execLiveList = new CopyOnWriteArrayList(Builder.totalLiveList.subList(0, Builder.execLiveCount));
                    z3 = (this.execLiveList.contains(1000) || this.execLiveList.contains(1001)) && (this.execLiveList.contains(1005) || this.execLiveList.contains(1004));
                }
                return;
            }
        }
        if (z4) {
            while (true) {
                while (!z2) {
                    Collections.shuffle(Builder.totalLiveList);
                    this.execLiveList = new CopyOnWriteArrayList(Builder.totalLiveList.subList(0, Builder.execLiveCount));
                    z2 = this.execLiveList.contains(1000) || this.execLiveList.contains(1001);
                }
                return;
            }
        }
        if (!z5) {
            Collections.shuffle(Builder.totalLiveList);
            this.execLiveList = new CopyOnWriteArrayList(Builder.totalLiveList.subList(0, Builder.execLiveCount));
        } else {
            while (true) {
                while (!z) {
                    Collections.shuffle(Builder.totalLiveList);
                    this.execLiveList = new CopyOnWriteArrayList(Builder.totalLiveList.subList(0, Builder.execLiveCount));
                    z = this.execLiveList.contains(1005) || this.execLiveList.contains(1004);
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCallBack() {
        this.cloudwalkSDK.cwFaceInfoCallback(this);
        this.cloudwalkSDK.cwLivessInfoCallback(this);
        this.mPreview.setCWPreviewCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCloudwalkSDK() {
        this.cloudwalkSDK = new CloudwalkSDK();
        this.initRet = this.cloudwalkSDK.cwInit(this, Builder.licence);
        if (this.initRet == 0) {
            initLivenessParam();
        }
        boolean z = true;
        if (!TextUtils.isEmpty(Builder.logPath)) {
            this.cloudwalkSDK.setLogAndSaveImage(true, Builder.logPath, true);
        }
        InitializeCallBack initializeCallBack = Builder.mInitializeCallBack;
        if (initializeCallBack != null) {
            if (this.initRet == 0) {
                initializeCallBack.onInitializeSuccess();
            } else {
                z = false;
                initializeCallBack.onInitializeFail(new InitializeException(getString(R.string.init_detector_exception)));
            }
        }
        this.cloudwalkSDK.cwResetLivenessTarget();
        if (z || Builder.isResultPage) {
            return;
        }
        LiveStartActivity liveStartActivity = LiveStartActivity.activity;
        if (liveStartActivity != null) {
            liveStartActivity.finish();
        }
        finish();
    }

    private void initLivenessParam() {
        FaceParam faceParam = new FaceParam();
        try {
            this.cloudwalkSDK.cwGetParam(faceParam);
            faceParam.sunglass = true;
            faceParam.stable = true;
            faceParam.mask = true;
            faceParam.occlusion = true;
            this.cloudwalkSDK.cwsetParam(faceParam);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void initStepViews() {
        this.totalStep = 0;
        getExecLive();
        this.totalStep++;
        int size = this.execLiveList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.totalStep++;
        }
    }

    private void initView() throws Resources.NotFoundException {
        this.circle_view = (CircleView) findViewById(R.id.circle_view);
        this.tv_time_tips = (TextView) findViewById(R.id.tv_time_tips);
        this.textureView = (RoundTextureView) findViewById(R.id.texture_preview);
        this.textureView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.circle_mark = (CircleMarkView) findViewById(R.id.circle_mark);
        this.fl_content = (FrameLayout) findViewById(R.id.fl_content);
        this.mPreview = (CameraPreview) findViewById(R.id.preview);
        this.mPreview.setPreviewTexture(this.textureView);
        this.textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        this.textSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: cn.cloudwalk.libproject.LiveActivity.5
            @Override // android.widget.ViewSwitcher.ViewFactory
            public View makeView() {
                TextView textView = new TextView(LiveActivity.this);
                textView.setTextSize(2, 20.0f);
                textView.setTextColor(-1);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                textView.setGravity(17);
                textView.setSingleLine();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.leftMargin = 20;
                layoutParams.rightMargin = 20;
                textView.setLayoutParams(layoutParams);
                return textView;
            }
        });
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        this.textSwitcher.setInAnimation(animationLoadAnimation);
        this.textSwitcher.setOutAnimation(animationLoadAnimation2);
        this.img_tip = (ImageView) findViewById(R.id.img_tip);
        this.orientation = getResources().getConfiguration().orientation;
        this.mPreview.setScreenOrientation(this.orientation);
        if (CameraUtil.isHasCamera(1)) {
            this.caremaId = 1;
            this.mPreview.setCaremaId(this.caremaId);
        } else {
            this.caremaId = 0;
            this.mPreview.setCaremaId(this.caremaId);
        }
        initStepViews();
    }

    private void initViewListener() {
        this.screenListener = new ScreenListener(getApplicationContext());
        this.screenListener.begin(new ScreenListener.ScreenStateListener() { // from class: cn.cloudwalk.libproject.LiveActivity.6
            @Override // cn.cloudwalk.libproject.util.ScreenListener.ScreenStateListener
            public void onScreenOff() {
                LogUtils.LOGI(LiveActivity.this.TAG, "onScreenOff...");
                LiveActivity.this.lockScreen = true;
            }

            @Override // cn.cloudwalk.libproject.util.ScreenListener.ScreenStateListener
            public void onScreenOn() {
                LogUtils.LOGI(LiveActivity.this.TAG, "onScreenOn...");
            }

            @Override // cn.cloudwalk.libproject.util.ScreenListener.ScreenStateListener
            public void onUserPresent() {
                if (LiveActivity.this.lockScreen) {
                    LiveActivity.this.finish();
                    LogUtils.LOGI(LiveActivity.this.TAG, "onUserPresent2...");
                    LiveActivity.this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_LOCK_AND_TOBACK)).sendToTarget();
                }
            }
        });
        findViewById(R.id.img_cancle).setOnClickListener(new View.OnClickListener() { // from class: cn.cloudwalk.libproject.LiveActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrontDetectCallback frontDetectCallback = Builder.mFrontDetectCallback;
                if (frontDetectCallback != null) {
                    frontDetectCallback.onLivenessCancel();
                }
                LiveActivity.this.finish();
            }
        });
    }

    private void playDetectSound(int i2) {
        SoundPool soundPool = this.sndPool;
        if (soundPool != null && Builder.playSound) {
            soundPool.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        this.mMainHandler.postDelayed(this.mDetectSoundRunnable, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playMain() {
        if (this.isPlayMain && this.isLoadmain) {
            this.isPlayMain = false;
            this.currentStreamID = 1;
            SoundPool soundPool = this.sndPool;
            if (soundPool != null && Builder.playSound && this.foreground) {
                this.currentPlaySoundId = soundPool.play(this.currentStreamID, 1.0f, 1.0f, 0, 0, 1.0f);
            }
            this.mMainHandler.sendEmptyMessageDelayed(PLAYMAIN_END, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFaceLiveResult(int i2, int i3) {
        boolean z = false;
        if (i3 == 10 && i2 == 1) {
            z = true;
        }
        this.circle_mark.stopAmin(true);
        this.mMainHandler.removeCallbacksAndMessages(null);
        if (this.isSetResult || this.isStop) {
            return;
        }
        this.isSetResult = true;
        if (!Builder.isResultPage) {
            LiveStartActivity liveStartActivity = LiveStartActivity.activity;
            if (liveStartActivity != null) {
                liveStartActivity.finish();
            }
        } else if (z) {
            Intent intent = new Intent(this, (Class<?>) LivenessSucessActivity.class);
            intent.putExtra(Contants.SERVER_HACK_RESULT, z);
            startActivity(intent);
        } else {
            startActivity(new Intent(this, (Class<?>) LivenessFailActivity.class));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showReadyInfo(int i2) {
        if (i2 == 15) {
            this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_glass));
        }
        if (i2 == 16) {
            this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_face_shield));
            return;
        }
        switch (i2) {
            case 0:
                this.circle_mark.setTipMsg("");
                break;
            case 1:
                this.circle_mark.setTipMsg("");
                break;
            case 2:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_too_far));
                break;
            case 3:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_too_close));
                break;
            case 4:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_not_frontal));
                break;
            case 5:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_not_stable));
                break;
            case 6:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_too_dark));
                break;
            case 7:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_too_bright));
                break;
            case 8:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_not_frontal));
                break;
            case 9:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_not_frontal));
                break;
            case 10:
                this.circle_mark.setTipMsg(getResources().getString(R.string.cloudwalk_tip_face_shield));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTimeOutDialog() {
        if (this.mTimeOutdialog == null) {
            this.mTimeOutdialog = new LivenessTimeOutDialog(this);
        }
        this.mTimeOutdialog.setOnDialogClickListener(new OnDialogClickListener() { // from class: cn.cloudwalk.libproject.LiveActivity.4
            @Override // cn.cloudwalk.libproject.dialog.OnDialogClickListener
            public void onDialogClick(Dialog dialog, int i2) {
                if (i2 == R.id.tv_again) {
                    LiveActivity.this.mTimeOutdialog.dismiss();
                    LiveActivity.this.cloudwalkSDK.cwResetLivenessTarget();
                    LiveActivity.this.getExecLive();
                    LiveActivity.this.resetLive();
                    return;
                }
                if (i2 == R.id.tv_cancle) {
                    LiveActivity.this.mTimeOutdialog.dismiss();
                    FrontDetectCallback frontDetectCallback = Builder.mFrontDetectCallback;
                    if (frontDetectCallback != null) {
                        frontDetectCallback.onLivenessFail(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_OVERTIME);
                    }
                    FrontLiveCallback frontLiveCallback = Builder.mFrontLiveCallback;
                    if (frontLiveCallback != null) {
                        frontLiveCallback.onFrontLivessFinished(null, "", null, "", null, false);
                    }
                    LiveActivity.this.finish();
                }
            }
        });
        this.mTimeOutdialog.show(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLivessDetect(int i2) {
        this.currentLivessType = i2;
        if (i2 == 1000) {
            this.currentStreamID = this.poolMap.get("head_left").intValue();
            playDetectSound(this.currentStreamID);
            return;
        }
        if (i2 == 1001) {
            this.currentStreamID = this.poolMap.get("head_right").intValue();
            playDetectSound(this.currentStreamID);
        } else if (i2 == 1004) {
            this.currentStreamID = this.poolMap.get("eye_blink").intValue();
            playDetectSound(this.currentStreamID);
        } else {
            if (i2 != 1005) {
                return;
            }
            this.currentStreamID = this.poolMap.get(Contants.POOL_MAP_MOUTH_OPEN).intValue();
            playDetectSound(this.currentStreamID);
        }
    }

    private void startTestingAnim() {
        if (this.animTimer == null) {
            this.animTimer = new Timer();
        }
        this.animTimer.schedule(new TimerTask() { // from class: cn.cloudwalk.libproject.LiveActivity.10
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LiveActivity.this.runOnUiThread(new Runnable() { // from class: cn.cloudwalk.libproject.LiveActivity.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiveActivity.this.animIndex >= 99) {
                            LiveActivity.this.animIndex = 0;
                        }
                        if (LiveActivity.this.animIndex % 3 == 0) {
                            LiveActivity.this.textSwitcher.setCurrentText("正在检测.  ");
                        } else if (LiveActivity.this.animIndex % 3 == 1) {
                            LiveActivity.this.textSwitcher.setCurrentText("正在检测.. ");
                        } else {
                            LiveActivity.this.textSwitcher.setCurrentText("正在检测...");
                        }
                        LiveActivity.access$1608(LiveActivity.this);
                    }
                });
            }
        }, 0L, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimerRunnable(int i2, boolean z) {
        this.faceTimerRunnable = new TimerRunnable(i2, this, this.sndPool, this.poolMap, this.currentStreamID, z);
        this.mMainHandler.postDelayed(this.faceTimerRunnable, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStepLayout(int i2) {
        this.circle_mark.stopAmin(true);
        this.img_tip.setVisibility(0);
        this.circle_mark.startAnim(1, 25);
        if (i2 == 1000) {
            this.textSwitcher.setText(getResources().getString(R.string.cloudwalk_live_headleft));
            this.img_tip.setImageResource(R.drawable.cloudwalk_head_left);
            this.animationDrawable = (AnimationDrawable) this.img_tip.getDrawable();
        } else if (i2 == 1001) {
            this.textSwitcher.setText(getResources().getString(R.string.cloudwalk_live_headright));
            this.img_tip.setImageResource(R.drawable.cloudwalk_head_right);
            this.animationDrawable = (AnimationDrawable) this.img_tip.getDrawable();
        } else if (i2 == 1004) {
            this.textSwitcher.setText(getResources().getString(R.string.cloudwalk_live_eye));
            this.img_tip.setImageResource(R.drawable.cloudwalk_eye_blink);
            this.animationDrawable = (AnimationDrawable) this.img_tip.getDrawable();
        } else if (i2 != 1005) {
            this.animationDrawable = null;
        } else {
            this.textSwitcher.setText(getResources().getString(R.string.cloudwalk_live_mouth));
            this.img_tip.setImageResource(R.drawable.cloudwalk_open_mouth);
            this.animationDrawable = (AnimationDrawable) this.img_tip.getDrawable();
        }
        AnimationDrawable animationDrawable = this.animationDrawable;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void checkLockOrBack() {
        if (this.foreground) {
            return;
        }
        this.foreground = true;
        if (this.lockScreen) {
            return;
        }
        LogUtils.LOGI(this.TAG, "checkLockOrBack...");
        this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_LOCK_AND_TOBACK)).sendToTarget();
        finish();
    }

    public void circleMarkAnim() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.circle_mark, "scaleX", 0.0f, 1.0f).setDuration(1000L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.circle_mark, "scaleY", 0.0f, 1.0f).setDuration(1000L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.circle_mark, "rotation", 0.0f, 360.0f).setDuration(2000L);
        duration3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.cloudwalk.libproject.LiveActivity.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveActivity.this.circle_view.setInnerRadius(((((Float) valueAnimator.getAnimatedValue()).floatValue() / 360.0f) * LiveActivity.this.circle_view.getWidth()) / 2.0f);
            }
        });
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(duration).with(duration2).with(duration3);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: cn.cloudwalk.libproject.LiveActivity.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LiveActivity.this.isStartAnimEnd = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveActivity.this.isStartAnimEnd = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    @Override // cn.cloudwalk.callback.FaceInfoCallback
    public void detectFaceInfo(FaceInfo[] faceInfoArr, int i2) {
    }

    @Override // cn.cloudwalk.callback.LivessCallBack
    public void detectFinished() {
    }

    @Override // cn.cloudwalk.callback.LivessCallBack
    public void detectInfo(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.isStartAnimEnd || this.preLivessCode == i2 || jCurrentTimeMillis - this.mLastPrepareInfoTime < 500) {
            return;
        }
        this.mLastPrepareInfoTime = jCurrentTimeMillis;
        this.preLivessCode = i2;
        showReadyInfo(i2);
    }

    @Override // cn.cloudwalk.callback.LivessCallBack
    public void detectLivess(int i2, byte[] bArr) {
        this.cloudwalkSDK.cwStopLivess();
        stopTimerRunnable();
        if (Builder.isLivesPicReturn) {
            Message messageObtainMessage = this.mMainHandler.obtainMessage();
            messageObtainMessage.what = 202;
            messageObtainMessage.arg1 = i2;
            messageObtainMessage.obj = bArr;
            this.mMainHandler.sendMessage(messageObtainMessage);
        }
        if (this.isSetResult || this.isStop) {
            return;
        }
        switch (i2) {
            case 600:
            case FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_BLINK /* 601 */:
            case FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADPITCH /* 602 */:
            case FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADDOWN /* 603 */:
            case FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADLEFT /* 604 */:
            case FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADRIGHT /* 605 */:
                synchronized (LiveActivity.class) {
                    this.currentStep++;
                }
                doNextStep();
                return;
            default:
                return;
        }
    }

    @Override // cn.cloudwalk.callback.LivessCallBack
    public void detectReady() {
        stopTimerRunnable();
        synchronized (LiveActivity.class) {
            this.currentStep++;
        }
        this.cloudwalkSDK.cwStopLivess();
        if (this.isStartDetectFace) {
            doNextStep();
        } else {
            this.mMainHandler.sendEmptyMessageDelayed(DETECT_READY, 400L);
        }
    }

    public void initSoundPool(Context context) {
        this.poolMap = new HashMap();
        this.sndPool = new SoundPool(1, 3, 100);
        this.sndPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: cn.cloudwalk.libproject.LiveActivity.3
            @Override // android.media.SoundPool.OnLoadCompleteListener
            public void onLoadComplete(SoundPool soundPool, int i2, int i3) {
                if (1 == i2) {
                    LiveActivity liveActivity = LiveActivity.this;
                    liveActivity.isLoadmain = true;
                    liveActivity.playMain();
                }
            }
        });
        this.poolMap.put("main", Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_main, 1)));
        this.poolMap.put(Contants.POOL_MAP_MOUTH_OPEN, Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_live_mouth, 1)));
        this.poolMap.put("head_up", Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_live_top, 1)));
        this.poolMap.put("head_down", Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_live_down, 1)));
        this.poolMap.put("head_left", Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_live_left, 1)));
        this.poolMap.put("head_right", Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_live_right, 1)));
        this.poolMap.put("eye_blink", Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_live_eye, 1)));
        this.poolMap.put("good", Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_good, 1)));
        this.poolMap.put(Contants.POOL_MAP_TRY_AGAIN, Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_again, 1)));
        this.poolMap.put(Contants.POOL_MAP_MOUTH_OPEN_WIDTHLY, Integer.valueOf(this.sndPool.load(context, R.raw.cloudwalk_open_widely, 1)));
    }

    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService("activity");
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public boolean isDetectAttack(int i2) {
        return i2 == 700 || i2 == 701 || i2 == 702 || i2 == 703 || i2 == 704 || i2 == 75003901 || i2 == 75003903 || i2 == 75003904 || i2 == 75003905 || i2 == 75003906 || i2 == 75003907 || i2 == 75003908;
    }

    @Override // cn.cloudwalk.callback.LivessCallBack
    public void onActionNotStandard(int i2) {
        if (this.currentStep == 0 || this.isLivePass) {
            return;
        }
        CloudwalkSDK cloudwalkSDK = this.cloudwalkSDK;
        if (cloudwalkSDK != null) {
            cloudwalkSDK.cwStopLivess();
        }
        this.mMainHandler.obtainMessage(122, Integer.valueOf(i2)).sendToTarget();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        PermissionUtils.getInstance().onActivityResult(i2, this, this.PERMISSIONS, this.mIPermissionsResult);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        FrontDetectCallback frontDetectCallback = Builder.mFrontDetectCallback;
        if (frontDetectCallback != null) {
            frontDetectCallback.onLivenessCancel();
        }
        finish();
    }

    @Override // cn.cloudwalk.libproject.camera.CameraPreview.CWPreviewCallback
    public void onCWPreviewFrame(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        this.cloudwalkSDK.cwPushFrame(bArr, i2, i3, i4, i5, i6);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i2 = configuration.orientation;
    }

    @Override // cn.cloudwalk.libproject.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.cloudwalk_activity_liveness);
        setTitle(R.string.cloudwalk_live_title);
        this.mMainHandler = new MainHandler(this);
        initView();
        initViewListener();
        checkRuntimeEnvironment();
        this.mDetectSoundRunnable = new DetectSoundRunnable(this);
    }

    @Override // cn.cloudwalk.libproject.BaseActivity, android.app.Activity
    protected void onDestroy() throws InterruptedException {
        super.onDestroy();
        this.circle_mark.stopAmin(true);
        Timer timer = this.animTimer;
        if (timer != null) {
            timer.cancel();
            this.animTimer = null;
        }
        this.mPreview.setCWPreviewCallback(null);
        this.mMainHandler.removeCallbacksAndMessages(null);
        CloudwalkSDK cloudwalkSDK = this.cloudwalkSDK;
        if (cloudwalkSDK != null) {
            cloudwalkSDK.cwDestory();
        }
        releaseSoundPool();
        LivenessTimeOutDialog livenessTimeOutDialog = this.mTimeOutdialog;
        if (livenessTimeOutDialog != null) {
            livenessTimeOutDialog.dismiss();
        }
        LocalBroadcastManager localBroadcastManager = this.localBroadcastManager;
        if (localBroadcastManager != null) {
            LiveBroadcastReceiver liveBroadcastReceiver = this.liveBroadcastReceiver;
            if (liveBroadcastReceiver != null) {
                localBroadcastManager.unregisterReceiver(liveBroadcastReceiver);
            }
            LiveServerBroadcastReceiver liveServerBroadcastReceiver = this.liveServerBroadcastReceiver;
            if (liveServerBroadcastReceiver != null) {
                this.localBroadcastManager.unregisterReceiver(liveServerBroadcastReceiver);
            }
        }
        ScreenListener screenListener = this.screenListener;
        if (screenListener != null) {
            screenListener.unregisterListener();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.textureView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ViewGroup.LayoutParams layoutParams = this.textureView.getLayoutParams();
        int iMin = (Math.min(this.textureView.getWidth(), this.textureView.getHeight()) * 3) / 5;
        layoutParams.width = iMin;
        layoutParams.height = iMin;
        this.textureView.setLayoutParams(layoutParams);
        this.textureView.turnRound();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        FrontDetectCallback frontDetectCallback;
        if (i2 == 4 && (frontDetectCallback = Builder.mFrontDetectCallback) != null) {
            frontDetectCallback.onLivenessCancel();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        PermissionUtils.getInstance().onRequestPermissionsResult(this, i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() throws IOException {
        super.onResume();
        this.isStop = false;
        getExecLive();
        if (this.mIsHasPermission) {
            resetLive();
        }
        this.mPreview.cwStartCamera();
        checkLockOrBack();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mPreview.cwStopCamera();
        stopTimerRunnable();
        stopDetectSoundRunable();
        PermissionUtils.getInstance().cancelPermissionDialog();
        this.isStop = true;
        this.mMainHandler.removeCallbacksAndMessages(null);
        SoundPool soundPool = this.sndPool;
        if (soundPool != null) {
            soundPool.stop(this.currentPlaySoundId);
        }
        if (isAppOnForeground()) {
            return;
        }
        this.foreground = false;
    }

    public void releaseSoundPool() {
        SoundPool soundPool = this.sndPool;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(null);
            this.sndPool.release();
            this.sndPool = null;
        }
    }

    void resetLive() {
        this.mMainHandler.removeCallbacksAndMessages(null);
        this.isPlayMain = true;
        Builder.bestFaceData = null;
        Builder.clipedBestFaceData = null;
        if (Builder.isLivesPicReturn) {
            Builder.liveDatas = new HashMap<>();
        }
        this.isLivePass = false;
        playMain();
        this.isSetResult = false;
        synchronized (LiveActivity.class) {
            this.currentStep = 0;
        }
        this.img_tip.setVisibility(8);
        this.isStartDetectFace = false;
        this.textSwitcher.setCurrentText(getResources().getString(R.string.cloudwalk_tip_not_center));
        this.circle_mark.setTipMsg("");
        int i2 = this.initRet;
        if (i2 == 0) {
            startTimerRunnable(Builder.timerCount, true);
            this.cloudwalkSDK.setActionCount(Builder.execLiveCount);
            this.cloudwalkSDK.cwClearBestFace();
            this.cloudwalkSDK.setWorkType(CloudwalkSDK.DetectType.LIVE_DETECT);
            this.cloudwalkSDK.setStageflag(1);
            this.cloudwalkSDK.setPushFrame(true);
            return;
        }
        if (i2 == 20007) {
            this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_AUTH_ERROR)).sendToTarget();
            return;
        }
        if (i2 == 20009 || i2 == 20010 || i2 == 20011 || i2 == 20012) {
            this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_MODEL_ERROR)).sendToTarget();
        } else {
            this.mMainHandler.obtainMessage(122, Integer.valueOf(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_DEFAULT_ERROR)).sendToTarget();
        }
    }

    public void setFaceResult(int i2, double d2, String str, String str2) {
        boolean z;
        int i3;
        if (5 == i2) {
            z = true;
            i3 = 5;
        } else if (6 == i2) {
            z = false;
            i3 = 6;
        } else {
            z = false;
            i3 = 7;
        }
        this.circle_mark.stopAmin(true);
        setFaceResult(z, d2, str, i3, str2);
    }

    void stopDetectSoundRunable() {
        DetectSoundRunnable detectSoundRunnable = this.mDetectSoundRunnable;
        if (detectSoundRunnable != null) {
            detectSoundRunnable.setFlag(false);
        }
    }

    void stopTimerRunnable() {
        TimerRunnable timerRunnable = this.faceTimerRunnable;
        if (timerRunnable != null) {
            timerRunnable.setFlag(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFaceResult(boolean z, double d2, String str, int i2, String str2) {
        this.mMainHandler.removeCallbacksAndMessages(null);
        if (this.isSetResult || this.isStop) {
            return;
        }
        this.isSetResult = true;
        if (Builder.isResultPage) {
            if (this.isLivePass && z) {
                Intent intent = new Intent(this, (Class<?>) LivenessSucessActivity.class);
                intent.putExtra(Contants.FACEDECT_RESULT_TYPE, i2);
                if (NullUtils.isNotEmpty(str2).booleanValue()) {
                    intent.putExtra(Contants.FACEDECT_RESULT_MSG, str2);
                }
                intent.putExtra(Contants.ISLIVEPASS, this.isLivePass);
                intent.putExtra(Contants.ISVERFYPASS, z);
                intent.putExtra(Contants.FACESCORE, d2);
                intent.putExtra(Contants.SESSIONID, str);
                startActivity(intent);
                finish();
                return;
            }
            startActivity(new Intent(this, (Class<?>) LivenessFailActivity.class));
            finish();
            return;
        }
        ResultCallBack resultCallBack = Builder.mResultCallBack;
        if (resultCallBack != null) {
            resultCallBack.result(this.isLivePass, z, str, d2, i2, Builder.bestFaceData, Builder.clipedBestFaceData, Builder.liveDatas);
        }
        LiveStartActivity liveStartActivity = LiveStartActivity.activity;
        if (liveStartActivity != null) {
            liveStartActivity.finish();
        }
        finish();
    }
}
