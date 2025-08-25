package network;

import java.util.List;

/* loaded from: classes2.dex */
public class SignInfo extends BaseBean {
    private int historySigninIntegral;
    private List<String> serialSignInDates;
    private boolean todayIsSignin;

    public int getHistoryintegral() {
        return this.historySigninIntegral;
    }

    public List<String> getSerialSignInDates() {
        return this.serialSignInDates;
    }

    public boolean isTodayIsSignin() {
        return this.todayIsSignin;
    }

    public void setHistoryintegral(int i2) {
        this.historySigninIntegral = i2;
    }

    public void setSerialSignInDates(List<String> list) {
        this.serialSignInDates = list;
    }

    public void setTodayIsSignin(boolean z) {
        this.todayIsSignin = z;
    }
}
