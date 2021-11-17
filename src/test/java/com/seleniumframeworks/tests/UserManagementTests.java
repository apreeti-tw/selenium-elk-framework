package com.seleniumframeworks.tests;

import com.seleniumframeworks.annotations.FrameworkAnnotations;
import com.seleniumframeworks.enums.CategoryTypes;
import com.seleniumframeworks.pages.OrangeHRMLoginPage;
import com.seleniumframeworks.pages.UserManagementPage;
import com.seleniumframeworks.utils.DataProviderUtils;
import com.seleniumframeworks.utils.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public final class UserManagementTests extends BaseTest {

    @FrameworkAnnotations(author = {"Preeti"}, category = {CategoryTypes.SMOKE})
    @Test(dataProvider = "DataContainer", dataProviderClass = DataProviderUtils.class)
    public void adminShouldBeAbleToAddNewUser(Map<String,String> user){
        new OrangeHRMLoginPage()
                .enterUsername(user.get("username"))
                .enterPassword(RandomUtils.decodeBase64(user.get("password")))
                .clickLogin()
                .hoverOnMainMenuItem("Admin")
                .hoverOnSubMenuItem("User Management")
                .clickOnMenuItem("Users");

        String username = RandomUtils.getFakeUsername(user.get("role"));
        String password = RandomUtils.getFakePassword();

        UserManagementPage userManagementPage =
                new UserManagementPage()
                        .clickButtonAdd()
                        .selectUserRole(user.get("role"))
                        .enterEmployeeName(user.get("name"))
                        .enterUsername(username)
                        .selectUserStatus(user.get("status"))
                        .enterPassword(password)
                        .enterConfirmPassword(password)
                        .clickSave()
                        .clickSave()
                        .enterSearchUsername(username)
                        .clickSearch();

        Assert.assertTrue(userManagementPage.isValuePresentInUsersTable(username));
    }
}
