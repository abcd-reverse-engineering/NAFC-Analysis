package cn.cloudwalk.libproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.cloudwalk.libproject.util.DisplayUtil;

/* loaded from: classes.dex */
public class TemplatedActivity extends BaseActivity {
    private View.OnClickListener listener = new View.OnClickListener() { // from class: cn.cloudwalk.libproject.TemplatedActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.actionbar_left_btn) {
                TemplatedActivity.this.onLeftClick(view);
                return;
            }
            if (id == R.id.actionbar_title) {
                TemplatedActivity.this.onClickTitle(view);
            } else if (id == R.id.actionbar_right_btn || id == R.id.actionbar_right_text) {
                TemplatedActivity.this.onRightClick(view);
            }
        }
    };
    protected View mActionLayout;
    private LinearLayout mContainer;
    protected ImageView mLeftBtn;
    protected ImageView mRightBtn;
    protected TextView mRightText;
    protected TextView mTitle;

    protected boolean hasActionBar() {
        return true;
    }

    public void onClickTitle(View view) {
    }

    @Override // cn.cloudwalk.libproject.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (hasActionBar()) {
            this.mContainer = new LinearLayout(this);
            this.mContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mContainer.setOrientation(1);
            this.mActionLayout = getLayoutInflater().inflate(R.layout.cloudwalk_actionbar_layout, (ViewGroup) null);
            this.mTitle = (TextView) this.mActionLayout.findViewById(R.id.actionbar_title);
            this.mLeftBtn = (ImageView) this.mActionLayout.findViewById(R.id.actionbar_left_btn);
            this.mRightBtn = (ImageView) this.mActionLayout.findViewById(R.id.actionbar_right_btn);
            this.mRightText = (TextView) this.mActionLayout.findViewById(R.id.actionbar_right_text);
            this.mTitle.setOnClickListener(this.listener);
            this.mLeftBtn.setOnClickListener(this.listener);
            this.mRightBtn.setOnClickListener(this.listener);
            this.mRightText.setOnClickListener(this.listener);
            this.mContainer.addView(this.mActionLayout, new LinearLayout.LayoutParams(-1, DisplayUtil.dip2px(this, 45.0f)));
        }
    }

    public void onLeftClick(View view) {
        finish();
    }

    public void onRightClick(View view) {
    }

    public void setActionBarBg(int i2) {
        this.mContainer.setBackgroundColor(i2);
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        if (!hasActionBar()) {
            super.setContentView(i2);
            return;
        }
        this.mContainer.addView(getLayoutInflater().inflate(i2, (ViewGroup) null), new LinearLayout.LayoutParams(-1, -1));
        super.setContentView(this.mContainer);
    }

    protected void setLeftBtnIcon(Drawable drawable) {
        if (hasActionBar()) {
            this.mLeftBtn.setImageDrawable(drawable);
            this.mLeftBtn.setVisibility(0);
        }
    }

    protected void setRightBackground(int i2) {
        if (hasActionBar()) {
            this.mRightText.setVisibility(0);
            this.mRightText.setBackgroundResource(i2);
            this.mRightBtn.setVisibility(8);
        }
    }

    protected void setRightBtnIcon(Drawable drawable) {
        if (hasActionBar()) {
            this.mRightText.setVisibility(8);
            this.mRightBtn.setVisibility(8);
            this.mRightBtn.setImageDrawable(drawable);
        }
    }

    protected void setRightText(int i2) {
        setRightText(getResources().getString(i2));
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        if (!hasActionBar()) {
            super.setTitle(charSequence);
        } else {
            this.mTitle.setText(charSequence);
            this.mTitle.setBackgroundDrawable(null);
        }
    }

    protected void setTitleIcon(int i2) {
        setTitleIcon(getResources().getDrawable(i2));
    }

    protected void setRightText(String str) {
        if (hasActionBar()) {
            this.mRightText.setVisibility(0);
            this.mRightText.setText(str);
            this.mRightBtn.setVisibility(8);
        }
    }

    protected void setTitleIcon(Drawable drawable) {
        if (hasActionBar()) {
            this.mTitle.setText((CharSequence) null);
            this.mTitle.setBackgroundDrawable(drawable);
        }
    }

    protected void setLeftBtnIcon(int i2) {
        setLeftBtnIcon(getResources().getDrawable(i2));
    }

    protected void setRightBtnIcon(int i2) {
        setRightBtnIcon(getResources().getDrawable(i2));
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        setTitle(getText(i2));
    }
}
