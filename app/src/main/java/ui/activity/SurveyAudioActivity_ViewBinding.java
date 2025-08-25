package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class SurveyAudioActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SurveyAudioActivity f19078a;

    /* renamed from: b, reason: collision with root package name */
    private View f19079b;

    /* renamed from: c, reason: collision with root package name */
    private View f19080c;

    /* renamed from: d, reason: collision with root package name */
    private View f19081d;

    /* renamed from: e, reason: collision with root package name */
    private View f19082e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurveyAudioActivity f19083a;

        a(SurveyAudioActivity surveyAudioActivity) {
            this.f19083a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19083a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurveyAudioActivity f19085a;

        b(SurveyAudioActivity surveyAudioActivity) {
            this.f19085a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19085a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurveyAudioActivity f19087a;

        c(SurveyAudioActivity surveyAudioActivity) {
            this.f19087a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19087a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurveyAudioActivity f19089a;

        d(SurveyAudioActivity surveyAudioActivity) {
            this.f19089a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19089a.onViewClicked(view);
        }
    }

    @UiThread
    public SurveyAudioActivity_ViewBinding(SurveyAudioActivity surveyAudioActivity) {
        this(surveyAudioActivity, surveyAudioActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SurveyAudioActivity surveyAudioActivity = this.f19078a;
        if (surveyAudioActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19078a = null;
        surveyAudioActivity.mTvTitle = null;
        surveyAudioActivity.mRecyclerview = null;
        surveyAudioActivity.mTvAdd = null;
        surveyAudioActivity.mRecyclerviewSuspect = null;
        surveyAudioActivity.mBtnCommit = null;
        surveyAudioActivity.mTvSuspectTip = null;
        surveyAudioActivity.mLlAddBtn = null;
        this.f19079b.setOnClickListener(null);
        this.f19079b = null;
        this.f19080c.setOnClickListener(null);
        this.f19080c = null;
        this.f19081d.setOnClickListener(null);
        this.f19081d = null;
        this.f19082e.setOnClickListener(null);
        this.f19082e = null;
    }

    @UiThread
    public SurveyAudioActivity_ViewBinding(SurveyAudioActivity surveyAudioActivity, View view) {
        this.f19078a = surveyAudioActivity;
        surveyAudioActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        surveyAudioActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        surveyAudioActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        surveyAudioActivity.mRecyclerviewSuspect = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_suspect, "field 'mRecyclerviewSuspect'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        surveyAudioActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f19079b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(surveyAudioActivity));
        surveyAudioActivity.mTvSuspectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_suspect_tip, "field 'mTvSuspectTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add_suspect, "field 'mLlAddBtn' and method 'onViewClicked'");
        surveyAudioActivity.mLlAddBtn = viewFindRequiredView2;
        this.f19080c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(surveyAudioActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19081d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(surveyAudioActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_add, "method 'onViewClicked'");
        this.f19082e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(surveyAudioActivity));
    }
}
