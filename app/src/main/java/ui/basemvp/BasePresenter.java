package ui.basemvp;

import ui.basemvp.BaseModel;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public class BasePresenter<V extends BaseView, T extends BaseModel> {
    protected T mModel;
    protected V mView;

    public void attachModel(T t) {
        this.mModel = t;
    }

    public void attachView(V v) {
        this.mView = v;
    }

    public void detachView() {
        this.mView = null;
    }

    public boolean isViewAttached() {
        return this.mView != null;
    }
}
