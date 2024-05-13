package Códigos;
import Métodos.Cadastros;
import Métodos.Logins;
import java.sql.*;
import java.util.Scanner;
public class Principal{
    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);
        Connection conexao = new Conexao().getConnection();
        int escolhaUser = 0;
        do{
            System.out.println("");
            System.out.println("BEM-VINDO AO MENU PRINCIPAL");
            System.out.println("[1] Login");
            System.out.println("[2] Cadastre-se");
            System.out.println("[3] Fechar programa");
            try { Thread.sleep (1000); } catch (InterruptedException ex) {}
            System.out.print("O que deseja fazer? ");
            escolhaUser = sc.nextInt();
            System.out.println("");
            if(escolhaUser == 1){
                System.out.println("BEM-VINDO A PÁGINA DE LOGIN");
                System.out.println("[1] Funcionário");
                System.out.println("[2] Cliente");
                System.out.print("Deseja realizar login como: ");
                int escolhaTipoLogin = sc.nextInt();
                System.out.println("");
                if(escolhaTipoLogin == 1){
                    Logins loginFuncionario = new Logins();
                    loginFuncionario.LoginFuncionario();
                }else if(escolhaTipoLogin == 2){
                    Logins loginFuncionario = new Logins();
                    loginFuncionario.LoginCliente();
                }
            }else if(escolhaUser == 2){
                Cadastros cadastro = new Cadastros();
                cadastro.CadastrarUsuario();
            }
        }while(escolhaUser != 3);
        System.out.println("");
        System.out.println("Fechando programa...");
    }
}