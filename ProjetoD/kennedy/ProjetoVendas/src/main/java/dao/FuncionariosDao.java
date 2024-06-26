package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Funcionarios;

/**
 *
 * @author jabes
 */
public class FuncionariosDao {
private Connection con;

    public FuncionariosDao() {
        try {
            this.con = new ConnectionFactory().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastraFuncionario(Funcionarios obj) {
        try {
            String sql = "insert into tb_funcionarios (nome, rg, cpf, email, celular, cep, endereco, numero, complemento, bairro, cidade, estado, senha, cargo, nivel_acesso) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            ps.setString(13, obj.getSenha());
            ps.setString(14, obj.getCargo());
            ps.setString(15, obj.getNivelAcesso());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public void alterarFuncionario(Funcionarios obj) {
        try {

            String sql = "update tb_funcionarios set  nome=?, rg=?, cpf=?, email=?, celular=?, cep=?, "
                    + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?, senha=?, cargo=?, nivel_acesso=?  where id =?";

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
            ps.setString(14, obj.getSenha());
            ps.setString(15, obj.getCargo());
            ps.setString(16, obj.getNivelAcesso());

            ps.setInt(14, obj.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public void excluirFuncionario(Funcionarios obj) {
        try {

            String sql = "delete from tb_funcionarios where id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }
    
    public List<Funcionarios> listarFuncionarios() {
        try {

            List<Funcionarios> lista = new ArrayList<>();

            String sql = "select * from tb_funcionarios";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

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
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("Nivel Acesso"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

    public Funcionarios consultaPorNome(String nome) {
        try {
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();
            Funcionarios obj = new Funcionarios();

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
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("Nivel Acesso"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
    
    public Funcionarios buscaporcpf(String cpf) {
        try {
            String sql = "select * from tb_funcionarios where cpf = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();
            Funcionarios obj = new Funcionarios();

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
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("Nivel Acesso"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
    
    
    
    
    public List<Funcionarios> buscaFuncionarioPorNome(String nome) {
        try {

            List<Funcionarios> lista = new ArrayList<>();

            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

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
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("Nivel Acesso"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }

}