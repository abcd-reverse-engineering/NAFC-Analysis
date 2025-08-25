package g.a.y0.j;

import java.util.ArrayList;

/* compiled from: LinkedArrayList.java */
/* loaded from: classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    final int f16048a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f16049b;

    /* renamed from: c, reason: collision with root package name */
    Object[] f16050c;

    /* renamed from: d, reason: collision with root package name */
    volatile int f16051d;

    /* renamed from: e, reason: collision with root package name */
    int f16052e;

    public n(int i2) {
        this.f16048a = i2;
    }

    public void a(Object obj) {
        if (this.f16051d == 0) {
            this.f16049b = new Object[this.f16048a + 1];
            Object[] objArr = this.f16049b;
            this.f16050c = objArr;
            objArr[0] = obj;
            this.f16052e = 1;
            this.f16051d = 1;
            return;
        }
        int i2 = this.f16052e;
        int i3 = this.f16048a;
        if (i2 != i3) {
            this.f16050c[i2] = obj;
            this.f16052e = i2 + 1;
            this.f16051d++;
        } else {
            Object[] objArr2 = new Object[i3 + 1];
            objArr2[0] = obj;
            this.f16050c[i3] = objArr2;
            this.f16050c = objArr2;
            this.f16052e = 1;
            this.f16051d++;
        }
    }

    public int b() {
        return this.f16051d;
    }

    public String toString() {
        int i2 = this.f16048a;
        int i3 = this.f16051d;
        ArrayList arrayList = new ArrayList(i3 + 1);
        Object[] objArrA = a();
        int i4 = 0;
        while (true) {
            int i5 = 0;
            while (i4 < i3) {
                arrayList.add(objArrA[i5]);
                i4++;
                i5++;
                if (i5 == i2) {
                    break;
                }
            }
            return arrayList.toString();
            objArrA = objArrA[i2];
        }
    }

    public Object[] a() {
        return this.f16049b;
    }
}
