package cn.cloudwalk.libproject.util;

/* loaded from: classes.dex */
public class RandomUtil {
    public static int[] randomCommon(int i2, int i3, int i4) {
        boolean z;
        int i5 = i3 - i2;
        if (i4 > i5 + 1 || i3 < i2) {
            return null;
        }
        int[] iArr = new int[i4];
        int i6 = 0;
        while (i6 < i4) {
            int iRandom = ((int) (Math.random() * i5)) + i2;
            int i7 = 0;
            while (true) {
                if (i7 >= i4) {
                    z = true;
                    break;
                }
                if (iRandom == iArr[i7]) {
                    z = false;
                    break;
                }
                i7++;
            }
            if (z) {
                iArr[i6] = iRandom;
                i6++;
            }
        }
        return iArr;
    }
}
