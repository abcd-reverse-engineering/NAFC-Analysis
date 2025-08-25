package com.lxj.xpopup.f;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.Toast;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.e.j;
import com.lxj.xpopup.impl.PartShadowPopupView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: XPopupUtils.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f8064a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f8065b;

    /* compiled from: XPopupUtils.java */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f8066a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8067b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8068c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f8069d;

        a(ViewGroup viewGroup, int i2, int i3, Runnable runnable) {
            this.f8066a = viewGroup;
            this.f8067b = i2;
            this.f8068c = i3;
            this.f8069d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = this.f8066a.getLayoutParams();
            View childAt = this.f8066a.getChildAt(0);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            int measuredWidth = this.f8066a.getMeasuredWidth();
            if (layoutParams2.width == -2) {
                measuredWidth = Math.min(measuredWidth, childAt.getMeasuredWidth());
            }
            int i2 = this.f8067b;
            if (i2 != 0) {
                layoutParams.width = Math.min(measuredWidth, i2);
            }
            int measuredHeight = this.f8066a.getMeasuredHeight();
            if (layoutParams2.height == -1) {
                measuredHeight = ((ViewGroup) this.f8066a.getParent()).getMeasuredHeight();
                layoutParams.height = measuredHeight;
            }
            if (this.f8068c != 0) {
                int i3 = layoutParams.height;
                if (i3 == -1 || i3 == c.b(this.f8066a.getContext()) + c.c()) {
                    layoutParams2.height = Math.min(childAt.getMeasuredHeight(), this.f8068c);
                    childAt.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.height = Math.min(measuredHeight, this.f8068c);
                }
            }
            this.f8066a.setLayoutParams(layoutParams);
            Runnable runnable = this.f8069d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: XPopupUtils.java */
    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f8070a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f8071b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Handler f8072c;

        /* compiled from: XPopupUtils.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(c.f8065b, "图片不存在！", 0).show();
                Context unused = c.f8065b = null;
            }
        }

        /* compiled from: XPopupUtils.java */
        /* renamed from: com.lxj.xpopup.f.c$b$b, reason: collision with other inner class name */
        class C0116b implements MediaScannerConnection.OnScanCompletedListener {

            /* compiled from: XPopupUtils.java */
            /* renamed from: com.lxj.xpopup.f.c$b$b$a */
            class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(c.f8065b, "已保存到相册！", 0).show();
                    Context unused = c.f8065b = null;
                }
            }

            C0116b() {
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                b.this.f8072c.post(new a());
            }
        }

        /* compiled from: XPopupUtils.java */
        /* renamed from: com.lxj.xpopup.f.c$b$c, reason: collision with other inner class name */
        class RunnableC0117c implements Runnable {
            RunnableC0117c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(c.f8065b, "没有保存权限，保存功能无法使用！", 0).show();
                Context unused = c.f8065b = null;
            }
        }

        b(j jVar, Object obj, Handler handler) {
            this.f8070a = jVar;
            this.f8071b = obj;
            this.f8072c = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            File fileA = this.f8070a.a(c.f8065b, this.f8071b);
            if (fileA == null) {
                this.f8072c.post(new a());
                return;
            }
            String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Environment.DIRECTORY_PICTURES;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                String strB = c.b(com.lxj.xpopup.f.a.a(new FileInputStream(fileA)));
                File file2 = new File(str, System.currentTimeMillis() + "." + strB);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                c.b(file2, new FileInputStream(fileA));
                MediaScannerConnection.scanFile(c.f8065b, new String[]{file2.getAbsolutePath()}, new String[]{"image/" + strB}, new C0116b());
            } catch (IOException e2) {
                e2.printStackTrace();
                this.f8072c.post(new RunnableC0117c());
            }
        }
    }

    /* compiled from: XPopupUtils.java */
    /* renamed from: com.lxj.xpopup.f.c$c, reason: collision with other inner class name */
    static /* synthetic */ class C0118c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8077a = new int[com.lxj.xpopup.d.a.values().length];

        static {
            try {
                f8077a[com.lxj.xpopup.d.a.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8077a[com.lxj.xpopup.d.a.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8077a[com.lxj.xpopup.d.a.PNG_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8077a[com.lxj.xpopup.d.a.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8077a[com.lxj.xpopup.d.a.WEBP_A.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8077a[com.lxj.xpopup.d.a.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static void a(EditText editText, int i2) {
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static boolean d(Context context) {
        boolean z;
        ViewGroup viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i2);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(context.getResources().getResourceEntryName(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i2++;
        }
        return z ? (viewGroup.getSystemUiVisibility() & 2) == 0 : z;
    }

    public static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int c() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean b(Activity activity) {
        return a(activity) > 0;
    }

    public static void c(BasePopupView basePopupView) {
        boolean z = basePopupView instanceof PartShadowPopupView;
        if (z || !(basePopupView instanceof AttachPopupView)) {
            if (z && !a(basePopupView)) {
                basePopupView.getPopupImplView().animate().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(200L).start();
            } else {
                basePopupView.getPopupContentView().animate().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(200L).start();
            }
        }
    }

    public static void a(View view, int i2, int i3) {
        if (i2 > 0 || i3 > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i2 > 0) {
                layoutParams.width = i2;
            }
            if (i3 > 0) {
                layoutParams.height = i3;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private static boolean b(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && !((PartShadowPopupView) basePopupView).s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(com.lxj.xpopup.d.a aVar) {
        switch (C0118c.f8077a[aVar.ordinal()]) {
            case 1:
                return "gif";
            case 2:
            case 3:
                return "png";
            case 4:
            case 5:
                return "webp";
            case 6:
            default:
                return "jpeg";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File file, InputStream inputStream) throws Throwable {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = inputStream.read(bArr, 0, 8192);
                        if (i2 == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, i2);
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            throw th;
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(ViewGroup viewGroup, int i2, int i3) {
        a(viewGroup, i2, i3, null);
    }

    public static void a(ViewGroup viewGroup, int i2, int i3, Runnable runnable) {
        viewGroup.post(new a(viewGroup, i2, i3, runnable));
    }

    public static BitmapDrawable a(Resources resources, int i2, int i3) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, 20, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(i3);
        canvas.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), 4.0f, paint);
        paint.setColor(0);
        canvas.drawRect(0.0f, 4.0f, bitmapCreateBitmap.getWidth(), 20.0f, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmapCreateBitmap);
        bitmapDrawable.setGravity(80);
        return bitmapDrawable;
    }

    public static StateListDrawable a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_focused}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static boolean a(float f2, float f3, Rect rect) {
        return f2 >= ((float) rect.left) && f2 <= ((float) rect.right) && f3 >= ((float) rect.top) && f3 <= ((float) rect.bottom);
    }

    public static int a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int iAbs = Math.abs(decorView.getBottom() - rect.bottom);
        if (iAbs <= b()) {
            f8064a = iAbs;
            return 0;
        }
        return iAbs - f8064a;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[PHI: r7
  0x00ab: PHI (r7v5 int) = (r7v3 int), (r7v7 int) binds: [B:70:0x011b, B:36:0x00a9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(int r11, com.lxj.xpopup.core.BasePopupView r12) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.f.c.a(int, com.lxj.xpopup.core.BasePopupView):void");
    }

    private static boolean a(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && ((PartShadowPopupView) basePopupView).s;
    }

    public static void a(ArrayList<EditText> arrayList, ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add((EditText) childAt);
            } else if (childAt instanceof ViewGroup) {
                a(arrayList, (ViewGroup) childAt);
            }
        }
    }

    public static void a(Context context, j jVar, Object obj) {
        Handler handler = new Handler(Looper.getMainLooper());
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        f8065b = context;
        executorServiceNewSingleThreadExecutor.execute(new b(jVar, obj, handler));
    }
}
