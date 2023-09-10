package org.come.bean;

import java.util.List;

import org.come.entity.ExpensesReceipts;

public class ExpensesReceiptsInfo {

    private List<ExpensesReceipts> list;

    private int pageNum;

    private int pages;

    private long total;

    public long getTotal() {
        return this.total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<ExpensesReceipts> getList() {
        return this.list;
    }
    public void setList(List<ExpensesReceipts> list) {
        this.list = list;
    }
    public int getPageNum() {
        return this.pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPages() {
        return this.pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

}