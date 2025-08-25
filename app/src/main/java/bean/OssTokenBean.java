package bean;

/* loaded from: classes.dex */
public class OssTokenBean {
    private String bucketName;
    private CallBackBean callBack;
    private String endPoint;
    private int isExist;
    private String path;
    private String putFileUrl;
    private int storageType;
    private Credential stsCredentials;

    public static class CallBackBean {
        private String callBackUrl;
        private String callbackBody;

        public String getCallBackUrl() {
            return this.callBackUrl;
        }

        public String getCallbackBody() {
            return this.callbackBody;
        }

        public void setCallBackUrl(String str) {
            this.callBackUrl = str;
        }

        public void setCallbackBody(String str) {
            this.callbackBody = str;
        }
    }

    public static class Credential {
        private String accessKeyId;
        private String accessKeySecret;
        private String expiration;
        private String securityToken;

        public String getAccessKeyId() {
            return this.accessKeyId;
        }

        public String getAccessKeySecret() {
            return this.accessKeySecret;
        }

        public String getExpiration() {
            return this.expiration;
        }

        public String getSecurityToken() {
            return this.securityToken;
        }

        public void setAccessKeyId(String str) {
            this.accessKeyId = str;
        }

        public void setAccessKeySecret(String str) {
            this.accessKeySecret = str;
        }

        public void setExpiration(String str) {
            this.expiration = str;
        }

        public void setSecurityToken(String str) {
            this.securityToken = str;
        }
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public CallBackBean getCallBack() {
        return this.callBack;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public String getPath() {
        return this.path;
    }

    public String getPutFileUrl() {
        return this.putFileUrl;
    }

    public int getStorageType() {
        return this.storageType;
    }

    public Credential getStsCredentials() {
        return this.stsCredentials;
    }

    public int isExist() {
        return this.isExist;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCallBack(CallBackBean callBackBean) {
        this.callBack = callBackBean;
    }

    public void setEndPoint(String str) {
        this.endPoint = str;
    }

    public void setExist(int i2) {
        this.isExist = i2;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPutFileUrl(String str) {
        this.putFileUrl = str;
    }

    public void setStorageType(int i2) {
        this.storageType = i2;
    }

    public void setStsCredentials(Credential credential) {
        this.stsCredentials = credential;
    }
}
