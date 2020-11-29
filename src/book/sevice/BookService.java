package book.sevice;

import book.bean.Book;
import book.bean.Page;

import java.util.List;

public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(Integer pageNow, Integer pageSize);

    Page<Book> pageByName(Integer pageNow, Integer pageSize, String keyWord);
}
