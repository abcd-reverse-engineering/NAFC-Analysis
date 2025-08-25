package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class CheckIDActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CheckIDActivity f17968a;

    /* renamed from: b, reason: collision with root package name */
    private View f17969b;

    /* renamed from: c, reason: collision with root package name */
    private View f17970c;

    /* renamed from: d, reason: collision with root package name */
    private View f17971d;

    /* renamed from: e, reason: collision with root package name */
    private View f17972e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckIDActivity f17973a;

        a(CheckIDActivity checkIDActivity) {
            this.f17973a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17973a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckIDActivity f17975a;

        b(CheckIDActivity checkIDActivity) {
            this.f17975a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17975a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckIDActivity f17977a;

        c(CheckIDActivity checkIDActivity) {
            this.f17977a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17977a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckIDActivity f17979a;

        d(CheckIDActivity checkIDActivity) {
            this.f17979a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17979a.onViewClicked(view);
        }
    }

    @UiThread
    public CheckIDActivity_ViewBinding(CheckIDActivity checkIDActivity) {
        this(checkIDActivity, checkIDActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CheckIDActivity checkIDActivity = this.f17968a;
        if (checkIDActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17968a = null;
        checkIDActivity.mIvBack = null;
        checkIDActivity.mTvTitle = null;
        checkIDActivity.mRlAceptRead = null;
        checkIDActivity.mTvAceptRead = null;
        checkIDActivity.mEtCheckPhone = null;
        checkIDActivity.mIdVrfySend = null;
        checkIDActivity.mIdVrfyList = null;
        checkIDActivity.mTvNoReadNum = null;
        this.f17969b.setOnClickListener(null);
        this.f17969b = null;
        this.f17970c.setOnClickListener(null);
        this.f17970c = null;
        this.f17971d.setOnClickListener(null);
        this.f17971d = null;
        this.f17972e.setOnClickListener(null);
        this.f17972e = null;
    }

    @UiThread
    public CheckIDActivity_ViewBinding(CheckIDActivity checkIDActivity, View view) {
        this.f17968a = checkIDActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        checkIDActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f17969b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(checkIDActivity));
        checkIDActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_acept_view, "field 'mRlAceptRead' and method 'onViewClicked'");
        checkIDActivity.mRlAceptRead = viewFindRequiredView2;
        this.f17970c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(checkIDActivity));
        checkIDActivity.mTvAceptRead = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_acept_read, "field 'mTvAceptRead'", TextView.class);
        checkIDActivity.mEtCheckPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_check_phone, "field 'mEtCheckPhone'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_idvrfy_send, "field 'mIdVrfySend' and method 'onViewClicked'");
        checkIDActivity.mIdVrfySend = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_idvrfy_send, "field 'mIdVrfySend'", Button.class);
        this.f17971d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(checkIDActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.idvrfy_list, "field 'mIdVrfyList' and method 'onViewClicked'");
        checkIDActivity.mIdVrfyList = viewFindRequiredView4;
        this.f17972e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(checkIDActivity));
        checkIDActivity.mTvNoReadNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_read, "field 'mTvNoReadNum'", TextView.class);
    }
}
