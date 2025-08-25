package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class w {

    /* renamed from: b, reason: collision with root package name */
    private static volatile w f11458b;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<ac> f11459a = new LinkedList<>();

    private w() {
    }

    public static w a() {
        if (f11458b == null) {
            synchronized (w.class) {
                if (f11458b == null) {
                    f11458b = new w();
                }
            }
        }
        return f11458b;
    }

    public final ac b() {
        ac acVarPollFirst;
        synchronized (this.f11459a) {
            acVarPollFirst = this.f11459a.pollFirst();
        }
        return acVarPollFirst;
    }

    public final int c() {
        int size;
        synchronized (this.f11459a) {
            size = this.f11459a.size();
        }
        return size;
    }

    public final void b(ac acVar) {
        synchronized (this.f11459a) {
            this.f11459a.remove(acVar);
        }
    }

    public final void a(ac acVar) {
        synchronized (this.f11459a) {
            this.f11459a.addLast(acVar);
        }
    }

    public final ac a(String str) {
        synchronized (this.f11459a) {
            Iterator<ac> it = this.f11459a.iterator();
            while (it.hasNext()) {
                ac next = it.next();
                UMessage uMessage = next.f11223b;
                if (uMessage != null && TextUtils.equals(str, uMessage.getMsgId())) {
                    return next;
                }
            }
            return null;
        }
    }
}
