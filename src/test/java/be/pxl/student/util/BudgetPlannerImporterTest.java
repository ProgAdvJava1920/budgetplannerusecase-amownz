package be.pxl.student.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetPlannerImporterTest {

List<String> list;

    @BeforeEach
    void setUp() throws BudgetPlannerException {
         list = BudgetPlannerImporter.readCsvFile(Paths.get("src/test/resources/account_paymentsTest.csv"));
    }

    @Test
    void read_csv_file_should_return_none_empty_list() {
        assertFalse(list.isEmpty());

    }

    @Test
    void read_csv_file_should_return_list_of_size_2() {
        assertEquals(2, list.size());
    }

    @Test
    void read_cvs_file_should_throw_our_own_exception_when_passing_null() throws BudgetPlannerException {
        assertThrows(BudgetPlannerException.class,() -> {
            BudgetPlannerImporter.readCsvFile(null);
        });

    }

    @Test
    void read_cvs_file_should_throw_exception_when_csv_file_does_not_exist() throws BudgetPlannerException {
        assertThrows(BudgetPlannerException.class, () -> {
            BudgetPlannerImporter.readCsvFile(Paths.get("non Existent File"));
        });



    }
}