package com.example.end_course.service.account;

import com.example.end_course.model.Account;
import com.example.end_course.model.Register;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account save(Account account);

    Optional<Account> getAccountById(int id);

    void delete(int id);

    List<Account> getAccounts();
}
