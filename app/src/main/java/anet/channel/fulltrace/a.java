package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile IFullTraceAnalysis f1775a = new C0014a(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1776b = false;

    /* compiled from: Taobao */
    /* renamed from: anet.channel.fulltrace.a$a, reason: collision with other inner class name */
    private static class C0014a implements IFullTraceAnalysis {

        /* renamed from: a, reason: collision with root package name */
        private IFullTraceAnalysis f1777a;

        C0014a(IFullTraceAnalysis iFullTraceAnalysis) {
            this.f1777a = iFullTraceAnalysis;
            boolean unused = a.f1776b = true;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public void commitRequest(String str, RequestStatistic requestStatistic) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (a.f1776b && (iFullTraceAnalysis = this.f1777a) != null) {
                try {
                    iFullTraceAnalysis.commitRequest(str, requestStatistic);
                } catch (Throwable th) {
                    boolean unused = a.f1776b = false;
                    ALog.e("anet.AnalysisFactory", "fulltrace commit fail.", null, th, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public String createRequest() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f1776b || (iFullTraceAnalysis = this.f1777a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.createRequest();
            } catch (Throwable th) {
                boolean unused = a.f1776b = false;
                ALog.e("anet.AnalysisFactory", "createRequest fail.", null, th, new Object[0]);
                return null;
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public b getSceneInfo() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f1776b || (iFullTraceAnalysis = this.f1777a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.getSceneInfo();
            } catch (Throwable th) {
                boolean unused = a.f1776b = false;
                ALog.e("anet.AnalysisFactory", "getSceneInfo fail", null, th, new Object[0]);
                return null;
            }
        }
    }

    public static IFullTraceAnalysis a() {
        return f1775a;
    }

    public static void a(IFullTraceAnalysis iFullTraceAnalysis) {
        f1775a = new C0014a(iFullTraceAnalysis);
    }
}
