package ui.model;

import android.app.Activity;
import android.content.Context;
import bean.APIH5Bean;
import bean.AccountListBean;
import bean.AdBean;
import bean.AddressBean;
import bean.AppVirusBean;
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
import bean.CriminalRequestBean;
import bean.CriminalSmsBean;
import bean.CriminalSocialBean;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import bean.GuideBean;
import bean.HandKey;
import bean.HomeNewCaseBean;
import bean.IDVarfyBean;
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
import bean.SearchVirusAppBean;
import bean.SignComitBean;
import bean.SocialTypeBean;
import bean.SurveyAppBean;
import bean.SurveyAudioResultBean;
import bean.SurveyPeopleBean;
import bean.SurveyToH5Bean;
import bean.TransferBean;
import bean.UploadFileBean;
import bean.UserInfoBean;
import bean.VerifyAcceptBean;
import bean.VerifyHomePointBean;
import bean.WebArticleBean;
import bean.WebInfoNumBean;
import bean.YcLicenceBean;
import g.a.i0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import network.Api;
import network.BannerInfo;
import network.DownloadInfo;
import network.FeedbackInfo;
import network.FileInfo_2;
import network.HistoryDetailInfo;
import network.HistoryListInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import network.account.RegisterInfo;
import network.request.EvidenceCommInfo;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import ui.basemvp.BaseModel;
import ui.basemvp.BaseView;
import ui.presenter.JNIHandStamp;

/* loaded from: classes2.dex */
public class ModelPresent<V extends BaseView> extends BaseModel {
    public V mvpView;

    protected ModelPresent(Activity activity, V v) {
        this.mActivity = activity;
        this.mvpView = v;
    }

