package network.response_bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes2.dex */
public class ReportResultInfo extends BaseBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    public static class DataBean {
        private String create_time;
        private int id;
        private String imei;
        private String phone;
        private Object report_content;
        private String report_desc;
        private String report_time;
        private int report_type;
        private int swindle_type;
        private int swindled;
        private String update_time;
        private String username;
        private String version;

        public String getCreate_time() {
            return this.create_time;
        }

        public int getId() {
            return this.id;
        }

        public String getImei() {
            return this.imei;
        }

        public String getPhone() {
            return this.phone;
        }

        public Object getReport_content() {
            return this.report_content;
        }

        public String getReport_desc() {
            return this.report_desc;
        }

        public String getReport_time() {
            return this.report_time;
        }

        public int getReport_type() {
            return this.report_type;
        }

        public int getSwindle_type() {
            return this.swindle_type;
        }

        public int getSwindled() {
            return this.swindled;
        }

        public String getUpdate_time() {
            return this.update_time;
        }

        public String getUsername() {
            return this.username;
        }

        public String getVersion() {
            return this.version;
        }

        public void setCreate_time(String str) {
            this.create_time = str;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setImei(String str) {
            this.imei = str;
        }

        public void setPhone(String str) {
            this.phone = str;
        }

        public void setReport_content(Object obj) {
            this.report_content = obj;
        }

        public void setReport_desc(String str) {
            this.report_desc = str;
        }

        public void setReport_time(String str) {
            this.report_time = str;
        }

        public void setReport_type(int i2) {
            this.report_type = i2;
        }

        public void setSwindle_type(int i2) {
            this.swindle_type = i2;
        }

        public void setSwindled(int i2) {
            this.swindled = i2;
        }

        public void setUpdate_time(String str) {
            this.update_time = str;
        }

        public void setUsername(String str) {
            this.username = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
