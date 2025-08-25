package ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class AddSmsThreeFragment_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AddSmsThreeFragment f19594a;

    /* renamed from: b, reason: collision with root package name */
    private View f19595b;

    /* renamed from: c, reason: collision with root package name */
    private View f19596c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsThreeFragment f19597a;

        a(AddSmsThreeFragment addSmsThreeFragment) {
            this.f19597a = addSmsThreeFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19597a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsThreeFragment f19599a;

        b(AddSmsThreeFragment addSmsThreeFragment) {
            this.f19599a = addSmsThreeFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19599a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsThreeFragment_ViewBinding(AddSmsThreeFragment addSmsThreeFragment, View view) {
        this.f19594a = addSmsThreeFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsThreeFragment.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f19595b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addSmsThreeFragment));
        addSmsThreeFragment.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        addSmsThreeFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsThreeFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsThreeFragment.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f19596c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(addSmsThreeFragment));
        addSmsThreeFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        addSmsThreeFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsThreeFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsThreeFragment addSmsThreeFragment = this.f19594a;
        if (addSmsThreeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19594a = null;
        addSmsThreeFragment.mBtnCommit = null;
        addSmsThreeFragment.mEtPhone = null;
        addSmsThreeFragment.mEtDescribe = null;
        addSmsThreeFragment.mEtVictimPhone = null;
        addSmsThreeFragment.mTvTime = null;
        addSmsThreeFragment.mRecyclerview = null;
        addSmsThreeFragment.mLlPicture = null;
        addSmsThreeFragment.mTvTipPicture = null;
        this.f19595b.setOnClickListener(null);
        this.f19595b = null;
        this.f19596c.setOnClickListener(null);
        this.f19596c = null;
    }
}
