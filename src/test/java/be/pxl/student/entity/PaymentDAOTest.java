package be.pxl.student.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentDAOTest {

    private static final String DB_URL = "jdbc:h2:mem:test;MODE=MYSQL;INIT=RUNSCRIPT FROM 'classpath:BudgetPlannerTest.sql'";
    AccountDAO dao;
    @BeforeEach
    void setUp() {
      //  dao= new PaymentDAO(DB_URL);
    }

    @Test
    void create() {
        fail("not yet implemented");
    }

    @Test
    void getById() {
        fail("not yet implemented");
    }

    @Test
    void getAll() {
        fail("not yet implemented");
    }

    @Test
    void update() {
        fail("not yet implemented");
    }

    @Test
    void delete() {
        fail("not yet implemented");
    }
}