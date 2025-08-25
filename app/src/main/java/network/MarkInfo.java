package network;

/* loaded from: classes2.dex */
public class MarkInfo extends BaseInfo {
    private int caseCategory;
    private String caseCategoryText;
    private String number;

    public MarkInfo() {
        setCommonParams();
    }

    public int getCaseCategory() {
        return this.caseCategory;
    }

    public String getCaseCategoryText() {
        return this.caseCategoryText;
    }

    public String getNumber() {
        return this.number;
    }

    public void setCaseCategory(int i2) {
        this.caseCategory = i2;
    }

    public void setCaseCategoryText(String str) {
        this.caseCategoryText = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }
}
