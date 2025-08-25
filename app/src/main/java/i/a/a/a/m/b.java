package i.a.a.a.m;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.bh;
import java.util.Locale;

/* compiled from: Caverphone1.java */
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16771a = "111111";

    @Override // i.a.a.a.i
    public String a(String str) {
        if (str == null || str.length() == 0) {
            return f16771a;
        }
        return (str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll(bh.aI, "k").replaceAll("q", "k").replaceAll("x", "k").replaceAll("v", "f").replaceAll("dg", UtilityImpl.NET_TYPE_2G).replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("d", "t").replaceAll("ph", "fh").replaceAll("b", bh.aA).replaceAll("sh", "s2").replaceAll(bh.aG, bh.aE).replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wy", "Wy").replaceAll("wh3", "Wh3").replaceAll("why", "Why").replaceAll("w", "2").replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll(bh.aJ, "2").replaceAll("r3", "R3").replaceAll("ry", "Ry").replaceAll("r", "2").replaceAll("l3", "L3").replaceAll("ly", "Ly").replaceAll("l", "2").replaceAll("j", "y").replaceAll("y3", "Y3").replaceAll("y", "2").replaceAll("2", "").replaceAll("3", "") + f16771a).substring(0, 6);
    }
}
