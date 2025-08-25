package network;

import java.util.List;

/* loaded from: classes2.dex */
public class HistoryElectronicDetailInfo extends BaseBean {
    private int caseCategory;
    private String caseCategoryText;
    private String caseDescription;
    private String caseNumber;
    private int clusterID;
    private String createTime;
    private String createUser;
    private List<FileDetailsBean> fileDetails;
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
        private boolean isDeleted;
        private String url = "";
        private String name = "";
        private String mD5 = "";
        private int type = 0;
        private int status = 0;
        private int source = 0;
        private String sourceID = "";
        private int timestamp = 0;
        private int heartBeat = 0;
        private int clusterID = 0;
        private String id = "";
        private String createTime = "";
        private String createUser = "";
        private String updateTime = "";
        private String updateUser = "";

        public int getClusterID() {
            return this.clusterID;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getCreateUser() {
            return this.createUser;
        }

        public int getHeartBeat() {
            return this.heartBeat;
        }

        public String getId() {
            return this.id;
        }

        public String getMD5() {
            return this.mD5;
        }

        public String getName() {
            return this.name;
        }

        public int getSource() {
            return this.source;
        }

        public String getSourceID() {
            return this.sourceID;
        }

        public int getStatus() {
            return this.status;
        }

        public int getTimestamp() {
            return this.timestamp;
        }

        public int getType() {
            return this.type;
        }

        public String getUpdateTime() {
            return this.updateTime;
        }

        public String getUpdateUser() {
            return this.updateUser;
        }

        public String getUrl() {
            return this.url;
        }

        public boolean isIsDeleted() {
            return this.isDeleted;
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

        public void setHeartBeat(int i2) {
            this.heartBeat = i2;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsDeleted(boolean z) {
            this.isDeleted = z;
        }

        public void setMD5(String str) {
            this.mD5 = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setSource(int i2) {
            this.source = i2;
        }

        public void setSourceID(String str) {
            this.sourceID = str;
        }

        public void setStatus(int i2) {
            this.status = i2;
        }

        public void setTimestamp(int i2) {
            this.timestamp = i2;
        }

        public void setType(int i2) {
            this.type = i2;
        }

        public void setUpdateTime(String str) {
            this.updateTime = str;
        }

        public void setUpdateUser(String str) {
            this.updateUser = str;
        }

        public void setUrl(String str) {
            this.url = str;
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

    public List<FileDetailsBean> getFileDetails() {
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

    public void setFileDetails(List<FileDetailsBean> list) {
        this.fileDetails = list;
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
