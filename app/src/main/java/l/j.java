package l;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: ParameterHandler.java */
/* loaded from: classes2.dex */
abstract class j<T> {

    /* compiled from: ParameterHandler.java */
    class a extends j<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // l.j
        public void a(l.l lVar, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                j.this.a(lVar, it.next());
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    class b extends j<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // l.j
        void a(l.l lVar, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                j.this.a(lVar, Array.get(obj, i2));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class c<T> extends j<T> {

        /* renamed from: a, reason: collision with root package name */
        private final l.e<T, RequestBody> f17118a;

        c(l.e<T, RequestBody> eVar) {
            this.f17118a = eVar;
        }

        @Override // l.j
        void a(l.l lVar, @Nullable T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                lVar.a(this.f17118a.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class d<T> extends j<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f17119a;

        /* renamed from: b, reason: collision with root package name */
        private final l.e<T, String> f17120b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f17121c;

        d(String str, l.e<T, String> eVar, boolean z) {
            this.f17119a = (String) p.a(str, "name == null");
            this.f17120b = eVar;
            this.f17121c = z;
        }

        @Override // l.j
        void a(l.l lVar, @Nullable T t) throws IOException {
            String strA;
            if (t == null || (strA = this.f17120b.a(t)) == null) {
                return;
            }
            lVar.a(this.f17119a, strA, this.f17121c);
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class e<T> extends j<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final l.e<T, String> f17122a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f17123b;

        e(l.e<T, String> eVar, boolean z) {
            this.f17122a = eVar;
            this.f17123b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // l.j
        public void a(l.l lVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                String strA = this.f17122a.a(value);
                if (strA == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f17122a.getClass().getName() + " for key '" + key + "'.");
                }
                lVar.a(key, strA, this.f17123b);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class f<T> extends j<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f17124a;

        /* renamed from: b, reason: collision with root package name */
        private final l.e<T, String> f17125b;

        f(String str, l.e<T, String> eVar) {
            this.f17124a = (String) p.a(str, "name == null");
            this.f17125b = eVar;
        }

        @Override // l.j
        void a(l.l lVar, @Nullable T t) throws IOException {
            String strA;
            if (t == null || (strA = this.f17125b.a(t)) == null) {
                return;
            }
            lVar.a(this.f17124a, strA);
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class g<T> extends j<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final l.e<T, String> f17126a;

        g(l.e<T, String> eVar) {
            this.f17126a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // l.j
        public void a(l.l lVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                }
                lVar.a(key, this.f17126a.a(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class h<T> extends j<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Headers f17127a;

        /* renamed from: b, reason: collision with root package name */
        private final l.e<T, RequestBody> f17128b;

        h(Headers headers, l.e<T, RequestBody> eVar) {
            this.f17127a = headers;
            this.f17128b = eVar;
        }

        @Override // l.j
        void a(l.l lVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                lVar.a(this.f17127a, this.f17128b.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class i<T> extends j<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final l.e<T, RequestBody> f17129a;

        /* renamed from: b, reason: collision with root package name */
        private final String f17130b;

        i(l.e<T, RequestBody> eVar, String str) {
            this.f17129a = eVar;
            this.f17130b = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // l.j
        public void a(l.l lVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                lVar.a(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f17130b), this.f17129a.a(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$j, reason: collision with other inner class name */
    static final class C0271j<T> extends j<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f17131a;

        /* renamed from: b, reason: collision with root package name */
        private final l.e<T, String> f17132b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f17133c;

        C0271j(String str, l.e<T, String> eVar, boolean z) {
            this.f17131a = (String) p.a(str, "name == null");
            this.f17132b = eVar;
            this.f17133c = z;
        }

        @Override // l.j
        void a(l.l lVar, @Nullable T t) throws IOException {
            if (t != null) {
                lVar.b(this.f17131a, this.f17132b.a(t), this.f17133c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.f17131a + "\" value must not be null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class k<T> extends j<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f17134a;

        /* renamed from: b, reason: collision with root package name */
        private final l.e<T, String> f17135b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f17136c;

        k(String str, l.e<T, String> eVar, boolean z) {
            this.f17134a = (String) p.a(str, "name == null");
            this.f17135b = eVar;
            this.f17136c = z;
        }

        @Override // l.j
        void a(l.l lVar, @Nullable T t) throws IOException {
            String strA;
            if (t == null || (strA = this.f17135b.a(t)) == null) {
                return;
            }
            lVar.c(this.f17134a, strA, this.f17136c);
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class l<T> extends j<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final l.e<T, String> f17137a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f17138b;

        l(l.e<T, String> eVar, boolean z) {
            this.f17137a = eVar;
            this.f17138b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // l.j
        public void a(l.l lVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                String strA = this.f17137a.a(value);
                if (strA == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f17137a.getClass().getName() + " for key '" + key + "'.");
                }
                lVar.c(key, strA, this.f17138b);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class m<T> extends j<T> {

        /* renamed from: a, reason: collision with root package name */
        private final l.e<T, String> f17139a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f17140b;

        m(l.e<T, String> eVar, boolean z) {
            this.f17139a = eVar;
            this.f17140b = z;
        }

        @Override // l.j
        void a(l.l lVar, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            lVar.c(this.f17139a.a(t), null, this.f17140b);
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class n extends j<MultipartBody.Part> {

        /* renamed from: a, reason: collision with root package name */
        static final n f17141a = new n();

        private n() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // l.j
        public void a(l.l lVar, @Nullable MultipartBody.Part part) {
            if (part != null) {
                lVar.a(part);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    static final class o extends j<Object> {
        o() {
        }

        @Override // l.j
        void a(l.l lVar, @Nullable Object obj) {
            p.a(obj, "@Url parameter is null.");
            lVar.a(obj);
        }
    }

    j() {
    }

    final j<Object> a() {
        return new b();
    }

    abstract void a(l.l lVar, @Nullable T t) throws IOException;

    final j<Iterable<T>> b() {
        return new a();
    }
}
