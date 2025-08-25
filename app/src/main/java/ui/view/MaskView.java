package ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class MaskView extends AppCompatImageView {

    /* renamed from: k, reason: collision with root package name */
    private static final String f20355k = MaskView.class.getSimpleName();

    /* renamed from: l, reason: collision with root package name */
    private static final int f20356l = -1;

    /* renamed from: m, reason: collision with root package name */
    private static final int f20357m = 1;
    private static final int n = 30;
    private static final int o = 16777215;
    private static final int p = 255;

    /* renamed from: a, reason: collision with root package name */
    private Paint f20358a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f20359b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f20360c;

    /* renamed from: d, reason: collision with root package name */
    private int f20361d;

    /* renamed from: e, reason: collision with root package name */
    private int f20362e;

    /* renamed from: f, reason: collision with root package name */
    private int f20363f;

    /* renamed from: g, reason: collision with root package name */
    private int f20364g;

    /* renamed from: h, reason: collision with root package name */
    private int f20365h;

    /* renamed from: i, reason: collision with root package name */
    private int f20366i;

    /* renamed from: j, reason: collision with root package name */
    private int f20367j;

    public MaskView(Context context) {
        super(context);
        this.f20360c = null;
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.cameView_MaskView, i2, 0);
        this.f20363f = typedArrayObtainStyledAttributes.getColor(3, -1);
        this.f20364g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, 1);
        this.f20365h = typedArrayObtainStyledAttributes.getInt(2, 30);
        this.f20366i = typedArrayObtainStyledAttributes.getColor(1, 16777215);
        this.f20367j = typedArrayObtainStyledAttributes.getInt(0, 255);
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f20360c;
        if (rectF == null) {
            return;
        }
        float fWidth = rectF.width();
        float fHeight = this.f20360c.height();
        float fMin = Math.min(fWidth, fHeight) / 2.0f;
        RectF rectF2 = this.f20360c;
        float f2 = rectF2.left + (fWidth / 2.0f);
        float f3 = rectF2.top + (fHeight / 2.0f);
        float f4 = f3 - fMin;
        canvas.drawRect(0.0f, 0.0f, this.f20361d, f4, this.f20359b);
        float f5 = f2 - fMin;
        float f6 = f3 + fMin;
        canvas.drawRect(0.0f, f4, f5, f6, this.f20359b);
        canvas.drawRect(0.0f, f6, this.f20361d, this.f20362e, this.f20359b);
        float f7 = f2 + fMin;
        canvas.drawRect(f7, f4, this.f20361d, f6, this.f20359b);
        Paint paint = new Paint();
        paint.setStrokeWidth(fMin / 2.0f);
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.f20366i);
        paint.setColor(getResources().getColor(R.color.white));
        paint.setAlpha(this.f20367j);
        RectF rectF3 = new RectF();
        float f8 = 1.25f * fMin;
        rectF3.left = f2 - f8;
        rectF3.top = f3 - f8;
        rectF3.right = f2 + f8;
        rectF3.bottom = f8 + f3;
        canvas.drawArc(rectF3, 360.0f, 360.0f, false, paint);
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(8);
        paint2.setColor(getResources().getColor(R.color.circle_blue));
        paint2.setFlags(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAlpha(this.f20367j);
        RectF rectF4 = new RectF();
        float f9 = 4;
        float f10 = 12;
        rectF4.left = (f5 - f9) - f10;
        rectF4.top = (f4 - f9) - f10;
        rectF4.right = f7 + f9 + f10;
        rectF4.bottom = f6 + f9 + f10;
        canvas.drawArc(rectF4, 360.0f, 360.0f, false, paint2);
        canvas.drawCircle(f2, f3, fMin, this.f20358a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f20361d = getMeasuredWidth();
        this.f20362e = getMeasuredHeight();
    }

    public void setCenterRect(RectF rectF) {
        this.f20360c = rectF;
        postInvalidate();
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20360c = null;
        a(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20360c = null;
        a(context, attributeSet, i2);
    }

    private void a() {
        this.f20358a = new Paint(1);
        this.f20358a.setColor(this.f20363f);
        this.f20358a.setStyle(Paint.Style.STROKE);
        this.f20358a.setStrokeWidth(this.f20364g);
        this.f20358a.setAlpha(this.f20365h);
        this.f20359b = new Paint(1);
        this.f20359b.setColor(this.f20366i);
        this.f20359b.setStyle(Paint.Style.FILL);
        this.f20359b.setAlpha(this.f20367j);
    }
}
