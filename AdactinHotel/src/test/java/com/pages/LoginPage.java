package com.pages;

import org.openqa.selenium.By;

import com.base.ProjectHooks;

public class LoginPage extends ProjectHooks {

	private By username = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("login");

	public LoginPage enterUsername(String user) {
		type(username, user, "Username");
		return this;
	}

	public LoginPage enterPassword(String pass) {
		type(password, pass, "Password");
		return this;
	}

	public SearchPage clickLogin() {
		click(loginButton, "Login Button");
		return new SearchPage();
	}

}
