package ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import b.a.a.e.d;
import bean.CallBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ui.Hicore;
import ui.view.w;

/* loaded from: classes2.dex */
public class CallEditActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    private CallBean f17742a = null;

    /* renamed from: b, reason: collision with root package name */
    private List<CallBean> f17743b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private int f17744c = -1;

    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;

    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @BindView(R.id.et_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.tv_duration)
    TextView mTvDuration;

    @BindView(R.id.tv_occur_time)
    TextView mTvOccurTime;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements d.m {
        a() {
        }

        @Override // b.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            CallEditActivity.this.mTvOccurTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + c.c.a.b.a.a.f3100g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
    }

    class b implements w.l {
        b() {
        }

        @Override // ui.view.w.l
        public void a(String str, String str2, String str3) throws NumberFormatException {
            int i2;
            int i3;
            String str4;
            int i4 = 0;
            try {
                i2 = Integer.parseInt(str);
                i3 = Integer.parseInt(str2);
                i4 = Integer.parseInt(str3);
            } catch (Exception unused) {
                i2 = 0;
                i3 = 0;
            }
            if (i2 > 0) {
                str4 = i2 + "小时" + i3 + "分钟" + i4 + "秒";
            } else if (i3 > 0) {
                str4 = i3 + "分钟" + i4 + "秒";
            } else {
                str4 = i4 + "秒";
            }
            CallEditActivity.this.mTvDuration.setText(str4);
        }
    }

    private void initData() {
        try {
            this.f17743b = (List) getIntent().getSerializableExtra(util.k1.f20845c);
            this.f17744c = getIntent().getIntExtra(util.k1.f20847e, -1);
            if (this.f17743b != null && this.f17744c >= 0 && this.f17744c < this.f17743b.size()) {
                this.f17742a = this.f17743b.get(this.f17744c);
                if (this.f17742a != null) {
                    this.mEtVictimPhone.setText(this.f17742a.getVictimTel());
                    this.mEtPhone.setText(this.f17742a.getNumber());
                    this.mTvOccurTime.setText(this.f17742a.getCrime_time());
                    this.mTvDuration.setText(this.f17742a.getTalkTime());
                }
            }
        } catch (Exception unused) {
            this.f17742a = null;
        }
        if (this.mEtVictimPhone.length() <= 0) {
            String strJ = util.v1.j();
            if (TextUtils.isEmpty(strJ)) {
                return;
            }
            this.mEtVictimPhone.setText(strJ);
        }
    }

    private void initView() {
        this.mTvTitle.setText("添加电话");
    }

    private void showDurationPiker() {
        ui.view.w wVar = new ui.view.w(this, -1, 3);
        wVar.c(23, 59, 59);
        wVar.a(0, 0, 0, 0, 0);
        wVar.setOnDateTimePickListener(new b());
        wVar.m();
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
        initView();
        initData();
    }

    @OnClick({R.id.iv_back, R.id.tv_occur_time, R.id.tv_duration, R.id.btn_confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_confirm /* 2131296396 */:
                if (this.mEtVictimPhone.length() == 0) {
                    util.w1.a("请输入受害人电话");
                    break;
                } else if (this.mEtPhone.length() == 0) {
                    util.w1.a("请填写诈骗电话");
                    break;
                } else if (this.mTvOccurTime.length() == 0) {
                    util.w1.a("请选择通话开始时间");
                    break;
                } else if (this.mTvDuration.length() == 0) {
                    util.w1.a("请选择通话时长");
                    break;
                } else {
                    if (this.f17742a == null) {
                        this.f17742a = new CallBean();
                    }
                    this.f17742a.setVictimTel(this.mEtVictimPhone.getText().toString());
                    this.f17742a.setNumber(this.mEtPhone.getText().toString());
                    this.f17742a.setCrime_time(this.mTvOccurTime.getText().toString());
                    this.f17742a.setTalkTime(this.mTvDuration.getText().toString());
                    List<CallBean> list = this.f17743b;
                    if (list == null || list.size() <= 0) {
                        if (this.f17743b == null) {
                            this.f17743b = new ArrayList();
                        }
                        this.f17743b.add(this.f17742a);
                    } else {
                        int iIndexOf = this.f17743b.indexOf(this.f17742a);
                        for (int i2 = 0; i2 < this.f17743b.size(); i2++) {
                            if (i2 != this.f17744c && i2 != iIndexOf && TextUtils.equals(this.f17742a.getNumber(), this.f17743b.get(i2).getNumber()) && TextUtils.equals(this.f17742a.getCrime_time(), this.f17743b.get(i2).getCrime_time())) {
                                util.w1.a("输入信息重复，请重新输入");
                                break;
                            }
                        }
                        if (iIndexOf == -1 && this.f17744c == -1) {
                            this.f17743b.add(this.f17742a);
                        }
                    }
                    if (this.f17743b.size() != 0) {
                        org.greenrobot.eventbus.c.f().d(new util.c2.a(301, this.f17743b));
                        finish();
                        break;
                    } else {
                        util.w1.a("还没有填写信息");
                        break;
                    }
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.tv_duration /* 2131297543 */:
                showDurationPiker();
                break;
            case R.id.tv_occur_time /* 2131297619 */:
                showTimePiker();
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_edit;
    }
}
