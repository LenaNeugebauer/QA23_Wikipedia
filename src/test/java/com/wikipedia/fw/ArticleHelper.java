package com.wikipedia.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticleHelper extends HelperBase{

    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void searchArticle(String text) {
        tap(By.id("search_container"));
        type(By.id("search_src_text"), text);
        waitForElementAndTap(By.id("page_list_item_container"),15);
        pause(5000);
        String title = driver.findElement(By.id("view_page_title_text")).getText();
        System.out.println(title);
    }

    public void addToFavorites() {
        waitForElementAndTap(By.xpath("//*[@content-desc='Add this article to a reading list']"),5);
    }

    public void createReadingList(String text) {
        waitForElementAndTap(By.xpath("//*[@text='GOT IT']"), 10);
        waitForElementAndType(By.id("text_input"), 15, text);
        tap(By.xpath("//*[@text='OK']"));
        tap(By.xpath("//*[@content-desc='Navigate up']"));
    }

    public void deleteFavoriteArticle (){
        waitForElementAndTap(By.xpath("//*[@content-desc='My lists']"),10);
        waitForElementAndTap(By.id("item_title"),10);
        tap(By.id("page_list_item_action_primary"));
        tap(By.id("reading_list_item_remove_text"));
    }
}
