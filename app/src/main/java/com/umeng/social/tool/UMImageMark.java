package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class UMImageMark extends UMWaterMark {
    private Bitmap mMarkBitmap;

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void bringToFront() {
        super.bringToFront();
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ Bitmap compound(Bitmap bitmap) {
        return super.compound(bitmap);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    Bitmap getMarkBitmap() {
        return this.mMarkBitmap;
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setAlpha(float f2) {
        super.setAlpha(f2);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setContext(Context context) {
        super.setContext(context);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setGravity(int i2) {
        super.setGravity(i2);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setMargins(int i2, int i3, int i4, int i5) {
        super.setMargins(i2, i3, i4, i5);
    }

    public void setMarkBitmap(Bitmap bitmap) {
        this.mMarkBitmap = bitmap;
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setRotate(int i2) {
        super.setRotate(i2);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setScale(float f2) {
        super.setScale(f2);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setTransparent() {
        super.setTransparent();
    }
}
