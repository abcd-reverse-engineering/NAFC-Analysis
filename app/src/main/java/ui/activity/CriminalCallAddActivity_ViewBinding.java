package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class CriminalCallAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CriminalCallAddActivity f17987a;

    /* renamed from: b, reason: collision with root package name */
    private View f17988b;

    /* renamed from: c, reason: collision with root package name */
    private View f17989c;

    /* renamed from: d, reason: collision with root package name */
    private View f17990d;

    /* renamed from: e, reason: collision with root package name */
    private View f17991e;

    /* renamed from: f, reason: collision with root package name */
    private View f17992f;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalCallAddActivity f17993a;

        a(CriminalCallAddActivity criminalCallAddActivity) {
            this.f17993a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17993a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalCallAddActivity f17995a;

        b(CriminalCallAddActivity criminalCallAddActivity) {
            this.f17995a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17995a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalCallAddActivity f17997a;

        c(CriminalCallAddActivity criminalCallAddActivity) {
            this.f17997a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17997a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalCallAddActivity f17999a;

        d(CriminalCallAddActivity criminalCallAddActivity) {
            this.f17999a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17999a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalCallAddActivity f18001a;

        e(CriminalCallAddActivity criminalCallAddActivity) {
            this.f18001a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18001a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalCallAddActivity_ViewBinding(CriminalCallAddActivity criminalCallAddActivity) {
        this(criminalCallAddActivity, criminalCallAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CriminalCallAddActivity criminalCallAddActivity = this.f17987a;
        if (criminalCallAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17987a = null;
        criminalCallAddActivity.mTvTitle = null;
        criminalCallAddActivity.mBtnConfirm = null;
        criminalCallAddActivity.mEtVictimPhone = null;
        criminalCallAddActivity.mEtPhone = null;
        criminalCallAddActivity.mTvOccurTime = null;
        criminalCallAddActivity.mTvDuration = null;
        criminalCallAddActivity.mLlClause = null;
        criminalCallAddActivity.mTCbSelect = null;
        criminalCallAddActivity.mAudioNum = null;
        this.f17988b.setOnClickListener(null);
        this.f17988b = null;
        this.f17989c.setOnClickListener(null);
        this.f17989c = null;
        this.f17990d.setOnClickListener(null);
        this.f17990d = null;
        this.f17991e.setOnClickListener(null);
        this.f17991e = null;
        this.f17992f.setOnClickListener(null);
        this.f17992f = null;
    }

    @UiThread
    public CriminalCallAddActivity_ViewBinding(CriminalCallAddActivity criminalCallAddActivity, View view) {
        this.f17987a = criminalCallAddActivity;
        criminalCallAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        criminalCallAddActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f17988b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalCallAddActivity));
        criminalCallAddActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        criminalCallAddActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_occur_time, "field 'mTvOccurTime' and method 'onViewClicked'");
        criminalCallAddActivity.mTvOccurTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_occur_time, "field 'mTvOccurTime'", TextView.class);
        this.f17989c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalCallAddActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_duration, "field 'mTvDuration' and method 'onViewClicked'");
        criminalCallAddActivity.mTvDuration = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_duration, "field 'mTvDuration'", TextView.class);
        this.f17990d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalCallAddActivity));
        criminalCallAddActivity.mLlClause = Utils.findRequiredView(view, R.id.ll_clause, "field 'mLlClause'");
        criminalCallAddActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_audio_num, "field 'mAudioNum' and method 'onViewClicked'");
        criminalCallAddActivity.mAudioNum = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_audio_num, "field 'mAudioNum'", TextView.class);
        this.f17991e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(criminalCallAddActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17992f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(criminalCallAddActivity));
    }
}
