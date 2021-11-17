package com.seleniumframeworks.pages;

import org.openqa.selenium.By;

public final class UserManagementPage extends BasePage{

    By buttonAdd = By.id("btnAdd");
    By listUserRole = By.id("systemUser_userType");
    By textboxEmployeeName = By.id("systemUser_employeeName_empName");
    By textboxUsername = By.id("systemUser_userName");
    By listStatus = By.id("systemUser_status");
    By textboxPassword = By.id("systemUser_password");
    By textboxConfirmPassword = By.id("systemUser_confirmPassword");
    By buttonSave = By.id("btnSave");
    By textboxSearch = By.id("searchSystemUser_userName");
    By buttonSearch = By.id("searchBtn");
    By usersTable = By.xpath("//table[@id='resultTable']/tbody/tr");

    public UserManagementPage clickButtonAdd(){
        click(buttonAdd, "Add");
        return this;
    }

    public UserManagementPage enterEmployeeName(String employeeName){
        sendKeys(textboxEmployeeName, employeeName, "Employee Name");
        return this;
    }

    public UserManagementPage enterUsername(String username){
        sendKeys(textboxUsername, username, "Username");
        return this;
    }

    public UserManagementPage enterPassword(String password){
        sendKeys(textboxPassword, password, "Password");
        return this;
    }

    public UserManagementPage enterConfirmPassword(String password){
        sendKeys(textboxConfirmPassword, password, "Confirm Password");
        return this;
    }

    public UserManagementPage enterSearchUsername(String searchText){
        sendKeys(textboxSearch, searchText, "Search username");
        return this;
    }

    public UserManagementPage selectUserRole(String userRole){
        selectText(listUserRole, userRole, "User role");
        return this;
    }

    public UserManagementPage selectUserStatus(String status){
        selectText(listStatus, status, "Status");
        return this;
    }

    public UserManagementPage clickSave(){
        click(buttonSave, "Save");
        return this;
    }

    public UserManagementPage clickSearch(){
        click(buttonSearch, "Search");
        return this;
    }

    public boolean isValuePresentInUsersTable(String value){
        return findValueInTableContent(usersTable, value).length>=1;
    }
}
