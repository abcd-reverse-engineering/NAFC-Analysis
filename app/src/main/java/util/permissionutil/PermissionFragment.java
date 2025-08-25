package util.permissionutil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PermissionFragment extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    private static final int f20904c = 1;

    /* renamed from: a, reason: collision with root package name */
    Activity f20905a;

    /* renamed from: b, reason: collision with root package name */
    private b f20906b;

    private void b() {
        b bVar = this.f20906b;
        if (bVar != null) {
            bVar.onGranted();
        }
    }

    public void a(b bVar) {
        this.f20906b = bVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f20905a = getActivity();
    }

    @Override // android.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // android.app.Fragment
    @RequiresApi(api = 23)
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 1) {
            return;
        }
        try {
            if (iArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    if (iArr[i3] != 0) {
                        arrayList.add(strArr[i3]);
                    }
                }
                if (arrayList.isEmpty()) {
                    b();
                    return;
                }
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!shouldShowRequestPermissionRationale(it.next())) {
                        b(arrayList);
                        return;
                    }
                }
                a(arrayList);
            }
        } catch (Exception unused) {
        }
    }

    public Activity a() {
        Activity activity = this.f20905a;
        return activity == null ? ui.c.i().h() : activity;
    }

    private void b(List<String> list) {
        b bVar = this.f20906b;
        if (bVar != null) {
            bVar.a(list);
        }
    }

    @TargetApi(23)
    public void a(@NonNull String[] strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(a(), str) != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                b();
            } else {
                requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1);
            }
        } catch (Error | Exception unused) {
        }
    }

    private void a(List<String> list) {
        b bVar = this.f20906b;
        if (bVar != null) {
            bVar.b(list);
        }
    }
}
