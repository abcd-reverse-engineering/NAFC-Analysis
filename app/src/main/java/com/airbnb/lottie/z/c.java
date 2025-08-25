package com.airbnb.lottie.z;

/* compiled from: FileExtension.java */
/* loaded from: classes.dex */
public enum c {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    c(String str) {
        this.extension = str;
    }

    public static c forFile(String str) {
        for (c cVar : values()) {
            if (str.endsWith(cVar.extension)) {
                return cVar;
            }
        }
        com.airbnb.lottie.b0.d.b("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
