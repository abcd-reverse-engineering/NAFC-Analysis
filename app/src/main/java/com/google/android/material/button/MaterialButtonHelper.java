package com.google.android.material.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class MaterialButtonHelper {
    private static final float CORNER_RADIUS_ADJUSTMENT = 1.0E-5f;
    private static final int DEFAULT_BACKGROUND_COLOR = -1;
    private static final boolean IS_LOLLIPOP;

    @Nullable
    private GradientDrawable backgroundDrawableLollipop;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff.Mode backgroundTintMode;

    @Nullable
    private GradientDrawable colorableBackgroundDrawableCompat;
    private int cornerRadius;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;

    @Nullable
    private GradientDrawable maskDrawableLollipop;
    private final MaterialButton materialButton;

    @Nullable
    private ColorStateList rippleColor;

    @Nullable
    private GradientDrawable rippleDrawableCompat;

    @Nullable
    private ColorStateList strokeColor;

    @Nullable
    private GradientDrawable strokeDrawableLollipop;
    private int strokeWidth;

    @Nullable
    private Drawable tintableBackgroundDrawableCompat;

    @Nullable
    private Drawable tintableRippleDrawableCompat;
    private final Paint buttonStrokePaint = new Paint(1);
    private final Rect bounds = new Rect();
    private final RectF rectF = new RectF();
    private boolean backgroundOverwritten = false;

    static {
        IS_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
    }

    public MaterialButtonHelper(MaterialButton materialButton) {
        this.materialButton = materialButton;
    }

    private Drawable createBackgroundCompat() {
        this.colorableBackgroundDrawableCompat = new GradientDrawable();
        this.colorableBackgroundDrawableCompat.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.colorableBackgroundDrawableCompat.setColor(-1);
        this.tintableBackgroundDrawableCompat = DrawableCompat.wrap(this.colorableBackgroundDrawableCompat);
        DrawableCompat.setTintList(this.tintableBackgroundDrawableCompat, this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            DrawableCompat.setTintMode(this.tintableBackgroundDrawableCompat, mode);
        }
        this.rippleDrawableCompat = new GradientDrawable();
        this.rippleDrawableCompat.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.rippleDrawableCompat.setColor(-1);
        this.tintableRippleDrawableCompat = DrawableCompat.wrap(this.rippleDrawableCompat);
        DrawableCompat.setTintList(this.tintableRippleDrawableCompat, this.rippleColor);
        return wrapDrawableWithInset(new LayerDrawable(new Drawable[]{this.tintableBackgroundDrawableCompat, this.tintableRippleDrawableCompat}));
    }

    @TargetApi(21)
    private Drawable createBackgroundLollipop() {
        this.backgroundDrawableLollipop = new GradientDrawable();
        this.backgroundDrawableLollipop.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.backgroundDrawableLollipop.setColor(-1);
        updateTintAndTintModeLollipop();
        this.strokeDrawableLollipop = new GradientDrawable();
        this.strokeDrawableLollipop.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.strokeDrawableLollipop.setColor(0);
        this.strokeDrawableLollipop.setStroke(this.strokeWidth, this.strokeColor);
        InsetDrawable insetDrawableWrapDrawableWithInset = wrapDrawableWithInset(new LayerDrawable(new Drawable[]{this.backgroundDrawableLollipop, this.strokeDrawableLollipop}));
        this.maskDrawableLollipop = new GradientDrawable();
        this.maskDrawableLollipop.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.maskDrawableLollipop.setColor(-1);
        return new MaterialButtonBackgroundDrawable(RippleUtils.convertToRippleDrawableColor(this.rippleColor), insetDrawableWrapDrawableWithInset, this.maskDrawableLollipop);
    }

    @Nullable
    private GradientDrawable unwrapBackgroundDrawable() {
        if (!IS_LOLLIPOP || this.materialButton.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    @Nullable
    private GradientDrawable unwrapStrokeDrawable() {
        if (!IS_LOLLIPOP || this.materialButton.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void updateStroke() {
        if (IS_LOLLIPOP && this.strokeDrawableLollipop != null) {
            this.materialButton.setInternalBackground(createBackgroundLollipop());
        } else {
            if (IS_LOLLIPOP) {
                return;
            }
            this.materialButton.invalidate();
        }
    }

    private void updateTintAndTintModeLollipop() {
        GradientDrawable gradientDrawable = this.backgroundDrawableLollipop;
        if (gradientDrawable != null) {
            DrawableCompat.setTintList(gradientDrawable, this.backgroundTint);
            PorterDuff.Mode mode = this.backgroundTintMode;
            if (mode != null) {
                DrawableCompat.setTintMode(this.backgroundDrawableLollipop, mode);
            }
        }
    }

    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    void drawStroke(@Nullable Canvas canvas) {
        if (canvas == null || this.strokeColor == null || this.strokeWidth <= 0) {
            return;
        }
        this.bounds.set(this.materialButton.getBackground().getBounds());
        RectF rectF = this.rectF;
        float f2 = this.bounds.left;
        int i2 = this.strokeWidth;
        rectF.set(f2 + (i2 / 2.0f) + this.insetLeft, r1.top + (i2 / 2.0f) + this.insetTop, (r1.right - (i2 / 2.0f)) - this.insetRight, (r1.bottom - (i2 / 2.0f)) - this.insetBottom);
        float f3 = this.cornerRadius - (this.strokeWidth / 2.0f);
        canvas.drawRoundRect(this.rectF, f3, f3, this.buttonStrokePaint);
    }

    int getCornerRadius() {
        return this.cornerRadius;
    }

    @Nullable
    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @Nullable
    ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    int getStrokeWidth() {
        return this.strokeWidth;
    }

    ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    public void loadFromAttributes(TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        this.cornerRadius = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, 0);
        this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.buttonStrokePaint.setStyle(Paint.Style.STROKE);
        this.buttonStrokePaint.setStrokeWidth(this.strokeWidth);
        Paint paint = this.buttonStrokePaint;
        ColorStateList colorStateList = this.strokeColor;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.materialButton.getDrawableState(), 0) : 0);
        int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        this.materialButton.setInternalBackground(IS_LOLLIPOP ? createBackgroundLollipop() : createBackgroundCompat());
        ViewCompat.setPaddingRelative(this.materialButton, paddingStart + this.insetLeft, paddingTop + this.insetTop, paddingEnd + this.insetRight, paddingBottom + this.insetBottom);
    }

    void setBackgroundColor(int i2) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (IS_LOLLIPOP && (gradientDrawable2 = this.backgroundDrawableLollipop) != null) {
            gradientDrawable2.setColor(i2);
        } else {
            if (IS_LOLLIPOP || (gradientDrawable = this.colorableBackgroundDrawableCompat) == null) {
                return;
            }
            gradientDrawable.setColor(i2);
        }
    }

    void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    void setCornerRadius(int i2) {
        GradientDrawable gradientDrawable;
        if (this.cornerRadius != i2) {
            this.cornerRadius = i2;
            if (!IS_LOLLIPOP || this.backgroundDrawableLollipop == null || this.strokeDrawableLollipop == null || this.maskDrawableLollipop == null) {
                if (IS_LOLLIPOP || (gradientDrawable = this.colorableBackgroundDrawableCompat) == null || this.rippleDrawableCompat == null) {
                    return;
                }
                float f2 = i2 + CORNER_RADIUS_ADJUSTMENT;
                gradientDrawable.setCornerRadius(f2);
                this.rippleDrawableCompat.setCornerRadius(f2);
                this.materialButton.invalidate();
                return;
            }
            if (Build.VERSION.SDK_INT == 21) {
                GradientDrawable gradientDrawableUnwrapBackgroundDrawable = unwrapBackgroundDrawable();
                float f3 = i2 + CORNER_RADIUS_ADJUSTMENT;
                gradientDrawableUnwrapBackgroundDrawable.setCornerRadius(f3);
                unwrapStrokeDrawable().setCornerRadius(f3);
            }
            GradientDrawable gradientDrawable2 = this.backgroundDrawableLollipop;
            float f4 = i2 + CORNER_RADIUS_ADJUSTMENT;
            gradientDrawable2.setCornerRadius(f4);
            this.strokeDrawableLollipop.setCornerRadius(f4);
            this.maskDrawableLollipop.setCornerRadius(f4);
        }
    }

    void setRippleColor(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            if (IS_LOLLIPOP && (this.materialButton.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.materialButton.getBackground()).setColor(colorStateList);
            } else {
                if (IS_LOLLIPOP || (drawable = this.tintableRippleDrawableCompat) == null) {
                    return;
                }
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
    }

    void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            this.buttonStrokePaint.setColor(colorStateList != null ? colorStateList.getColorForState(this.materialButton.getDrawableState(), 0) : 0);
            updateStroke();
        }
    }

    void setStrokeWidth(int i2) {
        if (this.strokeWidth != i2) {
            this.strokeWidth = i2;
            this.buttonStrokePaint.setStrokeWidth(i2);
            updateStroke();
        }
    }

    void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (IS_LOLLIPOP) {
                updateTintAndTintModeLollipop();
                return;
            }
            Drawable drawable = this.tintableBackgroundDrawableCompat;
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, this.backgroundTint);
            }
        }
    }

    void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        PorterDuff.Mode mode2;
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (IS_LOLLIPOP) {
                updateTintAndTintModeLollipop();
                return;
            }
            Drawable drawable = this.tintableBackgroundDrawableCompat;
            if (drawable == null || (mode2 = this.backgroundTintMode) == null) {
                return;
            }
            DrawableCompat.setTintMode(drawable, mode2);
        }
    }

    void updateMaskBounds(int i2, int i3) {
        GradientDrawable gradientDrawable = this.maskDrawableLollipop;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.insetLeft, this.insetTop, i3 - this.insetRight, i2 - this.insetBottom);
        }
    }
}
