package com.google.gson;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ToNumberPolicy.java */
/* loaded from: classes.dex */
public abstract class w implements x {
    public static final w DOUBLE = new a("DOUBLE", 0);
    public static final w LAZILY_PARSED_NUMBER = new w("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.w.b
        {
            a aVar = null;
        }

        @Override // com.google.gson.x
        public Number readNumber(com.google.gson.e0.a aVar) throws IOException {
            return new com.google.gson.b0.h(aVar.s());
        }
    };
    public static final w LONG_OR_DOUBLE = new w("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.w.c
        {
            a aVar = null;
        }

        @Override // com.google.gson.x
        public Number readNumber(com.google.gson.e0.a aVar) throws n, IOException, NumberFormatException {
            String strS = aVar.s();
            try {
                try {
                    return Long.valueOf(Long.parseLong(strS));
                } catch (NumberFormatException unused) {
                    Double dValueOf = Double.valueOf(strS);
                    if ((!dValueOf.isInfinite() && !dValueOf.isNaN()) || aVar.k()) {
                        return dValueOf;
                    }
                    throw new com.google.gson.e0.e("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.i());
                }
            } catch (NumberFormatException e2) {
                throw new n("Cannot parse " + strS + "; at path " + aVar.i(), e2);
            }
        }
    };
    public static final w BIG_DECIMAL = new w("BIG_DECIMAL", 3) { // from class: com.google.gson.w.d
        {
            a aVar = null;
        }

        @Override // com.google.gson.x
        public BigDecimal readNumber(com.google.gson.e0.a aVar) throws IOException {
            String strS = aVar.s();
            try {
                return new BigDecimal(strS);
            } catch (NumberFormatException e2) {
                throw new n("Cannot parse " + strS + "; at path " + aVar.i(), e2);
            }
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ w[] f5759a = {DOUBLE, LAZILY_PARSED_NUMBER, LONG_OR_DOUBLE, BIG_DECIMAL};

    /* compiled from: ToNumberPolicy.java */
    enum a extends w {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.gson.x
        public Double readNumber(com.google.gson.e0.a aVar) throws IOException {
            return Double.valueOf(aVar.n());
        }
    }

    private w(String str, int i2) {
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) f5759a.clone();
    }

    /* synthetic */ w(String str, int i2, a aVar) {
        this(str, i2);
    }
}
