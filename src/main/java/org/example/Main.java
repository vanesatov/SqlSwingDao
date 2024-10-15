package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/ad";
        String user = "root";
        String pass = "pwd";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            try( PreparedStatement pst = con.prepareStatement("select * from games where id = ?")) {
                pst.setInt(1, 8);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    System.out.println(rs.getString("title"));
                    System.out.println(rs.getString("platform"));
                    System.out.println(rs.getString("year"));
                    System.out.println("------------------------------------");
                }




            }




/*            try (Statement st = con.createStatement()) {
                ResultSet resultado = st.executeQuery("SELECT * FROM games WHERE  year<2015");

                while (resultado.next()) {
                    System.out.println(resultado.getString("title"));
                    System.out.println(resultado.getString("platform"));
                    System.out.println(resultado.getString("year"));
                    System.out.println("------------------------------------");


                }
            }
  */              ;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
    }