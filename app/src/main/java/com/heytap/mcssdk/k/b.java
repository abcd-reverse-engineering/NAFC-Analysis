package com.heytap.mcssdk.k;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5890a = "type";

    /* renamed from: b, reason: collision with root package name */
    private static final String f5891b = "count";

    /* renamed from: c, reason: collision with root package name */
    private static final String f5892c = "list";

    /* renamed from: d, reason: collision with root package name */
    private static final int f5893d = 1017;

    public static void a(Context context, MessageStat messageStat) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(messageStat);
        a(context, linkedList);
    }

    private static boolean a(Context context) {
        String strA = com.heytap.mcssdk.a.w().a(context);
        return c.c(context, strA) && c.a(context, strA) >= 1017;
    }

    public static boolean a(Context context, List<MessageStat> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        g.b("isSupportStatisticByMcs:" + a(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !a(context)) {
            return false;
        }
        return b(context, linkedList);
    }

    private static boolean b(Context context, List<MessageStat> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(com.heytap.mcssdk.a.w().b(context));
            intent.setPackage(com.heytap.mcssdk.a.w().a(context));
            intent.putExtra(com.heytap.mcssdk.constant.b.f5827e, context.getPackageName());
            intent.putExtra("type", MessageConstant.CommandId.COMMAND_STATISTIC);
            intent.putExtra(f5891b, list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<MessageStat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toJsonObject());
            }
            intent.putStringArrayListExtra(f5892c, arrayList);
            context.startService(intent);
            return true;
        } catch (Exception e2) {
            g.e("statisticMessage--Exception" + e2.getMessage());
            return false;
        }
    }
}
