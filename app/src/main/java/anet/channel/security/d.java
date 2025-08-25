package anet.channel.security;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class d implements ISecurityFactory {
    d() {
    }

    @Override // anet.channel.security.ISecurityFactory
    public ISecurity createNonSecurity(String str) {
        return new a(str);
    }

    @Override // anet.channel.security.ISecurityFactory
    public ISecurity createSecurity(String str) {
        return new b(str);
    }
}
