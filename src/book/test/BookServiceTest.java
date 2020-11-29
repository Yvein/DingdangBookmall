package book.test;

import book.bean.Book;
import book.sevice.BookService;
import book.sevice.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "北欧神话（茅盾先生写就的神话普及书！豆瓣高分绝…",
                "茅盾, 王浣", new BigDecimal(12.99), new BigDecimal(48.00), ""));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(10);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(10, "北欧神话（茅盾先生写就的神话普及书！豆瓣高分绝…",
                "茅盾, 王浣", new BigDecimal(12.99), new BigDecimal(48.00), "static/img/seckill-item10.jpg"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(10));
    }

    @Test
    public void queryBooks() {
        for(Book queryBook: bookService.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1,4));
        for(Book items: bookService.page(1,4).getItems()){
            System.out.println(items);
        }
    }

    @Test
    public void pageByName(){
        System.out.println(bookService.pageByName(1,3, "【"));
        for(Book items: bookService.pageByName(1,3, "【").getItems()){
            System.out.println(items);
        }
    }

}