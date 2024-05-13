package Códigos;
import java.sql.*;
public class Conexao {
    public Connection getConnection()throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/APS-Database", "postgres", "120305");
        return conexao;
    }
}
