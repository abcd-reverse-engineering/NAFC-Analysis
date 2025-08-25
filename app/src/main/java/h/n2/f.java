package h.n2;

import h.q2.t.i0;
import java.io.File;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        i0.a((Object) string, "sb.toString()");
        return string;
    }
}
