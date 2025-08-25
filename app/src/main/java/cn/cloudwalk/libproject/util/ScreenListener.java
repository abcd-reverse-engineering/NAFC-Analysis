package cn.cloudwalk.libproject.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

/* loaded from: classes.dex */
public class ScreenListener {
    private Context mContext;
    private ScreenBroadcastReceiver mScreenReceiver = new ScreenBroadcastReceiver();
    private ScreenStateListener mScreenStateListener;

    private class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action;

        private ScreenBroadcastReceiver() {
            this.action = null;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.action = intent.getAction();
            if ("android.intent.action.SCREEN_ON".equals(this.action)) {
                ScreenListener.this.mScreenStateListener.onScreenOn();
            } else if ("android.intent.action.SCREEN_OFF".equals(this.action)) {
                ScreenListener.this.mScreenStateListener.onScreenOff();
            } else if ("android.intent.action.USER_PRESENT".equals(this.action)) {
                ScreenListener.this.mScreenStateListener.onUserPresent();
            }
        }
    }

    public interface ScreenStateListener {
        void onScreenOff();

        void onScreenOn();

        void onUserPresent();
    }

    public ScreenListener(Context context) {
        this.mContext = context;
    }

    private void getScreenState() {
        if (((PowerManager) this.mContext.getSystemService("power")).isScreenOn()) {
            ScreenStateListener screenStateListener = this.mScreenStateListener;
            if (screenStateListener != null) {
                screenStateListener.onScreenOn();
                return;
            }
            return;
        }
        ScreenStateListener screenStateListener2 = this.mScreenStateListener;
        if (screenStateListener2 != null) {
            screenStateListener2.onScreenOff();
        }
    }

    private void registerListener() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.mContext.registerReceiver(this.mScreenReceiver, intentFilter);
    }

    public void begin(ScreenStateListener screenStateListener) {
        this.mScreenStateListener = screenStateListener;
        registerListener();
        getScreenState();
    }

    public void unregisterListener() {
        this.mContext.unregisterReceiver(this.mScreenReceiver);
    }
}
