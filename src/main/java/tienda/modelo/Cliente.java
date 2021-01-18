package tienda.modelo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cliente implements Serializable {
	private Dni dni ;
	private final String login;
	private String clave;
	private String nombre;
	private String apellidos;
	private String direccion; 
	private Calendar fechaNacimiento;
	private int idCarrito;
	
	public Cliente(Dni dni, String login, String clave, String nombre, String apellidos, String direccion,
			Calendar fechaNacimiento) {
		super();
		this.dni = dni;
		this.login = login;
		this.clave=clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Cliente(Dni dni, String login, String clave, String nombre, String apellidos, String direccion,
			Calendar fechaNacimiento,int idCarrito) {
		super();
		this.dni = dni;
		this.login = login;
		this.clave=clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.idCarrito=idCarrito;
	}
	
	
	
	public Dni getDni() {
		return dni;
	}



	public void setDni(Dni dni) {
		this.dni = dni;
	}



	public String getLogin() {
		return login;
	}


	
	
	
	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getIdCarrito () {
		return idCarrito;
	}



	public int calcularEdad() {
	Calendar hoy= Calendar.getInstance();
	long tiempo = hoy.getTimeInMillis() - this.fechaNacimiento.getTimeInMillis();
	Calendar edad = Calendar.getInstance();
	edad.setTimeInMillis(tiempo);
	return edad.get(Calendar.YEAR) - 1970 ;
	}
	
	public String toString () {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaTexto=sdf.format(this.fechaNacimiento.getTime());
		return "Dni: "+ this.dni +"\tNombre: " + this.nombre + " " + this.apellidos +"\tFecha nacimiento: " + fechaTexto;
	}

	public boolean equals (Object o) {
		if (o != null) {
			if (o instanceof Cliente ) {
				Cliente otro = (Cliente)o;
				return this.dni.equals(otro.dni);
			}else {
				return false ;
			}
		}else {
			return false ;
		}
	}
	
}