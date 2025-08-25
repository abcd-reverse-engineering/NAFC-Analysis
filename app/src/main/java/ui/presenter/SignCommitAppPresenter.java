package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SurveyAppBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.SignAppDetailActivity;
import ui.callview.ReportAppView;
import ui.model.ModelPresent;
import util.b1;
import util.k1;
import util.w1;
import util.y1;

/* loaded from: classes2.dex */
public class SignCommitAppPresenter extends ModelPresent<ReportAppView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<SurveyAppBean> mAppBeans;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f20111a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public View f20113a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f20114b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f20115c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f20116d;

            /* renamed from: e, reason: collision with root package name */
            public View f20117e;

            /* renamed from: f, reason: collision with root package name */
            public View f20118f;

            /* renamed from: g, reason: collision with root package name */
            public ImageView f20119g;

            public a(View view) {
                super(view);
                this.f20113a = view.findViewById(R.id.fl_view);
                this.f20114b = (TextView) view.findViewById(R.id.tv_app_name);
                this.f20117e = view.findViewById(R.id.ll_app_pkg);
                this.f20118f = view.findViewById(R.id.ll_app_vers);
                this.f20115c = (TextView) view.findViewById(R.id.tv_app_pkg);
                this.f20116d = (TextView) view.findViewById(R.id.tv_app_vers);
                this.f20119g = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f20111a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            aVar.f20119g.setVisibility(8);
            if (SignCommitAppPresenter.this.mAppBeans.size() > 0) {
                SurveyAppBean surveyAppBean = (SurveyAppBean) SignCommitAppPresenter.this.mAppBeans.get(i2);
                aVar.f20114b.setText(surveyAppBean.getAppName());
                if (y1.p(surveyAppBean.getPackageName())) {
                    aVar.f20117e.setVisibility(8);
                } else {
                    aVar.f20117e.setVisibility(0);
                    aVar.f20115c.setText(surveyAppBean.getPackageName());
                }
                if (y1.p(surveyAppBean.getAppVersion())) {
                    aVar.f20118f.setVisibility(8);
                } else {
                    aVar.f20118f.setVisibility(0);
                    aVar.f20116d.setText(surveyAppBean.getAppVersion());
                }
            }
            aVar.f20113a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20254a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SignCommitAppPresenter.this.mAppBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f20111a).inflate(R.layout.item_report_app, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(SignCommitAppPresenter.this.mActivity, (Class<?>) SignAppDetailActivity.class);
            intent.putExtra(k1.C0, SignCommitAppPresenter.this.caseInfoId);
            intent.putExtra(k1.f20845c, (Serializable) SignCommitAppPresenter.this.mAppBeans.get(i2));
            SignCommitAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<SurveyAppBean>>> {

        /* renamed from: ui.presenter.SignCommitAppPresenter$a$a, reason: collision with other inner class name */
        class C0311a extends com.google.gson.d0.a<List<SurveyAppBean>> {
            C0311a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0311a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<SurveyAppBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((ReportAppView) SignCommitAppPresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
            } else {
                ((ReportAppView) SignCommitAppPresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    public SignCommitAppPresenter(Activity activity, String str, ReportAppView reportAppView) {
        super(activity, reportAppView);
        this.mAppBeans = new ArrayList();
        this.caseInfoId = str;
    }

    private void httpReportAppList(HashMap<String, String> map) {
        getSurveyAppList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.M1), map, new a());
    }

    public void getReportAppList(String str) {
        b1.a("请稍后...", true, this.mActivity);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        httpReportAppList(map);
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<SurveyAppBean> list) {
        if (list != null) {
            this.mAppBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
