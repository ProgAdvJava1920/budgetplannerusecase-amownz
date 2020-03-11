package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class BudgetPlannerMapper {

    public static final String Date_PATTERN = "EEE MMM d HH:mm:ss z yyyy";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(Date_PATTERN, Locale.ENGLISH);

    public Map<String, Account> accountMap = new HashMap<>();

    public List<Account> mapAccounts(List<String> accountLines) {


        for (String accountLine : accountLines) {
            try {
                Account account = mapDataLineToAccount(accountLine);
                accountMap.putIfAbsent(account.getIBAN(), account);
            } catch (ParseException | BudgetPlannerException e) {
                System.err.println("could not parse line " + accountLine);

            }

        }
        return new ArrayList<>(accountMap.values());

    }

    public Account mapDataLineToAccount(String line) throws ParseException, BudgetPlannerException {
        String[] items = line.split(",");

        if (items.length != 7) {
            throw new BudgetPlannerException("Invalid line. Expected 7 items Found " + items.length);
        }

        String name = items[0];
        String iban = items[1];

        Account account = accountMap.getOrDefault(iban, new Account(name,iban));
        Payment payment = mapItemsToPayment(items);
        account.getPayments().add(payment);
        return account;
    }

    public Date convertToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = SIMPLE_DATE_FORMAT;
        return dateFormat.parse(dateString);
    }

    public String convertDateToString(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }

    public Payment mapItemsToPayment(String[] items) throws ParseException {


        return new Payment(
                items[2],                   //IBAN
                convertToDate(items[3]),    // Transaction date
                Float.parseFloat(items[4]), // ammount
                items[5],                   //currency
                items[6]                    // detail

        );

    }
}
