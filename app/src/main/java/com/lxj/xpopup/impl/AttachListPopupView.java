package com.lxj.xpopup.impl;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.R;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.e.f;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class AttachListPopupView extends AttachPopupView {
    protected int A;
    protected int B;
    String[] C;
    int[] D;
    private f E;
    RecyclerView z;

    class a extends EasyAdapter<String> {
        a(List list, int i2) {
            super(list, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lxj.easyadapter.EasyAdapter
        public void a(@NonNull ViewHolder viewHolder, @NonNull String str, int i2) {
            viewHolder.a(R.id.tv_text, str);
            int[] iArr = AttachListPopupView.this.D;
            if (iArr == null || iArr.length <= i2) {
                viewHolder.a(R.id.iv_image).setVisibility(8);
            } else {
                viewHolder.a(R.id.iv_image).setVisibility(0);
                viewHolder.a(R.id.iv_image).setBackgroundResource(AttachListPopupView.this.D[i2]);
            }
        }
    }

    class b extends MultiItemTypeAdapter.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EasyAdapter f8079a;

        b(EasyAdapter easyAdapter) {
            this.f8079a = easyAdapter;
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.c, com.lxj.easyadapter.MultiItemTypeAdapter.b
        public void a(View view, RecyclerView.ViewHolder viewHolder, int i2) {
            if (AttachListPopupView.this.E != null) {
                AttachListPopupView.this.E.a(i2, (String) this.f8079a.a().get(i2));
            }
            if (AttachListPopupView.this.f7987a.f8030d.booleanValue()) {
                AttachListPopupView.this.b();
            }
        }
    }

    public AttachListPopupView(@NonNull Context context) {
        super(context);
    }

    public AttachListPopupView b(int i2) {
        this.A = i2;
        return this;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.A;
        return i2 == 0 ? R.layout._xpopup_attach_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        this.z = (RecyclerView) findViewById(R.id.recyclerView);
        List listAsList = Arrays.asList(this.C);
        int i2 = this.B;
        if (i2 == 0) {
            i2 = R.layout._xpopup_adapter_text;
        }
        a aVar = new a(listAsList, i2);
        aVar.setOnItemClickListener(new b(aVar));
        this.z.setAdapter(aVar);
    }

    public AttachListPopupView a(int i2) {
        this.B = i2;
        return this;
    }

    public AttachListPopupView a(String[] strArr, int[] iArr) {
        this.C = strArr;
        this.D = iArr;
        return this;
    }

    public AttachListPopupView a(int i2, int i3) {
        this.q += i2;
        this.p += i3;
        return this;
    }

    public AttachListPopupView a(f fVar) {
        this.E = fVar;
        return this;
    }
}
