package g.a.y0.j;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes2.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    final int f16037a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f16038b;

    /* renamed from: c, reason: collision with root package name */
    Object[] f16039c;

    /* renamed from: d, reason: collision with root package name */
    int f16040d;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: g.a.y0.j.a$a, reason: collision with other inner class name */
    public interface InterfaceC0232a<T> extends g.a.x0.r<T> {
        @Override // g.a.x0.r
        boolean test(T t);
    }

    public a(int i2) {
        this.f16037a = i2;
        this.f16038b = new Object[i2 + 1];
        this.f16039c = this.f16038b;
    }

    public void a(T t) {
        int i2 = this.f16037a;
        int i3 = this.f16040d;
        if (i3 == i2) {
            Object[] objArr = new Object[i2 + 1];
            this.f16039c[i2] = objArr;
            this.f16039c = objArr;
            i3 = 0;
        }
        this.f16039c[i3] = t;
        this.f16040d = i3 + 1;
    }

    public void b(T t) {
        this.f16038b[0] = t;
    }

    public void a(InterfaceC0232a<? super T> interfaceC0232a) {
        int i2;
        int i3 = this.f16037a;
        for (Object[] objArr = this.f16038b; objArr != null; objArr = (Object[]) objArr[i3]) {
            while (i2 < i3) {
                Object obj = objArr[i2];
                i2 = (obj == null || interfaceC0232a.test(obj)) ? 0 : i2 + 1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean a(i.d.c<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16038b
            int r1 = r4.f16037a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = g.a.y0.j.q.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.y0.j.a.a(i.d.c):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean a(g.a.i0<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16038b
            int r1 = r4.f16037a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = g.a.y0.j.q.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.y0.j.a.a(g.a.i0):boolean");
    }

    public <S> void a(S s, g.a.x0.d<? super S, ? super T> dVar) throws Exception {
        Object[] objArr = this.f16038b;
        int i2 = this.f16037a;
        while (true) {
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = objArr[i3];
                if (obj == null || dVar.a(s, obj)) {
                    return;
                }
            }
            objArr = (Object[]) objArr[i2];
        }
    }
}
