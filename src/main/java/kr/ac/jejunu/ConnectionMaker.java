package kr.ac.jejunu;public class ConnectionMaker{	public ConnectionMaker()	{	}public java.sql.Connection getConnection() throws java.lang.ClassNotFoundException, java.sql.SQLException {
        java.lang.Class.forName("com.mysql.jdbc.Driver");
        return java.sql.DriverManager.getConnection("jdbc:mysql://localhost/jeju?characterEncoding=utf-8", "jeju", "jejupw");
    }}