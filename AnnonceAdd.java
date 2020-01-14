package com.test.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class AnnonceAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnonceAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			GrilleAnnonces tableAnnonces= new GrilleAnnonces();
			request.setAttribute("annonces", tableAnnonces.recupererAnnonces());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Annonce annonce=new Annonce();
	annonce.setTitle(request.getParameter("title"));
	annonce.setDescription(request.getParameter("description"));
	annonce.setAdress(request.getParameter("adress"));
	annonce.setMail(request.getParameter("mail"));
	
	GrilleAnnonces tableAnnonces=new GrilleAnnonces();
	tableAnnonces.ajouterAnnonce(annonce);
	request.setAttribute("annonces", tableAnnonces.recupererAnnonces());
	this.getServletContext().getRequestDispatcher("/WEB-INF/Test.jsp").forward(request, response);
	
	
		
	}

}
