package cn.cloudwalk.libproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.cloudwalk.libproject.callback.DefineRecognizeCallBack;
import cn.cloudwalk.libproject.callback.FrontDetectCallback;
import cn.cloudwalk.libproject.callback.FrontLiveCallback;
import cn.cloudwalk.libproject.callback.InitializeCallBack;
import cn.cloudwalk.libproject.callback.ResultCallBack;
import cn.cloudwalk.libproject.net.ServerConfig;
import cn.cloudwalk.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Builder {
    public static final int BESTFACE_FAIL = 8;
    public static final String FACE_DETECT_ACTIVITY = "LiveActivity";
    public static final int FACE_LIVE_FAIL = 9;
    public static final int FACE_LIVE_PASS = 10;
    public static final int FACE_VERFY_FAIL = 6;
    public static final int FACE_VERFY_NETFAIL = 7;
    public static final int FACE_VERFY_PASS = 5;
    public static final String GUIDE_PAGE_ACTIVITY = "LiveStartActivity";
    private static final String SDK_VERSION = "通用动作活体新UIV5.0.1.20201218";
    public static int antiHackMethod;
    public static byte[] bestFaceData;
    public static String bestInfo;
    public static byte[] clipedBestFaceData;
    public static DefineRecognizeCallBack dfvCallBack;
    public static int execLiveCount;
    public static boolean isFrontHack;
    public static boolean isLivesPicReturn;

    @Deprecated
    public static boolean isLivesRandom;
    public static boolean isResultPage;
    public static boolean isServerDet;
    public static boolean isServerLive;
    public static HashMap<Integer, byte[]> liveDatas;

    @Deprecated
    public static int liveLevel;
    public static FrontDetectCallback mFrontDetectCallback;

    @Deprecated
    public static FrontLiveCallback mFrontLiveCallback;
    public static InitializeCallBack mInitializeCallBack;
    public static ResultCallBack mResultCallBack;
    public static byte[] nextFaceData;
    public static String nextInfo;
    public static String publicFilePath;
    public static ServerConfig serverConfig;
    public static Class startCls;
    public static ArrayList<Integer> totalLiveList = new ArrayList<>();
    static String logPath = "";
    public static boolean playSound = true;
    public static int timerCount = 8;
    private static boolean enterGuidePage = true;
    public static String licence = "";
    public static String authorites = "";
    public static long mBestFacedelayTime = 3000;

    public static String getSdkVersion() {
        return SDK_VERSION;
    }

    public Builder isFrontHack(boolean z) {
        isFrontHack = z;
        return this;
    }

    public Builder isResultPage(boolean z) {
        isResultPage = z;
        return this;
    }

    public Boolean isServerDet(boolean z) {
        return Boolean.valueOf(z);
    }

    public Builder isServerLive(boolean z) {
        isServerLive = z;
        return this;
    }

    public Builder setAntiHackMethod(int i2) {
        antiHackMethod = i2;
        return this;
    }

    public Builder setAuthorites(String str) {
        authorites = str;
        return this;
    }

    @Deprecated
    public Builder setBestFaceDelay(long j2) {
        mBestFacedelayTime = j2;
        return this;
    }

    public Builder setEnterGuidePage(boolean z) {
        enterGuidePage = z;
        return this;
    }

    public void setFaceLiveResult(Context context, int i2, int i3) {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        Intent intent = new Intent(Contants.ACTION_BROADCAST_SERVER_LIVE);
        intent.putExtra("result", i2);
        intent.putExtra("extInfo", i3);
        localBroadcastManager.sendBroadcast(intent);
    }

    public void setFaceResult(Context context, int i2, double d2, String str, String str2) {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        Intent intent = new Intent(Contants.ACTION_BROADCAST_LIVE);
        intent.putExtra("isFaceComparePass", i2);
        intent.putExtra("faceCompareScore", d2);
        intent.putExtra("faceCompareSessionId", str);
        intent.putExtra("faceCompareTipMsg", str2);
        localBroadcastManager.sendBroadcast(intent);
    }

    @Deprecated
    public Builder setFaceVerify(DefineRecognizeCallBack defineRecognizeCallBack) {
        dfvCallBack = defineRecognizeCallBack;
        return this;
    }

    public Builder setFrontDetectCallback(FrontDetectCallback frontDetectCallback) {
        mFrontDetectCallback = frontDetectCallback;
        return this;
    }

    @Deprecated
    public Builder setFrontLiveFace(FrontLiveCallback frontLiveCallback) {
        mFrontLiveCallback = frontLiveCallback;
        return this;
    }

    public Builder setInitializeCallBack(InitializeCallBack initializeCallBack) {
        mInitializeCallBack = initializeCallBack;
        return this;
    }

    public Builder setLicence(String str) {
        licence = str;
        return this;
    }

    public Builder setLiveCount(int i2) {
        execLiveCount = i2;
        return this;
    }

    public Builder setLiveList(ArrayList<Integer> arrayList) {
        totalLiveList.clear();
        totalLiveList.addAll(arrayList);
        return this;
    }

    public Builder setLiveTime(int i2) {
        timerCount = i2;
        return this;
    }

    public Builder setLives(ArrayList<Integer> arrayList, int i2, boolean z, boolean z2, int i3) {
        totalLiveList.clear();
        totalLiveList.addAll(arrayList);
        execLiveCount = i2;
        isLivesRandom = z;
        isLivesPicReturn = z2;
        if (z2) {
            liveDatas = new HashMap<>();
        }
        liveLevel = i3;
        return this;
    }

    public Builder setLivesPicReturn(boolean z) {
        isLivesPicReturn = z;
        if (z) {
            liveDatas = new HashMap<>();
        }
        return this;
    }

    public Builder setLogImagePath(String str) {
        logPath = str;
        return this;
    }

    public Builder setPlaySound(boolean z) {
        playSound = z;
        return this;
    }

    public Builder setPublicFilePath(String str) {
        publicFilePath = str;
        return this;
    }

    public Builder setResultCallBack(ResultCallBack resultCallBack) {
        mResultCallBack = resultCallBack;
        return this;
    }

    public Builder setResultPage(boolean z) {
        isResultPage = z;
        return this;
    }

    public Builder setServerConfig(ServerConfig serverConfig2) {
        serverConfig = serverConfig2;
        return this;
    }

    public void startActivity(Activity activity, Class cls) {
        LogUtils.LOGI("tag", cls.getSimpleName());
        if (GUIDE_PAGE_ACTIVITY.equals(cls.getSimpleName()) && !enterGuidePage) {
            cls = LiveActivity.class;
        }
        startCls = cls;
        activity.startActivity(new Intent(activity, (Class<?>) cls));
    }
}
