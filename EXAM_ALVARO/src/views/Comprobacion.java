package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.IngresoLaby;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comprobacion extends JPanel {
	private JTextField fieldId;
	private JTextField fieldApellido;
	private JTextField returnMsg;
	private PerfilEquipo perfilEquipo;
	private IngresoLaby ingreso;

	/**
	 * Create the panel.
	 */
	public Comprobacion(JFrame frame) {
		
		ingreso = new IngresoLaby();
		setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(39, 30, 61, 16);
		add(lblId);
		
		fieldId = new JTextField();
		fieldId.setBounds(39, 55, 90, 28);
		add(fieldId);
		fieldId.setColumns(10);
		
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(186, 30, 90, 16);
		add(lblerApellido);
		
		fieldApellido = new JTextField();
		fieldApellido.setBounds(178, 55, 134, 28);
		add(fieldApellido);
		fieldApellido.setColumns(10);
		
		JButton btnNewButton = new JButton("Comprobar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = ingreso.comprobarCod(Integer.valueOf(fieldId.getText()), fieldApellido.getText());
				returnMsg.setText(msg);
			}
		});
		btnNewButton.setBounds(38, 114, 378, 29);
		add(btnNewButton);
		
		returnMsg = new JTextField();
		returnMsg.setBounds(39, 165, 377, 28);
		add(returnMsg);
		returnMsg.setColumns(10);
		
		JButton button = new JButton("<< Atrás");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				perfilEquipo.recargaCadetesEquipo(); //Recargamos el modelo de Equipos antes de acceder a la ventana
				CardLayout cardLayout = (CardLayout) (frame.getContentPane().getLayout());
				cardLayout.show(frame.getContentPane(), "perfilEquipo");
			}
		});
		button.setBounds(39, 297, 117, 29);
		add(button);

	}
	
	/*
	 * Método para setear el perfil del equipo
	 */

	public void setPerfilEquipo(PerfilEquipo perfil) {
		perfilEquipo = perfil;
		
	}

	

	

}
