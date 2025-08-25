package ui.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import event.AppEventBean;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;

/* loaded from: classes2.dex */
public class AppSelectedActivity extends BaseActivity {

    /* renamed from: h, reason: collision with root package name */
    public static final String f17651h = "select_type";

    /* renamed from: i, reason: collision with root package name */
    public static final String f17652i = "extra_select_limite";

    /* renamed from: j, reason: collision with root package name */
    public static final String f17653j = "extra_select_now";

    /* renamed from: k, reason: collision with root package name */
    public static final String f17654k = "extra_select_can";

    /* renamed from: l, reason: collision with root package name */
    public static final int f17655l = 1;

    /* renamed from: m, reason: collision with root package name */
    public static final int f17656m = 2;
    public static final int n = 9;
    public static final int o = 1;

    /* renamed from: c, reason: collision with root package name */
    private List<AppInfoBean> f17659c;

    /* renamed from: d, reason: collision with root package name */
    private adapter.f f17660d;

    @BindView(R.id.btn_report)
    Button mBtnReport;

    @BindView(R.id.recyclerview_app)
    ExpandableListView mExpandableList;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_right)
    ImageView mIvRight;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: a, reason: collision with root package name */
    private int f17657a = 9;

    /* renamed from: b, reason: collision with root package name */
    private int f17658b = 0;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f17661e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<List<AppInfoBean>> f17662f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<AppInfoBean> f17663g = new ArrayList<>();

    class a implements ExpandableListView.OnChildClickListener {
        a() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
            AppInfoBean appInfoBean = (AppInfoBean) ((List) AppSelectedActivity.this.f17662f.get(i2)).get(i3);
            AppSelectedActivity appSelectedActivity = AppSelectedActivity.this;
            appSelectedActivity.a(appInfoBean, appSelectedActivity.f17660d);
            return true;
        }
    }

    static /* synthetic */ boolean a(ExpandableListView expandableListView, View view, int i2, long j2) {
        return true;
    }

    private void c() {
        showProgressDialog();
        final util.r1 r1Var = new util.r1(this);
        new Thread(new Runnable() { // from class: ui.activity.e
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                this.f19417a.a(r1Var);
            }
        }).start();
    }

    private void initView() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("选择APP应用");
        this.f17658b = getIntent().getIntExtra(f17653j, 0);
        int intExtra = getIntent().getIntExtra(util.k1.f20846d, 0);
        int intExtra2 = getIntent().getIntExtra("extra_select_limite", 0);
        if (intExtra == 2) {
            this.mIvRight.setImageResource(R.drawable.iv_search);
        } else {
            this.mIvRight.setVisibility(8);
        }
        if (intExtra2 != 0) {
            this.f17657a = intExtra2;
        }
        this.f17657a -= this.f17658b;
        this.f17659c = new ArrayList();
        c();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 35) {
            return;
        }
        finish();
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.btn_report})
    public void onViewClicked(View view) {
        long jCurrentTimeMillis;
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_report) {
            if (id == R.id.iv_back) {
                finish();
                return;
            } else {
                if (id != R.id.iv_right) {
                    return;
                }
                Intent intent = new Intent(this.mActivity, (Class<?>) SearchAppActivity.class);
                SearchAppActivity.f18867e = this.f17663g;
                startActivity(intent);
                return;
            }
        }
        if (this.f17659c.size() != 0) {
            for (int i2 = 0; i2 < this.f17659c.size(); i2++) {
                AppInfoBean appInfoBean = this.f17659c.get(i2);
                if (TextUtils.isEmpty(appInfoBean.getActivityName())) {
                    try {
                        jCurrentTimeMillis = new File(appInfoBean.getPkgPath()).lastModified();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                    appInfoBean.setLastTime(jCurrentTimeMillis);
                }
                org.greenrobot.eventbus.c.f().d(new util.c2.a(30, appInfoBean));
            }
            org.greenrobot.eventbus.c.f().d(new AppEventBean(this.f17659c));
        }
        finish();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_app_selected;
    }

    private void b() {
        this.f17660d = new adapter.f(this.mActivity, this.f17661e, this.f17662f);
        this.mExpandableList.setAdapter(this.f17660d);
        for (int i2 = 0; i2 < this.f17661e.size(); i2++) {
            this.mExpandableList.expandGroup(i2);
        }
        this.mExpandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: ui.activity.c
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j2) {
                return AppSelectedActivity.a(expandableListView, view, i3, j2);
            }
        });
        this.mExpandableList.setOnChildClickListener(new a());
    }

    public /* synthetic */ void a(util.r1 r1Var) throws PackageManager.NameNotFoundException {
        final List<AppInfoBean> listA = util.r1.a(new String[]{util.r1.f20958d});
        final List<AppInfoBean> listA2 = r1Var.a();
        runOnUiThread(new Runnable() { // from class: ui.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f19411a.a(listA, listA2);
            }
        });
    }

    public /* synthetic */ void a(List list, List list2) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.f17661e.add("未安装安装包");
        this.f17661e.add("已安装应用");
        this.f17662f.add(list);
        this.f17662f.add(list2);
        this.f17663g.addAll(list);
        this.f17663g.addAll(list2);
        b();
        hideProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppInfoBean appInfoBean, adapter.f fVar) {
        if (appInfoBean.getFileSize() > 209715200) {
            util.w1.a("200M以上文件不可选择");
            return;
        }
        if (!appInfoBean.isSelect()) {
            if (this.f17657a == 1) {
                a();
            } else if (this.f17659c.size() == this.f17657a) {
                util.w1.a("最多选择" + this.f17657a + "个");
                return;
            }
            this.f17659c.add(appInfoBean);
            appInfoBean.setSelect(true);
        } else {
            this.f17659c.remove(appInfoBean);
            appInfoBean.setSelect(false);
        }
        fVar.notifyDataSetChanged();
    }

    private void a() {
        for (int i2 = 0; i2 < this.f17662f.size(); i2++) {
            List<AppInfoBean> list = this.f17662f.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).setSelect(false);
            }
        }
        this.f17660d.a(this.f17661e, this.f17662f);
        this.f17659c.clear();
    }
}
