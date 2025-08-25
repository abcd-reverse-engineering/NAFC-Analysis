package network.account;

/* loaded from: classes2.dex */
public class RegisterInfo {
    private int responseCode;
    private String responseText;
    private int result;
    private String resultText;
    private int score;

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseText() {
        return this.responseText;
    }

    public int getResult() {
        return this.result;
    }

    public String getResultText() {
        return this.resultText;
    }

    public int getScore() {
        return this.score;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public void setResponseText(String str) {
        this.responseText = str;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setResultText(String str) {
        this.resultText = str;
    }

    public void setScore(int i2) {
        this.score = i2;
    }
}
