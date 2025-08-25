package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: JsonElement.java */
/* loaded from: classes.dex */
public abstract class k {
    @Deprecated
    public k() {
    }

    public abstract k deepCopy();

    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    @Deprecated
    public char getAsCharacter() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public h getAsJsonArray() {
        if (isJsonArray()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m getAsJsonNull() {
        if (isJsonNull()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public JsonObject getAsJsonObject() {
        if (isJsonObject()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public p getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (p) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean isJsonArray() {
        return this instanceof h;
    }

    public boolean isJsonNull() {
        return this instanceof m;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof p;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.e0.d dVar = new com.google.gson.e0.d(stringWriter);
            dVar.b(true);
            com.google.gson.b0.o.a(this, dVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
