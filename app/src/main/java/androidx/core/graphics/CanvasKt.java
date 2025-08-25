package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import h.q2.s.l;
import h.q2.t.f0;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: Canvas.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aD\u0010\b\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a&\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aN\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u0013"}, d2 = {"withMatrix", "", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "withRotation", "degrees", "", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withMatrix(@d Canvas canvas, @d Matrix matrix, @d l<? super Canvas, y1> lVar) {
        i0.f(canvas, "$receiver");
        i0.f(matrix, "matrix");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            matrix = new Matrix();
        }
        i0.f(canvas, "$receiver");
        i0.f(matrix, "matrix");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static final void withRotation(@d Canvas canvas, float f2, float f3, float f4, @d l<? super Canvas, y1> lVar) {
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withRotation$default(Canvas canvas, float f2, float f3, float f4, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static final void withSave(@d Canvas canvas, @d l<? super Canvas, y1> lVar) {
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static final void withScale(@d Canvas canvas, float f2, float f3, float f4, float f5, @d l<? super Canvas, y1> lVar) {
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withScale$default(Canvas canvas, float f2, float f3, float f4, float f5, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f5 = 0.0f;
        }
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static final void withSkew(@d Canvas canvas, float f2, float f3, @d l<? super Canvas, y1> lVar) {
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.skew(f2, f3);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withSkew$default(Canvas canvas, float f2, float f3, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.skew(f2, f3);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static final void withTranslation(@d Canvas canvas, float f2, float f3, @d l<? super Canvas, y1> lVar) {
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.translate(f2, f3);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withTranslation$default(Canvas canvas, float f2, float f3, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        i0.f(canvas, "$receiver");
        i0.f(lVar, "block");
        int iSave = canvas.save();
        canvas.translate(f2, f3);
        try {
            lVar.invoke(canvas);
        } finally {
            f0.b(1);
            canvas.restoreToCount(iSave);
            f0.a(1);
        }
    }
}
