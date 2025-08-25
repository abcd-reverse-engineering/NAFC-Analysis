package h.q2.t;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassReference.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001KB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010B\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010J\u001a\u00020-H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u001e\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u0004\u0018\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u0002060\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u000bR \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010>8VX\u0097\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010A¨\u0006L"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", RemoteMessageConst.Notification.VISIBILITY, "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", DispatchConstants.OTHER, "error", "", "hashCode", "", "isInstance", SurveyH5Bean.VALUE, "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class t implements h.w2.c<Object>, s {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends h.m<?>>, Integer> f16439b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f16440c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f16441d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap<String, String> f16442e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, String> f16443f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f16444g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final Class<?> f16445a;

    /* compiled from: ClassReference.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.e
        public final String a(@i.c.a.d Class<?> cls) {
            String str;
            i0.f(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) t.f16442e.get(cls.getName());
                return str3 != null ? str3 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            i0.a((Object) componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) t.f16442e.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 != null ? str2 : "kotlin.Array";
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
        @i.c.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String b(@i.c.a.d java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                h.q2.t.i0.f(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L11
            Le:
                r1 = r2
                goto Lc2
            L11:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L73
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r1 = r8.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L43
                h.q2.t.i0.a(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = r1.getName()
                r6.append(r1)
                r6.append(r3)
                java.lang.String r1 = r6.toString()
                java.lang.String r1 = h.z2.s.b(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L43
                goto L66
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L65
                h.q2.t.i0.a(r0, r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r8 = r8.getName()
                r1.append(r8)
                r1.append(r3)
                java.lang.String r8 = r1.toString()
                java.lang.String r8 = h.z2.s.b(r0, r8, r2, r4, r2)
                r1 = r8
                goto L66
            L65:
                r1 = r2
            L66:
                if (r1 == 0) goto L69
                goto Lc2
            L69:
                h.q2.t.i0.a(r0, r5)
                r8 = 36
                java.lang.String r1 = h.z2.s.a(r0, r8, r2, r4, r2)
                goto Lc2
            L73:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto Lac
                java.lang.Class r8 = r8.getComponentType()
                java.lang.String r0 = "componentType"
                h.q2.t.i0.a(r8, r0)
                boolean r0 = r8.isPrimitive()
                if (r0 == 0) goto La8
                java.util.Map r0 = h.q2.t.t.p()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto La8
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r1)
                java.lang.String r8 = r0.toString()
                r2 = r8
            La8:
                if (r2 == 0) goto Lc2
                goto Le
            Lac:
                java.util.Map r0 = h.q2.t.t.p()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto Lbe
                goto Lc2
            Lbe:
                java.lang.String r1 = r8.getSimpleName()
            Lc2:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: h.q2.t.t.a.b(java.lang.Class):java.lang.String");
        }

        public /* synthetic */ a(v vVar) {
            this();
        }

        public final boolean a(@i.c.a.e Object obj, @i.c.a.d Class<?> cls) {
            i0.f(cls, "jClass");
            Map map = t.f16439b;
            if (map == null) {
                throw new h.e1("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            }
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return n1.b(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = h.q2.a.b(h.q2.a.a((Class) cls));
            }
            return cls.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i2 = 0;
        List listC = h.g2.y.c(h.q2.s.a.class, h.q2.s.l.class, h.q2.s.p.class, h.q2.s.q.class, h.q2.s.r.class, h.q2.s.s.class, h.q2.s.t.class, h.q2.s.u.class, h.q2.s.v.class, h.q2.s.w.class, h.q2.s.b.class, h.q2.s.c.class, h.q2.s.d.class, h.q2.s.e.class, h.q2.s.f.class, h.q2.s.g.class, h.q2.s.h.class, h.q2.s.i.class, h.q2.s.j.class, h.q2.s.k.class, h.q2.s.m.class, h.q2.s.n.class, h.q2.s.o.class);
        ArrayList arrayList = new ArrayList(h.g2.z.a(listC, 10));
        for (Object obj : listC) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                h.g2.y.f();
            }
            arrayList.add(h.c1.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f16439b = h.g2.c1.a(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f16440c = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f16441d = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(f16440c);
        map3.putAll(f16441d);
        Collection<String> collectionValues = f16440c.values();
        i0.a((Object) collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            i0.a((Object) str, "kotlinName");
            sb.append(h.z2.c0.b(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            h.i0 i0VarA = h.c1.a(sb.toString(), str + ".Companion");
            map3.put(i0VarA.getFirst(), i0VarA.getSecond());
        }
        for (Map.Entry<Class<? extends h.m<?>>, Integer> entry : f16439b.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f16442e = map3;
        HashMap<String, String> map4 = f16442e;
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.g2.b1.b(map4.size()));
        Iterator<T> it = map4.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            linkedHashMap.put(entry2.getKey(), h.z2.c0.b((String) entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
        f16443f = linkedHashMap;
    }

    public t(@i.c.a.d Class<?> cls) {
        i0.f(cls, "jClass");
        this.f16445a = cls;
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void A() {
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void B() {
    }

    private final Void q() {
        throw new h.q2.l();
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void r() {
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void s() {
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void t() {
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void u() {
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void v() {
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void w() {
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void x() {
    }

    @h.t0(version = "1.3")
    public static /* synthetic */ void y() {
    }

    @h.t0(version = "1.1")
    public static /* synthetic */ void z() {
    }

    @Override // h.w2.c, h.w2.f
    @i.c.a.d
    public Collection<h.w2.b<?>> a() {
        q();
        throw null;
    }

    @Override // h.w2.c
    @i.c.a.e
    public String b() {
        return f16444g.a(m());
    }

    @Override // h.w2.c
    @i.c.a.d
    public Collection<h.w2.c<?>> c() {
        q();
        throw null;
    }

    @Override // h.w2.c
    @i.c.a.d
    public Collection<h.w2.g<Object>> d() {
        q();
        throw null;
    }

    @Override // h.w2.c
    @i.c.a.d
    public List<h.w2.c<? extends Object>> e() {
        q();
        throw null;
    }

    @Override // h.w2.c
    public boolean equals(@i.c.a.e Object obj) {
        return (obj instanceof t) && i0.a(h.q2.a.b(this), h.q2.a.b((h.w2.c) obj));
    }

    @Override // h.w2.c
    public boolean f() {
        q();
        throw null;
    }

    @Override // h.w2.c
    @i.c.a.e
    public String g() {
        return f16444g.b(m());
    }

    @Override // h.w2.a
    @i.c.a.d
    public List<Annotation> getAnnotations() {
        q();
        throw null;
    }

    @Override // h.w2.c
    @i.c.a.d
    public List<h.w2.r> getTypeParameters() {
        q();
        throw null;
    }

    @Override // h.w2.c
    @i.c.a.e
    public h.w2.u getVisibility() {
        q();
        throw null;
    }

    @Override // h.w2.c
    @i.c.a.d
    public List<h.w2.q> h() {
        q();
        throw null;
    }

    @Override // h.w2.c
    public int hashCode() {
        return h.q2.a.b(this).hashCode();
    }

    @Override // h.w2.c
    @i.c.a.e
    public Object i() {
        q();
        throw null;
    }

    @Override // h.w2.c
    public boolean isAbstract() {
        q();
        throw null;
    }

    @Override // h.w2.c
    public boolean isFinal() {
        q();
        throw null;
    }

    @Override // h.w2.c
    public boolean isOpen() {
        q();
        throw null;
    }

    @Override // h.w2.c
    public boolean j() {
        q();
        throw null;
    }

    @Override // h.w2.c
    public boolean k() {
        q();
        throw null;
    }

    @Override // h.w2.c
    public boolean l() {
        q();
        throw null;
    }

    @Override // h.q2.t.s
    @i.c.a.d
    public Class<?> m() {
        return this.f16445a;
    }

    @i.c.a.d
    public String toString() {
        return m().toString() + " (Kotlin reflection is not available)";
    }

    @Override // h.w2.c
    @h.t0(version = "1.1")
    public boolean a(@i.c.a.e Object obj) {
        return f16444g.a(obj, m());
    }
}
