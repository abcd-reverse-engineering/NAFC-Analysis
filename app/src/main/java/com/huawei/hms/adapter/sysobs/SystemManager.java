package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SystemManager {

    /* renamed from: a, reason: collision with root package name */
    private static SystemManager f6587a = new SystemManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f6588b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static SystemNotifier f6589c = new a();

    private SystemManager() {
    }

    public static SystemManager getInstance() {
        return f6587a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f6589c;
    }

    public void notifyNoticeResult(int i2) {
        f6589c.notifyNoticeObservers(i2);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f6589c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i2) {
        f6589c.notifyObservers(i2);
    }

    class a implements SystemNotifier {

        /* renamed from: a, reason: collision with root package name */
        private final List<SystemObserver> f6590a = new ArrayList();

        a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i2) {
            synchronized (SystemManager.f6588b) {
                Iterator<SystemObserver> it = this.f6590a.iterator();
                while (it.hasNext()) {
                    if (it.next().onNoticeResult(i2)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f6588b) {
                Iterator<SystemObserver> it = this.f6590a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver == null || this.f6590a.contains(systemObserver)) {
                return;
            }
            synchronized (SystemManager.f6588b) {
                this.f6590a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f6588b) {
                this.f6590a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i2) {
            synchronized (SystemManager.f6588b) {
                Iterator<SystemObserver> it = this.f6590a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i2)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
