package a.a.r;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class c extends LinkedHashMap<String, String> {
    final /* synthetic */ d this$0;

    c(d dVar) {
        this.this$0 = dVar;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
        return size() > 100;
    }
}
