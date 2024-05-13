package Telas;
import Códigos.Conexao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProdutoDescricao extends javax.swing.JFrame {
    public ProdutoDescricao() {
        initComponents();
    }
    public void varprob(Ligacao ligamento){
        labelLigacao.setText(ligamento.getProblema());
    }


//Código Quando o Botão Enviar for Pressionado--------------------------------------------------------------------  

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(jTextCOD.getText().length() != 0 && jTextCPF.getText().length() != 0 && jTextDESC.getText().length() != 0){
            Connection conexao;
            try {
                ResultSet resultSet = null;
                conexao = new Conexao().getConnection();
                String consultaCod = "SELECT * FROM tablepatrimonio WHERE codigo = ?";
                PreparedStatement stmt = conexao.prepareStatement(consultaCod);
                stmt.setString(1, jTextCOD.getText()); 
                resultSet = stmt.executeQuery();
                if(resultSet.next() == false){
                    String texto = "Erro! Digite um código de produto válido.";
                    jLabel5.setText(texto);
                }else{
                    String texto = "Seu chamado foi enviado com sucesso! Aguarde nossa resposta.";
                    jLabel5.setText(texto);
                    try {
                        String sql = "insert into tableproblemaproduto(tipoproblema, cpf, descricaoproblema, codproduto) values ('" + labelLigacao.getText() + "', '" + jTextCPF.getText() + "', '" + jTextDESC.getText() + "', " + jTextCOD.getText() + ");";
                        stmt  = conexao.prepareStatement(sql);
                        stmt.execute();
                    }catch (SQLException ex) {
                        Logger.getLogger(ProdutoDescricao.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDescricao.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            String texto = "Seu chamado não foi concluído! Digite valores válidos.";
            jLabel5.setText(texto);
        }
    }
