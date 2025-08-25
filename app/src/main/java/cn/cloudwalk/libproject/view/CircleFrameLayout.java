package cn.cloudwalk.libproject.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.cloudwalk.libproject.R;

/* loaded from: classes.dex */
public class CircleFrameLayout extends FrameLayout {
    private Paint mPaint;
    private Bitmap srcBitmap;

    public CircleFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        if (Build.VERSION.SDK_INT <= 21) {
            this.mPaint = new Paint();
            this.srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cloudwalk_perview_circle);
        }
    }

    private Bitmap zoomBitmap() {
        float measuredWidth = (getMeasuredWidth() * 1.0f) / this.srcBitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(measuredWidth, measuredWidth);
        Bitmap bitmap = this.srcBitmap;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.srcBitmap.getHeight(), matrix, true);
        this.srcBitmap.recycle();
        this.srcBitmap = bitmapCreateBitmap;
        return this.srcBitmap;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        boolean zDrawChild = super.drawChild(canvas, view, j2);
        if (Build.VERSION.SDK_INT <= 21) {
            canvas.drawBitmap(zoomBitmap(), 0.0f, 0.0f, this.mPaint);
        }
        return zDrawChild;
    }
}
