package adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;

/* compiled from: AppExSelectedAdapter.java */
/* loaded from: classes.dex */
public class f extends BaseExpandableListAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f1369a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f1370b;

    /* renamed from: c, reason: collision with root package name */
    private List<List<AppInfoBean>> f1371c;

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f1372d;

    /* compiled from: AppExSelectedAdapter.java */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        ImageView f1373a;

        /* renamed from: b, reason: collision with root package name */
        TextView f1374b;

        /* renamed from: c, reason: collision with root package name */
        TextView f1375c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f1376d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f1377e;

        public a(View view) {
            this.f1373a = (ImageView) view.findViewById(R.id.app_icon);
            this.f1374b = (TextView) view.findViewById(R.id.tv_app_name);
            this.f1375c = (TextView) view.findViewById(R.id.tv_app_version);
            this.f1376d = (ImageView) view.findViewById(R.id.iv_checkbox);
            this.f1377e = (ImageView) view.findViewById(R.id.iv_checkbox2);
        }
    }

    public f(Context context, List<String> list, ArrayList<List<AppInfoBean>> arrayList) {
        this.f1369a = context;
        this.f1370b = list;
        this.f1371c = arrayList;
        this.f1372d = LayoutInflater.from(context);
    }

    public void a(List<String> list, List<List<AppInfoBean>> list2) {
        this.f1370b = list;
        this.f1371c = list2;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i2, int i3) {
        return this.f1371c.get(i2).get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i2, int i3) {
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        AppInfoBean appInfoBean = this.f1371c.get(i2).get(i3);
        if (view == null) {
            view = this.f1372d.inflate(R.layout.recyclerview_app_select, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Drawable appIcon = appInfoBean.getAppIcon();
        if (appIcon != null) {
            aVar.f1373a.setImageDrawable(appIcon);
        }
        aVar.f1374b.setText(appInfoBean.getName());
        String fileSize = Formatter.formatFileSize(Hicore.getApp(), appInfoBean.getFileSize());
        aVar.f1375c.setText("版本:" + appInfoBean.getVersionCode() + "  |  " + fileSize);
        if (appInfoBean.getFileSize() > 209715200) {
            aVar.f1376d.setVisibility(8);
            aVar.f1377e.setVisibility(0);
        } else if (appInfoBean.isSelect()) {
            aVar.f1376d.setImageResource(R.mipmap.checkbox_checked);
            aVar.f1376d.setVisibility(0);
            aVar.f1377e.setVisibility(8);
        } else {
            aVar.f1376d.setImageResource(R.mipmap.checkbox_unchecked);
            aVar.f1376d.setVisibility(0);
            aVar.f1377e.setVisibility(8);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i2) {
        return this.f1371c.get(i2).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i2) {
        return this.f1370b.get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f1370b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1372d.inflate(R.layout.app_select_tip, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.tv_lable)).setText(this.f1370b.get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }
}
