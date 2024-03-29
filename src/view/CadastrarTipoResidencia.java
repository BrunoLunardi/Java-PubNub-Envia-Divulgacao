package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.TipoResidenciaDAO;
import dto.TipoResidenciaDTO;

public class CadastrarTipoResidencia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 */
	public CadastrarTipoResidencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Tipo Residência");
		lblNewLabel.setBounds(12, 15, 322, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 42, 426, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//cria objeto do tipo TopicoDTO com o nome do topico passado
					TipoResidenciaDTO tipoResidenciaDTO = new TipoResidenciaDTO(textField.getText().toLowerCase());
					//objeto para executar sql de insert no bd
					TipoResidenciaDAO tipoResidenciaDAO = new TipoResidenciaDAO();
					//metodo para realizar insert no BD
					tipoResidenciaDAO.insert(tipoResidenciaDTO);
					//exibe resultado na tela
					JOptionPane.showMessageDialog(null, "Tipo de residência cadastrado com sucesso" ,"Sucesso",
						JOptionPane.INFORMATION_MESSAGE);	
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					Main frame = new Main();
					frame.setVisible(true);
					dispose();
				}
				
			}
		});		
		
		btnCadastrar.setBounds(273, 125, 114, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main frame = new Main();
				frame.setVisible(true);
				dispose();
			}
		});				
		
		btnCancelar.setBounds(73, 125, 114, 25);
		contentPane.add(btnCancelar);
	}	
	
}
