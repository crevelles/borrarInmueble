import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener, MouseListener{
	
	
	VBorrar vb;
	AccesoOracle bbdd;
	GestionBBDD gBBDD;
	ArrayList<Inmueble> inmuebles = new ArrayList<>();
	
	
	
	public Controlador(VBorrar vb, AccesoOracle bbdd) {
		super();
		this.vb = vb;
		this.bbdd = bbdd;
		gBBDD = new GestionBBDD(bbdd.conexion);
		gBBDD.cargarInmuebles(inmuebles);
		
	}
	

	private void cargarTabla() {
		for (Inmueble inmueble : inmuebles) {
			DefaultTableModel tabla = (DefaultTableModel) vb.table.getModel();
			tabla.addRow(new Object[]{
					inmueble.getDirec(),
					inmueble.getMuni(),
					inmueble.getPrecio(),
					inmueble.getMetros()
			});
		}	
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o == vb.table){
			vb.btnBorrar.setVisible(true);
		}
		
	}


	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == vb.btnSalir){
			vb.dispose();
			bbdd.cerrarBaseDatos();
		} else if(o == vb.btnBuscar){
			buscar();
		} else if(o == vb.btnBorrar){
			borrar();
		}
		
	}
	
	private void borrar() {
		int x = vb.table.getSelectedRow();
		int cod = inmuebles.get(x).getCod();
		gBBDD.borrar(cod);
		DefaultTableModel tabla = (DefaultTableModel) vb.table.getModel();
		tabla.removeRow(x);
		for (int i = 0; i < inmuebles.size(); i++) {
			if(inmuebles.get(i).getCod() == cod){
				inmuebles.remove(i);
			}
		}
//		
//		int fila = vb.table.getSelectedRow();
//		int codi = inmuebles.get(fila).getCod();
//		if(gBBDD.borrarInmueble(codi)){
//			DefaultTableModel tabla = (DefaultTableModel) vb.table.getModel();
//			tabla.removeRow(fila);
//			vb.lblError.setText("Eliminado");
//			vb.btnBorrar.setVisible(false);
//			inmuebles.remove(fila);
//			vb.textCodigoPostal.setText(null);
//		} else {
//			vb.lblError.setText("Error");
//		}
	}
	
	


	private void limpiar() {
		try {
			while (vb.table.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vb.table.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	private void buscar() {	
		vb.btnBorrar.setVisible(false);
		try{
			int contador = 0;
			limpiar();
			String cod =  vb.textCodigo.getText();
			if(cod.isEmpty()){
				cargarTabla();
				vb.lblError.setText(null);
			} else {
				int codigo = Integer.parseInt(cod);
				for (Inmueble inmueble : inmuebles) {
					if(inmueble.getCod_post() == codigo){
						DefaultTableModel tabla = (DefaultTableModel) vb.table.getModel();
						tabla.addRow(new Object[]{
								inmueble.getDirec(),
								inmueble.getMuni(),
								inmueble.getPrecio(),
								inmueble.getMetros()
						});
							contador++;
					}
				}
				vb.lblError.setText("Se encontraron " + contador + " resultados");
			}
			
		}catch (Exception e) {
			vb.lblError.setText("Debe introducir un código numérico");
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
