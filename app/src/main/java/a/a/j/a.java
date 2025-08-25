package a.a.j;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: Taobao */
    /* renamed from: a.a.j.a$a, reason: collision with other inner class name */
    public static class C0001a implements Serializable {
        public byte[] data;
        public String etag;
        public long lastModified;
        public Map<String, List<String>> responseHeaders = Collections.EMPTY_MAP;
        public long serverDate;
        public long ttl;

        public boolean isFresh() {
            return System.currentTimeMillis() <= this.ttl;
        }
    }

    void clear();

    C0001a get(String str);

    void put(String str, C0001a c0001a);

    void remove(String str);
}
