package com.umeng.socialize.net.dplus.cache1;

import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DplueCache {
    private static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        return (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("content")) == null) ? new JSONObject() : jSONObjectOptJSONObject.optJSONObject("share");
    }

    public static boolean deleteFile(File file) {
        return file.delete();
    }

    public static String getFileName() {
        return "dpluscache";
    }

    public static File getFilePath(String str) {
        if (ContextUtil.getContext() == null) {
            return null;
        }
        String packageName = ContextUtil.getContext().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        String str2 = File.separator + "data" + File.separator + "data" + File.separator + packageName + File.separator + "files" + File.separator + str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str2);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static String readFile(File file) throws Throwable {
        if (!file.exists()) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(ContextUtil.getContext().openFileInput(file.getName())));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (Exception e2) {
                        bufferedReader = bufferedReader2;
                        e = e2;
                        SLog.error(UmengText.CACHE.CACHEFILE, e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                SLog.error(UmengText.CACHE.CACHEFILE, e3);
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        bufferedReader = bufferedReader2;
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                                SLog.error(UmengText.CACHE.CACHEFILE, e4);
                            }
                        }
                        throw th;
                    }
                }
                String string = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (Exception e5) {
                    SLog.error(UmengText.CACHE.CACHEFILE, e5);
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public static boolean save(JSONObject jSONObject, File file) throws Throwable {
        if (!file.exists()) {
            file.createNewFile();
            return a(jSONObject.toString(), file);
        }
        return a(readFile(file) + Constants.ACCEPT_TIME_SEPARATOR_SP + jSONObject, file);
    }

    private static boolean a(String str, File file) throws Throwable {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(ContextUtil.getContext().openFileOutput(file.getName(), 0)));
                try {
                    bufferedWriter2.write(str);
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e2) {
                        SLog.error(UmengText.CACHE.CLOSE, e2);
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    bufferedWriter = bufferedWriter2;
                    SLog.error(UmengText.CACHE.CACHEFILE, e);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e4) {
                            SLog.error(UmengText.CACHE.CLOSE, e4);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e5) {
                            SLog.error(UmengText.CACHE.CLOSE, e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }
}
