package org.curso.tienda.modelo;

import java.util.Collections;

public class Producto implements Comparable<Producto> {
	
	private int idProducto;
	private String titulo;
	private String genero;
	private double precio;
	private int anho;
	
	public Producto(int idProducto , String titulo, String genero, double precio, int anho) {

		this.titulo = titulo;
		this.genero = genero;
		this.precio = precio;
		this.anho = anho;
		this.idProducto=idProducto;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getAnho() {
		return anho;
	}
	
	public void setAnho(int anho) {
		this.anho = anho;
	}
	public int getidProducto() {
		return idProducto;
	}
	
	public void idProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public String toString () {
		String texto= "Titulo:" + this.titulo + "\t Genero:" + this.genero + "\t Año:" + this.anho ;
		return texto ;
	}
	
	
	public boolean equals (Object o) {
		if(o!=null) {
			if (o instanceof Producto) {
				Producto otro=(Producto)o;
				return this.idProducto==otro.idProducto;			
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public int compareTo(Producto producto) {
		int a = 0;
		/*if(this.precio < producto.precio) {
			return  a=-1;
		}else {
			if(this.precio>producto.precio) {
			return a=1;
			}else {
				return a= 0;
			}
		}*/
		
		return new Double (this.precio).compareTo(producto.precio);
	}
	
	


}
