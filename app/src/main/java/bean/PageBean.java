package bean;

import java.util.List;

/* loaded from: classes.dex */
public class PageBean<T> {
    private List<T> rows;
    private int total;
    private int totalPages;

    public List<T> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setRows(List<T> list) {
        this.rows = list;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }

    public void setTotalPages(int i2) {
        this.totalPages = i2;
    }
}
