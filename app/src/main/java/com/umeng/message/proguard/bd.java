package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public final class bd extends Button {

    /* renamed from: a, reason: collision with root package name */
    private Paint f11332a;

    /* renamed from: b, reason: collision with root package name */
    private float f11333b;

    /* renamed from: c, reason: collision with root package name */
    private float f11334c;

    /* renamed from: d, reason: collision with root package name */
    private float f11335d;

    /* renamed from: e, reason: collision with root package name */
    private float f11336e;

    /* renamed from: f, reason: collision with root package name */
    private float f11337f;

    /* renamed from: g, reason: collision with root package name */
    private int f11338g;

    public bd(Context context) {
        super(context);
        setBackgroundColor(0);
        this.f11332a = new Paint();
        this.f11338g = bb.a(1.0f);
        this.f11337f = bb.a(2.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f11333b = getWidth() / 2;
        this.f11334c = getHeight() / 2;
        this.f11335d = (Math.min(getHeight(), getWidth()) / 2) - this.f11338g;
        this.f11336e = this.f11335d / 1.4142f;
        this.f11332a.setAntiAlias(true);
        this.f11332a.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f11332a.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.f11333b, this.f11334c, this.f11335d, this.f11332a);
        this.f11332a.setColor(-1);
        this.f11332a.setStrokeWidth(this.f11337f);
        this.f11332a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(this.f11333b, this.f11334c, this.f11335d, this.f11332a);
        float f2 = this.f11333b;
        float f3 = this.f11336e;
        float f4 = this.f11334c;
        canvas.drawLine(f2 - f3, f4 - f3, f2 + f3, f4 + f3, this.f11332a);
        float f5 = this.f11333b;
        float f6 = this.f11336e;
        float f7 = this.f11334c;
        canvas.drawLine(f5 + f6, f7 - f6, f5 - f6, f7 + f6, this.f11332a);
    }
}
