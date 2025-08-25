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
import bean.CallCriminalBean;
import bean.CriminalBean;
import bean.SocialCriminalBean;
import bean.UploadFileBean;
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
import ui.activity.SignCriminalDetialActivity;
import ui.callview.SignCommitCriminalView;
import ui.model.ModelPresent;
import util.k1;
import util.w1;

/* loaded from: classes2.dex */
public class SignCommitCriminalPresenter extends ModelPresent<SignCommitCriminalView> {
    private String caseInfoId;
    private List<CriminalBean> criminalBeans;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f20123a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public View f20125a;

            /* renamed from: b, reason: collision with root package name */
            public View f20126b;

            /* renamed from: c, reason: collision with root package name */
            public View f20127c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f20128d;

            /* renamed from: e, reason: collision with root package name */
            public TextView f20129e;

            /* renamed from: f, reason: collision with root package name */
            public TextView f20130f;

            /* renamed from: g, reason: collision with root package name */
            public TextView f20131g;

            /* renamed from: h, reason: collision with root package name */
            public ImageView f20132h;

            public a(View view) {
                super(view);
                this.f20125a = view.findViewById(R.id.fl_view);
                this.f20126b = view.findViewById(R.id.ll_phone_type);
                this.f20128d = (TextView) view.findViewById(R.id.tv_phone_num);
                this.f20127c = view.findViewById(R.id.ll_society_type);
                this.f20129e = (TextView) view.findViewById(R.id.tv_social_acc);
                this.f20130f = (TextView) view.findViewById(R.id.tv_audio_count);
                this.f20131g = (TextView) view.findViewById(R.id.tv_picture_count);
                this.f20132h = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f20123a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            CriminalBean criminalBean;
            if (SignCommitCriminalPresenter.this.criminalBeans.size() > 0 && (criminalBean = (CriminalBean) SignCommitCriminalPresenter.this.criminalBeans.get(i2)) != null) {
                List<CallCriminalBean> mobiles = criminalBean.getMobiles();
                if (mobiles == null || mobiles.size() <= 0) {
                    aVar.f20128d.setText("0个");
                } else {
                    aVar.f20128d.setText(mobiles.size() + "个");
                }
                List<SocialCriminalBean> socialAccounts = criminalBean.getSocialAccounts();
                if (socialAccounts == null || socialAccounts.size() <= 0) {
                    aVar.f20129e.setText("0个");
                } else {
                    aVar.f20129e.setText(socialAccounts.size() + "个");
                }
                List<UploadFileBean> audios = criminalBean.getAudios();
                if (audios == null || audios.size() <= 0) {
                    aVar.f20130f.setText("0个");
                } else {
                    aVar.f20130f.setText(audios.size() + "个");
                }
                List<UploadFileBean> printscreens = criminalBean.getPrintscreens();
                if (printscreens == null || printscreens.size() <= 0) {
                    aVar.f20131g.setText("0张");
                } else {
                    aVar.f20131g.setText(printscreens.size() + "张");
                }
            }
            aVar.f20125a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20206a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SignCommitCriminalPresenter.this.criminalBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f20123a).inflate(R.layout.item_crimina_list_preview, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(SignCommitCriminalPresenter.this.mActivity, (Class<?>) SignCriminalDetialActivity.class);
            intent.putExtra(k1.C0, SignCommitCriminalPresenter.this.caseInfoId);
            intent.putExtra(k1.f20845c, (Serializable) SignCommitCriminalPresenter.this.criminalBeans.get(i2));
            SignCommitCriminalPresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<CriminalBean>>> {

        /* renamed from: ui.presenter.SignCommitCriminalPresenter$a$a, reason: collision with other inner class name */
        class C0312a extends com.google.gson.d0.a<List<CriminalBean>> {
            C0312a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0312a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CriminalBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((SignCommitCriminalView) SignCommitCriminalPresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
            } else {
                ((SignCommitCriminalView) SignCommitCriminalPresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    public SignCommitCriminalPresenter(Activity activity, String str, SignCommitCriminalView signCommitCriminalView) {
        super(activity, signCommitCriminalView);
        this.criminalBeans = new ArrayList();
        this.caseInfoId = str;
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
            this.criminalBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
