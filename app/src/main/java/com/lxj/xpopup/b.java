package com.lxj.xpopup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.d.c;
import com.lxj.xpopup.d.d;
import com.lxj.xpopup.d.f;
import com.lxj.xpopup.e.e;
import com.lxj.xpopup.e.g;
import com.lxj.xpopup.e.i;
import com.lxj.xpopup.e.j;
import com.lxj.xpopup.impl.AttachListPopupView;
import com.lxj.xpopup.impl.BottomListPopupView;
import com.lxj.xpopup.impl.CenterListPopupView;
import com.lxj.xpopup.impl.ConfirmPopupView;
import com.lxj.xpopup.impl.InputConfirmPopupView;
import com.lxj.xpopup.impl.LoadingPopupView;
import java.util.List;

/* compiled from: XPopup.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f7943a = Color.parseColor("#121212");

    /* renamed from: b, reason: collision with root package name */
    private static int f7944b = 360;

    /* renamed from: c, reason: collision with root package name */
    public static int f7945c = Color.parseColor("#55000000");

    /* renamed from: d, reason: collision with root package name */
    private static int f7946d = Color.parseColor("#9F000000");

    /* compiled from: XPopup.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final com.lxj.xpopup.core.a f7947a = new com.lxj.xpopup.core.a();

        /* renamed from: b, reason: collision with root package name */
        private Context f7948b;

        /* compiled from: XPopup.java */
        /* renamed from: com.lxj.xpopup.b$a$a, reason: collision with other inner class name */
        class ViewOnTouchListenerC0112a implements View.OnTouchListener {
            ViewOnTouchListenerC0112a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.f7947a.f8036j != null && motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.f7947a.f8036j = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
                return false;
            }
        }

        public a(Context context) {
            this.f7948b = context;
        }

        public a b(View view) {
            com.lxj.xpopup.core.a aVar = this.f7947a;
            aVar.f8033g = view;
            aVar.f8033g.setOnTouchListener(new ViewOnTouchListenerC0112a());
            return this;
        }

        public a c(Boolean bool) {
            this.f7947a.f8028b = bool;
            return this;
        }

        public a d(Boolean bool) {
            this.f7947a.f8029c = bool;
            return this;
        }

        public a e(Boolean bool) {
            this.f7947a.f8031e = bool;
            return this;
        }

        public a f(Boolean bool) {
            this.f7947a.p = bool;
            return this;
        }

        public a a(f fVar) {
            this.f7947a.f8027a = fVar;
            return this;
        }

        public a c(boolean z) {
            this.f7947a.r = Boolean.valueOf(z);
            return this;
        }

        public a d(int i2) {
            this.f7947a.t = i2;
            return this;
        }

        public a e(boolean z) {
            this.f7947a.w = z;
            return this;
        }

        public a a(Boolean bool) {
            this.f7947a.f8030d = bool;
            return this;
        }

        public a b(int i2) {
            this.f7947a.f8037k = i2;
            return this;
        }

        public a c(int i2) {
            this.f7947a.s = i2;
            return this;
        }

        public a d(boolean z) {
            this.f7947a.v = z;
            return this;
        }

        public a a(View view) {
            this.f7947a.f8032f = view;
            return this;
        }

        public a b(Boolean bool) {
            this.f7947a.f8039m = bool;
            return this;
        }

        public a a(c cVar) {
            this.f7947a.f8034h = cVar;
            return this;
        }

        public a b(boolean z) {
            this.f7947a.u = Boolean.valueOf(z);
            return this;
        }

        public a a(com.lxj.xpopup.c.b bVar) {
            this.f7947a.f8035i = bVar;
            return this;
        }

        public CenterListPopupView b(String str, String[] strArr, int[] iArr, int i2, com.lxj.xpopup.e.f fVar) {
            a(f.Center);
            CenterListPopupView centerListPopupViewA = new CenterListPopupView(this.f7948b).a(str, strArr, iArr).c(i2).a(fVar);
            centerListPopupViewA.f7987a = this.f7947a;
            return centerListPopupViewA;
        }

        public a a(int i2) {
            this.f7947a.f8038l = i2;
            return this;
        }

        public a a(d dVar) {
            this.f7947a.q = dVar;
            return this;
        }

        public a a(boolean z) {
            this.f7947a.x = z;
            return this;
        }

        public a a(i iVar) {
            this.f7947a.n = iVar;
            return this;
        }

        public ConfirmPopupView a(String str, String str2, String str3, String str4, com.lxj.xpopup.e.c cVar, com.lxj.xpopup.e.a aVar, boolean z) {
            a(f.Center);
            ConfirmPopupView confirmPopupView = new ConfirmPopupView(this.f7948b);
            confirmPopupView.a(str, str2, null);
            confirmPopupView.a(str3);
            confirmPopupView.b(str4);
            confirmPopupView.a(cVar, aVar);
            if (z) {
                confirmPopupView.v();
            }
            confirmPopupView.f7987a = this.f7947a;
            return confirmPopupView;
        }

        public CenterListPopupView b(String str, String[] strArr, com.lxj.xpopup.e.f fVar) {
            return b(str, strArr, null, -1, fVar);
        }

        public CenterListPopupView b(String str, String[] strArr, int[] iArr, com.lxj.xpopup.e.f fVar) {
            return b(str, strArr, iArr, -1, fVar);
        }

        public ConfirmPopupView a(String str, String str2, com.lxj.xpopup.e.c cVar, com.lxj.xpopup.e.a aVar) {
            return a(str, str2, null, null, cVar, aVar, false);
        }

        public ConfirmPopupView a(String str, String str2, com.lxj.xpopup.e.c cVar) {
            return a(str, str2, null, null, cVar, null, false);
        }

        public InputConfirmPopupView a(String str, String str2, String str3, String str4, e eVar, com.lxj.xpopup.e.a aVar) {
            a(f.Center);
            InputConfirmPopupView inputConfirmPopupView = new InputConfirmPopupView(this.f7948b);
            inputConfirmPopupView.a(str, str2, str4);
            inputConfirmPopupView.F = str3;
            inputConfirmPopupView.a(eVar, aVar);
            inputConfirmPopupView.f7987a = this.f7947a;
            return inputConfirmPopupView;
        }

        public InputConfirmPopupView a(String str, String str2, String str3, String str4, e eVar) {
            return a(str, str2, str3, str4, eVar, (com.lxj.xpopup.e.a) null);
        }

        public InputConfirmPopupView a(String str, String str2, String str3, e eVar) {
            return a(str, str2, (String) null, str3, eVar, (com.lxj.xpopup.e.a) null);
        }

        public InputConfirmPopupView a(String str, String str2, e eVar) {
            return a(str, str2, (String) null, (String) null, eVar, (com.lxj.xpopup.e.a) null);
        }

        public LoadingPopupView a(String str) {
            a(f.Center);
            LoadingPopupView loadingPopupViewA = new LoadingPopupView(this.f7948b).a(str);
            loadingPopupViewA.f7987a = this.f7947a;
            return loadingPopupViewA;
        }

        public LoadingPopupView a() {
            return a((String) null);
        }

        public BottomListPopupView a(String str, String[] strArr, int[] iArr, int i2, boolean z, com.lxj.xpopup.e.f fVar) {
            a(f.Bottom);
            BottomListPopupView bottomListPopupViewA = new BottomListPopupView(this.f7948b).a(str, strArr, iArr).c(i2).a(fVar);
            bottomListPopupViewA.f7987a = this.f7947a;
            return bottomListPopupViewA;
        }

        public BottomListPopupView a(String str, String[] strArr, com.lxj.xpopup.e.f fVar) {
            return a(str, strArr, (int[]) null, -1, true, fVar);
        }

        public BottomListPopupView a(String str, String[] strArr, int[] iArr, com.lxj.xpopup.e.f fVar) {
            return a(str, strArr, iArr, -1, true, fVar);
        }

        public BottomListPopupView a(String str, String[] strArr, int[] iArr, int i2, com.lxj.xpopup.e.f fVar) {
            return a(str, strArr, iArr, i2, true, fVar);
        }

        public BottomListPopupView a(String str, String[] strArr, int[] iArr, boolean z, com.lxj.xpopup.e.f fVar) {
            return a(str, strArr, iArr, -1, z, fVar);
        }

        public AttachListPopupView a(String[] strArr, int[] iArr, int i2, int i3, com.lxj.xpopup.e.f fVar) {
            a(f.AttachView);
            AttachListPopupView attachListPopupViewA = new AttachListPopupView(this.f7948b).a(strArr, iArr).a(i2, i3).a(fVar);
            attachListPopupViewA.f7987a = this.f7947a;
            return attachListPopupViewA;
        }

        public AttachListPopupView a(String[] strArr, int[] iArr, com.lxj.xpopup.e.f fVar) {
            return a(strArr, iArr, 0, 0, fVar);
        }

        public ImageViewerPopupView a(ImageView imageView, Object obj, j jVar) {
            a(f.ImageViewer);
            ImageViewerPopupView imageViewerPopupViewA = new ImageViewerPopupView(this.f7948b).a(imageView, obj).a(jVar);
            imageViewerPopupViewA.f7987a = this.f7947a;
            return imageViewerPopupViewA;
        }

        public ImageViewerPopupView a(ImageView imageView, Object obj, boolean z, int i2, int i3, int i4, boolean z2, j jVar) {
            a(f.ImageViewer);
            ImageViewerPopupView imageViewerPopupViewA = new ImageViewerPopupView(this.f7948b).a(imageView, obj).a(z).a(i2).c(i3).b(i4).d(z2).a(jVar);
            imageViewerPopupViewA.f7987a = this.f7947a;
            return imageViewerPopupViewA;
        }

        public ImageViewerPopupView a(ImageView imageView, int i2, List<Object> list, g gVar, j jVar) {
            return a(imageView, i2, list, false, -1, -1, -1, true, gVar, jVar);
        }

        public ImageViewerPopupView a(ImageView imageView, int i2, List<Object> list, boolean z, int i3, int i4, int i5, boolean z2, g gVar, j jVar) {
            a(f.ImageViewer);
            ImageViewerPopupView imageViewerPopupViewA = new ImageViewerPopupView(this.f7948b).a(imageView, i2).a(list).a(z).a(i3).c(i4).b(i5).d(z2).a(gVar).a(jVar);
            imageViewerPopupViewA.f7987a = this.f7947a;
            return imageViewerPopupViewA;
        }

        public BasePopupView a(BasePopupView basePopupView) {
            if (basePopupView instanceof CenterPopupView) {
                a(f.Center);
            } else if (basePopupView instanceof BottomPopupView) {
                a(f.Bottom);
            } else if (basePopupView instanceof AttachPopupView) {
                a(f.AttachView);
            } else if (basePopupView instanceof ImageViewerPopupView) {
                a(f.ImageViewer);
            } else if (basePopupView instanceof PositionPopupView) {
                a(f.Position);
            }
            basePopupView.f7987a = this.f7947a;
            return basePopupView;
        }
    }

    private b() {
    }

    public static void a(int i2) {
        if (i2 >= 0) {
            f7944b = i2;
        }
    }

    public static void b(int i2) {
        f7943a = i2;
    }

    public static void c(int i2) {
        f7946d = i2;
    }

    public static int a() {
        return f7944b;
    }

    public static int b() {
        return f7943a;
    }

    public static int c() {
        return f7946d;
    }
}
