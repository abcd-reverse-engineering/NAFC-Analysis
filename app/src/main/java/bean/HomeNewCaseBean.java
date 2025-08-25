package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class HomeNewCaseBean extends BaseBean {
    private List<RowsBean> rows;
    private int total;
    private int totalPages;

    public static class RowsBean {
        private String author;
        private String authorExtra;
        private String cdnCover;
        private int classify;
        private String classifyName;
        private String content;
        private String content1;
        private String conver;
        private int coverAspectratio;
        private String createTime;
        private String description;
        private String icon;
        private String id;
        private int isTop;
        private List<String> keyWord;
        private String localFilePath;
        private int materialType;
        private int mediaPlayTime;
        private int mterialType;
        private String releaseTime;
        private int saveqrCode;
        private int status;
        private int themeID;
        private String title;
        private String updateTime;
        private String url;

        public String getAuthor() {
            return this.author;
        }

        public String getAuthorExtra() {
            return this.authorExtra;
        }

        public String getCdnCover() {
            return this.cdnCover;
        }

        public int getClassify() {
            return this.classify;
        }

        public String getClassifyName() {
            return this.classifyName;
        }

        public String getContent() {
            return this.content;
        }

        public String getContent1() {
            return this.content1;
        }

        public String getConver() {
            return this.conver;
        }

        public int getCoverAspectratio() {
            return this.coverAspectratio;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getDescription() {
            return this.description;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getId() {
            return this.id;
        }

        public int getIsTop() {
            return this.isTop;
        }

        public List<String> getKeyWord() {
            return this.keyWord;
        }

        public String getLocalFilePath() {
            return this.localFilePath;
        }

        public int getMaterialType() {
            return this.materialType;
        }

        public int getMediaPlayTime() {
            return this.mediaPlayTime;
        }

        public int getMterialType() {
            return this.mterialType;
        }

        public String getReleaseTime() {
            return this.releaseTime;
        }

        public int getSaveqrCode() {
            return this.saveqrCode;
        }

        public int getStatus() {
            return this.status;
        }

        public int getThemeID() {
            return this.themeID;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUpdateTime() {
            return this.updateTime;
        }

        public String getUrl() {
            return this.url;
        }

        public void setAuthor(String str) {
            this.author = str;
        }

        public void setAuthorExtra(String str) {
            this.authorExtra = str;
        }

        public void setCdnCover(String str) {
            this.cdnCover = str;
        }

        public void setClassify(int i2) {
            this.classify = i2;
        }

        public void setClassifyName(String str) {
            this.classifyName = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setContent1(String str) {
            this.content1 = str;
        }

        public void setConver(String str) {
            this.conver = str;
        }

        public void setCoverAspectratio(int i2) {
            this.coverAspectratio = i2;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsTop(int i2) {
            this.isTop = i2;
        }

        public void setKeyWord(List<String> list) {
            this.keyWord = list;
        }

        public void setLocalFilePath(String str) {
            this.localFilePath = str;
        }

        public void setMaterialType(int i2) {
            this.materialType = i2;
        }

        public void setMediaPlayTime(int i2) {
            this.mediaPlayTime = i2;
        }

        public void setMterialType(int i2) {
            this.mterialType = i2;
        }

        public void setReleaseTime(String str) {
            this.releaseTime = str;
        }

        public void setSaveqrCode(int i2) {
            this.saveqrCode = i2;
        }

        public void setStatus(int i2) {
            this.status = i2;
        }

        public void setThemeID(int i2) {
            this.themeID = i2;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUpdateTime(String str) {
            this.updateTime = str;
        }

        public void setUrl(String str) {
            this.url = str;
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
