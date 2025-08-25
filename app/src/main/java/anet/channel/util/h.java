package anet.channel.util;

import anet.channel.request.Request;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f2061a = new HashMap();

    static {
        f2061a.put("tpatch", 3);
        f2061a.put("so", 3);
        f2061a.put("json", 3);
        f2061a.put("html", 4);
        f2061a.put("htm", 4);
        f2061a.put("css", 5);
        f2061a.put("js", 5);
        f2061a.put("webp", 6);
        f2061a.put("png", 6);
        f2061a.put("jpg", 6);
        f2061a.put("do", 6);
        f2061a.put("zip", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f2061a.put("bin", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f2061a.put("apk", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
    }

    public static int a(Request request) {
        Integer num;
        if (request == null) {
            throw new NullPointerException("url is null!");
        }
        if (request.getHeaders().containsKey(HttpConstant.X_PV)) {
            return 1;
        }
        String strTrySolveFileExtFromUrlPath = HttpHelper.trySolveFileExtFromUrlPath(request.getHttpUrl().path());
        if (strTrySolveFileExtFromUrlPath == null || (num = f2061a.get(strTrySolveFileExtFromUrlPath)) == null) {
            return 6;
        }
        return num.intValue();
    }
}
