package androidx.core.net;

import android.net.Uri;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.File;

/* compiled from: Uri.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class UriKt {
    @d
    public static final File toFile(@d Uri uri) {
        i0.f(uri, "$receiver");
        if (i0.a((Object) uri.getScheme(), (Object) "file")) {
            return new File(uri.getPath());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }

    @d
    public static final Uri toUri(@d String str) {
        i0.f(str, "$receiver");
        Uri uri = Uri.parse(str);
        i0.a((Object) uri, "Uri.parse(this)");
        return uri;
    }

    @d
    public static final Uri toUri(@d File file) {
        i0.f(file, "$receiver");
        Uri uriFromFile = Uri.fromFile(file);
        i0.a((Object) uriFromFile, "Uri.fromFile(this)");
        return uriFromFile;
    }
}
