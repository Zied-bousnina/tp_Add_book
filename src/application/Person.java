package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty prenom;
	private SimpleStringProperty nom;
	
	private SimpleStringProperty email;
	

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom.get();
	}
	public int getId() {
		return id.get();
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom.setValue(prenom);;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom.get();
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom.setValue(nom);
	}


	


	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email.get();
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email.setValue(email);;
	}

	

	@Override
	public String toString() {
		return "Person [prenom=" + prenom + ", nom=" + nom +  ", email=" + email + "]";
	}


	public Person() {
		// TODO Auto-generated constructor stub
	}


	public Person(int id, String nom, String prenom, String email) {
		// TODO Auto-generated constructor stub
		this.id=new SimpleIntegerProperty(id);
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.email = new SimpleStringProperty(email);
	}
	public Person( String nom, String prenom, String email) {
		// TODO Auto-generated constructor stub
		
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.email = new SimpleStringProperty(email);
	}

}
