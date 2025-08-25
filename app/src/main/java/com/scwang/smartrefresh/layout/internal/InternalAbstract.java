package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.b.f;
import com.scwang.smartrefresh.layout.b.g;
import com.scwang.smartrefresh.layout.b.h;
import com.scwang.smartrefresh.layout.b.i;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;

/* loaded from: classes.dex */
public abstract class InternalAbstract extends RelativeLayout implements h {

    /* renamed from: a, reason: collision with root package name */
    protected View f8333a;

    /* renamed from: b, reason: collision with root package name */
    protected com.scwang.smartrefresh.layout.c.c f8334b;

    /* renamed from: c, reason: collision with root package name */
    protected h f8335c;

    /* JADX WARN: Multi-variable type inference failed */
    protected InternalAbstract(@NonNull View view) {
        this(view, view instanceof h ? (h) view : null);
    }

    public int a(@NonNull j jVar, boolean z) {
        h hVar = this.f8335c;
        if (hVar == null || hVar == this) {
            return 0;
        }
        return hVar.a(jVar, z);
    }

    public void b(@NonNull j jVar, int i2, int i3) {
        h hVar = this.f8335c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.b(jVar, i2, i3);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof h) && getView() == ((h) obj).getView();
    }

    @Override // com.scwang.smartrefresh.layout.b.h
    @NonNull
    public com.scwang.smartrefresh.layout.c.c getSpinnerStyle() {
        int i2;
        com.scwang.smartrefresh.layout.c.c cVar = this.f8334b;
        if (cVar != null) {
            return cVar;
        }
        h hVar = this.f8335c;
        if (hVar != null && hVar != this) {
            return hVar.getSpinnerStyle();
        }
        View view = this.f8333a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.m) {
                this.f8334b = ((SmartRefreshLayout.m) layoutParams).f8260b;
                com.scwang.smartrefresh.layout.c.c cVar2 = this.f8334b;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            if (layoutParams != null && ((i2 = layoutParams.height) == 0 || i2 == -1)) {
                com.scwang.smartrefresh.layout.c.c cVar3 = com.scwang.smartrefresh.layout.c.c.Scale;
                this.f8334b = cVar3;
                return cVar3;
            }
        }
        com.scwang.smartrefresh.layout.c.c cVar4 = com.scwang.smartrefresh.layout.c.c.Translate;
        this.f8334b = cVar4;
        return cVar4;
    }

    @Override // com.scwang.smartrefresh.layout.b.h
    @NonNull
    public View getView() {
        View view = this.f8333a;
        return view == null ? this : view;
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        h hVar = this.f8335c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.setPrimaryColors(iArr);
    }

    protected InternalAbstract(@NonNull View view, @Nullable h hVar) {
        super(view.getContext(), null, 0);
        this.f8333a = view;
        this.f8335c = hVar;
    }

    public void a(@NonNull i iVar, int i2, int i3) {
        h hVar = this.f8335c;
        if (hVar != null && hVar != this) {
            hVar.a(iVar, i2, i3);
            return;
        }
        View view = this.f8333a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.m) {
                iVar.a(this, ((SmartRefreshLayout.m) layoutParams).f8259a);
            }
        }
    }

    protected InternalAbstract(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean a() {
        h hVar = this.f8335c;
        return (hVar == null || hVar == this || !hVar.a()) ? false : true;
    }

    public void a(float f2, int i2, int i3) {
        h hVar = this.f8335c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.a(f2, i2, i3);
    }

    public void a(boolean z, float f2, int i2, int i3, int i4) {
        h hVar = this.f8335c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.a(z, f2, i2, i3, i4);
    }

    public void a(@NonNull j jVar, int i2, int i3) {
        h hVar = this.f8335c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.a(jVar, i2, i3);
    }

    public void a(@NonNull j jVar, @NonNull com.scwang.smartrefresh.layout.c.b bVar, @NonNull com.scwang.smartrefresh.layout.c.b bVar2) {
        h hVar = this.f8335c;
        if (hVar == null || hVar == this) {
            return;
        }
        if ((this instanceof RefreshFooterWrapper) && (hVar instanceof g)) {
            if (bVar.isFooter) {
                bVar = bVar.toHeader();
            }
            if (bVar2.isFooter) {
                bVar2 = bVar2.toHeader();
            }
        } else if ((this instanceof RefreshHeaderWrapper) && (this.f8335c instanceof f)) {
            if (bVar.isHeader) {
                bVar = bVar.toFooter();
            }
            if (bVar2.isHeader) {
                bVar2 = bVar2.toFooter();
            }
        }
        h hVar2 = this.f8335c;
        if (hVar2 != null) {
            hVar2.a(jVar, bVar, bVar2);
        }
    }
}
