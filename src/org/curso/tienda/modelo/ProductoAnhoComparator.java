package org.curso.tienda.modelo;

import java.util.Comparator;

public class ProductoAnhoComparator implements Comparator<Producto> {

	@Override
	public int compare(Producto o1, Producto o2) {
		return new Integer(o1.getAnho()).compareTo(o2.getAnho());
		
	}
	
	

}
