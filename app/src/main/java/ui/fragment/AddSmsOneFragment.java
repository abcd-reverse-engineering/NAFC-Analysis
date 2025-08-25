package ui.fragment;

import adapter.SmsPictureAdapter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import ui.activity.CriminalSmsAddActivity;
import util.b1;
import util.s1;
import util.w1;

/* loaded from: classes2.dex */
public class AddSmsOneFragment extends BaseFragment {

    /* renamed from: b, reason: collision with root package name */
    private CriminalSmsAddActivity f19572b;

    /* renamed from: c, reason: collision with root package name */
    private SmsPictureAdapter f19573c;

    @BindView(R.id.confirm)
    TextView mBtnCommit;

    @BindView(R.id.et_describe)
    EditText mEtDescribe;

    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @BindView(R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.ll_picture)
    LinearLayout mLlPicture;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_tip_picture)
    TextView mTvTipPicture;

    /* renamed from: a, reason: collision with root package name */
    private CriminalSmsBean f19571a = null;

    /* renamed from: d, reason: collision with root package name */
    private List<LocalMedia> f19574d = new ArrayList();

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                AddSmsOneFragment.this.mEtDescribe.setFocusable(true);
                AddSmsOneFragment.this.mEtDescribe.setFocusableInTouchMode(true);
            } else if (action == 2) {
                AddSmsOneFragment.this.mEtDescribe.setFocusable(false);
            }
            return false;
        }
    }

    class b implements SmsPictureAdapter.b {
        b() {
        }

        @Override // adapter.SmsPictureAdapter.b
        public void onItemClickListener(int i2, List<LocalMedia> list) {
            AddSmsOneFragment.this.f19572b.onItemClickListener(i2, list);
        }
    }

    class c implements BaseQuickAdapter.i {
        c() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            AddSmsOneFragment.this.f19572b.onItemChildClick(baseQuickAdapter, view, i2);
        }
    }

    class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            AddSmsOneFragment.this.f19572b.confirm(AddSmsOneFragment.this.f19571a);
        }
    }

    private void h() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        List<LocalMedia> list = this.f19574d;
        this.f19572b.getClass();
        this.f19573c = new SmsPictureAdapter(R.layout.recyclerview_feedback, list, 6, this.f19572b.isOnlyShow());
        this.f19573c.a(this.mRecyclerview);
        this.f19573c.setOnItemClickListener(new b());
        this.f19573c.setOnItemChildClickListener(new c());
        this.mRecyclerview.setAdapter(this.f19573c);
    }

    private void i() {
        this.mEtPhone.setEnabled(false);
        this.mEtDescribe.setEnabled(false);
        this.mEtVictimPhone.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        if (this.f19574d.size() <= 0) {
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    public void d() {
        String string = this.mEtPhone.getText().toString();
        String string2 = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            w1.a("请输入接收短信号码");
            return;
        }
        if (TextUtils.isEmpty(string)) {
            w1.a("请输入涉诈短信号码");
            return;
        }
        if (this.mTvTime.length() == 0) {
            w1.a("请选择涉诈短信接收时间");
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            w1.a("请输入涉诈短信内容");
            return;
        }
        if (this.f19571a == null) {
            this.f19571a = new CriminalSmsBean();
        }
        this.f19571a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f19571a.setSuspectMobile(string);
        this.f19571a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f19571a.setContent(string2);
        this.f19571a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f19571a.setDeliveryTime(this.mTvTime.getText().toString());
        if (TextUtils.equals(string, AccountManager.getVisiblePhone())) {
            b1.a(this.mActivity, "添加的涉诈短信中包含您的登录号码，确定添加个人发送短信为涉诈短信？", "", "取消", "确定", R.color._A8B4F7, R.color.blue, true, (IClickListener) new d());
        } else {
            this.f19572b.confirm(this.f19571a);
        }
    }

    public CriminalSmsBean e() {
        return this.f19571a;
    }

    public List<LocalMedia> f() {
        return this.f19574d;
    }

    public void g() {
        this.f19573c.notifyDataSetChanged();
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_sms;
    }

    @Override // ui.fragment.BaseFragment
    public void initPage() {
        this.f19572b = (CriminalSmsAddActivity) this.mActivity;
        this.mEtDescribe.setOnTouchListener(new a());
        try {
            CriminalSmsBean criminalSmsBean = ((CriminalSmsAddActivity) this.mActivity).getCriminalSmsBean();
            if (criminalSmsBean.getSmsType() == 1) {
                this.f19571a = criminalSmsBean;
            }
            if (this.f19571a != null) {
                String victimMobile = this.f19571a.getVictimMobile();
                String suspectMobile = this.f19571a.getSuspectMobile();
                String deliveryTime = this.f19571a.getDeliveryTime();
                String content = this.f19571a.getContent();
                if (!TextUtils.isEmpty(victimMobile)) {
                    this.mEtVictimPhone.setText(victimMobile);
                }
                if (!TextUtils.isEmpty(suspectMobile)) {
                    this.mEtPhone.setText(suspectMobile);
                }
                if (!TextUtils.isEmpty(deliveryTime)) {
                    this.mTvTime.setText(deliveryTime);
                }
                if (!TextUtils.isEmpty(content)) {
                    this.mEtDescribe.setText(content);
                }
                List<SmsPictureBean> smsDetails = this.f19571a.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia = new LocalMedia();
                        localMedia.setPath(smsPictureBean.getLocalPath());
                        localMedia.setCompressPath(smsPictureBean.getFilePath());
                        localMedia.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.f19574d.add(localMedia);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f19571a == null) {
            this.f19571a = new CriminalSmsBean();
            this.f19571a.setSmsType(1);
            this.f19571a.setSmsTypeText(this.f19572b.strs[0]);
        }
        this.f19572b.setChildBean(this.f19571a);
        h();
        if (this.f19572b.isOnlyShow()) {
            i();
        }
    }

    @OnClick({R.id.tv_time, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            d();
        } else {
            if (id != R.id.tv_time) {
                return;
            }
            s1.a(this.mActivity, this.mTvTime);
        }
    }
}
