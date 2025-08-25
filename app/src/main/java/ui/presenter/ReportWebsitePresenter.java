package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportWebsitBean;
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
import ui.activity.ReportWebsiteAddActivity;
import ui.callview.ReportWebView;
import ui.model.ModelPresent;
import util.b1;
import util.k1;
import util.w1;

/* loaded from: classes2.dex */
public class ReportWebsitePresenter extends ModelPresent<ReportWebView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<ReportWebsitBean> websits;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f20100a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public View f20102a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f20103b;

            /* renamed from: c, reason: collision with root package name */
            public ImageView f20104c;

            public a(View view) {
                super(view);
                this.f20102a = view.findViewById(R.id.fl_view);
                this.f20103b = (TextView) view.findViewById(R.id.tv_weburl);
                this.f20104c = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f20100a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            if (ReportWebsitePresenter.this.websits.size() > 0) {
                aVar.f20103b.setText(((ReportWebsitBean) ReportWebsitePresenter.this.websits.get(i2)).getUrl());
            }
            aVar.f20102a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20247a.a(i2, view);
                }
            });
            aVar.f20104c.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20249a.b(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            ((ReportWebView) ReportWebsitePresenter.this.mvpView).onItemDelet(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportWebsitePresenter.this.websits.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f20100a).inflate(R.layout.item_report_url, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(ReportWebsitePresenter.this.mActivity, (Class<?>) ReportWebsiteAddActivity.class);
            intent.putExtra(k1.C0, ReportWebsitePresenter.this.caseInfoId);
            intent.putExtra(k1.f20845c, (Serializable) ReportWebsitePresenter.this.websits.get(i2));
            ReportWebsitePresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<ReportWebsitBean>>> {

        /* renamed from: ui.presenter.ReportWebsitePresenter$a$a, reason: collision with other inner class name */
        class C0310a extends com.google.gson.d0.a<List<ReportWebsitBean>> {
            C0310a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0310a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<ReportWebsitBean>> aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0 && aPIresult.getData() != null) {
                ((ReportWebView) ReportWebsitePresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            } else {
                ((ReportWebView) ReportWebsitePresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
                aPIresult.getMsg();
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportWebView) ReportWebsitePresenter.this.mvpView).onSuccessHandle(4, null);
            }
        }
    }

    public ReportWebsitePresenter(Activity activity, String str, ReportWebView reportWebView) {
        super(activity, reportWebView);
        this.websits = new ArrayList();
        this.caseInfoId = str;
    }

    public void deleteCaseWebUrl(String str, String str2) {
        b1.a(this.mActivity, "请稍等...");
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.a2);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoId", str);
        map.put("urlInfoID", str2);
        deleteCaseWebUrl(strA, map, new b());
    }

    public void getSurveyWebList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.Y1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getSurveyWebList(strA, map, new a());
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<ReportWebsitBean> list) {
        this.websits = list;
        this.mAdapter.notifyDataSetChanged();
    }
}
