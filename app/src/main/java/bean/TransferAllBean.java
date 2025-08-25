package bean;

import java.util.ArrayList;
import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class TransferAllBean extends BaseBean {
    private TransferBean transferBean = new TransferBean();
    private List<TransferFileBean> transferRecord = new ArrayList();
    private List<TransferFileBean> transferDetail = new ArrayList();

    public TransferBean getTransferBean() {
        return this.transferBean;
    }

    public List<TransferFileBean> getTransferDetail() {
        return this.transferDetail;
    }

    public List<TransferFileBean> getTransferRecord() {
        return this.transferRecord;
    }

    public void setTransferBean(TransferBean transferBean) {
        this.transferBean = transferBean;
    }

    public void setTransferDetail(List<TransferFileBean> list) {
        this.transferDetail = list;
    }

    public void setTransferRecord(List<TransferFileBean> list) {
        this.transferRecord = list;
    }
}
