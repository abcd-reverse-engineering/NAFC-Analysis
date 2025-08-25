package c.c.a.a;

import com.hihonor.cloudservice.support.api.client.Status;

/* compiled from: ApiException.java */
/* loaded from: classes.dex */
public class a extends Exception {

    /* renamed from: a, reason: collision with root package name */
    protected final Status f3081a;

    public a(Status status) {
        super(status.b());
        this.f3081a = status;
    }

    public int getStatusCode() {
        return this.f3081a.c();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.f3081a.d();
    }
}
