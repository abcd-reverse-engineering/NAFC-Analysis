package com.lxj.xpopup.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    public k f8091a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView.ScaleType f8092b;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f8091a = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f8092b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f8092b = null;
        }
    }

    public k getAttacher() {
        return this.f8091a;
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.f8091a.a(matrix);
    }

    public RectF getDisplayRect() {
        return this.f8091a.a();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f8091a.b();
    }

    public float getMaximumScale() {
        return this.f8091a.c();
    }

    public float getMediumScale() {
        return this.f8091a.d();
    }

    public float getMinimumScale() {
        return this.f8091a.e();
    }

    public float getScale() {
        return this.f8091a.f();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f8091a.g();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.f8091a.b(matrix);
    }

    public boolean isZoomable() {
        return this.f8091a.i();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f8091a.a(z);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.f8091a.c(matrix);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.f8091a.j();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f8091a;
        if (kVar != null) {
            kVar.j();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        k kVar = this.f8091a;
        if (kVar != null) {
            kVar.j();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f8091a;
        if (kVar != null) {
            kVar.j();
        }
    }

    public void setMaximumScale(float f2) {
        this.f8091a.b(f2);
    }

    public void setMediumScale(float f2) {
        this.f8091a.c(f2);
    }

    public void setMinimumScale(float f2) {
        this.f8091a.d(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8091a.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f8091a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8091a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f8091a.setOnMatrixChangeListener(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f8091a.setOnOutsidePhotoTapListener(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f8091a.setOnPhotoTapListener(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f8091a.setOnScaleChangeListener(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f8091a.setOnSingleFlingListener(hVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f8091a.setOnViewDragListener(iVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f8091a.setOnViewTapListener(jVar);
    }

    public void setRotationBy(float f2) {
        this.f8091a.e(f2);
    }

    public void setRotationTo(float f2) {
        this.f8091a.f(f2);
    }

    public void setScale(float f2) {
        this.f8091a.g(f2);
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        this.f8091a.a(f2, f3, f4);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f8091a;
        if (kVar == null) {
            this.f8092b = scaleType;
        } else {
            kVar.a(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.f8091a.c(matrix);
    }

    public void setZoomTransitionDuration(int i2) {
        this.f8091a.a(i2);
    }

    public void setZoomable(boolean z) {
        this.f8091a.b(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f2, boolean z) {
        this.f8091a.a(f2, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.f8091a.a(f2, f3, f4, z);
    }
}
