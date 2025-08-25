package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class<?>, Service> f6439a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<Class<?>, Object> f6440b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<Class<?>, Service> f6441c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<Class<?>, Object> f6442d = new HashMap();

    d(List<Service> list, Context context) {
        a(list, context);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service2) throws SecurityException {
        StringBuilder sb;
        String localizedMessage;
        if (service2.getInstance() != null) {
            return service2.getInstance();
        }
        Class<?> type = service2.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor constructorA = a(type, Context.class, AGConnectInstance.class);
            if (constructorA != null) {
                return constructorA.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor constructorA2 = a(type, Context.class);
            return constructorA2 != null ? constructorA2.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e2.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        } catch (InstantiationException e3) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e3.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        } catch (InvocationTargetException e4) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e4.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        }
    }

    private static Constructor a(Class cls, Class... clsArr) throws SecurityException {
        boolean z = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                boolean z2 = z;
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    z2 = parameterTypes[i2] == clsArr[i2];
                }
                if (z2) {
                    return constructor;
                }
                z = z2;
            }
        }
        return null;
    }

    private void a(String str, Exception exc) {
        String str2 = "Instantiate shared service " + str + exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder();
        sb.append("cause message:");
        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        sb.toString();
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service2 = this.f6441c.get(cls);
        if (service2 == null && (service2 = f6439a.get(cls)) != null) {
            return (T) f6440b.get(cls);
        }
        if (service2 == null) {
            return null;
        }
        if (service2.isSingleton() && (t = (T) this.f6442d.get(cls)) != null) {
            return t;
        }
        T t2 = (T) a(aGConnectInstance, service2);
        if (t2 != null && service2.isSingleton()) {
            this.f6442d.put(cls, t2);
        }
        return t2;
    }

    public void a(List<Service> list, Context context) {
        Map<Class<?>, Service> map;
        String str;
        if (list == null) {
            return;
        }
        for (Service service2 : list) {
            if (service2.isSharedInstance()) {
                if (!f6439a.containsKey(service2.getInterface())) {
                    map = f6439a;
                }
                if (!service2.isAutoCreated() && service2.getType() != null && !f6440b.containsKey(service2.getInterface())) {
                    try {
                        Constructor constructorA = a(service2.getType(), Context.class);
                        f6440b.put(service2.getInterface(), constructorA != null ? constructorA.newInstance(context) : service2.getType().newInstance());
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        str = "AccessException";
                        a(str, e);
                    } catch (InstantiationException e3) {
                        e = e3;
                        str = "InstantiationException";
                        a(str, e);
                    } catch (InvocationTargetException e4) {
                        e = e4;
                        str = "TargetException";
                        a(str, e);
                    }
                }
            } else {
                map = this.f6441c;
            }
            map.put(service2.getInterface(), service2);
            if (!service2.isAutoCreated()) {
            }
        }
    }
}
