package bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ChatAllBean {
    private ChatBean chatBean;
    private int chatType;
    private Long conversationID;
    private List<ChatDetailBean> txtChatDetailList = new ArrayList();
    private List<ChatDetailBean> audioVictimChatDetailList = new ArrayList();
    private List<ChatDetailBean> audioSuspectChatDetailList = new ArrayList();
    private List<ChatDetailBean> videoChatDetailList = new ArrayList();
    private List<TransferAllBean> transferAllBeanList = new ArrayList();

    public List<ChatDetailBean> getAudioSuspectChatDetailList() {
        return this.audioSuspectChatDetailList;
    }

    public List<ChatDetailBean> getAudioVictimChatDetailList() {
        return this.audioVictimChatDetailList;
    }

    public ChatBean getChatBean() {
        return this.chatBean;
    }

    public int getChatType() {
        return this.chatType;
    }

    public Long getConversationID() {
        return this.conversationID;
    }

    public List<TransferAllBean> getTransferAllBeanList() {
        return this.transferAllBeanList;
    }

    public List<ChatDetailBean> getTxtChatDetailList() {
        return this.txtChatDetailList;
    }

    public List<ChatDetailBean> getVideoChatDetailList() {
        return this.videoChatDetailList;
    }

    public void setAudioSuspectChatDetailList(List<ChatDetailBean> list) {
        this.audioSuspectChatDetailList = list;
    }

    public void setAudioVictimChatDetailList(List<ChatDetailBean> list) {
        this.audioVictimChatDetailList = list;
    }

    public void setChatBean(ChatBean chatBean) {
        this.chatBean = chatBean;
    }

    public void setChatType(int i2) {
        this.chatType = i2;
    }

    public void setConversationID(Long l2) {
        this.conversationID = l2;
    }

    public void setTransferAllBeanList(List<TransferAllBean> list) {
        this.transferAllBeanList = list;
    }

    public void setTxtChatDetailList(List<ChatDetailBean> list) {
        this.txtChatDetailList = list;
    }

    public void setVideoChatDetailList(List<ChatDetailBean> list) {
        this.videoChatDetailList = list;
    }
}
