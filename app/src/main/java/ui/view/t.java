package ui.view;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;

/* compiled from: SingleMediaScanner.java */
/* loaded from: classes2.dex */
public class t implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    private MediaScannerConnection f20684a;

    /* renamed from: b, reason: collision with root package name */
    private File f20685b;

    public t(Context context, File file) {
        this.f20685b = file;
        this.f20684a = new MediaScannerConnection(context, this);
        this.f20684a.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.f20684a.scanFile(this.f20685b.getAbsolutePath(), null);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.f20684a.disconnect();
    }
}
