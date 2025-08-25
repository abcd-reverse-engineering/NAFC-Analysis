package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public class af extends AsyncTask<String, Void, Bitmap[]> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f11236b = af.class.getName();

    /* renamed from: a, reason: collision with root package name */
    public a f11237a;

    /* renamed from: c, reason: collision with root package name */
    private String f11238c;

    /* renamed from: d, reason: collision with root package name */
    private BitmapFactory.Options f11239d;

    public interface a {
        void a(Bitmap[] bitmapArr);
    }

    public af(Context context, UInAppMessage uInAppMessage) {
        this.f11238c = f.a(context, uInAppMessage.msg_id);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            this.f11239d = new BitmapFactory.Options();
            this.f11239d.inSampleSize = a(uInAppMessage, i2, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap[] doInBackground(String... strArr) throws IOException {
        Bitmap bitmapDecodeStream;
        boolean z;
        boolean zCompress;
        Bitmap[] bitmapArr = new Bitmap[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                String str = strArr[i2];
                StringBuilder sb = new StringBuilder();
                sb.append(str.hashCode());
                if (new File(this.f11238c, sb.toString()).exists()) {
                    bitmapArr[i2] = a(strArr[i2]);
                } else {
                    bitmapArr[i2] = a(strArr[i2]);
                    if (bitmapArr[i2] == null) {
                        String str2 = strArr[i2];
                        UMLog.mutlInfo(f11236b, 2, "Downloading image start");
                        URLConnection uRLConnectionOpenConnection = new URL(str2).openConnection();
                        uRLConnectionOpenConnection.connect();
                        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
                        if (this.f11239d == null) {
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                        } else {
                            UMLog.mutlInfo(f11236b, 2, "decode options");
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, this.f11239d);
                        }
                        inputStream.close();
                        UMLog.mutlInfo(f11236b, 2, "Downloading image finish");
                        bitmapArr[i2] = bitmapDecodeStream;
                        Bitmap bitmap = bitmapArr[i2];
                        String str3 = strArr[i2];
                        if (bitmap != null) {
                            try {
                                File file = new File(this.f11238c);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str3.hashCode());
                                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f11238c, sb2.toString()));
                                zCompress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e2) {
                                    z = zCompress;
                                    e = e2;
                                    e.printStackTrace();
                                    zCompress = z;
                                    UMLog.mutlInfo(f11236b, 2, "store bitmap".concat(String.valueOf(zCompress)));
                                }
                            } catch (Exception e3) {
                                e = e3;
                                z = false;
                            }
                            UMLog.mutlInfo(f11236b, 2, "store bitmap".concat(String.valueOf(zCompress)));
                        }
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        return bitmapArr;
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(Bitmap[] bitmapArr) {
        Bitmap[] bitmapArr2 = bitmapArr;
        super.onPostExecute(bitmapArr2);
        for (Bitmap bitmap : bitmapArr2) {
            if (bitmap == null) {
                return;
            }
        }
        a aVar = this.f11237a;
        if (aVar != null) {
            aVar.a(bitmapArr2);
        }
    }

    private Bitmap a(String str) {
        Bitmap bitmapDecodeFile = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str.hashCode());
            bitmapDecodeFile = BitmapFactory.decodeFile(this.f11238c + sb.toString());
            UMLog.mutlInfo(f11236b, 2, "load from local");
            return bitmapDecodeFile;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bitmapDecodeFile;
        }
    }

    private static int a(UInAppMessage uInAppMessage, int i2, int i3) {
        int i4 = uInAppMessage.height;
        int i5 = uInAppMessage.width;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }
}
