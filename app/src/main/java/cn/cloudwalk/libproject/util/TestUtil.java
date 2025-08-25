package cn.cloudwalk.libproject.util;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class TestUtil {
    private static int count;
    static int count1;
    private static int num;
    private static long start_time;
    private static long time;
    private static long time1;

    public static void save1FrameYUV(byte[] bArr, String str) throws Exception {
        count1++;
        if (count1 % 10 != 0) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        FileOutputStream fileOutputStream = new FileOutputStream(str + "/frame" + count1);
        byte[] bArr2 = new byte[1024000];
        while (true) {
            int i2 = byteArrayInputStream.read(bArr2);
            if (i2 == -1) {
                byteArrayInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr2, 0, i2);
        }
    }

    public static void time1sCount(String str) {
        if (num == 0) {
            start_time = System.currentTimeMillis();
            num++;
            String str2 = num + "";
            return;
        }
        if (System.currentTimeMillis() - start_time > 1000) {
            num = 0;
            return;
        }
        num++;
        String str3 = num + "";
    }

    public static void time1sCount2(String str) {
        String str2 = "-------" + num + "-------";
    }

    public static void timeCount() {
        count++;
        if (count % 2 == 1) {
            time = System.currentTimeMillis();
        }
        if (count % 2 == 0) {
            String str = (System.currentTimeMillis() - time) + "----------";
        }
    }

    public static void timeEnd(String str) {
        String str2 = (System.currentTimeMillis() - time1) + "----------";
    }

    public static void timeStart() {
        time1 = System.currentTimeMillis();
    }
}
