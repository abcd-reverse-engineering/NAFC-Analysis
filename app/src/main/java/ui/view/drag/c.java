package ui.view.drag;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: ReflectUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Class<?> superclass = obj.getClass();
        while (true) {
            if (superclass == Object.class) {
                declaredMethod = null;
                break;
            }
            try {
                declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                break;
            } catch (Exception unused) {
                superclass = superclass.getSuperclass();
            }
        }
        if (declaredMethod == null) {
            return null;
        }
        declaredMethod.setAccessible(true);
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
