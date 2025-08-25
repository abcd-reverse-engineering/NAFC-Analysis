package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReplyBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ReportRecordsReplyCallview;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class ReportRecordsReplyPresenter extends ModelPresent<ReportRecordsReplyCallview> {
    private HolderAdapte mAdapter;
    private List<ReplyBean> mData;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f20091a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public View f20093a;

            /* renamed from: b, reason: collision with root package name */
            public View f20094b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f20095c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f20096d;

            public a(View view) {
                super(view);
                this.f20093a = view.findViewById(R.id.v_top);
                this.f20094b = view.findViewById(R.id.v_bottom);
                this.f20095c = (TextView) view.findViewById(R.id.tv_content);
                this.f20096d = (TextView) view.findViewById(R.id.tv_time);
            }
        }

        public HolderAdapte(Context context) {
            this.f20091a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, int i2) {
            if (ReportRecordsReplyPresenter.this.mData.size() > 0) {
                if (i2 == 0) {
                    aVar.f20093a.setVisibility(8);
                } else {
                    aVar.f20093a.setVisibility(0);
                }
                if (i2 == ReportRecordsReplyPresenter.this.mData.size() - 1) {
                    aVar.f20094b.setVisibility(8);
                } else {
                    aVar.f20094b.setVisibility(0);
                }
                ReplyBean replyBean = (ReplyBean) ReportRecordsReplyPresenter.this.mData.get(i2);
                if (replyBean != null) {
                    aVar.f20095c.setText(replyBean.getContent());
                    aVar.f20096d.setText(replyBean.getReplyTime());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportRecordsReplyPresenter.this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f20091a).inflate(R.layout.item_report_records_reply, viewGroup, false));
        }
    }

    class a extends MiddleSubscriber<APIresult<List<ReplyBean>>> {

        /* renamed from: ui.presenter.ReportRecordsReplyPresenter$a$a, reason: collision with other inner class name */
        class C0309a extends com.google.gson.d0.a<List<ReplyBean>> {
            C0309a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0309a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ReportRecordsReplyCallview) ReportRecordsReplyPresenter.this.mvpView).onfailRequest();
            w1.a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<ReplyBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((ReportRecordsReplyCallview) ReportRecordsReplyPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public ReportRecordsReplyPresenter(Activity activity, ReportRecordsReplyCallview reportRecordsReplyCallview) {
        super(activity, reportRecordsReplyCallview);
        this.mData = new ArrayList();
    }

    public void getReply(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getReply(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.f2), map, new a());
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<ReplyBean> list) {
        if (list != null) {
            this.mData = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
