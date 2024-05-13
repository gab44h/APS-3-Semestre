package Telas;
import Códigos.Conexao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class HelpDeskProduto extends javax.swing.JFrame {
    public HelpDeskProduto() {
        initComponents();
    }
    public String HelpDeskProd(){
        String problema = "";
        if(jRadioButton1.isSelected() == true){
            problema = "Produto Defeituoso";
        }else if(jRadioButton2.isSelected() == true){
            problema = "Produto Não Foi Entregue";
        }else if(jRadioButton3.isSelected() == true){
            problema = "Produto Diferente do Comprado";
        }else if(jRadioButton5.isSelected() == true){
            problema = "Solicitar Devolução ou Reembolso";
        }else if(jRadioButton4.isSelected() == true){
            String textArea = textProblema.getText();
            problema = textArea;
        }      
        return problema;
    }


//Código Botão Enviar Abaixo----------------------------------------------
  
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Ligacao ligamento = new Ligacao();
        ligamento.setProblema(HelpDeskProd());
        ProdutoDescricao prodDesc = new ProdutoDescricao();
        prodDesc.varprob(ligamento);
        prodDesc.setVisible(true);
    }    


//Código Caixas Selecionáveis Abaixo---------------------------------------

private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(jRadioButton1.isSelected() == true){
            jButton1.setEnabled(true);
            textProblema.setEnabled(false);
        }
    }                                             

private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(jRadioButton2.isSelected() == true){
            jButton1.setEnabled(true);
            textProblema.setEnabled(false);
        }
    }                                             

private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(jRadioButton3.isSelected() == true){
            jButton1.setEnabled(true);
            textProblema.setEnabled(false);
        }
    }

private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(jRadioButton4.isSelected() == true){
            jButton1.setEnabled(true);
            textProblema.setEnabled(true);
        }
    }

private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(jRadioButton5.isSelected() == true){
            jButton1.setEnabled(true);
            textProblema.setEnabled(false);
        }
    }
