package org.curso.tienda.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.curso.tienda.modelo.Producto;
import org.curso.tienda.modelo.TiendaFacade;
import org.curso.tienda.modelo.exception.CarritoLlenoException;
import org.curso.tienda.modelo.exception.LetraDniIncorrectaException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, LetraDniIncorrectaException, CarritoLlenoException{
    	String login = request.getParameter("login");
    	String clave= request.getParameter("clave");
    	String mensajeError= "";
    	
    	
    	if  (login == "") {
    		mensajeError += "<br/> Login obligatorio" ;
    	}
    	if  (clave == "") {
    		mensajeError += "<br/> Clave obligatoria" ;
    	}
    	if (mensajeError.equals("")){
    		HttpSession sesion= request.getSession();
    		TiendaFacade fachada = (TiendaFacade)sesion.getAttribute("fachada");
    		if(fachada==null) {
    			fachada= new TiendaFacade();
    		}
    		boolean encontrado = fachada.login(login, clave);
    		if (encontrado) {
    			List <Producto> listaProductos = fachada.listarproductos();
    			request.setAttribute("listaProductos", listaProductos);
    			sesion.setAttribute("usuario", login);
    			sesion.setAttribute("carrito",fachada.getCarrito());
    			sesion.setAttribute("fachada", fachada);
    			request.getRequestDispatcher("tienda.jsp").forward(request, response);

    			
    		}
    			
    		else {
    		request.setAttribute("mensaje error", "El login o la clave son incorrectos");
    		request.getRequestDispatcher("error.jsp").forward(request, response);
    		} 
    	}else {
    		request.setAttribute("mensaje error", mensajeError);
    		request.getRequestDispatcher("error.jsp").forward(request, response);
    	}
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			try {
				procesar(request,response);
			} catch (CarritoLlenoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LetraDniIncorrectaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			try {
				procesar(request,response);
			} catch (CarritoLlenoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LetraDniIncorrectaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
