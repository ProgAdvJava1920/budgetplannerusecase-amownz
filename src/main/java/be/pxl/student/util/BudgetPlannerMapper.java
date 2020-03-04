package be.pxl.student.util;

import be.pxl.student.entity.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class BudgetPlannerMapper {

    public static final String Date_PATTERN = "EEE MMM d HH:mm:ss z yyyy";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(Date_PATTERN, Locale.ENGLISH);

    public List<Account> mapAccounts(List<String> accountLines) {

        List<Account> accountList = new ArrayList<>();
        for (String accountLine : accountLines) {
            Account account = mapDataLineToAccount(accountLine);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }

        }
        return accountList;

    }

    public Account mapDataLineToAccount(String line) {
        String[] items = line.split(",");

        String name = items[0];
        String iban = items[1];
        return new Account(name, iban);
    }

    public Date convertToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = SIMPLE_DATE_FORMAT;
        return dateFormat.parse(dateString);
    }

    public String convertDateToString(Date date){
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
