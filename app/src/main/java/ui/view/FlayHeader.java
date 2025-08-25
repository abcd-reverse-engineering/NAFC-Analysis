package ui.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: classes2.dex */
public class FlayHeader extends InternalAbstract implements com.scwang.smartrefresh.layout.b.g {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f20310d;

    /* renamed from: e, reason: collision with root package name */
    private View f20311e;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20312a = new int[com.scwang.smartrefresh.layout.c.b.values().length];

        static {
            try {
                f20312a[com.scwang.smartrefresh.layout.c.b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20312a[com.scwang.smartrefresh.layout.c.b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20312a[com.scwang.smartrefresh.layout.c.b.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20312a[com.scwang.smartrefresh.layout.c.b.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FlayHeader(Context context, @LayoutRes int i2) {
        this(context, null, i2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public int a(@NonNull com.scwang.smartrefresh.layout.b.j jVar, boolean z) {
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    @SuppressLint({"WrongConstant"})
    public void a(@NonNull com.scwang.smartrefresh.layout.b.j jVar, int i2, int i3) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f20310d, "rotation", 0.0f, 360.0f);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    @NonNull
    public com.scwang.smartrefresh.layout.c.c getSpinnerStyle() {
        return com.scwang.smartrefresh.layout.c.c.Scale;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void setPrimaryColors(int... iArr) {
        for (int i2 : iArr) {
            this.f20311e.setBackgroundColor(i2);
        }
    }

    public FlayHeader(Context context, AttributeSet attributeSet, @LayoutRes int i2) {
        this(context, attributeSet, 0, i2);
    }

    public FlayHeader(Context context, AttributeSet attributeSet, int i2, @LayoutRes int i3) {
        super(context, attributeSet, i2);
        View viewInflate = View.inflate(context, i3, this);
        this.f20310d = (ImageView) viewInflate.findViewById(R.id.header);
        this.f20311e = viewInflate.findViewById(R.id.primary);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.d.f
    public void a(@NonNull com.scwang.smartrefresh.layout.b.j jVar, @NonNull com.scwang.smartrefresh.layout.c.b bVar, @NonNull com.scwang.smartrefresh.layout.c.b bVar2) {
        int i2 = a.f20312a[bVar2.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f20310d.setVisibility(8);
            return;
        }
        if (i2 == 3) {
            this.f20310d.setImageResource(R.drawable.bg_record_time_cut);
        } else {
            if (i2 != 4) {
                return;
            }
            this.f20310d.setVisibility(0);
            this.f20310d.setImageResource(R.drawable.set_loading);
        }
    }
}
