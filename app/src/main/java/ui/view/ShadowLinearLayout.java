package ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class ShadowLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Paint f20432a;

    /* renamed from: b, reason: collision with root package name */
    private RectF f20433b;

    /* renamed from: c, reason: collision with root package name */
    private float f20434c;

    /* renamed from: d, reason: collision with root package name */
    private int f20435d;

    /* renamed from: e, reason: collision with root package name */
    private int f20436e;

    public ShadowLinearLayout(Context context) {
        this(context, null);
    }

    public void a() {
        int i2 = (int) this.f20434c;
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(this.f20436e);
        this.f20432a = new Paint();
        setLayerType(1, this.f20432a);
        this.f20432a.setColor(-1);
        this.f20432a.setShadowLayer(this.f20434c, 5.0f, 5.0f, this.f20435d);
        this.f20432a.setAntiAlias(true);
        this.f20433b = new RectF();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f20433b;
        float f2 = this.f20434c + 0.0f;
        rectF.top = f2;
        rectF.left = f2;
        rectF.bottom = getMeasuredHeight() - this.f20434c;
        RectF rectF2 = this.f20433b;
        float measuredWidth = getMeasuredWidth();
        float f3 = this.f20434c;
        rectF2.right = measuredWidth - f3;
        canvas.drawRoundRect(this.f20433b, f3, f3, this.f20432a);
    }

    public ShadowLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.shadowlayout);
        this.f20435d = typedArrayObtainStyledAttributes.getColor(1, -16776961);
        this.f20436e = typedArrayObtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK);
        this.f20434c = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 3);
        a();
    }
}
