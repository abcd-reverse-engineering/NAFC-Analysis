package receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.AppVirusBean;
import bean.SearchVirusAppBean;
import bean.SearchVirusAppResultBean;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import network.http.SearchVirusAppHttp;
import ui.callview.VirusKillingCallView;
import ui.d.a;
import ui.presenter.VirusKillingPresenter;
import ui.presenter.WelocmPresenter;
import util.r1;
import util.u1;
import util.v1;

/* loaded from: classes2.dex */
public class AppReceiver extends BroadcastReceiver implements a.InterfaceC0287a {

    /* renamed from: a, reason: collision with root package name */
    private AppInfoBean f17527a;

    /* renamed from: b, reason: collision with root package name */
    private Context f17528b;

    /* renamed from: c, reason: collision with root package name */
    private ui.d.a f17529c = null;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17530a;

        a(String str) {
            this.f17530a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppReceiver appReceiver = AppReceiver.this;
            appReceiver.f17527a = r1.c(appReceiver.f17528b).a(this.f17530a);
            if (AppReceiver.this.f17527a != null) {
                AppReceiver appReceiver2 = AppReceiver.this;
                appReceiver2.a(appReceiver2.f17527a);
            }
        }
    }

    class b implements SearchVirusAppHttp.Callback {
        b() {
        }

        @Override // network.http.SearchVirusAppHttp.Callback
        public void principalResult(@i.c.a.e AppInfoBean appInfoBean, @i.c.a.e List<SearchVirusAppResultBean> list) {
            if (appInfoBean == null || list == null || list.size() <= 0) {
                return;
            }
            SearchVirusAppResultBean searchVirusAppResultBean = list.get(0);
            int riskLevel = searchVirusAppResultBean.getRiskLevel();
            if (riskLevel == 1) {
                if (appInfoBean.getVirusLevel() != 1) {
                    appInfoBean.setVirusLevel(2);
                }
                AppReceiver.this.a(appInfoBean, searchVirusAppResultBean);
            } else if (riskLevel == 2) {
                appInfoBean.setVirusLevel(1);
                AppReceiver.this.a(appInfoBean, searchVirusAppResultBean);
            }
            String str = "getVirusLevel==" + appInfoBean.getVirusLevel();
            if (appInfoBean.getVirusLevel() == 1 || appInfoBean.getVirusLevel() == 2) {
                AppReceiver appReceiver = AppReceiver.this;
                appReceiver.a(appReceiver.f17528b, appInfoBean.getName());
            }
        }
    }

    class c implements VirusKillingCallView {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f17533a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AppReceiver.this.f17529c == null || !AppReceiver.this.f17529c.isShowing()) {
                    return;
                }
                AppReceiver.this.f17529c.dismiss();
            }
        }

        c(TextView textView) {
            this.f17533a = textView;
        }

        @Override // ui.callview.VirusKillingCallView
        public void onAppealSuccess() {
            TextView textView;
            if (AppReceiver.this.f17529c != null && AppReceiver.this.f17529c.isShowing() && (textView = this.f17533a) != null) {
                textView.setText("已提交");
                this.f17533a.setEnabled(false);
                this.f17533a.setTextColor(AppReceiver.this.f17528b.getResources().getColor(R.color.colorGray));
                this.f17533a.setBackgroundResource(R.drawable.button_bg_gray);
            }
            new Handler().postDelayed(new a(), 3000L);
        }
    }

    @Override // ui.d.a.InterfaceC0287a
    public void a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (u1.a(u1.H, false) && !TextUtils.equals(WelocmPresenter.VIRAPWARN, "0")) {
            this.f17528b = context;
            String action = intent.getAction();
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                String str = "onReceive    app is added-----------------   " + schemeSpecificPart;
                new Thread(new a(schemeSpecificPart)).start();
            }
        }
    }

    private void b(TextView textView) {
        ArrayList arrayList = new ArrayList();
        AppVirusBean appVirusBean = new AppVirusBean();
        appVirusBean.setAppName(this.f17527a.getName());
        appVirusBean.setFileMd5(this.f17527a.getAppMD5());
        appVirusBean.setVersionCode(this.f17527a.getVersionCode() + "");
        appVirusBean.setPkgName(this.f17527a.getPkgName());
        appVirusBean.setSignHash(this.f17527a.getSignHash());
        appVirusBean.setFindTime(v1.a(System.currentTimeMillis()));
        appVirusBean.setVirusDescription(this.f17527a.getVirusDescription());
        appVirusBean.setVirusName(this.f17527a.getVirusName());
        int virusLevel = this.f17527a.getVirusLevel();
        if (virusLevel == 1) {
            appVirusBean.setVirusLevel(1);
            appVirusBean.setIllegalType("病毒");
        } else if (virusLevel == 2) {
            appVirusBean.setVirusLevel(2);
            appVirusBean.setIllegalType("风险");
        }
        arrayList.add(appVirusBean);
        new VirusKillingPresenter((Activity) null, (VirusKillingCallView) new c(textView)).appealApp(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppInfoBean appInfoBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SearchVirusAppBean(appInfoBean.getName(), appInfoBean.getPkgName(), appInfoBean.getPkgPath(), appInfoBean.getAppMD5()));
        SearchVirusAppHttp.Companion.getInstance().principalHttp(appInfoBean, arrayList, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppInfoBean appInfoBean, SearchVirusAppResultBean searchVirusAppResultBean) {
        String str;
        String virusName = appInfoBean.getVirusName();
        String str2 = "";
        if (TextUtils.isEmpty(virusName)) {
            virusName = "";
        }
        String virusName2 = searchVirusAppResultBean.getVirusName();
        if (TextUtils.isEmpty(virusName2)) {
            str = "";
        } else {
            str = AppInfoBean.API_TAG_VIRUS_NAME + virusName2;
        }
        appInfoBean.setVirusName(virusName + str);
        String virusDescription = appInfoBean.getVirusDescription();
        if (TextUtils.isEmpty(virusDescription)) {
            virusDescription = "";
        }
        String virusDesc = searchVirusAppResultBean.getVirusDesc();
        if (!TextUtils.isEmpty(virusDesc)) {
            str2 = AppInfoBean.API_TAG_VIRUS_DISCRIPTION + virusDesc;
        }
        appInfoBean.setVirusDescription(virusDescription + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        this.f17529c = new ui.d.a(context);
        this.f17529c.show();
        this.f17529c.a("新下载的“" + str + "”\n经检测为疑似涉诈APP，请谨慎使用");
        this.f17529c.setOnBtnClickListener(this);
    }

    @Override // ui.d.a.InterfaceC0287a
    public void a(TextView textView) {
        b(textView);
    }
}
