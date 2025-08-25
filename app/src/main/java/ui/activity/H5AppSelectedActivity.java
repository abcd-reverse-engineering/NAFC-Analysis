package ui.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;

/* loaded from: classes2.dex */
public class H5AppSelectedActivity extends BaseActivity {

    /* renamed from: g, reason: collision with root package name */
    public static final String f18186g = "extra_select_limite";

    /* renamed from: h, reason: collision with root package name */
    public static final int f18187h = 9;

    /* renamed from: i, reason: collision with root package name */
    public static final int f18188i = 1;

    /* renamed from: c, reason: collision with root package name */
    private adapter.f f18191c;

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
    private int f18189a = 9;

    /* renamed from: b, reason: collision with root package name */
    private List<AppInfoBean> f18190b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<String> f18192d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<List<AppInfoBean>> f18193e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<AppInfoBean> f18194f = new ArrayList<>();

    class a implements ExpandableListView.OnChildClickListener {
        a() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
            AppInfoBean appInfoBean = (AppInfoBean) ((List) H5AppSelectedActivity.this.f18193e.get(i2)).get(i3);
            H5AppSelectedActivity h5AppSelectedActivity = H5AppSelectedActivity.this;
            h5AppSelectedActivity.a(appInfoBean, h5AppSelectedActivity.f18191c);
            return true;
        }
    }

    static /* synthetic */ boolean a(ExpandableListView expandableListView, View view, int i2, long j2) {
        return true;
    }

    private void c() {
        showProgressDialog();
        final util.r1 r1Var = new util.r1(this);
        new Thread(new Runnable() { // from class: ui.activity.s
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                this.f19465a.a(r1Var);
            }
        }).start();
    }

    private void initView() {
        this.mTvTitle.setText("选择APP应用");
        int intExtra = getIntent().getIntExtra("extra_select_limite", 0);
        if (intExtra > 0) {
            this.f18189a = intExtra;
        }
        c();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_report) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
        } else {
            Intent intent = getIntent();
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION, (ArrayList) this.f18190b);
            PictureSelector.putIntentResult(this.f18190b);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_app_selected;
    }

    private void b() {
        this.f18191c = new adapter.f(this.mActivity, this.f18192d, this.f18193e);
        this.mExpandableList.setAdapter(this.f18191c);
        for (int i2 = 0; i2 < this.f18192d.size(); i2++) {
            this.mExpandableList.expandGroup(i2);
        }
        this.mExpandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: ui.activity.r
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j2) {
                return H5AppSelectedActivity.a(expandableListView, view, i3, j2);
            }
        });
        this.mExpandableList.setOnChildClickListener(new a());
    }

    public /* synthetic */ void a(util.r1 r1Var) throws PackageManager.NameNotFoundException {
        final List<AppInfoBean> listA = util.r1.a(new String[]{util.r1.f20958d}, true);
        final List<AppInfoBean> listA2 = r1Var.a();
        runOnUiThread(new Runnable() { // from class: ui.activity.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f19470a.a(listA, listA2);
            }
        });
    }

    public /* synthetic */ void a(List list, List list2) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.f18192d.add("未安装安装包");
        this.f18192d.add("已安装应用");
        this.f18193e.add(list);
        this.f18193e.add(list2);
        this.f18194f.addAll(list);
        this.f18194f.addAll(list2);
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
            if (this.f18189a == 1) {
                a();
            } else if (this.f18190b.size() == this.f18189a) {
                util.w1.a("最多选择" + this.f18189a + "个");
                return;
            }
            this.f18190b.add(appInfoBean);
            appInfoBean.setSelect(true);
        } else {
            this.f18190b.remove(appInfoBean);
            appInfoBean.setSelect(false);
        }
        fVar.notifyDataSetChanged();
    }

    private void a() {
        for (int i2 = 0; i2 < this.f18193e.size(); i2++) {
            List<AppInfoBean> list = this.f18193e.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).setSelect(false);
            }
        }
        this.f18191c.a(this.f18192d, this.f18193e);
        this.f18190b.clear();
    }
}
