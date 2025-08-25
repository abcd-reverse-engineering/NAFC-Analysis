package interfaces;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public class IHandler {
    public static final int MSGWHAT0 = 0;
    public static final int MSGWHAT1 = 1;
    public static final int MSGWHAT10 = 10;
    public static final int MSGWHAT11 = 11;
    public static final int MSGWHAT2 = 2;
    public static final int MSGWHAT3 = 3;
    public static final int MSGWHAT4 = 4;
    public static final int MSGWHAT5 = 5;
    public static final int MSGWHAT6 = 6;
    public static final int MSGWHAT7 = 7;
    public static final int MSGWHAT8 = 8;
    public static final int MSGWHAT9 = 9;
    private static HandleWebActListener listenerWebAct;
    private static HandleWebDetailListener listenerWebDet;
    private static HandleWebFlgListener listenerWebFlg;
    public static Holder mHandler = new Holder(Looper.getMainLooper());

    public interface HandleListener {
        public static final Handler mHandler = IHandler.mHandler;

        void handleMsg(Message message);
    }

    public interface HandleWebActListener extends HandleListener {
    }

    public interface HandleWebDetailListener extends HandleListener {
    }

    public interface HandleWebFlgListener extends HandleListener {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static class Holder extends Handler {
        public Holder(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (IHandler.listenerWebFlg != null) {
                IHandler.listenerWebFlg.handleMsg(message);
            }
            if (IHandler.listenerWebAct != null) {
                IHandler.listenerWebAct.handleMsg(message);
            }
            if (IHandler.listenerWebDet != null) {
                IHandler.listenerWebDet.handleMsg(message);
            }
        }
    }

    private IHandler() {
    }

    public static void setHandleMsgListener(HandleListener handleListener) {
        if (handleListener instanceof HandleWebFlgListener) {
            listenerWebFlg = (HandleWebFlgListener) handleListener;
        } else if (handleListener instanceof HandleWebActListener) {
            listenerWebAct = (HandleWebActListener) handleListener;
        } else if (handleListener instanceof HandleWebDetailListener) {
            listenerWebDet = (HandleWebDetailListener) handleListener;
        }
    }
}
