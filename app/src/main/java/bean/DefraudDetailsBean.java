package bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DefraudDetailsBean implements Parcelable {
    public static final Parcelable.Creator<DefraudDetailsBean> CREATOR = new Parcelable.Creator<DefraudDetailsBean>() { // from class: bean.DefraudDetailsBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefraudDetailsBean createFromParcel(Parcel parcel) {
            return new DefraudDetailsBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefraudDetailsBean[] newArray(int i2) {
            return new DefraudDetailsBean[i2];
        }
    };
    private String audioDuration;
    private String defraudAudioUrl;
    private int defraudId;
    private String defraudProfileUrl;
    private String defraudSubject;
    private String defraudTime;
    private String defraudType;
    private int playState;
    private int profileType;

    public DefraudDetailsBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAudioDuration() {
        return this.audioDuration;
    }

    public String getDefraudAudioUrl() {
        return this.defraudAudioUrl;
    }

    public int getDefraudId() {
        return this.defraudId;
    }

    public String getDefraudProfileUrl() {
        return this.defraudProfileUrl;
    }

    public String getDefraudSubject() {
        return this.defraudSubject;
    }

    public String getDefraudTime() {
        return this.defraudTime;
    }

    public String getDefraudType() {
        return this.defraudType;
    }

    public int getPlayState() {
        return this.playState;
    }

    public int getProfileType() {
        return this.profileType;
    }

    public void setAudioDuration(String str) {
        this.audioDuration = str;
    }

    public void setDefraudAudioUrl(String str) {
        this.defraudAudioUrl = str;
    }

    public void setDefraudId(int i2) {
        this.defraudId = i2;
    }

    public void setDefraudProfileUrl(String str) {
        this.defraudProfileUrl = str;
    }

    public void setDefraudSubject(String str) {
        this.defraudSubject = str;
    }

    public void setDefraudTime(String str) {
        this.defraudTime = str;
    }

    public void setDefraudType(String str) {
        this.defraudType = str;
    }

    public DefraudDetailsBean setPlayState(int i2) {
        this.playState = i2;
        return this;
    }

    public void setProfileType(int i2) {
        this.profileType = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.defraudSubject);
        parcel.writeString(this.defraudType);
        parcel.writeString(this.defraudAudioUrl);
        parcel.writeString(this.defraudTime);
        parcel.writeString(this.defraudProfileUrl);
        parcel.writeString(this.audioDuration);
        parcel.writeInt(this.profileType);
        parcel.writeInt(this.defraudId);
        parcel.writeInt(this.playState);
    }

    protected DefraudDetailsBean(Parcel parcel) {
        this.defraudSubject = parcel.readString();
        this.defraudType = parcel.readString();
        this.defraudAudioUrl = parcel.readString();
        this.defraudTime = parcel.readString();
        this.defraudProfileUrl = parcel.readString();
        this.audioDuration = parcel.readString();
        this.profileType = parcel.readInt();
        this.defraudId = parcel.readInt();
        this.playState = parcel.readInt();
    }
}