    public static void searchVirusApp(String str, List<SearchVirusAppBean> list, MiddleSubscriber middleSubscriber) {
        Api.getInstance().getReportService().searchVirusApp(str, JNIHandStamp.getInstance().princEncode(list)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void ReportFraudIpUrl(HashMap<String, Object> map, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().reportFraudIpUrl(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void SurveyH5Param(Map<String, Object> map, String str, MiddleSubscriber<APIresult<SurveyToH5Bean>> middleSubscriber) {
        Api.getInstance().getReportService().SurveyToH5Bean(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void SurveyUploadFile2(String str, UploadFileBean uploadFileBean, MiddleSubscriber<APIresult<SurveyAudioResultBean>> middleSubscriber) {
        Api.getInstance().getReportService().SurveyUploadFile2(str, JNIHandStamp.getInstance().princEncode(uploadFileBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void accountHttp(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<UserInfoBean>> middleSubscriber) {
        Api.getInstance().getReportService().getNew(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void allDictionary(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<List<APIH5Bean>>> middleSubscriber) {
        Api.getInstanceImei().getReportService().allDictionary(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void appOperation(String str, List<AppVirusBean> list, MiddleSubscriber middleSubscriber) {
        Api.getInstance().getReportService().postOperation(str, JNIHandStamp.getInstance().princEncode(list)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void beforOrEndHttp(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().helpUpload(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void brandList(String str, MiddleSubscriber<APIresult<List<BrandBean>>> middleSubscriber) {
        Api.getInstance().getReportService().brandList(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void cancelUpdateHttp(HashMap<String, String> map, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().cancelUpdate(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void cancleUploadFile(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().cancleUploadFile(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void caseHistoryList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<CaseHistoryBean>> middleSubscriber) {
        Api.getInstance().getReportService().caseHistoryList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void checkFraudIpUrl(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<CheckFraudBean>> middleSubscriber) {
        Api.getInstance().getReportService().checkFraudIpUrl(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void checkisverify(String str, MiddleSubscriber<APIresult<CheckUserBean>> middleSubscriber) {
        Api.getInstance().getReportService().checkisverify(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void confirmIDAuth(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().confirmIDAuth(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void createInvited(String str, HashMap<String, String> map, MiddleSubscriber middleSubscriber) {
        Api.getInstanceMode().getReportService().postOperation(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void criminalCallSave(String str, CallBean callBean, MiddleSubscriber<APIresult<CallBean>> middleSubscriber) {
        Api.getInstance().getReportService().savecalltel(str, JNIHandStamp.getInstance().princEncode(callBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void deleteCaseAppInfo(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().deleteSurveyApp(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void deleteCaseWebUrl(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().deleteCaseWebUrl(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void deletePeople(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().deletePeople(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void deleteReportCriminal(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().deleteReportCriminal(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void deleteReportCriminalPic(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().deleteReportCriminal(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void feedBack2(FeedbackInfo feedbackInfo, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().feedBack2(str, JNIHandStamp.getInstance().princEncode(feedbackInfo)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getAccHasPwd(String str, MiddleSubscriber<APIresult<Boolean>> middleSubscriber) {
        Api.getInstance().getReportService().getAccHasPwd(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getAd(String str, MiddleSubscriber<APIresult<AdBean>> middleSubscriber) {
        Api.getInstance().getReportService().getAd(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getAreaListOss(String str, i0<List<AddressBean>> i0Var) {
        Api.getInstance().getReportService().getAreaListOss(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(i0Var);
    }

    protected void getAuditinfo(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<CheckUserBean>> middleSubscriber) {
        Api.getInstance().getReportService().getAuditinfo(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getBanner(String str, MiddleSubscriber<APIresult<List<BannerInfo>>> middleSubscriber) {
        Api.getInstance().getReportService().getBanner(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getCaseBankNum(String str, MiddleSubscriber<APIresult<Integer>> middleSubscriber) {
        Api.getInstance().getReportService().getCaseBankNum(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getCaseInfoById(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().getCaseInfoById(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getComitReportNum(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<SignComitBean>> middleSubscriber) {
        Api.getInstance().getReportService().getComitReportNum(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getCriminalCallNum(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<CriminalPhoneNumBean>> middleSubscriber) {
        Api.getInstance().getReportService().getCriminalPhoneNum(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getCriminalList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<CriminalBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getCriminalList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getCriminalPhoneList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<CallBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getCriminalPhoneList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getCriminalWebInfoNum(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<WebInfoNumBean>> middleSubscriber) {
        Api.getInstance().getReportService().getCriminalWebInfoNum(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getDeliveryList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<DeliveryBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getDeliveryList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getDeliveryPlatList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<DeliveryPlatBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getDeliveryPlatList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getDetail(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<CaseDetailBean>> middleSubscriber) {
        Api.getInstance().getReportService().getDetail(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getNewCaseList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<HomeNewCaseBean>> middleSubscriber) {
        Api.getInstance().getReportService().getNewCaseList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getNewCaseListOss(String str, i0<List<HomeNewCaseBean.RowsBean>> i0Var) {
        Api.getInstance().getReportServiceUnHeader().getNewCaseListOss(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(i0Var);
    }

    protected void getNoteList(String str, MiddleSubscriber<APIresult<List<NoteListBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getNoteList(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getNoteListItem(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<NoteListBean>> middleSubscriber) {
        Api.getInstance().getReportService().getNoteListItem(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getOperation(String str, HashMap<String, Object> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().getOperation(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getOssToken(String str, Object obj, MiddleSubscriber<APIresult<OssTokenBean>> middleSubscriber) {
        Api.getInstance().getReportService().getOssToken(str, JNIHandStamp.getInstance().princEncode(obj)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getPayment(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<AccountListBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getPayment(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getReChargeList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<RechargeBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getRechargePhoneList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getReChargePlatList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<RechargePlatBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getRechargePlatList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getRegionJson(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<RegionConfigBean>> middleSubscriber) {
        Api.getInstance().getReportService().getRegionJson(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getRegionJsonData(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().getRegionJsonData(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getRegionJsonOss(String str, i0<ResponseBody> i0Var) {
        Api.getInstance().getReportService().getRegionJsonOss(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(i0Var);
    }

    protected void getRelationList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<RelationBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getRelationList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getRelationPlatList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<RelationPlatBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getRelationPlatList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getReply(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<ReplyBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getReply(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getReportHistorys(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<HistoryListInfo>> middleSubscriber) {
        Api.getInstanceMode().getReportService().getHistorylist(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getReportMarkData(String str, MiddleSubscriber<APIresult<List<ReportZPBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getNEvidenceType(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getReportNum(String str, MiddleSubscriber<APIresult<RecordCountBean>> middleSubscriber) {
        Api.getInstance().getReportService().getReportNum(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getReportdetail(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<HistoryDetailInfo>> middleSubscriber) {
        Api.getInstance().getReportService().getdetail(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getSocialTags(String str, MiddleSubscriber<APIresult<List<SocialTypeBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getSocialTags(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getSurveyAppList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<SurveyAppBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getSurveyAppList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getSurveyWebList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<ReportWebsitBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getSurveyWebList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getTeltype(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().getTelType(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getVerifyAcceptList(String str, MiddleSubscriber<APIresult<List<VerifyAcceptBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getVerifyAcceptList(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getVerifyHomePoint(String str, MiddleSubscriber<APIresult<VerifyHomePointBean>> middleSubscriber) {
        Api.getInstance().getReportService().getVerifyHomePoint(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getVerifyList(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<IDVarfyBean>> middleSubscriber) {
        Api.getInstance().getReportService().getVerifyList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getVictimList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<SurveyPeopleBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getVictimList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getYCLicence(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<YcLicenceBean>> middleSubscriber) {
        Api.getInstance().getReportService().getYCLicence(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void getsocialtels(String str, MiddleSubscriber<APIresult<List<String>>> middleSubscriber) {
        Api.getInstance().getReportService().getsocialtels(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void jniAppKey(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<HandKey>> middleSubscriber) {
        Api.getInstanceImei().getReportService().jniAppKey(str, map).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void listenApp(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().listenApp(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void loginHttp(String str, RegisterBody registerBody, MiddleSubscriber<APIresult<AccountInfo>> middleSubscriber) {
        Api.getInstance().getReportService().postNew(str, JNIHandStamp.getInstance().princEncode(registerBody)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void loginOffHttp(String str, Map<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().loginOffHttp(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void manualAlreadyDetail(String str, HashMap<String, Long> map, MiddleSubscriber<APIresult<CheckUserBean>> middleSubscriber) {
        Api.getInstance().getReportService().manualAlreadyDetail(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void manualList(String str, HashMap<String, Object> map, MiddleSubscriber<APIresult<PageBean<ManualListBean>>> middleSubscriber) {
        Api.getInstance().getReportService().manualList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void policLogintion(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<PolicBean>> middleSubscriber) {
        Api.getInstance().getReportService().policLogintion(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void policUserLogout(String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().policLogot(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void postOperation(String str, HashMap<String, String> map, MiddleSubscriber middleSubscriber) {
        Api.getInstance().getReportService().postOperation(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void redName(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<Boolean>> middleSubscriber) {
        Api.getInstance().getReportService().redName(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void regionHttp(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<BaseAddressBean>> middleSubscriber) {
        Api.getInstance().getReportService().getAddress(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void registerHttp(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<AccountInfo>> middleSubscriber) {
        Api.getInstance().getReportService().postNew(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void removeDelivery(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().removeDelivery(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void removeRechargetel(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().removeRechargetel(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void removeRelationtel(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().removeRelationtel(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void removecalltel(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().removecalltel(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void reportAddCaseWebUrl(String str, ReportWebsitBean reportWebsitBean, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().reportAddCaseWebUrl(str, JNIHandStamp.getInstance().princEncode(reportWebsitBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void reportConfirm(String str, Map<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().reportConfirm(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void reportCriminalAdd(String str, CriminalRequestBean criminalRequestBean, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().reportCriminalAdd(str, JNIHandStamp.getInstance().princEncode(criminalRequestBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void reportSubmit(EvidenceCommInfo evidenceCommInfo, String str, MiddleSubscriber<APIresult<HistoryListInfo.RowsBean>> middleSubscriber) {
        Api.getInstance().getReportService().reportSubmit(str, JNIHandStamp.getInstance().princEncode(evidenceCommInfo)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void reportSubmitHttp(EvidenceCommInfo evidenceCommInfo, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().evidenceSubmit(str, JNIHandStamp.getInstance().princEncode(evidenceCommInfo)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void reportUploadFile(HashMap<String, Object> map, String str, MiddleSubscriber<APIresult<ReportResultBean>> middleSubscriber) {
        Api.getInstance().getReportService().reportUploadFile(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void reportUserCases(String str, MiddleSubscriber<APIresult<ReportCaseBean>> middleSubscriber) {
        Api.getInstance().getReportService().reportUserCases(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requessArticInfo(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<WebArticleBean>> middleSubscriber) {
        Api.getInstance().getReportService().requessArticInfo(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requessVerifyHttp(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<RegisterInfo>> middleSubscriber) {
        Api.getInstanceMode().getReportService().verityNew(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestAppConfig(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<APIH5Bean>> middleSubscriber) {
        Api.getInstance().getReportService().requestAppConfig(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestCheckFraud(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<CheckFraudBean>> middleSubscriber) {
        Api.getInstance().getReportService().checkFraud(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestCheckFraudCount(String str, MiddleSubscriber<APIresult<CheckFraudCountBean>> middleSubscriber) {
        Api.getInstance().getReportService().checkFraudCount(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestGuideConfig(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<GuideBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getGuideConfig(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestLoginOut(String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().requestLoginOut(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestNewNote(String str, MiddleSubscriber<APIresult<NoteDlgBean>> middleSubscriber) {
        Api.getInstance().getReportService().requestNewNote(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestOKHttp(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<CallWarnBean>> middleSubscriber) {
        Api.getInstance().getReportService().requestOKHttp(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestPhoneCode(String str, Map<String, String> map, MiddleSubscriber<APIresult<AccountInfo>> middleSubscriber) {
        HashMap<String, String> mapPrincEncode = JNIHandStamp.getInstance().princEncode(map);
        if (mapPrincEncode == null || mapPrincEncode.size() <= 0) {
            return;
        }
        Api.getInstance().getReportService().postNew(str, mapPrincEncode).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestPhoneCodeTime(String str, Map<String, String> map, MiddleSubscriber<APIresult<Integer>> middleSubscriber) {
        Api.getInstance().getReportService().requestPhoneCode(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestQAList(String str, MiddleSubscriber<APIresult<List<QATypeBean>>> middleSubscriber) {
        Api.getInstance().getReportService().getQAList(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestSMSHttp(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<SMSWarnBean>> middleSubscriber) {
        Api.getInstance().getReportService().getSMSWarnInfo(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void requestSolve(String str, HashMap<String, Object> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().solve(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void saveDeliveryTel(String str, DeliveryBean deliveryBean, MiddleSubscriber<APIresult<DeliveryBean>> middleSubscriber) {
        Api.getInstance().getReportService().saveDeliveryTel(str, JNIHandStamp.getInstance().princEncode(deliveryBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void saveRechargeTel(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().saveRechargeTel(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void saveRelationTel(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().saveRelationTel(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void saveSms(CriminalSmsBean criminalSmsBean, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().saveSms(str, JNIHandStamp.getInstance().princEncode(criminalSmsBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void saveSocial(CriminalSocialBean criminalSocialBean, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().saveSocial(str, JNIHandStamp.getInstance().princEncode(criminalSocialBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void saveTransfer(String str, TransferBean transferBean, MiddleSubscriber<APIresult<ChatDetailResultBeanTest>> middleSubscriber) {
        Api.getInstance().getReportService().saveTransfer(str, JNIHandStamp.getInstance().princEncode(transferBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void savexc(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<String>> middleSubscriber) {
        Api.getInstance().getReportService().savexc(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void silentlyreg(String str, Map<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().silentlyreg(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void smsList(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<List<CriminalSmsBean>>> middleSubscriber) {
        Api.getInstance().getReportService().smsList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void socialList(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<List<CriminalSocialBean>>> middleSubscriber) {
        Api.getInstance().getReportService().socialList(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void submitaudit(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().submitaudit(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void surveyAddCasePerson(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().surveyAddCasePerson(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void surveyCaseApp(String str, SurveyAppBean surveyAppBean, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().surveyCaseApp(str, JNIHandStamp.getInstance().princEncode(surveyAppBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void surveyCredentType(String str, MiddleSubscriber<APIresult<List<CaseDivisonBean>>> middleSubscriber) {
        Api.getInstance().getReportService().surveyCredentType(str).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void tencentAppHttp(String str, List<AppVirusBean> list, MiddleSubscriber middleSubscriber) {
        Api.getInstance().getReportService().postOperation(str, JNIHandStamp.getInstance().princEncode(list)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void trackData(String str, HashMap<String, String> map, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().trackData(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void updateApp(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<DownloadInfo>> middleSubscriber) {
        Api.getInstance().getReportService().download(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void updateUserInfo(HashMap<String, String> map, String str, MiddleSubscriber<APIresult<Double>> middleSubscriber) {
        Api.getInstance().getReportService().updateUserInfo(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void uploadCriminalFile2(UploadFileBean uploadFileBean, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().uploadCriminalFile2(str, JNIHandStamp.getInstance().princEncode(uploadFileBean)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void uploadDetail(String str, MultipartBody multipartBody, MiddleSubscriber<APIresult<ChatDetailResultBean>> middleSubscriber) {
        Api.getInstance().getReportService().uploadDetail(str, multipartBody).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void uploadFile(String str, FileInfo_2 fileInfo_2, MultipartBody.Part part, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().fileUpload(str, fileInfo_2, part).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void uploadTransferFile(String str, MultipartBody multipartBody, MiddleSubscriber<APIresult<ChatDetailResultBean>> middleSubscriber) {
        Api.getInstance().getReportService().uploadTransferFile(str, multipartBody).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void verifyCreate(HashMap<String, String> map, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstance().getReportService().verifyCreate(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected ModelPresent(Context context, V v) {
        this.mContext = context;
        this.mvpView = v;
    }

    protected void getReportNum(String str, HashMap<String, String> map, MiddleSubscriber<APIresult<Integer>> middleSubscriber) {
        Api.getInstance().getReportService().getReportNum(str, JNIHandStamp.getInstance().princEncode(map)).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }

    protected void uploadFile(String str, MultipartBody multipartBody, MiddleSubscriber<APIresult> middleSubscriber) {
        Api.getInstanceMode().getReportService().uploadFile(str, multipartBody).c(g.a.e1.a.b()).a(g.a.s0.e.a.a()).subscribe(middleSubscriber);
    }
}
