package org.curso.tienda.modelo;

public class Libro extends Producto {

	private String autor;
	private String isbn;
	
	public Libro(int idProducto , String titulo, String genero, double precio, int anho, String autor, String isbn) {
		super(idProducto ,titulo, genero, precio, anho);
		this.autor = autor;
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String toString (){
		return super.toString()+ "\t Autor:" + this.autor + "\n" ;
	}
}