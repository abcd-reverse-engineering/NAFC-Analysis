package network;

import bean.APIH5Bean;
import bean.AccountListBean;
import bean.AdBean;
import bean.AddressBean;
import bean.BaseAddressBean;
import bean.BrandBean;
import bean.CallBean;
import bean.CallWarnBean;
import bean.CaseDetailBean;
import bean.CaseDivisonBean;
import bean.CaseHistoryBean;
import bean.ChatDetailResultBean;
import bean.ChatDetailResultBeanTest;
import bean.CheckFraudBean;
import bean.CheckFraudCountBean;
import bean.CheckUserBean;
import bean.CriminalBean;
import bean.CriminalPhoneNumBean;
import bean.CriminalSmsBean;
import bean.CriminalSocialBean;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import bean.GuideBean;
import bean.HandKey;
import bean.HomeNewCaseBean;
import bean.IDVarfyBean;
import bean.InDustryBean;
import bean.ManualListBean;
import bean.NoteDlgBean;
import bean.NoteListBean;
import bean.OssTokenBean;
import bean.PageBean;
import bean.PolicBean;
import bean.QATypeBean;
import bean.RechargeBean;
import bean.RechargePlatBean;
import bean.RecordCountBean;
import bean.RegionConfigBean;
import bean.RelationBean;
import bean.RelationPlatBean;
import bean.ReplyBean;
import bean.ReportCaseBean;
import bean.ReportResultBean;
import bean.ReportWebsitBean;
import bean.ReportZPBean;
import bean.SMSWarnBean;
import bean.SearchVirusAppResultBean;
import bean.SignComitBean;
import bean.SocialTypeBean;
import bean.SurveyAppBean;
import bean.SurveyAudioResultBean;
import bean.SurveyPeopleBean;
import bean.SurveyToH5Bean;
import bean.UserInfoBean;
import bean.VerifyAcceptBean;
import bean.VerifyHomePointBean;
import bean.WebArticleBean;
import bean.WebInfoNumBean;
import bean.YcLicenceBean;
import g.a.b0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l.s.f;
import l.s.l;
import l.s.o;
import l.s.q;
import l.s.x;
import network.HistoryListInfo;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterInfo;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
public interface IReportService {
    @o
    b0<APIresult<SurveyToH5Bean>> SurveyToH5Bean(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<SurveyAudioResultBean>> SurveyUploadFile2(@x String str, @l.s.a HashMap<String, String> map);

    @o
    b0<APIresult<List<APIH5Bean>>> allDictionary(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<BrandBean>>> brandList(@x String str);

    @o
    b0<APIresult> cancelUpdate(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> cancleUploadFile(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<CaseHistoryBean>> caseHistoryList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<CheckFraudBean>> checkFraud(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<CheckFraudCountBean>> checkFraudCount(@x String str);

    @o
    b0<APIresult<CheckFraudBean>> checkFraudIpUrl(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<CheckUserBean>> checkisverify(@x String str);

    @o
    b0<APIresult> confirmIDAuth(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> deleteCaseWebUrl(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> deletePeople(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> deleteReportCriminal(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> deleteSurveyApp(@x String str, @l.s.a HashMap<String, String> map);

    @o
    b0<APIresult<DownloadInfo>> download(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> evidenceSubmit(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> feedBack2(@x String str, @l.s.a Map<String, String> map);

    @l
    @o
    b0<APIresult> fileUpload(@x String str, @q("data") FileInfo_2 fileInfo_2, @q MultipartBody.Part part);

    @o
    b0<APIresult<Boolean>> getAccHasPwd(@x String str);

    @o
    b0<APIresult<AdBean>> getAd(@x String str);

    @o
    b0<APIresult<BaseAddressBean>> getAddress(@x String str, @l.s.a Map<String, String> map);

    @f
    b0<List<AddressBean>> getAreaListOss(@x String str);

    @o
    b0<APIresult<CheckUserBean>> getAuditinfo(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<BannerInfo>>> getBanner(@x String str);

    @o
    b0<APIresult<Integer>> getCaseBankNum(@x String str);

    @o
    b0<APIresult> getCaseInfoById(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<SignComitBean>> getComitReportNum(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<CriminalBean>>> getCriminalList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<CallBean>>> getCriminalPhoneList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<CriminalPhoneNumBean>> getCriminalPhoneNum(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<WebInfoNumBean>> getCriminalWebInfoNum(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<DeliveryBean>>> getDeliveryList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<DeliveryPlatBean>>> getDeliveryPlatList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<CaseDetailBean>> getDetail(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<GuideBean>>> getGuideConfig(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<HistoryListInfo>> getHistorylist(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<InDustryBean>>> getIndustrys(@x String str);

    @o
    b0<APIresult<List<ReportZPBean>>> getNEvidenceType(@x String str);

    @o
    b0<APIresult<UserInfoBean>> getNew(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<HomeNewCaseBean>> getNewCaseList(@x String str, @l.s.a Map<String, String> map);

    @f
    b0<List<HomeNewCaseBean.RowsBean>> getNewCaseListOss(@x String str);

    @o
    b0<APIresult<List<NoteListBean>>> getNoteList(@x String str);

    @o
    b0<APIresult<NoteListBean>> getNoteListItem(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> getOperation(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<OssTokenBean>> getOssToken(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<AccountListBean>>> getPayment(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<QATypeBean>>> getQAList(@x String str);

    @o
    b0<APIresult<List<RechargeBean>>> getRechargePhoneList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<RechargePlatBean>>> getRechargePlatList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<RegionConfigBean>> getRegionJson(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> getRegionJsonData(@x String str, @l.s.a Map<String, String> map);

    @f
    b0<ResponseBody> getRegionJsonOss(@x String str);

    @o
    b0<APIresult<List<RelationBean>>> getRelationList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<RelationPlatBean>>> getRelationPlatList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<ReplyBean>>> getReply(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<RecordCountBean>> getReportNum(@x String str);

    @o
    b0<APIresult<Integer>> getReportNum(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<SMSWarnBean>> getSMSWarnInfo(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<SocialTypeBean>>> getSocialTags(@x String str);

    @o
    b0<APIresult<List<SurveyAppBean>>> getSurveyAppList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<ReportWebsitBean>>> getSurveyWebList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> getTelType(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<VerifyAcceptBean>>> getVerifyAcceptList(@x String str);

    @o
    b0<APIresult<VerifyHomePointBean>> getVerifyHomePoint(@x String str);

    @o
    b0<APIresult<IDVarfyBean>> getVerifyList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<SurveyPeopleBean>>> getVictimList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<YcLicenceBean>> getYCLicence(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<HistoryDetailInfo>> getdetail(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<String>>> getsocialtels(@x String str);

    @o
    b0<APIresult<HelpUploadInfo>> helpUpload(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<HandKey>> jniAppKey(@x String str, @l.s.a Map<String, String> map);

    @o
    l.b<APIresult<HandKey>> jniAppKeySyn(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> listenApp(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> loginOffHttp(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<CheckUserBean>> manualAlreadyDetail(@x String str, @l.s.a Map<String, Long> map);

    @o
    b0<APIresult<PageBean<ManualListBean>>> manualList(@x String str, @l.s.a Map<String, Object> map);

    @o
    b0<APIresult<PolicBean>> policLogintion(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> policLogot(@x String str);

    @o
    b0<APIresult<AccountInfo>> postNew(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> postOperation(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<Boolean>> redName(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> removeDelivery(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> removeRechargetel(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> removeRelationtel(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> removecalltel(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> reportAddCaseWebUrl(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> reportConfirm(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> reportCriminalAdd(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> reportFraudIpUrl(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<HistoryListInfo.RowsBean>> reportSubmit(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<ReportResultBean>> reportUploadFile(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<ReportCaseBean>> reportUserCases(@x String str);

    @o
    b0<APIresult<WebArticleBean>> requessArticInfo(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<APIH5Bean>> requestAppConfig(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> requestLoginOut(@x String str);

    @o
    b0<APIresult<NoteDlgBean>> requestNewNote(@x String str);

    @o
    b0<APIresult<CallWarnBean>> requestOKHttp(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<Integer>> requestPhoneCode(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<DeliveryBean>> saveDeliveryTel(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> saveRechargeTel(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> saveRelationTel(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> saveSms(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> saveSocial(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<ChatDetailResultBeanTest>> saveTransfer(@x String str, @l.s.a HashMap<String, String> map);

    @o
    b0<APIresult<CallBean>> savecalltel(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> savexc(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<SearchVirusAppResultBean>>> searchVirusApp(@x String str, @l.s.a Map<Object, Object> map);

    @o
    b0<APIresult> silentlyreg(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<CriminalSmsBean>>> smsList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<List<CriminalSocialBean>>> socialList(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> solve(@x String str, @l.s.a Map<String, Object> map);

    @o
    b0<APIresult> submitaudit(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> surveyAddCasePerson(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult> surveyCaseApp(@x String str, @l.s.a HashMap<String, String> map);

    @o
    b0<APIresult<List<CaseDivisonBean>>> surveyCredentType(@x String str);

    @o
    b0<APIresult> trackData(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<Double>> updateUserInfo(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<String>> uploadCriminalFile2(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<ChatDetailResultBean>> uploadDetail(@x String str, @l.s.a MultipartBody multipartBody);

    @o
    b0<APIresult> uploadFile(@x String str, @l.s.a MultipartBody multipartBody);

    @o
    b0<APIresult<ChatDetailResultBean>> uploadTransferFile(@x String str, @l.s.a MultipartBody multipartBody);

    @o
    b0<APIresult> verifyCreate(@x String str, @l.s.a Map<String, String> map);

    @o
    b0<APIresult<RegisterInfo>> verityNew(@x String str, @l.s.a Map<String, String> map);
}
