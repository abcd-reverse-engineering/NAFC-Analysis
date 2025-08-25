package interfaces;

import java.util.List;

/* loaded from: classes2.dex */
public interface PermissionsListener {
    void onDenied(List<String> list, boolean z);

    void onGranted();
}
