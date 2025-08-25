package com.bumptech.glide.load.o;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class o extends l<InputStream> {

    /* renamed from: e, reason: collision with root package name */
    private static final int f4294e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final int f4295f = 2;

    /* renamed from: g, reason: collision with root package name */
    private static final int f4296g = 3;

    /* renamed from: h, reason: collision with root package name */
    private static final int f4297h = 4;

    /* renamed from: i, reason: collision with root package name */
    private static final int f4298i = 5;

    /* renamed from: j, reason: collision with root package name */
    private static final UriMatcher f4299j = new UriMatcher(-1);

    static {
        f4299j.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f4299j.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f4299j.addURI("com.android.contacts", "contacts/#/photo", 2);
        f4299j.addURI("com.android.contacts", "contacts/#", 3);
        f4299j.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f4299j.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public o(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = f4299j.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return a(contentResolver, uri);
            }
            if (iMatch != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return a(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.o.l
    public InputStream a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamB = b(uri, contentResolver);
        if (inputStreamB != null) {
            return inputStreamB;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    private InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.o.l
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
