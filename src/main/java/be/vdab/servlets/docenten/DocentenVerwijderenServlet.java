package be.vdab.servlets.docenten;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.DocentService;

/**
 * Servlet implementation class DocentenVerwijderenServlet
 */
@WebServlet("/docenten/verwijderen.htm")
public class DocentenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		DocentService docentService = new DocentService();
		docentService.delete(id);
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		
	}

}
