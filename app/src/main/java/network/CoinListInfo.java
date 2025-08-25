package network;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class CoinListInfo extends BaseBean {
    private int availableIntegral;
    private int historyIntegral;
    private ArrayList<CoinsBean> integralItems = new ArrayList<>();

    public static class CoinsBean extends BaseBean {
        private String integralRule;
        private int intergalChange;
        private String intergalChangeTime;

        public String getIntegralRule() {
            return this.integralRule;
        }

        public int getIntergalChange() {
            return this.intergalChange;
        }

        public String getIntergalChangeTime() {
            return this.intergalChangeTime;
        }

        public void setIntegralRule(String str) {
            this.integralRule = str;
        }

        public void setIntergalChange(int i2) {
            this.intergalChange = i2;
        }

        public void setIntergalChangeTime(String str) {
            this.intergalChangeTime = str;
        }
    }

    public int getAvailableIntegral() {
        return this.availableIntegral;
    }

    public int getHistoryIntegral() {
        return this.historyIntegral;
    }

    public ArrayList<CoinsBean> getIntegralItems() {
        return this.integralItems;
    }

    public void setAvailableIntegral(int i2) {
        this.availableIntegral = i2;
    }

    public void setHistoryIntegral(int i2) {
        this.historyIntegral = i2;
    }

    public void setIntegralItems(ArrayList<CoinsBean> arrayList) {
        this.integralItems = arrayList;
    }
}
