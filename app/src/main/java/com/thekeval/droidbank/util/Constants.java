package com.thekeval.droidbank.util;

import com.thekeval.droidbank.model.*;

public class Constants {

    // Constants
    public static String FILE_NAME = "data.json";

    public static String ReadyMadeJson = "{\"customers\":[{\"name\":\"Keval\",\"contactNo\":\"7021989791\",\"address\":\"Bhavnagar\",\"password\":\"abc\",\"accounts\":{\"savingAcc\":{\"minBalance\":100.0,\"interestRate\":6.0,\"accountNo\":\"001\",\"accountBalance\":20900},\"salaryAcc\":{\"employer\":\"Microsoft\",\"monthlySalary\":10000.0,\"accountNo\":\"002\",\"accountBalance\":32445.95}}},{\"name\":\"Prachi\",\"contactNo\":\"abc\",\"address\":\"Ahmedabad\",\"password\":\"123\",\"accounts\":{\"fdAcc\":{\"termDuration\":32,\"interestRate\":9.0,\"accountNo\":\"003\",\"accountBalance\":10987.99}}},{\"name\":\"Akash\",\"contactNo\":\"0987615434\",\"address\":\"toronto\",\"password\":\"abc\",\"accounts\":{\"salaryAcc\":{\"employer\":\"IBM\",\"monthlySalary\":8000.0,\"accountNo\":\"004\",\"accountBalance\":20099.32}}}]}";

    public static DataModel customers = null;
    public static CustomerDetails loggedInCustomer = null;

    public static double SAVING_MIN_BAL = 100.0;
    public static double SAVING_INT_RATE = 6.0;
    public static double FD_INT_RATE = 9.0;
    public static int LAST_ACC_NO = 0;

    public static String firstTimeWelcomeMessage = "\nWelcome to Swift Bank. Please register yourself to get started";
    public static String welcomeMessage = "\nWelcome to JP Bank. What would you like to do today?";
    public static String exitMessage = "Thank you for using Swift Bank. See you next time! Bye..";

}
