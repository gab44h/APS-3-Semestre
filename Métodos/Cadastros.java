package Métodos;
import Códigos.Conexao;
import java.sql.*;
import java.util.Scanner;
public class Cadastros {
    
    public void CadastrarPatrimonio() throws SQLException{       
        Scanner sc = new Scanner(System.in);
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection conexao = new Conexao().getConnection();
        System.out.print("Código do Produto: ");
        String codProd = sc.nextLine();
        
        String consulta = "SELECT * FROM tablepatrimonio WHERE codigo = ?";
        statement = conexao.prepareStatement(consulta);
        statement.setString(1, codProd); 
        resultSet = statement.executeQuery();
        while(resultSet.next() == true){
            System.out.println("Código de Produto ja cadastrado.");
            System.out.print("Digite um código válido: ");
            codProd = sc.nextLine();
            consulta = "SELECT * FROM tablepatrimonio WHERE codigo = ?";
            statement = conexao.prepareStatement(consulta);
            statement.setString(1, codProd); 
            resultSet = statement.executeQuery();
        }
        
        System.out.print("Nome do Produto: ");
        String nomeProd = sc.nextLine();
        System.out.print("Tipo do Produto: ");
        String tipoProd = sc.nextLine();
        System.out.print("Preço do Produto: ");
        double precoProd = sc.nextDouble();
        sc.nextLine();
        System.out.print("Descrição do Produto: ");
        String descricaoProd = sc.nextLine();
        String sql = "insert into tablepatrimonio(codigo, nome, tipo, preco, descricao) values('" + codProd + "', '" + nomeProd + "', '" + tipoProd + "', " + precoProd + ", '" + descricaoProd + "');";
        PreparedStatement stmt  = conexao.prepareStatement(sql);
        stmt.execute();
        System.out.println("Produto Cadastrado com Sucesso!!!");
        System.out.println("");
    }
    
    
    
    //Código para Cadastrar Usuários Abaixo----------------
    
    public void CadastrarUsuario() throws SQLException{
        Scanner sc = new Scanner(System.in);
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection conexao = new Conexao().getConnection();
        System.out.println("");
        System.out.println("BEM-VINDO A PÁGINA DE CADASTRO");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        String consulta = "SELECT * FROM tablecadastrocliente WHERE cpf = ?";
        statement = conexao.prepareStatement(consulta);
        statement.setString(1, cpf); 
        resultSet = statement.executeQuery();
        while(resultSet.next() == true){
            System.out.println("CPF ja cadastrado.");
            System.out.print("Digite um CPF válido: ");
            cpf = sc.nextLine();
            consulta = "SELECT * FROM tablecadastrocliente WHERE cpf = ?";
            statement = conexao.prepareStatement(consulta);
            statement.setString(1, cpf); 
            resultSet = statement.executeQuery();
        }
        System.out.print("Email: ");
        String email = sc.nextLine();
        String consultaEmail = "SELECT * FROM tablecadastrocliente WHERE email = ?";
        statement = conexao.prepareStatement(consultaEmail);
        statement.setString(1, email); 
        resultSet = statement.executeQuery();
        while(resultSet.next() == true){
            System.out.println("Email ja cadastrado.");
            System.out.print("Digite um email diferente: ");
            email = sc.nextLine();
            consultaEmail = "SELECT * FROM tablecadastrocliente WHERE email = ?";
            statement = conexao.prepareStatement(consultaEmail);
            statement.setString(1, email); 
            resultSet = statement.executeQuery();
        }
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        String sql = "insert into tablecadastrocliente(nome, sobrenome, email, senha, cpf) values('" + nome + "', '" + sobrenome + "', '" + email + "', '" + senha + "', '" + cpf + "');";
        PreparedStatement stmt  = conexao.prepareStatement(sql);
        stmt.execute();
        System.out.println("CADASTRO REALIZADO COM SUCESSO!");
        System.out.println("");
    }  
}

