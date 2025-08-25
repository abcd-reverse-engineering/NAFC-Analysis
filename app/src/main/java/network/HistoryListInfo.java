package network;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HistoryListInfo extends BaseBean {
    private List<RowsBean> rows = new ArrayList();
    private String total;

    public static class RowsBean extends BaseBean {
        private String evidenceCount;
        private DetailsBean info;

        public static class DetailsBean extends BaseBean {
            private String caseCategoryText;
            private String caseDescription;
            private String caseNumber;
            private String createTime;
            private String id;
            private boolean isSelf;
            private int redPoint;
            private String region;
            private int replyStatus;
            private String replyTime;
            private String reporterID;
            private String reporterIdNumber;
            private String reporterName;
            private String reporterPhoneNumber;
            private String submitTime;
            private String submitterID;
            private int type;
            private String updateTime;

            public String getCaseCategoryText() {
                return this.caseCategoryText;
            }

            public String getCaseDescription() {
                return this.caseDescription;
            }

            public String getCaseNumber() {
                return this.caseNumber;
            }

            public String getCreateTime() {
                return this.createTime;
            }

            public String getId() {
                return this.id;
            }

            public int getRedPoint() {
                return this.redPoint;
            }

            public String getRegion() {
                return this.region;
            }

            public int getReplyStatus() {
                return this.replyStatus;
            }

            public String getReplyTime() {
                return this.replyTime;
            }

            public String getReporterID() {
                return this.reporterID;
            }

            public String getReporterIdNumber() {
                return this.reporterIdNumber;
            }

            public String getReporterName() {
                return this.reporterName;
            }

            public String getReporterPhoneNumber() {
                return this.reporterPhoneNumber;
            }

            public String getSubmitTime() {
                return this.submitTime;
            }

            public String getSubmitterID() {
                return this.submitterID;
            }

            public int getType() {
                return this.type;
            }

            public String getUpdateTime() {
                return this.updateTime;
            }

            public boolean isSelf() {
                return this.isSelf;
            }

            public void setCaseCategoryText(String str) {
                this.caseCategoryText = str;
            }

            public void setCaseDescription(String str) {
                this.caseDescription = str;
            }

            public void setCaseNumber(String str) {
                this.caseNumber = str;
            }

            public void setCreateTime(String str) {
                this.createTime = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setRedPoint(int i2) {
                this.redPoint = i2;
            }

            public void setRegion(String str) {
                this.region = str;
            }

            public void setReplyStatus(int i2) {
                this.replyStatus = i2;
            }

            public void setReplyTime(String str) {
                this.replyTime = str;
            }

            public void setReporterID(String str) {
                this.reporterID = str;
            }

            public void setReporterIdNumber(String str) {
                this.reporterIdNumber = str;
            }

            public void setReporterName(String str) {
                this.reporterName = str;
            }

            public void setReporterPhoneNumber(String str) {
                this.reporterPhoneNumber = str;
            }

            public void setSelf(boolean z) {
                this.isSelf = z;
            }

            public void setSubmitTime(String str) {
                this.submitTime = str;
            }

            public void setSubmitterID(String str) {
                this.submitterID = str;
            }

            public void setType(int i2) {
                this.type = i2;
            }

            public void setUpdateTime(String str) {
                this.updateTime = str;
            }
        }

        public String getEvidenceCount() {
            return this.evidenceCount;
        }

        public DetailsBean getInfo() {
            return this.info;
        }

        public void setEvidenceCount(String str) {
            this.evidenceCount = str;
        }

        public void setInfo(DetailsBean detailsBean) {
            this.info = detailsBean;
        }
    }

    public List<RowsBean> getRows() {
        return this.rows;
    }

    public String getTotal() {
        return this.total;
    }

    public void setRows(List<RowsBean> list) {
        this.rows = list;
    }

    public void setTotal(String str) {
        this.total = str;
    }
}
