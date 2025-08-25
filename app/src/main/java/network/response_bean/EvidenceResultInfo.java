package network.response_bean;

import java.util.List;

/* loaded from: classes2.dex */
public class EvidenceResultInfo {
    private int code;
    private List<DataBean> data;

    public static class DataBean {
        private String create_time;
        private String forensic_number;
        private String forensic_time;
        private int id;
        private String imei;
        private String phone;
        private List<ReportContentBean> report_content;
        private String report_desc;
        private String reporter;
        private String reporter_id_card;
        private String reporter_phone;
        private int swindle_type;
        private String update_time;
        private String username;
        private String version;

        public static class ReportContentBean {
            private String file_md5;
            private String file_name;

            public String getFile_md5() {
                return this.file_md5;
            }

            public String getFile_name() {
                return this.file_name;
            }

            public void setFile_md5(String str) {
                this.file_md5 = str;
            }

            public void setFile_name(String str) {
                this.file_name = str;
            }
        }

        public String getCreate_time() {
            return this.create_time;
        }

        public String getForensic_number() {
            return this.forensic_number;
        }

        public String getForensic_time() {
            return this.forensic_time;
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

        public List<ReportContentBean> getReport_content() {
            return this.report_content;
        }

        public String getReport_desc() {
            return this.report_desc;
        }

        public String getReporter() {
            return this.reporter;
        }

        public String getReporter_id_card() {
            return this.reporter_id_card;
        }

        public String getReporter_phone() {
            return this.reporter_phone;
        }

        public int getSwindle_type() {
            return this.swindle_type;
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

        public void setForensic_number(String str) {
            this.forensic_number = str;
        }

        public void setForensic_time(String str) {
            this.forensic_time = str;
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

        public void setReport_content(List<ReportContentBean> list) {
            this.report_content = list;
        }

        public void setReport_desc(String str) {
            this.report_desc = str;
        }

        public void setReporter(String str) {
            this.reporter = str;
        }

        public void setReporter_id_card(String str) {
            this.reporter_id_card = str;
        }

        public void setReporter_phone(String str) {
            this.reporter_phone = str;
        }

        public void setSwindle_type(int i2) {
            this.swindle_type = i2;
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

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }
}
