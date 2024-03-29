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
	
	//Recupera lista de municipios no BD
    public List<MunicipioDTO> listaMunicipios() throws ClassNotFoundException, SQLException{

		// ativa conexão com BD
		Connection connection = ConexaoUtil.getInstance().getConnection();
        
		PreparedStatement statement = null;
        ResultSet rs = null;

        List<MunicipioDTO> municipios = new ArrayList<>();

        try {
        	
			String sql = "SELECT DISTINCT NOME FROM Municipio ORDER BY Nome";
			// realiza uma ponte entre o java e o BD
			statement = connection.prepareStatement(sql);        	
        	
            //stmt = connection.prepareStatement("SELECT * FROM topicos");
            rs = statement.executeQuery();

            while (rs.next()) {

            	MunicipioDTO municipio = new MunicipioDTO();
            		
            	//recupera valores de acordo com as colunas do BD
//            	municipio.setId(rs.getInt("Id"));
//            	municipio.setCodigo(rs.getInt("Codigo"));
            	municipio.setNome(rs.getString("Nome"));
//            	municipio.setUf(rs.getString("Uf"));
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
    
	//Recupera lista de UF no BD
    public List<MunicipioDTO> listaUF() throws ClassNotFoundException, SQLException{

		// ativa conexão com BD
		Connection connection = ConexaoUtil.getInstance().getConnection();
        
		PreparedStatement statement = null;
        ResultSet rs = null;

        List<MunicipioDTO> ufs = new ArrayList<>();

        try {
        	
			String sql = "SELECT DISTINCT Uf FROM Municipio ORDER BY Uf";
			// realiza uma ponte entre o java e o BD
			statement = connection.prepareStatement(sql);        	
        	
            //stmt = connection.prepareStatement("SELECT * FROM topicos");
            rs = statement.executeQuery();

            while (rs.next()) {

            	MunicipioDTO uf = new MunicipioDTO();
            		
            	//recupera valores de acordo com as colunas do BD
            	uf.setUf(rs.getString("Uf"));
            	//adiciona o municipio na lista de municipios
            	ufs.add(uf);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        	statement.close();
        }

        return ufs;

    }	    
	  

}
