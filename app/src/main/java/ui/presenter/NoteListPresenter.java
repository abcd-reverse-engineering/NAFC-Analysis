package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.NoteListBean;
import com.hicorenational.antifraud.R;
import com.hihonor.honorid.core.data.UserLoginInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.NoteDetailActivity;
import ui.callview.NoteListView;
import ui.model.ModelPresent;
import util.b1;
import util.k1;
import util.w1;

/* loaded from: classes2.dex */
public class NoteListPresenter extends ModelPresent<NoteListView> {
    private List<NoteListBean> NoteListBeans;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f19983a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f19985a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f19986b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f19987c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f19988d;

            public a(View view) {
                super(view);
                this.f19986b = (TextView) view.findViewById(R.id.tv_note_them);
                this.f19987c = (TextView) view.findViewById(R.id.tv_time);
                this.f19985a = (TextView) view.findViewById(R.id.tv_num_red);
                this.f19988d = (TextView) view.findViewById(R.id.desc);
            }
        }

        public HolderAdapte(Context context) {
            this.f19983a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, int i2) {
            if (NoteListPresenter.this.NoteListBeans.size() > 0) {
                final NoteListBean noteListBean = (NoteListBean) NoteListPresenter.this.NoteListBeans.get(i2);
                if (noteListBean.isRead()) {
                    aVar.f19985a.setVisibility(4);
                } else {
                    aVar.f19985a.setVisibility(0);
                }
                aVar.f19986b.setText(NoteListPresenter.this.subTitle(noteListBean.getTitle()));
                aVar.f19987c.setText(noteListBean.getVaildStartTime());
                aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f20229a.a(noteListBean, view);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return NoteListPresenter.this.NoteListBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f19983a).inflate(R.layout.item_note_list, viewGroup, false));
        }

        public /* synthetic */ void a(NoteListBean noteListBean, View view) {
            Intent intent = new Intent(NoteListPresenter.this.mActivity, (Class<?>) NoteDetailActivity.class);
            intent.putExtra(k1.f20845c, noteListBean);
            NoteListPresenter.this.mActivity.startActivity(intent);
            noteListBean.setRead(true);
            notifyDataSetChanged();
            NoteListPresenter.this.getNoteItem(noteListBean.getId());
        }
    }

    class a extends MiddleSubscriber<APIresult<List<NoteListBean>>> {

        /* renamed from: ui.presenter.NoteListPresenter$a$a, reason: collision with other inner class name */
        class C0304a extends com.google.gson.d0.a<List<NoteListBean>> {
            C0304a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0304a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            ((NoteListView) NoteListPresenter.this.mvpView).onSuccessRequest(new ArrayList());
            w1.a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<NoteListBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((NoteListView) NoteListPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<NoteListBean>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return NoteListBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<NoteListBean> aPIresult) {
            if (aPIresult.getCode() == 0) {
                aPIresult.getData();
            }
        }
    }

    public NoteListPresenter(Activity activity, NoteListView noteListView) {
        super(activity, noteListView);
        this.NoteListBeans = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String subTitle(String str) {
        if (str.length() <= 18) {
            return str;
        }
        return ((Object) str.subSequence(0, 18)) + "...";
    }

    public void getNoteItem(String str) {
        b1.a(this.mActivity, "请稍等...");
        String str2 = d.a.f13517c + e.b.u;
        HashMap<String, String> map = new HashMap<>();
        map.put("noticeID", str);
        map.put(UserLoginInfo.f6190i, AccountManager.getAccountId());
        getNoteListItem(str2, map, new b());
    }

    public void getNoteList() {
        b1.a(this.mActivity, "请稍等...");
        getNoteList(d.a.f13517c + e.b.t, new a());
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<NoteListBean> list) {
        this.NoteListBeans = list;
        this.mAdapter.notifyDataSetChanged();
    }
}
