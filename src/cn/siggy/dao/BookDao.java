package cn.siggy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.siggy.entity.Book;
import cn.siggy.util.BaseDao;
import cn.siggy.util.PageUtil;

public class BookDao extends BaseDao {
	// 查询所有书籍
	public List<Book> getAll(PageUtil pu) {
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book limit ?, ?";
		// 查询的操作
		try {
			ResultSet rs = this.executeQuery(sql,(pu.getCurrentPage()-1)*pu.getPageSize(),pu.getPageSize());
			while (rs.next()) {
				list.add(new Book(rs.getInt(1), rs.getString(2), rs
						.getDouble(3), rs.getString(4), rs.getDate(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		return list;
	}
	//获取总记录数
	public int count() {
		String sql= "select count(1) from book";
		ResultSet rs = this.executeQuery(sql);
		try {
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return 0;
	}
	public Book getById(int id) {
		String sql = "select * from book where id = ?";
		// 查询的操作
		try {
			ResultSet rs = this.executeQuery(sql, id);
			while (rs.next()) {
				return new Book(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getString(4), rs.getDate(5),  rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;
	}

	// 添加书籍
	public int add(Book b) {
		String sql = "insert into book(name,price,author,pubDate,categoryId) values(?,?,?,?,?)";
		return this.executeUpdate(sql, b.getName(), b.getPrice(),
				b.getAuthor(),
				new SimpleDateFormat("yyyy-MM-dd").format(b.getPubDate()),b.getCategoryId());
	}

	// 修改书籍
	public int update(Book b) {
		String sql = "update book set name=?,price=?,author=?,pubDate=?,categoryId=? where id=?";
		return this.executeUpdate(sql,b.getName(),b.getPrice(),
				b.getAuthor(),
				new SimpleDateFormat("yyyy-MM-dd").format(b.getPubDate()),
				b.getCategoryId(),
				b.getId());
	}
	
	public int delete(int id) {
		String sql = "delete from book where id=?";
		return this.executeUpdate(sql, id);
	}
}
