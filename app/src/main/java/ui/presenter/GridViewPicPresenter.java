package ui.presenter;

import adapter.PicturePreviewAdapter;
import android.app.Activity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadFileBean;
import java.util.ArrayList;
import java.util.List;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class GridViewPicPresenter extends ModelPresent {
    private PicturePreviewAdapter mAdapter;
    private List<UploadFileBean> mPics;

    public GridViewPicPresenter(Activity activity) {
        super(activity, (BaseView) null);
        this.mPics = new ArrayList();
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, 4));
        this.mAdapter = new PicturePreviewAdapter(this.mActivity, this.mPics);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<UploadFileBean> list) {
        if (list != null) {
            this.mPics = list;
            this.mAdapter.setData(list);
        }
    }
}
