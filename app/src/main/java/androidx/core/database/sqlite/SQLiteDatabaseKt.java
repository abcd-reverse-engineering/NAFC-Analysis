package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import h.q2.s.l;
import h.q2.t.f0;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: SQLiteDatabase.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"transaction", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(@d SQLiteDatabase sQLiteDatabase, boolean z, @d l<? super SQLiteDatabase, ? extends T> lVar) {
        i0.f(sQLiteDatabase, "$receiver");
        i0.f(lVar, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T tInvoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return tInvoke;
        } finally {
            f0.b(1);
            sQLiteDatabase.endTransaction();
            f0.a(1);
        }
    }

    public static /* bridge */ /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        i0.f(sQLiteDatabase, "$receiver");
        i0.f(lVar, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objInvoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objInvoke;
        } finally {
            f0.b(1);
            sQLiteDatabase.endTransaction();
            f0.a(1);
        }
    }
}
