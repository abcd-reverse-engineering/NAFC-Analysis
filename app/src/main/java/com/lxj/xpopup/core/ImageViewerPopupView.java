package com.lxj.xpopup.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.ChangeTransform;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpermission.XPermission;
import com.lxj.xpopup.R;
import com.lxj.xpopup.e.g;
import com.lxj.xpopup.e.j;
import com.lxj.xpopup.photoview.PhotoView;
import com.lxj.xpopup.widget.BlankView;
import com.lxj.xpopup.widget.HackyViewPager;
import com.lxj.xpopup.widget.PhotoViewContainer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ImageViewerPopupView extends BasePopupView implements com.lxj.xpopup.e.d, View.OnClickListener {
    protected Rect A;
    protected ImageView B;
    protected PhotoView C;
    protected boolean D;
    protected int E;
    protected int F;
    protected int G;
    protected boolean H;
    protected boolean I;
    protected boolean J;
    protected View K;
    protected int L;
    protected FrameLayout p;
    protected PhotoViewContainer q;
    protected BlankView r;
    protected TextView s;
    protected TextView t;
    protected HackyViewPager u;
    protected ArgbEvaluator v;
    protected List<Object> w;
    protected j x;
    protected g y;
    protected int z;

    public class PhotoViewAdapter extends PagerAdapter {

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerPopupView.this.b();
            }
        }

        public PhotoViewAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            if (imageViewerPopupView.J) {
                return 1073741823;
            }
            return imageViewerPopupView.w.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            PhotoView photoView = new PhotoView(viewGroup.getContext());
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            j jVar = imageViewerPopupView.x;
            if (jVar != null) {
                List<Object> list = imageViewerPopupView.w;
                jVar.a(i2, list.get(imageViewerPopupView.J ? i2 % list.size() : i2), photoView);
            }
            viewGroup.addView(photoView);
            photoView.setOnClickListener(new a());
            return photoView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return obj == view;
        }
    }

    class a extends ViewPager.SimpleOnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.z = i2;
            imageViewerPopupView.x();
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            g gVar = imageViewerPopupView2.y;
            if (gVar != null) {
                gVar.a(imageViewerPopupView2, i2);
            }
        }
    }

    class b implements Runnable {

        class a extends TransitionListenerAdapter {
            a() {
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                ImageViewerPopupView.this.u.setVisibility(0);
                ImageViewerPopupView.this.C.setVisibility(4);
                ImageViewerPopupView.this.x();
                ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
                imageViewerPopupView.q.f8166f = false;
                ImageViewerPopupView.super.e();
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TransitionManager.beginDelayedTransition((ViewGroup) ImageViewerPopupView.this.C.getParent(), new TransitionSet().setDuration(com.lxj.xpopup.b.a()).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()).setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator()).addListener((Transition.TransitionListener) new a()));
            ImageViewerPopupView.this.C.setTranslationY(0.0f);
            ImageViewerPopupView.this.C.setTranslationX(0.0f);
            ImageViewerPopupView.this.C.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            com.lxj.xpopup.f.c.a(imageViewerPopupView.C, imageViewerPopupView.q.getWidth(), ImageViewerPopupView.this.q.getHeight());
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            imageViewerPopupView2.d(imageViewerPopupView2.L);
            View view = ImageViewerPopupView.this.K;
            if (view != null) {
                view.animate().alpha(1.0f).setDuration(com.lxj.xpopup.b.a()).start();
            }
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8020a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8021b;

        c(int i2, int i3) {
            this.f8020a = i2;
            this.f8021b = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.q.setBackgroundColor(((Integer) imageViewerPopupView.v.evaluate(valueAnimator.getAnimatedFraction(), Integer.valueOf(this.f8020a), Integer.valueOf(this.f8021b))).intValue());
        }
    }

    class d extends TransitionListenerAdapter {
        d() {
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            ImageViewerPopupView.this.d();
            ImageViewerPopupView.this.u.setVisibility(4);
            ImageViewerPopupView.this.C.setVisibility(0);
            ImageViewerPopupView.this.u.setScaleX(1.0f);
            ImageViewerPopupView.this.u.setScaleY(1.0f);
            ImageViewerPopupView.this.C.setScaleX(1.0f);
            ImageViewerPopupView.this.C.setScaleY(1.0f);
            ImageViewerPopupView.this.r.setVisibility(4);
        }
    }

    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            View view = ImageViewerPopupView.this.K;
            if (view != null) {
                view.setVisibility(4);
            }
        }
    }

    class f implements XPermission.d {
        f() {
        }

        @Override // com.lxj.xpermission.XPermission.d
        public void a() {
            Toast.makeText(ImageViewerPopupView.this.getContext(), "没有保存权限，保存功能无法使用！", 0).show();
        }

        @Override // com.lxj.xpermission.XPermission.d
        public void onGranted() {
            Context context = ImageViewerPopupView.this.getContext();
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            j jVar = imageViewerPopupView.x;
            List<Object> list = imageViewerPopupView.w;
            boolean z = imageViewerPopupView.J;
            int size = imageViewerPopupView.z;
            if (z) {
                size %= list.size();
            }
            com.lxj.xpopup.f.c.a(context, jVar, list.get(size));
        }
    }

    public ImageViewerPopupView(@NonNull Context context) {
        super(context);
        this.v = new ArgbEvaluator();
        this.w = new ArrayList();
        this.A = null;
        this.D = true;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = true;
        this.I = true;
        this.J = false;
        this.L = Color.rgb(32, 36, 46);
        this.p = (FrameLayout) findViewById(R.id.container);
        if (getImplLayoutId() > 0) {
            this.K = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.p, false);
            this.K.setVisibility(4);
            this.K.setAlpha(0.0f);
            this.p.addView(this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        int color = ((ColorDrawable) this.q.getBackground()).getColor();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new c(color, i2));
        valueAnimatorOfFloat.setDuration(com.lxj.xpopup.b.a()).setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.start();
    }

    private void v() {
        if (this.B == null) {
            return;
        }
        if (this.C == null) {
            this.C = new PhotoView(getContext());
            this.q.addView(this.C);
            this.C.setScaleType(this.B.getScaleType());
            this.C.setTranslationX(this.A.left);
            this.C.setTranslationY(this.A.top);
            com.lxj.xpopup.f.c.a(this.C, this.A.width(), this.A.height());
        }
        w();
        this.C.setImageDrawable(this.B.getDrawable());
    }

    private void w() {
        this.r.setVisibility(this.D ? 0 : 4);
        if (this.D) {
            int i2 = this.E;
            if (i2 != -1) {
                this.r.f8137d = i2;
            }
            int i3 = this.G;
            if (i3 != -1) {
                this.r.f8136c = i3;
            }
            int i4 = this.F;
            if (i4 != -1) {
                this.r.f8138e = i4;
            }
            com.lxj.xpopup.f.c.a(this.r, this.A.width(), this.A.height());
            this.r.setTranslationX(this.A.left);
            this.r.setTranslationY(this.A.top);
            this.r.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.w.size() > 1) {
            int size = this.J ? this.z % this.w.size() : this.z;
            this.s.setText((size + 1) + "/" + this.w.size());
        }
        if (this.H) {
            this.t.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.core.BasePopupView
    public void e() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void f() {
        if (this.B == null) {
            this.q.setBackgroundColor(0);
            d();
            this.u.setVisibility(4);
            this.r.setVisibility(4);
            return;
        }
        this.s.setVisibility(4);
        this.t.setVisibility(4);
        this.u.setVisibility(4);
        this.C.setVisibility(0);
        this.q.f8166f = true;
        TransitionManager.beginDelayedTransition((ViewGroup) this.C.getParent(), new TransitionSet().setDuration(com.lxj.xpopup.b.a()).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()).setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator()).addListener((Transition.TransitionListener) new d()));
        this.C.setTranslationY(this.A.top);
        this.C.setTranslationX(this.A.left);
        this.C.setScaleX(1.0f);
        this.C.setScaleY(1.0f);
        this.C.setScaleType(this.B.getScaleType());
        com.lxj.xpopup.f.c.a(this.C, this.A.width(), this.A.height());
        d(0);
        View view = this.K;
        if (view != null) {
            view.animate().alpha(0.0f).setDuration(com.lxj.xpopup.b.a()).setListener(new e()).start();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void g() {
        if (this.B == null) {
            this.q.setBackgroundColor(this.L);
            this.u.setVisibility(0);
            x();
            this.q.f8166f = false;
            super.e();
            return;
        }
        this.q.f8166f = true;
        this.C.setVisibility(0);
        View view = this.K;
        if (view != null) {
            view.setVisibility(0);
        }
        this.C.post(new b());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_image_viewer_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        this.s = (TextView) findViewById(R.id.tv_pager_indicator);
        this.t = (TextView) findViewById(R.id.tv_save);
        this.r = (BlankView) findViewById(R.id.placeholderView);
        this.q = (PhotoViewContainer) findViewById(R.id.photoViewContainer);
        this.q.setOnDragChangeListener(this);
        this.u = (HackyViewPager) findViewById(R.id.pager);
        this.u.setAdapter(new PhotoViewAdapter());
        this.u.setOffscreenPageLimit(this.w.size());
        this.u.setCurrentItem(this.z);
        this.u.setVisibility(4);
        v();
        if (this.J) {
            this.u.setOffscreenPageLimit(this.w.size() / 2);
        }
        this.u.addOnPageChangeListener(new a());
        if (!this.I) {
            this.s.setVisibility(8);
        }
        if (this.H) {
            this.t.setOnClickListener(this);
        } else {
            this.t.setVisibility(8);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void o() {
        super.o();
        this.B = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.t) {
            u();
        }
    }

    protected void u() {
        XPermission.a(getContext(), com.lxj.xpermission.b.f7932i).a(new f()).e();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void b() {
        if (this.f7991e != com.lxj.xpopup.d.e.Show) {
            return;
        }
        this.f7991e = com.lxj.xpopup.d.e.Dismissing;
        if (this.B != null) {
            HackyViewPager hackyViewPager = this.u;
            PhotoView photoView = (PhotoView) hackyViewPager.getChildAt(hackyViewPager.getCurrentItem());
            if (photoView != null) {
                Matrix matrix = new Matrix();
                photoView.getSuppMatrix(matrix);
                this.C.setSuppMatrix(matrix);
            }
        }
        f();
    }

    public ImageViewerPopupView c(boolean z) {
        this.D = z;
        return this;
    }

    public ImageViewerPopupView a(List<Object> list) {
        this.w = list;
        return this;
    }

    public ImageViewerPopupView c(int i2) {
        this.F = i2;
        return this;
    }

    public ImageViewerPopupView a(g gVar) {
        this.y = gVar;
        return this;
    }

    public ImageViewerPopupView a(j jVar) {
        this.x = jVar;
        return this;
    }

    public ImageViewerPopupView a(boolean z) {
        this.J = z;
        return this;
    }

    public ImageViewerPopupView a(int i2) {
        this.E = i2;
        return this;
    }

    public ImageViewerPopupView d(boolean z) {
        this.H = z;
        return this;
    }

    public ImageViewerPopupView a(ImageView imageView, Object obj) {
        if (this.w == null) {
            this.w = new ArrayList();
        }
        this.w.clear();
        this.w.add(obj);
        a(imageView, 0);
        return this;
    }

    public ImageViewerPopupView b(boolean z) {
        this.I = z;
        return this;
    }

    public ImageViewerPopupView b(int i2) {
        this.G = i2;
        return this;
    }

    public ImageViewerPopupView a(ImageView imageView, int i2) {
        this.B = imageView;
        this.z = i2;
        if (imageView != null) {
            int[] iArr = new int[2];
            this.B.getLocationInWindow(iArr);
            this.A = new Rect(iArr[0], iArr[1], iArr[0] + imageView.getWidth(), iArr[1] + imageView.getHeight());
        }
        return this;
    }

    public void a(ImageView imageView) {
        a(imageView, this.z);
        v();
    }

    @Override // com.lxj.xpopup.e.d
    public void a() {
        b();
    }

    @Override // com.lxj.xpopup.e.d
    public void a(int i2, float f2, float f3) {
        float f4 = 1.0f - f3;
        this.s.setAlpha(f4);
        View view = this.K;
        if (view != null) {
            view.setAlpha(f4);
        }
        if (this.H) {
            this.t.setAlpha(f4);
        }
        this.q.setBackgroundColor(((Integer) this.v.evaluate(f3 * 0.8f, Integer.valueOf(this.L), 0)).intValue());
    }
}
