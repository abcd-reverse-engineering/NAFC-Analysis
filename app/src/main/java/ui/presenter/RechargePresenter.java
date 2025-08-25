package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.RechargeBean;
import bean.RechargePlatBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.RechargeView;
import ui.model.ModelPresent;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class RechargePresenter extends ModelPresent<RechargeView> {
    private List<RechargeBean> arrayListBean;
    private boolean isOnlySee;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f20000a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f20002a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f20003b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f20004c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f20005d;

            /* renamed from: e, reason: collision with root package name */
            public ImageView f20006e;

            /* renamed from: f, reason: collision with root package name */
            public ImageView f20007f;

            /* renamed from: g, reason: collision with root package name */
            public View f20008g;

            /* renamed from: h, reason: collision with root package name */
            public View f20009h;

            public a(View view) {
                super(view);
                this.f20002a = (TextView) view.findViewById(R.id.tv_recharge_plat);
                this.f20003b = (TextView) view.findViewById(R.id.tv_recharge_phone);
                this.f20004c = (TextView) view.findViewById(R.id.tv_recharge_sum);
                this.f20005d = (TextView) view.findViewById(R.id.tv_recharge_time);
                this.f20006e = (ImageView) view.findViewById(R.id.iv_edit);
                this.f20007f = (ImageView) view.findViewById(R.id.iv_clear);
                this.f20009h = view.findViewById(R.id.iv_arrow);
                this.f20008g = view.findViewById(R.id.v_line);
                if (RechargePresenter.this.isOnlySee) {
                    this.f20006e.setVisibility(8);
                    this.f20007f.setVisibility(8);
                    this.f20008g.setVisibility(8);
                    this.f20009h.setVisibility(0);
                }
            }
        }

        public HolderAdapte(Context context) {
            this.f20000a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            RechargeBean rechargeBean = (RechargeBean) RechargePresenter.this.arrayListBean.get(i2);
            if (rechargeBean != null) {
                aVar.f20002a.setText(rechargeBean.getPlatformText());
                aVar.f20003b.setText(rechargeBean.getSuspectMobile());
                aVar.f20004c.setText(rechargeBean.getAmount() + "元");
                aVar.f20005d.setText(rechargeBean.getChargeTime());
                rechargeBean.getChargeTime();
            }
            aVar.f20006e.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20235a.a(i2, view);
                }
            });
            aVar.f20007f.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20233a.b(i2, view);
                }
            });
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20231a.c(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemDelet(i2);
        }

        public /* synthetic */ void c(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemEdit(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RechargePresenter.this.arrayListBean.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f20000a).inflate(R.layout.recyclerview_recharge_criminal, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemEdit(i2);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<RechargeBean>>> {

        /* renamed from: ui.presenter.RechargePresenter$a$a, reason: collision with other inner class name */
        class C0306a extends com.google.gson.d0.a<List<RechargeBean>> {
            C0306a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0306a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<RechargeBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RechargeView) RechargePresenter.this.mvpView).onSuccessList(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f20013a;

        b(int i2) {
            this.f20013a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                RechargePresenter.this.removeListData(this.f20013a);
                w1.a("删除成功");
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<String>> {

        class a extends com.google.gson.d0.a<String> {
            a() {
            }
        }

        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RechargeView) RechargePresenter.this.mvpView).onSuccessSave();
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<List<RechargePlatBean>>> {

        class a extends com.google.gson.d0.a<List<RechargePlatBean>> {
            a() {
            }
        }

        d() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<RechargePlatBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RechargeView) RechargePresenter.this.mvpView).onSuccessPlatList(aPIresult.getData());
            }
        }
    }

    public RechargePresenter(Activity activity, RechargeView rechargeView) {
        super(activity, rechargeView);
        this.arrayListBean = new ArrayList();
        this.isOnlySee = false;
    }

    public void deleteRecharge(String str, String str2, int i2) {
        b1.a(this.mActivity, "请稍等...");
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.C1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        map.put("chargeTelInfoID", str2);
        removeRechargetel(strA, map, new b(i2));
    }

    public void getPlatList() {
        b1.a(this.mActivity, "请稍等...");
        getReChargePlatList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.D1), new HashMap<>(), new d());
    }

    public void getReChargeList(String str) {
        b1.a(this.mActivity, "请稍等...");
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.A1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getReChargeList(strA, map, new a());
    }

    public void initRecycle(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void isOnlySee(boolean z) {
        this.isOnlySee = z;
    }

    public void removeListData(int i2) {
        this.arrayListBean.remove(i2);
        this.mAdapter.notifyDataSetChanged();
    }

    public void saveRechargeTel(RechargeBean rechargeBean) {
        b1.a(this.mActivity, "请稍等...");
        saveRechargeTel(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.B1), JNIHandStamp.getInstance().pamramToMap(rechargeBean), new c());
    }

    public void setListData(List<RechargeBean> list) {
        this.arrayListBean = list;
        this.mAdapter.notifyDataSetChanged();
    }

    public void updateListData(int i2, RechargeBean rechargeBean) {
        this.arrayListBean.set(i2, rechargeBean);
        this.mAdapter.notifyItemChanged(i2);
    }
}
