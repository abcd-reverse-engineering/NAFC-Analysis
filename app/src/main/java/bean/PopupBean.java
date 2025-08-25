package bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PopupBean {
    private int closeable;
    private String content;
    private String createTime;
    private String endTime;
    private long id;
    private int imgHeight;
    private int imgWidth;
    private String linkTitle;
    private int openType;
    private List<PopupBtnBean> popupBtns = new ArrayList();
    private int popupCountType;
    private String startTime;
    private String title;
    private String to;
    private int type;
    private String updateTime;

    public int getCloseable() {
        return this.closeable;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public long getId() {
        return this.id;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public String getLinkTitle() {
        return this.linkTitle;
    }

    public int getOpenType() {
        return this.openType;
    }

    public List<PopupBtnBean> getPopupBtns() {
        return this.popupBtns;
    }

    public int getPopupCountType() {
        return this.popupCountType;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTo() {
        return this.to;
    }

    public int getType() {
        return this.type;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setCloseable(int i2) {
        this.closeable = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setId(long j2) {
        this.id = j2;
    }

    public void setImgHeight(int i2) {
        this.imgHeight = i2;
    }

    public void setImgWidth(int i2) {
        this.imgWidth = i2;
    }

    public void setLinkTitle(String str) {
        this.linkTitle = str;
    }

    public void setOpenType(int i2) {
        this.openType = i2;
    }

    public void setPopupBtns(List<PopupBtnBean> list) {
        this.popupBtns = list;
    }

    public void setPopupCountType(int i2) {
        this.popupCountType = i2;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }
}
