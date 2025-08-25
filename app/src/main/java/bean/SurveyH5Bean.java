package bean;

import java.util.Map;
import network.BaseBean;

/* loaded from: classes.dex */
public class SurveyH5Bean extends BaseBean {
    public static final String ACTION = "action";
    public static final String AUDIO = "audio";
    public static final String CALL = "call";
    public static final String ERRORMSG = "\"errorMsg\"";
    public static final String EVENT = "event";
    public static final int EVENT_BASEINFO = 4;
    public static final int EVENT_CHANGEBARTOPSTYLE = 2;
    public static final int EVENT_EXIT = 7;
    public static final int EVENT_EXIT_POLIC = 9;
    public static final int EVENT_GETSCAN = 3;
    public static final int EVENT_GOBACK = 1;
    public static final int EVENT_H5_CLEAN = 16;
    public static final int EVENT_POLIC_PHONE = 13;
    public static final int EVENT_POLIC_TOKEN = 8;
    public static final int EVENT_POLIC_TOKEN2 = 12;
    public static final int EVENT_SELECT_SIZE = 10;
    public static final int EVENT_SHARE = 11;
    public static final int EVENT_SHARE_ARTICLE = 17;
    public static final int EVENT_SWIPBACK = 6;
    public static final int EVENT_TOVERIFIED = 5;
    public static final int EVENT_wWEB_JSFINISH = 15;
    public static final String POST = "post";
    public static final String RESPONSE = "\"response\"";
    public static final String SELECTNUM = "selectNum";
    public static final String SMS = "sms";
    public static final String VALUE = "value";
    private String apiUrl;
    private Object errorMsg;
    private String fileScopeType;
    private String md5;
    private String msgId;
    private String oss_Endpoint;
    private Map<String, Object> params;
    private String path;
    private Object response;
    private String transChannel;
    private String type;

    public String getApiUrl() {
        return this.apiUrl;
    }

    public Object getErrorMsg() {
        return this.errorMsg;
    }

    public String getFileScopeType() {
        return this.fileScopeType;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getOss_Endpoint() {
        return this.oss_Endpoint;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public String getPath() {
        return this.path;
    }

    public Object getResponse() {
        return this.response;
    }

    public String getTransChannel() {
        return this.transChannel;
    }

    public String getType() {
        return this.type;
    }

    public void setApiUrl(String str) {
        this.apiUrl = str;
    }

    public void setErrorMsg(Object obj) {
        this.errorMsg = obj;
    }

    public void setFileScopeType(String str) {
        this.fileScopeType = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setOss_Endpoint(String str) {
        this.oss_Endpoint = str;
    }

    public void setParams(Map<String, Object> map) {
        this.params = map;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setResponse(Object obj) {
        this.response = obj;
    }

    public void setTransChannel(String str) {
        this.transChannel = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
