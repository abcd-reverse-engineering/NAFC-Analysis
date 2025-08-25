package manager;

import java.util.List;

/* loaded from: classes2.dex */
public interface IFloatingWindowMgr {
    List<IFloatingWindow> getAllWindow();

    void hideWindow(IFloatingWindow iFloatingWindow);

    void removeAllWindow();

    boolean showWindow(IFloatingWindow iFloatingWindow);
}
