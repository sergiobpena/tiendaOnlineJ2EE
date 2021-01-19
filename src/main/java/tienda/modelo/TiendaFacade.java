package tienda.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tienda.modelo.data.dao.CarritoDao;
import tienda.modelo.data.dao.ClienteDao;
import tienda.modelo.data.dao.ProductoDAO;
import tienda.modelo.exception.CarritoLlenoException;
import tienda.modelo.exception.LetraDniIncorrectaException;

public class TiendaFacade {

	private Map<Dni, Cliente> clientes;
	private CarritoCollections carrito;
	private List<Producto> productos;

	public TiendaFacade() {
		this.clientes = new HashMap<>();
		this.productos= new ArrayList<>();
		
		
		String [] reparto1 = {"Actor 1", "Actriz2"};
		
		
		
		/*Libro l1= new Libro (12345,"Libro 1","Terror",4.95,1989,"Autor 1","34567");
		Libro l2= new Libro (5678,"Libro 2","Comedia",9.67,1955,"Autor 2","55567");

		Pelicula p1= new Pelicula (91011,"Pelicula1","Comedia",22.30 ,2017,"Director 1 ","p");
		Pelicula p2= new Pelicula (91012,"Pelicula2","Terror",20.50 ,2006,"Director 2 ","k");
		
		this.productos.add(l1);
		this.productos.add(l2);
		this.productos.add(p1);
		this.productos.add(p2);*/
		
	}

/*	public void guardarCliente(Cliente cliente) {
		if (cliente != null) {
			this.clientes.put(cliente.getDni(), cliente);

		}
	}*/
	public void guardarCliente (Cliente cliente) throws SQLException {
		CarritoDao daoCarrito = new CarritoDao();
		int idCarrito=daoCarrito.crearCarrito();
		ClienteDao dao = new ClienteDao();
		dao.guardarCliente(cliente,idCarrito);
	}
	public void modificarCliente(Cliente cliente) {
		this.clientes.replace(cliente.getDni(), cliente);
	}

	public void eliminarCliente(Dni dni) {
		if (this.clientes.containsKey(dni)) {
			this.clientes.remove(dni);
		} else {
			// ERROR
			System.out.println("Error: eliminar cliente");
		}

	}

/*	public String imprimirClientes() {
		
		 * String texto=""; Collection <Cliente> lista= this.clientes.values();
		 * Iterator<Cliente> it = lista.iterator(); while (it.hasNext()) { texto=
		 * it.next()+ "/n" ; } return texto;
		 
		Iterator<Cliente> it = this.clientes.values().iterator();
		String texto = "Clientes:" + "\n";
		while (it.hasNext()) {
			Cliente cliente = it.next();
			texto = texto + cliente.getDni() + " " + cliente.getNombre() + " " + cliente.getApellidos() + "\n";
		}
		return texto;
	}*/

	// Gardar lista cliente ficheiro
	/*public void guardarClientes(String fichero) {
		try (FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			// oos.writeObject(this.clientes);

			Iterator<Cliente> it = this.clientes.values().iterator();
			while (it.hasNext()) {
				oos.writeObject(it.next());
			}

		} catch (FileNotFoundException e) {
			///
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			///
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}*/

	/*public void cargarClientes(String fichero) {
		try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Cliente c = (Cliente) ois.readObject();
			while (c != null) { // lee ata EOFException
				this.clientes.put(c.getDni(), c);
				c = (Cliente) ois.readObject();
			}*/

			// this.clientes=(Map<Dni, Cliente>) ois.readObject(); //clasnotfoundexception,
			// meter catch

	/*	} catch (ClassNotFoundException e) {
			///
		} catch (EOFException e) {
			// Se ha alcanzado el final del fichero
		} catch (FileNotFoundException e) {
			///
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			///
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}*/

/*	public boolean login(String login, String clave) {
		// buscar usuario etcetcetcetc
		boolean encontrado = false;
		Iterator<Cliente> it = this.clientes.values().iterator();
		while (!encontrado && it.hasNext()) {
			Cliente c = it.next();
			System.out.println(c+"++++++++++++++++");
			if (c.getLogin().equals(login) && c.getClave().equals(clave)) {
				this.carrito = new CarritoCollections(c);
				encontrado = true;
			}
		}
		return encontrado;
	}*/
	/*public boolean login(String login, String clave) throws SQLException, LetraDniIncorrectaException {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorLogin(login);
		if (cliente != null) {
			if (cliente.getLogin().equals(login) && cliente.getClave().equals(clave)) {
				this.carrito = new CarritoCollections(cliente);
				return true;
			}else {
				return false;
			}
		} else {
			return false;
		}
	}*/
	public boolean login (String login,String clave) throws SQLException, LetraDniIncorrectaException, CarritoLlenoException {
		ClienteDao dao= new ClienteDao();
		CarritoDao daoCarrito= new CarritoDao();
		Cliente cliente = dao.buscarPorLogin(login);
		if (cliente != null ) {
			if (cliente.getLogin().equals(login) && cliente.getClave().equals(clave)) {
				this.carrito = daoCarrito.buscarPorIdCarrito(cliente.getIdCarrito());
				this.carrito.setCliente(cliente);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
/*	public List<Producto> listarproductos() {

		return this.productos;

	}*/
	public List<Producto> listarproductos() throws SQLException {
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarTodos();
	}
	
	

	public void meterEnCarrito(Producto p) {
		try {
			this.carrito.meterEnCarrito(p);
		} catch (CarritoLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void meterEnCarrito(int idProducto) {
/*		boolean encontrado= false;
		Iterator <Producto> it = this.productos.iterator();
		while (!encontrado && it.hasNext()) {
			Producto p = it.next();
			if (p.getidProducto()== idProducto) {
				meterEnCarrito(p);
				encontrado= true;
			}
			if (!encontrado) {
				//Erro o id do producto non existe
			}
		}*/
		
	}
	public void vaciarCarrito (){
		this.carrito.vaciarCarrito();
	}
	
	public CarritoCollections getCarrito() {
		return this.carrito;
	}

	public String listarcarrito() {
		return this.carrito.toString();
	}
}