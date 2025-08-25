package com.tencent.bugly.beta.tinker;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerPatchReflectApplication extends TinkerApplication {
    private static final String TAG = "Tinker.ReflectApp";
    private boolean isReflectFailure;
    private String rawApplicationName;
    private Application realApplication;

    public TinkerPatchReflectApplication() {
        super(7, "com.tencent.bugly.beta.tinker.TinkerApplicationLike", TinkerLoader.class.getName(), false);
        this.rawApplicationName = null;
        this.isReflectFailure = false;
    }

    protected void attachBaseContext(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.attachBaseContext(context);
        try {
            String rawApplicationName = getRawApplicationName(context);
            if (rawApplicationName == null) {
                throw new RuntimeException("can get real realApplication from manifest!");
            }
            this.realApplication = (Application) Class.forName(rawApplicationName, false, getClassLoader()).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (this.realApplication != null) {
                try {
                    Method declaredMethod = ContextWrapper.class.getDeclaredMethod("attachBaseContext", Context.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.realApplication, context);
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
        } catch (Exception e3) {
            throw new IllegalStateException(e3);
        }
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        Application application;
        return (!this.isReflectFailure || (application = this.realApplication) == null) ? super.bindService(intent, serviceConnection, i2) : application.bindService(intent, serviceConnection, i2);
    }

    public AssetManager getAssets() {
        Application application;
        return (!this.isReflectFailure || (application = this.realApplication) == null) ? super.getAssets() : application.getAssets();
    }

    public ClassLoader getClassLoader() {
        Application application;
        return (!this.isReflectFailure || (application = this.realApplication) == null) ? super.getClassLoader() : application.getClassLoader();
    }

    public ContentResolver getContentResolver() {
        Application application;
        return (!this.isReflectFailure || (application = this.realApplication) == null) ? super.getContentResolver() : application.getContentResolver();
    }

    public String getRawApplicationName(Context context) {
        String str = this.rawApplicationName;
        if (str != null) {
            return str;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("TINKER_PATCH_APPLICATION");
            if (obj != null) {
                this.rawApplicationName = String.valueOf(obj);
            } else {
                this.rawApplicationName = null;
            }
            String str2 = "with app realApplication from manifest applicationName:" + this.rawApplicationName;
            return this.rawApplicationName;
        } catch (Exception e2) {
            String str3 = "getManifestApplication exception:" + e2.getMessage();
            return null;
        }
    }

    public Resources getResources() {
        Application application;
        return (!this.isReflectFailure || (application = this.realApplication) == null) ? super.getResources() : application.getResources();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.onConfigurationChanged(configuration);
        } else {
            application.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        Class<?> cls;
        if (this.realApplication != null) {
            try {
                Class<?> cls2 = Class.forName("android.app.ActivityThread");
                Object activityThread = ShareReflectUtil.getActivityThread(this, cls2);
                Field declaredField = cls2.getDeclaredField("mInitialApplication");
                declaredField.setAccessible(true);
                Application application = (Application) declaredField.get(activityThread);
                if (this.realApplication != null && application == this) {
                    declaredField.set(activityThread, this.realApplication);
                }
                if (this.realApplication != null) {
                    Field declaredField2 = cls2.getDeclaredField("mAllApplications");
                    declaredField2.setAccessible(true);
                    List list = (List) declaredField2.get(activityThread);
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (list.get(i2) == this) {
                            list.set(i2, this.realApplication);
                        }
                    }
                }
                try {
                    cls = Class.forName("android.app.LoadedApk");
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName("android.app.ActivityThread$PackageInfo");
                }
                Field declaredField3 = cls.getDeclaredField("mApplication");
                declaredField3.setAccessible(true);
                Field declaredField4 = null;
                try {
                    declaredField4 = Application.class.getDeclaredField("mLoadedApk");
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
                String[] strArr = {"mPackages", "mResourcePackages"};
                for (int i3 = 0; i3 < 2; i3++) {
                    Field declaredField5 = cls2.getDeclaredField(strArr[i3]);
                    declaredField5.setAccessible(true);
                    Iterator it = ((Map) declaredField5.get(activityThread)).entrySet().iterator();
                    while (it.hasNext()) {
                        Object obj = ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                        if (obj != null && declaredField3.get(obj) == this) {
                            if (this.realApplication != null) {
                                declaredField3.set(obj, this.realApplication);
                            }
                            if (this.realApplication != null && declaredField4 != null) {
                                declaredField4.set(this.realApplication, obj);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                String str = "Error, reflect Application fail, result:" + th;
                this.isReflectFailure = true;
            }
            if (!this.isReflectFailure) {
                try {
                    Class<?> cls3 = Class.forName("com.tencent.bugly.beta.tinker.TinkerApplicationLike", false, getClassLoader());
                    String str2 = "replaceApplicationLike delegateClass:" + cls3;
                    ShareReflectUtil.findField(cls3, "application").set(cls3.getDeclaredMethod("getTinkerPatchApplicationLike", new Class[0]).invoke(cls3, new Object[0]), this.realApplication);
                } catch (Throwable th2) {
                    String str3 = "replaceApplicationLike exception:" + th2.getMessage();
                }
            }
        }
        super.onCreate();
        Application application2 = this.realApplication;
        if (application2 != null) {
            application2.onCreate();
        }
    }

    public void onLowMemory() {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.onLowMemory();
        } else {
            application.onLowMemory();
        }
    }

    public void onTerminate() {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.onTerminate();
        } else {
            application.onTerminate();
        }
    }

    @TargetApi(14)
    public void onTrimMemory(int i2) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.onTrimMemory(i2);
        } else {
            application.onTrimMemory(i2);
        }
    }

    @TargetApi(14)
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @TargetApi(14)
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.registerComponentCallbacks(componentCallbacks);
        } else {
            application.registerComponentCallbacks(componentCallbacks);
        }
    }

    @TargetApi(18)
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.registerOnProvideAssistDataListener(onProvideAssistDataListener);
        } else {
            application.registerOnProvideAssistDataListener(onProvideAssistDataListener);
        }
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Application application;
        return (!this.isReflectFailure || (application = this.realApplication) == null) ? super.registerReceiver(broadcastReceiver, intentFilter) : application.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void unbindService(ServiceConnection serviceConnection) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.unbindService(serviceConnection);
        } else {
            application.unbindService(serviceConnection);
        }
    }

    @TargetApi(14)
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @TargetApi(14)
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.unregisterComponentCallbacks(componentCallbacks);
        } else {
            application.unregisterComponentCallbacks(componentCallbacks);
        }
    }

    @TargetApi(18)
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
        } else {
            application.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Application application;
        if (!this.isReflectFailure || (application = this.realApplication) == null) {
            super.unregisterReceiver(broadcastReceiver);
        } else {
            application.unregisterReceiver(broadcastReceiver);
        }
    }
}
