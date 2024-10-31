package com.ibm.db2.samples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB2ConnectionSample {

    public static void main(String[] args) {
        // DB2データベースへの接続情報
        // String jdbcUrl = "jdbc:db2://:/";
        String jdbcUrl = "jdbc:db2://localhost:50000/testdb";
        String user = "db2inst1";
        String password = "Passw0rd";

        // JDBCコネクションの初期化
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBCドライバのロード
            Class.forName("com.ibm.db2.jcc.DB2Driver");

            // DB2データベースへの接続
            connection = DriverManager.getConnection(jdbcUrl, user, password);

            // SQLクエリの実行
            statement = connection.createStatement();
            // resultSet = statement.executeQuery("SELECT * FROM ");
            resultSet = statement.executeQuery("SELECT * FROM test_table");

            // 結果の表示
            while (resultSet.next()) {
                // System.out.println("Column1: " + resultSet.getString("COLUMN1"));
                // System.out.println("Column2: " + resultSet.getString("COLUMN2"));
                System.out.println("Column1: " + resultSet.getString("COL1"));
                System.out.println("Column2: " + resultSet.getString("COL2"));
                // 必要に応じて他の列も表示
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // リソースのクローズ
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}