package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.projet.connection.connexion;

import java.sql.*;

public class PersonneService implements IDao<Person> {

	public PersonneService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Person o) {
		// TODO Auto-generated method stub
		try {
			String req = "insert into person (nom, lastName, email) values('"+o.getNom() +"','"+o.getPrenom()+"','"+o.getEmail()+"')";
			Statement st = connexion.getCn().createStatement();
			if(st.executeUpdate(req)==1) {
				return true;
			}
			
		} catch (SQLException ex) {
		System.out.println("Erreur SQL");
		System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Person o) {
		// TODO Auto-generated method stub
		try {
			String req = "update person set nom='"+o.getNom()+"',lastname='"+o.getPrenom()+"',email='"+o.getEmail()+"'";
			Statement st = connexion.getCn().createStatement();
			if (st.executeUpdate(req)==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error sql");
		}
		return false;
	}

	@Override
	public boolean delete(Person o) {
		// TODO Auto-generated method stub
		
		try {
			String req = "delete from person where id="+o.getId();
			Statement st =connexion.getCn().createStatement();
			
			if (st.executeUpdate(req)==1) {
				return true;
				
			}
		} catch (SQLException e) {
			System.out.println("ERROR sql");
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Person findById(int id) {
		// TODO Auto-generated method stub
		try {
			String req = "select * from client where id="+id;
			Statement st = connexion.getCn().createStatement();
			ResultSet rs = st.executeQuery(req);
				if (rs.next()) {
					return new Person(rs.getInt("id"), rs.getString("nom"), rs.getString("lastName"), rs.getString("email"));
					
					
				}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERROR SQL");
		}
		return null;
	}

	@Override
	public ObservableList<Person> findAll() {
		// TODO Auto-generated method stub
		ObservableList<Person> persons = FXCollections.observableArrayList();
		try {
			String req = "select * from person";
			
//			Statement st = connexion.getCn().createStatement();
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ResultSet rs= ps.executeQuery(req);
			while (rs.next()) {
				persons.add(new Person(rs.getInt("id"), rs.getString("nom"), rs.getString("lastName"), rs.getString("email")));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERROR SQl");
		}
		
		return persons;
	}

}
