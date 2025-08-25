package com.alibaba.sdk.android.beacon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class Beacon {

    /* renamed from: a, reason: collision with root package name */
    private final b f3993a;

    private final class BeaconHandler extends Handler {
        BeaconHandler(Looper looper) {
            super(looper);
        }
    }

    public static final class Builder {
        String mAppKey;
        String mAppSecret;
        Map<String, String> mExtras = new HashMap();
        long mLoopInterval = 300000;

        public Builder appKey(String str) {
            this.mAppKey = str.trim();
            return this;
        }

        public Builder appSecret(String str) {
            this.mAppSecret = str.trim();
            return this;
        }

        public Beacon build() {
            return new Beacon(this);
        }

        public Builder extras(Map<String, String> map) {
            this.mExtras.putAll(map);
            return this;
        }

        public Builder loopInterval(long j2) {
            if (j2 < com.heytap.mcssdk.constant.a.f5800d) {
                this.mLoopInterval = com.heytap.mcssdk.constant.a.f5800d;
            } else {
                this.mLoopInterval = j2;
            }
            return this;
        }
    }

    public static final class Config {
        public final String key;
        public final String value;

        public Config(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public static final class Error {
        public final String errCode;
        public final String errMsg;

        Error(String str, String str2) {
            this.errCode = str;
            this.errMsg = str2;
        }
    }

    public interface OnServiceErrListener {
        void onErr(Error error);
    }

    public interface OnUpdateListener {
        void onUpdate(List<Config> list);
    }

    private Beacon(Builder builder) {
        this.f3993a = new b(this);
    }

    public static final void setPrepare(boolean z) {
        a.f3994a = z;
    }

    public void addServiceErrListener(OnServiceErrListener onServiceErrListener) {
    }

    public void addUpdateListener(OnUpdateListener onUpdateListener) {
    }

    public List<Config> getConfigs() {
        return this.f3993a.a();
    }

    public void start(Context context) {
    }

    public void stop() {
    }
}
