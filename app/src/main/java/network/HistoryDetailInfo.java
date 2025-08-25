package network;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HistoryDetailInfo extends BaseBean {
    private String Title;
    public DetailsBean info;
    private int itemType;
    public int os;
    public List<TellPhone> tels = new ArrayList();
    public List<SmsPhone> smSes = new ArrayList();
    public List<App> apps = new ArrayList();
    public List<Image> imgs = new ArrayList();
    public List<Record> mP3s = new ArrayList();
    public List<Video> mP4s = new ArrayList();
    public List<Url> urls = new ArrayList();
    public List<SocialTrad> socials = new ArrayList();
    public List<SocialTrad> payments = new ArrayList();
    public List<Replay> replys = new ArrayList();

    public static class App extends BaseBean {
        public AppInnerPicture appAuthorInfo;
        public String caseReportID;
        public String createTime;
        public AppInnerPicture downloadQRCode;
        public String downloadUrl;
        public String fileID;
        public String id;
        public String name;
        public String occurTime;
        public String type;
        public String updateTime;
        public String version;
        public String virus;
    }

    public static class AppInnerPicture extends BaseBean {
        public String createTime;
        public int fileSize;
        public int heartBeat;
        public String id;
        public String mD5;
        public String name;
        public int source;
        public String sourceID;
        public int status;
        public int timestamp;
        public int type;
        public String updateTime;
        public String uploadEnd;
        public String uploadStart;
        public String url;
    }

    public static class DetailsBean extends BaseBean {
        public String caseCategoryText;
        public String caseDescription;
        public String createTime;
        public String id;
        public String region;
        public int replyStatus;
        public String replyTime;
        public String reporterID;
        public String submitTime;
        public String updateTime;
    }

    public static class Image extends BaseBean {
        public String createTime;
        public String fileSize;
        public String heartBeat;
        public String id;
        public String mD5;
        public String name;
        public String occurTime;
        public String source;
        public String sourceID;
        public String status;
        public String timestamp;
        public String type;
        public String updateTime;
        public String uploadEnd;
        public String uploadStart;
        public String url;
    }

    public static class Record extends BaseBean {
        public String createTime;
        public String fileSize;
        public String heartBeat;
        public String id;
        public String mD5;
        public String name;
        public String occurTime;
        public String source;
        public String sourceID;
        public String status;
        public String timestamp;
        public String type;
        public String updateTime;
        public String uploadEnd;
        public String uploadStart;
        public String url;
    }

    public static class Replay extends BaseBean {
        public String caseID;
        public int caseType;
        public String createTime;
        public String description;
        public String id;
        public int processType;
        public String replyTime;
        public String text;
        public String updateTime;
    }

    public static class SmsPhone extends BaseBean {
        public String caseReportID;
        public String content;
        public String createTime;
        public String id;
        public String number;
        public String occurTime;
        public String updateTime;
        public String url;
    }

    public static class SocialTrad extends BaseBean {
        public String account;
        public String accountType;
        public String caseReportID;
        public String createTime;
        public String id;
        public String occurTime;
        public String paymentType;
        public String updateTime;
    }

    public static class TellPhone extends BaseBean {
        public String caseReportID;
        public String createTime;
        public String id;
        public String number;
        public String occurTime;
        public String updateTime;
    }

    public static class Url extends BaseBean {
        public String caseReportID;
        public String createTime;
        public String id;
        public String occurTime;
        public String updateTime;
        public String url;
    }

    public static class Video extends BaseBean {
        public String createTime;
        public String fileSize;
        public String heartBeat;
        public String id;
        public String mD5;
        public String name;
        public String occurTime;
        public String source;
        public String sourceID;
        public String status;
        public String timestamp;
        public String type;
        public String updateTime;
        public String uploadEnd;
        public String uploadStart;
        public String url;
    }

    public int getItemType() {
        return this.itemType;
    }

    public int getOs() {
        return this.os;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setOs(int i2) {
        this.os = i2;
    }

    public void setTitle(String str) {
        this.Title = str;
    }
}
