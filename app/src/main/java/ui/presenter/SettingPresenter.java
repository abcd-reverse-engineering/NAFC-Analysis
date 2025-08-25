package ui.presenter;

import adapter.CheckTimeAdapter;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CheckTimeBean;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import manager.BaseDialog;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.SettingView;
import ui.model.ModelPresent;
import util.b1;
import util.u1;

/* loaded from: classes2.dex */
public class SettingPresenter extends ModelPresent<SettingView> {
    private BaseDialog dlg;
    private CheckTimeAdapter mAdapter;
    public String mDefaultStr;
    private RecyclerView mRecyclerview;

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((SettingView) SettingPresenter.this.mvpView).onSuccessLoginOut(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            ((SettingView) SettingPresenter.this.mvpView).onSuccessLoginOut(aPIresult);
        }
    }

    public SettingPresenter(Activity activity, SettingView settingView) {
        super(activity, settingView);
        this.mDefaultStr = "每天9点";
    }

    private void initRecycleView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CheckTimeBean(this.mDefaultStr, 1));
        arrayList.add(new CheckTimeBean("每周一9点", 2));
        arrayList.add(new CheckTimeBean("每月初9点", 3));
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new CheckTimeAdapter(R.layout.item_check_time, arrayList);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemClickListener(new CheckTimeAdapter.b() { // from class: ui.presenter.x
            @Override // adapter.CheckTimeAdapter.b
            public final void onItemClickListener(int i2, List list) {
                this.f20252a.a(i2, list);
            }
        });
        CheckTimeBean checkTimeBean = (CheckTimeBean) u1.a(u1.I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            for (CheckTimeBean checkTimeBean2 : this.mAdapter.c()) {
                if (TextUtils.equals(checkTimeBean.getCode() + "", checkTimeBean2.getCode() + "")) {
                    checkTimeBean2.setSelect(true);
                } else {
                    checkTimeBean2.setSelect(false);
                }
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void a(View view) {
        ((SettingView) this.mvpView).cancleTimeDlg();
        this.dlg.dismiss();
    }

    public /* synthetic */ void b(View view) {
        ((SettingView) this.mvpView).ensureTimeDlg();
        this.dlg.dismiss();
    }

    public void closeTimeDlg() {
        BaseDialog baseDialog = this.dlg;
        if (baseDialog == null || !baseDialog.isShowing()) {
            return;
        }
        this.dlg.dismiss();
    }

    public void requestLoginOut() {
        b1.a("退出中...", true, this.mActivity);
        requestLoginOut(d.a.a("", 1, e.b.H), new a());
    }

    public void showSelectTimeDlg() {
        BaseDialog baseDialog = this.dlg;
        if (baseDialog != null) {
            baseDialog.show();
            return;
        }
        this.dlg = new BaseDialog(this.mActivity, R.style.base_dialog_style);
        this.dlg.setContentView(R.layout.layout_check_time_setting);
        this.dlg.setGravityLayout(0);
        this.dlg.setWidthDialog(-2.0d);
        this.dlg.setHeightDialogdp(-2.0f);
        this.dlg.setCancelable(false);
        this.dlg.setCanceledOnTouchOutside(false);
        this.dlg.initOnCreate();
        this.dlg.show();
        this.mRecyclerview = (RecyclerView) this.dlg.findViewById(R.id.recyclerview);
        TextView textView = (TextView) this.dlg.findViewById(R.id.cancle);
        TextView textView2 = (TextView) this.dlg.findViewById(R.id.confirm);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20251a.a(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20253a.b(view);
            }
        });
        initRecycleView();
    }

    public /* synthetic */ void a(int i2, List list) {
        ((SettingView) this.mvpView).onItemClick((CheckTimeBean) list.get(i2));
    }
}
