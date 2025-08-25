package ui.view.signature;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public class SignatureView extends View {

    /* renamed from: h, reason: collision with root package name */
    private static final float f20660h = 5.0f;

    /* renamed from: i, reason: collision with root package name */
    private static final float f20661i = 2.5f;

    /* renamed from: a, reason: collision with root package name */
    private Paint f20662a;

    /* renamed from: b, reason: collision with root package name */
    private Path f20663b;

    /* renamed from: c, reason: collision with root package name */
    private float f20664c;

    /* renamed from: d, reason: collision with root package name */
    private float f20665d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f20666e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f20667f;

    /* renamed from: g, reason: collision with root package name */
    private Canvas f20668g;

    public SignatureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20662a = new Paint();
        this.f20663b = new Path();
        this.f20666e = new RectF();
        this.f20662a.setAntiAlias(true);
        this.f20662a.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f20662a.setStyle(Paint.Style.STROKE);
        this.f20662a.setStrokeJoin(Paint.Join.ROUND);
        this.f20662a.setStrokeWidth(f20660h);
        this.f20662a.setDither(true);
    }

    private void b(float f2, float f3) {
        this.f20666e.left = Math.min(this.f20664c, f2);
        this.f20666e.right = Math.max(this.f20664c, f2);
        this.f20666e.top = Math.min(this.f20665d, f3);
        this.f20666e.bottom = Math.max(this.f20665d, f3);
    }

    public void a() {
        this.f20663b.reset();
        invalidate();
    }

    public Bitmap getPaintBitmap() {
        return a(this.f20667f, 320, 480);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f20668g.drawPath(this.f20663b, this.f20662a);
        canvas.drawBitmap(this.f20667f, 0.0f, 0.0f, this.f20662a);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f20667f = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f20668g = new Canvas(this.f20667f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f20663b.moveTo(x, y);
            this.f20664c = x;
            this.f20665d = y;
            return true;
        }
        if (action != 1 && action != 2) {
            return false;
        }
        b(x, y);
        int historySize = motionEvent.getHistorySize();
        for (int i2 = 0; i2 < historySize; i2++) {
            float historicalX = motionEvent.getHistoricalX(i2);
            float historicalY = motionEvent.getHistoricalY(i2);
            a(historicalX, historicalY);
            this.f20663b.lineTo(historicalX, historicalY);
        }
        this.f20663b.quadTo(x, y, this.f20664c, this.f20665d);
        RectF rectF = this.f20666e;
        invalidate((int) (rectF.left - f20661i), (int) (rectF.top - f20661i), (int) (rectF.right + f20661i), (int) (rectF.bottom + f20661i));
        this.f20664c = x;
        this.f20665d = y;
        return true;
    }

    private void a(float f2, float f3) {
        RectF rectF = this.f20666e;
        if (f2 < rectF.left) {
            rectF.left = f2;
        } else if (f2 > rectF.right) {
            rectF.right = f2;
        }
        RectF rectF2 = this.f20666e;
        if (f3 < rectF2.top) {
            rectF2.top = f3;
        } else if (f3 > rectF2.bottom) {
            rectF2.bottom = f3;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
