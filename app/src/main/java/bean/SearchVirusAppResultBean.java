package bean;

import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: SearchVirusAppResultBean.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lbean/SearchVirusAppResultBean;", "", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "fileMd5", "getFileMd5", "setFileMd5", "riskLevel", "", "getRiskLevel", "()I", "setRiskLevel", "(I)V", "virusDesc", "getVirusDesc", "setVirusDesc", "virusName", "getVirusName", "setVirusName", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SearchVirusAppResultBean {
    private int riskLevel;

    @d
    private String content = "";

    @d
    private String fileMd5 = "";

    @d
    private String virusName = "";

    @d
    private String virusDesc = "";

    @d
    public final String getContent() {
        return this.content;
    }

    @d
    public final String getFileMd5() {
        return this.fileMd5;
    }

    public final int getRiskLevel() {
        return this.riskLevel;
    }

    @d
    public final String getVirusDesc() {
        return this.virusDesc;
    }

    @d
    public final String getVirusName() {
        return this.virusName;
    }

    public final void setContent(@d String str) {
        i0.f(str, "<set-?>");
        this.content = str;
    }

    public final void setFileMd5(@d String str) {
        i0.f(str, "<set-?>");
        this.fileMd5 = str;
    }

    public final void setRiskLevel(int i2) {
        this.riskLevel = i2;
    }

    public final void setVirusDesc(@d String str) {
        i0.f(str, "<set-?>");
        this.virusDesc = str;
    }

    public final void setVirusName(@d String str) {
        i0.f(str, "<set-?>");
        this.virusName = str;
    }
}
