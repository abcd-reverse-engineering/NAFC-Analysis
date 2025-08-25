package ui.statusbarcompat;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import g.a.t0.f;

/* compiled from: StatusBarCompat.java */
/* loaded from: classes2.dex */
public class b {
    static int a(int i2, int i3) {
        float f2 = 1.0f - (i3 / 255.0f);
        return ((int) (((i2 & 255) * f2) + 0.5d)) | (((int) ((((i2 >> 16) & 255) * f2) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i2 >> 8) & 255) * f2) + 0.5d)) << 8);
    }

    public static void a(@f Activity activity, @ColorInt int i2, int i3) {
        a(activity, a(i2, i3), false);
    }

    public static void a(@f Activity activity, @ColorInt int i2, boolean z) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            d.a(activity, i2, z);
        } else if (i3 >= 19) {
            c.a(activity, i2);
        }
    }

    public static void a(@f Activity activity, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            d.b(activity, i2, false);
        } else if (i3 >= 19) {
            c.b(activity, i2);
        }
    }

    public static void a(@f Activity activity) {
        a(activity, false);
    }

    public static void a(@f Activity activity, boolean z, boolean z2) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            d.a(activity, z, z2);
        } else if (i2 >= 19) {
            c.c(activity);
        }
    }

    public static void a(@f Activity activity, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            d.a(activity, z);
        } else if (i2 >= 19) {
            c.b(activity);
        }
    }

    public static void a(@f Activity activity, boolean z, View view, boolean z2) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            d.a(activity, z, view, z2);
        } else if (i2 >= 19) {
            c.a(activity, view);
        }
    }

    public static void a(@f Fragment fragment, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            d.a(fragment, z);
        } else if (i2 >= 19) {
            c.a(fragment);
        }
    }

    public static void a(@f Fragment fragment, boolean z, View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            d.a(fragment, z, view);
        } else if (i2 >= 19) {
            c.a(fragment, view);
        }
    }

    public static void a(@f Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, @ColorInt int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            d.a(activity, appBarLayout, collapsingToolbarLayout, toolbar, i2);
        } else if (i3 >= 19) {
            c.a(activity, appBarLayout, collapsingToolbarLayout, toolbar, i2);
        }
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    public static void a(Context context, View view) {
        int i2;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (i2 = layoutParams.height) > 0) {
                layoutParams.height = i2 + a(context);
            }
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void a(Context context, boolean z) {
        if (context instanceof Activity) {
            a(((Activity) context).getWindow(), z);
        }
    }

    private static void a(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                decorView.setSystemUiVisibility(systemUiVisibility | 8192);
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
            }
        }
    }

    public static boolean a(@ColorInt int i2) {
        return ColorUtils.calculateLuminance(i2) < 0.5d;
    }

    public static void a(@f Window window, @ColorInt int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(c.c.a.b.a.a.B1);
            window.clearFlags(c.c.a.b.a.a.C1);
            window.getDecorView().setSystemUiVisibility(256);
            window.setStatusBarColor(i2);
            a(window, !a(i2));
        }
    }
}
