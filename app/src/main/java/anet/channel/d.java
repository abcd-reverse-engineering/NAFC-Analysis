package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class d implements IAmdcSign {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1696a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ISecurity f1697b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionCenter f1698c;

    d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.f1698c = sessionCenter;
        this.f1696a = str;
        this.f1697b = iSecurity;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String getAppkey() {
        return this.f1696a;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String sign(String str) {
        return this.f1697b.sign(this.f1698c.f1637b, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public boolean useSecurityGuard() {
        return !this.f1697b.isSecOff();
    }
}
