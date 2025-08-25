package k.a.b.b.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;

/* compiled from: MessageCodec.java */
/* loaded from: classes2.dex */
public class b {
    public Bundle a(Object obj, Bundle bundle) {
        for (Class<?> superclass = obj.getClass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                try {
                    a(obj, field, bundle);
                } catch (IllegalAccessException | IllegalArgumentException unused) {
                    String str = "encode, get value of the field exception, field name: " + field.getName();
                }
            }
        }
        return bundle;
    }

    private void a(Object obj, Field field, Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Modifier.isTransient(field.getModifiers())) {
            return;
        }
        boolean zIsAccessible = field.isAccessible();
        field.setAccessible(true);
        a(field.getName(), field.get(obj), bundle);
        field.setAccessible(zIsAccessible);
    }

    private void a(String str, Object obj, Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (obj != null) {
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
                return;
            }
            if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                bundle.putShort(str, ((Short) obj).shortValue());
                return;
            }
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
                return;
            }
            if (obj instanceof IBinder) {
                a.a(bundle, str, (IBinder) obj);
                return;
            }
            if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
                return;
            }
            if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
                return;
            }
            if (obj instanceof List) {
                a(str, (List) obj, bundle);
                return;
            }
            if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj.getClass() != Object.class) {
                Bundle bundleA = a(obj, new Bundle());
                bundleA.putInt("_val_type_", 0);
                bundle.putBundle(str, bundleA);
            }
        }
    }

    protected void a(String str, List list, Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            a("_list_item_" + i2, list.get(i2), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
