package bean;

import com.google.gson.a0.c;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class CaseDetailBean extends BaseBean {
    private int appCount;
    private int callTelCount;
    private String caseCategoryText;
    private String caseName;
    private String caseNumber;
    private int chargeTelCount;
    private String confirmFileID;
    private String confirmFileUrl;
    private String confirmTime;
    private String createTime;
    private String documentNumber;
    private String documentTypeText;
    private String id;
    private int linkTelCount;
    private int mailingTelCount;
    private String name;
    private int netAccountCount;
    private int paymentCount;
    private String policeMobile;
    private String processTime;
    private List<ReplyBean> replys;
    private int smsCount;
    private int status;
    private int stopPaymentCount;
    private String submitUserID;
    private int suspectCount;
    private int transferErrorCount;
    private String updateTime;
    private int urlCount;
    private int victimCount;

    public static class AppsBean {
        private String appCompany;
        private int appLogoFileID;
        private String appLogoFileUrl;
        private String appLogoPath;
        private String appName;
        private String appVersion;
        private int caseInfoID;
        private String downloadUrl;

        @c("id")
        private int idX;
        private int packageFileID;
        private String packageFileUrl;
        private String packageName;
        private String pkgPath;
        private int qrCodeFileID;
        private String qrCodeFileUrl;
        private String qrCodePath;

        public String getAppCompany() {
            return this.appCompany;
        }

        public int getAppLogoFileID() {
            return this.appLogoFileID;
        }

        public String getAppLogoFileUrl() {
            return this.appLogoFileUrl;
        }

        public String getAppLogoPath() {
            return this.appLogoPath;
        }

        public String getAppName() {
            return this.appName;
        }

        public String getAppVersion() {
            return this.appVersion;
        }

        public int getCaseInfoID() {
            return this.caseInfoID;
        }

        public String getDownloadUrl() {
            return this.downloadUrl;
        }

        public int getIdX() {
            return this.idX;
        }

        public int getPackageFileID() {
            return this.packageFileID;
        }

        public String getPackageFileUrl() {
            return this.packageFileUrl;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getPkgPath() {
            return this.pkgPath;
        }

        public int getQrCodeFileID() {
            return this.qrCodeFileID;
        }

        public String getQrCodeFileUrl() {
            return this.qrCodeFileUrl;
        }

        public String getQrCodePath() {
            return this.qrCodePath;
        }

        public void setAppCompany(String str) {
            this.appCompany = str;
        }

        public void setAppLogoFileID(int i2) {
            this.appLogoFileID = i2;
        }

        public void setAppLogoFileUrl(String str) {
            this.appLogoFileUrl = str;
        }

        public void setAppLogoPath(String str) {
            this.appLogoPath = str;
        }

        public void setAppName(String str) {
            this.appName = str;
        }

        public void setAppVersion(String str) {
            this.appVersion = str;
        }

        public void setCaseInfoID(int i2) {
            this.caseInfoID = i2;
        }

        public void setDownloadUrl(String str) {
            this.downloadUrl = str;
        }

        public void setIdX(int i2) {
            this.idX = i2;
        }

        public void setPackageFileID(int i2) {
            this.packageFileID = i2;
        }

        public void setPackageFileUrl(String str) {
            this.packageFileUrl = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setPkgPath(String str) {
            this.pkgPath = str;
        }

        public void setQrCodeFileID(int i2) {
            this.qrCodeFileID = i2;
        }

        public void setQrCodeFileUrl(String str) {
            this.qrCodeFileUrl = str;
        }

        public void setQrCodePath(String str) {
            this.qrCodePath = str;
        }
    }

    public static class PaymentsBean {
        private String caseInfoID;

        @c("createTime")
        private String createTimeX;
        private String description;

        @c("id")
        private String idX;
        private List<PaymentDetailsBean> paymentDetails;
        private String paymentTime;
        private String paymentType;
        private String paymentTypeText;
        private String suspectAccount;
        private String suspectAccountType;
        private String suspectAccountTypeText;
        private String suspectAccountTypeText1;

        @c("updateTime")
        private String updateTimeX;
        private String victimAccount;
        private String victimAccountType;
        private String victimAccountTypeText;
        private String victimAccountTypeText1;

        public static class PaymentDetailsBean {

            @c("createTime")
            private String createTimeX;
            private String fileID;
            private String fileName;
            private String fileUrl;

            @c("id")
            private String idX;
            private String localPath;
            private String paymentInfoID;

            @c("updateTime")
            private String updateTimeX;

            public String getCreateTimeX() {
                return this.createTimeX;
            }

            public String getFileID() {
                return this.fileID;
            }

            public String getFileName() {
                return this.fileName;
            }

            public String getFileUrl() {
                return this.fileUrl;
            }

            public String getIdX() {
                return this.idX;
            }

            public String getLocalPath() {
                return this.localPath;
            }

            public String getPaymentInfoID() {
                return this.paymentInfoID;
            }

            public String getUpdateTimeX() {
                return this.updateTimeX;
            }

            public void setCreateTimeX(String str) {
                this.createTimeX = str;
            }

            public void setFileID(String str) {
                this.fileID = str;
            }

            public void setFileName(String str) {
                this.fileName = str;
            }

            public void setFileUrl(String str) {
                this.fileUrl = str;
            }

            public void setIdX(String str) {
                this.idX = str;
            }

            public void setLocalPath(String str) {
                this.localPath = str;
            }

            public void setPaymentInfoID(String str) {
                this.paymentInfoID = str;
            }

            public void setUpdateTimeX(String str) {
                this.updateTimeX = str;
            }
        }

        public String getCaseInfoID() {
            return this.caseInfoID;
        }

        public String getCreateTimeX() {
            return this.createTimeX;
        }

        public String getDescription() {
            return this.description;
        }

        public String getIdX() {
            return this.idX;
        }

        public List<PaymentDetailsBean> getPaymentDetails() {
            return this.paymentDetails;
        }

        public String getPaymentTime() {
            return this.paymentTime;
        }

        public String getPaymentType() {
            return this.paymentType;
        }

        public String getPaymentTypeText() {
            return this.paymentTypeText;
        }

        public String getSuspectAccount() {
            return this.suspectAccount;
        }

        public String getSuspectAccountType() {
            return this.suspectAccountType;
        }

        public String getSuspectAccountTypeText() {
            return this.suspectAccountTypeText;
        }

        public String getSuspectAccountTypeText1() {
            return this.suspectAccountTypeText1;
        }

        public String getUpdateTimeX() {
            return this.updateTimeX;
        }

        public String getVictimAccount() {
            return this.victimAccount;
        }

        public String getVictimAccountType() {
            return this.victimAccountType;
        }

        public String getVictimAccountTypeText() {
            return this.victimAccountTypeText;
        }

        public String getVictimAccountTypeText1() {
            return this.victimAccountTypeText1;
        }

        public void setCaseInfoID(String str) {
            this.caseInfoID = str;
        }

        public void setCreateTimeX(String str) {
            this.createTimeX = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setIdX(String str) {
            this.idX = str;
        }

        public void setPaymentDetails(List<PaymentDetailsBean> list) {
            this.paymentDetails = list;
        }

        public void setPaymentTime(String str) {
            this.paymentTime = str;
        }

        public void setPaymentType(String str) {
            this.paymentType = str;
        }

        public void setPaymentTypeText(String str) {
            this.paymentTypeText = str;
        }

        public void setSuspectAccount(String str) {
            this.suspectAccount = str;
        }

        public void setSuspectAccountType(String str) {
            this.suspectAccountType = str;
        }

        public void setSuspectAccountTypeText(String str) {
            this.suspectAccountTypeText = str;
        }

        public void setSuspectAccountTypeText1(String str) {
            this.suspectAccountTypeText1 = str;
        }

        public void setUpdateTimeX(String str) {
            this.updateTimeX = str;
        }

        public void setVictimAccount(String str) {
            this.victimAccount = str;
        }

        public void setVictimAccountType(String str) {
            this.victimAccountType = str;
        }

        public void setVictimAccountTypeText(String str) {
            this.victimAccountTypeText = str;
        }

        public void setVictimAccountTypeText1(String str) {
            this.victimAccountTypeText1 = str;
        }
    }

    public static class SuspectsBean {
        private int caseInfoID;

        @c("createTime")
        private String createTimeX;

        @c("id")
        private int idX;
        private List<MobilesBean> mobiles;
        private List<PrintscreensBean> printscreens;
        private List<SocialAccountsBean> socialAccounts;

        @c("updateTime")
        private String updateTimeX;

        public static class MobilesBean {
            private String account;
            private int accountType;
            private String accountTypeName;

            @c("createTime")
            private String createTimeX;

            @c("id")
            private int idX;
            private int suspectInfoID;

            @c("updateTime")
            private String updateTimeX;

            public String getAccount() {
                return this.account;
            }

            public int getAccountType() {
                return this.accountType;
            }

            public String getAccountTypeName() {
                return this.accountTypeName;
            }

            public String getCreateTimeX() {
                return this.createTimeX;
            }

            public int getIdX() {
                return this.idX;
            }

            public int getSuspectInfoID() {
                return this.suspectInfoID;
            }

            public String getUpdateTimeX() {
                return this.updateTimeX;
            }

            public void setAccount(String str) {
                this.account = str;
            }

            public void setAccountType(int i2) {
                this.accountType = i2;
            }

            public void setAccountTypeName(String str) {
                this.accountTypeName = str;
            }

            public void setCreateTimeX(String str) {
                this.createTimeX = str;
            }

            public void setIdX(int i2) {
                this.idX = i2;
            }

            public void setSuspectInfoID(int i2) {
                this.suspectInfoID = i2;
            }

            public void setUpdateTimeX(String str) {
                this.updateTimeX = str;
            }
        }

        public static class PrintscreensBean {

            @c("createTime")
            private String createTimeX;
            private int fileID;
            private String fileName;
            private String fileUrl;

            @c("id")
            private int idX;
            private String localPath;
            private int suspectInfoID;

            @c("updateTime")
            private String updateTimeX;

            public String getCreateTimeX() {
                return this.createTimeX;
            }

            public int getFileID() {
                return this.fileID;
            }

            public String getFileName() {
                return this.fileName;
            }

            public String getFileUrl() {
                return this.fileUrl;
            }

            public int getIdX() {
                return this.idX;
            }

            public String getLocalPath() {
                return this.localPath;
            }

            public int getSuspectInfoID() {
                return this.suspectInfoID;
            }

            public String getUpdateTimeX() {
                return this.updateTimeX;
            }

            public void setCreateTimeX(String str) {
                this.createTimeX = str;
            }

            public void setFileID(int i2) {
                this.fileID = i2;
            }

            public void setFileName(String str) {
                this.fileName = str;
            }

            public void setFileUrl(String str) {
                this.fileUrl = str;
            }

            public void setIdX(int i2) {
                this.idX = i2;
            }

            public void setLocalPath(String str) {
                this.localPath = str;
            }

            public void setSuspectInfoID(int i2) {
                this.suspectInfoID = i2;
            }

            public void setUpdateTimeX(String str) {
                this.updateTimeX = str;
            }
        }

        public static class SocialAccountsBean {
            private String account;
            private int accountType;
            private String accountTypeName;

            @c("createTime")
            private String createTimeX;

            @c("id")
            private int idX;
            private int suspectInfoID;

            @c("updateTime")
            private String updateTimeX;

            public String getAccount() {
                return this.account;
            }

            public int getAccountType() {
                return this.accountType;
            }

            public String getAccountTypeName() {
                return this.accountTypeName;
            }

            public String getCreateTimeX() {
                return this.createTimeX;
            }

            public int getIdX() {
                return this.idX;
            }

            public int getSuspectInfoID() {
                return this.suspectInfoID;
            }

            public String getUpdateTimeX() {
                return this.updateTimeX;
            }

            public void setAccount(String str) {
                this.account = str;
            }

            public void setAccountType(int i2) {
                this.accountType = i2;
            }

            public void setAccountTypeName(String str) {
                this.accountTypeName = str;
            }

            public void setCreateTimeX(String str) {
                this.createTimeX = str;
            }

            public void setIdX(int i2) {
                this.idX = i2;
            }

            public void setSuspectInfoID(int i2) {
                this.suspectInfoID = i2;
            }

            public void setUpdateTimeX(String str) {
                this.updateTimeX = str;
            }
        }

        public int getCaseInfoID() {
            return this.caseInfoID;
        }

        public String getCreateTimeX() {
            return this.createTimeX;
        }

        public int getIdX() {
            return this.idX;
        }

        public List<MobilesBean> getMobiles() {
            return this.mobiles;
        }

        public List<PrintscreensBean> getPrintscreens() {
            return this.printscreens;
        }

        public List<SocialAccountsBean> getSocialAccounts() {
            return this.socialAccounts;
        }

        public String getUpdateTimeX() {
            return this.updateTimeX;
        }

        public void setCaseInfoID(int i2) {
            this.caseInfoID = i2;
        }

        public void setCreateTimeX(String str) {
            this.createTimeX = str;
        }

        public void setIdX(int i2) {
            this.idX = i2;
        }

        public void setMobiles(List<MobilesBean> list) {
            this.mobiles = list;
        }

        public void setPrintscreens(List<PrintscreensBean> list) {
            this.printscreens = list;
        }

        public void setSocialAccounts(List<SocialAccountsBean> list) {
            this.socialAccounts = list;
        }

        public void setUpdateTimeX(String str) {
            this.updateTimeX = str;
        }
    }

    public static class UrlsBean {
        private int caseInfoID;

        @c("createTime")
        private String createTimeX;

        @c("id")
        private int idX;

        @c("updateTime")
        private String updateTimeX;
        private String url;
        private String urlCompany;
        private List<UrlDetailsBean> urlDetails;

        public static class UrlDetailsBean {

            @c("createTime")
            private String createTimeX;
            private int fileID;
            private String fileName;
            private String fileUrl;

            @c("id")
            private int idX;
            private String localPath;

            @c("updateTime")
            private String updateTimeX;
            private int urlInfoID;

            public String getCreateTimeX() {
                return this.createTimeX;
            }

            public int getFileID() {
                return this.fileID;
            }

            public String getFileName() {
                return this.fileName;
            }

            public String getFileUrl() {
                return this.fileUrl;
            }

            public int getIdX() {
                return this.idX;
            }

            public String getLocalPath() {
                return this.localPath;
            }

            public String getUpdateTimeX() {
                return this.updateTimeX;
            }

            public int getUrlInfoID() {
                return this.urlInfoID;
            }

            public void setCreateTimeX(String str) {
                this.createTimeX = str;
            }

            public void setFileID(int i2) {
                this.fileID = i2;
            }

            public void setFileName(String str) {
                this.fileName = str;
            }

            public void setFileUrl(String str) {
                this.fileUrl = str;
            }

            public void setIdX(int i2) {
                this.idX = i2;
            }

            public void setLocalPath(String str) {
                this.localPath = str;
            }

            public void setUpdateTimeX(String str) {
                this.updateTimeX = str;
            }

            public void setUrlInfoID(int i2) {
                this.urlInfoID = i2;
            }
        }

        public int getCaseInfoID() {
            return this.caseInfoID;
        }

        public String getCreateTimeX() {
            return this.createTimeX;
        }

        public int getIdX() {
            return this.idX;
        }

        public String getUpdateTimeX() {
            return this.updateTimeX;
        }

        public String getUrl() {
            return this.url;
        }

        public String getUrlCompany() {
            return this.urlCompany;
        }

        public List<UrlDetailsBean> getUrlDetails() {
            return this.urlDetails;
        }

        public void setCaseInfoID(int i2) {
            this.caseInfoID = i2;
        }

        public void setCreateTimeX(String str) {
            this.createTimeX = str;
        }

        public void setIdX(int i2) {
            this.idX = i2;
        }

        public void setUpdateTimeX(String str) {
            this.updateTimeX = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setUrlCompany(String str) {
            this.urlCompany = str;
        }

        public void setUrlDetails(List<UrlDetailsBean> list) {
            this.urlDetails = list;
        }
    }

    public static class VictimsBean {
        private String address;
        private String addressDetail;
        private String addressName;
        private int age;
        private int caseInfoID;

        @c("createTime")
        private String createTimeX;
        private int cultural;
        private String culturalName;
        private String culturalText;
        private String documentName;

        @c("documentNumber")
        private String documentNumberX;
        private int documentType;

        @c("documentTypeText")
        private String documentTypeTextX;

        @c("id")
        private int idX;
        private String mobileNumber;

        @c(CommonNetImpl.NAME)
        private String nameX;
        private int nationality;
        private String nationalityName;
        private String nationalityText;
        private String occupation;
        private String presentAddress;
        private String presentAddressDetail;
        private String presentAddressName;
        private int sex;
        private String unit;

        @c("updateTime")
        private String updateTimeX;

        public String getAddress() {
            return this.address;
        }

        public String getAddressDetail() {
            return this.addressDetail;
        }

        public String getAddressName() {
            return this.addressName;
        }

        public int getAge() {
            return this.age;
        }

        public int getCaseInfoID() {
            return this.caseInfoID;
        }

        public String getCreateTimeX() {
            return this.createTimeX;
        }

        public int getCultural() {
            return this.cultural;
        }

        public String getCulturalName() {
            return this.culturalName;
        }

        public String getCulturalText() {
            return this.culturalText;
        }

        public String getDocumentName() {
            return this.documentName;
        }

        public String getDocumentNumberX() {
            return this.documentNumberX;
        }

        public int getDocumentType() {
            return this.documentType;
        }

        public String getDocumentTypeTextX() {
            return this.documentTypeTextX;
        }

        public int getIdX() {
            return this.idX;
        }

        public String getMobileNumber() {
            return this.mobileNumber;
        }

        public String getNameX() {
            return this.nameX;
        }

        public int getNationality() {
            return this.nationality;
        }

        public String getNationalityName() {
            return this.nationalityName;
        }

        public String getNationalityText() {
            return this.nationalityText;
        }

        public String getOccupation() {
            return this.occupation;
        }

        public String getPresentAddress() {
            return this.presentAddress;
        }

        public String getPresentAddressDetail() {
            return this.presentAddressDetail;
        }

        public String getPresentAddressName() {
            return this.presentAddressName;
        }

        public int getSex() {
            return this.sex;
        }

        public String getUnit() {
            return this.unit;
        }

        public String getUpdateTimeX() {
            return this.updateTimeX;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setAddressDetail(String str) {
            this.addressDetail = str;
        }

        public void setAddressName(String str) {
            this.addressName = str;
        }

        public void setAge(int i2) {
            this.age = i2;
        }

        public void setCaseInfoID(int i2) {
            this.caseInfoID = i2;
        }

        public void setCreateTimeX(String str) {
            this.createTimeX = str;
        }

        public void setCultural(int i2) {
            this.cultural = i2;
        }

        public void setCulturalName(String str) {
            this.culturalName = str;
        }

        public void setCulturalText(String str) {
            this.culturalText = str;
        }

        public void setDocumentName(String str) {
            this.documentName = str;
        }

        public void setDocumentNumberX(String str) {
            this.documentNumberX = str;
        }

        public void setDocumentType(int i2) {
            this.documentType = i2;
        }

        public void setDocumentTypeTextX(String str) {
            this.documentTypeTextX = str;
        }

        public void setIdX(int i2) {
            this.idX = i2;
        }

        public void setMobileNumber(String str) {
            this.mobileNumber = str;
        }

        public void setNameX(String str) {
            this.nameX = str;
        }

        public void setNationality(int i2) {
            this.nationality = i2;
        }

        public void setNationalityName(String str) {
            this.nationalityName = str;
        }

        public void setNationalityText(String str) {
            this.nationalityText = str;
        }

        public void setOccupation(String str) {
            this.occupation = str;
        }

        public void setPresentAddress(String str) {
            this.presentAddress = str;
        }

        public void setPresentAddressDetail(String str) {
            this.presentAddressDetail = str;
        }

        public void setPresentAddressName(String str) {
            this.presentAddressName = str;
        }

        public void setSex(int i2) {
            this.sex = i2;
        }

        public void setUnit(String str) {
            this.unit = str;
        }

        public void setUpdateTimeX(String str) {
            this.updateTimeX = str;
        }
    }

    public int getAppCount() {
        return this.appCount;
    }

    public int getCallTelCount() {
        return this.callTelCount;
    }

    public String getCaseCategoryText() {
        return this.caseCategoryText;
    }

    public String getCaseName() {
        return this.caseName;
    }

    public String getCaseNumber() {
        return this.caseNumber;
    }

    public int getChargeTelCount() {
        return this.chargeTelCount;
    }

    public String getConfirmFileID() {
        return this.confirmFileID;
    }

    public String getConfirmFileUrl() {
        return this.confirmFileUrl;
    }

    public String getConfirmTime() {
        return this.confirmTime;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public String getDocumentTypeText() {
        return this.documentTypeText;
    }

    public String getId() {
        return this.id;
    }

    public int getLinkTelCount() {
        return this.linkTelCount;
    }

    public int getMailingTelCount() {
        return this.mailingTelCount;
    }

    public String getName() {
        return this.name;
    }

    public int getNetAccountCount() {
        return this.netAccountCount;
    }

    public int getPaymentCount() {
        return this.paymentCount;
    }

    public String getPoliceMobile() {
        return this.policeMobile;
    }

    public String getProcessTime() {
        return this.processTime;
    }

    public List<ReplyBean> getReplys() {
        return this.replys;
    }

    public int getSmsCount() {
        return this.smsCount;
    }

    public int getStatus() {
        return this.status;
    }

    public int getStopPaymentCount() {
        return this.stopPaymentCount;
    }

    public String getSubmitUserID() {
        return this.submitUserID;
    }

    public int getSuspectCount() {
        return this.suspectCount;
    }

    public int getTransferErrorCount() {
        return this.transferErrorCount;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public int getUrlCount() {
        return this.urlCount;
    }

    public int getVictimCount() {
        return this.victimCount;
    }

    public void setAppCount(int i2) {
        this.appCount = i2;
    }

    public void setCallTelCount(int i2) {
        this.callTelCount = i2;
    }

    public void setCaseCategoryText(String str) {
        this.caseCategoryText = str;
    }

    public void setCaseName(String str) {
        this.caseName = str;
    }

    public void setCaseNumber(String str) {
        this.caseNumber = str;
    }

    public void setChargeTelCount(int i2) {
        this.chargeTelCount = i2;
    }

    public void setConfirmFileID(String str) {
        this.confirmFileID = str;
    }

    public void setConfirmFileUrl(String str) {
        this.confirmFileUrl = str;
    }

    public void setConfirmTime(String str) {
        this.confirmTime = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDocumentNumber(String str) {
        this.documentNumber = str;
    }

    public void setDocumentTypeText(String str) {
        this.documentTypeText = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLinkTelCount(int i2) {
        this.linkTelCount = i2;
    }

    public void setMailingTelCount(int i2) {
        this.mailingTelCount = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNetAccountCount(int i2) {
        this.netAccountCount = i2;
    }

    public void setPaymentCount(int i2) {
        this.paymentCount = i2;
    }

    public void setPoliceMobile(String str) {
        this.policeMobile = str;
    }

    public void setProcessTime(String str) {
        this.processTime = str;
    }

    public void setReplys(List<ReplyBean> list) {
        this.replys = list;
    }

    public void setSmsCount(int i2) {
        this.smsCount = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStopPaymentCount(int i2) {
        this.stopPaymentCount = i2;
    }

    public void setSubmitUserID(String str) {
        this.submitUserID = str;
    }

    public void setSuspectCount(int i2) {
        this.suspectCount = i2;
    }

    public void setTransferErrorCount(int i2) {
        this.transferErrorCount = i2;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setUrlCount(int i2) {
        this.urlCount = i2;
    }

    public void setVictimCount(int i2) {
        this.victimCount = i2;
    }
}
