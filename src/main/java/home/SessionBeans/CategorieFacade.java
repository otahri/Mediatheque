/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.SessionBeans;

import home.Beans.Categorie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author machd
 */
@Stateless
public class CategorieFacade extends AbstractFacade<Categorie> {
    @PersistenceContext(unitName = "home_Mediatheque_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        em.flush();
        em.clear();
        em.getEntityManagerFactory().getCache().evictAll();
        return em;
    }

    public CategorieFacade() {
        super(Categorie.class);
    }
    
}
