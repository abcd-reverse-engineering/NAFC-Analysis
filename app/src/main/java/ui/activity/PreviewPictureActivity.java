package ui.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.widget.PreviewViewPager;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;

/* loaded from: classes2.dex */
public class PreviewPictureActivity extends BaseActivity {

    /* renamed from: e, reason: collision with root package name */
    public static final int f18538e = 1000;

    /* renamed from: f, reason: collision with root package name */
    public static final String f18539f = "extra_pic";

    /* renamed from: g, reason: collision with root package name */
    public static final String f18540g = "extra_position";

    /* renamed from: h, reason: collision with root package name */
    public static final String f18541h = "extra_sum";

    /* renamed from: i, reason: collision with root package name */
    public static final String f18542i = "extra_path";

    /* renamed from: a, reason: collision with root package name */
    private TextView f18543a;

    /* renamed from: b, reason: collision with root package name */
    private PreviewViewPager f18544b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList f18545c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<LocalMedia> f18546d;

    class a extends PagerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private List<View> f18547a;

        public a(List<View> list) {
            this.f18547a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(this.f18547a.get(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f18547a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            View view = this.f18547a.get(i2);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.preview_image);
            j.b bVarA = j.b.a();
            PreviewPictureActivity previewPictureActivity = PreviewPictureActivity.this;
            bVarA.loadImage(previewPictureActivity.mActivity, ((LocalMedia) previewPictureActivity.f18546d.get(i2)).getPath(), photoView);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, false);
        this.f18543a = (TextView) findViewById(R.id.tv_title);
        this.f18544b = (PreviewViewPager) findViewById(R.id.view_pager);
        this.f18543a.setText("预览");
        a();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.picture_anim_fade_in, R.anim.picture_anim_exit);
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        if (!Hicore.getApp().isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        overridePendingTransition(R.anim.picture_anim_enter, R.anim.picture_anim_fade_in);
        return R.layout.dialog_preview_picture;
    }

    private void a() {
        this.f18546d = getIntent().getParcelableArrayListExtra(f18539f);
        List<LocalMedia> list = this.f18546d;
        if (list != null) {
            if (list.size() > 0) {
                a(getIntent().getIntExtra(f18540g, 0));
                return;
            } else {
                a(0);
                return;
            }
        }
        String stringExtra = getIntent().getStringExtra(f18542i);
        this.f18546d = new ArrayList();
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(stringExtra);
        this.f18546d.add(localMedia);
        a(0);
    }

    private void a(int i2) {
        for (int i3 = 0; i3 < this.f18546d.size(); i3++) {
            this.f18545c.add(LayoutInflater.from(this).inflate(R.layout.pic_preview, (ViewGroup) null));
        }
        this.f18544b.setAdapter(new a(this.f18545c));
        this.f18544b.setCurrentItem(i2);
    }
}
