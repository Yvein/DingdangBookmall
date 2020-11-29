package book.test;

import book.dao.BookDao;
import book.dao.impl.BookDaoImpl;
import book.bean.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "洞见：从科学到哲学，打开人类的认知真相（万维钢…",
                "罗伯特•赖特", new BigDecimal(15.99), new BigDecimal(49.04), null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(9, "洞见：从科学到哲学，打开人类的认知真相（万维钢…",
                "罗伯特•赖特", new BigDecimal(15.99), new BigDecimal(49.04), "static/img/seckill-item9.jpg"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(4));
    }

    @Test
    public void queryBooks() {
        for(Book queryBook: bookDao.queryBooks()){
            System.out.println(queryBook);
        }

    }

    @Test
    public void queryForItemNumber() {
        System.out.println(bookDao.queryForItemNumber());
    }

    @Test
    public void queryForPageItems() {
        for(Book pageItem: bookDao.queryForPageItems(0,4)){
            System.out.println(pageItem);
        }
        for(Book pageItem: bookDao.queryForPageItems(4,4)){
            System.out.println(pageItem);
        }
    }

    @Test
    public void queryForPageItemsByName(){
        for(Book pageItem: bookDao.queryForPageItemsByName(3,1,"【")){
            System.out.println(pageItem);
        }
    }
}