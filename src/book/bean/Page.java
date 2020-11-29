package book.bean;

import java.util.List;

/**
 *
 * @param <T> item的JavaBean类
 */
public class Page<T> {

    public static final Integer PAGE_SIZE = 3;
    //当前页码
    private Integer pageNow;
    //总页码数量
    private Integer pageNum;
    //每页显示数目
    private Integer PageSize = PAGE_SIZE;
    //总记录数
    private Integer itemNum;
    //当前页面记录集合
    private List<T> items;
    //分页条的请求地址
    private String url;

    private String keyword = "";

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
//        /* 数据边界的有效检查 */
//        if (pageNow < 1) {
//            pageNow = 1;
//        }
//        if (pageNow > pageNum) {
//            pageNow = pageNum;
//        }

        this.pageNow = pageNow;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNow=" + pageNow +
                ", pageNum=" + pageNum +
                ", PageSize=" + PageSize +
                ", itemNum=" + itemNum +
                ", items=" + items +
                ", url='" + url + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
