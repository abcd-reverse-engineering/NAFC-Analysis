package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Array;
import java.util.List;

/* loaded from: classes.dex */
public final class Utils {
    private static final TypedValue VALUE = new TypedValue();

    private Utils() {
        throw new AssertionError("No instances.");
    }

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T... tArr) {
        int length = tArr.length;
        int i2 = 0;
        for (T t : tArr) {
            if (t != null) {
                tArr[i2] = t;
                i2++;
            }
        }
        if (i2 == length) {
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
        System.arraycopy(tArr, 0, tArr2, 0, i2);
        return tArr2;
    }

    public static <T> T castParam(Object obj, String str, int i2, String str2, int i3, Class<T> cls) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Parameter #" + (i2 + 1) + " of method '" + str + "' was of the wrong type for parameter #" + (i3 + 1) + " of method '" + str2 + "'. See cause for more info.", e2);
        }
    }

    public static <T> T castView(View view, @IdRes int i2, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e2) {
            throw new IllegalStateException("View '" + getResourceEntryName(view, i2) + "' with ID " + i2 + " for " + str + " was of the wrong type. See cause for more info.", e2);
        }
    }

    public static <T> T findOptionalViewAsType(View view, @IdRes int i2, String str, Class<T> cls) {
        return (T) castView(view.findViewById(i2), i2, str, cls);
    }

    public static View findRequiredView(View view, @IdRes int i2, String str) {
        View viewFindViewById = view.findViewById(i2);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalStateException("Required view '" + getResourceEntryName(view, i2) + "' with ID " + i2 + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T findRequiredViewAsType(View view, @IdRes int i2, String str, Class<T> cls) {
        return (T) castView(findRequiredView(view, i2, str), i2, str, cls);
    }

    @UiThread
    public static float getFloat(Context context, @DimenRes int i2) throws Resources.NotFoundException {
        TypedValue typedValue = VALUE;
        context.getResources().getValue(i2, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i2) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    private static String getResourceEntryName(View view, @IdRes int i2) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i2);
    }

    @UiThread
    public static Drawable getTintedDrawable(Context context, @DrawableRes int i2, @AttrRes int i3) {
        if (context.getTheme().resolveAttribute(i3, VALUE, true)) {
            Drawable drawableWrap = DrawableCompat.wrap(ContextCompat.getDrawable(context, i2).mutate());
            DrawableCompat.setTint(drawableWrap, ContextCompat.getColor(context, VALUE.resourceId));
            return drawableWrap;
        }
        throw new Resources.NotFoundException("Required tint color attribute with name " + context.getResources().getResourceEntryName(i3) + " and attribute ID " + i3 + " was not found.");
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T... tArr) {
        return new ImmutableList(arrayFilteringNull(tArr));
    }
}
