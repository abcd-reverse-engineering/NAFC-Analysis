package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.bw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class br extends bw.b<Long> {

    /* renamed from: a, reason: collision with root package name */
    private long f12517a;

    /* renamed from: a, reason: collision with other field name */
    private String f227a;

    public br(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i2);
        this.f12517a = 0L;
        this.f227a = str6;
    }

    public static br a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new br(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.bw.b
    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.bw.b
    public void a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.f12517a = list.get(0).longValue();
    }

    @Override // com.xiaomi.push.bw.a
    /* renamed from: a */
    public Object mo193a() {
        return Long.valueOf(this.f12517a);
    }
}
