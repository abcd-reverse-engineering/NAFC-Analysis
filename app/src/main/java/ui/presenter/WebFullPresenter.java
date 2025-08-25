package ui.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import bean.SurveyH5Bean;
import bean.SurveyToH5Bean;
import interfaces.PermissionsListener;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.gson.ObjectTypeAdapter;
import ui.activity.CallRecordNewActivity;
import ui.activity.SmsRecordSelectActivity;
import ui.callview.WebFullCallView;
import ui.model.OSSModelPresent;

/* loaded from: classes2.dex */
public class WebFullPresenter extends OSSModelPresent<WebFullCallView> {

    class a implements PermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f20182a;

        a(int i2) {
            this.f20182a = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(WebFullPresenter.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(WebFullPresenter.this.mActivity, (Class<?>) SmsRecordSelectActivity.class);
            intent.putExtra(SmsRecordSelectActivity.f19028h, 1);
            intent.putExtra("extra_select_can", this.f20182a);
            WebFullPresenter.this.mActivity.startActivity(intent);
        }
    }

    class b implements PermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f20184a;

        b(int i2) {
            this.f20184a = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(WebFullPresenter.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(WebFullPresenter.this.mActivity, (Class<?>) CallRecordNewActivity.class);
            intent.putExtra("extra_select_can", this.f20184a);
            WebFullPresenter.this.mActivity.startActivity(intent);
        }
    }

    class c extends MiddleSubscriber<APIresult<SurveyToH5Bean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f20186a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20187b;

        c(String str, String str2) {
            this.f20186a = str;
            this.f20187b = str2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return SurveyToH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((WebFullCallView) ((OSSModelPresent) WebFullPresenter.this).mvpView).onSurveyBeanRequest(this.f20187b, "\"errorMsg\":\"" + aPIException.getMessage() + "\"", false);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<SurveyToH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (this.f20186a.contains("getxccasecategorysv2")) {
                ((WebFullCallView) ((OSSModelPresent) WebFullPresenter.this).mvpView).onSurveyBeanRequest(this.f20187b, "\"response\":" + aPIresult.getEncodeStr(), true);
                return;
            }
            ((WebFullCallView) ((OSSModelPresent) WebFullPresenter.this).mvpView).onSurveyBeanRequest(this.f20187b, "\"response\":" + aPIresult.getEncodeStr(), false);
        }
    }

    public WebFullPresenter(Activity activity, WebFullCallView webFullCallView) {
        super(activity, webFullCallView);
    }

    private void callPermission(int i2) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20918l}, new b(i2));
    }

    private void smsPermission(int i2) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.w, util.permissionutil.a.v}, new a(i2));
    }

    public void SurveyH5Http(String str, Map<String, Object> map, String str2) {
        SurveyH5Param(map, str2, new c(str2, str));
    }

    public void SurveyH5Param(String str) {
        SurveyH5Bean surveyH5Bean = (SurveyH5Bean) ObjectTypeAdapter.buildNewGson().a(str, SurveyH5Bean.class);
        if (surveyH5Bean != null) {
            Map<String, Object> map = new HashMap<>();
            if (surveyH5Bean.getParams() != null) {
                map = surveyH5Bean.getParams();
            }
            if (TextUtils.equals(SurveyH5Bean.POST, surveyH5Bean.getType())) {
                SurveyH5Http(str, map, d.a.c(surveyH5Bean.getTransChannel()) + surveyH5Bean.getApiUrl());
                return;
            }
            if (TextUtils.equals("audio", surveyH5Bean.getType())) {
                return;
            }
            if (TextUtils.equals("event", surveyH5Bean.getType())) {
                ((WebFullCallView) ((OSSModelPresent) this).mvpView).eventH5Action(str, map);
                return;
            }
            if (TextUtils.equals("call", surveyH5Bean.getType())) {
                if (map.containsKey(SurveyH5Bean.SELECTNUM)) {
                    callPermission(Integer.parseInt(map.get(SurveyH5Bean.SELECTNUM).toString()));
                }
            } else if (!TextUtils.equals(SurveyH5Bean.SMS, surveyH5Bean.getType())) {
                ((WebFullCallView) ((OSSModelPresent) this).mvpView).eventH5Action(str, map);
            } else if (map.containsKey(SurveyH5Bean.SELECTNUM)) {
                smsPermission(Integer.parseInt(map.get(SurveyH5Bean.SELECTNUM).toString()));
            }
        }
    }
}
