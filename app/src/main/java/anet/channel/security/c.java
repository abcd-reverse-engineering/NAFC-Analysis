package anet.channel.security;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ISecurityFactory f1877a;

    public static ISecurityFactory a() {
        if (f1877a == null) {
            f1877a = new d();
        }
        return f1877a;
    }
}
