package com.huawei.hms.hatool;

import android.os.Build;

/* loaded from: classes.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7051a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f7052b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.314" + p.a();
    }

    public void a(int i2) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 19) {
            sb.append(System.lineSeparator());
            sb.append("======================================= ");
            sb.append(System.lineSeparator());
            sb.append(a());
            sb.append("");
            sb.append(System.lineSeparator());
            str = "=======================================";
        } else {
            sb.append("====================");
            sb.append(a());
            str = "===================";
        }
        sb.append(str);
        sb.toString();
        this.f7052b = i2;
        this.f7051a = true;
    }

    public void a(int i2, String str, String str2) {
        if (i2 == 3 || i2 != 5) {
        }
    }

    public void b(int i2, String str, String str2) {
        a(i2, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i2) {
        return this.f7051a && i2 >= this.f7052b;
    }
}
