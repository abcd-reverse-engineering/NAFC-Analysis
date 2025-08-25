package com.just.agentweb;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import c.c.a.b.a.a;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsCallJava {
    private static final String[] IGNORE_UNSAFE_METHODS = {"getClass", "hashCode", AgooConstants.MESSAGE_NOTIFICATION, "notifyAll", "equals", "toString", "wait"};
    private static final String KEY_ARGS = "args";
    private static final String KEY_METHOD = "method";
    private static final String KEY_OBJ = "obj";
    private static final String KEY_TYPES = "types";
    private static final String MSG_PROMPT_HEADER = "AgentWeb:";
    private static final String RETURN_RESULT_FORMAT = "{\"CODE\": %d, \"result\": %s}";
    private static final String TAG = "JsCallJava";
    private Object mInterfaceObj;
    private String mInterfacedName;
    private HashMap<String, Method> mMethodsMap;
    private String mPreloadInterfaceJs;

    public JsCallJava(Object obj, String str) throws Exception {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.mInterfaceObj = obj;
            this.mInterfacedName = str;
            this.mMethodsMap = new HashMap<>();
            Method[] methods = this.mInterfaceObj.getClass().getMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.mInterfacedName);
            sb.append(" init begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : methods) {
                String str2 = "method:" + method;
                String strGenJavaMethodSign = genJavaMethodSign(method);
                if (strGenJavaMethodSign != null) {
                    this.mMethodsMap.put(strGenJavaMethodSign, method);
                    sb.append(String.format("a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.mInterfacedName);
            sb.append(" call result, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var k = new Date().getTime();var l = f.shift();var m=prompt('");
            sb.append(MSG_PROMPT_HEADER);
            sb.append("'+JSON.stringify(");
            sb.append(promptMsgFormat("'" + this.mInterfacedName + "'", "l", "e", "f"));
            sb.append("));console.log(\"invoke \"+l+\", time: \"+(new Date().getTime()-k));var g=JSON.parse(m);if(g.CODE!=200){throw\"");
            sb.append(this.mInterfacedName);
            sb.append(" call result, CODE:\"+g.CODE+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.mInterfacedName);
            sb.append("=a;console.log(\"");
            sb.append(this.mInterfacedName);
            sb.append(" init end\")})(window)");
            this.mPreloadInterfaceJs = sb.toString();
            sb.setLength(0);
        } catch (Exception e2) {
            if (LogUtils.isDebug()) {
                String str3 = "init js result:" + e2.getMessage();
            }
        }
    }

    private String genJavaMethodSign(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (String str : IGNORE_UNSAFE_METHODS) {
            if (str.equals(name)) {
                if (!LogUtils.isDebug()) {
                    return null;
                }
                String str2 = "method(" + name + ") is unsafe, will be pass";
                return null;
            }
        }
        for (Class<?> cls : parameterTypes) {
            if (cls == String.class) {
                name = name + "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                name = name + "_N";
            } else if (cls == Boolean.TYPE) {
                name = name + "_B";
            } else if (cls == JSONObject.class) {
                name = name + "_O";
            } else if (cls == JsCallback.class) {
                name = name + "_F";
            } else {
                name = name + "_P";
            }
        }
        return name;
    }

    static String getInterfacedName(JSONObject jSONObject) {
        return jSONObject.optString(KEY_OBJ);
    }

    static JSONObject getMsgJSONObject(String str) {
        try {
            return new JSONObject(str.substring(9));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    private String getReturn(JSONObject jSONObject, int i2, Object obj, long j2) {
        String str = String.format(RETURN_RESULT_FORMAT, Integer.valueOf(i2), obj == null ? a.f3101h : obj instanceof String ? "\"".concat(String.valueOf(((String) obj).replace("\"", "\\\""))).concat("\"") : String.valueOf(obj));
        if (LogUtils.isDebug()) {
            String str2 = "call time: " + (SystemClock.uptimeMillis() - j2) + ", request: " + jSONObject + ", result:" + str;
        }
        return str;
    }

    static boolean isSafeWebViewCallMsg(String str) {
        return str.startsWith(MSG_PROMPT_HEADER);
    }

    private static String promptMsgFormat(String str, String str2, String str3, String str4) {
        return "{" + KEY_OBJ + Constants.COLON_SEPARATOR + str + Constants.ACCEPT_TIME_SEPARATOR_SP + KEY_METHOD + Constants.COLON_SEPARATOR + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + KEY_TYPES + Constants.COLON_SEPARATOR + str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + KEY_ARGS + Constants.COLON_SEPARATOR + str4 + "}";
    }

    public String call(WebView webView, JSONObject jSONObject) throws JSONException {
        long jUptimeMillis = LogUtils.isDebug() ? SystemClock.uptimeMillis() : 0L;
        if (jSONObject == null) {
            return getReturn(jSONObject, 500, "call data empty", jUptimeMillis);
        }
        try {
            String string = jSONObject.getString(KEY_METHOD);
            JSONArray jSONArray = jSONObject.getJSONArray(KEY_TYPES);
            JSONArray jSONArray2 = jSONObject.getJSONArray(KEY_ARGS);
            int length = jSONArray.length();
            Object[] objArr = new Object[length];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                String strOptString = jSONArray.optString(i3);
                Object jSONObject2 = null;
                if ("string".equals(strOptString)) {
                    string = string + "_S";
                    if (!jSONArray2.isNull(i3)) {
                        jSONObject2 = jSONArray2.getString(i3);
                    }
                    objArr[i3] = jSONObject2;
                } else if ("number".equals(strOptString)) {
                    string = string + "_N";
                    i2 = (i2 * 10) + i3 + 1;
                } else if ("boolean".equals(strOptString)) {
                    string = string + "_B";
                    objArr[i3] = Boolean.valueOf(jSONArray2.getBoolean(i3));
                } else if ("object".equals(strOptString)) {
                    string = string + "_O";
                    if (!jSONArray2.isNull(i3)) {
                        jSONObject2 = jSONArray2.getJSONObject(i3);
                    }
                    objArr[i3] = jSONObject2;
                } else if ("function".equals(strOptString)) {
                    string = string + "_F";
                    objArr[i3] = new JsCallback(webView, this.mInterfacedName, jSONArray2.getInt(i3));
                } else {
                    string = string + "_P";
                }
            }
            Method method = this.mMethodsMap.get(string);
            if (method == null) {
                return getReturn(jSONObject, 500, "not found method(" + string + ") with valid parameters", jUptimeMillis);
            }
            if (i2 > 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                while (i2 > 0) {
                    int i4 = (i2 - ((i2 / 10) * 10)) - 1;
                    Class<?> cls = parameterTypes[i4];
                    if (cls == Integer.TYPE) {
                        objArr[i4] = Integer.valueOf(jSONArray2.getInt(i4));
                    } else if (cls == Long.TYPE) {
                        objArr[i4] = Long.valueOf(Long.parseLong(jSONArray2.getString(i4)));
                    } else {
                        objArr[i4] = Double.valueOf(jSONArray2.getDouble(i4));
                    }
                    i2 /= 10;
                }
            }
            return getReturn(jSONObject, 200, method.invoke(this.mInterfaceObj, objArr), jUptimeMillis);
        } catch (Exception e2) {
            LogUtils.safeCheckCrash(TAG, "call", e2);
            if (e2.getCause() != null) {
                return getReturn(jSONObject, 500, "method execute result:" + e2.getCause().getMessage(), jUptimeMillis);
            }
            return getReturn(jSONObject, 500, "method execute result:" + e2.getMessage(), jUptimeMillis);
        }
    }

    public String getPreloadInterfaceJs() {
        return this.mPreloadInterfaceJs;
    }
}
