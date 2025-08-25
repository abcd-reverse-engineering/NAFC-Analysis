package com.lxj.easyadapter;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.accs.utl.BaseMonitor;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.List;

/* compiled from: EasyAdapter.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0006H$¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/lxj/easyadapter/EasyAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lxj/easyadapter/MultiItemTypeAdapter;", "data", "", "mLayoutId", "", "(Ljava/util/List;I)V", "getMLayoutId", "()I", "setMLayoutId", "(I)V", BaseMonitor.ALARM_POINT_BIND, "", "holder", "Lcom/lxj/easyadapter/ViewHolder;", "t", "position", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;I)V", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes.dex */
public abstract class EasyAdapter<T> extends MultiItemTypeAdapter<T> {

    /* renamed from: i, reason: collision with root package name */
    private int f7872i;

    /* compiled from: EasyAdapter.kt */
    public static final class a implements b<T> {
        a() {
        }

        @Override // com.lxj.easyadapter.b
        public int a() {
            return EasyAdapter.this.g();
        }

        @Override // com.lxj.easyadapter.b
        public boolean a(T t, int i2) {
            return true;
        }

        @Override // com.lxj.easyadapter.b
        public void a(@d ViewHolder viewHolder, T t, int i2) {
            i0.f(viewHolder, "holder");
            EasyAdapter.this.a(viewHolder, (ViewHolder) t, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EasyAdapter(@d List<? extends T> list, int i2) {
        super(list);
        i0.f(list, "data");
        this.f7872i = i2;
        a(new a());
    }

    protected abstract void a(@d ViewHolder viewHolder, T t, int i2);

    protected final void b(int i2) {
        this.f7872i = i2;
    }

    protected final int g() {
        return this.f7872i;
    }
}
