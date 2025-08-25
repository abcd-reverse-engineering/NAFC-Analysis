package com.scwang.smartrefresh.layout.c;

/* compiled from: DimensionStatus.java */
/* loaded from: classes.dex */
public enum a {
    DefaultUnNotify(false),
    Default(true),
    XmlWrapUnNotify(false),
    XmlWrap(true),
    XmlExactUnNotify(false),
    XmlExact(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);

    public final boolean notified;

    a(boolean z) {
        this.notified = z;
    }

    public boolean canReplaceWith(a aVar) {
        return ordinal() < aVar.ordinal() || ((!this.notified || CodeExact == this) && ordinal() == aVar.ordinal());
    }

    public a notified() {
        return !this.notified ? values()[ordinal() + 1] : this;
    }

    public a unNotify() {
        if (!this.notified) {
            return this;
        }
        a aVar = values()[ordinal() - 1];
        return !aVar.notified ? aVar : DefaultUnNotify;
    }
}
