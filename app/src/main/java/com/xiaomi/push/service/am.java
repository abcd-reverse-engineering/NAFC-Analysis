package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static am f13343a;

    /* renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f989a = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private List<a> f988a = new ArrayList();

    public interface a {
        void a();
    }

    public static class b {

        /* renamed from: a, reason: collision with other field name */
        public Context f990a;

        /* renamed from: a, reason: collision with other field name */
        Messenger f992a;

        /* renamed from: a, reason: collision with other field name */
        private XMPushService f994a;

        /* renamed from: a, reason: collision with other field name */
        public h f997a;

        /* renamed from: a, reason: collision with other field name */
        public String f998a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f1000a;

        /* renamed from: b, reason: collision with other field name */
        public String f1001b;

        /* renamed from: c, reason: collision with root package name */
        public String f13346c;

        /* renamed from: d, reason: collision with root package name */
        public String f13347d;

        /* renamed from: e, reason: collision with root package name */
        public String f13348e;

        /* renamed from: f, reason: collision with root package name */
        public String f13349f;

        /* renamed from: g, reason: collision with root package name */
        public String f13350g;

        /* renamed from: h, reason: collision with root package name */
        public String f13351h;

        /* renamed from: i, reason: collision with root package name */
        public String f13352i;

        /* renamed from: a, reason: collision with other field name */
        c f996a = c.unbind;

        /* renamed from: a, reason: collision with root package name */
        private int f13344a = 0;

        /* renamed from: a, reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f999a = new CopyOnWriteArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        c f13345b = null;

        /* renamed from: b, reason: collision with other field name */
        private boolean f1002b = false;

        /* renamed from: a, reason: collision with other field name */
        private XMPushService.c f993a = new XMPushService.c(this);

        /* renamed from: a, reason: collision with other field name */
        IBinder.DeathRecipient f991a = null;

        /* renamed from: a, reason: collision with other field name */
        final C0165b f995a = new C0165b();

        public interface a {
            void a(c cVar, c cVar2, int i2);
        }

        class c implements IBinder.DeathRecipient {

            /* renamed from: a, reason: collision with root package name */
            final Messenger f13357a;

            /* renamed from: a, reason: collision with other field name */
            final b f1005a;

            c(b bVar, Messenger messenger) {
                this.f1005a = bVar;
                this.f13357a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f1005a.f13350g);
                int i2 = 0;
                b.this.f994a.a(new XMPushService.j(i2) { // from class: com.xiaomi.push.service.am.b.c.1
                    @Override // com.xiaomi.push.service.XMPushService.j
                    public String a() {
                        return "clear peer job";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.j
                    /* renamed from: a */
                    public void mo379a() {
                        c cVar = c.this;
                        if (cVar.f13357a == cVar.f1005a.f992a) {
                            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + c.this.f1005a.f13350g);
                            c.this.f1005a.f992a = null;
                        }
                    }
                }, 0L);
                if ("9".equals(this.f1005a.f13350g) && "com.xiaomi.xmsf".equals(b.this.f994a.getPackageName())) {
                    b.this.f994a.a(new XMPushService.j(i2) { // from class: com.xiaomi.push.service.am.b.c.2
                        @Override // com.xiaomi.push.service.XMPushService.j
                        public String a() {
                            return "check peer job";
                        }

                        @Override // com.xiaomi.push.service.XMPushService.j
                        /* renamed from: a */
                        public void mo379a() {
                            am amVarA = am.a();
                            b bVar = c.this.f1005a;
                            if (amVarA.a(bVar.f13350g, bVar.f1001b).f992a == null) {
                                XMPushService xMPushService = b.this.f994a;
                                b bVar2 = c.this.f1005a;
                                xMPushService.a(bVar2.f13350g, bVar2.f1001b, 2, null, null);
                            }
                        }
                    }, com.heytap.mcssdk.constant.a.f5800d);
                }
            }
        }

        public b() {
        }

        private boolean b(int i2, int i3, String str) {
            if (i2 == 1) {
                return (this.f996a == c.binded || !this.f994a.m668c() || i3 == 21 || (i3 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i2 == 2) {
                return this.f994a.m668c();
            }
            if (i2 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: com.xiaomi.push.service.am$b$b, reason: collision with other inner class name */
        class C0165b extends XMPushService.j {

            /* renamed from: a, reason: collision with other field name */
            String f1003a;

            /* renamed from: b, reason: collision with root package name */
            int f13355b;

            /* renamed from: b, reason: collision with other field name */
            String f1004b;

            /* renamed from: c, reason: collision with root package name */
            int f13356c;

            public C0165b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() throws RemoteException {
                if (b.this.a(this.f13355b, this.f13356c, this.f1004b)) {
                    b.this.a(this.f13355b, this.f13356c, this.f1003a, this.f1004b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.f13350g);
            }

            public XMPushService.j a(int i2, int i3, String str, String str2) {
                this.f13355b = i2;
                this.f13356c = i3;
                this.f1004b = str2;
                this.f1003a = str;
                return this;
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        void m699a() {
            try {
                Messenger messenger = this.f992a;
                if (messenger != null && this.f991a != null) {
                    messenger.getBinder().unlinkToDeath(this.f991a, 0);
                }
            } catch (Exception unused) {
            }
            this.f13345b = null;
        }

        public void b(a aVar) {
            this.f999a.remove(aVar);
        }

        void a(Messenger messenger) {
            m699a();
            try {
                if (messenger != null) {
                    this.f992a = messenger;
                    this.f1002b = true;
                    this.f991a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f991a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.f13350g);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e2.getMessage());
                this.f992a = null;
                this.f1002b = false;
            }
        }

        public b(XMPushService xMPushService) {
            this.f994a = xMPushService;
            a(new a() { // from class: com.xiaomi.push.service.am.b.1
                @Override // com.xiaomi.push.service.am.b.a
                public void a(c cVar, c cVar2, int i2) {
                    if (cVar2 == c.binding) {
                        b.this.f994a.a(b.this.f993a, com.heytap.mcssdk.constant.a.f5800d);
                    } else {
                        b.this.f994a.b(b.this.f993a);
                    }
                }
            });
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            Iterator<a> it = this.f999a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(this.f996a, cVar, i3);
                }
            }
            c cVar2 = this.f996a;
            int i4 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m50a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), an.a(i3), str, str2, this.f13350g));
                this.f996a = cVar;
            }
            if (this.f997a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.f13345b != null && (z = this.f1002b)) {
                i4 = (this.f992a == null || !z) ? Constants.REQUEST_API : 1000;
            }
            this.f994a.b(this.f995a);
            if (b(i2, i3, str2)) {
                a(i2, i3, str, str2);
            } else {
                this.f994a.a(this.f995a.a(i2, i3, str, str2), i4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) throws RemoteException {
            c cVar = this.f996a;
            this.f13345b = cVar;
            if (i2 == 2) {
                this.f997a.a(this.f990a, this, i3);
                return;
            }
            if (i2 == 3) {
                this.f997a.a(this.f990a, this, str2, str);
                return;
            }
            if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f13344a++;
                } else if (z) {
                    this.f13344a = 0;
                    if (this.f992a != null) {
                        try {
                            this.f992a.send(Message.obtain(null, 16, this.f994a.f935a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f997a.a(this.f994a, this, z, i3, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i2, int i3, String str) {
            boolean z;
            c cVar = this.f13345b;
            if (cVar == null || !(z = this.f1002b)) {
                return true;
            }
            if (cVar == this.f996a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.f13350g);
                return false;
            }
            if (this.f992a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.f13350g);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.f13350g);
            return false;
        }

        public void a(a aVar) {
            this.f999a.add(aVar);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f13344a + 1) * 15)) * 1000;
        }

        public static String a(String str) {
            int iLastIndexOf;
            return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(iLastIndexOf + 1);
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private am() {
    }

    public static synchronized am a() {
        if (f13343a == null) {
            f13343a = new am();
        }
        return f13343a;
    }

    public synchronized void b() {
        this.f988a.clear();
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> map = this.f989a.get(bVar.f13350g);
        if (map == null) {
            map = new HashMap<>();
            this.f989a.put(bVar.f13350g, map);
        }
        map.put(a(bVar.f1001b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m50a("add active client. " + bVar.f998a);
        Iterator<a> it = this.f988a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m697a(String str, String str2) {
        HashMap<String, b> map = this.f989a.get(str);
        if (map != null) {
            b bVar = map.get(a(str2));
            if (bVar != null) {
                bVar.m699a();
            }
            map.remove(a(str2));
            if (map.isEmpty()) {
                this.f989a.remove(str);
            }
        }
        Iterator<a> it = this.f988a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m696a(String str) {
        HashMap<String, b> map = this.f989a.get(str);
        if (map != null) {
            Iterator<b> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().m699a();
            }
            map.clear();
            this.f989a.remove(str);
        }
        Iterator<a> it2 = this.f988a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized List<String> m694a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f989a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f998a)) {
                    arrayList.add(bVar.f13350g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<b> m692a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f989a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<b> m693a(String str) {
        if (!this.f989a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f989a.get(str).clone()).values();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> map = this.f989a.get(str);
        if (map == null) {
            return null;
        }
        return map.get(a(str2));
    }

    public synchronized void a(Context context, int i2) {
        Iterator<HashMap<String, b>> it = this.f989a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 2, i2, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m691a() {
        return this.f989a.size();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m695a() {
        Iterator<b> it = m692a().iterator();
        while (it.hasNext()) {
            it.next().m699a();
        }
        this.f989a.clear();
    }

    public synchronized void a(Context context) {
        Iterator<HashMap<String, b>> it = this.f989a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("@");
        return iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
    }

    public synchronized void a(a aVar) {
        this.f988a.add(aVar);
    }
}
