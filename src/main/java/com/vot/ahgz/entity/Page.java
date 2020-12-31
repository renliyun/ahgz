package com.vot.ahgz.entity;


//指定泛型
public class Page<T> {

    private static final long serialVersionUID = 6412051100892337972L;
    // 当期页面得序号
    private Integer pageNum;

    // 当前页面显示条数
    private Integer pageTotal;

    //页面传递得数据
    private T pageData;

    public Page() {
    }

    public Page(Integer pageNum, Integer pageTotal, T pageData) {
        this.pageNum = pageNum;
        this.pageTotal = pageTotal;
        this.pageData = pageData;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Object getPageData() {
        return pageData;
    }

    public void setPageData(T pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageTotal=" + pageTotal +
                ", pageData=" + pageData +
                '}';
    }
}
