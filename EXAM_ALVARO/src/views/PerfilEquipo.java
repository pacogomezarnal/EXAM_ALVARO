package views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Cadete;

import java.awt.CardLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PerfilEquipo extends JPanel {
	private JTextField fieldNombre;
	private JTextField field1Apellido;
	private JTextField field2Apellido;
	private JTextField fieldNacionalidad;
	private JTextField fieldId;
	private JComboBox comboEquipos;
	private PerfilUsuario perfilUsuario;
	private Comprobacion comprobacion;
	private JFrame frame;

	/**
	 * Create the panel.
	 * @param comprobacion 
	 * @param perfilUsuario 
	 */
	public PerfilEquipo(JFrame frame,PerfilUsuario perfilUsuario, Comprobacion comprobacion) {
		
		this.perfilUsuario=perfilUsuario;
		this.comprobacion=comprobacion;
		
		setLayout(null);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(36, 26, 61, 16);
		add(lblEquipo);
		
		comboEquipos = new JComboBox();
		comboEquipos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				loadCadete();
				
			}
		});
		
		recargaCadetesEquipo(); //Llamamos al método de recarga del combobox
		
		comboEquipos.setBounds(36, 55, 110, 27);
		add(comboEquipos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(174, 26, 61, 16);
		add(lblNombre);
		
		fieldNombre = new JTextField();
		fieldNombre.setEditable(false);
		fieldNombre.setBounds(174, 53, 134, 28);
		add(fieldNombre);
		fieldNombre.setColumns(10);
		
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(174, 107, 110, 16);
		add(lblerApellido);
		
		field1Apellido = new JTextField();
		field1Apellido.setEditable(false);
		field1Apellido.setBounds(174, 124, 134, 28);
		add(field1Apellido);
		field1Apellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("2º Apellido");
		lblApellido.setBounds(174, 176, 82, 16);
		add(lblApellido);
		
		field2Apellido = new JTextField();
		field2Apellido.setEditable(false);
		field2Apellido.setBounds(174, 200, 134, 28);
		add(field2Apellido);
		field2Apellido.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(174, 240, 82, 16);
		add(lblNacionalidad);
		
		fieldNacionalidad = new JTextField();
		fieldNacionalidad.setEditable(false);
		fieldNacionalidad.setBounds(174, 261, 134, 28);
		add(fieldNacionalidad);
		fieldNacionalidad.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(351, 26, 61, 16);
		add(lblId);
		
		fieldId = new JTextField();
		fieldId.setEditable(false);
		fieldId.setBounds(345, 53, 67, 28);
		add(fieldId);
		fieldId.setColumns(10);
		
		JButton btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) (frame.getContentPane().getLayout());
				cardLayout.show(frame.getContentPane(), "comprobacion");
			}
		});
		btnSiguiente.setBounds(295, 301, 117, 29);
		add(btnSiguiente);
		
		JButton brnAtras = new JButton("<< Atrás");
		brnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				perfilUsuario.loadCadete(); //Recargamos cadete antes de volver a la ventana
				CardLayout cardLayout = (CardLayout) (frame.getContentPane().getLayout());
				cardLayout.show(frame.getContentPane(), "perfilUsuario");
			}
		});
		brnAtras.setBounds(36, 301, 117, 29);
		add(brnAtras);

	}
	
	
	/*
	 * Este método borra y recarga el modelo del combobox de Cadetes
	 */
	
	public void recargaCadetesEquipo() {
		
		Cadete myCadete = Cadete.getMyCadete();
		DefaultComboBoxModel nuevoModelo = new DefaultComboBoxModel(myCadete.getCadetesByIdEquipo().toArray());
		comboEquipos.setModel(nuevoModelo);
	}
	
	/*
	 * Este método nos recarga los inputs con el cadete del combobox
	 */
	public void loadCadete() {
		
		Cadete cadete = (Cadete) comboEquipos.getSelectedItem();
		fieldNombre.setText(cadete.getNombre());
		field1Apellido.setText(cadete.separarApellidos()[0]);
		field2Apellido.setText(cadete.separarApellidos()[1]);
		fieldId.setText(""+cadete.getId());
		fieldNacionalidad.setText(cadete.getNacionalidad());
		
		
	}
	
	
}
