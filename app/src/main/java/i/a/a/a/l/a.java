package i.a.a.a.l;

import i.a.a.a.k.k;
import i.a.a.a.k.l;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: DigestUtils.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16770a = 1024;

    private static byte[] a(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int i2 = inputStream.read(bArr, 0, 1024);
        while (i2 > -1) {
            messageDigest.update(bArr, 0, i2);
            i2 = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest.digest();
    }

    static MessageDigest b(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    private static MessageDigest c() {
        return b("SHA-384");
    }

    private static MessageDigest d() {
        return b("SHA-512");
    }

    private static MessageDigest e() {
        return b("SHA");
    }

    public static byte[] f(String str) {
        return d(a(str));
    }

    public static String g(String str) {
        return k.b(f(str));
    }

    public static byte[] h(String str) {
        return f(a(str));
    }

    public static String i(String str) {
        return k.b(h(str));
    }

    public static byte[] j(String str) {
        return h(a(str));
    }

    public static String k(String str) {
        return k.b(j(str));
    }

    public static String l(String str) {
        return k.b(e(str));
    }

    public static byte[] c(String str) {
        return a(a(str));
    }

    public static String d(String str) {
        return k.b(c(str));
    }

    public static byte[] e(String str) {
        return c(a(str));
    }

    public static byte[] f(byte[] bArr) {
        return c().digest(bArr);
    }

    public static String g(byte[] bArr) {
        return k.b(f(bArr));
    }

    public static byte[] h(byte[] bArr) {
        return d().digest(bArr);
    }

    public static String i(byte[] bArr) {
        return k.b(h(bArr));
    }

    public static String j(byte[] bArr) {
        return k.b(c(bArr));
    }

    private static MessageDigest b() {
        return b("SHA-256");
    }

    public static byte[] c(byte[] bArr) {
        return e().digest(bArr);
    }

    public static byte[] d(byte[] bArr) {
        return b().digest(bArr);
    }

    public static String e(byte[] bArr) {
        return k.b(d(bArr));
    }

    public static byte[] f(InputStream inputStream) throws IOException {
        return a(c(), inputStream);
    }

    public static String g(InputStream inputStream) throws IOException {
        return k.b(f(inputStream));
    }

    public static byte[] h(InputStream inputStream) throws IOException {
        return a(d(), inputStream);
    }

    public static String i(InputStream inputStream) throws IOException {
        return k.b(h(inputStream));
    }

    public static String j(InputStream inputStream) throws IOException {
        return k.b(c(inputStream));
    }

    public static String b(byte[] bArr) {
        return k.b(a(bArr));
    }

    public static byte[] c(InputStream inputStream) throws IOException {
        return a(e(), inputStream);
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        return a(b(), inputStream);
    }

    public static String e(InputStream inputStream) throws IOException {
        return k.b(d(inputStream));
    }

    private static byte[] a(String str) {
        return l.f(str);
    }

    public static String b(InputStream inputStream) throws IOException {
        return k.b(a(inputStream));
    }

    private static MessageDigest a() {
        return b("MD5");
    }

    public static byte[] a(byte[] bArr) {
        return a().digest(bArr);
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        return a(a(), inputStream);
    }
}
