package lk.ijse.freshBite.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.freshBite.bo.BoFactory;
import lk.ijse.freshBite.bo.custom.LoginBo;
import lk.ijse.freshBite.bo.custom.impl.LoginBoImpl;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    public Label lblAlert;
    public AnchorPane root;
    public TextField txtPassword;

    @FXML
    private JFXButton btnForgotPwd;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXCheckBox pwdCheckBox;

    @FXML
    private PasswordField txtPwd;

    @FXML
    private TextField txtUserName;
    private LoginBo loginBo = (LoginBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.LOGIN);

    @FXML
    void btnForgotPwdONAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Forgot_password_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Forget Password form");
        stage.centerOnScreen();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
       login();

    }

    @FXML
    void cbShowPasswordOnAcction(ActionEvent event) {
        if (pwdCheckBox.isSelected()){
            txtPassword.setText(txtPwd.getText());
            txtPassword.setVisible(true);
            txtPwd.setVisible(false);
        }
        else{
            txtPwd.setText(txtPassword.getText());
            txtPwd.setVisible(true);
            txtPassword.setVisible(false);
        }

    }

    public void txtUserNameKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            // Enter key pressed in the username field, move focus to the password field
            txtPwd.requestFocus();
        }
    }

    public void txtPwKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            // Enter key pressed in the username field, move focus to the password field
            login();
        }

    }
    public void login (){
        String userName = txtUserName.getText();
        String pwd = txtPwd.getText();
        String pwd1 = txtPassword.getText();
        System.out.println(userName);
        System.out.println(pwd);
        try {
            var dto =  loginBo.CheckUserNamePassword ();
            System.out.println(dto);
            if(dto.getUserName().equals(userName) && dto.getPwd().equals(pwd) || dto.getPwd().equals(pwd1)){
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            }
            else {
                lblAlert.setVisible(true);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

