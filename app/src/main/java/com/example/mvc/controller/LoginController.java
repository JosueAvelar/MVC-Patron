package com.example.mvc.controller;

import com.example.mvc.model.User;
import com.example.mvc.view.ILoginView;

public class LoginController implements ILoginController{
    ILoginView loginView;
    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }
    @Override
    public void OnLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValid();
        if(loginCode == 0)
        {
            loginView.OnLoginError("Por favor, ingrese un Email");
        }else  if (loginCode == 1){
            loginView.OnLoginError("Ingrese un Email valido");
        } else  if (loginCode == 2)
        {
            loginView.OnLoginError("Por favor ingrese la contraseña");
        }else  if(loginCode == 3){
            loginView.OnLoginError("Ingrese una contraseña mayor a 6 digitos");
        }
        else {
            loginView.OnLoginSuccess("login Successful");
        }
    }
}
