package network;

/* loaded from: classes2.dex */
public class ReportCallInfo extends BaseBean {
    private String number;
    private String occurTime;
    private String talkTime;
    private String victimTel;

    public String getNumber() {
        return this.number;
    }

    public String getOccurTime() {
        return this.occurTime;
    }

    public String getTalkTime() {
        return this.talkTime;
    }

    public String getVictimTel() {
        return this.victimTel;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setOccurTime(String str) {
        this.occurTime = str;
    }

    public void setTalkTime(String str) {
        this.talkTime = str;
    }

    public void setVictimTel(String str) {
        this.victimTel = str;
    }
}
