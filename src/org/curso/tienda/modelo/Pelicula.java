package org.curso.tienda.modelo;

public class Pelicula extends Producto {

	private String director;
	private String reparto;


	//private String[] reparto ;

	//public Pelicula(int idProducto,String titulo, String genero, double precio, int anho, String director, String[] reparto)
	public Pelicula(int idProducto,String titulo, String genero, double precio, int anho, String director, String reparto) {
		super(idProducto, titulo, genero, precio, anho);
		this.director = director;
		this.reparto = reparto;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getReparto() {
		return reparto;
	}


	public void setReparto(String reparto) {
		this.reparto = reparto;
	} 
	public String toString () {
		String texto=super.toString()+"\t Director:"+this.director+"\t Reparto:" + this.reparto + "\n";
		/*String texto = super.toString()+"Director: "+this.director + "Reparto:" ;
			for (String nombre : reparto) {
				texto=texto + ","+ nombre ;
			}*/
			return texto;
				
	}
	

}
