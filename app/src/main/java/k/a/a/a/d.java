package k.a.a.a;

import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.Iterator;
import java.util.List;

/* compiled from: HnIDCloudServiceUtils.java */
/* loaded from: classes2.dex */
public class d {
    public static String a(List<Scope> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Scope> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a());
            sb.append(c.c.a.b.a.a.f3100g);
        }
        k.a.a.a.j.e.b("HnIDCloudServiceUtils", "scopesToStr scopes : " + sb.toString().trim(), true);
        return sb.toString().trim();
    }
}
