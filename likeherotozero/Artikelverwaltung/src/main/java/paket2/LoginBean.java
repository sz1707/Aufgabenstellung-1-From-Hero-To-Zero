package paket2;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named("loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
  
    public void setUsername(String username) {
        this.username = username;
    }
  
    public String getPassword() {
        return password;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }
  
    public String login() {
        if ("admin".equals(username) && "admin123".equals(password)) {
            return "edit.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                 "Ungültiger Benutzername oder Passwort",
                                 null));
            return null;
        }
    }
}








