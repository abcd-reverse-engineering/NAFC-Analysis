package ui.view;

import android.content.Context;
import android.widget.ImageView;
import com.hicorenational.antifraud.R;
import com.youth.banner.loader.ImageLoader;

/* compiled from: GlideImageLoader.java */
/* loaded from: classes2.dex */
public class q extends ImageLoader {

    /* renamed from: a, reason: collision with root package name */
    private static q f20641a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f20642b;

    private q() {
    }

    public static q getImageLoader(Context context) {
        f20642b = context;
        if (f20641a == null) {
            f20641a = new q();
        }
        return f20641a;
    }

    @Override // com.youth.banner.loader.ImageLoaderInterface
    public void displayImage(Context context, Object obj, ImageView imageView) {
        com.bumptech.glide.b.e(context).a(obj).a((com.bumptech.glide.r.a<?>) new com.bumptech.glide.r.h().e(R.mipmap.banner1).a(com.bumptech.glide.load.p.j.f4570a)).a(imageView);
    }
}
