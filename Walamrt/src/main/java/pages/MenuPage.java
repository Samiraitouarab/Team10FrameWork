package pages;

import base.CommonAPI;
import database.ConnectToSqlDB;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import reporting.TestLogger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static datasource.DataBase.filePath;

public class MenuPage extends CommonAPI {

    public void readMenuText(WebDriver driver1) throws  Exception, IOException, SQLException, ClassNotFoundException {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> actualData = new ArrayList<String>();
        List<String> listOfMenu = CommonAPI.getTextFromWebElements("#SearchDropdown-list");
        System.out.println("List of Walmar Menu from the Website of Walmart:");
        for(String data:listOfMenu){
            System.out.println(data);
        }
        System.out.println("**************************************************\n");
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        //connectToSqlDB.insertDataFromArrayListToSqlTable(listOfMenu,"WalmartItemList","items",filePath);
        actualData = connectToSqlDB.readDataBase("WalmartItemList","items",filePath);
        System.out.println("List of Walmart Menu from Mysql Databae :");
        for(String data : actualData){
            System.out.println(data);
        }
        Assert.assertEquals(listOfMenu,actualData);
    }

}