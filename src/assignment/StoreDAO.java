package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO {

	Connection con;

	static {
		System.out.println("Driver Loading");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error in Driver Loading: " + cnfe);
		}
	}

	public StoreDAO() {
		System.out.println("Establishing Connection");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront", "root", "mysql");
		} catch (SQLException sqle) {
			System.out.println("Error Connecting Database: " + sqle);
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				closeConnection();
			}
		});
	}

	public List<StoreEntity> getAllData() {
		List<StoreEntity> orderDetails = new ArrayList<StoreEntity>();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM storefront WHERE status = 'Shipped' ORDER BY OrderDate ASC");
			while (rs.next()) {
				StoreEntity se = new StoreEntity();
				se.setId(rs.getInt(1));
				se.setOrderId(rs.getInt(2));
				se.setUserName(rs.getString(3));
				se.setPid(rs.getInt(4));
				se.setPname(rs.getString(5));
				se.setOrderDate(rs.getString(8));
				se.setOrderTotal(rs.getInt(6));
				se.setOrderStatus(rs.getString(7));

				orderDetails.add(se);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				st.close();
			} catch (Exception e) {
			}
		}
		return orderDetails;
	}

	
	  public void deleteItem() { 
		  Statement st = null; 
		  ResultSet rs = null; 
		  try { 
			  st = con.createStatement(); 
			  rs = st.executeQuery("SELECT p.ProductId"
					  + "FROM product p"
					  + "LEFT JOIN orders o ON o.ProductId = p.ProductId"
					  + "WHERE o.ProductId IS NULL");
	  
	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				st.close();
			} catch (Exception e) {
			}
		}
	  
	  }
	  
	 
//	public int[] addbatchimages() {
//		Statement st = null;
//		ResultSet rs = null;
//		int[] count = null;
//		try {
//			st = con.createStatement();
//			con.setAutoCommit(false);
//			String SQL = "UPDATE product SET ImageURL = 'https://m.media-amazon.com/images/I/51q2t2DUpaL._AC_SX425_.jpg'"
//					+ "WHERE ProductId = 29";
//			st.addBatch(SQL);
//			String SQL1 = "UPDATE product SET ImageURL = 'https://m.media-amazon.com/images/I/71vFoc5xVLL._UX569_.jpg'"
//					+ "WHERE ProductId = 30";
//			st.addBatch(SQL1);
//			String SQL2 = "UPDATE product SET ImageURL = 'https://5.imimg.com/data5/QC/KO/MY-3749260/gold-women-necklaces-500x500.jpg'"
//					+ "WHERE ProductId = 31";
//			st.addBatch(SQL2);
//			String SQL3 = "UPDATE product SET ImageURL = 'https://cdn.shopify.com/s/files/1/0057/8938/4802/files/2_a25aff7a-b5c4-4565-a111-6e1ce2d5b5f0.png?v=1624268771'"
//					+ "WHERE ProductId = 32";
//			st.addBatch(SQL3);
//			String SQL4 = "UPDATE product SET ImageURL = 'https://m.media-amazon.com/images/I/61PLjJc9YfL._AC_UY1000_.jpg'"
//					+ "WHERE ProductId = 33";
//			st.addBatch(SQL4);
//			count = st.executeBatch();
//
//			con.commit();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//			} catch (Exception e) {
//			}
//			try {
//				st.close();
//			} catch (Exception e) {
//			}
//		}
//		return count;
//	}

	public List<StoreEntity> getCategoryData() {
		List<StoreEntity> category = new ArrayList<StoreEntity>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(
					"select distinct productcategories.CategoryName , Count(distinct product.ItemName) as items"
							+ " from productcategories , product"
							+ " where productcategories.CategoryId = product.CategoryId "
							+ " group by productcategories.CategoryName"
							+ " ORDER BY productcategories.CategoryName ASC");
			while (rs.next()) {
				StoreEntity se = new StoreEntity();
				se.setOrderStatus(rs.getString(1));
				se.setId(rs.getInt(2));

				category.add(se);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				st.close();
			} catch (Exception e) {
			}
		}
		return category;
	}

	protected void closeConnection() {
		System.out.println(" Closing Connection ");
		// resources to be close
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
