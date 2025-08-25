package bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OcrBean {
    private int direction;
    private long log_id;
    private List<WordsResultBean> words_result = new ArrayList();
    private int words_result_num;

    public static class WordsResultBean {
        private String words;

        public String getWords() {
            return this.words;
        }

        public void setWords(String str) {
            this.words = str;
        }
    }

    public int getDirection() {
        return this.direction;
    }

    public long getLog_id() {
        return this.log_id;
    }

    public List<WordsResultBean> getWords_result() {
        return this.words_result;
    }

    public int getWords_result_num() {
        return this.words_result_num;
    }

    public void setDirection(int i2) {
        this.direction = i2;
    }

    public void setLog_id(long j2) {
        this.log_id = j2;
    }

    public void setWords_result(List<WordsResultBean> list) {
        this.words_result = list;
    }

    public void setWords_result_num(int i2) {
        this.words_result_num = i2;
    }
}
