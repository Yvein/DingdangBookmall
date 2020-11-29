package book.dao.impl;

import book.dao.BookDao;
import book.bean.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {

        String sql = "insert into books(name, author, discount, price, img_path) values(?,?,?,?,?);";

        return update(sql, book.getName(), book.getAuthor(),book.getDiscount(),book.getPrice(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {

        String sql ="delete from books where id = ?";

        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {

        String sql = "update books set name = ?, author = ?, discount = ?, price = ?, img_path = ? where id = ?";

        return update(sql, book.getName(), book.getAuthor(),book.getDiscount(),book.getPrice(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {

        String sql = "select id, name, author, discount, price, img_path imgPath from books where id = ?";

        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {

        String sql = "select id, name, author, discount, price, img_path imgPath from books";

        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForItemNumber() {
        String sql = "select count(*) from books";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, Integer pageSize) {
        String sql = "select id, name, author, discount, price, img_path imgPath from books limit ?, ?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public List<Book> queryForPageItemsByName(int begin, Integer pageSize, String keyWord) {
        String sql = "select id, name, author, discount, price, img_path imgPath \n" +
                "from\n" +
                "(select * from books \n" +
                "where name like ? " +
                "or  author like ? " +
                ") as book\n" +
                "limit ?, ?";
        return queryForList(Book.class, sql, "%" + keyWord + "%", "%" + keyWord + "%", begin, pageSize);
    }

}
