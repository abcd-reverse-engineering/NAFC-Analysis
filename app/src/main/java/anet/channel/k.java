package anet.channel;

import anet.channel.util.HttpConstant;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class k implements a.a.j.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f1801a;

    k(j jVar) {
        this.f1801a = jVar;
    }

    @Override // a.a.j.c
    public boolean handleCache(String str, Map<String, String> map) {
        return "weex".equals(map.get(HttpConstant.F_REFER));
    }
}
