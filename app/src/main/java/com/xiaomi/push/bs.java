package com.xiaomi.push;

import com.xiaomi.push.bw;

/* loaded from: classes2.dex */
public class bs extends bw.d {

    /* renamed from: a, reason: collision with root package name */
    protected String f12518a;

    public bs(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f12518a = "MessageDeleteJob";
        this.f12518a = str3;
    }

    public static bs a(String str) {
        return new bs(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
