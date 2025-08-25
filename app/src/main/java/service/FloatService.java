package service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes2.dex */
public class FloatService extends AccessibilityService {

    /* renamed from: a, reason: collision with root package name */
    private static AccessibilityService f17551a;

    public FloatService() {
        f17551a = this;
    }

    public static AccessibilityService a() {
        AccessibilityService accessibilityService = f17551a;
        if (accessibilityService == null) {
            return null;
        }
        return accessibilityService;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }
}
