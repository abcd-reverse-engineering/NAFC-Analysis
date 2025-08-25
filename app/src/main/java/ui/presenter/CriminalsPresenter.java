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
import bean.CallCriminalBean;
import bean.CriminalBean;
import bean.SocialCriminalBean;
import bean.UploadFileBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalsView;
import ui.model.ModelPresent;
import ui.presenter.CriminalsPresenter;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class CriminalsPresenter extends ModelPresent<CriminalsView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<CriminalBean> mCriminalBeans;
    private g.a.u0.c mDisposable;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f19865a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public View f19867a;

            /* renamed from: b, reason: collision with root package name */
            public View f19868b;

            /* renamed from: c, reason: collision with root package name */
            public View f19869c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f19870d;

            /* renamed from: e, reason: collision with root package name */
            public TextView f19871e;

            /* renamed from: f, reason: collision with root package name */
            public TextView f19872f;

            /* renamed from: g, reason: collision with root package name */
            public TextView f19873g;

            /* renamed from: h, reason: collision with root package name */
            public ImageView f19874h;

            public a(View view) {
                super(view);
                this.f19867a = view.findViewById(R.id.fl_view);
                this.f19868b = view.findViewById(R.id.ll_phone_type);
                this.f19870d = (TextView) view.findViewById(R.id.tv_phone_num);
                this.f19869c = view.findViewById(R.id.ll_society_type);
                this.f19871e = (TextView) view.findViewById(R.id.tv_social_acc);
                this.f19872f = (TextView) view.findViewById(R.id.tv_audio_count);
                this.f19873g = (TextView) view.findViewById(R.id.tv_picture_count);
                this.f19874h = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f19865a = context;
        }

        static /* synthetic */ void a(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            CriminalBean criminalBean;
            if (CriminalsPresenter.this.mCriminalBeans.size() > 0 && (criminalBean = (CriminalBean) CriminalsPresenter.this.mCriminalBeans.get(i2)) != null) {
                List<CallCriminalBean> mobiles = criminalBean.getMobiles();
                if (mobiles == null || mobiles.size() <= 0) {
                    aVar.f19870d.setText("0个");
                } else {
                    aVar.f19870d.setText(mobiles.size() + "个");
                }
                List<SocialCriminalBean> socialAccounts = criminalBean.getSocialAccounts();
                if (socialAccounts == null || socialAccounts.size() <= 0) {
                    aVar.f19871e.setText("0个");
                } else {
                    aVar.f19871e.setText(socialAccounts.size() + "个");
                }
                List<UploadFileBean> audios = criminalBean.getAudios();
                if (audios == null || audios.size() <= 0) {
                    aVar.f19872f.setText("0个");
                } else {
                    aVar.f19872f.setText(audios.size() + "个");
                }
                List<UploadFileBean> printscreens = criminalBean.getPrintscreens();
                if (printscreens == null || printscreens.size() <= 0) {
                    aVar.f19873g.setText("0张");
                } else {
                    aVar.f19873g.setText(printscreens.size() + "张");
                }
            }
            aVar.f19867a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CriminalsPresenter.HolderAdapte.a(view);
                }
            });
            aVar.f19874h.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20204a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CriminalsPresenter.this.mCriminalBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f19865a).inflate(R.layout.item_crimina_list, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            ((CriminalsView) CriminalsPresenter.this.mvpView).onItemDelet(i2);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<CriminalBean>>> {

        /* renamed from: ui.presenter.CriminalsPresenter$a$a, reason: collision with other inner class name */
        class C0298a extends com.google.gson.d0.a<List<CriminalBean>> {
            C0298a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0298a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CriminalBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((CriminalsView) CriminalsPresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalsView) CriminalsPresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
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
                ((CriminalsView) CriminalsPresenter.this.mvpView).onSuccessHandle(4, null);
            }
        }
    }

    public CriminalsPresenter(Activity activity, String str, CriminalsView criminalsView) {
        super(activity, criminalsView);
        this.mCriminalBeans = new ArrayList();
        this.caseInfoId = str;
    }

    public void deleteReportCriminal(String str) {
        b1.a(this.mActivity, "请稍后...");
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.s1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        deleteReportCriminal(strA, map, new b());
    }

    public void getCriminalList(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.o1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getCriminalList(strA, map, new a());
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<CriminalBean> list) {
        if (list != null) {
            this.mCriminalBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
