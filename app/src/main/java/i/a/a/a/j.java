package i.a.a.a;

import java.util.Comparator;

/* compiled from: StringEncoderComparator.java */
/* loaded from: classes2.dex */
public class j implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private final i f16735a;

    public j() {
        this.f16735a = null;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            return ((Comparable) this.f16735a.encode(obj)).compareTo((Comparable) this.f16735a.encode(obj2));
        } catch (g unused) {
            return 0;
        }
    }

    public j(i iVar) {
        this.f16735a = iVar;
    }
}
