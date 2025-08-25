package com.umeng.ut.b.a.a;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f11906d = !a.class.desiredAssertionStatus();

    /* renamed from: com.umeng.ut.b.a.a.a$a, reason: collision with other inner class name */
    static abstract class AbstractC0160a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f11907a;

        /* renamed from: b, reason: collision with root package name */
        public int f11908b;

        AbstractC0160a() {
        }
    }

    static class b extends AbstractC0160a {

        /* renamed from: c, reason: collision with other field name */
        int f60c;
        private int count;

        /* renamed from: d, reason: collision with other field name */
        private final byte[] f61d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f11912e;

        /* renamed from: e, reason: collision with other field name */
        private final byte[] f62e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f11913f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f11914g;

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f11911d = !a.class.desiredAssertionStatus();

        /* renamed from: b, reason: collision with root package name */
        private static final byte[] f11909b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: c, reason: collision with root package name */
        private static final byte[] f11910c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        public b(int i2, byte[] bArr) {
            this.f11907a = bArr;
            this.f11912e = (i2 & 1) == 0;
            this.f11913f = (i2 & 2) == 0;
            this.f11914g = (i2 & 4) != 0;
            this.f62e = (i2 & 8) == 0 ? f11909b : f11910c;
            this.f61d = new byte[2];
            this.f60c = 0;
            this.count = this.f11913f ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:104:0x00e9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0097  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 528
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.b.a.a.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    private a() {
    }

    public static String a(byte[] bArr, int i2) {
        try {
            return new String(m46a(bArr, i2), i.a.a.a.c.f16730b);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m46a(byte[] bArr, int i2) {
        return a(bArr, 0, bArr.length, i2);
    }

    @SuppressLint({"Assert"})
    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, null);
        int i5 = (i3 / 3) * 4;
        if (bVar.f11912e) {
            if (i3 % 3 > 0) {
                i5 += 4;
            }
        } else {
            int i6 = i3 % 3;
            if (i6 != 0) {
                if (i6 == 1) {
                    i5 += 2;
                } else if (i6 == 2) {
                    i5 += 3;
                }
            }
        }
        if (bVar.f11913f && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (bVar.f11914g ? 2 : 1);
        }
        bVar.f11907a = new byte[i5];
        bVar.a(bArr, i2, i3, true);
        if (f11906d || bVar.f11908b == i5) {
            return bVar.f11907a;
        }
        throw new AssertionError();
    }
}
