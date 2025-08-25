package g.a.u0;

/* compiled from: SubscriptionDisposable.java */
/* loaded from: classes2.dex */
final class i extends f<i.d.d> {
    private static final long serialVersionUID = -707001650852963139L;

    i(i.d.d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.a.u0.f
    public void onDisposed(@g.a.t0.f i.d.d dVar) {
        dVar.cancel();
    }
}
