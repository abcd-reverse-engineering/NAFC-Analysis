package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hihonor.honorid.d.a.d;
import com.hihonor.honorid.f.b;
import com.hihonor.honorid.f.c;
import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class UserInfo implements Parcelable, Serializable {
    public static final String ADDRESS = "address";
    public static final String AGE = "age";
    public static final String BIRTHDATE = "birthDate";
    public static final String CITY = "city";
    public static final String CLOUDACCOUNT = "cloudAccount";
    public static final Parcelable.Creator<UserInfo> CREATOR = new a();
    public static final String CTFCODE = "ctfCode";
    public static final String CTFTYPE = "ctfType";
    public static final String CTFVERIFYFLAG = "ctfVerifyFlag";
    public static final String FIRSTNAME = "firstName";
    public static final String GENDER = "gender";
    public static final String GUARDIAN_ACCOUNT = "guardianAccount";
    public static final String GUARDIAN_USER_ID = "guardianUserID";
    public static final String HEADPICTUREURL = "headPictureURL";
    public static final String INVITER = "Inviter";
    public static final String INVITER_USERID = "InviterUserID";
    public static final String LANGUAGECODE = "languageCode";
    public static final String LASTNAME = "lastName";
    public static final String LOGIN_NOTICE = "loginnotice";
    public static final String LOGIN_USER_NAME = "loginUserName";
    public static final String LOGIN_USER_NAME_FLAG = "loginUserNameFlag";
    public static final String NATIONALCODE = "nationalCode";
    public static final String NICKNAME = "nickName";
    public static final String OCCUPATION = "occupation";
    public static final String PASSWORDANWSER = "passwordAnswer";
    public static final String PASSWORDPROMPT = "passwordPrompt";
    public static final String PROVINCE = "province";
    public static final String RESET_PASSWD_MODE = "resetPasswdMode";
    public static final String SERVICEFLAG = "ServiceFlag";
    public static final String TWO_STEP_TIME = "twoStepTime";
    public static final String TWO_STEP_VERIFY = "twoStepVerify";
    public static final String UNIQUE_NICKNAME = "uniquelyNickname";
    public static final String UPDATE_TIME = "updateTime";
    public static final String USERSIGN = "userSignature";
    public static final String USERSTATE = "userState";
    public static final String USERVALID_STATUS = "userValidStatus";
    public static final String USER_STATUS_FLAGS = "userStatusFlags";
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;

    /* renamed from: a, reason: collision with root package name */
    private String f6177a;

    /* renamed from: b, reason: collision with root package name */
    private String f6178b;

    /* renamed from: c, reason: collision with root package name */
    private String f6179c;

    /* renamed from: d, reason: collision with root package name */
    private String f6180d;

    /* renamed from: e, reason: collision with root package name */
    private String f6181e;

    /* renamed from: f, reason: collision with root package name */
    private String f6182f;

    /* renamed from: g, reason: collision with root package name */
    private String f6183g;

    /* renamed from: h, reason: collision with root package name */
    private String f6184h;

    /* renamed from: i, reason: collision with root package name */
    private String f6185i;

    /* renamed from: j, reason: collision with root package name */
    private String f6186j;

    /* renamed from: k, reason: collision with root package name */
    private String f6187k;

    /* renamed from: l, reason: collision with root package name */
    private String f6188l;

    /* renamed from: m, reason: collision with root package name */
    private String f6189m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    class a implements Parcelable.Creator<UserInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo createFromParcel(Parcel parcel) {
            UserInfo userInfo = new UserInfo();
            userInfo.f6185i = parcel.readString();
            userInfo.f6184h = parcel.readString();
            userInfo.n = parcel.readString();
            userInfo.q = parcel.readString();
            userInfo.f6180d = parcel.readString();
            userInfo.f6183g = parcel.readString();
            userInfo.f6187k = parcel.readString();
            userInfo.f6179c = parcel.readString();
            userInfo.f6181e = parcel.readString();
            userInfo.f6188l = parcel.readString();
            userInfo.f6177a = parcel.readString();
            userInfo.f6178b = parcel.readString();
            userInfo.f6186j = parcel.readString();
            userInfo.p = parcel.readString();
            userInfo.o = parcel.readString();
            userInfo.f6189m = parcel.readString();
            userInfo.r = parcel.readString();
            userInfo.f6182f = parcel.readString();
            userInfo.s = parcel.readString();
            userInfo.t = parcel.readString();
            userInfo.u = parcel.readString();
            userInfo.v = parcel.readString();
            userInfo.w = parcel.readString();
            userInfo.x = parcel.readString();
            userInfo.y = parcel.readString();
            userInfo.z = parcel.readString();
            userInfo.A = parcel.readString();
            userInfo.B = parcel.readString();
            userInfo.D = parcel.readString();
            userInfo.C = parcel.readString();
            userInfo.E = parcel.readString();
            userInfo.F = parcel.readString();
            userInfo.I = parcel.readString();
            userInfo.G = parcel.readString();
            userInfo.H = parcel.readString();
            userInfo.J = parcel.readString();
            userInfo.K = parcel.readString();
            return userInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo[] newArray(int i2) {
            return new UserInfo[i2];
        }
    }

    public static void getUserInfoIntag(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if (xmlPullParser == null || userInfo == null || str == null) {
            return;
        }
        a(xmlPullParser, userInfo, str);
        b(xmlPullParser, userInfo, str);
        c(xmlPullParser, userInfo, str);
    }

    public static void setUserInfoIntag(XmlSerializer xmlSerializer, UserInfo userInfo) throws IllegalStateException, IOException, IllegalArgumentException {
        if (xmlSerializer == null || userInfo == null) {
            return;
        }
        c.a(xmlSerializer, "uniquelyNickname", userInfo.getUniqueNickName());
        c.a(xmlSerializer, "nickName", userInfo.getNickName());
        c.a(xmlSerializer, LANGUAGECODE, userInfo.getLanguageCode());
        c.a(xmlSerializer, FIRSTNAME, userInfo.getFirstName());
        c.a(xmlSerializer, LASTNAME, userInfo.getLastName());
        c.a(xmlSerializer, USERSTATE, userInfo.getUserState());
        c.a(xmlSerializer, GENDER, userInfo.getGender());
        c.a(xmlSerializer, "birthDate", userInfo.getBirthDate());
        c.a(xmlSerializer, ADDRESS, userInfo.getAddress());
        c.a(xmlSerializer, OCCUPATION, userInfo.getOccupation());
        c.a(xmlSerializer, HEADPICTUREURL, userInfo.getHeadPictureUrl());
        c.a(xmlSerializer, NATIONALCODE, userInfo.getNationalCode());
        c.a(xmlSerializer, PROVINCE, userInfo.getProvince());
        c.a(xmlSerializer, CITY, userInfo.getCity());
        c.a(xmlSerializer, PASSWORDPROMPT, userInfo.getPasswordPrompt());
        c.a(xmlSerializer, PASSWORDANWSER, userInfo.getPasswordAnwser());
        c.a(xmlSerializer, CLOUDACCOUNT, userInfo.getCloudAccount());
        c.a(xmlSerializer, SERVICEFLAG, userInfo.getServiceFlag());
        c.a(xmlSerializer, USERVALID_STATUS, userInfo.getUserValidStatus());
        c.a(xmlSerializer, INVITER, userInfo.getInviter());
        c.a(xmlSerializer, INVITER_USERID, userInfo.getInviterUserId());
        c.a(xmlSerializer, "updateTime", userInfo.getUpdateTime());
        c.a(xmlSerializer, "loginUserName", userInfo.getLoginUserName());
        c.a(xmlSerializer, LOGIN_USER_NAME_FLAG, userInfo.getLoginUserNameFlag());
        c.a(xmlSerializer, USERSIGN, userInfo.getUserSign());
        c.a(xmlSerializer, CTFCODE, userInfo.getCtfCode());
        c.a(xmlSerializer, CTFTYPE, userInfo.getCtfType());
        c.a(xmlSerializer, CTFVERIFYFLAG, userInfo.getCtfVerifyFlag());
        c.a(xmlSerializer, "srvNationalCode", userInfo.getServiceCountryCode());
        c.a(xmlSerializer, "age", userInfo.getAge());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f6185i;
    }

    public String getAge() {
        return this.K;
    }

    public String getBirthDate() {
        return this.f6184h;
    }

    public String getCity() {
        return this.n;
    }

    public String getCloudAccount() {
        return this.q;
    }

    public String getCtfCode() {
        return this.I;
    }

    public String getCtfType() {
        return this.G;
    }

    public String getCtfVerifyFlag() {
        return this.H;
    }

    public String getFirstName() {
        return this.f6180d;
    }

    public String getGender() {
        return this.f6183g;
    }

    public String getGuardianAccount() {
        return this.F;
    }

    public String getGuardianUserId() {
        return this.E;
    }

    public String getHeadPictureUrl() {
        return this.f6187k;
    }

    public String getInviter() {
        return this.u;
    }

    public String getInviterUserId() {
        return this.t;
    }

    public String getLanguageCode() {
        return this.f6179c;
    }

    public String getLastName() {
        return this.f6181e;
    }

    public String getLoginNotice() {
        return this.D;
    }

    public String getLoginUserName() {
        return this.w;
    }

    public String getLoginUserNameFlag() {
        return this.x;
    }

    public String getNationalCode() {
        return this.f6188l;
    }

    public String getNickName() {
        return this.f6177a;
    }

    public String getOccupation() {
        return this.f6186j;
    }

    public String getPasswordAnwser() {
        return this.p;
    }

    public String getPasswordPrompt() {
        return this.o;
    }

    public String getProvince() {
        return this.f6189m;
    }

    public String getResetPasswdMode() {
        return this.B;
    }

    public String getServiceCountryCode() {
        return this.J;
    }

    public String getServiceFlag() {
        return this.r;
    }

    public String getUniqueNickName() {
        return this.f6178b;
    }

    public String getUpdateTime() {
        return this.v;
    }

    public String getUserSign() {
        return this.C;
    }

    public String getUserState() {
        return this.f6182f;
    }

    public int getUserType() {
        return (TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.F)) ? 0 : 1;
    }

    public String getUserValidStatus() {
        return this.s;
    }

    public String gettwoStepTime() {
        return this.A;
    }

    public String gettwoStepVerify() {
        return this.z;
    }

    public String getuserStatusFlags() {
        return this.y;
    }

    public boolean isObjectEquals(Object obj) {
        if (obj == null || !(obj instanceof UserInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        UserInfo userInfo = (UserInfo) obj;
        return b.a(getNickName(), userInfo.getNickName()) && b.a(getLoginUserName(), userInfo.getLoginUserName()) && b.a(getLoginUserNameFlag(), userInfo.getLoginUserNameFlag()) && b.a(getGender(), userInfo.getGender()) && b.a(getBirthDate(), userInfo.getBirthDate()) && b.a(getNationalCode(), userInfo.getNationalCode());
    }

    public void setAddress(String str) {
        this.f6185i = str;
    }

    public void setAge(String str) {
        this.K = str;
    }

    public void setBirthDate(String str) {
        this.f6184h = str;
    }

    public void setCity(String str) {
        this.n = str;
    }

    public void setCloudAccount(String str) {
        this.q = str;
    }

    public void setCtfCode(String str) {
        this.I = str;
    }

    public void setCtfType(String str) {
        this.G = str;
    }

    public void setCtfVerifyFlag(String str) {
        this.H = str;
    }

    public void setFirstName(String str) {
        this.f6180d = str;
    }

    public void setGender(String str) {
        this.f6183g = str;
    }

    public void setGuardianAccount(String str) {
        this.F = str;
    }

    public void setGuardianUserId(String str) {
        this.E = str;
    }

    public void setHeadPictureUrl(String str) {
        this.f6187k = str;
    }

    public void setInviter(String str) {
        this.u = str;
    }

    public void setInviterUserId(String str) {
        this.t = str;
    }

    public void setLanguageCode(String str) {
        this.f6179c = str;
    }

    public void setLastName(String str) {
        this.f6181e = str;
    }

    public void setLoginNotice(String str) {
        this.D = str;
    }

    public void setLoginUserName(String str) {
        this.w = str;
    }

    public void setLoginUserNameFlag(String str) {
        this.x = str;
    }

    public void setNationalCode(String str) {
        this.f6188l = str;
    }

    public void setNickName(String str) {
        this.f6177a = str;
    }

    public void setOccupation(String str) {
        this.f6186j = str;
    }

    public void setPasswordAnwser(String str) {
        this.p = str;
    }

    public void setPasswordPrompt(String str) {
        this.o = str;
    }

    public void setProvince(String str) {
        this.f6189m = str;
    }

    public void setResetPasswdMode(String str) {
        this.B = str;
    }

    public void setServiceCountryCode(String str) {
        this.J = str;
    }

    public void setServiceFlag(String str) {
        this.r = str;
    }

    public void setUniqueNickName(String str) {
        this.f6178b = str;
    }

    public void setUpdateTime(String str) {
        this.v = str;
    }

    public void setUserSign(String str) {
        this.C = str;
    }

    public void setUserState(String str) {
        this.f6182f = str;
    }

    public void setUserValidStatus(String str) {
        this.s = str;
    }

    public void settwoStepTime(String str) {
        this.A = str;
    }

    public void settwoStepVerify(String str) {
        this.z = str;
    }

    public void setuserStatusFlags(String str) {
        this.y = str;
    }

    public String toString() {
        return "UserInfo [mNickName=" + d.a(this.f6177a) + ", mUniqueNickName=" + d.a(this.f6178b) + ", mLanguageCode=" + this.f6179c + ", mFirstName=" + d.a(this.f6180d) + ", mLastName=" + d.a(this.f6181e) + ", mUserState=" + this.f6182f + ", mGender=" + this.f6183g + ", mBirthDate=" + this.f6184h + ", mAddress=" + d.a(this.f6185i) + ", mOccupation=" + this.f6186j + ", mHeadPictureUrl=" + this.f6187k + ", mNationalCode=" + this.f6188l + ", mProvince=" + this.f6189m + ", mCity=" + this.n + ", mPasswordPrompt=" + d.a(this.o) + ", mscrtdanws=" + this.p + ", mCloudAccount=" + this.q + ", mServiceFlag=" + this.r + ", mUserValidStatus=" + this.s + ", mInviterUserId=" + d.a(this.t) + ", mInviter=" + d.a(this.u) + ", mUpdateTime=" + this.v + ", mLoginUserName=" + d.a(this.w) + ", mLoginUserNameFlag=" + this.x + ", muserStatusFlags=" + this.y + ", mtwoStepVerify=" + this.z + ", mtwoStepTime=" + this.A + ", mResetPasswdMode=" + this.B + ", mUserSign=" + this.C + ", mLoginNotice=" + this.D + ", mGuardianUserId=" + d.a(this.E) + ", mGuardianAccount=" + d.a(this.F) + ", mCtfType=" + this.G + ", mCtfVerifyFlag=" + this.H + ", mCtfCode=" + this.I + ", mServiceCountryCode=" + this.J + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6185i);
        parcel.writeString(this.f6184h);
        parcel.writeString(this.n);
        parcel.writeString(this.q);
        parcel.writeString(this.f6180d);
        parcel.writeString(this.f6183g);
        parcel.writeString(this.f6187k);
        parcel.writeString(this.f6179c);
        parcel.writeString(this.f6181e);
        parcel.writeString(this.f6188l);
        parcel.writeString(this.f6177a);
        parcel.writeString(this.f6178b);
        parcel.writeString(this.f6186j);
        parcel.writeString(this.p);
        parcel.writeString(this.o);
        parcel.writeString(this.f6189m);
        parcel.writeString(this.r);
        parcel.writeString(this.f6182f);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.D);
        parcel.writeString(this.C);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.I);
        parcel.writeString(this.H);
        parcel.writeString(this.G);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
    }

    private static void a(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if ("nickName".equals(str)) {
            userInfo.setNickName(xmlPullParser.nextText());
            return;
        }
        if ("uniquelyNickname".equals(str)) {
            userInfo.setUniqueNickName(xmlPullParser.nextText());
            return;
        }
        if (LANGUAGECODE.equals(str)) {
            userInfo.setLanguageCode(xmlPullParser.nextText());
            return;
        }
        if (FIRSTNAME.equals(str)) {
            userInfo.setFirstName(xmlPullParser.nextText());
            return;
        }
        if (LASTNAME.equals(str)) {
            userInfo.setLastName(xmlPullParser.nextText());
            return;
        }
        if (USERSTATE.equals(str)) {
            userInfo.setUserState(xmlPullParser.nextText());
            return;
        }
        if (GUARDIAN_ACCOUNT.equals(str)) {
            userInfo.setGuardianAccount(xmlPullParser.nextText());
            return;
        }
        if (GUARDIAN_USER_ID.equals(str)) {
            userInfo.setGuardianUserId(xmlPullParser.nextText());
            return;
        }
        if (CTFCODE.equals(str)) {
            userInfo.setCtfCode(xmlPullParser.nextText());
            return;
        }
        if (CTFTYPE.equals(str)) {
            userInfo.setCtfType(xmlPullParser.nextText());
            return;
        }
        if (CTFVERIFYFLAG.equals(str)) {
            userInfo.setCtfVerifyFlag(xmlPullParser.nextText());
            return;
        }
        if (USERVALID_STATUS.equals(str)) {
            userInfo.setUserValidStatus(xmlPullParser.nextText());
        } else if (INVITER_USERID.equals(str)) {
            userInfo.setInviterUserId(xmlPullParser.nextText());
        } else if ("age".equals(str)) {
            userInfo.setAge(xmlPullParser.nextText());
        }
    }

    private static void b(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if (GENDER.equals(str)) {
            userInfo.setGender(xmlPullParser.nextText());
            return;
        }
        if ("birthDate".equals(str)) {
            userInfo.setBirthDate(xmlPullParser.nextText());
            return;
        }
        if (ADDRESS.equals(str)) {
            userInfo.setAddress(xmlPullParser.nextText());
            return;
        }
        if (OCCUPATION.equals(str)) {
            userInfo.setOccupation(xmlPullParser.nextText());
            return;
        }
        if (HEADPICTUREURL.equals(str)) {
            userInfo.setHeadPictureUrl(xmlPullParser.nextText());
            return;
        }
        if (NATIONALCODE.equals(str)) {
            userInfo.setNationalCode(xmlPullParser.nextText());
            return;
        }
        if (PROVINCE.equals(str)) {
            userInfo.setProvince(xmlPullParser.nextText());
            return;
        }
        if (CITY.equals(str)) {
            userInfo.setCity(xmlPullParser.nextText());
            return;
        }
        if (PASSWORDPROMPT.equals(str)) {
            userInfo.setPasswordPrompt(xmlPullParser.nextText());
            return;
        }
        if (PASSWORDANWSER.equals(str)) {
            userInfo.setPasswordAnwser(xmlPullParser.nextText());
        } else if (CLOUDACCOUNT.equals(str)) {
            userInfo.setCloudAccount(xmlPullParser.nextText());
        } else if (SERVICEFLAG.equals(str)) {
            userInfo.setServiceFlag(xmlPullParser.nextText());
        }
    }

    private static void c(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if (INVITER.equals(str)) {
            userInfo.setInviter(xmlPullParser.nextText());
            return;
        }
        if ("updateTime".equals(str)) {
            userInfo.setUpdateTime(xmlPullParser.nextText());
            return;
        }
        if ("loginUserName".equals(str)) {
            userInfo.setLoginUserName(xmlPullParser.nextText());
            return;
        }
        if (LOGIN_USER_NAME_FLAG.equals(str)) {
            userInfo.setLoginUserNameFlag(xmlPullParser.nextText());
            return;
        }
        if (USER_STATUS_FLAGS.equals(str)) {
            userInfo.setuserStatusFlags(xmlPullParser.nextText());
            return;
        }
        if (TWO_STEP_VERIFY.equals(str)) {
            userInfo.settwoStepVerify(xmlPullParser.nextText());
            return;
        }
        if (TWO_STEP_TIME.equals(str)) {
            userInfo.settwoStepTime(xmlPullParser.nextText());
            return;
        }
        if (RESET_PASSWD_MODE.equals(str)) {
            userInfo.setResetPasswdMode(xmlPullParser.nextText());
            return;
        }
        if (USERSIGN.equals(str)) {
            userInfo.setUserSign(xmlPullParser.nextText());
        } else if (LOGIN_NOTICE.equals(str)) {
            userInfo.setLoginNotice(xmlPullParser.nextText());
        } else if ("srvNationalCode".equals(str)) {
            userInfo.setServiceCountryCode(xmlPullParser.nextText());
        }
    }
}
