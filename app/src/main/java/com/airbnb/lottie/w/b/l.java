package com.airbnb.lottie.w.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.y.k.h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class l implements n, j {

    /* renamed from: d, reason: collision with root package name */
    private final String f3692d;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.y.k.h f3694f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f3689a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Path f3690b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f3691c = new Path();

    /* renamed from: e, reason: collision with root package name */
    private final List<n> f3693e = new ArrayList();

    /* compiled from: MergePathsContent.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3695a = new int[h.a.values().length];

        static {
            try {
                f3695a[h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3695a[h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3695a[h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3695a[h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3695a[h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(com.airbnb.lottie.y.k.h hVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f3692d = hVar.b();
        this.f3694f = hVar;
    }

    @Override // com.airbnb.lottie.w.b.j
    public void a(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof n) {
                this.f3693e.add((n) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3692d;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        this.f3691c.reset();
        if (this.f3694f.c()) {
            return this.f3691c;
        }
        int i2 = a.f3695a[this.f3694f.a().ordinal()];
        if (i2 == 1) {
            a();
        } else if (i2 == 2) {
            a(Path.Op.UNION);
        } else if (i2 == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            a(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            a(Path.Op.XOR);
        }
        return this.f3691c;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < this.f3693e.size(); i2++) {
            this.f3693e.get(i2).a(list, list2);
        }
    }

    private void a() {
        for (int i2 = 0; i2 < this.f3693e.size(); i2++) {
            this.f3691c.addPath(this.f3693e.get(i2).getPath());
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f3690b.reset();
        this.f3689a.reset();
        for (int size = this.f3693e.size() - 1; size >= 1; size--) {
            n nVar = this.f3693e.get(size);
            if (nVar instanceof d) {
                d dVar = (d) nVar;
                List<n> listB = dVar.b();
                for (int size2 = listB.size() - 1; size2 >= 0; size2--) {
                    Path path = listB.get(size2).getPath();
                    path.transform(dVar.c());
                    this.f3690b.addPath(path);
                }
            } else {
                this.f3690b.addPath(nVar.getPath());
            }
        }
        n nVar2 = this.f3693e.get(0);
        if (nVar2 instanceof d) {
            d dVar2 = (d) nVar2;
            List<n> listB2 = dVar2.b();
            for (int i2 = 0; i2 < listB2.size(); i2++) {
                Path path2 = listB2.get(i2).getPath();
                path2.transform(dVar2.c());
                this.f3689a.addPath(path2);
            }
        } else {
            this.f3689a.set(nVar2.getPath());
        }
        this.f3691c.op(this.f3689a, this.f3690b, op);
    }
}
