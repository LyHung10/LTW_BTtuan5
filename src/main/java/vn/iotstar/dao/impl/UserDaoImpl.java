package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public UserModel findByUserName(String username) {
		String sql = "select * from users where username =?";
		try {
			Connection conn = new DBConnectSQL().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); // truyen tham so
			ResultSet rs = ps.executeQuery(); // thưc thi phất bieur prepare tồi đưa kq vào resultset
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("image"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreatedate(rs.getDate("createdate"));

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("image"), rs.getString("fullname"), rs.getString("email"), rs.getInt("roleid"),
						rs.getString("phone"), rs.getDate("createDate")));
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "select * from users where id =?";
		try {
			Connection conn = new DBConnectSQL().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id); // truyen tham so
			ResultSet rs = ps.executeQuery(); // thưc thi phất bieur prepare tồi đưa kq vào resultset
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("image"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreatedate(rs.getDate("createdate"));

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
	    String sql = "INSERT INTO users( username, password, fullname, email, phone) VALUES ( ?, ?, ?, ?, ?)";

	    try {
	        conn = new DBConnectSQL().getConnection(); // Kết nối đến cơ sở dữ liệu
	        ps = conn.prepareStatement(sql); // Ném câu SQL vào cho thực thi
	        System.out.println(user.toString()); // Thêm dòng này
	        
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getFullname());
	        ps.setString(4, user.getEmail());
	        ps.setString(5, user.getPhone());

	        ps.executeUpdate(); // Thực thi câu lệnh
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý lỗi SQL
	    } catch (Exception e) { // Bắt mọi loại ngoại lệ khác
	        e.printStackTrace();
	    } finally {
	        // Đóng tài nguyên trong khối finally
	        try {
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

	
	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from users where email = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;

	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where username = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "select * from [users] where phone = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
			// Handle exception
		}
		return duplicate;
	}
	public static void main(String[] args) {
		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.print(userDao.checkExistUsername("hung"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
