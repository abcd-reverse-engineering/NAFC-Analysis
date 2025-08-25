package network;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HistoryInfo extends BaseBean {
    private List<RowsBean> rows = new ArrayList();
    private int total;

    public static class RowsBean extends BaseBean {
        private int caseCategory;
        private String caseCategoryText;
        private String caseDescription;
        private int clusterID;
        private String createTime;
        private String createUser;
        private DetailsBean details;
        private String id;
        private boolean isDeleted;
        private int objectType;
        private String reporterID;
        private String submitTime;
        private String updateTime;
        private String updateUser;

        public static class DetailsBean {
            private int total = 0;
            private int waitCount = 0;
            private int uploadingCount = 0;
            private int successCount = 0;
            private int failCount = 0;

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

        public int getClusterID() {
            return this.clusterID;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getCreateUser() {
            return this.createUser;
        }

        public DetailsBean getDetails() {
            return this.details;
        }

        public String getId() {
            return this.id;
        }

        public int getObjectType() {
            return this.objectType;
        }

        public String getReporterID() {
            return this.reporterID;
        }

        public String getSubmitTime() {
            return this.submitTime;
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

        public void setClusterID(int i2) {
            this.clusterID = i2;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setCreateUser(String str) {
            this.createUser = str;
        }

        public void setDetails(DetailsBean detailsBean) {
            this.details = detailsBean;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsDeleted(boolean z) {
            this.isDeleted = z;
        }

        public void setObjectType(int i2) {
            this.objectType = i2;
        }

        public void setReporterID(String str) {
            this.reporterID = str;
        }

        public void setSubmitTime(String str) {
            this.submitTime = str;
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
