package com.xyzcorp;


import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(AcceptanceTest.class)
@Suite.SuiteClasses( { HelloWorldTest.class, SeleniumTest.class})
public class AcceptanceTestSuite {
}
