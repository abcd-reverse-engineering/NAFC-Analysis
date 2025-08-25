package c.b.c.d0.a0.g.e;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;

/* compiled from: FieldParser.java */
/* loaded from: classes.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2518a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object[][] f2519b = {new Object[]{"00", 18}, new Object[]{HiAnalyticsConstant.KeyAndValue.NUMBER_01, 14}, new Object[]{"02", 14}, new Object[]{"10", f2518a, 20}, new Object[]{"11", 6}, new Object[]{"12", 6}, new Object[]{"13", 6}, new Object[]{"15", 6}, new Object[]{Constants.VIA_REPORT_TYPE_START_GROUP, 6}, new Object[]{"20", 2}, new Object[]{"21", f2518a, 20}, new Object[]{"22", f2518a, 29}, new Object[]{"30", f2518a, 8}, new Object[]{"37", f2518a, 8}, new Object[]{"90", f2518a, 30}, new Object[]{"91", f2518a, 30}, new Object[]{"92", f2518a, 30}, new Object[]{"93", f2518a, 30}, new Object[]{"94", f2518a, 30}, new Object[]{"95", f2518a, 30}, new Object[]{"96", f2518a, 30}, new Object[]{"97", f2518a, 30}, new Object[]{"98", f2518a, 30}, new Object[]{"99", f2518a, 30}};

    /* renamed from: c, reason: collision with root package name */
    private static final Object[][] f2520c = {new Object[]{"240", f2518a, 30}, new Object[]{"241", f2518a, 30}, new Object[]{"242", f2518a, 6}, new Object[]{"250", f2518a, 30}, new Object[]{"251", f2518a, 30}, new Object[]{"253", f2518a, 17}, new Object[]{"254", f2518a, 20}, new Object[]{"400", f2518a, 30}, new Object[]{"401", f2518a, 30}, new Object[]{"402", 17}, new Object[]{"403", f2518a, 30}, new Object[]{"410", 13}, new Object[]{"411", 13}, new Object[]{"412", 13}, new Object[]{"413", 13}, new Object[]{"414", 13}, new Object[]{"420", f2518a, 20}, new Object[]{"421", f2518a, 15}, new Object[]{"422", 3}, new Object[]{"423", f2518a, 15}, new Object[]{"424", 3}, new Object[]{"425", 3}, new Object[]{"426", 3}};

    /* renamed from: d, reason: collision with root package name */
    private static final Object[][] f2521d = {new Object[]{"310", 6}, new Object[]{"311", 6}, new Object[]{"312", 6}, new Object[]{"313", 6}, new Object[]{"314", 6}, new Object[]{"315", 6}, new Object[]{"316", 6}, new Object[]{"320", 6}, new Object[]{"321", 6}, new Object[]{"322", 6}, new Object[]{"323", 6}, new Object[]{"324", 6}, new Object[]{"325", 6}, new Object[]{"326", 6}, new Object[]{"327", 6}, new Object[]{"328", 6}, new Object[]{"329", 6}, new Object[]{"330", 6}, new Object[]{"331", 6}, new Object[]{"332", 6}, new Object[]{"333", 6}, new Object[]{"334", 6}, new Object[]{"335", 6}, new Object[]{"336", 6}, new Object[]{"340", 6}, new Object[]{"341", 6}, new Object[]{"342", 6}, new Object[]{"343", 6}, new Object[]{"344", 6}, new Object[]{"345", 6}, new Object[]{"346", 6}, new Object[]{"347", 6}, new Object[]{"348", 6}, new Object[]{"349", 6}, new Object[]{"350", 6}, new Object[]{"351", 6}, new Object[]{"352", 6}, new Object[]{"353", 6}, new Object[]{"354", 6}, new Object[]{"355", 6}, new Object[]{"356", 6}, new Object[]{"357", 6}, new Object[]{"360", 6}, new Object[]{"361", 6}, new Object[]{"362", 6}, new Object[]{"363", 6}, new Object[]{"364", 6}, new Object[]{"365", 6}, new Object[]{"366", 6}, new Object[]{"367", 6}, new Object[]{"368", 6}, new Object[]{"369", 6}, new Object[]{"390", f2518a, 15}, new Object[]{"391", f2518a, 18}, new Object[]{"392", f2518a, 15}, new Object[]{"393", f2518a, 18}, new Object[]{"703", f2518a, 30}};

    /* renamed from: e, reason: collision with root package name */
    private static final Object[][] f2522e = {new Object[]{"7001", 13}, new Object[]{"7002", f2518a, 30}, new Object[]{"7003", 10}, new Object[]{"8001", 14}, new Object[]{"8002", f2518a, 20}, new Object[]{"8003", f2518a, 30}, new Object[]{"8004", f2518a, 30}, new Object[]{"8005", 6}, new Object[]{"8006", 18}, new Object[]{"8007", f2518a, 30}, new Object[]{"8008", f2518a, 12}, new Object[]{"8018", 18}, new Object[]{"8020", f2518a, 25}, new Object[]{"8100", 6}, new Object[]{"8101", 10}, new Object[]{"8102", 2}, new Object[]{"8110", f2518a, 70}, new Object[]{"8200", f2518a, 70}};

    private r() {
    }

    static String a(String str) throws c.b.c.m {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw c.b.c.m.getNotFoundInstance();
        }
        String strSubstring = str.substring(0, 2);
        for (Object[] objArr : f2519b) {
            if (objArr[0].equals(strSubstring)) {
                return objArr[1] == f2518a ? b(2, ((Integer) objArr[2]).intValue(), str) : a(2, ((Integer) objArr[1]).intValue(), str);
            }
        }
        if (str.length() < 3) {
            throw c.b.c.m.getNotFoundInstance();
        }
        String strSubstring2 = str.substring(0, 3);
        for (Object[] objArr2 : f2520c) {
            if (objArr2[0].equals(strSubstring2)) {
                return objArr2[1] == f2518a ? b(3, ((Integer) objArr2[2]).intValue(), str) : a(3, ((Integer) objArr2[1]).intValue(), str);
            }
        }
        for (Object[] objArr3 : f2521d) {
            if (objArr3[0].equals(strSubstring2)) {
                return objArr3[1] == f2518a ? b(4, ((Integer) objArr3[2]).intValue(), str) : a(4, ((Integer) objArr3[1]).intValue(), str);
            }
        }
        if (str.length() < 4) {
            throw c.b.c.m.getNotFoundInstance();
        }
        String strSubstring3 = str.substring(0, 4);
        for (Object[] objArr4 : f2522e) {
            if (objArr4[0].equals(strSubstring3)) {
                return objArr4[1] == f2518a ? b(4, ((Integer) objArr4[2]).intValue(), str) : a(4, ((Integer) objArr4[1]).intValue(), str);
            }
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private static String b(int i2, int i3, String str) throws c.b.c.m {
        String strSubstring = str.substring(0, i2);
        int length = i3 + i2;
        if (str.length() < length) {
            length = str.length();
        }
        String strSubstring2 = str.substring(i2, length);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(length));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }

    private static String a(int i2, int i3, String str) throws c.b.c.m {
        if (str.length() >= i2) {
            String strSubstring = str.substring(0, i2);
            int i4 = i3 + i2;
            if (str.length() >= i4) {
                String strSubstring2 = str.substring(i2, i4);
                String str2 = '(' + strSubstring + ')' + strSubstring2;
                String strA = a(str.substring(i4));
                if (strA == null) {
                    return str2;
                }
                return str2 + strA;
            }
            throw c.b.c.m.getNotFoundInstance();
        }
        throw c.b.c.m.getNotFoundInstance();
    }
}
