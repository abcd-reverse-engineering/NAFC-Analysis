package network;

import java.util.List;

/* loaded from: classes2.dex */
public class HistoryElectronicInfo extends BaseBean {
    private List<RowsBean> rows;
    private int total;

    public static class RowsBean extends BaseBean {
        private int caseCategory;
        private String caseCategoryText;
        private String caseDescription;
        private String caseNumber;
        private int clusterID;
        private String createTime;
        private String createUser;
        private FileDetailsBean fileDetails;
        private String id;
        private boolean isDeleted;
        private String reporterIdNumber;
        private String reporterName;
        private String reporterPhoneNumber;
        private String submitTime;
        private String submitterID;
        private String updateTime;
        private String updateUser;

        public static class FileDetailsBean extends BaseBean {
            private int failCount;
            private int successCount;
            private int total;
            private int uploadingCount;
            private int waitCount;

            public int getFailCount() {
                return this.failCount;
            }

            public int getSuccessCount() {
                return this.successCount;
            }

            public int getTotal() {
                return this.total;
            }

            public int getUploadingCount() {
                return this.uploadingCount;
            }

            public int getWaitCount() {
                return this.waitCount;
            }

            public void setFailCount(int i2) {
                this.failCount = i2;
            }

            public void setSuccessCount(int i2) {
                this.successCount = i2;
            }

            public void setTotal(int i2) {
                this.total = i2;
            }

            public void setUploadingCount(int i2) {
                this.uploadingCount = i2;
            }

            public void setWaitCount(int i2) {
                this.waitCount = i2;
            }
        }

        public int getCaseCategory() {
            return this.caseCategory;
        }

        public String getCaseCategoryText() {
            return this.caseCategoryText;
        }

        public String getCaseDescription() {
            return this.caseDescription;
        }

        public String getCaseNumber() {
            return this.caseNumber;
        }

        public int getClusterID() {
            return this.clusterID;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getCreateUser() {
            return this.createUser;
        }

        public FileDetailsBean getFileDetails() {
            return this.fileDetails;
        }

        public String getId() {
            return this.id;
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

        public String getUpdateTime() {
            return this.updateTime;
        }

        public String getUpdateUser() {
            return this.updateUser;
        }

        public boolean isIsDeleted() {
            return this.isDeleted;
        }

        public void setCaseCategory(int i2) {
            this.caseCategory = i2;
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

        public void setClusterID(int i2) {
            this.clusterID = i2;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setCreateUser(String str) {
            this.createUser = str;
        }

        public void setFileDetails(FileDetailsBean fileDetailsBean) {
            this.fileDetails = fileDetailsBean;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsDeleted(boolean z) {
            this.isDeleted = z;
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

        public void setSubmitTime(String str) {
            this.submitTime = str;
        }

        public void setSubmitterID(String str) {
            this.submitterID = str;
        }

        public void setUpdateTime(String str) {
            this.updateTime = str;
        }

        public void setUpdateUser(String str) {
            this.updateUser = str;
        }
    }

    public List<RowsBean> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public void setRows(List<RowsBean> list) {
        this.rows = list;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }
}
