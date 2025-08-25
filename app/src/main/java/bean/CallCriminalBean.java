package bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class CallCriminalBean implements Serializable {
    private String account;
    private String crime_time;
    private long duration;
    private boolean isInput = false;
    private boolean isSelect;
    private String plcae;
    private long suspectInfoID;
    private int type;

    public CallCriminalBean() {
    }

    public String getAccount() {
        return this.account;
    }

    public String getCrime_time() {
        return this.crime_time;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getPlcae() {
        return this.plcae;
    }

    public long getSuspectInfoID() {
        return this.suspectInfoID;
    }

    public int getType() {
        return this.type;
    }

    public boolean isInput() {
        return this.isInput;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setCrime_time(String str) {
        this.crime_time = str;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setInput(boolean z) {
        this.isInput = z;
    }

    public void setPlcae(String str) {
        this.plcae = str;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSuspectInfoID(long j2) {
        this.suspectInfoID = j2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public CallCriminalBean(String str, String str2, String str3, int i2, boolean z) {
        this.account = str;
        this.crime_time = str2;
        this.plcae = str3;
        this.type = i2;
        this.isSelect = z;
    }

    public CallCriminalBean(String str, String str2, String str3, int i2, boolean z, long j2) {
        this.account = str;
        this.crime_time = str2;
        this.plcae = str3;
        this.type = i2;
        this.isSelect = z;
        this.duration = j2;
    }
}
