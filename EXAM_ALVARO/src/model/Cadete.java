package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import views.PerfilEquipo;
import views.PerfilUsuario;

//Clase que almacenar� todos los datos de un cadete
public class Cadete {
	//Propiedades
	private int id=0;
	private String nombre="";
	private String apellidos="";
	private int edad=0; 
	private String nacionalidad="";
	private int equipo=0; 
	
	
	
	
	//ArrayList con todos los cadetes de la BBDD
	private static Cadete myCadete;

	//Constructores
	public Cadete() {
		
	}
	
	public Cadete(int id,
				  String nombre,
				  String apellidos,
				  int edad,
				  String nacionalidad,
				  int equipo) {
		this.id=id;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.nacionalidad=nacionalidad;
		this.equipo=equipo;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEquipo() {
		return equipo;
	}

	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}
	
	/*
	 * Método de carga del Cadete proveniente de la BBDD
	 */
	public static Cadete loadFromDB() {
		
		
		
		ConexionDB conexion = ConexionDB.getInstance();
		ResultSet rs = conexion.query("select * from cadetes where id=5");
		
		try {
			while(rs.next()) {
				myCadete = new Cadete(
						rs.getInt("id"), 
						rs.getString("nombre"),
						rs.getString("apellidos"),
						rs.getInt("edad"),
						rs.getString("nacionalidad"),
						rs.getInt("equipo")
				);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myCadete;		
		
	}
	
	/*
	 * Método que devuelve los cadetes de tu equipo
	 */
	public ArrayList<Cadete> getCadetesByIdEquipo() {
		
		ArrayList<Cadete> cadetes = new ArrayList<Cadete>();
		ConexionDB conexion = ConexionDB.getInstance();
		
		ResultSet rs = conexion.query("select * from cadetes where equipo="+this.getEquipo());

		try {
			
			while(rs.next()) {
				Cadete cadete = new Cadete(
						rs.getInt("id"), 
						rs.getString("nombre"),
						rs.getString("apellidos"),
						rs.getInt("edad"),
						rs.getString("nacionalidad"),
						rs.getInt("equipo")
				);
				cadetes.add(cadete);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cadetes;
		
		
		
	}
	
	public static Cadete getMyCadete() {
		return myCadete;
	}
	
	public String toString() {
		return this.getNombre()+" "+this.getApellidos();
	}
	
	/*
	 * Separa los apellidos en una array de strings
	 */
	public String[] separarApellidos() {
		return this.getApellidos().split(" ");
	}

}
