package com.luozm.captcha;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.luozm.captcha.PictureVertifyView;
import com.luozm.captcha.a;

/* loaded from: classes.dex */
public class Captcha extends LinearLayout {
    public static final int s = -100;
    public static final int t = 1;
    public static final int u = 2;

    /* renamed from: a, reason: collision with root package name */
    private PictureVertifyView f7829a;

    /* renamed from: b, reason: collision with root package name */
    private TextSeekbar f7830b;

    /* renamed from: c, reason: collision with root package name */
    private View f7831c;

    /* renamed from: d, reason: collision with root package name */
    private View f7832d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f7833e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f7834f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f7835g;

    /* renamed from: h, reason: collision with root package name */
    private int f7836h;

    /* renamed from: i, reason: collision with root package name */
    private int f7837i;

    /* renamed from: j, reason: collision with root package name */
    private int f7838j;

    /* renamed from: k, reason: collision with root package name */
    private int f7839k;

    /* renamed from: l, reason: collision with root package name */
    private int f7840l;

    /* renamed from: m, reason: collision with root package name */
    private int f7841m;
    private int n;
    private boolean o;
    private boolean p;
    private f q;
    private com.luozm.captcha.a r;

    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (Captcha.this.p) {
                Captcha.this.p = false;
                if (i2 > 10) {
                    Captcha.this.o = false;
                } else {
                    Captcha.this.o = true;
                    Captcha.this.f7832d.setVisibility(8);
                    Captcha.this.f7829a.a(0);
                }
            }
            if (Captcha.this.o) {
                Captcha.this.f7829a.b(i2);
            } else {
                seekBar.setProgress(0);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Captcha.this.p = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (Captcha.this.o) {
                Captcha.this.f7829a.b();
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Captcha.this.a(view);
        }
    }

    class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (Captcha.this.q != null) {
                Captcha.this.q.a(-100);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class e implements a.InterfaceC0111a {
        e() {
        }

        @Override // com.luozm.captcha.a.InterfaceC0111a
        public void a(Bitmap bitmap) {
            Captcha.this.setBitmap(bitmap);
        }
    }

    public interface f {
        String a();

        String a(int i2);

        String a(long j2);
    }

    public @interface g {
    }

    public Captcha(@NonNull Context context) {
        super(context);
        this.f7836h = -1;
    }

    public int getMaxFailedCount() {
        return this.f7840l;
    }

    public int getMode() {
        return this.f7839k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.luozm.captcha.a aVar = this.r;
        if (aVar != null && aVar.getStatus().equals(AsyncTask.Status.RUNNING)) {
            this.r.cancel(true);
        }
        super.onDetachedFromWindow();
    }

    public void setBitmap(int i2) {
        setBitmap(BitmapFactory.decodeResource(getResources(), i2));
    }

    public void setBlockSize(int i2) {
        this.f7829a.c(i2);
    }

    public void setCaptchaListener(f fVar) {
        this.q = fVar;
    }

    public void setCaptchaStrategy(com.luozm.captcha.d dVar) {
        if (dVar != null) {
            this.f7829a.a(dVar);
        }
    }

    public void setMaxFailedCount(int i2) {
        this.f7840l = i2;
    }

    public void setMode(@g int i2) {
        this.f7839k = i2;
        this.f7829a.d(i2);
        if (this.f7839k == 2) {
            this.f7830b.setVisibility(8);
            this.f7829a.a(true);
        } else {
            this.f7830b.setVisibility(0);
            this.f7830b.setEnabled(true);
        }
        b();
    }

