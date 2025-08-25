package com.umeng.analytics.filter;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import h.f1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: SmartDict.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f10004b = "Ă";

    /* renamed from: c, reason: collision with root package name */
    private MessageDigest f10006c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10008e;

    /* renamed from: a, reason: collision with root package name */
    private final String f10005a = "MD5";

    /* renamed from: d, reason: collision with root package name */
    private Set<Object> f10007d = new HashSet();

    public d(boolean z, String str) {
        int i2 = 0;
        this.f10008e = false;
        this.f10008e = z;
        try {
            this.f10006c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            if (!z) {
                String[] strArrSplit = str.split(f10004b);
                int length = strArrSplit.length;
                while (i2 < length) {
                    this.f10007d.add(strArrSplit[i2]);
                    i2++;
                }
                return;
            }
            try {
                byte[] bArrDecode = Base64.decode(str.getBytes(), 0);
                while (i2 < bArrDecode.length / 4) {
                    int i3 = i2 * 4;
                    this.f10007d.add(Integer.valueOf(((bArrDecode[i3 + 0] & f1.f16099c) << 24) + ((bArrDecode[i3 + 1] & f1.f16099c) << 16) + ((bArrDecode[i3 + 2] & f1.f16099c) << 8) + (bArrDecode[i3 + 3] & f1.f16099c)));
                    i2++;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f10006c.update(str.getBytes());
            byte[] bArrDigest = this.f10006c.digest();
            return Integer.valueOf(((bArrDigest[0] & f1.f16099c) << 24) + ((bArrDigest[1] & f1.f16099c) << 16) + ((bArrDigest[2] & f1.f16099c) << 8) + (bArrDigest[3] & f1.f16099c));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        return this.f10008e ? this.f10007d.contains(c(str)) : this.f10007d.contains(str);
    }

    public void b(String str) {
        if (this.f10008e) {
            this.f10007d.add(c(str));
        } else {
            this.f10007d.add(str);
        }
    }

    public String toString() {
        if (!this.f10008e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f10007d) {
                if (sb.length() > 0) {
                    sb.append(f10004b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f10007d.size() * 4];
        Iterator<Object> it = this.f10007d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((-16777216) & iIntValue) >> 24);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((16711680 & iIntValue) >> 16);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((65280 & iIntValue) >> 8);
            i2 = i5 + 1;
            bArr[i5] = (byte) (iIntValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f10007d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        System.out.println(sb.toString());
    }
}
