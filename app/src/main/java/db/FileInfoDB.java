package db;

import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public class FileInfoDB {
    public static final int TYPE_SOURCE_APP = 1;
    public static final int TYPE_SOURCE_APP_UPLOAD = 4;
    public static final int TYPE_SOURCE_ELECTRONIC = 0;
    public static final int TYPE_SOURCE_PICTURE = 3;
    public static final int TYPE_SOURCE_RECORD = 2;
    public static final int TYPE_SOURCE_VEDIO = 5;
    private RequestBody file;
    private String fileID;
    private String fileLocalPath;
    private String fileMD5;
    private String filePath;
    private long fileSize;
    private int source;
    private String sourceID;

    public static final class FileInfoTable {
        public static final String NAME = "file_info";

        public static final class Cols {
            public static final String FILE_ID = "file_id";
            public static final String FILE_LOCAL_PATH = "file_local_path";
            public static final String FILE_MD5 = "file_md5";
            public static final String FILE_NAME = "file_name";
            public static final String FILE_PATH = "file_path";
            public static final String SOURCE = "source";
            public static final String SOURCE_ID = "source_id";
        }
    }

    public RequestBody getFile() {
        return this.file;
    }

    public String getFileID() {
        return this.fileID;
    }

    public String getFileLocalPath() {
        return this.fileLocalPath;
    }

    public String getFileMD5() {
        return this.fileMD5;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getSource() {
        return this.source;
    }

    public String getSourceID() {
        return this.sourceID;
    }

    public void setFile(RequestBody requestBody) {
        this.file = requestBody;
    }

    public void setFileID(String str) {
        this.fileID = str;
    }

    public void setFileLocalPath(String str) {
        this.fileLocalPath = str;
    }

    public void setFileMD5(String str) {
        this.fileMD5 = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setSource(int i2) {
        this.source = i2;
    }

    public void setSourceID(String str) {
        this.sourceID = str;
    }
}
