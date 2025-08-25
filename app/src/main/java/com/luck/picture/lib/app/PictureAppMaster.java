package com.luck.picture.lib.app;

import android.content.Context;

/* loaded from: classes.dex */
public class PictureAppMaster implements IApp {
    private static PictureAppMaster mInstance;
    private IApp app;

    private PictureAppMaster() {
    }

    public static PictureAppMaster getInstance() {
        if (mInstance == null) {
            synchronized (PictureAppMaster.class) {
                if (mInstance == null) {
                    mInstance = new PictureAppMaster();
                }
            }
        }
        return mInstance;
    }

    public IApp getApp() {
        return this.app;
    }

    @Override // com.luck.picture.lib.app.IApp
    public Context getAppContext() {
        IApp iApp = this.app;
        if (iApp == null) {
            return null;
        }
        return iApp.getAppContext();
    }

    public void setApp(IApp iApp) {
        this.app = iApp;
    }
}
