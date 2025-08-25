package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.CircularBorderDrawableLollipop;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

@RequiresApi(21)
/* loaded from: classes.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    private InsetDrawable insetDrawable;

    static class AlwaysStatefulGradientDrawable extends GradientDrawable {
        AlwaysStatefulGradientDrawable() {
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    FloatingActionButtonImplLollipop(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    @NonNull
    private Animator createElevationAnimator(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.view, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.view, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void getPadding(Rect rect) {
        if (!this.shadowViewDelegate.isCompatPaddingEnabled()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        float radius = this.shadowViewDelegate.getRadius();
        float elevation = getElevation() + this.pressedTranslationZ;
        int iCeil = (int) Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(elevation, radius, false));
        int iCeil2 = (int) Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(elevation, radius, false));
        rect.set(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawableLollipop();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    GradientDrawable newGradientDrawableForShape() {
        return new AlwaysStatefulGradientDrawable();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onDrawableStateChanged(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.view.isEnabled()) {
                this.view.setElevation(0.0f);
                this.view.setTranslationZ(0.0f);
                return;
            }
            this.view.setElevation(this.elevation);
            if (this.view.isPressed()) {
                this.view.setTranslationZ(this.pressedTranslationZ);
            } else if (this.view.isFocused() || this.view.isHovered()) {
                this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
            } else {
                this.view.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onElevationsChanged(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.view.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(f2, f4));
            stateListAnimator.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f2, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f2, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.view, "elevation", f2).setDuration(0L));
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 22 && i2 <= 24) {
                VisibilityAwareImageButton visibilityAwareImageButton = this.view;
                arrayList.add(ObjectAnimator.ofFloat(visibilityAwareImageButton, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, visibilityAwareImageButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.view, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
            stateListAnimator.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, animatorSet);
            stateListAnimator.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
            this.view.setStateListAnimator(stateListAnimator);
        }
        if (this.shadowViewDelegate.isCompatPaddingEnabled()) {
            updatePadding();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onPaddingUpdated(Rect rect) {
        if (!this.shadowViewDelegate.isCompatPaddingEnabled()) {
            this.shadowViewDelegate.setBackgroundDrawable(this.rippleDrawable);
        } else {
            this.insetDrawable = new InsetDrawable(this.rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
            this.shadowViewDelegate.setBackgroundDrawable(this.insetDrawable);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean requirePreDrawListener() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void setBackgroundDrawable(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable layerDrawable;
        this.shapeDrawable = DrawableCompat.wrap(createShapeDrawable());
        DrawableCompat.setTintList(this.shapeDrawable, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.shapeDrawable, mode);
        }
        if (i2 > 0) {
            this.borderDrawable = createBorderDrawable(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.borderDrawable, this.shapeDrawable});
        } else {
            this.borderDrawable = null;
            layerDrawable = this.shapeDrawable;
        }
        this.rippleDrawable = new RippleDrawable(RippleUtils.convertToRippleDrawableColor(colorStateList2), layerDrawable, null);
        Drawable drawable = this.rippleDrawable;
        this.contentBackground = drawable;
        this.shadowViewDelegate.setBackgroundDrawable(drawable);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.convertToRippleDrawableColor(colorStateList));
        } else {
            super.setRippleColor(colorStateList);
        }
    }
}
