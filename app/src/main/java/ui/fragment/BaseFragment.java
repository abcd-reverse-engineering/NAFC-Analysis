package ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import bean.module.RegionMudelBean;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ui.Hicore;
import util.v1;

/* loaded from: classes2.dex */
public abstract class BaseFragment extends Fragment {
    static RegionMudelBean mRegionBean;
    public Activity mActivity;
    private ui.view.s mProgressDialogBar;
    protected View mView;
    public Typeface typ_ME;
    Unbinder unbinder;

    protected abstract int getLayoutId();

    public void hideProgressDialog() {
        ui.view.s sVar = this.mProgressDialogBar;
        if (sVar == null || !sVar.isShowing()) {
            return;
        }
        this.mProgressDialogBar.dismiss();
    }

    public void hideSoftInput() {
        try {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected abstract void initPage();

    public boolean isDouble() {
        return Hicore.getApp().isDouble();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        v1.a(this.mActivity);
        this.mView = layoutInflater.inflate(getLayoutId(), (ViewGroup) null);
        this.unbinder = ButterKnife.bind(this, this.mView);
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        hideProgressDialog();
        org.greenrobot.eventbus.c.f().g(this);
        this.unbinder.unbind();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.typ_ME = Typeface.createFromAsset(getContext().getAssets(), "DIN-Medium.otf");
        initPage();
    }

    public void showProgressDialog() {
        showProgressDialog("加载中...");
    }

    public void startActivity(Class<?> cls) {
        startActivity(cls, (Bundle) null);
    }

    public void showProgressDialog(boolean z) {
        showProgressDialog("加载中...", z);
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this.mActivity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void showProgressDialog(String str) {
        showProgressDialog(str, true);
    }

    public void showProgressDialog(String str, boolean z) {
        if (this.mProgressDialogBar == null) {
            this.mProgressDialogBar = ui.view.s.a(getContext());
        }
        this.mProgressDialogBar.a(str);
        this.mProgressDialogBar.setCanceledOnTouchOutside(false);
        this.mProgressDialogBar.setCancelable(z);
        this.mProgressDialogBar.show();
    }
}
