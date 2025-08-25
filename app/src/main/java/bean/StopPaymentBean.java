package bean;

import h.y;
import i.c.a.e;
import network.BaseBean;

/* compiled from: StopPaymentBean.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lbean/StopPaymentBean;", "Lnetwork/BaseBean;", "()V", "paymentTime", "", "getPaymentTime", "()Ljava/lang/String;", "setPaymentTime", "(Ljava/lang/String;)V", "suspectAccount", "getSuspectAccount", "setSuspectAccount", "suspectAccountType", "getSuspectAccountType", "setSuspectAccountType", "suspectAccountTypeText", "getSuspectAccountTypeText", "setSuspectAccountTypeText", "suspectName", "getSuspectName", "setSuspectName", "transferAmount", "getTransferAmount", "setTransferAmount", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class StopPaymentBean extends BaseBean {

    @e
    private String paymentTime = "";

    @e
    private String suspectAccountType = "";

    @e
    private String suspectAccountTypeText = "";

    @e
    private String suspectAccount = "";

    @e
    private String suspectName = "";

    @e
    private String transferAmount = "";

    @e
    public final String getPaymentTime() {
        return this.paymentTime;
    }

    @e
    public final String getSuspectAccount() {
        return this.suspectAccount;
    }

    @e
    public final String getSuspectAccountType() {
        return this.suspectAccountType;
    }

    @e
    public final String getSuspectAccountTypeText() {
        return this.suspectAccountTypeText;
    }

    @e
    public final String getSuspectName() {
        return this.suspectName;
    }

    @e
    public final String getTransferAmount() {
        return this.transferAmount;
    }

    public final void setPaymentTime(@e String str) {
        this.paymentTime = str;
    }

    public final void setSuspectAccount(@e String str) {
        this.suspectAccount = str;
    }

    public final void setSuspectAccountType(@e String str) {
        this.suspectAccountType = str;
    }

    public final void setSuspectAccountTypeText(@e String str) {
        this.suspectAccountTypeText = str;
    }

    public final void setSuspectName(@e String str) {
        this.suspectName = str;
    }

    public final void setTransferAmount(@e String str) {
        this.transferAmount = str;
    }
}
