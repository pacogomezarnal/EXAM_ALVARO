package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameVentana extends JFrame {

	private JPanel contentPane;
	private PerfilUsuario perfilUsuario;
	private PerfilEquipo perfilEquipo;
	private Comprobacion comprobacion;

	
	public FrameVentana() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout());
		setContentPane(contentPane);
		
		//Inicializamos las ventanas que contendrá el CardLayout y las metemos en él
		perfilUsuario = new PerfilUsuario(this);
		comprobacion = new Comprobacion(this);
		perfilEquipo = new PerfilEquipo(this, perfilUsuario, comprobacion);
		comprobacion.setPerfilEquipo(perfilEquipo); //Seteamos la ventana de perfilEquipo en la de comprobación
		
		
		contentPane.add(perfilUsuario, "perfilUsuario");
		contentPane.add(perfilEquipo, "perfilEquipo");
		contentPane.add(comprobacion, "comprobacion");
		
		//Seteamos el título de la ventana
		this.setTitle("THE LABY");
	}

}
