package ru.stqa.alena.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.alena.mantis.model.UserData;
import ru.stqa.alena.mantis.model.Users;

import java.sql.*;

public class DbConnectionTests {
  @Test
    public void testDbConnection(){
      Connection conn = null;
      try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/mantisbt-2.21.0?user=root&password=");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("id, username, email, password from mantis_user_table");
        Users users = new Users();
        while (rs.next()) {
          users.add(new UserData().withId(rs.getInt("id")).withUsername(rs.getString("username"))
                  .withEmail(rs.getString("email")).withPassword(rs.getString("password")));
        }
        rs.close();
        st.close();
        conn.close();
        System.out.println(users);

      } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
      }
    }
  }