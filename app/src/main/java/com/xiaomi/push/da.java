package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class da {

    /* renamed from: a, reason: collision with root package name */
    private static String f12622a = "/MiPushLog";

    /* renamed from: a, reason: collision with other field name */
    private int f299a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f302a;

    /* renamed from: b, reason: collision with other field name */
    private String f303b;

    /* renamed from: c, reason: collision with root package name */
    private String f12624c;

    /* renamed from: a, reason: collision with other field name */
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat f300a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: b, reason: collision with root package name */
    private int f12623b = 2097152;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<File> f301a = new ArrayList<>();

    da() {
    }

    da a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f303b = this.f300a.format(date2);
            this.f12624c = this.f300a.format(date);
        } else {
            this.f303b = this.f300a.format(date);
            this.f12624c = this.f300a.format(date2);
        }
        return this;
    }

    void a(int i2) {
        if (i2 != 0) {
            this.f12623b = i2;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    da m261a(File file) {
        if (file.exists()) {
            this.f301a.add(file);
        }
        return this;
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) throws IOException {
        char[] cArr = new char[4096];
        int i2 = bufferedReader.read(cArr);
        boolean z = false;
        while (i2 != -1 && !z) {
            String str = new String(cArr, 0, i2);
            Matcher matcher = pattern.matcher(str);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= i2 || !matcher.find(i3)) {
                    break;
                }
                int iStart = matcher.start();
                String strSubstring = str.substring(iStart, this.f303b.length() + iStart);
                if (!this.f302a) {
                    if (strSubstring.compareTo(this.f303b) >= 0) {
                        this.f302a = true;
                        i4 = iStart;
                    }
                } else if (strSubstring.compareTo(this.f12624c) > 0) {
                    i2 = iStart;
                    z = true;
                    break;
                }
                int iIndexOf = str.indexOf(10, iStart);
                if (iIndexOf == -1) {
                    iIndexOf = this.f303b.length();
                }
                i3 = iStart + iIndexOf;
            }
            if (this.f302a) {
                int i5 = i2 - i4;
                this.f299a += i5;
                if (z) {
                    bufferedWriter.write(cArr, i4, i5);
                    return;
                } else {
                    bufferedWriter.write(cArr, i4, i5);
                    if (this.f299a > this.f12623b) {
                        return;
                    }
                }
            }
            i2 = bufferedReader.read(cArr);
        }
    }

    private void a(File file) throws Throwable {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        Pattern patternCompile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedReader = null;
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedWriter = null;
            }
            try {
                bufferedWriter.write("model :" + k.a() + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.ax.m705a() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");
                this.f299a = 0;
                Iterator<File> it = this.f301a.iterator();
                while (it.hasNext()) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                    try {
                        a(bufferedReader, bufferedWriter, patternCompile);
                        bufferedReader.close();
                        bufferedReader2 = bufferedReader;
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedReader2 = bufferedWriter;
                        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                        w.a(bufferedReader2);
                        w.a(bufferedReader);
                        return;
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader2 = bufferedWriter;
                        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                        w.a(bufferedReader2);
                        w.a(bufferedReader);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        w.a(bufferedWriter);
                        w.a(bufferedReader2);
                        throw th;
                    }
                }
                bufferedWriter.write(cg.a().c());
                w.a(bufferedWriter);
                w.a(bufferedReader2);
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = bufferedReader2;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = bufferedReader2;
            } catch (Throwable th3) {
                th = th3;
                w.a(bufferedWriter);
                w.a(bufferedReader2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = bufferedReader2;
        }
    }

    File a(Context context, Date date, Date date2, File file) throws Throwable {
        File fileA;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            fileA = cz.a(context);
            if (fileA == null) {
                return null;
            }
            m261a(new File(fileA, "xmsf.log.1"));
            m261a(new File(fileA, "xmsf.log"));
        } else {
            File file2 = new File(context.getFilesDir() + f12622a);
            if (!v.m764a(file2)) {
                return null;
            }
            m261a(new File(file2, "log0.txt"));
            m261a(new File(file2, "log1.txt"));
            fileA = file2;
        }
        if (!fileA.isDirectory()) {
            return null;
        }
        File file3 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file3.exists()) {
            return null;
        }
        a(date, date2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file4 = new File(file, "log.txt");
        a(file4);
        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (file4.exists()) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            w.a(file3, file4);
            com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (System.currentTimeMillis() - jCurrentTimeMillis2));
            file4.delete();
            if (file3.exists()) {
                return file3;
            }
        }
        return null;
    }
}
