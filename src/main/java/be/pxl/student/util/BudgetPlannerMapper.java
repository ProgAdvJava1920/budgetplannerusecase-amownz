package be.pxl.student.util;

import be.pxl.student.entity.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetPlannerMapper {

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
}