    private void c() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.container, (ViewGroup) this, true);
        this.f7829a = (PictureVertifyView) viewInflate.findViewById(R.id.vertifyView);
        this.f7830b = (TextSeekbar) viewInflate.findViewById(R.id.seekbar);
        this.f7831c = viewInflate.findViewById(R.id.accessRight);
        this.f7832d = viewInflate.findViewById(R.id.accessFailed);
        this.f7833e = (TextView) viewInflate.findViewById(R.id.accessText);
        this.f7834f = (TextView) viewInflate.findViewById(R.id.accessFailedText);
        this.f7835g = (ImageView) viewInflate.findViewById(R.id.refresh);
        setMode(this.f7839k);
        int i2 = this.f7836h;
        if (i2 != -1) {
            this.f7829a.setImageResource(i2);
        }
        setBlockSize(this.n);
        this.f7829a.a(new a());
        a(this.f7837i, this.f7838j);
        this.f7830b.setOnSeekBarChangeListener(new b());
        this.f7835g.setOnClickListener(new c());
    }

    public Captcha(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b() {
        this.f7832d.setVisibility(8);
        this.f7831c.setVisibility(8);
    }

    public void setBitmap(Bitmap bitmap) {
        this.f7829a.setImageBitmap(bitmap);
        a(false);
    }

    public Captcha(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f7836h = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Captcha);
        this.f7836h = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Captcha_src, R.drawable.container_backgroud);
        this.f7837i = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Captcha_progressDrawable, R.drawable.po_seekbar);
        this.f7838j = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Captcha_thumbDrawable, R.drawable.iv_tc_thumb);
        this.f7839k = typedArrayObtainStyledAttributes.getInteger(R.styleable.Captcha_mode, 1);
        this.f7840l = typedArrayObtainStyledAttributes.getInteger(R.styleable.Captcha_max_fail_count, 3);
        this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Captcha_blockSize, com.luozm.captcha.c.a(getContext(), 50.0f));
        typedArrayObtainStyledAttributes.recycle();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        view.animate().rotationBy(360.0f).setDuration(500L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new d());
    }

    public void setBitmap(String str) {
        this.r = new com.luozm.captcha.a(new e());
        this.r.execute(str);
    }

    class a implements PictureVertifyView.a {
        a() {
        }

        @Override // com.luozm.captcha.PictureVertifyView.a
        public void a(long j2) {
            if (Captcha.this.q != null) {
                String strA = Captcha.this.q.a(j2);
                if (strA != null) {
                    Captcha.this.f7833e.setText(strA);
                } else {
                    Captcha.this.f7833e.setText(String.format(Captcha.this.getResources().getString(R.string.vertify_access), Long.valueOf(j2)));
                }
            }
            Captcha.this.f7831c.setVisibility(0);
            Captcha.this.f7832d.setVisibility(8);
        }

        @Override // com.luozm.captcha.PictureVertifyView.a
        public void a() {
            Captcha.this.f7830b.setEnabled(false);
            Captcha.this.f7829a.a(false);
            Captcha captcha = Captcha.this;
            captcha.f7841m = captcha.f7841m > Captcha.this.f7840l ? Captcha.this.f7840l : Captcha.this.f7841m + 1;
            Captcha.this.f7832d.setVisibility(0);
            Captcha.this.f7831c.setVisibility(8);
            if (Captcha.this.q != null) {
                if (Captcha.this.f7841m == Captcha.this.f7840l) {
                    String strA = Captcha.this.q.a();
                    if (strA != null) {
                        Captcha.this.f7834f.setText(strA);
                        return;
                    } else {
                        Captcha.this.f7834f.setText(String.format(Captcha.this.getResources().getString(R.string.vertify_failed), Integer.valueOf(Captcha.this.f7840l - Captcha.this.f7841m)));
                        return;
                    }
                }
                String strA2 = Captcha.this.q.a(Captcha.this.f7841m);
                if (strA2 != null) {
                    Captcha.this.f7834f.setText(strA2);
                } else {
                    Captcha.this.f7834f.setText(String.format(Captcha.this.getResources().getString(R.string.vertify_failed), Integer.valueOf(Captcha.this.f7840l - Captcha.this.f7841m)));
                }
            }
        }
    }

    public void a(@DrawableRes int i2, @DrawableRes int i3) {
        this.f7830b.setProgressDrawable(getResources().getDrawable(i2));
        this.f7830b.setThumb(getResources().getDrawable(i3));
        this.f7830b.setThumbOffset(0);
    }

    public void a() {
        a(this.f7835g);
    }

    public void a(boolean z) {
        b();
        this.f7829a.c();
        if (z) {
            this.f7841m = 0;
        }
        if (this.f7839k == 1) {
            this.f7830b.setEnabled(true);
            this.f7830b.setProgress(0);
        } else {
            this.f7829a.a(true);
        }
    }
}
