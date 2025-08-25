package com.hihonor.honorid;

import com.hihonor.honorid.UseCase;

/* compiled from: UseCaseHandler.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final c f6101a;

    /* compiled from: UseCaseHandler.java */
    private static final class a implements UseCase.a {
        public a(UseCase.a aVar, b bVar) {
        }
    }

    /* compiled from: UseCaseHandler.java */
    /* renamed from: com.hihonor.honorid.b$b, reason: collision with other inner class name */
    static final class RunnableC0101b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        UseCase f6102a;

        RunnableC0101b(UseCase useCase) {
            this.f6102a = useCase;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6102a.a();
        }
    }

    public b(c cVar) {
        this.f6101a = cVar;
    }

    public <T extends UseCase.RequestValues> void a(UseCase<T> useCase, T t, UseCase.a aVar) {
        useCase.b(t);
        useCase.a(new a(aVar, this));
        this.f6101a.execute(new RunnableC0101b(useCase));
    }
}
