package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import bean.CaseDetailBean;
import bean.ReplyBean;
import bean.StopPaymentBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import ui.callview.CaseHistoryCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CaseHistoryPresenter extends ModelPresent<CaseHistoryCallView> {
    private HolderAdapte mAdapter;
    private List<ReplyBean> mData;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f19805a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public View f19807a;

            /* renamed from: b, reason: collision with root package name */
            public View f19808b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f19809c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f19810d;

            public a(View view) {
                super(view);
                this.f19807a = view.findViewById(R.id.v_top);
                this.f19808b = view.findViewById(R.id.v_bottom);
                this.f19809c = (TextView) view.findViewById(R.id.tv_content);
                this.f19810d = (TextView) view.findViewById(R.id.tv_time);
            }
        }

        public HolderAdapte(Context context) {
            this.f19805a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, int i2) {
            if (CaseHistoryPresenter.this.mData.size() > 0) {
                if (i2 == 0) {
                    aVar.f19807a.setVisibility(8);
                } else {
                    aVar.f19807a.setVisibility(0);
                }
                if (i2 == CaseHistoryPresenter.this.mData.size() - 1) {
                    aVar.f19808b.setVisibility(8);
                } else {
                    aVar.f19808b.setVisibility(0);
                }
                ReplyBean replyBean = (ReplyBean) CaseHistoryPresenter.this.mData.get(i2);
                if (replyBean != null) {
                    aVar.f19809c.setText(replyBean.getContent());
                    aVar.f19810d.setText(replyBean.getReplyTime());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CaseHistoryPresenter.this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f19805a).inflate(R.layout.item_report_records_reply, viewGroup, false));
        }
    }

    class a extends MiddleSubscriber<APIresult<CaseDetailBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CaseDetailBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CaseDetailBean> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseHistoryCallView) CaseHistoryPresenter.this.mvpView).onSuccessDetail(aPIresult.getData());
            }
        }
    }

    class b extends com.google.gson.d0.a<ArrayList<StopPaymentBean>> {
        b() {
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseHistoryCallView) CaseHistoryPresenter.this.mvpView).onSuccessCommit();
            }
        }
    }

    class d extends MiddleSubscriber<APIresult> {
        d() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseHistoryCallView) CaseHistoryPresenter.this.mvpView).onSuccessBack();
            }
        }
    }

    public CaseHistoryPresenter(Activity activity, CaseHistoryCallView caseHistoryCallView) {
        super(activity, caseHistoryCallView);
        this.mData = new ArrayList();
    }

    public void getDetail(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.S0);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getDetail(strA, map, new a());
    }

    public void initRecycler(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void returnCase(String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", str);
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.U0), map, new d());
    }

    public void setListData(List<ReplyBean> list) {
        if (list != null) {
            this.mData = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void submitCase(String str, ArrayList<AccountListBean> arrayList) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", str);
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        if (arrayList != null && arrayList.size() > 0) {
            com.google.gson.e eVar = new com.google.gson.e();
            map.put("stopPayments", (ArrayList) eVar.a(eVar.a(arrayList), new b().getType()));
        }
        getOperation(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.T0), map, new c());
    }
}
