package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public class Service {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f6415a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f6416b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6417c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6418d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6419e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6420f;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        Class<?> f6421a;

        /* renamed from: b, reason: collision with root package name */
        Class<?> f6422b;

        /* renamed from: c, reason: collision with root package name */
        Object f6423c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6424d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6425e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f6426f;

        public Service build() {
            Class<?> cls = this.f6421a;
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
            Class<?> cls2 = this.f6422b;
            if (cls2 == null) {
                Object obj = this.f6423c;
                if (obj == null) {
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                }
                Service service2 = new Service(cls, obj);
                service2.f6418d = this.f6424d;
                return service2;
            }
            if (cls2.isInterface() || !Modifier.isPublic(this.f6422b.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
            }
            Service service3 = new Service((Class) this.f6421a, (Class) this.f6422b);
            service3.f6418d = this.f6424d;
            service3.f6419e = this.f6425e;
            service3.f6420f = this.f6426f;
            return service3;
        }

        public Builder isAutoCreated(boolean z) {
            this.f6426f = z;
            return this;
        }

        public Builder isSharedInstance(boolean z) {
            this.f6425e = z;
            return this;
        }

        public Builder isSingleton(boolean z) {
            this.f6424d = z;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.f6422b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f6421a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f6423c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f6415a = cls;
        this.f6416b = cls2;
        this.f6417c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.f6415a = cls;
        this.f6416b = null;
        this.f6417c = obj;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.f6417c;
    }

    public Class<?> getInterface() {
        return this.f6415a;
    }

    public Class<?> getType() {
        return this.f6416b;
    }

    public boolean isAutoCreated() {
        return this.f6420f;
    }

    public boolean isSharedInstance() {
        return this.f6419e;
    }

    public boolean isSingleton() {
        return this.f6418d;
    }
}
