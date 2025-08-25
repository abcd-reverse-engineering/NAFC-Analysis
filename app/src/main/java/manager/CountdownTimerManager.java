package manager;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.heytap.mcssdk.constant.a;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class CountdownTimerManager {
    private CountDownTimer mCountDownTimer;

    public interface CountDownTimerListener {
        void onFinish();

        void onTick(int i2);
    }

    private static class SingletonHolder {
        private static final CountdownTimerManager INSTANCE = new CountdownTimerManager();

        private SingletonHolder() {
        }
    }

    public static CountdownTimerManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void endCountDownTimer() {
        try {
            if (this.mCountDownTimer != null) {
                this.mCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void startCountDownTimer(TextView textView) {
        startCountDownTimer(textView, -1);
    }

    private CountdownTimerManager() {
    }

    public void startCountDownTimer(final TextView textView, final int i2) {
        try {
            endCountDownTimer();
            this.mCountDownTimer = new CountDownTimer(a.f5800d, 1000L) { // from class: manager.CountdownTimerManager.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    try {
                        textView.setEnabled(true);
                        textView.setText("获取验证码");
                        if (i2 == -1) {
                            textView.setTextColor(textView.getResources().getColor(R.color.blue));
                        } else {
                            textView.setTextColor(textView.getResources().getColor(i2));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    CountdownTimerManager.this.endCountDownTimer();
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    if (j2 == a.f5800d) {
                        j2 -= 100;
                    }
                    try {
                        textView.setEnabled(false);
                        textView.setText("重新获取(" + (j2 / 1000) + "s)");
                        textView.setTextColor(textView.getResources().getColor(R.color.colorGray));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            };
            textView.setEnabled(false);
            this.mCountDownTimer.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void startCountDownTimer(CountDownTimerListener countDownTimerListener) {
        startCountDownTimer(60L, countDownTimerListener);
    }

    public void startCountDownTimer(long j2, final CountDownTimerListener countDownTimerListener) {
        try {
            endCountDownTimer();
            this.mCountDownTimer = new CountDownTimer(j2 * 1000, 1000L) { // from class: manager.CountdownTimerManager.2
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    try {
                        countDownTimerListener.onFinish();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    CountdownTimerManager.this.endCountDownTimer();
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    try {
                        countDownTimerListener.onTick((int) (j3 / 1000));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            };
            this.mCountDownTimer.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
