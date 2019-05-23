package org.curso.tienda.modelo;

import org.curso.tienda.modelo.exception.CarritoLlenoException;
import org.curso.tienda.modelo.exception.PosicionFueraCarritoException;
import org.curso.tienda.modelo.exception.ProductoNoEncontradoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CarritoCollections {
	
	private Cliente cliente;
	private List <Producto> listaProductos;
	//private int numProductos;
	//private final int MAX_PRODUCTOS=30;
	
	
	public CarritoCollections (Cliente cliente) {
		
		this.cliente= cliente ;
		this.listaProductos = new ArrayList<Producto>();
		//this.numProductos=0;
	}

	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	

	public void meterEnCarrito(Producto producto) throws CarritoLlenoException {
		this.listaProductos.add(producto);
	}
	
	public void sacarDeCarrito(int posicion) throws PosicionFueraCarritoException {
		if (posicion >= 0 & posicion < this.listaProductos.size()) {
			
		this.listaProductos.remove(posicion);
		}else {
			throw new PosicionFueraCarritoException ("La posicion"+ "no esta en el carrito");
		}
		
/*		try {
			this.listaProductos.remove(posicion);
		}catch(IndexOutofBounds*/
	}
	public void sacardeCarrito(Producto producto) throws ProductoNoEncontradoException {
		if(!this.listaProductos.remove(producto)) {
			throw new ProductoNoEncontradoException ("El producto " + producto.getidProducto() + "no fue encontrado");
			
		}			
		}
	public void vaciarCarrito() {
		this.listaProductos.clear();
	}
	
	
	public String toString () {
		String texto = "Cliente \n"+ this.cliente + "\nCarrito: \n";
		
		/*for(int i = 0 ; i< listaProductos.size(); i++) {
			texto=texto + this.listaProductos.get(i)+"";
		}*/
		
		//For each
		/*for (Producto p : this.listaProductos) {
			texto= texto + p + "";
		}*/
		
		//Iterator
		Iterator<Producto> it = this.listaProductos.iterator();
		while (it.hasNext()) {
			texto= texto + it.next()+ "" ;
		}
			
		return texto;
	}
	
	
	
	//Ordear
	public void ordenarPrecio() {
		Collections.sort(this.listaProductos);
	}
	
	public void ordenarPorTitulo() {
		Collections.sort(this.listaProductos, new ProductoTituloComparator());
	}
	
	public void ordenarPorAnho() {
		Collections.sort(this.listaProductos, new ProductoAnhoComparator());
	}

}
