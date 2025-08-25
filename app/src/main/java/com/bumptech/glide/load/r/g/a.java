package com.bumptech.glide.load.r.g;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.p.v;
import java.io.File;

/* compiled from: FileDecoder.java */
/* loaded from: classes.dex */
public class a implements l<File, File> {
    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull File file, @NonNull j jVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    public v<File> a(@NonNull File file, int i2, int i3, @NonNull j jVar) {
        return new b(file);
    }
}
