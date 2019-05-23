package org.curso.tienda.modelo;

import org.curso.tienda.modelo.exception.CarritoLlenoException;
import org.curso.tienda.modelo.exception.PosicionFueraCarritoException;
import org.curso.tienda.modelo.exception.ProductoNoEncontradoException;

public class Carrito {
	
	private Cliente cliente;
	private Producto[] listaProductos;
	private int numProductos;
	
	public Carrito (Cliente cliente) {
		this.cliente= cliente ;
		this.listaProductos = new Producto[30];
		this.numProductos=0;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	

	public Producto[] getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Producto[] listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void meterEnCarrito(Producto producto) throws CarritoLlenoException {
		if(this.numProductos==this.listaProductos.length) {
			//System.out.println("Carrito lleno");
			throw new CarritoLlenoException("Carrito lleno");
			
		}else {
			this.listaProductos[this.numProductos]=producto;
			this.numProductos++;
		}
	}
	public void sacarDeCarrito(int posicion) throws PosicionFueraCarritoException {
		if(posicion >= this.listaProductos.length || posicion<0) {
			//System.out.println("Posicion fora do carrito");
			throw new PosicionFueraCarritoException ("Posicion fuera Carrito.Maximo " );
		}else {
			this.listaProductos[posicion]=this.listaProductos[this.numProductos - 1];
			this.numProductos--;
			
		}
		
	}
	public void vaciarCarrito() {
		for (int i=0;i < this.listaProductos.length; i++) {
			this.listaProductos[i]=null ;
			
		}
		
	}
	public String toString () {
		String texto = "Cliente "+ this.cliente + "\nCarrito: ";
		for (int i=0 ; i<this.numProductos; i++) {
			texto=texto + "\t" + this.listaProductos[i] + "\n";
		}
		return texto;
	}
/*	public void sacarcarrito(Producto producto) throws {
		//por id de prodcuto
		int posicion = 0 ;
		
		while (posicion < this.listaProductos.length && !producto.equals(this.listaProductos[posicion]) ) {
			posicion ++ ;
		}
		if (posicion == this.listaProductos.length) {
			//System.out.println("Error: EL producto no esta en el carrito");
			throw new ProductoNoEncontradoException("El producto"+ producto + "no esta en el carrito")
			
		}else {
			this.listaProductos[posicion]=this.listaProductos[this.numProductos-1];
			this.numProductos--;
		}
	}*/

}
