package org.curso.tienda.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.curso.tienda.modelo.Cliente;
import org.curso.tienda.modelo.Dni;
import org.curso.tienda.modelo.TiendaFacade;
import org.curso.tienda.modelo.exception.LetraDniIncorrectaException;

/**
 * Servlet implementation class RegistrarServlet
 */
@WebServlet("/registrar")
public class RegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String login= request.getParameter("login");
    	String clave= request.getParameter("clave"); 
    	String clave2=request.getParameter("clave2");
    	String nombre= request.getParameter("nombre");
    	String apellidos= request.getParameter("apellidos");
    	String direccion= request.getParameter("direccion");
    	String numDniText = request.getParameter("dni");
    	String letraDniText= request.getParameter("letraDni");
    	String fechaNac= request.getParameter("fechaNac");
    	
    	String mensajeError = "";
    	int numDni=0;
    	
    	if (login == null || login.equals("")) {
    		mensajeError += "<br/> El login es obligatorio";
    		
    	}
    	if(clave == null || clave.equals("")) {
    		mensajeError += "<br/> La clave es obligatoria";	
    	}else {
    		if(!clave.equals(clave2)||clave2.equals("")) {
    			mensajeError += "<br/> La clave es obligatoria";
    		}
    	}
    	if (numDniText ==null) {
    		mensajeError += "<br/> El DNI ";
    		
    	}else {
    		try {
    			numDni = Integer.parseInt(numDniText);
    		}catch (NumberFormatException ex) {
    			mensajeError += "<br/> Dni con caracteres invalidos";
    		}
    	}
    	char letraDni= letraDniText.charAt(0);
    	Calendar fechaNacimiento= Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	try {
    		fechaNacimiento.setTimeInMillis(sdf.parse(fechaNac).getTime());
    	} catch (ParseException ee) {
    		mensajeError += "<br/> Fecha con formato incorrecto";
    	}
    	
    	if (mensajeError.equals("")) {
    		try {
    			Dni d = new Dni (numDni ,letraDni);
    			Cliente c= new Cliente(d, login, clave, nombre, apellidos, direccion, fechaNacimiento);
    			//ServletContext aplicacion= request.getSession().getServletContext();
    			//TiendaFacade fachada = (TiendaFacade)aplicacion.getAttribute("fachada");
        		HttpSession sesion= request.getSession();
        		TiendaFacade fachada = (TiendaFacade)sesion.getAttribute("fachada");
    			if (fachada==null) {
    				fachada = new TiendaFacade();
    				
    			}
    			fachada.guardarCliente(c);
    			//fachada.guardarClientes("clientes.dat");
    			//O modificar estado hai que volver a gardar a aplicacions
    			response.sendRedirect("index.jsp");
    			sesion.setAttribute("fachada", fachada);
    			
    		}catch (LetraDniIncorrectaException e ) {
    			//ERROR
    		}catch(SQLException e) {
    			e.printStackTrace();
    			mensajeError += "<br/> Error de acceso a datos";
        		request.setAttribute("mensajeError", mensajeError);
        		//request.getRequestDispatcher("error.jsp").forward(request, response);
        		request.getRequestDispatcher("error.jsp").forward(request, response);
    		}
    		
    	}else {
    		request.setAttribute("mensajeError", mensajeError);
    		//request.getRequestDispatcher("error.jsp").forward(request, response);
    		request.getRequestDispatcher("error.jsp").forward(request, response);
    	}
    		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesar(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesar(request,response);
	}

}
