package jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author jabes
 */
public class TestaConexao {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null,"Conectado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
}
