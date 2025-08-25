package cn.cloudwalk.libproject.view;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class RoundFrameLayout extends FrameLayout {
    private int radius;

    public RoundFrameLayout(Context context) {
        this(context, null);
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int i2) {
        this.radius = i2;
    }

    public void turnRound() {
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radius = 0;
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: cn.cloudwalk.libproject.view.RoundFrameLayout.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(new Rect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight()), RoundFrameLayout.this.radius);
                }
            });
            setClipToOutline(true);
        }
    }
}
