package com.xiaomi.push.service;

import com.xiaomi.push.gs;
import java.util.Map;

/* loaded from: classes2.dex */
public class au {
    public static gs a(gs gsVar) {
        Map<String, String> map;
        if (gsVar != null && (map = gsVar.f636b) != null) {
            map.remove("score_info");
        }
        return gsVar;
    }
}
