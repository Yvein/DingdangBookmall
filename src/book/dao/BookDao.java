package book.dao;

import book.bean.Book;

import java.util.List;

/**
 * 增、删、改、查
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForItemNumber();

    List<Book> queryForPageItems(int begin, Integer pageSize);

    List<Book> queryForPageItemsByName(int begin, Integer pageSize, String keyWord);
}
