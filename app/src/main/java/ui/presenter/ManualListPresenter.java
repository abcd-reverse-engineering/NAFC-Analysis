package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ManualListBean;
import bean.PageBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.ManualAlreadyDetailActivity;
import ui.callview.ManualListCallView;
import ui.model.ModelPresent;
import util.k1;

/* loaded from: classes2.dex */
public class ManualListPresenter extends ModelPresent<ManualListCallView> {
    private HolderAdapte mAdapter;
    private List<ManualListBean> mList;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f19964a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f19966a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f19967b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f19968c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f19969d;

            /* renamed from: e, reason: collision with root package name */
            public TextView f19970e;

            /* renamed from: f, reason: collision with root package name */
            public ImageView f19971f;

            public a(View view) {
                super(view);
                this.f19966a = (TextView) view.findViewById(R.id.tv_manual_title);
                this.f19967b = (TextView) view.findViewById(R.id.tv_name);
                this.f19968c = (TextView) view.findViewById(R.id.tv_id_type);
                this.f19969d = (TextView) view.findViewById(R.id.tv_id);
                this.f19970e = (TextView) view.findViewById(R.id.tv_time);
                this.f19971f = (ImageView) view.findViewById(R.id.iv_tag);
            }
        }

        public HolderAdapte(Context context) {
            this.f19964a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, int i2) {
            if (ManualListPresenter.this.mList.size() > 0) {
                final ManualListBean manualListBean = (ManualListBean) ManualListPresenter.this.mList.get(i2);
                if (manualListBean != null) {
                    aVar.f19966a.setText(manualListBean.getTitle());
                    aVar.f19967b.setText(manualListBean.getUasename());
                    aVar.f19968c.setText("证件号 (" + manualListBean.getDocumentType() + ")  ");
                    aVar.f19969d.setText(manualListBean.getIdnumber());
                    aVar.f19970e.setText(manualListBean.getApplytime());
                    if (manualListBean.getAuditstatus() == Integer.parseInt("1")) {
                        aVar.f19971f.setImageResource(R.mipmap.ic_manual_aduopt);
                    } else if (manualListBean.getAuditstatus() == Integer.parseInt("3")) {
                        aVar.f19971f.setImageResource(R.mipmap.ic_manual_reject);
                    }
                }
                aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f20224a.a(manualListBean, view);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ManualListPresenter.this.mList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f19964a).inflate(R.layout.item_manual_list, viewGroup, false));
        }

        public /* synthetic */ void a(ManualListBean manualListBean, View view) {
            if (manualListBean.getAuditstatus() == Integer.parseInt("1") || manualListBean.getAuditstatus() == Integer.parseInt("3")) {
                return;
            }
            Intent intent = new Intent(ManualListPresenter.this.mActivity, (Class<?>) ManualAlreadyDetailActivity.class);
            intent.putExtra(k1.f20845c, manualListBean.getId());
            ManualListPresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<PageBean<ManualListBean>>> {

        /* renamed from: ui.presenter.ManualListPresenter$a$a, reason: collision with other inner class name */
        class C0303a extends com.google.gson.d0.a<PageBean<ManualListBean>> {
            C0303a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0303a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ManualListCallView) ManualListPresenter.this.mvpView).onSuccess(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<PageBean<ManualListBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ManualListCallView) ManualListPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public ManualListPresenter(Activity activity, ManualListCallView manualListCallView) {
        super(activity, manualListCallView);
        this.mList = new ArrayList();
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void manualListData(int i2, int i3) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", Integer.valueOf(i2));
        map.put("rows", Integer.valueOf(i3));
        map.put("sort", "createtime");
        map.put("order", SocialConstants.PARAM_APP_DESC);
        manualList(d.a.a(ModuelConfig.MODEL_MANUAL, 8, e.b.H0), map, new a());
    }

    public void setListData(List<ManualListBean> list) {
        if (list != null) {
            this.mList = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
