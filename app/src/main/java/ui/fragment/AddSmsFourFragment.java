package ui.fragment;

import adapter.SmsPictureAdapter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.e.i;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import ui.activity.CriminalSmsAddActivity;
import util.s1;
import util.w1;

/* loaded from: classes2.dex */
public class AddSmsFourFragment extends BaseFragment {

    /* renamed from: b, reason: collision with root package name */
    private CriminalSmsAddActivity f19554b;

    /* renamed from: c, reason: collision with root package name */
    private SmsPictureAdapter f19555c;

    @BindView(R.id.confirm)
    TextView mBtnCommit;

    @BindView(R.id.et_brand_other)
    EditText mEtBrandOther;

    @BindView(R.id.et_describe)
    EditText mEtDescribe;

    @BindView(R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.gp_brand_other)
    Group mGpBrandOther;

    @BindView(R.id.ll_picture)
    LinearLayout mLlPicture;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_brand)
    TextView mTvBrand;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_tip_picture)
    TextView mTvTipPicture;

    /* renamed from: a, reason: collision with root package name */
    private CriminalSmsBean f19553a = null;

    /* renamed from: d, reason: collision with root package name */
    private List<LocalMedia> f19556d = new ArrayList();

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                AddSmsFourFragment.this.mEtDescribe.setFocusable(true);
                AddSmsFourFragment.this.mEtDescribe.setFocusableInTouchMode(true);
            } else if (action == 2) {
                AddSmsFourFragment.this.mEtDescribe.setFocusable(false);
            }
            return false;
        }
    }

    class b implements i.b<BrandBean> {
        b() {
        }

        @Override // b.a.a.e.i.b
        public void a(int i2, BrandBean brandBean) {
            AddSmsFourFragment.this.f19553a.setOsBrandType(brandBean.getOsBrandType());
            AddSmsFourFragment.this.f19553a.setOsBrandTypeText(brandBean.getOsBrandTypeText());
            AddSmsFourFragment.this.mTvBrand.setText(brandBean.getOsBrandTypeText());
            if (brandBean.getEx() == 1) {
                AddSmsFourFragment.this.mGpBrandOther.setVisibility(0);
            } else {
                AddSmsFourFragment.this.mGpBrandOther.setVisibility(8);
            }
        }
    }

    class c implements SmsPictureAdapter.b {
        c() {
        }

        @Override // adapter.SmsPictureAdapter.b
        public void onItemClickListener(int i2, List<LocalMedia> list) {
            AddSmsFourFragment.this.f19554b.onItemClickListener(i2, list);
        }
    }

    class d implements BaseQuickAdapter.i {
        d() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            AddSmsFourFragment.this.f19554b.onItemChildClick(baseQuickAdapter, view, i2);
        }
    }

    private void h() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        List<LocalMedia> list = this.f19556d;
        this.f19554b.getClass();
        this.f19555c = new SmsPictureAdapter(R.layout.recyclerview_feedback, list, 6, this.f19554b.isOnlyShow());
        this.f19555c.a(this.mRecyclerview);
        this.f19555c.setOnItemClickListener(new c());
        this.f19555c.setOnItemChildClickListener(new d());
        this.mRecyclerview.setAdapter(this.f19555c);
    }

    private void i() {
        this.mTvBrand.setEnabled(false);
        this.mEtDescribe.setEnabled(false);
        this.mEtVictimPhone.setEnabled(false);
        this.mEtBrandOther.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        if (this.f19556d.size() <= 0) {
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    public CriminalSmsBean d() {
        return this.f19553a;
    }

    public List<LocalMedia> e() {
        return this.f19556d;
    }

    public void f() {
        this.f19555c.notifyDataSetChanged();
    }

    public void g() {
        String string = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            w1.a("请输入接收短信号码");
            return;
        }
        if (this.mTvBrand.length() == 0) {
            w1.a("请选择接收短信手机品牌");
            return;
        }
        if (this.mGpBrandOther.getVisibility() == 0 && this.mEtBrandOther.length() == 0) {
            w1.a("请输入手机品牌名称");
            return;
        }
        if (this.mTvTime.length() == 0) {
            w1.a("请选择涉诈短信接收时间");
            return;
        }
        if (TextUtils.isEmpty(string)) {
            w1.a("请输入涉诈短信内容");
            return;
        }
        if (this.f19553a == null) {
            this.f19553a = new CriminalSmsBean();
        }
        if (this.mGpBrandOther.getVisibility() == 0) {
            this.f19553a.setOsBrandTypeText(this.mEtBrandOther.getText().toString());
        }
        this.f19553a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f19553a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f19553a.setContent(string);
        this.f19553a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f19553a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f19554b.confirm(this.f19553a);
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_sms_ip;
    }

    @Override // ui.fragment.BaseFragment
    public void initPage() {
        this.f19554b = (CriminalSmsAddActivity) this.mActivity;
        this.mEtDescribe.setOnTouchListener(new a());
        try {
            CriminalSmsBean criminalSmsBean = ((CriminalSmsAddActivity) this.mActivity).getCriminalSmsBean();
            if (criminalSmsBean.getSmsType() == 4) {
                this.f19553a = criminalSmsBean;
            }
            if (this.f19553a != null) {
                String victimMobile = this.f19553a.getVictimMobile();
                String deliveryTime = this.f19553a.getDeliveryTime();
                this.f19553a.getOsBrandTypeText();
                String content = this.f19553a.getContent();
                if (!TextUtils.isEmpty(victimMobile)) {
                    this.mEtVictimPhone.setText(victimMobile);
                }
                if (!TextUtils.isEmpty(deliveryTime)) {
                    this.mTvTime.setText(deliveryTime);
                }
                if (!TextUtils.isEmpty(content)) {
                    this.mEtDescribe.setText(content);
                }
                List<SmsPictureBean> smsDetails = this.f19553a.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia = new LocalMedia();
                        localMedia.setPath(smsPictureBean.getLocalPath());
                        localMedia.setCompressPath(smsPictureBean.getFilePath());
                        localMedia.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.f19556d.add(localMedia);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f19553a == null) {
            this.f19553a = new CriminalSmsBean();
            this.f19553a.setSmsType(4);
            this.f19553a.setSmsTypeText(this.f19554b.strs[3]);
        }
        this.f19554b.setChildBean(this.f19553a);
        h();
        this.mGpBrandOther.setVisibility(8);
        if (this.f19554b.isOnlyShow()) {
            i();
        }
    }

    @OnClick({R.id.tv_time, R.id.tv_brand, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            g();
        } else if (id == R.id.tv_brand) {
            this.f19554b.brandPick(new b());
        } else {
            if (id != R.id.tv_time) {
                return;
            }
            s1.a(this.mActivity, this.mTvTime);
        }
    }

    public void a(List<BrandBean> list) {
        CriminalSmsBean criminalSmsBean = this.f19553a;
        if (criminalSmsBean == null || TextUtils.isEmpty(criminalSmsBean.getOsBrandType())) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            BrandBean brandBean = list.get(i2);
            if (TextUtils.equals(this.f19553a.getOsBrandType(), brandBean.getOsBrandType())) {
                this.mTvBrand.setText(brandBean.getOsBrandTypeText());
                if (brandBean.getEx() == 1) {
                    this.mEtBrandOther.setText(this.f19553a.getOsBrandTypeText());
                    this.mGpBrandOther.setVisibility(0);
                    return;
                }
                return;
            }
        }
    }
}
