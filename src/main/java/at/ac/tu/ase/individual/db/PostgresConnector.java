package at.ac.tu.ase.individual.db;

import java.sql.*;

public class PostgresConnector {
  private static String url = "jdbc:postgresql://localhost:5432/ase";
  private static String pw = "ase";
  private static String user = "ase";
  private static PostgresConnector instance;
  private Connection connection;

  public static PostgresConnector getInstance() {
    if(instance == null) instance = new PostgresConnector();
    return instance;
  }

  public PostgresConnector() {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(url, user, pw);
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private void selectStuff(){
    try {
      PreparedStatement statement = connection.prepareStatement("SELECT a, b,c FROM table WHERE a = ?");
      statement.setInt(1, 3);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()){
        String a = resultSet.getString("a");
      }

      if (resultSet.next()){
        String a = resultSet.getString("a");
      }
      resultSet.close();
      statement.closeOnCompletion();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void insertStuff(){
    try {
      PreparedStatement statement = connection.prepareStatement("INSERT INTO table (a, b,c)  VALUES (?, ?, ?)");
      statement.setInt(1, 3);
      statement.execute();
      statement.closeOnCompletion();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}
