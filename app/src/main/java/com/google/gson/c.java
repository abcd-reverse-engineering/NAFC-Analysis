package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes.dex */
public abstract class c implements com.google.gson.d {
    public static final c IDENTITY = new a("IDENTITY", 0);
    public static final c UPPER_CAMEL_CASE = new c("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.c.b
        {
            a aVar = null;
        }

        @Override // com.google.gson.d
        public String translateName(Field field) {
            return c.upperCaseFirstLetter(field.getName());
        }
    };
    public static final c UPPER_CAMEL_CASE_WITH_SPACES = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.c.c
        {
            a aVar = null;
        }

        @Override // com.google.gson.d
        public String translateName(Field field) {
            return c.upperCaseFirstLetter(c.separateCamelCase(field.getName(), ' '));
        }
    };
    public static final c UPPER_CASE_WITH_UNDERSCORES = new c("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.c.d
        {
            a aVar = null;
        }

        @Override // com.google.gson.d
        public String translateName(Field field) {
            return c.separateCamelCase(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    };
    public static final c LOWER_CASE_WITH_UNDERSCORES = new c("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: com.google.gson.c.e
        {
            a aVar = null;
        }

        @Override // com.google.gson.d
        public String translateName(Field field) {
            return c.separateCamelCase(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    };
    public static final c LOWER_CASE_WITH_DASHES = new c("LOWER_CASE_WITH_DASHES", 5) { // from class: com.google.gson.c.f
        {
            a aVar = null;
        }

        @Override // com.google.gson.d
        public String translateName(Field field) {
            return c.separateCamelCase(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    };
    public static final c LOWER_CASE_WITH_DOTS = new c("LOWER_CASE_WITH_DOTS", 6) { // from class: com.google.gson.c.g
        {
            a aVar = null;
        }

        @Override // com.google.gson.d
        public String translateName(Field field) {
            return c.separateCamelCase(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ c[] f5682a = {IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, UPPER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES, LOWER_CASE_WITH_DOTS};

    /* compiled from: FieldNamingPolicy.java */
    enum a extends c {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.gson.d
        public String translateName(Field field) {
            return field.getName();
        }
    }

    private c(String str, int i2) {
    }

    static String separateCamelCase(String str, char c2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String upperCaseFirstLetter(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i2 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
            }
        }
        return str;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f5682a.clone();
    }

    /* synthetic */ c(String str, int i2, a aVar) {
        this(str, i2);
    }
}
