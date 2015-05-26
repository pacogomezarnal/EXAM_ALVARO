package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Clase que comprueba el codigo de entrada
public class IngresoLaby {
	//CONSULTA A LA BASE DE DATOS
	private final static String CHECK_SEL="SELECT cod FROM cod WHERE id=";
	private final static String COD_COL="cod";
	
	//Conexion
	private Connection conexion = null;// maneja la conexió
	private Statement instruccion = null;
	private ResultSet conjuntoResultados = null;

	public IngresoLaby() {
		//Obtenemos la conexion de datos
		conexion=ConexionDB.getConexion();		
	}
	
	public String comprobarCod(int id,String apellido){
		try{
			String cod="";
			instruccion = this.conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery(CHECK_SEL+String.valueOf(id));
			
			//Listaremos por pantalla los datos
			while(conjuntoResultados.next() ) {
				if(apellido.equals(conjuntoResultados.getString(COD_COL))) cod="CODIGO CORRECTO ENHORABUENA. LLAMA A TU INSTRUCTOR";
				else return cod="CODIGO INCORRECTO COMPRUEBA TODOS LOS PASOS";
			}// fin de while
			return cod;
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return "ERROR EN LA CONEXION. LLAMA A TU INSTRUCTOR";
		}
		finally{
			try{
				conjuntoResultados.close();
				instruccion.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}	
	}

}
