package com.vivo.push.f;

import ui.activity.BaseProgressUploadActivity;

/* compiled from: PushClientTaskFactory.java */
/* loaded from: classes2.dex */
public final class ah {
    public static com.vivo.push.s a(com.vivo.push.v vVar) {
        int iB = vVar.b();
        if (iB == 20) {
            return new ag(vVar);
        }
        if (iB == 100) {
            return new b(vVar);
        }
        if (iB == 101) {
            return new c(vVar);
        }
        switch (iB) {
            case 0:
                break;
            case 1:
                return new ab(vVar);
            case 2:
                return new l(vVar);
            case 3:
                return new t(vVar);
            case 4:
                return new u(vVar);
            case 5:
                return new x(vVar);
            case 6:
                return new y(vVar);
            case 7:
                return new r(vVar);
            case 8:
                return new p(vVar);
            case 9:
                return new k(vVar);
            case 10:
                return new h(vVar);
            case 11:
                return new ae(vVar);
            case 12:
                return new j(vVar);
            default:
                switch (iB) {
                    case 2000:
                    case BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1 /* 2001 */:
                    case BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2 /* 2002 */:
                    case 2003:
                    case 2004:
                    case 2005:
                    case 2008:
                    case 2009:
                    case 2010:
                    case 2011:
                    case 2012:
                    case 2013:
                    case 2014:
                    case 2015:
                        break;
                    case 2006:
                        return new a(vVar);
                    case 2007:
                        return new aj(vVar);
                    default:
                        return null;
                }
        }
        return new ai(vVar);
    }

    public static aa b(com.vivo.push.v vVar) {
        int iB = vVar.b();
        if (iB == 20) {
            return new ag(vVar);
        }
        if (iB == 2016) {
            return new o(vVar);
        }
        switch (iB) {
            case 1:
                return new ab(vVar);
            case 2:
                return new l(vVar);
            case 3:
                return new t(vVar);
            case 4:
                return new u(vVar);
            case 5:
                return new x(vVar);
            case 6:
                return new y(vVar);
            case 7:
                return new r(vVar);
            case 8:
                return new p(vVar);
            case 9:
                return new k(vVar);
            case 10:
                return new h(vVar);
            case 11:
                return new ae(vVar);
            default:
                return null;
        }
    }
}
