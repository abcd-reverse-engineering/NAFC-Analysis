package com.luck.picture.lib;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class PictureMediaScannerConnection implements MediaScannerConnection.MediaScannerConnectionClient {
    private ScanListener mListener;
    private MediaScannerConnection mMs;
    private String mPath;

    public interface ScanListener {
        void onScanFinish();
    }

    public PictureMediaScannerConnection(Context context, String str, ScanListener scanListener) {
        this.mListener = scanListener;
        this.mPath = str;
        this.mMs = new MediaScannerConnection(context.getApplicationContext(), this);
        this.mMs.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (TextUtils.isEmpty(this.mPath)) {
            return;
        }
        this.mMs.scanFile(this.mPath, null);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.mMs.disconnect();
        ScanListener scanListener = this.mListener;
        if (scanListener != null) {
            scanListener.onScanFinish();
        }
    }

    public PictureMediaScannerConnection(Context context, String str) {
        this.mPath = str;
        this.mMs = new MediaScannerConnection(context.getApplicationContext(), this);
        this.mMs.connect();
    }
}
