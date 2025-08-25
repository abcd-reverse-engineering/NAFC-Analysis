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
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import bean.OssFileInfo;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.DeliveryView;
import ui.model.OSSModelPresent;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class DeliveryPresenter extends OSSModelPresent<DeliveryView> {
    private List<DeliveryBean> arrayListBean;
    private boolean isOnlySee;
    private HolderAdapte mAdapter;
    List<OssFileInfo> ossFiles;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f19879a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f19881a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f19882b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f19883c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f19884d;

            /* renamed from: e, reason: collision with root package name */
            public TextView f19885e;

            /* renamed from: f, reason: collision with root package name */
            public TextView f19886f;

            /* renamed from: g, reason: collision with root package name */
            public TextView f19887g;

            /* renamed from: h, reason: collision with root package name */
            public ImageView f19888h;

            /* renamed from: i, reason: collision with root package name */
            public ImageView f19889i;

            /* renamed from: j, reason: collision with root package name */
            public View f19890j;

            /* renamed from: k, reason: collision with root package name */
            public View f19891k;

            public a(View view) {
                super(view);
                this.f19881a = (TextView) view.findViewById(R.id.tv_delivery_plat);
                this.f19882b = (TextView) view.findViewById(R.id.tv_delivery_num);
                this.f19886f = (TextView) view.findViewById(R.id.tv_delivery_address);
                this.f19884d = (TextView) view.findViewById(R.id.tv_delivery_sender);
                this.f19883c = (TextView) view.findViewById(R.id.tv_delivery_wp);
                this.f19885e = (TextView) view.findViewById(R.id.tv_delivery_phone);
                this.f19887g = (TextView) view.findViewById(R.id.tv_delivery_time);
                this.f19888h = (ImageView) view.findViewById(R.id.iv_edit);
                this.f19889i = (ImageView) view.findViewById(R.id.iv_clear);
                this.f19890j = view.findViewById(R.id.iv_arrow);
                this.f19891k = view.findViewById(R.id.v_line);
                if (DeliveryPresenter.this.isOnlySee) {
                    this.f19888h.setVisibility(8);
                    this.f19889i.setVisibility(8);
                    this.f19891k.setVisibility(8);
                    this.f19890j.setVisibility(0);
                }
            }
        }

        public HolderAdapte(Context context) {
            this.f19879a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            DeliveryBean deliveryBean = (DeliveryBean) DeliveryPresenter.this.arrayListBean.get(i2);
            if (deliveryBean != null) {
                aVar.f19881a.setText(deliveryBean.getDeliveryPlat());
                aVar.f19882b.setText(deliveryBean.getDeliveryNum());
                aVar.f19883c.setText(deliveryBean.getDeliveryWp());
                aVar.f19884d.setText(deliveryBean.getDeliveryName());
                aVar.f19885e.setText(deliveryBean.getDeliveryPhone());
                aVar.f19886f.setText(deliveryBean.getDeliveryAddress());
                String deliveryTime = deliveryBean.getDeliveryTime();
                if (deliveryTime.length() > 2) {
                    aVar.f19887g.setText(deliveryTime.substring(0, deliveryTime.length() - 3));
                }
            }
            aVar.f19888h.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20214a.a(i2, view);
                }
            });
            aVar.f19889i.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20217a.b(i2, view);
                }
            });
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20211a.c(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemDelet(i2);
        }

        public /* synthetic */ void c(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemEdit(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DeliveryPresenter.this.arrayListBean.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f19879a).inflate(R.layout.recycle_delivery_item, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemEdit(i2);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<DeliveryBean>>> {

        /* renamed from: ui.presenter.DeliveryPresenter$a$a, reason: collision with other inner class name */
        class C0299a extends com.google.gson.d0.a<List<DeliveryBean>> {
            C0299a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0299a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<DeliveryBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onSuccessList(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19895a;

        b(int i2) {
            this.f19895a = i2;
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
                DeliveryPresenter.this.removeListData(this.f19895a);
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<DeliveryBean>> {

        class a extends com.google.gson.d0.a<DeliveryBean> {
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
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onSuccessSaveFail(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<DeliveryBean> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onSuccessSave(aPIresult.getData());
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<List<DeliveryPlatBean>>> {

        class a extends com.google.gson.d0.a<List<DeliveryPlatBean>> {
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
        protected void onNextMiddle(APIresult<List<DeliveryPlatBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onSuccessPlatList(aPIresult.getData());
            }
        }
    }

    public DeliveryPresenter(Activity activity, DeliveryView deliveryView) {
        super(activity, deliveryView);
        this.arrayListBean = new ArrayList();
        this.isOnlySee = false;
    }

    public void getDeliveryList(String str) {
        b1.a(this.mActivity, "请稍等...");
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.I1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getDeliveryList(strA, map, new a());
    }

    public void getPlatList() {
        b1.a(this.mActivity, "请稍等...");
        getDeliveryPlatList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.L1), new HashMap<>(), new d());
    }

    public void initRecycle(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void isOnlySee(boolean z) {
        this.isOnlySee = z;
    }

    public void removeDelivery(String str, String str2, int i2) {
        b1.a(this.mActivity, "请稍等...");
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.K1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        map.put("mailingTelInfoID", str2);
        removeDelivery(strA, map, new b(i2));
    }

    public void removeListData(int i2) {
        this.arrayListBean.remove(i2);
        this.mAdapter.notifyDataSetChanged();
    }

    public void saveDeliveryTelHttp(DeliveryBean deliveryBean) {
        b1.a(this.mActivity, "请稍等...");
        saveDeliveryTel(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.J1), deliveryBean, new c());
    }

    public void setListData(List<DeliveryBean> list) {
        this.arrayListBean = list;
        this.mAdapter.notifyDataSetChanged();
    }

    public void updateListData(int i2, DeliveryBean deliveryBean) {
        this.arrayListBean.set(i2, deliveryBean);
        this.mAdapter.notifyItemChanged(i2);
    }
}
