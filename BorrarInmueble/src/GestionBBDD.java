import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionBBDD {

	Connection conexion;

	public GestionBBDD(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	
	public void cargarInmuebles(ArrayList<Inmueble>inmuebles){
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM INMUEBLE";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Inmueble i = new Inmueble();
				i.setCod(rset.getInt("COD"));
				i.setDirec(rset.getString("DIREC"));
				i.setMuni(rset.getString("MUNI"));
				i.setCod_post(rset.getInt("COD_POST"));
				i.setMetros(rset.getInt("METROS"));
				i.setPrecio(rset.getInt("PRECIO"));
				inmuebles.add(i);
			}
				rset.close();
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrar(int cod) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "DELETE FROM INMUEBLE WHERE COD = " + cod;
			System.err.println(select);
			stmt.executeQuery(select);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
