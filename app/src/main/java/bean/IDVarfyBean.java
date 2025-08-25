package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class IDVarfyBean extends BaseBean {
    public List<Rows> rows;
    public int total;
    public int totalPages;

    public static class Rows extends BaseBean {
        private String deadline;
        private String id;
        private String intivedMobile;
        private String intivedPhotoFileUrl;
        private String launchTime;
        private int verifyStatus;
        private String verifyTime;

        public String getDeadline() {
            return this.deadline;
        }

        public String getId() {
            return this.id;
        }

        public String getIntivedMobile() {
            return this.intivedMobile;
        }

        public String getIntivedPhotoFileUrl() {
            return this.intivedPhotoFileUrl;
        }

        public String getLaunchTime() {
            return this.launchTime;
        }

        public int getVerifyStatus() {
            return this.verifyStatus;
        }

        public String getVerifyTime() {
            return this.verifyTime;
        }

        public void setDeadline(String str) {
            this.deadline = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIntivedMobile(String str) {
            this.intivedMobile = str;
        }

        public void setIntivedPhotoFileUrl(String str) {
            this.intivedPhotoFileUrl = str;
        }

        public void setLaunchTime(String str) {
            this.launchTime = str;
        }

        public void setVerifyStatus(int i2) {
            this.verifyStatus = i2;
        }

        public void setVerifyTime(String str) {
            this.verifyTime = str;
        }
    }
}
