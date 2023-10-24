package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	
	@FXML
	private TextField txtUser;
	
	@FXML
	private PasswordField pfPassword;
	
	@FXML
	private Button btLogin;
	
	@FXML
	private Button btCancel;
	
	@FXML
	private Label lbError;
	
	@FXML
	private ImageView imgLogo;
	
	
	@FXML
	private void onBtLoginAction() {
		
	}
	
	@FXML
	private void onBtCancelAction() {
		Stage stage = (Stage) btCancel.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
		lbError.setText("");
		Image img;
		try {
			img = new Image(new FileInputStream("\\image\\controle-de-estoque.jpg"));
			imgLogo.setImage(img);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//imgLogo = new Image("/image/controle-de-estoque.jpg");
	}

}
