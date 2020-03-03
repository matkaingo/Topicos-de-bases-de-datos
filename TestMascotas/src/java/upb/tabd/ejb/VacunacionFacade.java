/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.tabd.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import upb.tabd.entidades.Vacunacion;

/**
 *
 * @author B09S105est
 */
@Stateless
public class VacunacionFacade extends AbstractFacade<Vacunacion> {

    @PersistenceContext(unitName = "MascotasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VacunacionFacade() {
        super(Vacunacion.class);
    }
    
}
