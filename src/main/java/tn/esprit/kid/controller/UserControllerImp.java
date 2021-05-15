package tn.esprit.kid.controller;



import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;






import tn.esprit.kid.entities.Role;
import tn.esprit.kid.entities.Userr;
import tn.esprit.kid.services.IUserService;

@ManagedBean(name = "userController")
@Scope(value = "session")
@Controller(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/login.jsf")
public class UserControllerImp {
	

	@Autowired
	IUserService userService;

	private String login; private String password; private Userr user;
	private String prenom; private String nom; private String email;
	 private Role role;
	public Role[] getRoles() { return Role.values(); }
	private Boolean loggedIn;
	private Userr authenticatedUser;
	private List<Userr> users;
	
	public List<Userr> getUsers() {
		users= userService.getAllUsers();
		return users;
	}
	public void setUsers(List<Userr> users) {
		this.users = users;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Userr getUser() {
		return user;
	}
	public void setUser(Userr user) {
		this.user = user;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public Userr getAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(Userr authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	
	
	public String doLogin() {
		String navigateTo = "null";
		System.out.println("test6666666666666666666666666666666666666666666666666666666");
		authenticatedUser=userService.authenticate(login, password);
		System.out.println("test333333333333333333333333333333333333333333333333");

		if (authenticatedUser != null && authenticatedUser.getRole() ==
				Role.ROLE_ADMIN) {
			System.out.println("test888888888888888888888888888888888888888");
		//navigateTo = "/login.xhtml?faces-redirect=true";
			navigateTo = "/welcome.xhtml?faces-redirect=true";
		loggedIn = true; }
		
	else {
		FacesMessage facesMessage =

		new FacesMessage("Login Failed: please check your username/password and try again.");

		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}

	public String doLogout() {
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login.xhtml?faces-redirect=true";
	}
	
	public String goEvent(){
		return "/event.xhtml?faces-redirect=true";
		
	}

	public String goEnfant(){
		return "/enfant.xhtml?faces-redirect=true";
		
	}
}
