package com.wework.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by IntelliJ Idea IDEA
 * java version "1.8.0_91"
 * Author: Ean Song
 * Date: 2020-06-01
 * Time: 22:35
 */
public class ContentPage {
    RemoteWebDriver driver;

    By addMemberText = By.linkText("添加成员");
    By username = By.name("username");
    By deleteText = By.linkText("删除");

    public ContentPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    /**
     * 添加新用户
     *
     * @param username
     * @param acctid
     * @param memberAdd_phone
     */
    public ContentPage addMember(String username, String acctid, String memberAdd_phone) {
//        while(driver.findElements(this.username).size()==0){
//            driver.findElement(addMember).click();
//        }
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(addMemberText));
        driver.findElement(addMemberText).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("acctid")).sendKeys(acctid);
        driver.findElement(By.name("mobile")).sendKeys(memberAdd_phone);
        driver.findElement(By.cssSelector(".js_btn_save")).click();

        return this;
    }

    /**
     * 搜索成员
     *
     * @param keyword
     * @return
     */
    public ContentPage searchMember(String keyword) {
        driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(deleteText));
        return this;
    }

    /**
     * 删除搜索到的成员
     */
    public ContentPage deleteMember() {
        driver.findElement(deleteText).click();
        driver.findElement(By.linkText("确认")).click();
//        删除搜索框输入内容
        driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}
