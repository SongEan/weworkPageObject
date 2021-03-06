package com.wework.pageobject.testcase;

import com.wework.pageobject.page.ContentPage;
import com.wework.pageobject.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ Idea IDEA
 * java version "1.8.0_91"
 * Author: Ean Song
 * Date: 2020-06-01
 * Time: 22:47
 */
public class TestContent {
    public static MainPage mainPage;
    public static ContentPage contentPage;

    @BeforeAll
    public static void beforeAll() {
        mainPage = new MainPage();
        contentPage = mainPage.toContent();
    }

    @AfterAll
    public static void afterAll() {
        contentPage.quit();
    }

    /**
     * 新增联系人
     */
    @Test
    @Order(2)
    void testAddMember() {
        String userName=contentPage.addMember("12", "23", "13651362122").getUserName();
        assertEquals(userName, "3");
    }

    /**
     * 删除联系人
     */
    @Test
    @Order(1)
    void testDeleteMember() {
        contentPage.searchMember("12").deleteMember();
    }

}
