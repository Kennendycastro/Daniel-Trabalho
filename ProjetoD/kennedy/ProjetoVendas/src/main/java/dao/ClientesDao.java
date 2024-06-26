package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Clientes;

/**
 *
 * @author jabes
 */
public class ClientesDao {
private Connection con;

    public ClientesDao() {
        try {
            this.con = new ConnectionFactory().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastraClientes(Clientes obj) {
        try {
            String sql = "insert into tb_clientes (nome, rg, cpf, email, celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getRg());
            ps.setString(3, obj.getCpf());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getCelular());
            ps.setString(6, obj.getCep());
            ps.setString(7, obj.getEndereco());
            ps.setInt(8, obj.getNumero());
            ps.setString(9, obj.getComplemento());
            ps.setString(10, obj.getBairro());
            ps.setString(11, obj.getCidade());
            ps.setString(12, obj.getUf());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public void alterarCliente(Clientes obj) {
        try {

            String sql = "update tb_clientes set  nome=?, rg=?, cpf=?, email=?, celular=?, cep=?, "
                    + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?  where id =?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getRg());
            ps.setString(3, obj.getCpf());
            ps.setString(4, obj.getEmail());
            ps.setString(6, obj.getCelular());
            ps.setString(7, obj.getCep());
            ps.setString(8, obj.getEndereco());
            ps.setInt(9, obj.getNumero());
            ps.setString(10, obj.getComplemento());
            ps.setString(11, obj.getBairro());
            ps.setString(12, obj.getCidade());
            ps.setString(13, obj.getUf());

            ps.setInt(14, obj.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public void excluirCliente(Clientes obj) {
        try {

            String sql = "delete from tb_clientes where id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }
    
    public List<Clientes> listarClientes() {
        try {

            List<Clientes> lista = new ArrayList<>();

            String sql = "select * from tb_clientes";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

    public Clientes consultaPorNome(String nome) {
        try {
            String sql = "select * from tb_clientes where nome = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();
            Clientes obj = new Clientes();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
    
    public Clientes buscaporcpf(String cpf) {
        try {
            String sql = "select * from tb_clientes where cpf = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();
            Clientes obj = new Clientes();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
    
    
    
    
    public List<Clientes> buscaClientePorNome(String nome) {
        try {

            List<Clientes> lista = new ArrayList<>();

            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }

}