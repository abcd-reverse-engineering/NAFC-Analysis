package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class QATypeBean extends BaseBean {
    private int code;
    private String createTime;
    private String description;
    private String id;
    private int isShow;
    private List<QABean> qaList;
    private int sort;
    private String text;
    private String updateTime;

    public int getCode() {
        return this.code;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public int getIsShow() {
        return this.isShow;
    }

    public List<QABean> getQaList() {
        return this.qaList;
    }

    public int getSort() {
        return this.sort;
    }

    public String getText() {
        return this.text;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIsShow(int i2) {
        this.isShow = i2;
    }

    public void setQaList(List<QABean> list) {
        this.qaList = list;
    }

    public void setSort(int i2) {
        this.sort = i2;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }
}
