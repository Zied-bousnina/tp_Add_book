package application;

import java.sql.*;
	
import javafx.event.ActionEvent;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;



import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import ma.projet.connection.connexion;

public class AddBookController implements Initializable {

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfEmail;

    @FXML
    private Button addbtn;

    @FXML
    private TextField tfLastName;

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> lastNameCol;

    @FXML
    private TableColumn<Person, String> firstNameCol;

    @FXML
    private TableColumn<Person, String> emailCol;

    @FXML
    private Button removebtn;

    @FXML
    private Button exportbtn;

    @FXML
    private Button importbtn;

    @FXML
    private Button quitbtn;
    
    private DataClass data;
    
     ObservableList<Person> listM ;
    connexion connectionClass ;

    @FXML
    public void Export(ActionEvent event) {
    	

//    	data = new DataClass();
//    	list.addAll( data.getExportList());

    }

    @FXML
    public void importer(ActionEvent event) {
//    	for (Person p : data.getExportList()) {
//    		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
//    		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//    		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    	
    	  PersonneService ps=new PersonneService();
    	  listM = ps.findAll();
			
//    	data = new DataClass();
//    	list.addAll(data.getImportList());
    		
    		table.setItems(listM);
    		
    		
    		
    	
    		
    		
//    		System.out.println(data.getImportList().get(0).getNom());
			
//		}
    	

    }

    @FXML
    public void quit(ActionEvent event) {
    	Platform.exit();

    }
    

    @FXML
    public void remove(ActionEvent event) {
//    	table.setOnMouseClicked(eventE->{
//    		
//    	Person p =table.getSelectionModel().getSelectedItem();
//    	System.out.println(p.getEmail());
//    	
//    	
//    	});
//    	table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
    	PersonneService ps=new PersonneService();
    	ps.delete(table.getSelectionModel().getSelectedItems().get(0));
    	System.out.println(table.getSelectionModel().getSelectedItems().get(0).getId());

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("nom"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("prenom"));
		
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		
		editableCols();
		 
		
		
	}
	
	
	
	private void editableCols() {
		// TODO Auto-generated method stub
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
		firstNameCol.setOnEditCommit(e->{
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setNom(e.getNewValue());
		});
		
		lastNameCol.setOnEditCommit(e->{
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrenom(e.getNewValue());
		});
		
		emailCol.setOnEditCommit(e->{
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmail(e.getNewValue());
		});
		table.setEditable(true);
		
		
	}

	public void showPerson() {
		
		
	}

    @FXML
    void insert(ActionEvent event) throws SQLException {
    	
      
    	//Connection
    	connectionClass= new connexion();
    	Connection connection = connectionClass.getCn();
    	
    	PersonneService personneService = new PersonneService();
    	String nom=tfFirstName.getText();
    	String lastName=tfLastName.getText();
    	String email=tfEmail.getText();
    	if (!nom.isEmpty() & !lastName.isEmpty() && !email.isEmpty()  ) {
			
    	Person p =new Person(nom, lastName, email);
//    	table.getItems().add(p);
    	System.out.println(p.toString());
    	
    	personneService.create(p);
    	
    		
    		
    		
    	}else {
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Champ Vide");
    		alert.setContentText("Remplir tous les champs !");
    		alert.showAndWait();
    		
    		
    	}

    }
	
	
	

}



