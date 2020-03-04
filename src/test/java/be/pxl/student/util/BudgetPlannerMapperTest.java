package be.pxl.student.util;

import be.pxl.student.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
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
}