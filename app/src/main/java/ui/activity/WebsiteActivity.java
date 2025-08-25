package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;

/* loaded from: classes2.dex */
public class WebsiteActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<EditText> f19368a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<ImageView> f19369b;

    /* renamed from: c, reason: collision with root package name */
    private List<String> f19370c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private int f19371d = 20;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.linearlayout)
    public LinearLayout mLinearLayout;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommit;

    @BindView(R.id.fl_select_history)
    public View mTvSelectHistory;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.v_line)
    public View mVline;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebsiteActivity.this.a(view);
        }
    }

    private void b() {
        this.mLinearLayout.removeAllViews();
        this.f19368a.clear();
        this.f19369b.clear();
    }

    private void c() {
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(util.k1.n);
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            for (int i2 = 0; i2 < 5; i2++) {
                a();
            }
        } else {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
        List<SmsBean> listA = SmsRecordSelectActivity.a((Activity) this, true);
        if (listA == null || listA.size() <= 0) {
            this.mVline.setVisibility(8);
            this.mTvSelectHistory.setVisibility(8);
        } else {
            this.mVline.setVisibility(0);
            this.mTvSelectHistory.setVisibility(0);
        }
    }

    private List<String> d() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f19368a.size(); i2++) {
            String strTrim = this.f19368a.get(i2).getText().toString().trim();
            if (!TextUtils.isEmpty(strTrim) && !arrayList.contains(strTrim)) {
                arrayList.add(strTrim);
            }
        }
        return arrayList;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("添加诈骗网址");
        this.mTvCommit.setText("最多可添加20条网址");
        this.mBtnCommit.setText("确定");
        this.mLinearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        this.f19368a = new LinkedList<>();
        this.f19369b = new LinkedList<>();
        c();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        sendData();
        org.greenrobot.eventbus.c.f().g(this);
        LinearLayout linearLayout = this.mLinearLayout;
        if (linearLayout == null || this.f19368a == null || this.f19369b == null) {
            return;
        }
        linearLayout.removeAllViews();
        this.f19368a.clear();
        this.f19369b.clear();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        List list;
        if (aVar == null || aVar.a() != 13 || (list = (List) aVar.b()) == null) {
            return;
        }
        this.f19370c = d();
        b();
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String smsContent = ((SmsBean) it.next()).getSmsContent();
                if (this.f19370c == null) {
                    this.f19370c = new ArrayList();
                }
                if (this.f19370c.size() <= 0) {
                    this.f19370c.add(smsContent);
                } else if (!this.f19370c.contains(smsContent)) {
                    this.f19370c.add(smsContent);
                }
            }
            List<String> list2 = this.f19370c;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            Iterator<String> it2 = this.f19370c.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_back, R.id.fl_select, R.id.fl_select_history, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                this.f19370c = d();
                finish();
                break;
            case R.id.fl_select /* 2131296641 */:
                if (!rejuctOperation()) {
                    a();
                    break;
                }
                break;
            case R.id.fl_select_history /* 2131296642 */:
                if (!rejuctOperation()) {
                    this.f19370c = d();
                    int size = 0;
                    List<String> list = this.f19370c;
                    if (list != null && list.size() > 0) {
                        size = this.f19370c.size();
                    }
                    Intent intent = new Intent(this, (Class<?>) SmsRecordSelectActivity.class);
                    intent.putExtra(SmsRecordSelectActivity.f19028h, 2);
                    intent.putExtra("extra_select_can", this.f19371d - size);
                    startActivity(intent);
                    break;
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
        }
    }

    public boolean rejuctOperation() {
        LinkedList<EditText> linkedList = this.f19368a;
        if (linkedList == null || linkedList.size() != this.f19371d) {
            return false;
        }
        util.w1.a("最多可添加" + this.f19371d + "条网址");
        return true;
    }

    public void sendData() {
        List<String> list = this.f19370c;
        if (list == null || list.size() <= 0) {
            this.f19370c = d();
        }
        org.greenrobot.eventbus.c.f().d(new util.c2.a(8, this.f19370c));
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_weburl;
    }

    private void a() {
        a("");
    }

    private void a(String str) {
        View viewInflate = View.inflate(this.mActivity, R.layout.recyclerview_url_select, null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.et_content);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_clear);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(500)});
        imageView.setOnClickListener(new a());
        this.mLinearLayout.addView(viewInflate);
        this.f19368a.add(editText);
        this.f19369b.add(imageView);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        editText.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f19369b.size()) {
                break;
            }
            if (this.f19369b.get(i3) == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (this.f19368a.size() == 1) {
            this.f19368a.get(i2).setText("");
            return;
        }
        this.f19368a.remove(i2);
        this.f19369b.remove(i2);
        this.mLinearLayout.removeViewAt(i2);
    }
}
