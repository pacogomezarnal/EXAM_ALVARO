package model;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;



public class ConexionDB {
	// DATOS DE LA CONEXION
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	//DATOS POR DEFECTO
	private static final String HOST="localhost";
	private static final String BBDD="thelaby";
	private static final String USER="root";
	private static final String PASS="";
	
	//DATOS DE LA BBDD
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;
	
	//Conexion
	private static Connection conexion = null;// maneja la conexió
	
	//Instancia unica
	private static ConexionDB instance = null;
	
	private ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	//Implementar SingleTon
	public static ConexionDB getInstance(String HOST,String BBDD,String USER,String PASS) {
	      if(instance == null) {
	         instance = new ConexionDB(BBDD,HOST,USER,PASS);
	      }
	      return instance;
	   }
	//Este método es el mismo que el anterior pero no es necesario
	//pasar parámetros de base de datos ya que toma los
	//valores por defecto
	public static ConexionDB getInstance() {
	      if(instance == null) {
	         instance = new ConexionDB(ConexionDB.BBDD,ConexionDB.HOST,ConexionDB.USER,ConexionDB.PASS);;
	      }
	      return instance;
	  }
	
	//Metodo que permite la conexion a la base de datos
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador MySQL el cual automáticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return false;
		}
		catch( ClassNotFoundException noEncontroClase)
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Metodo que devuelve la conexion a la base de datos
	public static Connection getConexion(){
		return conexion;
	}

}

