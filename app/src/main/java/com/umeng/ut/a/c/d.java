package com.umeng.ut.a.c;

/* loaded from: classes2.dex */
public class d {

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public int[] f11903a;
        public int x;
        public int y;

        private a() {
            this.f11903a = new int[256];
        }
    }

    private static a a(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a();
        for (int i2 = 0; i2 < 256; i2++) {
            aVar.f11903a[i2] = i2;
        }
        aVar.x = 0;
        aVar.y = 0;
        int length = 0;
        int iCharAt = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            try {
                iCharAt = ((str.charAt(length) + aVar.f11903a[i3]) + iCharAt) % 256;
                int i4 = aVar.f11903a[i3];
                aVar.f11903a[i3] = aVar.f11903a[iCharAt];
                aVar.f11903a[iCharAt] = i4;
                length = (length + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    public static byte[] b(byte[] bArr) {
        a aVarA;
        if (bArr == null || (aVarA = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, aVarA);
    }

    private static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i2 = aVar.x;
        int i3 = aVar.y;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) % 256;
            int[] iArr = aVar.f11903a;
            i3 = (iArr[i2] + i3) % 256;
            int i5 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i5;
            int i6 = (iArr[i2] + iArr[i3]) % 256;
            bArr[i4] = (byte) (iArr[i6] ^ bArr[i4]);
        }
        aVar.x = i2;
        aVar.y = i3;
        return bArr;
    }
}
