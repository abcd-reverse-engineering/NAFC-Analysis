package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class CheckFraudBean extends BaseBean {
    private String bankName;
    private String content;
    private int isCheat;
    private List<Integer> soue;
    private String text;
    private int type;

    public String getBankName() {
        return this.bankName;
    }

    public String getContent() {
        return this.content;
    }

    public int getIsCheat() {
        return this.isCheat;
    }

    public List<Integer> getSource() {
        return this.soue;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIsCheat(int i2) {
        this.isCheat = i2;
    }

    public void setSource(List<Integer> list) {
        this.soue = list;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
