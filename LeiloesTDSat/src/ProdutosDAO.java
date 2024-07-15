/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        String sql = "INSERT INTO produtos (nome, valor, status) values (?,?,?)";

        conn = new conectaDAO().connectDB();

        try {
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());            
            prep.setDouble(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            prep.executeUpdate();
            prep.close();

            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
                                
           } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na ProdutosDAO " + e.getMessage());
        }
    }
        
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        String sql = "SELECT * FROM produtos;";

        conn = new conectaDAO().connectDB();

        try {
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            while (resultset.next()) {
                ProdutosDTO prodDto = new ProdutosDTO();

                prodDto.setId(resultset.getInt("id"));
                prodDto.setNome(resultset.getString("nome"));
                prodDto.setValor(resultset.getInt("valor"));
                prodDto.setStatus(resultset.getString("status"));
                
                listagem.add(prodDto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ListarDao" + e.getMessage());

        }
        return listagem;
    }
    
    
}

