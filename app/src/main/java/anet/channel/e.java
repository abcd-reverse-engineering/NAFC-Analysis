package anet.channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map<SessionRequest, List<Session>> f1739a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f1740b = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f1741c = this.f1740b.readLock();

    /* renamed from: d, reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f1742d = this.f1740b.writeLock();

    e() {
    }

    public void a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest == null || sessionRequest.a() == null || session == null) {
            return;
        }
        this.f1742d.lock();
        try {
            List<Session> arrayList = this.f1739a.get(sessionRequest);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f1739a.put(sessionRequest, arrayList);
            }
            if (arrayList.indexOf(session) != -1) {
                return;
            }
            arrayList.add(session);
            Collections.sort(arrayList);
        } finally {
            this.f1742d.unlock();
        }
    }

    public void b(SessionRequest sessionRequest, Session session) {
        this.f1742d.lock();
        try {
            List<Session> list = this.f1739a.get(sessionRequest);
            if (list == null) {
                return;
            }
            list.remove(session);
            if (list.size() == 0) {
                this.f1739a.remove(sessionRequest);
            }
        } finally {
            this.f1742d.unlock();
        }
    }

    public boolean c(SessionRequest sessionRequest, Session session) {
        this.f1741c.lock();
        try {
            List<Session> list = this.f1739a.get(sessionRequest);
            boolean z = false;
            if (list != null) {
                if (list.indexOf(session) != -1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.f1741c.unlock();
        }
    }

    public List<Session> a(SessionRequest sessionRequest) {
        this.f1741c.lock();
        try {
            List<Session> list = this.f1739a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            return Collections.EMPTY_LIST;
        } finally {
            this.f1741c.unlock();
        }
    }

    public Session a(SessionRequest sessionRequest, int i2) {
        this.f1741c.lock();
        try {
            List<Session> list = this.f1739a.get(sessionRequest);
            Session session = null;
            if (list != null && !list.isEmpty()) {
                for (Session session2 : list) {
                    if (session2 != null && session2.isAvailable() && (i2 == anet.channel.entity.c.f1771c || session2.f1630j.getType() == i2)) {
                        session = session2;
                        break;
                    }
                }
                return session;
            }
            return null;
        } finally {
            this.f1741c.unlock();
        }
    }

    public List<SessionRequest> a() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.f1741c.lock();
        try {
            return this.f1739a.isEmpty() ? list : new ArrayList(this.f1739a.keySet());
        } finally {
            this.f1741c.unlock();
        }
    }
}
