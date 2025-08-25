package event;

import bean.CallBean;
import java.util.List;

/* loaded from: classes2.dex */
public class CallEventBean {
    private List<CallBean> mStringList;

    public CallEventBean(List<CallBean> list) {
        this.mStringList = list;
    }

    public List<CallBean> getStringList() {
        return this.mStringList;
    }

    public CallEventBean setStringList(List<CallBean> list) {
        this.mStringList = list;
        return this;
    }
}
