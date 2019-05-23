package org.curso.tienda.modelo;

import java.util.Comparator;

public class ProductoTituloComparator implements Comparator<Producto> {

	@Override
	public int compare(Producto p1, Producto p2) {
		return p1.getTitulo().compareTo(p2.getTitulo());
	}
	

}
