package cn.siggy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.siggy.entity.Category;
import cn.siggy.util.BaseDao;

public class CategoryDao extends BaseDao{
	public List<Category> getList() {
		String sql = "select * from category";
		List<Category> list = new ArrayList<Category>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while(rs.next()) {
				list.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return list.size() > 0 ? list : null;
	}
}
