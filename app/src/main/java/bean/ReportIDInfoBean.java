package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ReportIDInfoBean extends BaseBean {
    private String caseCategoryText;
    private String caseName;
    private String caseNumber;
    private String processTime;

    public String getCaseCategoryText() {
        return this.caseCategoryText;
    }

    public String getCaseName() {
        return this.caseName;
    }

    public String getCaseNumber() {
        return this.caseNumber;
    }

    public String getProcessTime() {
        return this.processTime;
    }

    public void setCaseCategoryText(String str) {
        this.caseCategoryText = str;
    }

    public void setCaseName(String str) {
        this.caseName = str;
    }

    public void setCaseNumber(String str) {
        this.caseNumber = str;
    }

    public void setProcessTime(String str) {
        this.processTime = str;
    }
}
