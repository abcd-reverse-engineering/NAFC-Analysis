package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class QRcodeActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private QRcodeActivity f18582a;

    /* renamed from: b, reason: collision with root package name */
    private View f18583b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QRcodeActivity f18584a;

        a(QRcodeActivity qRcodeActivity) {
            this.f18584a = qRcodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18584a.onViewClicked(view);
        }
    }

    @UiThread
    public QRcodeActivity_ViewBinding(QRcodeActivity qRcodeActivity) {
        this(qRcodeActivity, qRcodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        QRcodeActivity qRcodeActivity = this.f18582a;
        if (qRcodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18582a = null;
        qRcodeActivity.mTvTitle = null;
        qRcodeActivity.mTvCaseName = null;
        qRcodeActivity.mTvNumber = null;
        qRcodeActivity.mIvQrcode = null;
        qRcodeActivity.mTvDate = null;
        qRcodeActivity.mTvCaseCode = null;
        qRcodeActivity.mTvClose = null;
        this.f18583b.setOnClickListener(null);
        this.f18583b = null;
    }

    @UiThread
    public QRcodeActivity_ViewBinding(QRcodeActivity qRcodeActivity, View view) {
        this.f18582a = qRcodeActivity;
        qRcodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        qRcodeActivity.mTvCaseName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_name, "field 'mTvCaseName'", TextView.class);
        qRcodeActivity.mTvNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_number, "field 'mTvNumber'", TextView.class);
        qRcodeActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
        qRcodeActivity.mTvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_date, "field 'mTvDate'", TextView.class);
        qRcodeActivity.mTvCaseCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_code, "field 'mTvCaseCode'", TextView.class);
        qRcodeActivity.mTvClose = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_close, "field 'mTvClose'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18583b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(qRcodeActivity));
    }
}
