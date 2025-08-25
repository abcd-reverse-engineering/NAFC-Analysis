package network.account;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class APIresult<T> implements Serializable {
    private int code = -102;
    private T data;
    private String encodeStr;
    private String msg;
    private String sData;
    private String sign;
    private String timestamp;

    public APIresult() {
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getEncodeStr() {
        return this.encodeStr;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getsData() {
        return this.sData;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setEncodeStr(String str) {
        this.encodeStr = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setsData(String str) {
        this.sData = str;
    }

    public APIresult(String str) {
        this.msg = str;
    }
}
