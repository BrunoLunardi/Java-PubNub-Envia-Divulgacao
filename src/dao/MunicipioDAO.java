package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import configs.ConexaoUtil;
import dto.MunicipioDTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//classe para executar os comandos SQL 
public class MunicipioDAO {
	
	//inserir topicos no BD
//	public void insert(MunicipioDTO municipioDTO) {
//		
//		try {
//			// ativa conexão com BD
//			Connection connection = ConexaoUtil.getInstance().getConnection();
//			// código sql a ser executado
//			// o ? será trocado, em tempo de execução, pelo valor a ser inserido no BD
//			String sql = "INSERT INTO topicos (topico) VALUES (?)";
//			// realiza uma ponte entre o java e o BD
//			PreparedStatement statement = connection.prepareStatement(sql);
//			// faz a alteração do ? da variavel sql para o valor a ser passado para o insert
//			// primeiro parâmetro indica qual o ponto de interrogação será alterado (1 é o
//			// primeiro, 2 é o segundo...)
//			// segundo parâmetro é o valor a ser inserido
//			statement.setString(1, municipioDTO.getTopico());
//			// Executar o comando sql com os devidos valores
//			statement.execute();
//			// fechar conexao com bd
//			statement.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	//Recupera lista de tópicos no BD
    public List<MunicipioDTO> listaMunicipios() throws ClassNotFoundException, SQLException{

		// ativa conexão com BD
		Connection connection = ConexaoUtil.getInstance().getConnection();
        
		PreparedStatement statement = null;
        ResultSet rs = null;

        List<MunicipioDTO> municipios = new ArrayList<>();

        try {
        	
			String sql = "SELECT * FROM Municipio";
			// realiza uma ponte entre o java e o BD
			statement = connection.prepareStatement(sql);        	
        	
            //stmt = connection.prepareStatement("SELECT * FROM topicos");
            rs = statement.executeQuery();

            while (rs.next()) {

            	MunicipioDTO municipio = new MunicipioDTO();
            		
            	//recupera valores de acordo com as colunas do BD
            	municipio.setId(rs.getInt("Id"));
            	municipio.setCodigo(rs.getInt("Codigo"));
            	municipio.setNome(rs.getString("Nome"));
            	municipio.setUf(rs.getString("Uf"));
            	//adiciona o municipio na lista de municipios
            	municipios.add(municipio);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        	statement.close();
        }

        return municipios;

    }	
	

}
