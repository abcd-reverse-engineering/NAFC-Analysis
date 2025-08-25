package ui.activity;

import android.app.Activity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.NoteListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.view.swip.SwipBackLayout;

/* compiled from: NoteDetailActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020%H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lui/activity/NoteDetailActivity;", "Lui/activity/BaseActivity;", "()V", "mContent", "Landroid/widget/TextView;", "getMContent", "()Landroid/widget/TextView;", "setMContent", "(Landroid/widget/TextView;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mNoteTit", "getMNoteTit", "setMNoteTit", "mTvTime", "getMTvTime", "setMTvTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "noteBean", "Lbean/NoteListBean;", "getNoteBean", "()Lbean/NoteListBean;", "setNoteBean", "(Lbean/NoteListBean;)V", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class NoteDetailActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private NoteListBean f18412a;

    @BindView(R.id.content)
    @i.c.a.d
    public TextView mContent;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.title)
    @i.c.a.d
    public TextView mNoteTit;

    @BindView(R.id.time)
    @i.c.a.d
    public TextView mTvTime;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    /* compiled from: NoteDetailActivity.kt */
    static final class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public static final a f18413a = new a();

        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    @i.c.a.d
    public final TextView a() {
        TextView textView = this.mContent;
        if (textView == null) {
            h.q2.t.i0.k("mContent");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView b() {
        TextView textView = this.mNoteTit;
        if (textView == null) {
            h.q2.t.i0.k("mNoteTit");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView c() {
        TextView textView = this.mTvTime;
        if (textView == null) {
            h.q2.t.i0.k("mTvTime");
        }
        return textView;
    }

    @i.c.a.e
    public final NoteListBean d() {
        return this.f18412a;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        textView.setText("公告详情");
        initView();
    }

    public final void initView() {
        this.f18412a = (NoteListBean) getIntent().getSerializableExtra(util.k1.f20845c);
        if (this.f18412a != null) {
            TextView textView = this.mTvTime;
            if (textView == null) {
                h.q2.t.i0.k("mTvTime");
            }
            NoteListBean noteListBean = this.f18412a;
            textView.setText(noteListBean != null ? noteListBean.getVaildStartTime() : null);
            TextView textView2 = this.mNoteTit;
            if (textView2 == null) {
                h.q2.t.i0.k("mNoteTit");
            }
            NoteListBean noteListBean2 = this.f18412a;
            textView2.setText(Html.fromHtml(noteListBean2 != null ? noteListBean2.getTitle() : null));
            TextView textView3 = this.mContent;
            if (textView3 == null) {
                h.q2.t.i0.k("mContent");
            }
            NoteListBean noteListBean3 = this.f18412a;
            textView3.setText(Html.fromHtml(noteListBean3 != null ? noteListBean3.getContent() : null));
            TextView textView4 = this.mContent;
            if (textView4 == null) {
                h.q2.t.i0.k("mContent");
            }
            textView4.setMovementMethod(new ScrollingMovementMethod());
            TextView textView5 = this.mContent;
            if (textView5 == null) {
                h.q2.t.i0.k("mContent");
            }
            textView5.setOnTouchListener(a.f18413a);
        }
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_note_detail;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void a(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mContent = textView;
    }

    public final void b(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mNoteTit = textView;
    }

    public final void c(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTime = textView;
    }

    public final void a(@i.c.a.e NoteListBean noteListBean) {
        this.f18412a = noteListBean;
    }
}
