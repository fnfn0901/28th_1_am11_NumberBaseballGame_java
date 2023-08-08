package Numbaseballgame;

import java.sql.*;

public class Database {
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost:3306/baseballdb";
	String user = "root";
	String passwd = "";	
	PreparedStatement pstmt;
	
	int bestTime = 0;
	
	Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			System.out.println("Connect Success");
		} catch(Exception e) {
			System.out.println("Connect Failure : " + e.toString());
		}
		
	}
	
	
	boolean logincheck(String _i, String _p) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		
		try {
			String checkingStr = "SELECT password FROM user WHERE id='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			while(result.next()) {
				if(pw.equals(result.getString("password"))) {
					flag = true;
					System.out.println("Login Success");
				}
				
				else {
					flag = false;
					System.out.println("Login Failure");
				}
				count++;
			}
		} catch(Exception e) {
			flag = false;
			System.out.println("Login Failure : " + e.toString());
		}
		
		return flag;
	}
	boolean joinCheck(String _i, String _p) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
			
		try {
			String insertStr = "INSERT INTO user (id, password) VALUES (?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(insertStr);
			
			pstmt.setString(1, id);
	        pstmt.setString(2, pw);
	        pstmt.executeUpdate();
				
			flag = true;
			System.out.println("Welcome");
		} catch(Exception e) {
			flag = false;
			System.out.println("Join Failure : " + e.toString());
		}
			
		return flag;
	}
	
	public int dbBestTime(int levelNum, int playTime, String userID) {
		
		String sql4 = "SELECT level1Time FROM user  WHERE id = ?";
		String sql5 = "SELECT level2Time FROM user  WHERE id = ?";
		String sql6 = "SELECT level3Time FROM user  WHERE id = ?";
		
		
		if (levelNum == 2) {
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseballdb", "root", "");
				PreparedStatement pstmt4 = conn.prepareStatement(sql4)) {


	            pstmt4.setString(1, userID);
	            
	            ResultSet rs = pstmt4.executeQuery();

	            
	            if (rs.next()) {
	                
	                bestTime = rs.getInt("level1Time");
	            }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			
			
		} 
		else if (levelNum == 3) {
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseballdb", "root", "");
				PreparedStatement pstmt5 = conn.prepareStatement(sql5)) {

	            pstmt5.setString(1, userID);

	            ResultSet rs = pstmt5.executeQuery();

	            if (rs.next()) {
	                bestTime = rs.getInt("level2Time");
	            }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
		}
		else if (levelNum == 4) {
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseballdb", "root", "");
				PreparedStatement pstmt6 = conn.prepareStatement(sql6)) {

		            pstmt6.setString(1, userID);

		            ResultSet rs = pstmt6.executeQuery();

		            if (rs.next()) {
		                bestTime = rs.getInt("level3Time");
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		}
		
		return bestTime;
	
	}
	
	
	public void dbChange(int levelNum, int playTime, String userID) {
		
		String sqll = "UPDATE user SET level1Time = CASE WHEN level1Time IS NULL OR level1Time > ? THEN ? ELSE level1Time END WHERE id = ?";
		String sql2 = "UPDATE user SET level2Time = CASE WHEN level2Time IS NULL OR level2Time > ? THEN ? ELSE level2Time END WHERE id = ?";
		String sql3 = "UPDATE user SET level3Time = CASE WHEN level3Time IS NULL OR level3Time > ? THEN ? ELSE level3Time END WHERE id = ?";
		
		
		
		System.out.println(userID);
		
		if (levelNum == 2) {
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseballdb", "root", "");
					PreparedStatement pstmt1 = conn.prepareStatement(sqll)) {
		            pstmt1.setInt(1, playTime);
		            pstmt1.setInt(2, playTime);
		            pstmt1.setString(3, userID);

		            int rowsAffected = pstmt1.executeUpdate();

		            System.out.println("업데이트된 로우 개수: " + rowsAffected);

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			
			
		} 
		else if (levelNum == 3) {
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseballdb", "root", "");
				PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {

			    // 업데이트할 값과 해당 로우를 식별하는 기준을 설정합니다.
				pstmt2.setInt(1, playTime);
	            pstmt2.setInt(2, playTime);
	            pstmt2.setString(3, userID);

	            // 쿼리를 실행합니다.
	            int rowsAffected = pstmt2.executeUpdate();

	            // 업데이트 된 로우의 개수를 출력합니다.
	            System.out.println("업데이트된 로우 개수: " + rowsAffected);


			} catch (SQLException e) {
			    e.printStackTrace();
			}
		}
		else if (levelNum == 4) {
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseballdb", "root", "");
					PreparedStatement pstmt3 = conn.prepareStatement(sql3)) {

				// 업데이트할 값과 해당 로우를 식별하는 기준을 설정합니다.
				pstmt3.setInt(1, playTime);
	            pstmt3.setInt(2, playTime);
	            pstmt3.setString(3, userID);

	            // 쿼리를 실행합니다.
	            int rowsAffected = pstmt3.executeUpdate();

	            // 업데이트 된 로우의 개수를 출력합니다.
	            System.out.println("업데이트된 로우 개수: " + rowsAffected);


			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			
			
		}
	}
		
 }
