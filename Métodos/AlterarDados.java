package Métodos;
import Códigos.Conexao;
import java.util.Scanner;
import java.sql.*;
public class AlterarDados {
    
    public void AlterarDadosUsuário(int escolha, String email) throws SQLException{
        Scanner sc = new Scanner(System.in);
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        switch (escolha){
            case 1:
                  {
                    System.out.print("Digite o novo nome: ");
                    String nomeNovo = sc.nextLine();
                    System.out.print("Digite o novo sobrenome: ");
                    String sobrenomeNovo = sc.nextLine();
                    String sql = "update tablecadastrocliente set nome = '" + nomeNovo + "', sobrenome = '" + sobrenomeNovo + "' where email = '" + email + "'";
                    PreparedStatement stmt  = conexao.prepareStatement(sql);
                    stmt.execute();
                    System.out.println("Nome/Sobrenome alterados com sucesso!");
                    System.out.println("");
                    break;
                  }
                
            case 2:
                  {
                    System.out.print("Digite o novo email: ");
                    String emailNovo = sc.nextLine();
                    String consultaEmail = "SELECT * FROM tablecadastrocliente WHERE email = ?";
                    statement = conexao.prepareStatement(consultaEmail);
                    statement.setString(1, emailNovo);
                    resultSet = statement.executeQuery();
                    while(resultSet.next() == true){
                        System.out.println("Email ja cadastrado.");
                        System.out.print("Digite um email diferente: ");
                        emailNovo = sc.nextLine();
                        consultaEmail = "SELECT * FROM tablecadastrocliente WHERE email = ?";
                        statement = conexao.prepareStatement(consultaEmail);
                        statement.setString(1, emailNovo);
                        resultSet = statement.executeQuery();
                    }       String sql = "update tablecadastrocliente set email = '" + emailNovo + "' where email = '" + email + "'";
                    PreparedStatement stmt  = conexao.prepareStatement(sql);
                    stmt.execute();
                    System.out.println("Email alterado com sucesso!");
                    System.out.println("");
                    break;
                  }
                
            case 3:
                  {
                    System.out.print("Digite a nova senha: ");
                    String senhaNova = sc.nextLine();
                    String sql = "update tablecadastrocliente set senha = '" + senhaNova + "' where email = '" + email + "'";
                    PreparedStatement stmt  = conexao.prepareStatement(sql);
                    stmt.execute();
                    System.out.println("Senha alterada com sucesso!");
                    System.out.println("");
                    break;
                  }
        }
    }
    

  
    //Código para Modificar dados do Patrimonio abaixo--------------------------
    
    public void AlterarDadosPatrimonio(int escolha, String codigo) throws SQLException{
        Scanner sc = new Scanner(System.in);
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        switch (escolha) {
            case 1:
                  {
                    System.out.print("Digite o novo código do produto: ");
                    double codNovo = sc.nextDouble();
                    String consultaCod = "SELECT * FROM tablepatrimonio WHERE codigo = ?";
                    statement = conexao.prepareStatement(consultaCod);
                    statement.setDouble(1, codNovo);
                    resultSet = statement.executeQuery();
                    while(resultSet.next() == true){
                        System.out.println("Código de Produto ja cadastrado.");
                        System.out.print("Digite um código diferente: ");
                        codNovo = sc.nextDouble();
                        consultaCod = "SELECT * FROM tablepatrimonio WHERE codigo = ?";
                        statement = conexao.prepareStatement(consultaCod);
                        statement.setDouble(1, codNovo);
                        resultSet = statement.executeQuery();
                    }       String sql = "update tablepatrimonio set codigo = " + codNovo + " where codigo = '" + codigo + "'";
                    PreparedStatement stmt  = conexao.prepareStatement(sql);
                    stmt.execute();
                    System.out.println("Código do Produto alterado com sucesso!");
                    System.out.println("");
                    break;
                  }
                  
            case 2:
                  {
                    System.out.print("Digite o novo nome para o produto: ");
                    String nomeNovo = sc.nextLine();
                    String sql = "update tablepatrimonio set nome = '" + nomeNovo + "' where codigo = '" + codigo + "'";
                    PreparedStatement stmt  = conexao.prepareStatement(sql);
                    stmt.execute();
                    System.out.println("Nome do Produto alterado com sucesso!");
                    System.out.println("");
                    break;
                  }
                 
            case 3: 
                  {
                    System.out.print("Digite um novo tipo para o produto: ");
                    String tipoNovo = sc.nextLine();
                    String sql = "update tablepatrimonio set tipo = '" + tipoNovo + "' where codigo = '" + codigo + "'";
                    PreparedStatement stmt  = conexao.prepareStatement(sql);
                    stmt.execute();
                    System.out.println("Tipo do Produto alterado com sucesso!");
                    System.out.println("");
                    break;
                  }
                  
            case 4:
                  {
                    System.out.print("Digite um novo preço para o produto: ");
                    double precoNovo = sc.nextDouble();
                    String sql = "update tablepatrimonio set preco = '" + precoNovo + "' where codigo = '" + codigo + "'";
                    PreparedStatement stmt  = conexao.prepareStatement(sql);
                    stmt.execute();
                    System.out.println("Preço do Produto alterado com sucesso!");
                    System.out.println("");
                    break;
                  }
                  
            case 5:
                  {
                    System.out.print("Digite uma nova descrição para o produto: ");
                    String descricaoNovo = sc.nextLine();
                    String sql = "update tablepatrimonio set descricao = '" + descricaoNovo + "' where codigo = '" + codigo + "'";
                    PreparedStatement stmt  = conexao.prepareStatement(sql);
                    stmt.execute();
                    System.out.println("Descrição do Produto alterado com sucesso!");
                    System.out.println("");
                    break;
                  }
        }
    }
}
