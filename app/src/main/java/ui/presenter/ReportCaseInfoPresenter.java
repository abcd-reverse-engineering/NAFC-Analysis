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
import bean.SignComitBean;
import bean.SurveyPeopleBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.VictimActivity;
import ui.activity.VictimDetialActivity;
import ui.callview.VictimPeopleView;
import ui.model.ModelPresent;
import util.b1;
import util.k1;
import util.w1;

/* loaded from: classes2.dex */
public class ReportCaseInfoPresenter extends ModelPresent<VictimPeopleView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<SurveyPeopleBean> surveyPeopleBeans;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f20058a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            View f20060a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f20061b;

            /* renamed from: c, reason: collision with root package name */
            TextView f20062c;

            /* renamed from: d, reason: collision with root package name */
            TextView f20063d;

            /* renamed from: e, reason: collision with root package name */
            TextView f20064e;

            /* renamed from: f, reason: collision with root package name */
            TextView f20065f;

            /* renamed from: g, reason: collision with root package name */
            ImageView f20066g;

            public a(View view) {
                super(view);
                this.f20060a = view.findViewById(R.id.fl_view);
                this.f20061b = (ImageView) view.findViewById(R.id.iv_head_sex);
                this.f20062c = (TextView) view.findViewById(R.id.tv_peop_name);
                this.f20063d = (TextView) view.findViewById(R.id.tv_peop_phone);
                this.f20064e = (TextView) view.findViewById(R.id.tv_card_type);
                this.f20065f = (TextView) view.findViewById(R.id.tv_peop_id);
                this.f20066g = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f20058a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            SurveyPeopleBean surveyPeopleBean;
            if (ReportCaseInfoPresenter.this.surveyPeopleBeans.size() > 0 && (surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(i2)) != null) {
                aVar.f20062c.setText(surveyPeopleBean.getPeopleName());
                aVar.f20065f.setText(surveyPeopleBean.getDocumentNumber());
                aVar.f20064e.setText(surveyPeopleBean.getDocumentName());
                aVar.f20063d.setText(surveyPeopleBean.getPeoplePhone());
                if (ReportCaseInfoPresenter.this.caseInfoId == null) {
                    aVar.f20066g.setVisibility(8);
                }
            }
            aVar.f20060a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20241a.a(i2, view);
                }
            });
            aVar.f20066g.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20243a.b(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            b1.b(ReportCaseInfoPresenter.this.mActivity, "删除当前事主信息？", "", "确定", "取消", new f0(this, i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportCaseInfoPresenter.this.surveyPeopleBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f20058a).inflate(R.layout.item_victim_people, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            SurveyPeopleBean surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(i2);
            if (surveyPeopleBean != null) {
                if (ReportCaseInfoPresenter.this.caseInfoId == null) {
                    Intent intent = new Intent(ReportCaseInfoPresenter.this.mActivity, (Class<?>) VictimDetialActivity.class);
                    intent.putExtra(k1.f20845c, surveyPeopleBean);
                    ReportCaseInfoPresenter.this.mActivity.startActivity(intent);
                } else {
                    Intent intent2 = new Intent(ReportCaseInfoPresenter.this.mActivity, (Class<?>) VictimActivity.class);
                    intent2.putExtra(k1.C0, ReportCaseInfoPresenter.this.caseInfoId);
                    intent2.putExtra(k1.f20845c, surveyPeopleBean);
                    ReportCaseInfoPresenter.this.mActivity.startActivity(intent2);
                }
            }
        }
    }

    class a extends MiddleSubscriber<APIresult<List<SurveyPeopleBean>>> {

        /* renamed from: ui.presenter.ReportCaseInfoPresenter$a$a, reason: collision with other inner class name */
        class C0308a extends com.google.gson.d0.a<List<SurveyPeopleBean>> {
            C0308a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0308a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<SurveyPeopleBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessHandle(new ArrayList());
            } else {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessHandle(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<SignComitBean>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return SignComitBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<SignComitBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessHandle(new ArrayList());
            } else {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessCaseNum(aPIresult.getData());
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessDelet();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    public ReportCaseInfoPresenter(Activity activity, String str, VictimPeopleView victimPeopleView) {
        super(activity, victimPeopleView);
        this.surveyPeopleBeans = new ArrayList();
        this.caseInfoId = str;
    }

    public void deletePeople(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.e1);
        HashMap<String, String> map = new HashMap<>();
        map.put("victimInfoID", str);
        deletePeople(strA, map, new c());
    }

    public void getSubmitCaseInfo(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.b2);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getComitReportNum(strA, map, new b());
    }

    public void getVictimList(String str) {
        b1.a("请稍后...", true, this.mActivity);
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.d1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getVictimList(strA, map, new a());
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<SurveyPeopleBean> list) {
        this.surveyPeopleBeans = list;
        this.mAdapter.notifyDataSetChanged();
    }
}
