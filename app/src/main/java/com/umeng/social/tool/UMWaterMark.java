package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes2.dex */
class UMWaterMark {
    static final int RELATIVE_POSITION_HORIZONTAL_LEFT = 4;
    static final int RELATIVE_POSITION_HORIZONTAL_RIGHT = 3;
    static final int RELATIVE_POSITION_VERTICAL_BOTTOM = 1;
    static final int RELATIVE_POSITION_VERTICAL_TOP = 2;
    private static final String TAG = "UMWaterMark";
    private int mBottomMargin;
    private Context mContext;
    private int mLeftMargin;
    private int mRightMargin;
    private int mTopMargin;
    private float mScale = 0.3f;
    private Rect mAnchorMarkRect = new Rect();
    private int mVerticalRelativePosition = -1;
    private int mHorizontalRelativePosition = -1;
    private int mGravity = 51;
    private boolean mIsTransparent = false;
    private boolean mIsBringToFront = false;
    private float mAlpha = -1.0f;
    private int mDegree = -1;
    private Rect mMeasureRect = new Rect();

    UMWaterMark() {
    }

    private float getDx(int i2) {
        int iDip2px = dip2px(this.mLeftMargin);
        int i3 = -dip2px(this.mRightMargin);
        int i4 = this.mGravity & 7;
        if (i4 != 1) {
            return i4 != 5 ? iDip2px : (i2 - getMarkWidth()) + i3;
        }
        if (iDip2px == 0) {
            iDip2px = i3;
        }
        return (((i2 - getMarkWidth()) * 1.0f) / 2.0f) + iDip2px;
    }

    private float getDy(int i2) {
        int i3 = -dip2px(this.mBottomMargin);
        int iDip2px = dip2px(this.mTopMargin);
        int i4 = this.mGravity & 112;
        if (i4 != 16) {
            return i4 != 80 ? iDip2px : (i2 - getMarkHeight()) + i3;
        }
        if (iDip2px != 0) {
            i3 = iDip2px;
        }
        return (((i2 - getMarkHeight()) * 1.0f) / 2.0f) + i3;
    }

    private int getMarkHeight() {
        if (getMarkBitmap() == null) {
            return -1;
        }
        return getMarkBitmap().getHeight();
    }

    private int getMarkWidth() {
        if (getMarkBitmap() == null) {
            return -1;
        }
        return getMarkBitmap().getWidth();
    }

    private float getRelativeDx(int i2) {
        Rect rect = this.mAnchorMarkRect;
        float f2 = rect.left;
        float f3 = rect.right;
        int i3 = this.mHorizontalRelativePosition;
        if (i3 == 3) {
            return dip2px(this.mLeftMargin) + f3;
        }
        if (i3 != 4) {
            return getDx(i2);
        }
        return (-dip2px(this.mRightMargin)) + (f2 - getMarkWidth());
    }

    private float getRelativeDy(int i2) {
        Rect rect = this.mAnchorMarkRect;
        float f2 = rect.top;
        float f3 = rect.bottom;
        int i3 = this.mVerticalRelativePosition;
        if (i3 == 1) {
            return dip2px(this.mTopMargin) + f3;
        }
        if (i3 != 2) {
            return getDy(i2);
        }
        return (-dip2px(this.mBottomMargin)) + (f2 - getMarkHeight());
    }

    private float getScaleAnchorX(int i2) {
        int i3 = this.mGravity & 7;
        if (i3 == 1) {
            i2 /= 2;
        } else if (i3 != 5) {
            return 0.0f;
        }
        return i2;
    }

    private float getScaleAnchorY(int i2) {
        int i3 = this.mGravity & 112;
        if (i3 == 16) {
            i2 /= 2;
        } else if (i3 != 80) {
            return 0.0f;
        }
        return i2;
    }

