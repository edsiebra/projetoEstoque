package view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConexaoViewController implements Initializable{
	
	@FXML
	private Button btCancel;
	
	@FXML
	private Button btSave;
	
	@FXML
	private TextField txtHost;
	
	@FXML
	private TextField txtDB;
	
	@FXML
	private TextField txtUser;
	
	@FXML
	private TextField txtPorta;
	
	@FXML
	private PasswordField txtPsw;
	

	@FXML
	private void onBtSaveAction() {
		String iphost = txtHost.getText();
		String porta = txtPorta.getText();
		String banco = txtDB.getText();
		String user = txtUser.getText();
		String senha = txtPsw.getText();
		
		Properties props = loadPrperties();
		
		if(props != null) {
			props.setProperty("iphost", iphost);
			props.setProperty("porta", porta);
			props.setProperty("banco", banco);
			props.setProperty("user", user);
			props.setProperty("senha", senha);
			
		} else {
			props.setProperty("iphost", "localhost");
			props.setProperty("porta", "5432");
			props.setProperty("banco", "estoque");
			props.setProperty("user", "postgres");
			props.setProperty("senha", "database");
		}
		
		try {
			FileOutputStream fos = new FileOutputStream("conect.properties");
			props.store(fos, "propiedades_conexao");
			fos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Stage stage = (Stage) btSave.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void onBtCancel() {
		Stage stage = (Stage) btCancel.getScene().getWindow();
		stage.close();
	}

	private Properties loadPrperties() {
		try (FileInputStream fs = new FileInputStream("conect.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarDados();
		
	}


	@SuppressWarnings("null")
	private void carregarDados() {
		Properties props = loadPrperties();
		if(props != null) {
			txtHost.setText(props.getProperty("iphost"));
			txtPorta.setText(props.getProperty("porta"));
			txtDB.setText(props.getProperty("banco"));
			txtUser.setText(props.getProperty("user"));
			txtPsw.setText(props.getProperty("senha"));
		} else {
			txtHost.setText("localhost");
			txtPorta.setText("5432");
			txtDB.setText("estoque");
			txtUser.setText("postgres");
			txtPsw.setText("database");
		}
		
	}

}
