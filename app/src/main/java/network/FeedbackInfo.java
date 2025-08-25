package network;

import bean.OssFileInfo;
import java.util.List;

/* loaded from: classes2.dex */
public class FeedbackInfo extends BaseBean {
    private int classifyCode;
    private String content;
    private List<OssFileInfo> fileInfos;
    private String mobileNumber;

    public int getClassifyCode() {
        return this.classifyCode;
    }

    public String getContent() {
        return this.content;
    }

    public List<OssFileInfo> getFileInfos() {
        return this.fileInfos;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setClassifyCode(int i2) {
        this.classifyCode = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFileInfos(List<OssFileInfo> list) {
        this.fileInfos = list;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }
}
