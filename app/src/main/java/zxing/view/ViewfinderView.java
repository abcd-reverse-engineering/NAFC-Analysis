package zxing.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import c.b.c.t;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import m.a.d;

/* loaded from: classes2.dex */
public final class ViewfinderView extends View {
    private static final int[] o = {0, 64, 128, 192, 255, 192, 128, 64};
    private static final long p = 80;
    private static final int q = 160;
    private static final int r = 20;
    private static final int s = 6;

    /* renamed from: a, reason: collision with root package name */
    private d f21140a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f21141b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f21142c;

    /* renamed from: d, reason: collision with root package name */
    private final int f21143d;

    /* renamed from: e, reason: collision with root package name */
    private final int f21144e;

    /* renamed from: f, reason: collision with root package name */
    private final int f21145f;

    /* renamed from: g, reason: collision with root package name */
    private final int f21146g;

    /* renamed from: h, reason: collision with root package name */
    private final int f21147h;

    /* renamed from: i, reason: collision with root package name */
    private int f21148i;

    /* renamed from: j, reason: collision with root package name */
    private List<t> f21149j;

    /* renamed from: k, reason: collision with root package name */
    private List<t> f21150k;

    /* renamed from: l, reason: collision with root package name */
    private int f21151l;

    /* renamed from: m, reason: collision with root package name */
    private final int f21152m;
    Bitmap n;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21152m = 10;
        this.f21141b = new Paint(1);
        Resources resources = getResources();
        this.f21143d = resources.getColor(R.color.viewfinder_mask);
        this.f21144e = resources.getColor(R.color.result_view);
        this.f21145f = resources.getColor(R.color.viewfinder_laser);
        this.f21146g = resources.getColor(R.color.possible_result_points);
        this.f21147h = resources.getColor(R.color.status_text);
        this.f21148i = 0;
        this.f21149j = new ArrayList(5);
        this.f21150k = null;
        this.n = BitmapFactory.decodeResource(resources, R.drawable.scan_light);
    }

    private void a(Canvas canvas, Rect rect) {
        this.f21141b.setColor(-1);
        this.f21141b.setStrokeWidth(2.0f);
        this.f21141b.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, this.f21141b);
        this.f21141b.setColor(Color.parseColor("#21b3e2"));
        this.f21141b.setStyle(Paint.Style.FILL);
        int i2 = rect.left;
        canvas.drawRect(i2 - 10, rect.top, i2, r1 + 45, this.f21141b);
        int i3 = rect.left;
        canvas.drawRect(i3 - 10, r1 - 10, i3 + 45, rect.top, this.f21141b);
        canvas.drawRect(rect.right, rect.top, r0 + 10, r1 + 45, this.f21141b);
        int i4 = rect.right;
        canvas.drawRect(i4 - 45, r1 - 10, i4 + 10, rect.top, this.f21141b);
        canvas.drawRect(r0 - 10, r1 - 45, rect.left, rect.bottom, this.f21141b);
        int i5 = rect.left;
        canvas.drawRect(i5 - 10, rect.bottom, i5 + 45, r1 + 10, this.f21141b);
        canvas.drawRect(rect.right, r1 - 45, r0 + 10, rect.bottom, this.f21141b);
        int i6 = rect.right;
        canvas.drawRect(i6 - 45, rect.bottom, i6 + 10, r10 + 10, this.f21141b);
    }

    private void b(Canvas canvas, Rect rect) {
        if (this.f21151l == 0) {
            this.f21151l = rect.top;
        }
        int i2 = this.f21151l;
        if (i2 >= rect.bottom) {
            this.f21151l = rect.top;
        } else {
            this.f21151l = i2 + 10;
        }
        int i3 = rect.left;
        int i4 = this.f21151l;
        canvas.drawBitmap(this.n, (Rect) null, new Rect(i3, i4, rect.right, i4 + 30), this.f21141b);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) throws Resources.NotFoundException {
        d dVar = this.f21140a;
        if (dVar == null) {
            return;
        }
        Rect rectB = dVar.b();
        Rect rectC = this.f21140a.c();
        if (rectB == null || rectC == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f21141b.setColor(this.f21142c != null ? this.f21144e : this.f21143d);
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, rectB.top, this.f21141b);
        canvas.drawRect(0.0f, rectB.top, rectB.left, rectB.bottom + 1, this.f21141b);
        canvas.drawRect(rectB.right + 1, rectB.top, f2, rectB.bottom + 1, this.f21141b);
        canvas.drawRect(0.0f, rectB.bottom + 1, f2, height, this.f21141b);
        if (this.f21142c != null) {
            this.f21141b.setAlpha(q);
            canvas.drawBitmap(this.f21142c, (Rect) null, rectB, this.f21141b);
            return;
        }
        a(canvas, rectB);
        a(canvas, rectB, width);
        b(canvas, rectB);
        float fWidth = rectB.width() / rectC.width();
        float fHeight = rectB.height() / rectC.height();
        List<t> list = this.f21149j;
        List<t> list2 = this.f21150k;
        int i2 = rectB.left;
        int i3 = rectB.top;
        if (list.isEmpty()) {
            this.f21150k = null;
        } else {
            this.f21149j = new ArrayList(5);
            this.f21150k = list;
            this.f21141b.setAlpha(q);
            this.f21141b.setColor(this.f21146g);
            synchronized (list) {
                for (t tVar : list) {
                    canvas.drawCircle(((int) (tVar.a() * fWidth)) + i2, ((int) (tVar.b() * fHeight)) + i3, 6.0f, this.f21141b);
                }
            }
        }
        if (list2 != null) {
            this.f21141b.setAlpha(80);
            this.f21141b.setColor(this.f21146g);
            synchronized (list2) {
                for (t tVar2 : list2) {
                    canvas.drawCircle(((int) (tVar2.a() * fWidth)) + i2, ((int) (tVar2.b() * fHeight)) + i3, 3.0f, this.f21141b);
                }
            }
        }
        postInvalidateDelayed(p, rectB.left - 6, rectB.top - 6, rectB.right + 6, rectB.bottom + 6);
    }

    public void setCameraManager(d dVar) {
        this.f21140a = dVar;
    }

    private void a(Canvas canvas, Rect rect, int i2) throws Resources.NotFoundException {
        String string = getResources().getString(R.string.viewfinderview_status_text1);
        String string2 = getResources().getString(R.string.viewfinderview_status_text2);
        this.f21141b.setColor(this.f21147h);
        this.f21141b.setTextSize(45);
        canvas.drawText(string, (i2 - ((int) this.f21141b.measureText(string))) / 2, rect.top - 180, this.f21141b);
        canvas.drawText(string2, (i2 - ((int) this.f21141b.measureText(string2))) / 2, (rect.top - 180) + 60, this.f21141b);
    }

    public void a() {
        Bitmap bitmap = this.f21142c;
        this.f21142c = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    public void a(Bitmap bitmap) {
        this.f21142c = bitmap;
        invalidate();
    }

    public void a(t tVar) {
        List<t> list = this.f21149j;
        synchronized (list) {
            list.add(tVar);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }
}
