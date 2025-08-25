package com.scwang.smartrefresh.layout.c;

/* compiled from: RefreshState.java */
/* loaded from: classes.dex */
public enum b {
    None(0, false, false, false, false),
    PullDownToRefresh(1, true, false, false, false),
    PullUpToLoad(2, true, false, false, false),
    PullDownCanceled(1, false, false, false, false),
    PullUpCanceled(2, false, false, false, false),
    ReleaseToRefresh(1, true, false, false, false),
    ReleaseToLoad(2, true, false, false, false),
    ReleaseToTwoLevel(1, true, false, false, true),
    TwoLevelReleased(1, false, false, false, true),
    RefreshReleased(1, false, false, false, false),
    LoadReleased(2, false, false, false, false),
    Refreshing(1, false, true, false, false),
    Loading(2, false, true, false, false),
    TwoLevel(1, false, true, false, true),
    RefreshFinish(1, false, false, true, false),
    LoadFinish(2, false, false, true, false),
    TwoLevelFinish(1, false, false, true, true);

    public final boolean isDragging;
    public final boolean isFinishing;
    public final boolean isFooter;
    public final boolean isHeader;
    public final boolean isOpening;
    public final boolean isTwoLevel;

    b(int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.isHeader = i2 == 1;
        this.isFooter = i2 == 2;
        this.isDragging = z;
        this.isOpening = z2;
        this.isFinishing = z3;
        this.isTwoLevel = z4;
    }

    public b toFooter() {
        return (!this.isHeader || this.isTwoLevel) ? this : values()[ordinal() + 1];
    }

    public b toHeader() {
        return (!this.isFooter || this.isTwoLevel) ? this : values()[ordinal() - 1];
    }
}
