package com.google.gson.b0.q;

import com.google.gson.t;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;

/* compiled from: NumberTypeAdapter.java */
/* loaded from: classes.dex */
public final class i extends y<Number> {

    /* renamed from: b, reason: collision with root package name */
    private static final z f5574b = b(w.LAZILY_PARSED_NUMBER);

    /* renamed from: a, reason: collision with root package name */
    private final x f5575a;

    /* compiled from: NumberTypeAdapter.java */
    class a implements z {
        a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.getRawType() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    /* compiled from: NumberTypeAdapter.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5577a = new int[com.google.gson.e0.c.values().length];

        static {
            try {
                f5577a[com.google.gson.e0.c.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5577a[com.google.gson.e0.c.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5577a[com.google.gson.e0.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private i(x xVar) {
        this.f5575a = xVar;
    }

    public static z a(x xVar) {
        return xVar == w.LAZILY_PARSED_NUMBER ? f5574b : b(xVar);
    }

    private static z b(x xVar) {
        return new i(xVar).new a();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.y
    /* renamed from: read */
    public Number read2(com.google.gson.e0.a aVar) throws IOException {
        com.google.gson.e0.c cVarPeek = aVar.peek();
        int i2 = b.f5577a[cVarPeek.ordinal()];
        if (i2 == 1) {
            aVar.r();
            return null;
        }
        if (i2 == 2 || i2 == 3) {
            return this.f5575a.readNumber(aVar);
        }
        throw new t("Expecting number, got: " + cVarPeek + "; at path " + aVar.h());
    }

    @Override // com.google.gson.y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
        dVar.a(number);
    }
}
