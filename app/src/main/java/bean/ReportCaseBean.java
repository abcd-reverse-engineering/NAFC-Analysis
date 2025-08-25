package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class ReportCaseBean extends BaseBean {
    private List<RowsBean> rows;
    private int total;
    private int totalPages;

    public static class RowsBean {
        private String caseCategoryText;
        private String caseName;
        private String caseNumber;
        private String confirmFileID;
        private String confirmFileUrl;
        private String confirmTime;
        private String createTime;
        private String documentNumber;
        private String documentTypeText;
        private String id;
        private int isExpired;
        private String name;
        private String policeMobile;
        private String processTime;
        private int redPoint;
        private int replyStatus;
        private int status;
        private String submitUserID;
        private String transferErrorCount;
        private String updateTime;

        public String getCaseCategoryText() {
            return this.caseCategoryText;
        }

        public String getCaseName() {
            return this.caseName;
        }

        public String getCaseNumber() {
            return this.caseNumber;
        }

        public String getConfirmFileID() {
            return this.confirmFileID;
        }

        public String getConfirmFileUrl() {
            return this.confirmFileUrl;
        }

        public String getConfirmTime() {
            return this.confirmTime;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getDocumentNumber() {
            return this.documentNumber;
        }

        public String getDocumentTypeText() {
            return this.documentTypeText;
        }

        public String getId() {
            return this.id;
        }

        public int getIsExpired() {
            return this.isExpired;
        }

        public String getName() {
            return this.name;
        }

        public String getPoliceMobile() {
            return this.policeMobile;
        }

        public String getProcessTime() {
            return this.processTime;
        }

        public int getRedPoint() {
            return this.redPoint;
        }

        public int getReplyStatus() {
            return this.replyStatus;
        }

        public int getStatus() {
            return this.status;
        }

        public String getSubmitUserID() {
            return this.submitUserID;
        }

        public String getTransferErrorCount() {
            return this.transferErrorCount;
        }

        public String getUpdateTime() {
            return this.updateTime;
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

        public void setConfirmFileID(String str) {
            this.confirmFileID = str;
        }

        public void setConfirmFileUrl(String str) {
            this.confirmFileUrl = str;
        }

        public void setConfirmTime(String str) {
            this.confirmTime = str;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setDocumentNumber(String str) {
            this.documentNumber = str;
        }

        public void setDocumentTypeText(String str) {
            this.documentTypeText = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsExpired(int i2) {
            this.isExpired = i2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPoliceMobile(String str) {
            this.policeMobile = str;
        }

        public void setProcessTime(String str) {
            this.processTime = str;
        }

        public void setRedPoint(int i2) {
            this.redPoint = i2;
        }

        public void setReplyStatus(int i2) {
            this.replyStatus = i2;
        }

        public void setStatus(int i2) {
            this.status = i2;
        }

        public void setSubmitUserID(String str) {
            this.submitUserID = str;
        }

        public void setTransferErrorCount(String str) {
            this.transferErrorCount = str;
        }

        public void setUpdateTime(String str) {
            this.updateTime = str;
        }
    }

    public List<RowsBean> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setRows(List<RowsBean> list) {
        this.rows = list;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }

    public void setTotalPages(int i2) {
        this.totalPages = i2;
    }
}
