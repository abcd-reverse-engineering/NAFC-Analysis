package b.a.a.g;

import android.R;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.xiaomi.mipush.sdk.Constants;
import h.f1;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: ConvertUtils.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final long f2306a = 1073741824;

    /* renamed from: b, reason: collision with root package name */
    public static final long f2307b = 1048576;

    /* renamed from: c, reason: collision with root package name */
    public static final long f2308c = 1024;

    public static float a(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (NumberFormatException unused) {
            return -1.0f;
        }
    }

    public static int a(byte b2, byte b3) {
        return (b2 << 8) + (b3 & f1.f16099c);
    }

    public static int b(Object obj) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static long c(Object obj) {
        try {
            return Long.parseLong(obj.toString());
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static String d(byte... bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = bArr[i3] < 0 ? bArr[i3] + 256 : bArr[i3];
            int i5 = i2 + 1;
            cArr2[i2] = cArr[i4 >>> 4];
            i2 = i5 + 1;
            cArr2[i5] = cArr[i4 & 15];
        }
        return new String(cArr2);
    }

    public static int e(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 += (bArr[i3] & f1.f16099c) << (i3 * 8);
        }
        return i2;
    }

    public static byte[] a(String str, boolean z) throws IOException {
        if (str == null || str.equals("")) {
            return null;
        }
        if (!z) {
            return str.getBytes();
        }
        String strReplaceAll = str.replaceAll("\\s+", "");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(strReplaceAll.length() / 2);
        for (int i2 = 0; i2 < strReplaceAll.length(); i2 += 2) {
            byteArrayOutputStream.write(("0123456789ABCDEF".indexOf(strReplaceAll.charAt(i2)) << 4) | "0123456789ABCDEF".indexOf(strReplaceAll.charAt(i2 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            d.c(e2);
        }
        return byteArray;
    }

    public static byte[] b(int i2) {
        return ByteBuffer.allocate(4).putInt(i2).array();
    }

    public static String c(String str) {
        String str2 = "";
        for (char c2 : str.toCharArray()) {
            if (c2 == '\"' || c2 == '\'' || c2 == '\\') {
                str2 = str2 + "\\";
            }
            str2 = str2 + c2;
        }
        return str2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : str.getBytes()) {
            sb.append(Integer.toHexString(b2 & f1.f16099c));
            sb.append(c.c.a.b.a.a.f3100g);
        }
        return sb.toString();
    }

    public static String e(int i2) {
        String hexString = Integer.toHexString(i2);
        d.e(String.format(Locale.CHINA, "%d to hex string is %s", Integer.valueOf(i2), hexString));
        return hexString;
    }

    public static Drawable c(byte[] bArr) {
        return b(b(bArr));
    }

    public static int c(Context context, float f2) {
        int i2 = (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        d.e(f2 + " px == " + i2 + " sp");
        return i2;
    }

    public static int d(@ColorInt int i2) {
        return a(i2, 0.8f);
    }

    public static String c(@ColorInt int i2) {
        return a(i2, false);
    }

    public static String b(Object[] objArr) {
        return Arrays.deepToString(objArr);
    }

    public static Bitmap b(byte[] bArr) {
        return a(bArr, -1, -1);
    }

    public static Drawable b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(Resources.getSystem(), bitmap);
    }

    public static byte[] b(Drawable drawable) {
        return a(a(drawable));
    }

    public static String a(byte... bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 8];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = bArr[i3] < 0 ? bArr[i3] + 256 : bArr[i3];
            int i5 = i2 + 1;
            cArr2[i2] = cArr[(i4 >>> 7) & 1];
            int i6 = i5 + 1;
            cArr2[i5] = cArr[(i4 >>> 6) & 1];
            int i7 = i6 + 1;
            cArr2[i6] = cArr[(i4 >>> 5) & 1];
            int i8 = i7 + 1;
            cArr2[i7] = cArr[(i4 >>> 4) & 1];
            int i9 = i8 + 1;
            cArr2[i8] = cArr[(i4 >>> 3) & 1];
            int i10 = i9 + 1;
            cArr2[i9] = cArr[(i4 >>> 2) & 1];
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(i4 >>> 1) & 1];
            i2 = i11 + 1;
            cArr2[i11] = cArr[i4 & 1];
        }
        return new String(cArr2);
    }

    public static int b(Context context, float f2) {
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        d.e(f2 + " dp == " + i2 + " px");
        return i2;
    }

    public static String b(InputStream inputStream) {
        return a(inputStream, "utf-8");
    }

    public static String a(int i2) {
        String binaryString = Integer.toBinaryString(i2);
        d.e(String.format(Locale.CHINA, "%d to binary string is %s", Integer.valueOf(i2), binaryString));
        return binaryString;
    }

    public static <T> T[] a(List<T> list) {
        return (T[]) list.toArray();
    }

    public static <T> List<T> a(T[] tArr) {
        return Arrays.asList(tArr);
    }

    public static String a(Object[] objArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(str);
        }
        return sb.toString();
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[100];
            while (true) {
                int i2 = inputStream.read(bArr, 0, 100);
                if (i2 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException e2) {
            d.c(e2);
            return null;
        }
    }

    public static byte[] a(Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            d.c(e2);
        }
        return byteArray;
    }

    public static Bitmap a(byte[] bArr, int i2, int i3) {
        Bitmap bitmapDecodeByteArray = null;
        if (bArr.length == 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            options.inPreferredConfig = null;
            if (i2 > 0 && i3 > 0) {
                options.outWidth = i2;
                options.outHeight = i3;
            }
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            bitmapDecodeByteArray.setDensity(96);
            return bitmapDecodeByteArray;
        } catch (Exception e2) {
            d.a(e2);
            return bitmapDecodeByteArray;
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof ColorDrawable) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawColor(((ColorDrawable) drawable).getColor());
            return bitmapCreateBitmap;
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap2;
    }

    @TargetApi(19)
    public static String a(Context context, Uri uri) {
        if (uri == null) {
            d.e("uri is null");
            return "";
        }
        d.e("uri: " + uri.toString());
        String path = uri.getPath();
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] strArrSplit = documentId.split(Constants.COLON_SEPARATOR);
            String str = strArrSplit[0];
            char c2 = 65535;
            int iHashCode = authority.hashCode();
            if (iHashCode != 320699453) {
                if (iHashCode != 596745902) {
                    if (iHashCode == 1734583286 && authority.equals("com.android.providers.media.documents")) {
                        c2 = 2;
                    }
                } else if (authority.equals("com.android.externalstorage.documents")) {
                    c2 = 0;
                }
            } else if (authority.equals("com.android.providers.downloads.documents")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
                }
                if (c2 == 2) {
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return a(context, uri2, "_id=?", new String[]{strArrSplit[1]});
                }
            } else if ("primary".equalsIgnoreCase(str)) {
                return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
            }
        } else {
            if ("content".equalsIgnoreCase(scheme)) {
                if (authority.equals("com.google.android.apps.photos.content")) {
                    return uri.getLastPathSegment();
                }
                return a(context, uri, (String) null, (String[]) null);
            }
            if ("file".equalsIgnoreCase(scheme)) {
                return uri.getPath();
            }
        }
        d.e("uri to path: " + path);
        return path;
    }

    private static String a(Context context, Uri uri, String str, String[] strArr) throws IllegalArgumentException {
        String string = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery == null) {
                return null;
            }
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(columnIndexOrThrow);
            cursorQuery.close();
            return string;
        } catch (IllegalArgumentException e2) {
            d.a(e2);
            return string;
        }
    }

    public static Bitmap a(View view) {
        int height;
        int width = view.getWidth();
        int height2 = view.getHeight();
        if (view instanceof ListView) {
            ListView listView = (ListView) view;
            height = 0;
            for (int i2 = 0; i2 < listView.getChildCount(); i2++) {
                height += listView.getChildAt(i2).getHeight();
            }
        } else if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            height = 0;
            for (int i3 = 0; i3 < scrollView.getChildCount(); i3++) {
                height += scrollView.getChildAt(i3).getHeight();
            }
        } else {
            height = height2;
        }
        view.setDrawingCacheEnabled(true);
        view.clearFocus();
        view.setPressed(false);
        boolean zWillNotCacheDrawing = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(-1);
        if (drawingCacheBackgroundColor != -1) {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(drawingCache, 0.0f, 0.0f, (Paint) null);
        canvas.save();
        canvas.restore();
        if (!bitmapCreateBitmap.isRecycled()) {
            d.e("recycle bitmap: " + bitmapCreateBitmap.toString());
            bitmapCreateBitmap.recycle();
        }
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(zWillNotCacheDrawing);
        view.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return bitmapCreateBitmap;
    }

    public static int a(Context context, float f2) {
        int i2 = (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
        d.e(f2 + " px == " + i2 + " dp");
        return i2;
    }

    public static String a(String str) {
        try {
            return new String(str.getBytes("utf-8"), "gbk");
        } catch (UnsupportedEncodingException e2) {
            d.c(e2);
            return str;
        }
    }

    public static String a(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j2 < 1024) {
            return j2 + "B";
        }
        if (j2 < 1048576) {
            return decimalFormat.format(j2 / 1024.0d) + "K";
        }
        if (j2 < f2306a) {
            return decimalFormat.format(j2 / 1048576.0d) + "M";
        }
        return decimalFormat.format(j2 / 1.073741824E9d) + "G";
    }

    public static String a(InputStream inputStream, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e2) {
            d.a(e2);
        }
        return sb.toString();
    }

    public static int a(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        fArr[2] = fArr[2] * f2;
        return Color.HSVToColor(fArr);
    }

    public static String a(@ColorInt int i2, boolean z) {
        String hexString = Integer.toHexString(Color.alpha(i2));
        String hexString2 = Integer.toHexString(Color.red(i2));
        String hexString3 = Integer.toHexString(Color.green(i2));
        String hexString4 = Integer.toHexString(Color.blue(i2));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = "0" + hexString4;
        }
        if (z) {
            String str = hexString + hexString2 + hexString3 + hexString4;
            d.e(String.format(Locale.CHINA, "%d to color string is %s", Integer.valueOf(i2), str));
            return str;
        }
        String str2 = hexString2 + hexString3 + hexString4;
        d.e(String.format(Locale.CHINA, "%d to color string is %s%s%s%s, exclude alpha is %s", Integer.valueOf(i2), hexString, hexString2, hexString3, hexString4, str2));
        return str2;
    }

    public static ColorStateList a(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, new int[]{i3, i4, i2, i4, i5, i2});
    }

    public static ColorStateList a(@ColorInt int i2, @ColorInt int i3) {
        return a(i2, i3, i3, i2);
    }
}
