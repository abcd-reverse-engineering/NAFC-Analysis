package h.m2;

import androidx.exifinterface.media.ExifInterface;
import h.e1;
import h.n0;
import h.q2.t.i0;
import h.t0;
import h.z2.c0;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final k f16311a;

    static {
        k kVar;
        int iA = a();
        if (iA >= 65544) {
            try {
                Object objNewInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                i0.a(objNewInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (objNewInstance == null) {
                        throw new e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    kVar = (k) objNewInstance;
                } catch (ClassCastException e2) {
                    Throwable thInitCause = new ClassCastException("Instance classloader: " + objNewInstance.getClass().getClassLoader() + ", base type classloader: " + k.class.getClassLoader()).initCause(e2);
                    i0.a((Object) thInitCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw thInitCause;
                }
            } catch (ClassNotFoundException unused) {
                try {
                    Object objNewInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    i0.a(objNewInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (objNewInstance2 == null) {
                            throw new e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        kVar = (k) objNewInstance2;
                    } catch (ClassCastException e3) {
                        Throwable thInitCause2 = new ClassCastException("Instance classloader: " + objNewInstance2.getClass().getClassLoader() + ", base type classloader: " + k.class.getClassLoader()).initCause(e3);
                        i0.a((Object) thInitCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw thInitCause2;
                    }
                } catch (ClassNotFoundException unused2) {
                }
            }
        } else if (iA >= 65543) {
            try {
                Object objNewInstance3 = Class.forName("h.m2.r.a").newInstance();
                i0.a(objNewInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (objNewInstance3 == null) {
                        throw new e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    kVar = (k) objNewInstance3;
                } catch (ClassCastException e4) {
                    Throwable thInitCause3 = new ClassCastException("Instance classloader: " + objNewInstance3.getClass().getClassLoader() + ", base type classloader: " + k.class.getClassLoader()).initCause(e4);
                    i0.a((Object) thInitCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw thInitCause3;
                }
            } catch (ClassNotFoundException unused3) {
                try {
                    Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    i0.a(objNewInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (objNewInstance4 == null) {
                            throw new e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        kVar = (k) objNewInstance4;
                    } catch (ClassCastException e5) {
                        Throwable thInitCause4 = new ClassCastException("Instance classloader: " + objNewInstance4.getClass().getClassLoader() + ", base type classloader: " + k.class.getClassLoader()).initCause(e5);
                        i0.a((Object) thInitCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw thInitCause4;
                    }
                } catch (ClassNotFoundException unused4) {
                }
            }
        } else {
            kVar = new k();
        }
        f16311a = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    private static final /* synthetic */ <T> T a(Object obj) throws Throwable {
        try {
            i0.a(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        } catch (ClassCastException e2) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            i0.a(4, ExifInterface.GPS_DIRECTION_TRUE);
            Throwable thInitCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + Object.class.getClassLoader()).initCause(e2);
            i0.a((Object) thInitCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw thInitCause;
        }
    }

    private static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int iA = c0.a((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (iA < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i2 = iA + 1;
        int iA2 = c0.a((CharSequence) property, '.', i2, false, 4, (Object) null);
        if (iA2 < 0) {
            iA2 = property.length();
        }
        if (property != null) {
            String strSubstring = property.substring(0, iA);
            i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (property != null) {
                String strSubstring2 = property.substring(i2, iA2);
                i0.a((Object) strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                try {
                    return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
                } catch (NumberFormatException unused2) {
                    return 65542;
                }
            }
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @t0(version = "1.2")
    @n0
    public static final boolean a(int i2, int i3, int i4) {
        return h.q.f16363f.a(i2, i3, i4);
    }
}
