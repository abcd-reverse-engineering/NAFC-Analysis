package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class WhiteTelBean extends BaseBean {
    private String areaName;
    private List<String> list;

    public String getAreaName() {
        return this.areaName;
    }

    public List<String> getList() {
        return this.list;
    }

    public void setAreaName(String str) {
        this.areaName = str;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
