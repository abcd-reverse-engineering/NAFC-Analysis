package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class BindResolveClients {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f6743b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ResolveClientBean> f6744a;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final BindResolveClients f6745a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.f6745a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean zContains;
        synchronized (f6743b) {
            zContains = this.f6744a.contains(resolveClientBean);
        }
        return zContains;
    }

    public void notifyClientReconnect() {
        synchronized (f6743b) {
            ListIterator<ResolveClientBean> listIterator = this.f6744a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f6744a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f6743b) {
            if (!this.f6744a.contains(resolveClientBean)) {
                this.f6744a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f6743b) {
            if (this.f6744a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.f6744a.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    } else if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (f6743b) {
            this.f6744a.clear();
        }
    }

    private BindResolveClients() {
        this.f6744a = new ArrayList<>();
    }
}
