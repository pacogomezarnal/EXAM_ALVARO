package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Cadete;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PerfilUsuario extends JPanel {
	private JTextField fieldNombre;
	private JTextField fieldId;
	private JTextField fieldApellidos;
	private JTextField fieldEdad;
	private JTextField fieldNacionalidad;
	private JFrame parentFrame;

	/**
	 * Create the panel.
	 */
	public PerfilUsuario(JFrame frame) {
		this.parentFrame = frame;
		setLayout(null);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setBounds(41, 24, 106, 132);
		
		lblAvatar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/albafo.jpg")));
		add(lblAvatar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(201, 24, 61, 16);
		add(lblNombre);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(358, 24, 61, 16);
		add(lblId);
		
		fieldNombre = new JTextField();
		fieldNombre.setEditable(false);
		fieldNombre.setBounds(201, 54, 134, 28);
		add(fieldNombre);
		fieldNombre.setColumns(10);
		
		fieldId = new JTextField();
		fieldId.setEditable(false);
		fieldId.setColumns(10);
		fieldId.setBounds(358, 54, 61, 28);
		add(fieldId);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(201, 107, 61, 16);
		add(lblApellidos);
		
		fieldApellidos = new JTextField();
		fieldApellidos.setEditable(false);
		fieldApellidos.setBounds(201, 135, 134, 28);
		add(fieldApellidos);
		fieldApellidos.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(201, 175, 61, 16);
		add(lblEdad);
		
		fieldEdad = new JTextField();
		fieldEdad.setEditable(false);
		fieldEdad.setBounds(201, 203, 134, 28);
		add(fieldEdad);
		fieldEdad.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(201, 243, 82, 16);
		add(lblNacionalidad);
		
		fieldNacionalidad = new JTextField();
		fieldNacionalidad.setEditable(false);
		fieldNacionalidad.setBounds(201, 271, 134, 28);
		add(fieldNacionalidad);
		fieldNacionalidad.setColumns(10);
		
		JButton btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Redirigimos a la ventana 2
				
				CardLayout cardLayout = (CardLayout) (frame.getContentPane().getLayout());
				cardLayout.show(frame.getContentPane(), "perfilEquipo");

				
			}
		});
		btnSiguiente.setBounds(313, 311, 117, 29);
		add(btnSiguiente);
		
		
		loadCadete(); //Llamamos a la carga de los datos del cadete

	}
	
	
	/*
	 *  Método que carga e inserta los datos del Cadete en los inputs.
	 */
	
	public void loadCadete() {
		
		Cadete cadete = Cadete.loadFromDB();
		fieldNombre.setText(cadete.getNombre());
		fieldApellidos.setText(cadete.getApellidos());
		fieldEdad.setText(""+cadete.getEdad());
		fieldNacionalidad.setText(cadete.getNacionalidad());
		fieldId.setText(""+cadete.getId());
		
	}


	
	
	
}
