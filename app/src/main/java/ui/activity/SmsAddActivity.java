package ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import b.a.a.e.d;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ui.view.MyEdittext;

/* loaded from: classes2.dex */
public class SmsAddActivity extends BaseActivity {

    /* renamed from: d, reason: collision with root package name */
    public static final String f19013d = "extra_sms_add";

    /* renamed from: a, reason: collision with root package name */
    private SmsBean f19014a = null;

    /* renamed from: b, reason: collision with root package name */
    private List<SmsBean> f19015b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private int f19016c = -1;

    @BindView(R.id.confirm)
    TextView mBtnCommit;

    @BindView(R.id.et_describe)
    MyEdittext mEtDescribe;

    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @BindView(R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements d.m {
        a() {
        }

        @Override // b.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            SmsAddActivity.this.mTvTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + c.c.a.b.a.a.f3100g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
    }

    private void showTimePiker() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        b.a.a.e.d dVar = new b.a.a.e.d(this, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new a());
        dVar.m();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加短信");
        try {
            this.f19015b = (List) getIntent().getSerializableExtra(util.k1.f20845c);
            this.f19016c = getIntent().getIntExtra(util.k1.f20847e, -1);
            if (this.f19015b != null && this.f19016c >= 0 && this.f19016c < this.f19015b.size()) {
                this.f19014a = this.f19015b.get(this.f19016c);
                if (this.f19014a != null) {
                    String victimTel = this.f19014a.getVictimTel();
                    String smsNum = this.f19014a.getSmsNum();
                    String stringDate = this.f19014a.getStringDate();
                    String smsContent = this.f19014a.getSmsContent();
                    if (!TextUtils.isEmpty(victimTel)) {
                        this.mEtVictimPhone.setText(victimTel);
                    }
                    if (!TextUtils.isEmpty(smsNum)) {
                        this.mEtPhone.setText(smsNum);
                    }
                    if (!TextUtils.isEmpty(stringDate)) {
                        this.mTvTime.setText(stringDate);
                    }
                    if (!TextUtils.isEmpty(smsContent)) {
                        this.mEtDescribe.setText(smsContent);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (this.f19014a == null) {
            this.f19014a = new SmsBean("", "", "", false);
        }
        if (this.mEtVictimPhone.length() <= 0) {
            String strJ = util.v1.j();
            if (TextUtils.isEmpty(strJ)) {
                return;
            }
            this.mEtVictimPhone.setText(strJ);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_time, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            sendData();
        } else if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.tv_time) {
                return;
            }
            showTimePiker();
        }
    }

    public void sendData() {
        String string = this.mEtPhone.getText().toString();
        String string2 = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            util.w1.a("请输入或粘贴收件人短信号码");
            return;
        }
        if (TextUtils.isEmpty(string)) {
            util.w1.a("请输入或粘贴诈骗短信号码");
            return;
        }
        if (this.mTvTime.length() == 0) {
            util.w1.a("请选择诈骗短信接收时间");
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            util.w1.a("请输入短信内容");
            return;
        }
        if (this.f19014a == null) {
            this.f19014a = new SmsBean("", "", "", false);
        }
        this.f19014a.setVictimTel(this.mEtVictimPhone.getText().toString());
        this.f19014a.setSmsNum(string);
        this.f19014a.setStringDate(this.mTvTime.getText().toString());
        this.f19014a.setSmsContent(string2);
        this.f19014a.setVictimTel(this.mEtVictimPhone.getText().toString());
        this.f19014a.setStringDate(this.mTvTime.getText().toString());
        List<SmsBean> list = this.f19015b;
        if (list == null || list.size() <= 0) {
            if (this.f19015b == null) {
                this.f19015b = new ArrayList();
            }
            this.f19015b.add(this.f19014a);
        } else {
            int iIndexOf = this.f19015b.indexOf(this.f19014a);
            for (int i2 = 0; i2 < this.f19015b.size(); i2++) {
                if (i2 != this.f19016c && i2 != iIndexOf && TextUtils.equals(this.f19014a.getVictimTel(), this.f19015b.get(i2).getVictimTel()) && TextUtils.equals(this.f19014a.getSmsNum(), this.f19015b.get(i2).getSmsNum()) && TextUtils.equals(this.f19014a.getStringDate(), this.f19015b.get(i2).getStringDate()) && TextUtils.equals(this.f19014a.getSmsContent(), this.f19015b.get(i2).getSmsContent())) {
                    util.w1.a("输入信息重复，请重新输入");
                    return;
                }
            }
            if (iIndexOf == -1 && this.f19016c == -1) {
                this.f19015b.add(this.f19014a);
            }
        }
        if (this.f19015b.size() == 0) {
            util.w1.a("还没有填写信息");
        } else {
            org.greenrobot.eventbus.c.f().d(new util.c2.a(303, this.f19015b));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sms_add;
    }
}
