package util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.Toast;
import com.luck.picture.lib.config.PictureMimeType;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Calendar;

/* compiled from: ShotScreenUtils.java */
/* loaded from: classes2.dex */
public class t1 {

    /* renamed from: i, reason: collision with root package name */
    private static final String f20971i = "ShotScreenUtils";

    /* renamed from: j, reason: collision with root package name */
    private static ImageReader f20972j;

    /* renamed from: a, reason: collision with root package name */
    private d f20973a;

    /* renamed from: b, reason: collision with root package name */
    private int f20974b;

    /* renamed from: c, reason: collision with root package name */
    private int f20975c;

    /* renamed from: d, reason: collision with root package name */
    private int f20976d;

    /* renamed from: e, reason: collision with root package name */
    private Intent f20977e;

    /* renamed from: f, reason: collision with root package name */
    private Context f20978f;

    /* renamed from: g, reason: collision with root package name */
    private MediaProjection f20979g;

    /* renamed from: h, reason: collision with root package name */
    private VirtualDisplay f20980h;

    /* compiled from: ShotScreenUtils.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t1.this.i();
        }
    }

    /* compiled from: ShotScreenUtils.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t1.this.h();
        }
    }

    /* compiled from: ShotScreenUtils.java */
    public static final class c {
        private c() {
        }

        @Deprecated
        public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
            if (asyncTask == null) {
                throw new IllegalArgumentException("task can not be null");
            }
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
            return asyncTask;
        }
    }

    /* compiled from: ShotScreenUtils.java */
    public interface d {
        void a();

        void a(Uri uri);

        void b();
    }

    /* compiled from: ShotScreenUtils.java */
    private class e extends AsyncTask<Image, Void, Uri> {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Uri doInBackground(Image... imageArr) {
            if (imageArr == null || imageArr.length < 1 || imageArr[0] == null) {
                if (t1.this.f20973a != null) {
                    t1.this.f20973a.b();
                }
                return null;
            }
            Image image = imageArr[0];
            int width = image.getWidth();
            int height = image.getHeight();
            Image.Plane[] planes = image.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            int pixelStride = planes[0].getPixelStride();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((planes[0].getRowStride() - (pixelStride * width)) / pixelStride) + width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.copyPixelsFromBuffer(buffer);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, height);
            image.close();
            if (bitmapCreateBitmap2 != null) {
                t1 t1Var = t1.this;
                return t1Var.a(t1Var.f20978f, bitmapCreateBitmap2);
            }
            if (t1.this.f20973a != null) {
                t1.this.f20973a.b();
            }
            return null;
        }

        /* synthetic */ e(t1 t1Var, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Uri uri) {
            super.onPostExecute(uri);
            if (uri != null) {
                if (t1.this.f20973a != null) {
                    Toast.makeText(t1.this.f20978f, "截屏完成。", 0).show();
                    t1.this.f20973a.a(uri);
                    return;
                }
                return;
            }
            if (t1.this.f20973a != null) {
                t1.this.f20973a.b();
            }
        }
    }

    /* compiled from: ShotScreenUtils.java */
    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private static final t1 f20984a = new t1(null);

        private f() {
        }
    }

    /* synthetic */ t1(a aVar) {
        this();
    }

    public static t1 e() {
        return f.f20984a;
    }

    private MediaProjectionManager f() {
        return (MediaProjectionManager) this.f20978f.getSystemService("media_projection");
    }

    private void g() {
        if (this.f20977e != null) {
            this.f20979g = f().getMediaProjection(-1, this.f20977e);
            return;
        }
        n1.b(f20971i, "setUpMediaProjection: 获取权限返回数据发生异常！");
        d dVar = this.f20973a;
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Image imageAcquireLatestImage = f20972j.acquireLatestImage();
        if (imageAcquireLatestImage == null) {
            b();
        } else {
            c.a(new e(this, null), imageAcquireLatestImage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f20979g != null) {
            l();
        } else {
            g();
            l();
        }
    }

    private void j() {
        VirtualDisplay virtualDisplay = this.f20980h;
        if (virtualDisplay == null) {
            return;
        }
        virtualDisplay.release();
        this.f20980h = null;
    }

    private void k() {
        MediaProjection mediaProjection = this.f20979g;
        if (mediaProjection != null) {
            mediaProjection.stop();
            this.f20979g = null;
        }
    }

    private void l() {
        this.f20980h = this.f20979g.createVirtualDisplay("screen-mirror", this.f20974b, this.f20975c, this.f20976d, 16, f20972j.getSurface(), null, null);
    }

    public void setOnShotScreenListener(d dVar) {
        this.f20973a = dVar;
    }

    private t1() {
    }

    public static boolean c() {
        return f20972j != null;
    }

    private void d() {
        f20972j = ImageReader.newInstance(this.f20974b, this.f20975c, 1, 1);
    }

    public void b() {
        d dVar = this.f20973a;
        if (dVar != null) {
            dVar.a();
        }
        Handler handler = new Handler();
        handler.postDelayed(new a(), 5L);
        handler.postDelayed(new b(), 30L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri a(Context context, Bitmap bitmap) throws IOException {
        String str;
        if (y1.b()) {
            str = context.getExternalFilesDir(Environment.DIRECTORY_DCIM) + File.separator + "ScreenShots";
        } else {
            str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + File.separator + "ScreenShots";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis / 1000;
        Calendar calendar = Calendar.getInstance();
        String str2 = "Screenshot_" + calendar.get(1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (calendar.get(2) + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(10) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(12) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(13) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(14) + c.c.a.b.a.a.s1 + context.getPackageName() + PictureMimeType.PNG;
        String str3 = str + File.separator + str2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = context.getContentResolver();
        contentValues.put("_data", str3);
        contentValues.put("title", str2);
        contentValues.put("_display_name", str2);
        contentValues.put("datetaken", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("date_added", Long.valueOf(j2));
        contentValues.put("date_modified", Long.valueOf(j2));
        contentValues.put("mime_type", PictureMimeType.MIME_TYPE_PNG);
        contentValues.put(SocializeProtocolConstants.WIDTH, Integer.valueOf(width));
        contentValues.put(SocializeProtocolConstants.HEIGHT, Integer.valueOf(height));
        Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        try {
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStreamOpenOutputStream);
            outputStreamOpenOutputStream.flush();
            outputStreamOpenOutputStream.close();
        } catch (FileNotFoundException e2) {
            d dVar = this.f20973a;
            if (dVar != null) {
                dVar.b();
            }
            e2.printStackTrace();
        } catch (IOException e3) {
            d dVar2 = this.f20973a;
            if (dVar2 != null) {
                dVar2.b();
            }
            e3.printStackTrace();
        }
        contentValues.clear();
        contentValues.put("_size", Long.valueOf(new File(str3).length()));
        contentResolver.update(uriInsert, contentValues, null, null);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        Uri uriFromFile = Uri.fromFile(new File(str3));
        intent.setData(uriFromFile);
        context.sendBroadcast(intent);
        return uriFromFile;
    }

    public t1 a(int i2, int i3, int i4) {
        this.f20974b = i2;
        this.f20975c = i3;
        this.f20976d = i4;
        return this;
    }

    public t1 a(Context context) {
        this.f20978f = context;
        return this;
    }

    public t1 a(Intent intent) {
        this.f20977e = intent;
        d();
        return this;
    }

    public void a() {
        k();
        j();
    }
}