    private void safelyRecycleBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception unused) {
            }
        }
    }

    public void bringToFront() {
        this.mIsBringToFront = true;
    }

    void clearRelativePosition() {
        this.mHorizontalRelativePosition = -1;
        this.mVerticalRelativePosition = -1;
    }

    public Bitmap compound(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap;
        Canvas canvas;
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap markBitmap = getMarkBitmap();
            if (markBitmap == null) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= 0 || height <= 0) {
                String str = "mark bitmap is error, markWidth:" + width + ", markHeight:" + height;
                return bitmap;
            }
            int markWidth = getMarkWidth();
            int markHeight = getMarkHeight();
            if (markWidth > 0 && markHeight > 0) {
                if (this.mIsTransparent) {
                    bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    canvas = new Canvas(bitmapCreateBitmap);
                    canvas.drawColor(0);
                } else {
                    bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                    canvas = new Canvas(bitmapCreateBitmap);
                }
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                Matrix matrix = new Matrix();
                float fMin = (this.mScale * Math.min(bitmap.getWidth(), bitmap.getHeight())) / Math.max(markWidth, markHeight);
                matrix.postScale(fMin, fMin, getScaleAnchorX(markWidth), getScaleAnchorY(markHeight));
                if (this.mDegree != -1) {
                    matrix.postRotate(this.mDegree, markWidth / 2, markHeight / 2);
                }
                matrix.postTranslate(isHorizontalRelativePosition() ? getRelativeDx(width) : getDx(width), isVerticalRelativePosition() ? getRelativeDy(height) : getDy(height));
                if (this.mAlpha != -1.0f) {
                    Paint paint = new Paint();
                    paint.setAlpha((int) (this.mAlpha * 255.0f));
                    canvas.drawBitmap(markBitmap, matrix, paint);
                } else {
                    canvas.drawBitmap(markBitmap, matrix, null);
                }
                safelyRecycleBitmap(bitmap);
                safelyRecycleBitmap(markBitmap);
                releaseResource();
                return bitmapCreateBitmap;
            }
            String str2 = "mark bitmap is error, markWidth:" + markWidth + ", markHeight:" + markHeight;
            return bitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    int dip2px(float f2) {
        return (int) ((f2 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    Bitmap getMarkBitmap() {
        return null;
    }

    boolean isBringToFront() {
        return this.mIsBringToFront;
    }

    boolean isHorizontalRelativePosition() {
        return this.mHorizontalRelativePosition != -1;
    }

    boolean isVerticalRelativePosition() {
        return this.mVerticalRelativePosition != -1;
    }

    Rect onMeasure(int i2, int i3) {
        int dx;
        int markWidth;
        int markHeight;
        int dy = 0;
        if (isHorizontalRelativePosition()) {
            dx = 0;
            markWidth = 0;
        } else {
            dx = (int) getDx(i2);
            markWidth = getMarkWidth() + dx;
        }
        if (isVerticalRelativePosition()) {
            markHeight = 0;
        } else {
            dy = (int) getDy(i3);
            markHeight = getMarkHeight() + dy;
        }
        this.mMeasureRect.set(dx, dy, markWidth, markHeight);
        return this.mMeasureRect;
    }

    void releaseResource() {
    }

    public void setAlpha(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.mAlpha = f2;
    }

    void setAnchorMarkHorizontalRect(Rect rect) {
        Rect rect2 = this.mAnchorMarkRect;
        rect2.set(rect.left, rect2.top, rect.right, rect2.bottom);
    }

    void setAnchorMarkVerticalRect(Rect rect) {
        this.mAnchorMarkRect = rect;
        Rect rect2 = this.mAnchorMarkRect;
        rect2.set(rect2.left, rect.top, rect2.right, rect.bottom);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setGravity(int i2) {
        if (i2 > 0 && this.mGravity != i2) {
            this.mGravity = i2;
        }
    }

    void setHorizontalRelativePosition(int i2) {
        this.mHorizontalRelativePosition = i2;
    }

    public void setMargins(int i2, int i3, int i4, int i5) {
        this.mLeftMargin = i2;
        this.mTopMargin = i3;
        this.mRightMargin = i4;
        this.mBottomMargin = i5;
    }

    public void setRotate(int i2) {
        if (i2 < 0 || i2 > 360) {
            return;
        }
        this.mDegree = i2;
    }

    public void setScale(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.mScale = f2;
    }

    public void setTransparent() {
        this.mIsTransparent = true;
    }

    void setVerticalRelativePosition(int i2) {
        this.mVerticalRelativePosition = i2;
    }
}
