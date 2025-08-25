package ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CaseHistoryBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class QRcodeActivity extends BaseActivity {

    @BindView(R.id.iv_qrcode)
    ImageView mIvQrcode;

    @BindView(R.id.tv_case_code)
    TextView mTvCaseCode;

    @BindView(R.id.tv_case_name)
    TextView mTvCaseName;

    @BindView(R.id.tv_close)
    TextView mTvClose;

    @BindView(R.id.tv_date)
    TextView mTvDate;

    @BindView(R.id.tv_number)
    TextView mTvNumber;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f18578a;

        /* renamed from: ui.activity.QRcodeActivity$a$a, reason: collision with other inner class name */
        class RunnableC0285a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f18580a;

            RunnableC0285a(Bitmap bitmap) {
                this.f18580a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                QRcodeActivity.this.mIvQrcode.setImageBitmap(this.f18580a);
            }
        }

        a(String str) {
            this.f18578a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(QRcodeActivity.this.getResources(), R.mipmap.ic_police_logo);
            int iA = util.c1.a(QRcodeActivity.this, 240.0f);
            Bitmap bitmapA = util.e1.a(this.f18578a, iA, iA, bitmapDecodeResource);
            ImageView imageView = QRcodeActivity.this.mIvQrcode;
            if (imageView != null) {
                imageView.post(new RunnableC0285a(bitmapA));
            }
        }
    }

    private void createQRcode(String str) {
        new Thread(new a(str)).start();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("二维码");
        this.mTvClose.setVisibility(8);
        CaseHistoryBean.Rows rows = (CaseHistoryBean.Rows) getIntent().getSerializableExtra(util.k1.f20845c);
        String id = rows.getId();
        String caseName = rows.getCaseName();
        String caseNumber = rows.getCaseNumber();
        String caseCategoryText = rows.getCaseCategoryText();
        if (TextUtils.isEmpty(caseNumber)) {
            this.mTvCaseCode.setText(c.c.a.b.a.a.f3100g);
        } else {
            this.mTvCaseCode.setText("采集编号：" + caseNumber);
        }
        if (TextUtils.isEmpty(caseCategoryText)) {
            this.mTvNumber.setVisibility(8);
        } else {
            this.mTvNumber.setVisibility(0);
            this.mTvNumber.setText(caseCategoryText);
        }
        this.mTvCaseName.setText(caseName);
        this.mIvQrcode.setImageResource(R.mipmap.ic_placeholder);
        if (TextUtils.isEmpty(id)) {
            util.w1.a("二维码数据有误");
            finish();
        } else {
            createQRcode(id);
            this.mTvDate.setText(rows.getCreateTime());
        }
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_qrcode;
    }
}
