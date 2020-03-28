package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManterPaisController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePais = request.getParameter("nome");
		long populacaoPais = Long.parseLong(request.getParameter("populacao"));
		double areaPais = Double.parseDouble(request.getParameter("area"));
		
		Pais pais = new Pais(0, nomePais, populacaoPais, areaPais);
		
		PaisService ps = new PaisService();
		
		pais = ps.carregar(ps.incluir(pais));
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset=\"UTF-8\"><title>Pais Cadastrado</title></head><body>");
		out.println(	"id: " + pais.getId() + "<br>");
		out.println(	"nome: " + pais.getNome() + "<br>");
		out.println(	"populacao: " + pais.getPopulacao() + "<br>");
		out.println(	"area: " + pais.getArea() + "<br>");
		out.println("</body></html>");
	}

}
