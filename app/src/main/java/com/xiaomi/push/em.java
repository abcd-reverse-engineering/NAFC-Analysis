package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
final class em {

    static class a {

        /* renamed from: a, reason: collision with root package name */
        ei f12772a;

        /* renamed from: a, reason: collision with other field name */
        String f449a;

        a() {
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m380a(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Throwable] */
    static a b(Exception exc) {
        Throwable cause;
        m380a(exc);
        boolean z = exc instanceof fi;
        Exception excA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            excA = exc;
            if (fiVar.a() != null) {
                excA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = excA.getMessage();
        if (excA.getCause() != null) {
            message = excA.getCause().getMessage();
        }
        int iA = fc.a(excA);
        String str = excA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA != 0) {
            aVar.f12772a = ei.a(ei.CONN_SUCCESS.a() + iA);
            if (aVar.f12772a == ei.CONN_BOSH_ERR && (cause = excA.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f12772a = ei.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f12772a = ei.CONN_XMPP_ERR;
        }
        ei eiVar = aVar.f12772a;
        if (eiVar == ei.CONN_TCP_ERR_OTHER || eiVar == ei.CONN_XMPP_ERR || eiVar == ei.CONN_BOSH_ERR) {
            aVar.f449a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    static a c(Exception exc) {
        m380a(exc);
        boolean z = exc instanceof fi;
        Exception excA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            excA = exc;
            if (fiVar.a() != null) {
                excA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = excA.getMessage();
        if (excA.getCause() != null) {
            message = excA.getCause().getMessage();
        }
        int iA = fc.a(excA);
        String str = excA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA == 105) {
            aVar.f12772a = ei.BIND_TCP_READ_TIMEOUT;
        } else if (iA == 199) {
            aVar.f12772a = ei.BIND_TCP_ERR;
        } else if (iA == 499) {
            aVar.f12772a = ei.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f12772a = ei.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (iA == 109) {
            aVar.f12772a = ei.BIND_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.f12772a = ei.BIND_XMPP_ERR;
        } else {
            aVar.f12772a = ei.BIND_TCP_BROKEN_PIPE;
        }
        ei eiVar = aVar.f12772a;
        if (eiVar == ei.BIND_TCP_ERR || eiVar == ei.BIND_XMPP_ERR || eiVar == ei.BIND_BOSH_ERR) {
            aVar.f449a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    static a d(Exception exc) {
        m380a(exc);
        boolean z = exc instanceof fi;
        Exception excA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            excA = exc;
            if (fiVar.a() != null) {
                excA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = excA.getMessage();
        int iA = fc.a(excA);
        String str = excA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA == 105) {
            aVar.f12772a = ei.CHANNEL_TCP_READTIMEOUT;
        } else if (iA == 199) {
            aVar.f12772a = ei.CHANNEL_TCP_ERR;
        } else if (iA == 499) {
            aVar.f12772a = ei.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f12772a = ei.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (iA == 109) {
            aVar.f12772a = ei.CHANNEL_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.f12772a = ei.CHANNEL_XMPPEXCEPTION;
        } else {
            aVar.f12772a = ei.CHANNEL_TCP_BROKEN_PIPE;
        }
        ei eiVar = aVar.f12772a;
        if (eiVar == ei.CHANNEL_TCP_ERR || eiVar == ei.CHANNEL_XMPPEXCEPTION || eiVar == ei.CHANNEL_BOSH_EXCEPTION) {
            aVar.f449a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    static a a(Exception exc) {
        m380a(exc);
        boolean z = exc instanceof fi;
        Exception excA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            excA = exc;
            if (fiVar.a() != null) {
                excA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = excA.getMessage();
        if (excA.getCause() != null) {
            message = excA.getCause().getMessage();
        }
        String str = excA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int iA = fc.a(excA);
        if (iA != 0) {
            aVar.f12772a = ei.a(ei.GSLB_REQUEST_SUCCESS.a() + iA);
        }
        if (aVar.f12772a == null) {
            aVar.f12772a = ei.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f12772a == ei.GSLB_TCP_ERR_OTHER) {
            aVar.f449a = str;
        }
        return aVar;
    }
}
