package com.umeng.socialize.common;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ResContainer {
    private static ResContainer R = null;
    private static String mPackageName = "";
    private Context context;
    private Map<String, SocializeResource> mResources;
    private Map<String, Integer> map = new HashMap();

    public static class SocializeResource {
        public int mId;
        public boolean mIsCompleted = false;
        public String mName;
        public String mType;

        public SocializeResource(String str, String str2) {
            this.mType = str;
            this.mName = str2;
        }
    }

    private ResContainer(Context context) {
        this.context = null;
        this.context = context.getApplicationContext();
    }

    public static synchronized ResContainer get(Context context) {
        if (R == null) {
            R = new ResContainer(context);
        }
        return R;
    }

    public static int getResourceId(Context context, String str, String str2) {
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(mPackageName)) {
            mPackageName = context.getPackageName();
        }
        int identifier = resources.getIdentifier(str2, str, mPackageName);
        if (identifier > 0) {
            return identifier;
        }
        throw new RuntimeException(UmengText.errorWithUrl(UmengText.resError(mPackageName, str, str2), UrlUtil.ALL_NO_RES));
    }

    public static String getString(Context context, String str) {
        return context.getString(getResourceId(context, "string", str));
    }

    public int anim(String str) {
        return getResourceId(this.context, "anim", str);
    }

    public synchronized Map<String, SocializeResource> batch() {
        if (this.mResources == null) {
            return this.mResources;
        }
        Iterator<String> it = this.mResources.keySet().iterator();
        while (it.hasNext()) {
            SocializeResource socializeResource = this.mResources.get(it.next());
            socializeResource.mId = getResourceId(this.context, socializeResource.mType, socializeResource.mName);
            socializeResource.mIsCompleted = true;
        }
        return this.mResources;
    }

    public int color(String str) {
        return getResourceId(this.context, RemoteMessageConst.Notification.COLOR, str);
    }

    public int dimen(String str) {
        return getResourceId(this.context, "dimen", str);
    }

    public int drawable(String str) {
        return getResourceId(this.context, "drawable", str);
    }

    public int id(String str) {
        return getResourceId(this.context, "id", str);
    }

    public int layout(String str) {
        return getResourceId(this.context, "layout", str);
    }

    public int raw(String str) {
        return getResourceId(this.context, "raw", str);
    }

    public int string(String str) {
        return getResourceId(this.context, "string", str);
    }

    public int style(String str) {
        return getResourceId(this.context, "style", str);
    }

    public int styleable(String str) {
        return getResourceId(this.context, "styleable", str);
    }

    public ResContainer(Context context, Map<String, SocializeResource> map) {
        this.context = null;
        this.mResources = map;
        this.context = context;
    }
}
