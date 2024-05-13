package Métodos;
import Códigos.Conexao;
import Telas.HelpDeskProduto;
import java.util.Scanner;
import java.sql.*;
public class Logins {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public void LoginFuncionario() throws SQLException{
        Scanner sc = new Scanner(System.in);
        Connection conexao = new Conexao().getConnection();
        System.out.print("ID do Funcionário: ");
        int idFuncionario = sc.nextInt();
        sc.nextLine();
        System.out.print("Senha do Funcionário: ");
        String senhaFuncionario = sc.nextLine();
        String sql = "SELECT COUNT(*) AS total FROM tablefuncionarios WHERE id_funcionario = ? AND senha = ?";
        PreparedStatement stmt  = conexao.prepareStatement(sql);
        stmt.setInt(1, idFuncionario);
        stmt.setString(2, senhaFuncionario);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next() && resultSet.getInt("total") > 0) {
            System.out.println("Funcionário autenticado com sucesso!\n");
            System.out.println("[1] Cadastrar Patrimônio");
            System.out.println("[2] Alterar Dados do Patrimônio");
            System.out.println("[3] Voltar a Página Inicial");
            System.out.print("O que deseja fazer? ");
            int escolhaLoginCorreto = sc.nextInt();
            System.out.println("");
            while(escolhaLoginCorreto != 3){
                while(escolhaLoginCorreto == 1){
                    Cadastros cadPatri = new Cadastros();
                    cadPatri.CadastrarPatrimonio();
                    System.out.println("[1] Cadastrar outro Patrimônio");
                    System.out.println("[2] Alterar Dados do Patrimônio");
                    System.out.println("[3] Voltar a Página Inicial");
                    System.out.print("O que deseja fazer? ");
                    escolhaLoginCorreto = sc.nextInt();
                    System.out.println("");
                }if(escolhaLoginCorreto == 2){
                    sc.nextLine();
                    System.out.print("Digite o código do produto que deseja modificar: ");
                    String codMod = sc.nextLine();
                    String consultaCod = "SELECT * FROM tablepatrimonio WHERE codigo = ?";
                    statement = conexao.prepareStatement(consultaCod);
                    statement.setString(1, codMod); 
                    resultSet = statement.executeQuery();
                    while(resultSet.next() == false){
                        System.out.println("Código de Produto não cadastrado.");
                        System.out.print("Digite um código válido: ");
                        codMod = sc.nextLine();
                        consultaCod = "SELECT * FROM tablepatrimonio WHERE codigo = ?";
                        statement = conexao.prepareStatement(consultaCod);
                        statement.setString(1, codMod); 
                        resultSet = statement.executeQuery();
                    }
                    System.out.println("");
                    System.out.println("[1] Código do Produto");
                    System.out.println("[2] Nome do Produto");
                    System.out.println("[3] Tipo do Produto");
                    System.out.println("[4] Preço do Produto");
                    System.out.println("[5] Descrição do Produto");
                    System.out.print("O que deseja modificar? ");
                    int escolhaMod = sc.nextInt();
                    System.out.println("");
                    AlterarDados modPatri = new AlterarDados();
                    modPatri.AlterarDadosPatrimonio(escolhaMod, codMod);
                }
                System.out.println("[1] Cadastrar Patrimônio");
                System.out.println("[2] Alterar Dados do Patrimônio");
                System.out.println("[3] Voltar a Página Inicial");
                System.out.print("O que deseja fazer? ");
                escolhaLoginCorreto = sc.nextInt();
            }
        }else {
            System.out.println("ID ou senha incorretos.");
            System.out.println("");
            System.out.println("[1] Tentar Novamente");
            System.out.println("[2] Voltar a Página Inicial");
            System.out.print("O que deseja fazer? ");
            int escolhaLoginIncorreto = sc.nextInt();
            System.out.println("");
            if(escolhaLoginIncorreto == 1){
                sc.nextLine();
                LoginFuncionario();
            }else if(escolhaLoginIncorreto == 2){
                sc.nextLine();
            }
        }
    }
    
    
    
    //Código para Login do Cliente abaixo-------------------------
    
    public void LoginCliente() throws SQLException{
        Scanner sc = new Scanner(System.in);
        Connection conexao = new Conexao().getConnection();
        System.out.print("Email cadastrado: ");
        String emailLogin = sc.nextLine();
        System.out.print("Senha cadastrada: ");
        String senhaLogin = sc.nextLine();
        String sql = "SELECT COUNT(*) AS total FROM tablecadastrocliente WHERE email = ? AND senha = ?";
        PreparedStatement stmt  = conexao.prepareStatement(sql);
        stmt.setString(1, emailLogin);
        stmt.setString(2, senhaLogin);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next() && resultSet.getInt("total") > 0) {
            System.out.println("Usuário autenticado com sucesso!");
            System.out.println("");
            System.out.println("[1] Serviço de Ajuda");
            System.out.println("[2] Editar Dados da Conta");
            System.out.println("[3] Realizar Logout");
            System.out.print("O que deseja fazer? ");
            int escolhaHelpDesk = sc.nextInt();
            System.out.println("");
            while(escolhaHelpDesk != 3 ){
                if(escolhaHelpDesk == 1){
                    HelpDeskProduto telaProd = new HelpDeskProduto();
                    telaProd.setVisible(true);
                    sc.nextInt();
                }else if(escolhaHelpDesk == 2){
                    System.out.println("[1] Nome/Sobrenome");
                    System.out.println("[2] Email");
                    System.out.println("[3] Senha");
                    System.out.print("O que deseja modificar? ");
                    System.out.println("");
                    int escolhaModificacao = sc.nextInt();
                    AlterarDados modificacao = new AlterarDados();
                    modificacao.AlterarDadosUsuário(escolhaModificacao, emailLogin);
                    System.out.println("[1] Serviço de Ajuda");
                    System.out.println("[2] Editar Dados da Conta");
                    System.out.println("[3] Realizar Logout");
                    System.out.print("O que deseja fazer? ");
                    escolhaHelpDesk = sc.nextInt();
                }
            }
            System.out.println("Fazendo logout...");
        } else {
            System.out.println("Email ou senha incorretos.");
            System.out.println("");
            System.out.println("[1] Tentar Novamente");
            System.out.println("[2] Realizar Cadastro");
            System.out.print("O que deseja fazer? ");
            int escolhaLoginIncorreto = sc.nextInt();
            if(escolhaLoginIncorreto == 1){
                sc.nextLine();
                LoginCliente();
            }else if(escolhaLoginIncorreto == 2){
                sc.nextLine();
                Cadastros cadastro = new Cadastros();
                cadastro.CadastrarUsuario();
            }
        }
    }
}
