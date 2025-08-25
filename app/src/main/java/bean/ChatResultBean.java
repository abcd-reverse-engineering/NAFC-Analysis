package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ChatResultBean extends BaseBean {
    private Long id;
    private Long suspectAccountHeadFileID;
    private Long victimAccountHeadFileID;

    public Long getId() {
        return this.id;
    }

    public Long getSuspectAccountHeadFileID() {
        return this.suspectAccountHeadFileID;
    }

    public Long getVictimAccountHeadFileID() {
        return this.victimAccountHeadFileID;
    }

    public void setId(Long l2) {
        this.id = l2;
    }

    public void setSuspectAccountHeadFileID(Long l2) {
        this.suspectAccountHeadFileID = l2;
    }

    public void setVictimAccountHeadFileID(Long l2) {
        this.victimAccountHeadFileID = l2;
    }
}
