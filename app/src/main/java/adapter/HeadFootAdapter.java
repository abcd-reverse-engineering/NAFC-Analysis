package adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class HeadFootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1280a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f1281b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f1282c = 2;

    public abstract View a();

    public abstract View b();

    public abstract int c();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (b() == null && a() == null) ? c() : (b() != null || a() == null) ? (b() == null || a() != null) ? c() + 2 : c() + 1 : c() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (b() == null || i2 != 0) {
            return (a() == null || i2 != getItemCount() - 1) ? 2 : 1;
        }
        return 0;
    }
}
