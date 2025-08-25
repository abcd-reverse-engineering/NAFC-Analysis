package ui.presenter;

import android.content.Context;
import bean.CallWarnBean;
import bean.ReportPersonBean;
import bean.SMSWarnBean;
import bean.SmsBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.HistoryListInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.basemvp.BaseView;
import ui.callview.CallWarnCallView;
import ui.callview.ReportCallView;
import ui.callview.SMSWarnCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class WarnPresenter extends ModelPresent {
    CallWarnCallView mWarnCallView;
    SMSWarnCallView mWarnSmsView;

    class a extends MiddleSubscriber<APIresult<CallWarnBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CallWarnBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            WarnPresenter.this.mWarnCallView.onSuccRequest(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CallWarnBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            try {
                if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                    WarnPresenter.this.mWarnCallView.onSuccRequest(null);
                } else {
                    WarnPresenter.this.mWarnCallView.onSuccRequest(aPIresult.getData());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                WarnPresenter.this.mWarnCallView.onSuccRequest(null);
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<SMSWarnBean>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return SMSWarnBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            WarnPresenter.this.mWarnSmsView.onSuccRequest(new SMSWarnBean());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<SMSWarnBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null) {
                WarnPresenter.this.mWarnSmsView.onSuccRequest(new SMSWarnBean());
            } else {
                WarnPresenter.this.mWarnSmsView.onSuccRequest(aPIresult.getData());
            }
        }
    }

    class c implements ReportCallView {
        c() {
        }

        @Override // ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            w1.a("举报成功");
        }

        @Override // ui.callview.ReportCallView
        public void onfailRequest() {
        }
    }

    public WarnPresenter(Context context, CallWarnCallView callWarnCallView) {
        super(context, (BaseView) null);
        this.mWarnCallView = callWarnCallView;
    }

    public void oneKeyReportSMS(SmsBean smsBean, List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(smsBean);
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setDupery("其他诈骗");
        reportPersonBean.setDefraudType(22);
        reportPersonBean.setCaseDis("短信预警一键举报");
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new c());
        reportPresenter.setIsilent(true);
        reportPresenter.reportSubmit(null, arrayList, list, null, null, reportPersonBean);
    }

    public void requestOKHttp(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_WARN, 6, e.b.f0);
        HashMap<String, String> map = new HashMap<>();
        map.put("tel", str);
        requestOKHttp(strA, map, new a());
    }

    public void requestSMSHttp(String str, String str2) {
        String strA = d.a.a(ModuelConfig.MODEL_WARN, 6, e.b.k0);
        HashMap<String, String> map = new HashMap<>();
        map.put("tel", str);
        map.put("smsContent", str2);
        requestSMSHttp(strA, map, new b());
    }

    public WarnPresenter(Context context, SMSWarnCallView sMSWarnCallView) {
        super(context, (BaseView) null);
        this.mWarnSmsView = sMSWarnCallView;
    }
}
