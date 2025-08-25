package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.b.g;
import com.scwang.smartrefresh.layout.b.i;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.c.b;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: classes.dex */
public class FalsifyHeader extends InternalAbstract implements g {

    /* renamed from: d, reason: collision with root package name */
    protected i f8308d;

    public FalsifyHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(@NonNull i iVar, int i2, int i3) {
        this.f8308d = iVar;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void b(@NonNull j jVar, int i2, int i3) {
        i iVar = this.f8308d;
        if (iVar != null) {
            iVar.a(b.None);
            this.f8308d.a(b.RefreshFinish);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int iB = com.scwang.smartrefresh.layout.e.b.b(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-858993460);
            paint.setStrokeWidth(com.scwang.smartrefresh.layout.e.b.b(1.0f));
            float f2 = iB;
            paint.setPathEffect(new DashPathEffect(new float[]{f2, f2, f2, f2}, 1.0f));
            canvas.drawRect(f2, f2, getWidth() - iB, getBottom() - iB, paint);
            TextView textView = new TextView(getContext());
            textView.setText(getResources().getString(R.string.srl_component_falsify, FalsifyHeader.class.getSimpleName(), Float.valueOf(com.scwang.smartrefresh.layout.e.b.b(getHeight()))));
            textView.setTextColor(-858993460);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
