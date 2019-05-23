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

import org.curso.tienda.modelo.Producto;
import org.curso.tienda.modelo.TiendaFacade;

/**
 * Servlet implementation class AñadirCarritoServlet
 */
@WebServlet("/anadirCarrito")
public class AñadirCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AñadirCarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
    	String idProductoText=request.getParameter("productoId");
    	if (idProductoText !=null) {
    		int idProducto=Integer.parseInt(idProductoText);//fallo aqui
    		//ServletContext aplicacion= request.getSession().getServletContext();
    		//TiendaFacade fachada = (TiendaFacade)aplicacion.getAttribute("fachada");
    		HttpSession sesion= request.getSession();
    		TiendaFacade fachada = (TiendaFacade)sesion.getAttribute("fachada");
    		if(fachada==null) {
    			fachada= new TiendaFacade();
    		}
    		fachada.meterEnCarrito(idProducto);
    		List<Producto> listaProductos= fachada.listarproductos();
    		request.setAttribute("listaProductos", listaProductos);
    		request.getRequestDispatcher("tienda.jsp").forward(request, response);
    		//avisar de que se engadiu
    	}	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			procesar(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//falloaqui
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			procesar(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
