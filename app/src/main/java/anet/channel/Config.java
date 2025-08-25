package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.umeng.analytics.pro.at;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class Config {

    /* renamed from: b, reason: collision with root package name */
    private String f1600b;

    /* renamed from: c, reason: collision with root package name */
    private String f1601c;

    /* renamed from: d, reason: collision with root package name */
    private ENV f1602d = ENV.ONLINE;

    /* renamed from: e, reason: collision with root package name */
    private ISecurity f1603e;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Config> f1599a = new HashMap();
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();

    /* compiled from: Taobao */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f1604a;

        /* renamed from: b, reason: collision with root package name */
        private String f1605b;

        /* renamed from: c, reason: collision with root package name */
        private ENV f1606c = ENV.ONLINE;

        /* renamed from: d, reason: collision with root package name */
        private String f1607d;

        /* renamed from: e, reason: collision with root package name */
        private String f1608e;

        public Config build() {
            if (TextUtils.isEmpty(this.f1605b)) {
                throw new RuntimeException("appkey can not be null or empty!");
            }
            synchronized (Config.f1599a) {
                for (Config config : Config.f1599a.values()) {
                    if (config.f1602d == this.f1606c && config.f1601c.equals(this.f1605b)) {
                        ALog.w("awcn.Config", "duplicated config exist!", null, "appkey", this.f1605b, at.f10067a, this.f1606c);
                        if (!TextUtils.isEmpty(this.f1604a)) {
                            Config.f1599a.put(this.f1604a, config);
                        }
                        return config;
                    }
                }
                Config config2 = new Config();
                config2.f1601c = this.f1605b;
                config2.f1602d = this.f1606c;
                if (TextUtils.isEmpty(this.f1604a)) {
                    config2.f1600b = StringUtils.concatString(this.f1605b, "$", this.f1606c.toString());
                } else {
                    config2.f1600b = this.f1604a;
                }
                if (TextUtils.isEmpty(this.f1608e)) {
                    config2.f1603e = anet.channel.security.c.a().createSecurity(this.f1607d);
                } else {
                    config2.f1603e = anet.channel.security.c.a().createNonSecurity(this.f1608e);
                }
                synchronized (Config.f1599a) {
                    Config.f1599a.put(config2.f1600b, config2);
                }
                return config2;
            }
        }

        public Builder setAppSecret(String str) {
            this.f1608e = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.f1605b = str;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.f1607d = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.f1606c = env;
            return this;
        }

        public Builder setTag(String str) {
            this.f1604a = str;
            return this;
        }
    }

    protected Config() {
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (f1599a) {
            for (Config config : f1599a.values()) {
                if (config.f1602d == env && config.f1601c.equals(str)) {
                    return config;
                }
            }
            return null;
        }
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (f1599a) {
            config = f1599a.get(str);
        }
        return config;
    }

    public String getAppkey() {
        return this.f1601c;
    }

    public ENV getEnv() {
        return this.f1602d;
    }

    public ISecurity getSecurity() {
        return this.f1603e;
    }

    public String getTag() {
        return this.f1600b;
    }

    public String toString() {
        return this.f1600b;
    }
}
