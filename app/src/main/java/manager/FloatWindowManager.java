package manager;

import android.view.View;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class FloatWindowManager implements IFloatingWindowMgr {
    private static FloatWindowManager sFWManager;
    private List<IFloatingWindow> mWindows = new LinkedList();

    private FloatWindowManager() {
    }

    public static FloatWindowManager getFWManager() {
        if (sFWManager == null) {
            sFWManager = new FloatWindowManager();
        }
        return sFWManager;
    }

    @Override // manager.IFloatingWindowMgr
    public List<IFloatingWindow> getAllWindow() {
        return this.mWindows;
    }

    public boolean haveWindow() {
        return this.mWindows.size() > 0;
    }

    @Override // manager.IFloatingWindowMgr
    public void hideWindow(IFloatingWindow iFloatingWindow) {
        if (iFloatingWindow != null) {
            try {
                if (iFloatingWindow.isShowing()) {
                    WindowManager windowManager = (WindowManager) iFloatingWindow.getContext().getSystemService("window");
                    View contentView = iFloatingWindow.getContentView();
                    if (windowManager != null) {
                        windowManager.removeView(contentView);
                    }
                    if (this.mWindows.contains(iFloatingWindow)) {
                        this.mWindows.remove(iFloatingWindow);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // manager.IFloatingWindowMgr
    public void removeAllWindow() {
        try {
            if (haveWindow()) {
                Iterator<IFloatingWindow> it = this.mWindows.iterator();
                while (it.hasNext()) {
                    IFloatingWindow next = it.next();
                    it.remove();
                    next.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // manager.IFloatingWindowMgr
    public boolean showWindow(IFloatingWindow iFloatingWindow) {
        if (iFloatingWindow == null) {
            return false;
        }
        try {
            WindowManager windowManager = (WindowManager) iFloatingWindow.getContext().getSystemService("window");
            View contentView = iFloatingWindow.getContentView();
            WindowManager.LayoutParams layoutParams = iFloatingWindow.getLayoutParams();
            if (windowManager == null || iFloatingWindow.isShowing() || contentView == null || layoutParams == null) {
                return false;
            }
            contentView.setFitsSystemWindows(true);
            windowManager.addView(contentView, layoutParams);
            this.mWindows.add(iFloatingWindow);
            return true;
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }
}
