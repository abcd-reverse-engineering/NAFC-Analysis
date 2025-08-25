package ui.presenter;

import android.content.Context;
import android.text.TextUtils;
import bean.module.HomeToolBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import network.http.ReportNumHttp;
import ui.activity.ReportNewActivity;
import util.k1;
import util.y1;

/* compiled from: MainPagePresenter.java */
/* loaded from: classes2.dex */
class e0 implements ReportNumHttp.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainPagePresenter f20219a;

    e0(MainPagePresenter mainPagePresenter) {
        this.f20219a = mainPagePresenter;
    }

    @Override // network.http.ReportNumHttp.Callback
    public void onNumSuccess() {
        RegionMudelBean regionMudelBeanJ = d.a.j();
        if (regionMudelBeanJ == null) {
            y1.a((Context) this.f20219a.mActivity, (Class<?>) ReportNewActivity.class);
            return;
        }
        if (regionMudelBeanJ.getTool() == null || regionMudelBeanJ.getTool().size() <= 0) {
            return;
        }
        for (HomeToolBean homeToolBean : regionMudelBeanJ.getTool()) {
            if (TextUtils.equals(homeToolBean.getId(), ModuelConfig.MODEL_REPORT) && !TextUtils.isEmpty(homeToolBean.getModule())) {
                k1.a(this.f20219a.mActivity, homeToolBean.getModule());
                return;
            } else if (TextUtils.equals(homeToolBean.getModule(), ModuelConfig.MODEL_REPORT)) {
                y1.a((Context) this.f20219a.mActivity, (Class<?>) ReportNewActivity.class);
            }
        }
    }
}
