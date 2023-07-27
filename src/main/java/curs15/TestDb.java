package curs15;

import java.sql.Connection;

public class TestDb {
	static String URL = "jdbc:mysql://keytraining-demo.c050jeowbe1q.eu-central-1.rds.amazonaws.com:3306/KeyTraining";
	static String USER = "demouser";
	static String PASS = "demouser";

	public static void main(String[] args) {

		Connection conn= DbConnection.openDbConnection(URL, USER, PASS);
		
		String selectQuery = "select * from customers;";
		
		System.out.println(DBQuerys.dbSelectQuery(conn, selectQuery));
		
		String updateQuery="update customers set CustomerName = 'TestDragos' where CustomerName = 'TestElena'";
		DBQuerys.dbUpdateQuery(conn, updateQuery);
	    System.out.println();
	
	    String deleteQuery="delete from customers where CustomerName='TestDragos22';";
	    DBQuerys.dbDeleteQuery(conn, deleteQuery);
	    System.out.println(DBQuerys.dbSelectQuery(conn, deleteQuery));
	    DbConnection.closeDbConnection(conn);
	}

}
