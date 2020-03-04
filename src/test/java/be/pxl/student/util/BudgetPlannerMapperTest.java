package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetPlannerMapperTest {
    List<String> accountLines;
    BudgetPlannerMapper mapper;
    String testDataLine = "Jos,BE69771770897312,BE17795215960626,Thu Feb 13 05:47:35 CET 2020,265.8,EUR,Ut ut necessitatibus itaque ullam.";
    Path testCvsFile = Paths.get("src/test/resources/account_paymentsTest.csv");

    @BeforeEach
    void setUp() throws BudgetPlannerException {
        mapper = new BudgetPlannerMapper();
        accountLines = BudgetPlannerImporter.readCsvFile(testCvsFile);
        List<String> accountLines;
    }

    @Test
    void it_should_return_non_empty_list() {
        assertFalse(mapper.mapAccounts(accountLines).isEmpty());

    }

    @Test
    void it_should_map_to_account_list_with_1_account_with_2_payments() {
        List<Account> accountList = mapper.mapAccounts(accountLines);
        assertEquals(2, accountList.get(0).getPayments().size(), "account should have 2 payments");
    }

    @Test
    void it_should_map_to_account_list_with_1_account() {
        List<Account> accountList = mapper.mapAccounts(accountLines);
        assertEquals(1, accountList.size(), "it should have 1 account");
    }

    @Test
    void it_should_map_line_to_account_object() {
        Account expectedAccount = new Account("Jos", "BE69771770897312");
        Account lineToAccount = mapper.mapDataLineToAccount(testDataLine);

        assertEquals(expectedAccount, lineToAccount);
    }


    @Test
    void it_should_map_line_to_payment() throws ParseException {
        Payment expectedPayment = new Payment(
                "BE17795215960626",
                mapper.convertToDate("Thu Feb 13 05:47:35 CET 2020"),
                265.8f,
                "EUR",
                "Ut ut necessitatibus itaque ullam."
        );


    }

    @Test
    void it_should_convert_to_date_to_string_and_back_again() throws ParseException {
        String testDate = "Thu Feb 13 05:47:35 CET 2020";
        Date date = mapper.convertToDate(testDate);
        String dateToString = mapper.convertDateToString(date);
        assertEquals(testDate, dateToString);
    }
}