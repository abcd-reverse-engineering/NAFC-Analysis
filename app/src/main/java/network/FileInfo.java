package network;

import java.util.ArrayList;
import java.util.List;
import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public class FileInfo extends BaseBean {
    private List<FileDetailsBean> fileDetails = new ArrayList();
    private List<RequestBody> files = new ArrayList();

    public static class FileDetailsBean extends BaseBean {
        private String fileMD5;
        private String fileName;
        private String filePath;

        public String getFileMD5() {
            return this.fileMD5;
        }

        public String getFileName() {
            return this.fileName;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public void setFileMD5(String str) {
            this.fileMD5 = str;
        }

        public void setFileName(String str) {
            this.fileName = str;
        }

        public void setFilePath(String str) {
            this.filePath = str;
        }
    }

    public List<FileDetailsBean> getFileDetails() {
        return this.fileDetails;
    }

    public List<RequestBody> getFiles() {
        return this.files;
    }

    public void setFileDetails(List<FileDetailsBean> list) {
        this.fileDetails = list;
    }

    public void setFiles(List<RequestBody> list) {
        this.files = list;
    }
}
