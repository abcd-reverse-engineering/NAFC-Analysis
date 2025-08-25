package com.hicorenational.antifraud.service;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CallWarnBean;
import bean.WhiteTelBean;
import com.hicorenational.antifraud.R;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import manager.AccountManager;
import manager.FloatingWindow;
import manager.IFloatingWindow;
import ui.callview.CallWarnCallView;
import ui.presenter.WarnPresenter;
import ui.presenter.WelocmPresenter;
import util.n1;
import util.u1;

/* loaded from: classes.dex */
public class CallIntercepeUtil implements CallWarnCallView {
    private boolean calling;
    private String inPhoneNum;
    private ImageView mClose;
    private Context mContext;
    private boolean mIsBound = false;
    private int mWhiteResult = 0;
    private IFloatingWindow mWindowCall;
    private IFloatingWindow mWindowWhite;
    private a myPhoneStateListener;
    private boolean phoneIsWorn;
    private TelephonyManager telephonyManager;
    private TextView tvNumTag;
    private TextView tvPhone;
    private TextView tvRecordTip;
    private TextView tvWarnType;
    private WarnPresenter warnPresenter;

    class a extends PhoneStateListener {
        a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            super.onCallStateChanged(i2, str);
            n1.a("hsc", "onReceive   state---------------   " + i2 + " / " + str);
            CallIntercepeUtil.this.mIsBound = false;
            CallIntercepeUtil.this.phoneIsWorn = false;
            CallIntercepeUtil.this.inPhoneNum = str;
            if (i2 != 0) {
                if (i2 == 1 && !CallIntercepeUtil.this.calling) {
                    CallIntercepeUtil.this.judgeWhiteTel();
                    if (CallIntercepeUtil.this.mWhiteResult == 2 && !TextUtils.isEmpty(str) && u1.a(u1.F, false)) {
                        CallIntercepeUtil.this.warnPresenter.requestOKHttp(CallIntercepeUtil.this.inPhoneNum);
                    }
                    CallIntercepeUtil.this.calling = true;
                    return;
                }
                return;
            }
            CallIntercepeUtil.this.mIsBound = true;
            CallIntercepeUtil.this.calling = false;
            if (CallIntercepeUtil.this.mWindowWhite != null) {
                CallIntercepeUtil.this.mWindowWhite.dismiss();
            }
            if (CallIntercepeUtil.this.mWindowCall != null) {
                CallIntercepeUtil.this.mWindowCall.dismiss();
            }
            if (AccountManager.isLogin()) {
                return;
            }
            CallIntercepeUtil.this.inPhoneNum = "";
        }
    }

    private void dlgCallWarnView(CallWarnBean callWarnBean) {
        this.tvPhone.setText(callWarnBean.getTelNumber());
        if (callWarnBean.getSource() == 0 || callWarnBean.getSource() == 3 || callWarnBean.getSource() == 4 || callWarnBean.getSource() == 5 || callWarnBean.getSource() == 9) {
            this.phoneIsWorn = true;
            this.tvNumTag.setText("");
            this.tvWarnType.setText(callWarnBean.getTabText());
            this.tvRecordTip.setText("建议拒接或接听后点击录音并举报");
            return;
        }
        if (callWarnBean.getSource() == 1) {
            this.phoneIsWorn = true;
            this.tvNumTag.setText("已被" + callWarnBean.getCount() + "人标记为");
            this.tvWarnType.setText(callWarnBean.getTabText());
            this.tvRecordTip.setText("建议拒接或接听后点击录音并标注");
            return;
        }
        if (callWarnBean.getSource() != 2) {
            this.phoneIsWorn = false;
            return;
        }
        this.phoneIsWorn = true;
        this.tvNumTag.setText("已被" + callWarnBean.getCount() + "人举报为");
        this.tvWarnType.setText(callWarnBean.getTabText());
        this.tvRecordTip.setText("建议拒接或接听后点击录音并举报");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeWhiteTel() {
        this.mWhiteResult = 3;
        List<WhiteTelBean> list = WelocmPresenter.whiteTelList;
        if (list != null && list.size() > 0) {
            for (WhiteTelBean whiteTelBean : WelocmPresenter.whiteTelList) {
                Iterator<String> it = whiteTelBean.getList().iterator();
                while (it.hasNext()) {
                    String strTrim = Pattern.compile("[^(0-9)]").matcher(it.next()).replaceAll("").trim();
                    if (TextUtils.equals(strTrim, this.inPhoneNum)) {
                        this.mWhiteResult = 1;
                        this.mWindowWhite = showWhiteListWindow(strTrim, whiteTelBean.getAreaName());
                        return;
                    }
                }
            }
        }
        this.mWhiteResult = 2;
    }

    private IFloatingWindow showCallWindow() {
        final FloatingWindow floatingWindow = new FloatingWindow(this.mContext);
        floatingWindow.setParams(floatingWindow.getCallWarnLayoutParams());
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_call_intercepter, (ViewGroup) null);
        this.mClose = (ImageView) viewInflate.findViewById(R.id.iv_closee);
        this.tvPhone = (TextView) viewInflate.findViewById(R.id.tv_dialog_phone);
        this.tvNumTag = (TextView) viewInflate.findViewById(R.id.tv_num_tag);
        this.tvWarnType = (TextView) viewInflate.findViewById(R.id.tv_warn_type);
        this.tvRecordTip = (TextView) viewInflate.findViewById(R.id.tv_record_tip);
        this.mClose.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                floatingWindow.dismiss();
            }
        });
        floatingWindow.setContentView(viewInflate);
        return floatingWindow;
    }

    private IFloatingWindow showWhiteListWindow(String str, String str2) {
        final FloatingWindow floatingWindow = new FloatingWindow(this.mContext);
        floatingWindow.setParams(floatingWindow.getCallWarnLayoutParams());
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_white_list, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_closee);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_dialog_phone);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_dialog_describe);
        if (floatingWindow.getAllWindow() != null) {
            textView.setText(str);
            textView2.setText(str2);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                floatingWindow.dismiss();
            }
        });
        floatingWindow.setContentView(viewInflate);
        floatingWindow.show();
        return floatingWindow;
    }

    public void getIncomingCall(Context context) {
        this.mContext = context;
        this.mWhiteResult = 0;
        this.telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        this.myPhoneStateListener = new a();
        this.telephonyManager.listen(this.myPhoneStateListener, 32);
        this.warnPresenter = new WarnPresenter(this.mContext, this);
    }

    @Override // ui.callview.CallWarnCallView
    public void onSuccRequest(CallWarnBean callWarnBean) {
        IFloatingWindow iFloatingWindow = this.mWindowWhite;
        if ((iFloatingWindow != null && iFloatingWindow.isShowing()) || callWarnBean == null || this.mIsBound) {
            return;
        }
        if (this.mWindowCall == null) {
            this.mWindowCall = showCallWindow();
        }
        dlgCallWarnView(callWarnBean);
        if (this.phoneIsWorn) {
            this.mWindowCall.show();
        }
    }
}
