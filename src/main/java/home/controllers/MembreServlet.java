package home.controllers;

import home.Beans.Categorie;
import home.Beans.Membre;
import home.SessionBeans.CategorieFacade;
import home.SessionBeans.MembreFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author machd
 */
public class MembreServlet extends HttpServlet {

    @EJB
    private MembreFacade membreFacade;

    @EJB
    private CategorieFacade categoriefacade;

    private List<Categorie> listcategorie;

    private List<Membre> listmembre;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        listcategorie = categoriefacade.findAll();

        listmembre = membreFacade.FindByFonction();

        request.setAttribute("listcategorie", listcategorie);
        request.setAttribute("listmembre", listmembre);

        this.getServletContext().getRequestDispatcher("/membre.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
