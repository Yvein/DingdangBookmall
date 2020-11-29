package book.sevice.impl;

import book.dao.BookDao;
import book.dao.impl.BookDaoImpl;
import book.bean.Book;
import book.bean.Page;
import book.sevice.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNow, Integer pageSize) {
        Page<Book> page = new Page<Book>();

        page.setPageNow(pageNow);
        page.setPageSize(pageSize);
        //总记录数
        Integer itemNum = bookDao.queryForItemNumber();
        page.setItemNum(itemNum);
        //页数
        Integer pageNum = itemNum / pageSize;
        if(itemNum%pageSize > 0){
            pageNum++;
        }
        page.setPageNum(pageNum);

        //当前页码的合法性校验
        if(pageNow < 1){
            pageNow = 1;
        }
        else if(pageNow > pageNum){
            pageNow = pageNum;
        }

        //当前页内记录
        int begin = (pageNow - 1) * pageSize;

        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByName(Integer pageNow, Integer pageSize, String keyWord) {
        Page<Book> page = new Page<Book>();

        //当前页内记录
        int begin = (pageNow - 1) * pageSize;

        List<Book> items = bookDao.queryForPageItemsByName(begin, pageSize, keyWord);

        //总记录数
        Integer itemNum = items.size();
        page.setItemNum(itemNum);

        //页数
        Integer pageNum = itemNum / pageSize;
        if(itemNum%pageSize > 0){
            pageNum++;
        }
        page.setPageNum(pageNum);

        //当前页码的合法性校验
        if(pageNow < 1){
            pageNow = 1;
        }
        else if(pageNow > pageNum){
            pageNow = pageNum;
        }

        page.setPageNow(pageNow);
        page.setPageSize(pageSize);

        //设置当前页数据
        page.setItems(items);
        return page;
    }
}
