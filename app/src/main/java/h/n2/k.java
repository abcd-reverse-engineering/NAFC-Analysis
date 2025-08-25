package h.n2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.e2;
import h.q2.t.i0;
import h.y;
import h.y1;
import h.z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;

/* compiled from: FileTreeWalk.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class k implements h.x2.m<File> {

    /* renamed from: a, reason: collision with root package name */
    private final File f16331a;

    /* renamed from: b, reason: collision with root package name */
    private final m f16332b;

    /* renamed from: c, reason: collision with root package name */
    private final h.q2.s.l<File, Boolean> f16333c;

    /* renamed from: d, reason: collision with root package name */
    private final h.q2.s.l<File, y1> f16334d;

    /* renamed from: e, reason: collision with root package name */
    private final h.q2.s.p<File, IOException, y1> f16335e;

    /* renamed from: f, reason: collision with root package name */
    private final int f16336f;

    /* compiled from: FileTreeWalk.kt */
    private static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@i.c.a.d File file) {
            super(file);
            i0.f(file, "rootDir");
            if (e2.f16096a) {
                boolean zIsDirectory = file.isDirectory();
                if (e2.f16096a && !zIsDirectory) {
                    throw new AssertionError("rootDir must be verified to be directory beforehand.");
                }
            }
        }
    }

    /* compiled from: FileTreeWalk.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    private final class b extends h.g2.c<File> {

        /* renamed from: c, reason: collision with root package name */
        private final ArrayDeque<c> f16337c = new ArrayDeque<>();

        /* compiled from: FileTreeWalk.kt */
        private final class a extends a {

            /* renamed from: b, reason: collision with root package name */
            private boolean f16339b;

            /* renamed from: c, reason: collision with root package name */
            private File[] f16340c;

            /* renamed from: d, reason: collision with root package name */
            private int f16341d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f16342e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f16343f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@i.c.a.d b bVar, File file) {
                super(file);
                i0.f(file, "rootDir");
                this.f16343f = bVar;
            }

            @Override // h.n2.k.c
            @i.c.a.e
            public File b() {
                if (!this.f16342e && this.f16340c == null) {
                    h.q2.s.l lVar = k.this.f16333c;
                    if (lVar != null && !((Boolean) lVar.invoke(a())).booleanValue()) {
                        return null;
                    }
                    this.f16340c = a().listFiles();
                    if (this.f16340c == null) {
                        h.q2.s.p pVar = k.this.f16335e;
                        if (pVar != null) {
                        }
                        this.f16342e = true;
                    }
                }
                File[] fileArr = this.f16340c;
                if (fileArr != null) {
                    int i2 = this.f16341d;
                    if (fileArr == null) {
                        i0.f();
                    }
                    if (i2 < fileArr.length) {
                        File[] fileArr2 = this.f16340c;
                        if (fileArr2 == null) {
                            i0.f();
                        }
                        int i3 = this.f16341d;
                        this.f16341d = i3 + 1;
                        return fileArr2[i3];
                    }
                }
                if (!this.f16339b) {
                    this.f16339b = true;
                    return a();
                }
                h.q2.s.l lVar2 = k.this.f16334d;
                if (lVar2 != null) {
                }
                return null;
            }
        }

        /* compiled from: FileTreeWalk.kt */
        /* renamed from: h.n2.k$b$b, reason: collision with other inner class name */
        private final class C0247b extends c {

            /* renamed from: b, reason: collision with root package name */
            private boolean f16344b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f16345c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0247b(@i.c.a.d b bVar, File file) {
                super(file);
                i0.f(file, "rootFile");
                this.f16345c = bVar;
                if (e2.f16096a) {
                    boolean zIsFile = file.isFile();
                    if (e2.f16096a && !zIsFile) {
                        throw new AssertionError("rootFile must be verified to be file beforehand.");
                    }
                }
            }

            @Override // h.n2.k.c
            @i.c.a.e
            public File b() {
                if (this.f16344b) {
                    return null;
                }
                this.f16344b = true;
                return a();
            }
        }

        /* compiled from: FileTreeWalk.kt */
        private final class c extends a {

            /* renamed from: b, reason: collision with root package name */
            private boolean f16346b;

            /* renamed from: c, reason: collision with root package name */
            private File[] f16347c;

            /* renamed from: d, reason: collision with root package name */
            private int f16348d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f16349e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@i.c.a.d b bVar, File file) {
                super(file);
                i0.f(file, "rootDir");
                this.f16349e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
            
                if (r0.length == 0) goto L36;
             */
            @Override // h.n2.k.c
            @i.c.a.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f16346b
                    r1 = 0
                    if (r0 != 0) goto L28
                    h.n2.k$b r0 = r10.f16349e
                    h.n2.k r0 = h.n2.k.this
                    h.q2.s.l r0 = h.n2.k.c(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r10.a()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r10.f16346b = r0
                    java.io.File r0 = r10.a()
                    return r0
                L28:
                    java.io.File[] r0 = r10.f16347c
                    if (r0 == 0) goto L4c
                    int r2 = r10.f16348d
                    if (r0 != 0) goto L33
                    h.q2.t.i0.f()
                L33:
                    int r0 = r0.length
                    if (r2 >= r0) goto L37
                    goto L4c
                L37:
                    h.n2.k$b r0 = r10.f16349e
                    h.n2.k r0 = h.n2.k.this
                    h.q2.s.l r0 = h.n2.k.e(r0)
                    if (r0 == 0) goto L4b
                    java.io.File r2 = r10.a()
                    java.lang.Object r0 = r0.invoke(r2)
                    h.y1 r0 = (h.y1) r0
                L4b:
                    return r1
                L4c:
                    java.io.File[] r0 = r10.f16347c
                    if (r0 != 0) goto La2
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f16347c = r0
                    java.io.File[] r0 = r10.f16347c
                    if (r0 != 0) goto L81
                    h.n2.k$b r0 = r10.f16349e
                    h.n2.k r0 = h.n2.k.this
                    h.q2.s.p r0 = h.n2.k.d(r0)
                    if (r0 == 0) goto L81
                    java.io.File r2 = r10.a()
                    h.n2.a r9 = new h.n2.a
                    java.io.File r4 = r10.a()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    java.lang.Object r0 = r0.invoke(r2, r9)
                    h.y1 r0 = (h.y1) r0
                L81:
                    java.io.File[] r0 = r10.f16347c
                    if (r0 == 0) goto L8d
                    if (r0 != 0) goto L8a
                    h.q2.t.i0.f()
                L8a:
                    int r0 = r0.length
                    if (r0 != 0) goto La2
                L8d:
                    h.n2.k$b r0 = r10.f16349e
                    h.n2.k r0 = h.n2.k.this
                    h.q2.s.l r0 = h.n2.k.e(r0)
                    if (r0 == 0) goto La1
                    java.io.File r2 = r10.a()
                    java.lang.Object r0 = r0.invoke(r2)
                    h.y1 r0 = (h.y1) r0
                La1:
                    return r1
                La2:
                    java.io.File[] r0 = r10.f16347c
                    if (r0 != 0) goto La9
                    h.q2.t.i0.f()
                La9:
                    int r1 = r10.f16348d
                    int r2 = r1 + 1
                    r10.f16348d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: h.n2.k.b.c.b():java.io.File");
            }
        }

        public b() {
            if (k.this.f16331a.isDirectory()) {
                this.f16337c.push(a(k.this.f16331a));
            } else if (k.this.f16331a.isFile()) {
                this.f16337c.push(new C0247b(this, k.this.f16331a));
            } else {
                c();
            }
        }

        private final a a(File file) {
            int i2 = l.f16351a[k.this.f16332b.ordinal()];
            if (i2 == 1) {
                return new c(this, file);
            }
            if (i2 == 2) {
                return new a(this, file);
            }
            throw new z();
        }

        private final File d() {
            File fileB;
            while (true) {
                c cVarPeek = this.f16337c.peek();
                if (cVarPeek == null) {
                    return null;
                }
                fileB = cVarPeek.b();
                if (fileB == null) {
                    this.f16337c.pop();
                } else {
                    if (i0.a(fileB, cVarPeek.a()) || !fileB.isDirectory() || this.f16337c.size() >= k.this.f16336f) {
                        break;
                    }
                    this.f16337c.push(a(fileB));
                }
            }
            return fileB;
        }

        @Override // h.g2.c
        protected void b() {
            File fileD = d();
            if (fileD != null) {
                b(fileD);
            } else {
                c();
            }
        }
    }

    /* compiled from: FileTreeWalk.kt */
    private static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final File f16350a;

        public c(@i.c.a.d File file) {
            i0.f(file, "root");
            this.f16350a = file;
        }

        @i.c.a.d
        public final File a() {
            return this.f16350a;
        }

        @i.c.a.e
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k(File file, m mVar, h.q2.s.l<? super File, Boolean> lVar, h.q2.s.l<? super File, y1> lVar2, h.q2.s.p<? super File, ? super IOException, y1> pVar, int i2) {
        this.f16331a = file;
        this.f16332b = mVar;
        this.f16333c = lVar;
        this.f16334d = lVar2;
        this.f16335e = pVar;
        this.f16336f = i2;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<File> iterator() {
        return new b();
    }

    /* synthetic */ k(File file, m mVar, h.q2.s.l lVar, h.q2.s.l lVar2, h.q2.s.p pVar, int i2, int i3, h.q2.t.v vVar) {
        this(file, (i3 & 2) != 0 ? m.TOP_DOWN : mVar, lVar, lVar2, pVar, (i3 & 32) != 0 ? Integer.MAX_VALUE : i2);
    }

    @i.c.a.d
    public final k a(@i.c.a.d h.q2.s.l<? super File, Boolean> lVar) {
        i0.f(lVar, "function");
        return new k(this.f16331a, this.f16332b, lVar, this.f16334d, this.f16335e, this.f16336f);
    }

    @i.c.a.d
    public final k b(@i.c.a.d h.q2.s.l<? super File, y1> lVar) {
        i0.f(lVar, "function");
        return new k(this.f16331a, this.f16332b, this.f16333c, lVar, this.f16335e, this.f16336f);
    }

    @i.c.a.d
    public final k c(int i2) {
        if (i2 > 0) {
            return new k(this.f16331a, this.f16332b, this.f16333c, this.f16334d, this.f16335e, i2);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i2 + '.');
    }

    @i.c.a.d
    public final k a(@i.c.a.d h.q2.s.p<? super File, ? super IOException, y1> pVar) {
        i0.f(pVar, "function");
        return new k(this.f16331a, this.f16332b, this.f16333c, this.f16334d, pVar, this.f16336f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(@i.c.a.d File file, @i.c.a.d m mVar) {
        this(file, mVar, null, null, null, 0, 32, null);
        i0.f(file, "start");
        i0.f(mVar, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
    }

    public /* synthetic */ k(File file, m mVar, int i2, h.q2.t.v vVar) {
        this(file, (i2 & 2) != 0 ? m.TOP_DOWN : mVar);
    }
}
