package com.lxj.xpopup.core;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lxj.xpopup.f.b;
import com.lxj.xpopup.impl.FullScreenPopupView;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes.dex */
public abstract class BasePopupView extends FrameLayout {
    private static Stack<BasePopupView> o = new Stack<>();

    /* renamed from: a, reason: collision with root package name */
    public com.lxj.xpopup.core.a f7987a;

    /* renamed from: b, reason: collision with root package name */
    protected com.lxj.xpopup.c.b f7988b;

    /* renamed from: c, reason: collision with root package name */
    protected com.lxj.xpopup.c.e f7989c;

    /* renamed from: d, reason: collision with root package name */
    private int f7990d;

    /* renamed from: e, reason: collision with root package name */
    public com.lxj.xpopup.d.e f7991e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7992f;

    /* renamed from: g, reason: collision with root package name */
    private int f7993g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7994h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f7995i;

    /* renamed from: j, reason: collision with root package name */
    private i f7996j;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f7997k;

    /* renamed from: l, reason: collision with root package name */
    Runnable f7998l;

    /* renamed from: m, reason: collision with root package name */
    private float f7999m;
    private float n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BasePopupView.this.getLayoutParams();
            int rotation = ((WindowManager) BasePopupView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 0) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = com.lxj.xpopup.f.c.d(BasePopupView.this.getContext()) ? com.lxj.xpopup.f.c.b() : 0;
            } else if (rotation == 1) {
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = com.lxj.xpopup.f.c.d(BasePopupView.this.getContext()) ? com.lxj.xpopup.f.c.b() : 0;
                layoutParams.leftMargin = 0;
            } else if (rotation == 3) {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = com.lxj.xpopup.f.c.d(BasePopupView.this.getContext()) ? com.lxj.xpopup.f.c.b() : 0;
            }
            BasePopupView.this.setLayoutParams(layoutParams);
            BasePopupView.this.getPopupContentView().setAlpha(1.0f);
            BasePopupView.this.u();
            BasePopupView.this.g();
            BasePopupView.this.e();
            BasePopupView basePopupView = BasePopupView.this;
            if (basePopupView instanceof FullScreenPopupView) {
                return;
            }
            basePopupView.h();
        }
    }

    class b implements b.InterfaceC0115b {
        b() {
        }

        @Override // com.lxj.xpopup.f.b.InterfaceC0115b
        public void a(int i2) {
            if (i2 == 0) {
                com.lxj.xpopup.f.c.c(BasePopupView.this);
                BasePopupView.this.f7994h = false;
            } else {
                com.lxj.xpopup.f.c.a(i2, BasePopupView.this);
                BasePopupView.this.f7994h = true;
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BasePopupView.this.getParent() != null) {
                ((ViewGroup) BasePopupView.this.getParent()).removeView(BasePopupView.this);
            }
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f7987a.o.addView(basePopupView, new FrameLayout.LayoutParams(-1, -1));
            ArrayList arrayList = new ArrayList();
            com.lxj.xpopup.f.c.a((ArrayList<EditText>) arrayList, (ViewGroup) BasePopupView.this.getPopupContentView());
            if (arrayList.size() > 0) {
                Window window = ((Activity) BasePopupView.this.getContext()).getWindow();
                BasePopupView.this.f7993g = window.getAttributes().softInputMode;
                if (BasePopupView.this.f7993g != 16) {
                    window.setSoftInputMode(16);
                }
            }
            BasePopupView.this.j();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.lxj.xpopup.e.i iVar;
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f7991e = com.lxj.xpopup.d.e.Show;
            basePopupView.p();
            BasePopupView basePopupView2 = BasePopupView.this;
            if (basePopupView2 instanceof FullScreenPopupView) {
                basePopupView2.h();
            }
            com.lxj.xpopup.core.a aVar = BasePopupView.this.f7987a;
            if (aVar != null && (iVar = aVar.n) != null) {
                iVar.b();
            }
            if (com.lxj.xpopup.f.c.a((Activity) BasePopupView.this.getContext()) <= 0 || BasePopupView.this.f7994h) {
                return;
            }
            com.lxj.xpopup.f.c.a(com.lxj.xpopup.f.c.a((Activity) BasePopupView.this.getContext()), BasePopupView.this);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePopupView.this.b();
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.lxj.xpopup.e.i iVar;
            BasePopupView.this.o();
            com.lxj.xpopup.core.a aVar = BasePopupView.this.f7987a;
            if (aVar != null && (iVar = aVar.n) != null) {
                iVar.onDismiss();
            }
            Runnable runnable = BasePopupView.this.f7998l;
            if (runnable != null) {
                runnable.run();
                BasePopupView.this.f7998l = null;
            }
            BasePopupView.this.f7991e = com.lxj.xpopup.d.e.Dismiss;
            if (!BasePopupView.o.isEmpty()) {
                BasePopupView.o.pop();
            }
            com.lxj.xpopup.core.a aVar2 = BasePopupView.this.f7987a;
            if (aVar2 != null && aVar2.w) {
                if (BasePopupView.o.isEmpty()) {
                    View viewFindViewById = ((Activity) BasePopupView.this.getContext()).findViewById(R.id.content);
                    viewFindViewById.setFocusable(true);
                    viewFindViewById.setFocusableInTouchMode(true);
                } else {
                    ((BasePopupView) BasePopupView.o.get(BasePopupView.o.size() - 1)).h();
                }
            }
            BasePopupView basePopupView = BasePopupView.this;
            ViewGroup viewGroup = basePopupView.f7987a.o;
            if (viewGroup != null) {
                viewGroup.removeView(basePopupView);
                BasePopupView basePopupView2 = BasePopupView.this;
                com.lxj.xpopup.f.b.a(basePopupView2.f7987a.o, basePopupView2);
            }
        }
    }

    static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8006a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                f8006a[com.lxj.xpopup.d.c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.TranslateAlphaFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.TranslateAlphaFromTop.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.TranslateAlphaFromRight.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.TranslateAlphaFromBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.TranslateFromLeft.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.TranslateFromTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.TranslateFromRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.TranslateFromBottom.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScrollAlphaFromLeft.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScrollAlphaFromLeftTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScrollAlphaFromTop.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScrollAlphaFromRightTop.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScrollAlphaFromRight.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScrollAlphaFromRightBottom.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScrollAlphaFromBottom.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.ScrollAlphaFromLeftBottom.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f8006a[com.lxj.xpopup.d.c.NoAnimation.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    class h implements View.OnKeyListener {
        h() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            com.lxj.xpopup.e.i iVar;
            if (i2 != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            if (BasePopupView.this.f7987a.f8028b.booleanValue() && ((iVar = BasePopupView.this.f7987a.n) == null || !iVar.c())) {
                BasePopupView.this.c();
            }
            return true;
        }
    }

    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        View f8008a;

        /* renamed from: b, reason: collision with root package name */
        boolean f8009b = false;

        public i(View view) {
            this.f8008a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f8008a;
            if (view == null || this.f8009b) {
                return;
            }
            this.f8009b = true;
            com.lxj.xpopup.f.b.b(view);
        }
    }

    public BasePopupView(@NonNull Context context) {
        super(context);
        this.f7991e = com.lxj.xpopup.d.e.Dismiss;
        this.f7992f = false;
        this.f7993g = -1;
        this.f7994h = false;
        this.f7995i = new d();
        this.f7997k = new f();
        this.f7990d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f7989c = new com.lxj.xpopup.c.e(this);
        View viewInflate = LayoutInflater.from(context).inflate(getPopupLayoutId(), (ViewGroup) this, false);
        viewInflate.setAlpha(0.0f);
        addView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f7988b == null) {
            com.lxj.xpopup.c.b bVar = this.f7987a.f8035i;
            if (bVar != null) {
                this.f7988b = bVar;
                this.f7988b.f7950a = getPopupContentView();
            } else {
                this.f7988b = i();
                if (this.f7988b == null) {
                    this.f7988b = getPopupAnimator();
                }
            }
            this.f7989c.d();
            com.lxj.xpopup.c.b bVar2 = this.f7988b;
            if (bVar2 != null) {
                bVar2.d();
            }
        }
    }

    protected void d() {
        if (this.f7987a.f8039m.booleanValue()) {
            com.lxj.xpopup.f.b.a(this);
        }
        removeCallbacks(this.f7997k);
        postDelayed(this.f7997k, getAnimationDuration());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        removeCallbacks(this.f7995i);
        postDelayed(this.f7995i, getAnimationDuration());
    }

    public void f() {
        if (this.f7987a.f8031e.booleanValue()) {
            this.f7989c.a();
        }
        com.lxj.xpopup.c.b bVar = this.f7988b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void g() {
        if (this.f7987a.f8031e.booleanValue()) {
            this.f7989c.f7967e = this.f7987a.f8034h == com.lxj.xpopup.d.c.NoAnimation;
            this.f7989c.b();
        }
        com.lxj.xpopup.c.b bVar = this.f7988b;
        if (bVar != null) {
            bVar.b();
        }
    }

    public int getAnimationDuration() {
        if (this.f7987a.f8034h == com.lxj.xpopup.d.c.NoAnimation) {
            return 10;
        }
        return com.lxj.xpopup.b.a();
    }

    protected int getImplLayoutId() {
        return -1;
    }

    protected int getMaxHeight() {
        return this.f7987a.f8038l;
    }

    protected int getMaxWidth() {
        return 0;
    }

    protected com.lxj.xpopup.c.b getPopupAnimator() {
        return null;
    }

    public View getPopupContentView() {
        return getChildAt(0);
    }

    protected int getPopupHeight() {
        return 0;
    }

    public View getPopupImplView() {
        return ((ViewGroup) getPopupContentView()).getChildAt(0);
    }

    protected abstract int getPopupLayoutId();

    protected int getPopupWidth() {
        return 0;
    }

    protected View getTargetSizeView() {
        return getPopupContentView();
    }

    public void h() {
        if (this.f7987a.w) {
            setFocusableInTouchMode(true);
            requestFocus();
            if (!o.contains(this)) {
                o.push(this);
            }
        }
        setOnKeyListener(new h());
        if (!this.f7987a.x) {
            a((View) this);
        }
        ArrayList arrayList = new ArrayList();
        com.lxj.xpopup.f.c.a((ArrayList<EditText>) arrayList, (ViewGroup) getPopupContentView());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            EditText editText = (EditText) arrayList.get(i2);
            editText.setOnKeyListener(new h());
            if (i2 == 0 && this.f7987a.x) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                a(editText);
            }
        }
    }

    protected com.lxj.xpopup.c.b i() {
        com.lxj.xpopup.d.c cVar;
        com.lxj.xpopup.core.a aVar = this.f7987a;
        if (aVar == null || (cVar = aVar.f8034h) == null) {
            return null;
        }
        switch (g.f8006a[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new com.lxj.xpopup.c.c(getPopupContentView(), this.f7987a.f8034h);
            case 6:
            case 7:
            case 8:
            case 9:
                return new com.lxj.xpopup.c.f(getPopupContentView(), this.f7987a.f8034h);
            case 10:
            case 11:
            case 12:
            case 13:
                return new com.lxj.xpopup.c.g(getPopupContentView(), this.f7987a.f8034h);
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return new com.lxj.xpopup.c.d(getPopupContentView(), this.f7987a.f8034h);
            case 22:
                return new com.lxj.xpopup.c.a();
            default:
                return null;
        }
    }

    public void j() {
        com.lxj.xpopup.d.e eVar = this.f7991e;
        com.lxj.xpopup.d.e eVar2 = com.lxj.xpopup.d.e.Showing;
        if (eVar == eVar2) {
            return;
        }
        this.f7991e = eVar2;
        if (!this.f7992f) {
            k();
        }
        if (!(this instanceof FullScreenPopupView) && !(this instanceof ImageViewerPopupView)) {
            com.lxj.xpopup.f.c.a(getTargetSizeView(), (getMaxWidth() == 0 || getPopupWidth() <= getMaxWidth()) ? getPopupWidth() : getMaxWidth(), (getMaxHeight() == 0 || getPopupHeight() <= getMaxHeight()) ? getPopupHeight() : getMaxHeight());
        }
        if (!this.f7992f) {
            this.f7992f = true;
            n();
            com.lxj.xpopup.e.i iVar = this.f7987a.n;
            if (iVar != null) {
                iVar.a();
            }
        }
        postDelayed(new a(), 50L);
    }

    protected void k() {
    }

    public boolean l() {
        return this.f7991e == com.lxj.xpopup.d.e.Dismiss;
    }

    public boolean m() {
        return this.f7991e != com.lxj.xpopup.d.e.Dismiss;
    }

    protected void n() {
    }

    protected void o() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o.clear();
        removeCallbacks(this.f7995i);
        removeCallbacks(this.f7997k);
        com.lxj.xpopup.f.b.a(this.f7987a.o, this);
        i iVar = this.f7996j;
        if (iVar != null) {
            removeCallbacks(iVar);
        }
        this.f7991e = com.lxj.xpopup.d.e.Dismiss;
        this.f7996j = null;
        this.f7994h = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getPopupContentView().getGlobalVisibleRect(rect);
        if (!com.lxj.xpopup.f.c.a(motionEvent.getX(), motionEvent.getY(), rect)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f7999m = motionEvent.getX();
                this.n = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.f7999m, 2.0d) + Math.pow(motionEvent.getY() - this.n, 2.0d))) < this.f7990d && this.f7987a.f8029c.booleanValue()) {
                    b();
                }
                this.f7999m = 0.0f;
                this.n = 0.0f;
            }
        }
        return true;
    }

    protected void p() {
    }

    protected void q() {
    }

    public BasePopupView r() {
        if (getParent() != null) {
            return this;
        }
        Activity activity = (Activity) getContext();
        this.f7987a.o = (ViewGroup) activity.getWindow().getDecorView();
        com.lxj.xpopup.f.b.a(activity, this, new b());
        this.f7987a.o.post(new c());
        return this;
    }

    public void s() {
        if (m()) {
            b();
        } else {
            r();
        }
    }

    public void b() {
        com.lxj.xpopup.d.e eVar = this.f7991e;
        com.lxj.xpopup.d.e eVar2 = com.lxj.xpopup.d.e.Dismissing;
        if (eVar == eVar2) {
            return;
        }
        this.f7991e = eVar2;
        if (this.f7987a.f8039m.booleanValue()) {
            com.lxj.xpopup.f.b.a(this);
        }
        q();
        clearFocus();
        f();
        d();
    }

    protected void c() {
        if (com.lxj.xpopup.f.b.f8059a == 0) {
            b();
        } else {
            com.lxj.xpopup.f.b.a(this);
        }
    }

    protected void a(View view) {
        if (this.f7987a.f8039m.booleanValue()) {
            i iVar = this.f7996j;
            if (iVar == null) {
                this.f7996j = new i(view);
            } else {
                removeCallbacks(iVar);
            }
            postDelayed(this.f7996j, 10L);
        }
    }

    public void a(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        postDelayed(new e(), j2);
    }

    public void a(long j2, Runnable runnable) {
        this.f7998l = runnable;
        a(j2);
    }

    public void a(Runnable runnable) {
        this.f7998l = runnable;
        b();
    }

    public BasePopupView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7991e = com.lxj.xpopup.d.e.Dismiss;
        this.f7992f = false;
        this.f7993g = -1;
        this.f7994h = false;
        this.f7995i = new d();
        this.f7997k = new f();
    }

    public BasePopupView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7991e = com.lxj.xpopup.d.e.Dismiss;
        this.f7992f = false;
        this.f7993g = -1;
        this.f7994h = false;
        this.f7995i = new d();
        this.f7997k = new f();
    }
}
