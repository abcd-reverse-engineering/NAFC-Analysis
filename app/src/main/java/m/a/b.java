package m.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: CameraConfigurationManager.java */
/* loaded from: classes2.dex */
final class b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f17253d = "CameraConfiguration";

    /* renamed from: a, reason: collision with root package name */
    private final Context f17254a;

    /* renamed from: b, reason: collision with root package name */
    private Point f17255b;

    /* renamed from: c, reason: collision with root package name */
    private Point f17256c;

    b(Context context) {
        this.f17254a = context;
    }

    @SuppressLint({"NewApi"})
    void a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.f17254a.getSystemService("window")).getDefaultDisplay();
        this.f17255b = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        String str = "Screen resolution: " + this.f17255b;
        Point point = new Point();
        Point point2 = this.f17255b;
        point.x = point2.x;
        point.y = point2.y;
        int i2 = point2.x;
        int i3 = point2.y;
        if (i2 < i3) {
            point.x = i3;
            point.y = point2.x;
        }
        this.f17256c = c.a(parameters, point);
        String str2 = "Camera resolution: " + this.f17256c;
    }

    Point b() {
        return this.f17255b;
    }

    void a(Camera camera, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            return;
        }
        String str = "Initial camera parameters: " + parameters.flatten();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f17254a);
        c.a(parameters, defaultSharedPreferences.getBoolean(zxing.android.f.f21138g, true), defaultSharedPreferences.getBoolean(zxing.android.f.f21139h, true), z);
        Point point = this.f17256c;
        parameters.setPreviewSize(point.x, point.y);
        a(camera, 90);
        String str2 = "Final camera parameters: " + parameters.flatten();
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f17256c;
            if (point2.x == previewSize.width && point2.y == previewSize.height) {
                return;
            }
            String str3 = "Camera said it supported preview size " + this.f17256c.x + 'x' + this.f17256c.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height;
            Point point3 = this.f17256c;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
    }

    void a(Camera camera, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
                method.invoke(camera, Integer.valueOf(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    Point a() {
        return this.f17256c;
    }
}
