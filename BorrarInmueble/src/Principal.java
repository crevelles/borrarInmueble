
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VBorrar vb = new VBorrar();
		AccesoOracle bbdd = new AccesoOracle();
		Controlador c = new Controlador(vb, bbdd);
		vb.setControlador(c);
		vb.setVisible(true);
	}

}
