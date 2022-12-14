package DAO;

import model.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CaixaDAO {
    Connection conn;
    
    
    public ResultSet loginCaixa(Caixa objCaixa) throws ClassNotFoundException{
        
        conn = new BancoDAO().conectaBD();
        
        try {
            String sql = "SELECT * FROM vendedor WHERE email_vendedor = ? AND senha_vendedor = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objCaixa.getEmailCaixa());
            pstm.setString(2, objCaixa.getSenhaCaixa());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CaixaDAO " + erro);
            return null;
        }
    }
}
