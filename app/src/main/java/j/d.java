package j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.p.j;
import com.bumptech.glide.load.r.d.n;
import com.bumptech.glide.r.h;
import com.hicorenational.antifraud.R;
import java.io.File;
import ui.view.r;

/* compiled from: ImageUtil.java */
/* loaded from: classes2.dex */
public class d {

    /* compiled from: ImageUtil.java */
    static class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17013a;

        a(int i2) {
            this.f17013a = i2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f17013a);
        }
    }

    public static void a(String str, ImageView imageView) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) new h().e(R.drawable.default_pic).b(R.drawable.default_pic).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void b(ImageView imageView, String str) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) new h().a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void c(String str, ImageView imageView) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) new h().e(R.drawable.iv_tool_default).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void b(ImageView imageView, Integer num) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(num).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void b(String str, ImageView imageView) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) h.c(new n()).a(300, 300).e(R.drawable.iv_cricle_img_def).b(R.drawable.iv_cricle_img_def).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void a(ImageView imageView, Integer num) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).e().a(num).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void a(ImageView imageView, String str) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).e().a(str).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str, ImageView imageView, int i2) {
        com.bumptech.glide.b.e(context).a(str).a((com.bumptech.glide.r.a<?>) new h().e(R.drawable.default_pic).a(300, 300).b(R.drawable.default_pic).a(j.f4570a)).b((com.bumptech.glide.load.n<Bitmap>) new r(i2)).a(imageView);
    }

    public static void b(String str, ImageView imageView, Integer num) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) h.c(new n()).a(300, 300).e(R.drawable.iv_cricle_img_def).b(num.intValue()).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void a(String str, ImageView imageView, Integer num) {
        if (num == null) {
            num = Integer.valueOf(R.mipmap.ic_launcher);
        }
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) new h().e(num.intValue()).b(num.intValue()).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void a(String str, ImageView imageView, Integer num, int i2, int i3) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) new h().a(i2, i3).a(com.bumptech.glide.load.b.PREFER_RGB_565).e(num.intValue()).b(num.intValue()).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void a(Fragment fragment, String str, ImageView imageView, Integer num) {
        if (num == null) {
            num = Integer.valueOf(R.mipmap.ic_launcher);
        }
        try {
            com.bumptech.glide.b.a(fragment).a(str).a((com.bumptech.glide.r.a<?>) new h().e(num.intValue()).b(num.intValue()).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void a(Activity activity, String str, ImageView imageView, Integer num) {
        if (num == null) {
            num = Integer.valueOf(R.mipmap.ic_launcher);
        }
        try {
            com.bumptech.glide.b.a(activity).a(str).a((com.bumptech.glide.r.a<?>) new h().e(num.intValue()).b(num.intValue()).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    public static void a(File file, ImageView imageView, Integer num) {
        if (num == null) {
            num = Integer.valueOf(R.mipmap.ic_launcher);
        }
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(file).a((com.bumptech.glide.r.a<?>) new h().e(num.intValue()).b(num.intValue()).a(j.f4570a)).a(imageView);
        } catch (Exception unused) {
        }
    }

    @TargetApi(21)
    public static void a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21 && view != null && i2 > 0) {
            view.setOutlineProvider(new a(i2));
            view.setClipToOutline(true);
        }
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        float f2 = i2;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        return Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, height - i2);
    }

    public static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
