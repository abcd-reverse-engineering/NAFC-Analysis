package i.a.a.a.m.k;

import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/* compiled from: Languages.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final String f16811b = "any";

    /* renamed from: c, reason: collision with root package name */
    private static final Map<i.a.a.a.m.k.d, c> f16812c = new EnumMap(i.a.a.a.m.k.d.class);

    /* renamed from: d, reason: collision with root package name */
    public static final AbstractC0254c f16813d;

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC0254c f16814e;

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f16815a;

    /* compiled from: Languages.java */
    static class a extends AbstractC0254c {
        a() {
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public AbstractC0254c a(AbstractC0254c abstractC0254c) {
            return this;
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public String a() {
            throw new NoSuchElementException("Can't fetch any language from the empty language set.");
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean a(String str) {
            return false;
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean b() {
            return true;
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean c() {
            return false;
        }

        public String toString() {
            return "NO_LANGUAGES";
        }
    }

    /* compiled from: Languages.java */
    static class b extends AbstractC0254c {
        b() {
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public AbstractC0254c a(AbstractC0254c abstractC0254c) {
            return abstractC0254c;
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public String a() {
            throw new NoSuchElementException("Can't fetch any language from the any language set.");
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean a(String str) {
            return true;
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean b() {
            return false;
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean c() {
            return false;
        }

        public String toString() {
            return "ANY_LANGUAGE";
        }
    }

    /* compiled from: Languages.java */
    /* renamed from: i.a.a.a.m.k.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0254c {
        public static AbstractC0254c a(Set<String> set) {
            return set.isEmpty() ? c.f16813d : new d(set, null);
        }

        public abstract AbstractC0254c a(AbstractC0254c abstractC0254c);

        public abstract String a();

        public abstract boolean a(String str);

        public abstract boolean b();

        public abstract boolean c();
    }

    /* compiled from: Languages.java */
    public static final class d extends AbstractC0254c {

        /* renamed from: a, reason: collision with root package name */
        private final Set<String> f16816a;

        /* synthetic */ d(Set set, a aVar) {
            this(set);
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean a(String str) {
            return this.f16816a.contains(str);
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean b() {
            return this.f16816a.isEmpty();
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public boolean c() {
            return this.f16816a.size() == 1;
        }

        public Set<String> d() {
            return this.f16816a;
        }

        public String toString() {
            return "Languages(" + this.f16816a.toString() + ")";
        }

        private d(Set<String> set) {
            this.f16816a = Collections.unmodifiableSet(set);
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public String a() {
            return this.f16816a.iterator().next();
        }

        @Override // i.a.a.a.m.k.c.AbstractC0254c
        public AbstractC0254c a(AbstractC0254c abstractC0254c) {
            if (abstractC0254c == c.f16813d) {
                return abstractC0254c;
            }
            if (abstractC0254c == c.f16814e) {
                return this;
            }
            d dVar = (d) abstractC0254c;
            if (dVar.f16816a.containsAll(this.f16816a)) {
                return this;
            }
            HashSet hashSet = new HashSet(this.f16816a);
            hashSet.retainAll(dVar.f16816a);
            return AbstractC0254c.a(hashSet);
        }
    }

    static {
        for (i.a.a.a.m.k.d dVar : i.a.a.a.m.k.d.values()) {
            f16812c.put(dVar, a(b(dVar)));
        }
        f16813d = new a();
        f16814e = new b();
    }

    private c(Set<String> set) {
        this.f16815a = set;
    }

    public static c a(i.a.a.a.m.k.d dVar) {
        return f16812c.get(dVar);
    }

    private static String b(i.a.a.a.m.k.d dVar) {
        return String.format("org/apache/commons/codec/language/bm/%s_languages.txt", dVar.getName());
    }

    public static c a(String str) {
        HashSet hashSet = new HashSet();
        InputStream resourceAsStream = c.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalArgumentException("Unable to resolve required resource: " + str);
        }
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                String strTrim = scanner.nextLine().trim();
                if (z) {
                    if (strTrim.endsWith("*/")) {
                        break;
                    }
                } else if (strTrim.startsWith("/*")) {
                    z = true;
                } else if (strTrim.length() > 0) {
                    hashSet.add(strTrim);
                }
            }
            return new c(Collections.unmodifiableSet(hashSet));
        }
    }

    public Set<String> a() {
        return this.f16815a;
    }
}
