package book.bean;

import java.math.BigDecimal;

public class Book {

    private Integer id;
    private String name;
    private String author;
    private BigDecimal discount;
    private BigDecimal price;
    private String imgPath = "static/img/default.jpg";

    public Book() {
    }

    public Book(Integer id, String name, String author, BigDecimal discount, BigDecimal price, String imgPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.discount = discount;
        this.price = price;
        //imgPath不为空
        if(imgPath != null && imgPath != ""){
            this.imgPath = imgPath;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        //imgPath不为空
        if(imgPath != null && imgPath != ""){
            this.imgPath = imgPath;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
