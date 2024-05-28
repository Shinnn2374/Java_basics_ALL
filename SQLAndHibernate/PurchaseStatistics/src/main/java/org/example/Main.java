package org.example;

import java.sql.*;

public class Main {
    static String database = "skillbox";
    static String sqlUrl = "jdbc:mysql://localhost:3306/" + database;
    static String sqlUser = "root";
    static String sqlPassword = "030704Aa030704";
    static String yearFilter = "2018";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT name, month, number" +
                " FROM Courses" +
                " LEFT JOIN" +
                    " (SELECT course_name, MONTH(subscription_date) AS month, COUNT(MONTH(subscription_date)) AS number" +
                        " FROM PurchaseList" +
                        " WHERE subscription_date LIKE '" + yearFilter + "%'" +
                        " GROUP BY course_name, MONTH(subscription_date)" +
                    ") mt" +
                " ON name=course_name" +
                " ORDER BY name, month"
        );

        String courseName = null;
        int firstMonth = 0;
        int lastMonth = 0;
        double purchaseCount = 0;

        while (resultSet.next()) {
            if (resultSet.getString("name").equals(courseName)) {
                // Add next month
                lastMonth = resultSet.getInt("month");
                purchaseCount += resultSet.getInt("number");
            } else {
                // Output current course if exists
                println(courseName, firstMonth, lastMonth, purchaseCount);

                // Init next course
                courseName = resultSet.getString("name");
                lastMonth = firstMonth = resultSet.getInt("month");
                purchaseCount = resultSet.getInt("number");
            }
        }

        println(courseName, firstMonth, lastMonth, purchaseCount);
    }

    private static void println(String courseName, int firstMonth, int lastMonth, double purchaseCount) {
        if (courseName != null) {
            System.out.println(courseName + "\t" + purchaseCount / (lastMonth - firstMonth + 1));
        }
    }
}