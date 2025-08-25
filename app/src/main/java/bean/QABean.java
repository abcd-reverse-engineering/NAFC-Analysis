package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class QABean extends BaseBean {
    private String answer;
    private String createTime;
    private String description;
    private String id;
    private int isShow;
    private int qaClassifyCode;
    private String question;
    private int sort;
    private String updateTime;

    public String getAnswer() {
        return this.answer;
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

    public int getQaClassifyCode() {
        return this.qaClassifyCode;
    }

    public String getQuestion() {
        return this.question;
    }

    public int getSort() {
        return this.sort;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setAnswer(String str) {
        this.answer = str;
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

    public void setQaClassifyCode(int i2) {
        this.qaClassifyCode = i2;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public void setSort(int i2) {
        this.sort = i2;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }
}
