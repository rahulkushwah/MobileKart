package com.synchronoss.spark.mobilekart.service;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseService {

  public static Connection getconnection() {
    Connection con = null;
    try {
      // step1 load the driver class
      Class.forName("oracle.jdbc.driver.OracleDriver");

      // step2 create the connection object
      con = DriverManager.getConnection("jdbc:oracle:thin:@" + "mobilekart.ceolzyzjhhii.ap-south-1.rds.amazonaws.com" + ":" + "1521" + "/" + "ORCL", "awsmasteruser", "rahulkushwah");
    } catch (Exception e) {
      return null;
    }
    return con;
  }

}
