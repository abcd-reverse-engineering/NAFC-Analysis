package com.umeng.message.tag;

import android.app.Application;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.ar;
import com.umeng.message.proguard.av;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.d;
import com.umeng.message.proguard.e;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.x;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TagManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile TagManager f11486b;

    /* renamed from: a, reason: collision with root package name */
    private final ITagManager f11487a = new ar();

    @Deprecated
    public interface TCallBack extends UPushTagCallback<ITagManager.Result> {
    }

    @Deprecated
    public interface TagListCallBack extends UPushTagCallback<List<String>> {
    }

    private TagManager() {
    }

    static /* synthetic */ boolean b() {
        boolean z = MessageSharedPrefs.getInstance(x.a()).f11128b.b("tag_send_policy", -1) == 1;
        if (z) {
            UPLog.d("TagManager", "tag server disable!");
        }
        return z;
    }

    static /* synthetic */ JSONObject d() throws JSONException {
        Application applicationA = x.a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("utdid", d.o(applicationA));
        jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(applicationA).k());
        jSONObject.put("ts", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ITagManager.Result e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", ITagManager.SUCCESS);
            jSONObject.put("remain", MessageSharedPrefs.getInstance(x.a()).d());
        } catch (Exception e2) {
            UPLog.e("TagManager", e2);
        }
        return new ITagManager.Result(jSONObject);
    }

    public static TagManager getInstance() {
        if (f11486b == null) {
            synchronized (TagManager.class) {
                if (f11486b == null) {
                    f11486b = new TagManager();
                }
            }
        }
        return f11486b;
    }

    public void addTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        b.b(new Runnable() { // from class: com.umeng.message.tag.TagManager.1
            @Override // java.lang.Runnable
            public final void run() {
                ITagManager.Result result = new ITagManager.Result();
                boolean z = false;
                try {
                    if (strArr != null && strArr.length != 0) {
                        if (TagManager.a()) {
                            UPLog.e("TagManager", "No utdid or device_token");
                            result.setErrors("No utdid or device_token");
                            try {
                                return;
                            } catch (Throwable th) {
                                return;
                            }
                        }
                        if (TagManager.b()) {
                            UPLog.e("TagManager", "Tag api is disabled by the server");
                            result.setErrors("Tag api is disabled by the server");
                            try {
                                uPushTagCallback.onMessage(false, result);
                                return;
                            } catch (Throwable th2) {
                                UPLog.e("TagManager", th2);
                                return;
                            }
                        }
                        Application applicationA = x.a();
                        ArrayList arrayList = new ArrayList();
                        Set<String> setB = MessageSharedPrefs.getInstance(applicationA).f11128b.b(SocializeProtocolConstants.TAGS, new HashSet());
                        for (String str : strArr) {
                            if (!setB.contains(str) && !arrayList.contains(str)) {
                                byte[] bytes = str.getBytes();
                                if (bytes == null || bytes.length > 128 || bytes.length <= 0) {
                                    UPLog.e("TagManager", "tag length must be 1~128 byte");
                                    result.setErrors("tag length must be 1~128 byte");
                                    try {
                                        uPushTagCallback.onMessage(false, result);
                                        return;
                                    } catch (Throwable th3) {
                                        UPLog.e("TagManager", th3);
                                        return;
                                    }
                                }
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() > MessageSharedPrefs.getInstance(applicationA).d()) {
                            UPLog.e("TagManager", "tag count limit");
                            result.setErrors("tag count limit");
                            try {
                                uPushTagCallback.onMessage(false, result);
                                return;
                            } catch (Throwable th4) {
                                UPLog.e("TagManager", th4);
                                return;
                            }
                        }
                        if (!MessageSharedPrefs.getInstance(applicationA).a("tag_add_")) {
                            UPLog.e("TagManager", "interval limit");
                            result.setErrors("interval limit");
                            try {
                                uPushTagCallback.onMessage(false, result);
                                return;
                            } catch (Throwable th5) {
                                UPLog.e("TagManager", th5);
                                return;
                            }
                        }
                        if (arrayList.size() == 0) {
                            try {
                                uPushTagCallback.onMessage(true, TagManager.e());
                                return;
                            } catch (Throwable th6) {
                                UPLog.e("TagManager", th6);
                                return;
                            }
                        }
                        try {
                            JSONObject jSONObjectD = TagManager.d();
                            jSONObjectD.put(SocializeProtocolConstants.TAGS, av.a(arrayList));
                            result = TagManager.this.f11487a.addTags(jSONObjectD, strArr);
                            z = true;
                        } catch (Exception e2) {
                            UPLog.e("TagManager", e2);
                        }
                        try {
                            uPushTagCallback.onMessage(z, result);
                            return;
                        } catch (Throwable th7) {
                            UPLog.e("TagManager", th7);
                            return;
                        }
                    }
                    UPLog.e("TagManager", "No tags");
                    result.setErrors("No tags");
                    try {
                        uPushTagCallback.onMessage(false, result);
                    } catch (Throwable th8) {
                        UPLog.e("TagManager", th8);
                    }
                } catch (Throwable th9) {
                    try {
                        UPLog.e("TagManager", th9);
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th10) {
                            UPLog.e("TagManager", th10);
                        }
                    } finally {
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th11) {
                            UPLog.e("TagManager", th11);
                        }
                    }
                }
            }
        });
    }

    public void deleteTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        b.b(new Runnable() { // from class: com.umeng.message.tag.TagManager.2
            @Override // java.lang.Runnable
            public final void run() {
                int i2;
                ITagManager.Result result = new ITagManager.Result();
                boolean z = false;
                try {
                    Application applicationA = x.a();
                    if (strArr != null && strArr.length > 0) {
                        String[] strArr2 = strArr;
                        int length = strArr2.length;
                        while (i2 < length) {
                            byte[] bytes = strArr2[i2].getBytes();
                            i2 = (bytes != null && bytes.length <= 128 && bytes.length > 0) ? i2 + 1 : 0;
                            result.setErrors("tag length must be 1~128 byte.");
                            try {
                                return;
                            } catch (Throwable th) {
                                return;
                            }
                        }
                    }
                    if (!MessageSharedPrefs.getInstance(applicationA).a("tag_del_")) {
                        UPLog.e("TagManager", "interval limit");
                        result.setErrors("interval limit");
                        try {
                            uPushTagCallback.onMessage(false, result);
                            return;
                        } catch (Throwable th2) {
                            UPLog.e("TagManager", th2);
                            return;
                        }
                    }
                    if (TagManager.b()) {
                        result.setErrors("tag server disable.");
                        try {
                            uPushTagCallback.onMessage(false, result);
                            return;
                        } catch (Throwable th3) {
                            UPLog.e("TagManager", th3);
                            return;
                        }
                    }
                    if (TagManager.a()) {
                        result.setErrors("check request failed.");
                        try {
                            uPushTagCallback.onMessage(false, result);
                            return;
                        } catch (Throwable th4) {
                            UPLog.e("TagManager", th4);
                            return;
                        }
                    }
                    if (strArr == null || strArr.length == 0) {
                        UPLog.e("TagManager", "No tags.");
                        result.setErrors("No tags.");
                        try {
                            uPushTagCallback.onMessage(true, result);
                            return;
                        } catch (Throwable th5) {
                            UPLog.e("TagManager", th5);
                            return;
                        }
                    }
                    try {
                        JSONObject jSONObjectD = TagManager.d();
                        String[] strArr3 = strArr;
                        jSONObjectD.put(SocializeProtocolConstants.TAGS, strArr3 == null ? "" : av.a(Arrays.asList(strArr3)));
                        result = TagManager.this.f11487a.deleteTags(jSONObjectD, strArr);
                        z = true;
                    } catch (Exception e2) {
                        UPLog.e("TagManager", e2);
                    }
                    try {
                        uPushTagCallback.onMessage(z, result);
                    } catch (Throwable th6) {
                        UPLog.e("TagManager", th6);
                    }
                } catch (Throwable th7) {
                    try {
                        UPLog.e("TagManager", th7);
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th8) {
                            UPLog.e("TagManager", th8);
                        }
                    } finally {
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th9) {
                            UPLog.e("TagManager", th9);
                        }
                    }
                }
            }
        });
    }

    public void getTags(final UPushTagCallback<List<String>> uPushTagCallback) {
        b.b(new Runnable() { // from class: com.umeng.message.tag.TagManager.3
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                try {
                    if (!MessageSharedPrefs.getInstance(x.a()).a("tag_add_")) {
                        UPLog.e("TagManager", "interval limit");
                        try {
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    if (TagManager.b()) {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                            return;
                        } catch (Throwable th2) {
                            UPLog.e("TagManager", th2);
                            return;
                        }
                    }
                    if (TagManager.a()) {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                            return;
                        } catch (Throwable th3) {
                            UPLog.e("TagManager", th3);
                            return;
                        }
                    }
                    try {
                        List<String> tags = TagManager.this.f11487a.getTags(TagManager.d());
                        if (tags != null && tags.size() > 0) {
                            arrayList.addAll(tags);
                        }
                        z = true;
                    } catch (Exception e2) {
                        UPLog.e("TagManager", "getTags error:", e2);
                    }
                    try {
                        uPushTagCallback.onMessage(z, arrayList);
                    } catch (Throwable th4) {
                        UPLog.e("TagManager", th4);
                    }
                } catch (Throwable th5) {
                    try {
                        UPLog.e("TagManager", th5);
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                        } catch (Throwable th6) {
                            UPLog.e("TagManager", th6);
                        }
                    } finally {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                        } catch (Throwable th7) {
                            UPLog.e("TagManager", th7);
                        }
                    }
                }
            }
        });
    }

    static /* synthetic */ boolean a() {
        if (TextUtils.isEmpty(d.o(x.a()))) {
            UPLog.e("TagManager", "utdid empty.");
            return true;
        }
        if (f.b()) {
            UPLog.d("TagManager", "check tag failed, silent mode!");
            return true;
        }
        if (!TextUtils.isEmpty(PushAgent.getInstance(x.a()).getRegistrationId())) {
            return false;
        }
        UPLog.e("TagManager", "deviceToken empty.");
        return true;
    }
}
