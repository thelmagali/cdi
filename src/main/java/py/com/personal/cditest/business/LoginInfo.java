package py.com.personal.cditest.business;

import org.jboss.weld.environment.se.contexts.ThreadScoped;
import py.com.personal.cditest.model.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ThreadScoped
public class LoginInfo {

    private Boolean sessionActive;
    private Usuario loggedUser;

    @PostConstruct
    private void init(){
        this.sessionActive = false;
    }

    public Boolean getSessionActive() {
        return sessionActive;
    }

    public void setSessionActive(Boolean sessionActive) {
        this.sessionActive = sessionActive;
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Usuario loggedUser) {
        this.loggedUser = loggedUser;
    }
}
