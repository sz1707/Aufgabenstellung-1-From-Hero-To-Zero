package paket2;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.Serializable;
import java.util.List;
import paket1.Emissionsdaten;

@Named
@ViewScoped
public class EmissionsdatenBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private EntityManager em;
    private List<Emissionsdaten> alleEmissionen;
    
    private static EntityManagerFactory emf;

    @PostConstruct
    public void init() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("co2PU");
            }
            em = emf.createEntityManager();
            alleEmissionen = em.createQuery("SELECT e FROM Emissionsdaten e", Emissionsdaten.class)
                               .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Fehler beim Initialisieren der Bean: " + e.getMessage(), e);
        }
    }

    public List<Emissionsdaten> getAlleEmissionen() {
        return alleEmissionen;
    }
    
    public String speichern() {
        try {
            em.getTransaction().begin();
            for (Emissionsdaten e : alleEmissionen) {
                em.merge(e);
            }
            em.getTransaction().commit();
            return "index.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                 "Fehler beim Speichern: " + ex.getMessage(),
                                 null));
            return null;
        }
    }
}









