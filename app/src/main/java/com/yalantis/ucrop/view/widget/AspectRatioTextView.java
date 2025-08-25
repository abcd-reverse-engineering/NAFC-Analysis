package com.yalantis.ucrop.view.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AspectRatioTextView extends AppCompatTextView {
    private final float MARGIN_MULTIPLIER;
    private float mAspectRatio;
    private String mAspectRatioTitle;
    private float mAspectRatioX;
    private float mAspectRatioY;
    private final Rect mCanvasClipBounds;
    private Paint mDotPaint;
    private int mDotSize;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    private void applyActiveColor(@ColorInt int i2) {
        Paint paint = this.mDotPaint;
        if (paint != null) {
            paint.setColor(i2);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{0}}, new int[]{i2, ContextCompat.getColor(getContext(), com.yalantis.ucrop.R.color.ucrop_color_widget)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void init(@androidx.annotation.NonNull android.content.res.TypedArray r6) {
        /*
            r5 = this;
            r0 = 1
            r5.setGravity(r0)
            int r1 = com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title
            java.lang.String r1 = r6.getString(r1)
            r5.mAspectRatioTitle = r1
            int r1 = com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x
            r2 = 0
            float r1 = r6.getFloat(r1, r2)
            r5.mAspectRatioX = r1
            int r1 = com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y
            float r1 = r6.getFloat(r1, r2)
            r5.mAspectRatioY = r1
            float r1 = r5.mAspectRatioX
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 == 0) goto L2e
            float r3 = r5.mAspectRatioY
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 != 0) goto L2a
            goto L2e
        L2a:
            float r1 = r1 / r3
            r5.mAspectRatio = r1
            goto L30
        L2e:
            r5.mAspectRatio = r2
        L30:
            android.content.Context r1 = r5.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.yalantis.ucrop.R.dimen.ucrop_size_dot_scale_text_view
            int r1 = r1.getDimensionPixelSize(r2)
            r5.mDotSize = r1
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>(r0)
            r5.mDotPaint = r1
            android.graphics.Paint r0 = r5.mDotPaint
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r0.setStyle(r1)
            r5.setTitle()
            android.content.res.Resources r0 = r5.getResources()
            int r1 = com.yalantis.ucrop.R.color.ucrop_color_widget_active
            int r0 = r0.getColor(r1)
            r5.applyActiveColor(r0)
            r6.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.view.widget.AspectRatioTextView.init(android.content.res.TypedArray):void");
    }

    private void setTitle() {
        if (TextUtils.isEmpty(this.mAspectRatioTitle)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.mAspectRatioX), Integer.valueOf((int) this.mAspectRatioY)));
        } else {
            setText(this.mAspectRatioTitle);
        }
    }

    private void toggleAspectRatio() {
        if (this.mAspectRatio != 0.0f) {
            float f2 = this.mAspectRatioX;
            this.mAspectRatioX = this.mAspectRatioY;
            this.mAspectRatioY = f2;
            this.mAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
        }
    }

    public float getAspectRatio(boolean z) {
        if (z) {
            toggleAspectRatio();
            setTitle();
        }
        return this.mAspectRatio;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.mCanvasClipBounds);
            Rect rect = this.mCanvasClipBounds;
            float f2 = (rect.right - rect.left) / 2.0f;
            float f3 = rect.bottom - (rect.top / 2.0f);
            int i2 = this.mDotSize;
            canvas.drawCircle(f2, f3 - (i2 * 1.5f), i2 / 2.0f, this.mDotPaint);
        }
    }

    public void setActiveColor(@ColorInt int i2) {
        applyActiveColor(i2);
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setAspectRatio(@androidx.annotation.NonNull com.yalantis.ucrop.model.AspectRatio r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.getAspectRatioTitle()
            r3.mAspectRatioTitle = r0
            float r0 = r4.getAspectRatioX()
            r3.mAspectRatioX = r0
            float r4 = r4.getAspectRatioY()
            r3.mAspectRatioY = r4
            float r4 = r3.mAspectRatioX
            r0 = 0
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r1 == 0) goto L24
            float r1 = r3.mAspectRatioY
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 != 0) goto L20
            goto L24
        L20:
            float r4 = r4 / r1
            r3.mAspectRatio = r4
            goto L26
        L24:
            r3.mAspectRatio = r0
        L26:
            r3.setTitle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.view.widget.AspectRatioTextView.setAspectRatio(com.yalantis.ucrop.model.AspectRatio):void");
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new Rect();
        init(context.obtainStyledAttributes(attributeSet, com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView));
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new Rect();
        init(context.obtainStyledAttributes(attributeSet, com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView));
    }
}
