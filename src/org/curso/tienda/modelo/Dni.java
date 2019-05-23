package org.curso.tienda.modelo;

import java.io.Serializable;

import org.curso.tienda.modelo.exception.LetraDniIncorrectaException;

public class Dni implements Serializable {
	private int numero;
	private char letra;
	
	private String listLetras="TRWAGMYFPDXBNJZSQVHLCKE";
	

	public Dni (int numero , char letra) throws LetraDniIncorrectaException {
		
		this.numero = numero ;
		this.letra = letra ;
		letra =  Character.toUpperCase(letra);
		if (letra == this.obtenerLetra()) {
			this.letra=letra;
		} else {
			System.out.println("Erro letra incorrecta");
			//throw new LetraDniIncorrectaException("La letra no es valida para el numero" + numero);
		}
		
	}

	private char obtenerLetra() {
		int posicion = this.numero % 23;
		return this.listLetras.charAt(posicion);	
	}
	
	
	
	
	
/*	public void setLetra (char letra) {
		letra=Character.toUpperCase(letra)
				if letra==this.obtenerLetra(){
					this.letra=letra
				}
		id( letra == this,.);
	}*/
	
	public String toString () {
		return this.numero + "-" + this.letra ;
	}
	

	/*public boolean equals(Object o) {
		if (o instanceof Dni) {
			Dni otro = (Dni)o;
			return this.numero == otro.numero;
			if (this numero == otro numero ) {
			}

		}else {
			return false ;
		}
	}*/
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	
	
	
	
	public int hashCode() {
		return new Integer(this.numero).hashCode();	
	}
}


