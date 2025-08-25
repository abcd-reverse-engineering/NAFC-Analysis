package ui.view.signature;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class GestureSignatureView extends View {

    /* renamed from: i, reason: collision with root package name */
    private static final String f20645i = "GestureSignatureView";

    /* renamed from: a, reason: collision with root package name */
    private Context f20646a;

    /* renamed from: b, reason: collision with root package name */
    private Path f20647b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f20648c;

    /* renamed from: d, reason: collision with root package name */
    private Canvas f20649d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f20650e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20651f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f20652g;

    /* renamed from: h, reason: collision with root package name */
    private float[] f20653h;

    public GestureSignatureView(Context context) {
        this(context, null);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private void b() {
        this.f20648c = new Paint(1);
        this.f20648c.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f20648c.setStrokeWidth(10.0f);
        this.f20648c.setStrokeCap(Paint.Cap.ROUND);
        this.f20648c.setStyle(Paint.Style.STROKE);
        this.f20648c.setStrokeJoin(Paint.Join.ROUND);
        this.f20648c.setDither(true);
        this.f20647b = new Path();
    }

    public Bitmap getPaintBitmap() {
        return a(this.f20650e, 320, 480);
    }

    public boolean getTouched() {
        return this.f20651f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(this.f20650e, 0.0f, 0.0f, this.f20648c);
        canvas.drawPath(this.f20647b, this.f20648c);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f20650e = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f20649d = new Canvas(this.f20650e);
        this.f20649d.drawColor(0);
        this.f20649d.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        this.f20651f = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        String str = "onMeasure: 测量的宽高：" + getMeasuredWidth() + "-----------" + getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f20652g[0] = motionEvent.getX();
        this.f20652g[1] = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            float[] fArr = this.f20653h;
            float[] fArr2 = this.f20652g;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            this.f20647b.moveTo(fArr2[0], fArr2[1]);
        } else if (action == 1) {
            this.f20649d.drawPath(this.f20647b, this.f20648c);
            this.f20647b.reset();
        } else if (action == 2) {
            float fAbs = Math.abs(this.f20652g[0] - this.f20653h[0]);
            float fAbs2 = Math.abs(this.f20652g[1] - this.f20653h[1]);
            if (fAbs >= 3.0f || fAbs2 >= 3.0f) {
                float[] fArr3 = this.f20652g;
                float f2 = fArr3[0];
                float[] fArr4 = this.f20653h;
                this.f20647b.quadTo(fArr4[0], fArr4[1], (f2 + fArr4[0]) / 2.0f, (fArr3[1] + fArr4[1]) / 2.0f);
                float[] fArr5 = this.f20653h;
                float[] fArr6 = this.f20652g;
                fArr5[0] = fArr6[0];
                fArr5[1] = fArr6[1];
                this.f20651f = true;
            }
        }
        invalidate();
        return true;
    }

    public GestureSignatureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureSignatureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20651f = false;
        this.f20652g = new float[2];
        this.f20653h = new float[2];
        this.f20646a = context;
        b();
    }

    public void a() {
        if (this.f20649d != null) {
            this.f20651f = false;
            this.f20647b.reset();
            this.f20649d.drawColor(0, PorterDuff.Mode.CLEAR);
            invalidate();
        }
    }

    public void a(String str) throws IOException {
        a(str, false, 0);
    }

    @SuppressLint({"WrongThread"})
    public void a(String str, boolean z, int i2) throws IOException {
        Bitmap bitmapA = this.f20650e;
        if (z) {
            bitmapA = a(bitmapA, i2);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapA.getWidth(), bitmapA.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-1);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(bitmapA, 0.0f, 0.0f, (Paint) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray != null) {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArray);
            fileOutputStream.close();
            a(file);
        }
    }

    private Bitmap a(Bitmap bitmap, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int[] iArr = new int[width];
        int i3 = 0;
        for (int i4 = 0; i4 < height; i4++) {
            bitmap.getPixels(iArr, 0, width, 0, i4, width, 1);
            int length = iArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z4 = false;
                    break;
                }
                if (iArr[i5] != 0) {
                    i3 = i4;
                    z4 = true;
                    break;
                }
                i5++;
            }
            if (z4) {
                break;
            }
        }
        int i6 = height - 1;
        int i7 = 0;
        for (int i8 = i6; i8 >= 0; i8--) {
            bitmap.getPixels(iArr, 0, width, 0, i8, width, 1);
            int length2 = iArr.length;
            int i9 = 0;
            while (true) {
                if (i9 >= length2) {
                    z3 = false;
                    break;
                }
                if (iArr[i9] != 0) {
                    i7 = i8;
                    z3 = true;
                    break;
                }
                i9++;
            }
            if (z3) {
                break;
            }
        }
        int[] iArr2 = new int[height];
        int i10 = 0;
        for (int i11 = 0; i11 < width; i11++) {
            bitmap.getPixels(iArr2, 0, 1, i11, 0, 1, height);
            int length3 = iArr2.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length3) {
                    z2 = false;
                    break;
                }
                if (iArr2[i12] != 0) {
                    i10 = i11;
                    z2 = true;
                    break;
                }
                i12++;
            }
            if (z2) {
                break;
            }
        }
        int i13 = width - 1;
        int i14 = 0;
        for (int i15 = i13; i15 > 0; i15--) {
            bitmap.getPixels(iArr2, 0, 1, i15, 0, 1, height);
            int length4 = iArr2.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length4) {
                    z = false;
                    break;
                }
                if (iArr2[i16] != 0) {
                    i14 = i15;
                    z = true;
                    break;
                }
                i16++;
            }
            if (z) {
                break;
            }
        }
        int i17 = i2 < 0 ? 0 : i2;
        int i18 = i10 - i17;
        if (i18 <= 0) {
            i18 = 0;
        }
        int i19 = i3 - i17;
        if (i19 <= 0) {
            i19 = 0;
        }
        int i20 = i14 + i17;
        if (i20 > i13) {
            i20 = i13;
        }
        int i21 = i7 + i17;
        if (i21 > i6) {
            i21 = i6;
        }
        return Bitmap.createBitmap(bitmap, i18, i19, i20 - i18, i21 - i19);
    }

    private void a(File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        getContext().sendBroadcast(intent);
    }
}
