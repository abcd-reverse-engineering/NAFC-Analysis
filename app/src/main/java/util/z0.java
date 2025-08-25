package util;

import android.content.res.ColorStateList;
import androidx.core.view.ViewCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: ColorUtils.java */
/* loaded from: classes2.dex */
public class z0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f21046a = 16842910;

    /* renamed from: b, reason: collision with root package name */
    private static final int f21047b = 16842912;

    /* renamed from: c, reason: collision with root package name */
    private static final int f21048c = 16842919;

    public static ColorStateList a(int i2) {
        int i3 = i2 - (-805306368);
        return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842912, 16842919}, new int[]{-16842912, 16842919}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i2 - (-520093696), CommonNetImpl.FLAG_AUTH, i3, CommonNetImpl.FLAG_SHARE, i3, CommonNetImpl.FLAG_SHARE});
    }

    public static ColorStateList b(int i2) {
        int i3 = i2 - (-1728053248);
        return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842919, -16842912}, new int[]{16842919, 16842912}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i2 - (-1442840576), -4539718, i3, i3, i2 | ViewCompat.MEASURED_STATE_MASK, -1446930});
    }
}
