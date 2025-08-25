package cn.jzvd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* loaded from: classes.dex */
public class JZTextureView extends TextureView {

    /* renamed from: c, reason: collision with root package name */
    protected static final String f3185c = "JZResizeTextureView";

    /* renamed from: a, reason: collision with root package name */
    public int f3186a;

    /* renamed from: b, reason: collision with root package name */
    public int f3187b;

    public JZTextureView(Context context) {
        super(context);
        this.f3186a = 0;
        this.f3187b = 0;
        this.f3186a = 0;
        this.f3187b = 0;
    }

    public void a(int i2, int i3) {
        if (this.f3186a == i2 && this.f3187b == i3) {
            return;
        }
        this.f3186a = i2;
        this.f3187b = i3;
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0130  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jzvd.JZTextureView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        if (f2 != getRotation()) {
            super.setRotation(f2);
            requestLayout();
        }
    }

    public JZTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3186a = 0;
        this.f3187b = 0;
        this.f3186a = 0;
        this.f3187b = 0;
    }
}
