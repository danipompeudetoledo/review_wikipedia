package org.example.base;

import org.example.utilities.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)


    public  abstract class  Basetest {

        protected WebDriver driver;


        @BeforeAll

        void setUp(){
            driver = DriverFactory.getDriver();

            driver.get("https://en.wikipedia.org/");
        }

        @AfterAll
        void tearDown(){
            DriverFactory.quitDriver();
        }
    }





