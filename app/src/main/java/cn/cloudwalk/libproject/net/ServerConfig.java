package cn.cloudwalk.libproject.net;

/* loaded from: classes.dex */
public class ServerConfig {
    private String faceAppSecret;
    private String faceAppid;
    private String faceServer;
    private String licence;

    public ServerConfig() {
    }

    public String getFaceAppSecret() {
        return this.faceAppSecret;
    }

    public String getFaceAppid() {
        return this.faceAppid;
    }

    public String getFaceServer() {
        return this.faceServer;
    }

    public String getLicence() {
        return this.licence;
    }

    public void setFaceAppSecret(String str) {
        this.faceAppSecret = str;
    }

    public void setFaceAppid(String str) {
        this.faceAppid = str;
    }

    public void setFaceServer(String str) {
        this.faceServer = str;
    }

    public void setLicence(String str) {
        this.licence = str;
    }

    public ServerConfig(String str, String str2, String str3, String str4) {
        this.faceServer = str;
        this.faceAppid = str2;
        this.faceAppSecret = str3;
        this.licence = str4;
    }
}
