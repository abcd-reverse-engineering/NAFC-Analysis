package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.ShareConfigBean;
import bean.WebArticleBean;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.StatisticsShareHttp;
import ui.basemvp.BaseView;
import ui.f.c;
import ui.model.ModelPresent;
import util.b1;

/* loaded from: classes2.dex */
public class WebFrgPresenter extends ModelPresent {
    private ShareConfigBean shareBean;
    private ui.f.c shareDialog;

    class a extends MiddleSubscriber<APIresult<WebArticleBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return WebArticleBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<WebArticleBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                WebFrgPresenter.this.onSuccRequest(aPIresult);
            }
        }
    }

    public WebFrgPresenter(Activity activity) {
        super(activity, (BaseView) null);
        this.shareBean = new ShareConfigBean();
    }

    public void doShare(final String str) {
        this.shareDialog = new ui.f.c(this.mActivity, this.shareBean, 2, new c.b() { // from class: ui.presenter.c0
            @Override // ui.f.c.b
            public final void a() {
                StatisticsShareHttp.getInstance().shareArticleHttp(str);
            }
        });
        this.shareDialog.show();
    }

    public void onSuccRequest(APIresult<WebArticleBean> aPIresult) {
        WebArticleBean data = aPIresult.getData();
        if (data != null) {
            this.shareBean.downloadUrl = data.getContent();
            this.shareBean.title = data.getTitle();
            this.shareBean.iconUrl = data.getIcon();
            this.shareBean.description = data.getDescription();
            doShare(data.getId());
        }
    }

    public void requestAticleInfo(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str2)) {
            return;
        }
        b1.a("加载中...", true, this.mActivity);
        String str3 = str + e.b.A;
        HashMap<String, String> map = new HashMap<>();
        map.put("informationID", str2);
        requessArticInfo(str3, map, new a());
    }
}
