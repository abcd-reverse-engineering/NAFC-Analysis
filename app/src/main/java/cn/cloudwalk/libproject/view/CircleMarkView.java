package cn.cloudwalk.libproject.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import cn.cloudwalk.libproject.R;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class CircleMarkView extends View {
    public static final int AnimType_ActionChange = 1;
    public static final int AnimType_Testing = 0;
    private int AnimType;
    private final int TSET_NUM;
    private int action_sum;
    private int arcColor;
    private Paint arcPaint;
    private int color_blue;
    private int color_gray;
    private int color_white;
    private int forceColor;
    int interRedius;
    private boolean isAnimation;
    private boolean isForce;
    public int lineHeight;
    private Paint linePaint;
    private int lineSum;
    private String mShowedContent;
    private Timer mTimer;
    RectF ovalRectF;
    private int radius;
    private float sweepAngle;
    float sweepIndex;
    private int test_index;
    int text_x_center;
    int text_y_center;
    private TimerTask timerTask;
    private String tipMsg;
    private Paint tipPaint;

    public CircleMarkView(Context context) {
        super(context);
        this.sweepAngle = 360.0f;
        this.lineHeight = 40;
        this.lineSum = 40;
        this.sweepIndex = this.sweepAngle / this.lineSum;
        this.AnimType = -1;
        this.action_sum = 0;
        this.TSET_NUM = 9;
        this.test_index = 0;
        this.mTimer = null;
        this.timerTask = null;
        this.isAnimation = false;
        this.forceColor = -1;
        this.isForce = false;
        initView();
    }

    static /* synthetic */ int access$108(CircleMarkView circleMarkView) {
        int i2 = circleMarkView.test_index;
        circleMarkView.test_index = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$308(CircleMarkView circleMarkView) {
        int i2 = circleMarkView.action_sum;
        circleMarkView.action_sum = i2 + 1;
        return i2;
    }

    private void createTimer() {
        if (this.isAnimation) {
            return;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.timerTask == null) {
            this.timerTask = new TimerTask() { // from class: cn.cloudwalk.libproject.view.CircleMarkView.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (CircleMarkView.this.AnimType == 0) {
                        CircleMarkView.access$108(CircleMarkView.this);
                        if (CircleMarkView.this.test_index > CircleMarkView.this.lineSum) {
                            CircleMarkView.this.test_index = 0;
                        }
                        CircleMarkView.this.postInvalidate();
                        return;
                    }
                    if (CircleMarkView.this.AnimType == 1) {
                        CircleMarkView.access$308(CircleMarkView.this);
                        if (CircleMarkView.this.action_sum <= CircleMarkView.this.lineSum) {
                            CircleMarkView.this.postInvalidate();
                        } else {
                            CircleMarkView.this.action_sum = 0;
                            CircleMarkView.this.stopAmin(true);
                        }
                    }
                }
            };
        }
    }

    private void drawLine(Canvas canvas) {
        int i2;
        canvas.save();
        int i3 = this.radius;
        canvas.translate(i3, i3);
        if (this.AnimType != -1) {
            canvas.rotate(180.0f);
        }
        int i4 = 0;
        while (true) {
            int i5 = this.lineSum;
            if (i4 >= i5) {
                canvas.restore();
                return;
            }
            if (this.isForce) {
                int i6 = this.forceColor;
                if (i6 != -1) {
                    this.linePaint.setColor(i6);
                } else {
                    this.linePaint.setColor(this.color_gray);
                }
            } else {
                int i7 = this.AnimType;
                if (i7 == 1) {
                    if (i4 < this.action_sum) {
                        this.linePaint.setColor(this.color_blue);
                    } else {
                        this.linePaint.setColor(this.color_gray);
                    }
                } else if (i7 == 0) {
                    int i8 = this.test_index;
                    if (i8 + 9 >= i5) {
                        if ((i4 < 0 || i4 >= (i8 + 9) - i5) && (i4 < (i2 = this.test_index) || i4 >= i2 + 9)) {
                            this.linePaint.setColor(this.color_gray);
                        } else {
                            this.linePaint.setColor(this.color_blue);
                        }
                    } else if (i4 < i8 || i4 >= i8 + 9) {
                        this.linePaint.setColor(this.color_gray);
                    } else {
                        this.linePaint.setColor(this.color_blue);
                    }
                } else {
                    this.linePaint.setColor(this.color_gray);
                }
            }
            canvas.drawLine(0.0f, this.radius, 0.0f, r2 - (this.lineHeight / 2), this.linePaint);
            canvas.rotate(this.sweepIndex);
            i4++;
        }
    }

    private void drawText(Canvas canvas) {
        if (TextUtils.isEmpty(this.tipMsg) || TextUtils.equals(this.mShowedContent, this.tipMsg)) {
            return;
        }
        this.mShowedContent = this.tipMsg;
        canvas.save();
        int i2 = this.lineHeight;
        int i3 = this.radius;
        this.ovalRectF = new RectF(i2, i2, (i3 * 2) - i2, (i3 * 2) - i2);
        canvas.drawArc(this.ovalRectF, -30.0f, -120.0f, false, this.arcPaint);
        int i4 = this.radius;
        this.text_x_center = i4;
        this.interRedius = i4 - (this.lineHeight / 2);
        this.text_y_center = (i4 - ((int) (this.interRedius * 0.5d))) - sp2px(14.0f);
        canvas.drawText(this.tipMsg, this.text_x_center, this.text_y_center, this.tipPaint);
        canvas.restore();
    }

    private void initAttrs(AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CircleMarkView, i2, i3);
        this.lineHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleMarkView_line_height, 14);
        this.arcColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleMarkView_arc_color, getResources().getColor(R.color.color_f44e58));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initView() {
        this.color_gray = getResources().getColor(R.color.color_a0a0a0);
        this.color_blue = getResources().getColor(R.color.color_44d7b6);
        this.color_white = getResources().getColor(android.R.color.white);
        this.linePaint = new Paint();
        this.linePaint.setStrokeWidth(6.0f);
        this.linePaint.setAntiAlias(true);
        this.linePaint.setColor(this.color_gray);
        this.tipPaint = new Paint();
        this.tipPaint.setAntiAlias(true);
        this.tipPaint.setStrokeWidth(4.0f);
        this.tipPaint.setColor(this.color_white);
        this.tipPaint.setStyle(Paint.Style.FILL);
        this.tipPaint.setTextAlign(Paint.Align.CENTER);
        this.tipPaint.setTextSize(sp2px(18.0f));
        this.arcPaint = new Paint();
        this.arcPaint.setAntiAlias(true);
        this.arcPaint.setStrokeWidth(4.0f);
        this.arcPaint.setColor(this.arcColor);
        this.arcPaint.setStyle(Paint.Style.FILL);
    }

    private int sp2px(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int dip2px(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void invalidate() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.invalidate();
        } else {
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        stopAmin(false);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawLine(canvas);
        drawText(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.radius = Math.min(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3)) / 2;
        int i4 = this.radius;
        setMeasuredDimension(i4 * 2, i4 * 2);
    }

    public void setLineColor(int i2, boolean z) {
        this.isForce = z;
        this.forceColor = i2;
    }

    public void setRadius(int i2) {
        this.radius = i2;
        this.AnimType = -1;
        invalidate();
    }

    public void setTipMsg(String str) {
        this.tipMsg = str;
        invalidate();
    }

    public void startAnim(int i2, int i3) {
        if (this.isAnimation) {
            return;
        }
        this.action_sum = 0;
        this.AnimType = i2;
        createTimer();
        this.isAnimation = true;
        this.mTimer.schedule(this.timerTask, 0L, i3);
    }

    public void stopAmin(boolean z) {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = null;
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.timerTask = null;
        this.isAnimation = false;
        this.AnimType = -1;
        this.action_sum = 0;
        this.test_index = 0;
        if (z) {
            postInvalidate();
        }
    }

    public CircleMarkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.sweepAngle = 360.0f;
        this.lineHeight = 40;
        this.lineSum = 40;
        this.sweepIndex = this.sweepAngle / this.lineSum;
        this.AnimType = -1;
        this.action_sum = 0;
        this.TSET_NUM = 9;
        this.test_index = 0;
        this.mTimer = null;
        this.timerTask = null;
        this.isAnimation = false;
        this.forceColor = -1;
        this.isForce = false;
        initAttrs(attributeSet, i2, 0);
    }

    public CircleMarkView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.sweepAngle = 360.0f;
        this.lineHeight = 40;
        this.lineSum = 40;
        this.sweepIndex = this.sweepAngle / this.lineSum;
        this.AnimType = -1;
        this.action_sum = 0;
        this.TSET_NUM = 9;
        this.test_index = 0;
        this.mTimer = null;
        this.timerTask = null;
        this.isAnimation = false;
        this.forceColor = -1;
        this.isForce = false;
        initAttrs(attributeSet, i2, i3);
        initView();
    }

    public CircleMarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sweepAngle = 360.0f;
        this.lineHeight = 40;
        this.lineSum = 40;
        this.sweepIndex = this.sweepAngle / this.lineSum;
        this.AnimType = -1;
        this.action_sum = 0;
        this.TSET_NUM = 9;
        this.test_index = 0;
        this.mTimer = null;
        this.timerTask = null;
        this.isAnimation = false;
        this.forceColor = -1;
        this.isForce = false;
        initAttrs(attributeSet, 0, 0);
        initView();
    }
}
