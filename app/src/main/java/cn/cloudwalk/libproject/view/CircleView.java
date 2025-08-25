package cn.cloudwalk.libproject.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import cn.cloudwalk.libproject.R;

/* loaded from: classes.dex */
public class CircleView extends View {
    private float innerRadius;
    Paint mTimePaint;
    Paint paint;
    private int radius;

    public CircleView(Context context) {
        super(context);
        this.innerRadius = 0.0f;
        initView();
    }

    private void drawCircle(Canvas canvas) {
        canvas.save();
        int i2 = this.radius;
        canvas.translate(i2, i2);
        canvas.drawCircle(0.0f, 0.0f, this.radius, this.mTimePaint);
        canvas.restore();
        canvas.save();
        int i3 = this.radius;
        canvas.translate(i3, i3);
        canvas.drawCircle(0.0f, 0.0f, this.innerRadius, this.paint);
        canvas.restore();
    }

    private void initView() {
        setLayerType(1, null);
        this.paint = new Paint(1);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.paint.setAntiAlias(true);
        this.mTimePaint = new Paint();
        this.mTimePaint.setAntiAlias(true);
        this.mTimePaint.setStrokeWidth(4.0f);
        this.mTimePaint.setColor(getResources().getColor(R.color.color_black));
        this.mTimePaint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawCircle(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.radius = Math.min(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3)) / 2;
        int i4 = this.radius;
        setMeasuredDimension(i4 * 2, i4 * 2);
    }

    public void setInnerRadius(float f2) {
        this.innerRadius = f2;
        invalidate();
    }

    public void setRadius(int i2) {
        this.radius = i2;
        invalidate();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.innerRadius = 0.0f;
        initView();
    }

    public CircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.innerRadius = 0.0f;
        initView();
    }

    public CircleView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.innerRadius = 0.0f;
        initView();
    }
}
