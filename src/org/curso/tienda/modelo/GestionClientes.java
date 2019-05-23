package org.curso.tienda.modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestionClientes {
	
	private Map<Dni, Cliente> clientes;
	
	public GestionClientes() {
		this.clientes= new HashMap<>();
	}
	
	public void guardarCliente (Cliente cliente) {
		if(cliente !=null) {
		this.clientes.put(cliente.getDni(), cliente);
		
		} 
	}
	
	public void modificarCliente(Cliente cliente) {
		this.clientes.replace(cliente.getDni(), cliente);
	}
	
	public void eliminarCliente(Dni dni) {
		if(this.clientes.containsKey(dni)) {
			this.clientes.remove(dni);
		} else {
			//ERROR
			System.out.println("Error: eliminar cliente");
		}
		
	}
	public String imprimirClientes() {
		/*String texto="";
		Collection <Cliente> lista= this.clientes.values();
		Iterator<Cliente> it = lista.iterator();
		while (it.hasNext()) {
			texto= it.next()+ "/n" ;
		}
		return texto;*/
		Iterator<Cliente> it = this.clientes.values().iterator();
		String texto = "Clientes:" + "/n";
		while (it.hasNext()) {
			Cliente cliente= it.next();
			texto= texto + cliente.getDni() + cliente.getNombre()+ cliente.getApellidos() + "/n";
		}
		return texto;
	}
	
	//Gardar lista cliente ficheiro
	public void guardarClientes(String fichero) {
		try(FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos)	
				){
			//oos.writeObject(this.clientes);
			
			Iterator<Cliente> it = this.clientes.values().iterator();
			while (it.hasNext()) {
				oos.writeObject(fos);
			}
			
			
			
		} catch (FileNotFoundException e ) {
			///
			System.out.println(e.getMessage());
		}catch (IOException e ) {
			///
			System.out.println(e.getMessage());
		}
	}
		

	
	
	
	public void cargarClientes(String fichero){
		try(FileInputStream fis = new FileInputStream(fichero);
				ObjectInputStream ois = new ObjectInputStream(fis)	
					){
			
			Cliente c = (Cliente)ois.readObject();
			while (c != null) { //lee ata EOFException
				this.clientes.put(c.getDni(), c);
				c=(Cliente)ois.readObject();
			}
			
				//this.clientes=(Map<Dni, Cliente>) ois.readObject();		//clasnotfoundexception, meter catch
				
				
			}catch (ClassNotFoundException e) {
				///
			}catch (EOFException e) {
				//Se ha alcanzado el final del fichero
			}
			catch (FileNotFoundException e ) {
				///
				e.printStackTrace();
				System.out.println(e.getMessage());
			}catch (IOException e ) {
				///
				System.out.println(e.getMessage());
			}
	}
}

	
	
