package ui.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import b.a.a.e.d;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
import bean.UploadFileBean;
import butterknife.BindView;
import com.hicorenational.antifraud.R;
import com.umeng.analytics.pro.bh;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.CriminalPhoneView;
import ui.presenter.CriminalPhonePresenter;
import ui.view.w;
import util.y1;

/* compiled from: CriminalCallAddActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010>\u001a\u00020\tH\u0002J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020@H\u0002J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0014J\u0012\u0010D\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0007J\u0018\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020JH\u0016J\u0016\u0010K\u001a\u00020@2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020\u001aH\u0016J\u0010\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020%H\u0007J\u0006\u0010P\u001a\u00020@J\b\u0010Q\u001a\u00020@H\u0002J\b\u0010R\u001a\u00020,H\u0016J\b\u0010S\u001a\u00020@H\u0002J\b\u0010T\u001a\u00020@H\u0002J\b\u0010U\u001a\u00020@H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\u001e\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u001e\u0010;\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000f¨\u0006V"}, d2 = {"Lui/activity/CriminalCallAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CriminalPhoneView;", "()V", "CNATelList", "", "", "caseInfoId", "isEdit", "", "mAudioNum", "Landroid/widget/TextView;", "getMAudioNum", "()Landroid/widget/TextView;", "setMAudioNum", "(Landroid/widget/TextView;)V", "mAudios", "", "Lbean/UploadFileBean;", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mCallBean", "Lbean/CallBean;", "mEtPhone", "Landroid/widget/EditText;", "getMEtPhone", "()Landroid/widget/EditText;", "setMEtPhone", "(Landroid/widget/EditText;)V", "mEtVictimPhone", "getMEtVictimPhone", "setMEtVictimPhone", "mLlClause", "Landroid/view/View;", "getMLlClause", "()Landroid/view/View;", "setMLlClause", "(Landroid/view/View;)V", "mPhoneList", "mPosition", "", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvDuration", "getMTvDuration", "setMTvDuration", "mTvOccurTime", "getMTvOccurTime", "setMTvOccurTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "checkListRepeat", "editChangeListner", "", com.umeng.socialize.tracker.a.f11813c, "initPage", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccess", "onSuccessSave", "bean", "onViewClicked", "view", "onkeyback", "saveHttpApi", "setLayoutView", "showData", "showDurationPiker", "showTimePiker", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CriminalCallAddActivity extends BaseActivity implements CriminalPhoneView {
    private List<String> CNATelList;
    private boolean isEdit;

    @BindView(R.id.tv_audio_num)
    @i.c.a.d
    public TextView mAudioNum;

    @BindView(R.id.btn_confirm)
    @i.c.a.d
    public Button mBtnConfirm;
    private CallBean mCallBean;

    @BindView(R.id.et_phone)
    @i.c.a.d
    public EditText mEtPhone;

    @BindView(R.id.et_victim_phone)
    @i.c.a.d
    public EditText mEtVictimPhone;

    @BindView(R.id.ll_clause)
    @i.c.a.d
    public View mLlClause;
    private CriminalPhonePresenter mPresenter;

    @BindView(R.id.cb_select)
    @i.c.a.d
    public CheckBox mTCbSelect;

    @BindView(R.id.tv_duration)
    @i.c.a.d
    public TextView mTvDuration;

    @BindView(R.id.tv_occur_time)
    @i.c.a.d
    public TextView mTvOccurTime;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;
    private List<CallBean> mPhoneList = new ArrayList();
    private int mPosition = -1;
    private List<UploadFileBean> mAudios = new ArrayList();
    private String caseInfoId = "";

    /* compiled from: CriminalCallAddActivity.kt */
    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@i.c.a.d Editable editable) {
            h.q2.t.i0.f(editable, bh.aE);
            if (y1.a(editable.toString(), (List<String>) CriminalCallAddActivity.this.CNATelList)) {
                View mLlClause = CriminalCallAddActivity.this.getMLlClause();
                if (mLlClause == null) {
                    h.q2.t.i0.f();
                }
                mLlClause.setVisibility(0);
                return;
            }
            View mLlClause2 = CriminalCallAddActivity.this.getMLlClause();
            if (mLlClause2 == null) {
                h.q2.t.i0.f();
            }
            mLlClause2.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@i.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            h.q2.t.i0.f(charSequence, bh.aE);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@i.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            h.q2.t.i0.f(charSequence, bh.aE);
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    static final class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(@i.c.a.e CompoundButton compoundButton, boolean z) {
            CheckBox mTCbSelect = CriminalCallAddActivity.this.getMTCbSelect();
            if (mTCbSelect == null) {
                h.q2.t.i0.f();
            }
            mTCbSelect.setChecked(z);
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    public static final class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CriminalCallAddActivity.this.saveHttpApi();
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    public static final class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CriminalCallAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    static final class e implements w.l {
        e() {
        }

        @Override // ui.view.w.l
        public final void a(String str, String str2, String str3) throws NumberFormatException {
            int i2;
            int i3;
            String str4;
            int i4 = 0;
            try {
                h.q2.t.i0.a((Object) str, "hour");
                i2 = Integer.parseInt(str);
                h.q2.t.i0.a((Object) str2, "minute");
                i3 = Integer.parseInt(str2);
                h.q2.t.i0.a((Object) str3, "second");
                i4 = Integer.parseInt(str3);
            } catch (Exception unused) {
                i2 = 0;
                i3 = 0;
            }
            if (i2 > 0) {
                str4 = String.valueOf(i2) + "小时" + i3 + "分钟" + i4 + "秒";
            } else if (i3 > 0) {
                str4 = String.valueOf(i3) + "分钟" + i4 + "秒";
            } else {
                str4 = String.valueOf(i4) + "秒";
            }
            TextView mTvDuration = CriminalCallAddActivity.this.getMTvDuration();
            if (mTvDuration == null) {
                h.q2.t.i0.f();
            }
            mTvDuration.setText(str4);
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    static final class f implements d.m {
        f() {
        }

        @Override // b.a.a.e.d.m
        public final void a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + '-' + str2 + '-' + str3 + ' ' + str4 + ':' + str5;
            TextView mTvOccurTime = CriminalCallAddActivity.this.getMTvOccurTime();
            if (mTvOccurTime == null) {
                h.q2.t.i0.f();
            }
            mTvOccurTime.setText(str6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean checkListRepeat() {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.CriminalCallAddActivity.checkListRepeat():boolean");
    }

    private final void editChangeListner() {
        EditText editText = this.mEtPhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtPhone");
        }
        if (editText == null) {
            h.q2.t.i0.f();
        }
        editText.addTextChangedListener(new a());
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            h.q2.t.i0.k("mTCbSelect");
        }
        if (checkBox == null) {
            h.q2.t.i0.f();
        }
        checkBox.setOnCheckedChangeListener(new b());
    }

    private final void initData() {
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPhoneList = h.q2.t.n1.d(getIntent().getSerializableExtra(util.k1.f20845c));
        this.mPosition = getIntent().getIntExtra(util.k1.f20847e, -1);
        List<CallBean> list = this.mPhoneList;
        if (list == null || this.mPosition < 0) {
            this.isEdit = false;
        } else {
            if (list == null) {
                h.q2.t.i0.f();
            }
            this.mCallBean = list.get(this.mPosition);
            showData();
            this.isEdit = true;
        }
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("通话类嫌疑人电话详情");
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        if (button == null) {
            h.q2.t.i0.f();
        }
        button.setText("添加");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveHttpApi() {
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            h.q2.t.i0.f();
        }
        CallBean callBean = this.mCallBean;
        if (callBean == null) {
            h.q2.t.i0.f();
        }
        criminalPhonePresenter.criminalCallSave(callBean);
    }

    private final void showData() {
        CallBean callBean = this.mCallBean;
        if (callBean != null) {
            if (callBean == null) {
                h.q2.t.i0.f();
            }
            if (callBean.getIsInput() == 1) {
                EditText editText = this.mEtPhone;
                if (editText == null) {
                    h.q2.t.i0.k("mEtPhone");
                }
                if (editText == null) {
                    h.q2.t.i0.f();
                }
                editText.setFocusable(false);
                EditText editText2 = this.mEtPhone;
                if (editText2 == null) {
                    h.q2.t.i0.k("mEtPhone");
                }
                if (editText2 == null) {
                    h.q2.t.i0.f();
                }
                editText2.setTextColor(Color.parseColor("#999999"));
                TextView textView = this.mTvOccurTime;
                if (textView == null) {
                    h.q2.t.i0.k("mTvOccurTime");
                }
                if (textView == null) {
                    h.q2.t.i0.f();
                }
                textView.setEnabled(false);
                TextView textView2 = this.mTvOccurTime;
                if (textView2 == null) {
                    h.q2.t.i0.k("mTvOccurTime");
                }
                if (textView2 == null) {
                    h.q2.t.i0.f();
                }
                textView2.setTextColor(Color.parseColor("#999999"));
                TextView textView3 = this.mTvDuration;
                if (textView3 == null) {
                    h.q2.t.i0.k("mTvDuration");
                }
                if (textView3 == null) {
                    h.q2.t.i0.f();
                }
                textView3.setEnabled(false);
                TextView textView4 = this.mTvDuration;
                if (textView4 == null) {
                    h.q2.t.i0.k("mTvDuration");
                }
                if (textView4 == null) {
                    h.q2.t.i0.f();
                }
                textView4.setTextColor(Color.parseColor("#999999"));
                TextView textView5 = this.mTvOccurTime;
                if (textView5 == null) {
                    h.q2.t.i0.k("mTvOccurTime");
                }
                if (textView5 == null) {
                    h.q2.t.i0.f();
                }
                textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                TextView textView6 = this.mTvDuration;
                if (textView6 == null) {
                    h.q2.t.i0.k("mTvDuration");
                }
                if (textView6 == null) {
                    h.q2.t.i0.f();
                }
                textView6.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                CallBean callBean2 = this.mCallBean;
                if (callBean2 == null) {
                    h.q2.t.i0.f();
                }
                CallBean callBean3 = this.mCallBean;
                if (callBean3 == null) {
                    h.q2.t.i0.f();
                }
                callBean2.setTalkTime(callBean3.getTalkTime());
            }
            EditText editText3 = this.mEtVictimPhone;
            if (editText3 == null) {
                h.q2.t.i0.k("mEtVictimPhone");
            }
            if (editText3 == null) {
                h.q2.t.i0.f();
            }
            CallBean callBean4 = this.mCallBean;
            if (callBean4 == null) {
                h.q2.t.i0.f();
            }
            editText3.setText(callBean4.getVictimMobile());
            EditText editText4 = this.mEtPhone;
            if (editText4 == null) {
                h.q2.t.i0.k("mEtPhone");
            }
            if (editText4 == null) {
                h.q2.t.i0.f();
            }
            CallBean callBean5 = this.mCallBean;
            if (callBean5 == null) {
                h.q2.t.i0.f();
            }
            editText4.setText(callBean5.getSuspectMobile());
            TextView textView7 = this.mTvOccurTime;
            if (textView7 == null) {
                h.q2.t.i0.k("mTvOccurTime");
            }
            if (textView7 == null) {
                h.q2.t.i0.f();
            }
            CallBean callBean6 = this.mCallBean;
            if (callBean6 == null) {
                h.q2.t.i0.f();
            }
            textView7.setText(callBean6.getTalkTime());
            TextView textView8 = this.mTvDuration;
            if (textView8 == null) {
                h.q2.t.i0.k("mTvDuration");
            }
            if (textView8 == null) {
                h.q2.t.i0.f();
            }
            CallBean callBean7 = this.mCallBean;
            if (callBean7 == null) {
                h.q2.t.i0.f();
            }
            textView8.setText(callBean7.getCallDuration());
            CallBean callBean8 = this.mCallBean;
            if (callBean8 == null) {
                h.q2.t.i0.f();
            }
            if (callBean8.getCallTelDetails() != null) {
                CallBean callBean9 = this.mCallBean;
                if (callBean9 == null) {
                    h.q2.t.i0.f();
                }
                List<UploadFileBean> callTelDetails = callBean9.getCallTelDetails();
                h.q2.t.i0.a((Object) callTelDetails, "mCallBean!!.callTelDetails");
                this.mAudios = callTelDetails;
                List<UploadFileBean> list = this.mAudios;
                if (list == null) {
                    h.q2.t.i0.f();
                }
                if (list.size() > 0) {
                    TextView textView9 = this.mAudioNum;
                    if (textView9 == null) {
                        h.q2.t.i0.k("mAudioNum");
                    }
                    if (textView9 == null) {
                        h.q2.t.i0.f();
                    }
                    StringBuilder sb = new StringBuilder();
                    List<UploadFileBean> list2 = this.mAudios;
                    if (list2 == null) {
                        h.q2.t.i0.f();
                    }
                    sb.append(String.valueOf(list2.size()));
                    sb.append("条");
                    textView9.setText(sb.toString());
                    TextView textView10 = this.mAudioNum;
                    if (textView10 == null) {
                        h.q2.t.i0.k("mAudioNum");
                    }
                    if (textView10 == null) {
                        h.q2.t.i0.f();
                    }
                    textView10.setTextColor(Color.parseColor("#333333"));
                }
            }
            TextView textView11 = this.mTvTitle;
            if (textView11 == null) {
                h.q2.t.i0.k("mTvTitle");
            }
            if (textView11 == null) {
                h.q2.t.i0.f();
            }
            textView11.setText("诈骗电话详情");
            Button button = this.mBtnConfirm;
            if (button == null) {
                h.q2.t.i0.k("mBtnConfirm");
            }
            if (button == null) {
                h.q2.t.i0.f();
            }
            button.setText("添加");
            CallBean callBean10 = this.mCallBean;
            if (callBean10 == null) {
                h.q2.t.i0.f();
            }
            if (callBean10.getSwindleTelTypeText() != null) {
                CallBean callBean11 = this.mCallBean;
                if (callBean11 == null) {
                    h.q2.t.i0.f();
                }
                if (h.z2.b0.c(callBean11.getSwindleTelTypeText(), "FaceTime", true)) {
                    View view = this.mLlClause;
                    if (view == null) {
                        h.q2.t.i0.k("mLlClause");
                    }
                    if (view == null) {
                        h.q2.t.i0.f();
                    }
                    view.setVisibility(0);
                    CheckBox checkBox = this.mTCbSelect;
                    if (checkBox == null) {
                        h.q2.t.i0.k("mTCbSelect");
                    }
                    if (checkBox == null) {
                        h.q2.t.i0.f();
                    }
                    checkBox.setChecked(true);
                }
            }
        }
    }

    private final void showDurationPiker() {
        ui.view.w wVar = new ui.view.w(this, -1, 3);
        wVar.c(23, 59, 59);
        wVar.a(0, 0, 0, 0, 0);
        wVar.setOnDateTimePickListener(new e());
        wVar.m();
    }

    private final void showTimePiker() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        b.a.a.e.d dVar = new b.a.a.e.d(this, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new f());
        dVar.m();
    }

    @i.c.a.d
    public final TextView getMAudioNum() {
        TextView textView = this.mAudioNum;
        if (textView == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        return textView;
    }

    @i.c.a.d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        return button;
    }

    @i.c.a.d
    public final EditText getMEtPhone() {
        EditText editText = this.mEtPhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtPhone");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtVictimPhone() {
        EditText editText = this.mEtVictimPhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtVictimPhone");
        }
        return editText;
    }

    @i.c.a.d
    public final View getMLlClause() {
        View view = this.mLlClause;
        if (view == null) {
            h.q2.t.i0.k("mLlClause");
        }
        return view;
    }

    @i.c.a.d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            h.q2.t.i0.k("mTCbSelect");
        }
        return checkBox;
    }

    @i.c.a.d
    public final TextView getMTvDuration() {
        TextView textView = this.mTvDuration;
        if (textView == null) {
            h.q2.t.i0.k("mTvDuration");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvOccurTime() {
        TextView textView = this.mTvOccurTime;
        if (textView == null) {
            h.q2.t.i0.k("mTvOccurTime");
        }
        return textView;
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
        org.greenrobot.eventbus.c.f().e(this);
        this.mPresenter = new CriminalPhonePresenter(this, this);
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            h.q2.t.i0.f();
        }
        criminalPhonePresenter.getCriminakTel();
        editChangeListner();
        initData();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@i.c.a.e util.c2.a aVar) {
        if (aVar == null || aVar.a() != 4) {
            return;
        }
        List<UploadFileBean> list = this.mAudios;
        if (list != null) {
            list.clear();
        }
        TextView textView = this.mAudioNum;
        if (textView == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("请选择");
        TextView textView2 = this.mAudioNum;
        if (textView2 == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setTextColor(Color.parseColor("#cccccc"));
        ArrayList arrayList = (ArrayList) aVar.b();
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        List<UploadFileBean> list2 = this.mAudios;
        if (list2 == null) {
            h.q2.t.i0.f();
        }
        list2.addAll(arrayList);
        TextView textView3 = this.mAudioNum;
        if (textView3 == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        if (textView3 == null) {
            h.q2.t.i0.f();
        }
        StringBuilder sb = new StringBuilder();
        List<UploadFileBean> list3 = this.mAudios;
        if (list3 == null) {
            h.q2.t.i0.f();
        }
        sb.append(String.valueOf(list3.size()));
        sb.append("条");
        textView3.setText(sb.toString());
        TextView textView4 = this.mAudioNum;
        if (textView4 == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        if (textView4 == null) {
            h.q2.t.i0.f();
        }
        textView4.setTextColor(Color.parseColor("#333333"));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @i.c.a.d KeyEvent keyEvent) {
        h.q2.t.i0.f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccess(@i.c.a.d List<String> list) {
        h.q2.t.i0.f(list, "CNATelList");
        this.CNATelList = list;
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessList(@i.c.a.d List<? extends CallBean> list) {
        h.q2.t.i0.f(list, "callBeans");
        CriminalPhoneView.a.b(this, list);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@i.c.a.d CriminalPhoneNumBean criminalPhoneNumBean) {
        h.q2.t.i0.f(criminalPhoneNumBean, "bean");
        CriminalPhoneView.a.a(this, criminalPhoneNumBean);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        CriminalPhoneView.a.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    @Override // ui.callview.CriminalPhoneView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccessSave(@i.c.a.d bean.CallBean r2) {
        /*
            r1 = this;
            java.lang.String r0 = "bean"
            h.q2.t.i0.f(r2, r0)
            bean.CallBean r2 = r1.mCallBean
            if (r2 == 0) goto L1e
            if (r2 != 0) goto Le
            h.q2.t.i0.f()
        Le:
            java.lang.String r2 = r2.getCallTelInfoID()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L1e
            java.lang.String r2 = "修改成功"
            util.w1.a(r2)
            goto L23
        L1e:
            java.lang.String r2 = "添加成功"
            util.w1.a(r2)
        L23:
            r1.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.CriminalCallAddActivity.onSuccessSave(bean.CallBean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0230  */
    @butterknife.OnClick({com.hicorenational.antifraud.R.id.iv_back, com.hicorenational.antifraud.R.id.tv_occur_time, com.hicorenational.antifraud.R.id.tv_duration, com.hicorenational.antifraud.R.id.tv_audio_num, com.hicorenational.antifraud.R.id.btn_confirm})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onViewClicked(@i.c.a.d android.view.View r9) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.CriminalCallAddActivity.onViewClicked(android.view.View):void");
    }

    public final void onkeyback() {
        util.b1.b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new d());
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_criminal_add;
    }

    public final void setMAudioNum(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mAudioNum = textView;
    }

    public final void setMBtnConfirm(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtPhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtPhone = editText;
    }

    public final void setMEtVictimPhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtVictimPhone = editText;
    }

    public final void setMLlClause(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlClause = view;
    }

    public final void setMTCbSelect(@i.c.a.d CheckBox checkBox) {
        h.q2.t.i0.f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvDuration(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvDuration = textView;
    }

    public final void setMTvOccurTime(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvOccurTime = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
