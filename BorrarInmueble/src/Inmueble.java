
public class Inmueble {

	
	int cod,cod_post, metros, precio;
	String direc,muni;
	
	
	public Inmueble(int cod, int cod_post, int metros, int precio, String direc, String muni) {
		super();
		this.cod = cod;
		this.cod_post = cod_post;
		this.metros = metros;
		this.precio = precio;
		this.direc = direc;
		this.muni = muni;
	}


	public Inmueble() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public int getCod_post() {
		return cod_post;
	}


	public void setCod_post(int cod_post) {
		this.cod_post = cod_post;
	}


	public int getMetros() {
		return metros;
	}


	public void setMetros(int metros) {
		this.metros = metros;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getDirec() {
		return direc;
	}


	public void setDirec(String direc) {
		this.direc = direc;
	}


	public String getMuni() {
		return muni;
	}


	public void setMuni(String muni) {
		this.muni = muni;
	}
	
	
	
	
	
	
}
