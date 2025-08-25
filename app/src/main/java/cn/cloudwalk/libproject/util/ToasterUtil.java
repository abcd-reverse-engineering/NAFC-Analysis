package cn.cloudwalk.libproject.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.Toast;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ToasterUtil {
    public static Toast showToast(Context context, Toast toast, String str, float f2) {
        if (toast != null) {
            toast.cancel();
        }
        Activity activity = (Activity) context;
        Toast toast2 = new Toast(activity);
        toast2.setView(new View(str, activity, f2) { // from class: cn.cloudwalk.libproject.util.ToasterUtil.1RotatedTextView
            private Rect bounds;
            private Paint paint;
            private String text;
            final /* synthetic */ float val$uiRotation;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(activity);
                this.val$uiRotation = f2;
                this.text = "";
                this.paint = new Paint();
                this.bounds = new Rect();
                this.text = str;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f3 = getResources().getDisplayMetrics().density;
                this.paint.setTextSize((18.0f * f3) + 0.5f);
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(Color.rgb(75, 75, 75));
                this.paint.setShadowLayer(1.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
                Paint paint = this.paint;
                String str2 = this.text;
                paint.getTextBounds(str2, 0, str2.length(), this.bounds);
                int i2 = (int) ((14.0f * f3) + 0.5f);
                int i3 = (int) ((f3 * 32.0f) + 0.5f);
                canvas.save();
                canvas.rotate(this.val$uiRotation, canvas.getWidth() / 2, canvas.getHeight() / 2);
                canvas.drawRect((((canvas.getWidth() / 2) - (this.bounds.width() / 2)) + this.bounds.left) - i2, (((canvas.getHeight() / 2) + this.bounds.top) - i2) + i3, ((canvas.getWidth() / 2) - (this.bounds.width() / 2)) + this.bounds.right + i2, (canvas.getHeight() / 2) + this.bounds.bottom + i2 + i3, this.paint);
                this.paint.setColor(-1);
                canvas.drawText(this.text, (canvas.getWidth() / 2) - (this.bounds.width() / 2), (canvas.getHeight() / 2) + i3, this.paint);
                canvas.restore();
            }
        });
        toast2.setDuration(0);
        toast2.show();
        return toast2;
    }

    public static Toast showToast(Activity activity, Toast toast, String str) {
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = new Toast(activity);
        toast2.setView(new View(str, activity) { // from class: cn.cloudwalk.libproject.util.ToasterUtil.2RotatedTextView
            private Rect bounds;
            private Paint paint;
            private String text;

            {
                super(activity);
                this.text = "";
                this.paint = new Paint();
                this.bounds = new Rect();
                this.text = str;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f2 = getResources().getDisplayMetrics().density;
                this.paint.setTextSize((22.0f * f2) + 0.5f);
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(Color.rgb(75, 75, 75));
                this.paint.setShadowLayer(1.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
                Paint paint = this.paint;
                String str2 = this.text;
                paint.getTextBounds(str2, 0, str2.length(), this.bounds);
                int i2 = (int) ((14.0f * f2) + 0.5f);
                int i3 = (int) ((f2 * 32.0f) + 0.5f);
                canvas.save();
                canvas.drawRect((((canvas.getWidth() / 2) - (this.bounds.width() / 2)) + this.bounds.left) - i2, (((canvas.getHeight() / 2) + this.bounds.top) - i2) + i3, ((canvas.getWidth() / 2) - (this.bounds.width() / 2)) + this.bounds.right + i2, (canvas.getHeight() / 2) + this.bounds.bottom + i2 + i3, this.paint);
                this.paint.setColor(-1);
                canvas.drawText(this.text, (canvas.getWidth() / 2) - (this.bounds.width() / 2), (canvas.getHeight() / 2) + i3, this.paint);
                canvas.restore();
            }
        });
        toast2.setDuration(1);
        toast2.show();
        return toast2;
    }

    public static Toast showToast(Context context, Toast toast, String str) {
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = new Toast(context);
        toast2.setView(new View(str, context) { // from class: cn.cloudwalk.libproject.util.ToasterUtil.3RotatedTextView
            private Rect bounds;
            private Paint paint;
            private String text;

            {
                super(context);
                this.text = "";
                this.paint = new Paint();
                this.bounds = new Rect();
                this.text = str;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f2 = getResources().getDisplayMetrics().density;
                this.paint.setTextSize((22.0f * f2) + 0.5f);
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(Color.rgb(75, 75, 75));
                this.paint.setShadowLayer(1.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
                Paint paint = this.paint;
                String str2 = this.text;
                paint.getTextBounds(str2, 0, str2.length(), this.bounds);
                int i2 = (int) ((14.0f * f2) + 0.5f);
                int i3 = (int) ((f2 * 32.0f) + 0.5f);
                canvas.save();
                canvas.drawRect((((canvas.getWidth() / 2) - (this.bounds.width() / 2)) + this.bounds.left) - i2, (((canvas.getHeight() / 2) + this.bounds.top) - i2) + i3, ((canvas.getWidth() / 2) - (this.bounds.width() / 2)) + this.bounds.right + i2, (canvas.getHeight() / 2) + this.bounds.bottom + i2 + i3, this.paint);
                this.paint.setColor(-1);
                canvas.drawText(this.text, (canvas.getWidth() / 2) - (this.bounds.width() / 2), (canvas.getHeight() / 2) + i3, this.paint);
                canvas.restore();
            }
        });
        toast2.setDuration(0);
        toast2.show();
        return toast2;
    }
}
