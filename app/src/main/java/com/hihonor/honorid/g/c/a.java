package com.hihonor.honorid.g.c;

import android.content.Context;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.usecase.WriteHnAccountUseCase;
import java.util.ArrayList;
import k.a.a.a.i.c;
import k.a.a.a.j.e;

/* compiled from: SDKAccountManager.java */
/* loaded from: classes.dex */
public final class a implements com.hihonor.honorid.g.b {

    /* renamed from: a, reason: collision with root package name */
    private static a f6230a;

    private a() {
    }

    public static synchronized a b(Context context) {
        if (f6230a == null) {
            e.a(context);
            a aVar = new a();
            f6230a = aVar;
            aVar.c(context);
        }
        return f6230a;
    }

    private void c(Context context) {
        e.b("SDKAccountManager", "init SDKAccountManager", true);
        c.a(context);
    }

    @Override // com.hihonor.honorid.g.b
    public boolean a(Context context, HonorAccount honorAccount) {
        if (!com.hihonor.honorid.f.a.a(honorAccount)) {
            e.b("SDKAccountManager", "the account is invalid , cannot be added into file", true);
            return false;
        }
        com.hihonor.honorid.h.a.a(context).a(honorAccount);
        ArrayList arrayList = new ArrayList();
        arrayList.add(honorAccount);
        new com.hihonor.honorid.b(com.hihonor.honorid.e.a()).a(new WriteHnAccountUseCase(context, arrayList, true), new WriteHnAccountUseCase.RequestValues(honorAccount.c()), null);
        return true;
    }

    @Override // com.hihonor.honorid.g.b
    public ArrayList<HonorAccount> a(Context context) throws Throwable {
        e.b("SDKAccountManager", "MemCache has no account,parse from file", true);
        ArrayList<HonorAccount> arrayListA = b.a("accounts.xml", context, true);
        if (!arrayListA.isEmpty()) {
            com.hihonor.honorid.h.a.a(context).a(arrayListA.get(0));
        }
        return arrayListA;
    }
}
