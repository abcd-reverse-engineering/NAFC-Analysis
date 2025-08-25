package m.c;

import android.graphics.Bitmap;
import c.b.c.l;
import c.b.c.w;
import c.b.c.z.b;

/* compiled from: CodeCreator.java */
/* loaded from: classes2.dex */
public class a {
    public static Bitmap a(String str) throws w {
        if (str == null || str.equals("")) {
            return null;
        }
        b bVarA = new l().a(str, c.b.c.a.QR_CODE, 300, 300);
        int iG = bVarA.g();
        int iD = bVarA.d();
        int[] iArr = new int[iG * iD];
        for (int i2 = 0; i2 < iD; i2++) {
            for (int i3 = 0; i3 < iG; i3++) {
                if (bVarA.b(i3, i2)) {
                    iArr[(i2 * iG) + i3] = -16777216;
                }
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iG, iD, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, iG, 0, 0, iG, iD);
        return bitmapCreateBitmap;
    }
}
