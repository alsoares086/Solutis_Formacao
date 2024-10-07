package com.bobocode.web.controller;

import com.bobocode.dao.AccountDao;
import com.bobocode.model.Account;
//import com.bobocode.exception.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * todo: 1. Configure rest controller that handles requests with url "/accounts"
 * todo: 2. Inject {@link AccountDao} implementation
 * todo: 3. Implement method that handles GET request and returns a list of accounts
 * todo: 4. Implement method that handles GET request with id as path variable and returns account by id
 * todo: 5. Implement method that handles POST request, receives account as request body, saves account and returns it
 * todo:    Configure HTTP response status code 201 - CREATED
 * todo: 6. Implement method that handles PUT request with id as path variable and receives account as request body.
 * todo:    It check if account id and path variable are the same and throws {@link IllegalStateException} otherwise.
 * todo:    Then it saves received account. Configure HTTP response status code 204 - NO CONTENT
 * todo: 7. Implement method that handles DELETE request with id as path variable removes an account by id
 * todo:    Configure HTTP response status code 204 - NO CONTENT
 */
@RestController
@RequestMapping("/accounts") // 1. Configure rest controller that handles requests with url "/accounts"
public class AccountRestController {

    private final AccountDao accountDao; // 2. Inject {@link AccountDao} implementation

    @Autowired
    public AccountRestController(AccountDao accountDao) {
        this.accountDao = accountDao; // Injeção de dependência
    }

    // 3. Implement method that handles GET request and returns a list of accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountDao.findAll();
        return ResponseEntity.ok(accounts);
    }

    // 4. Implement method that handles GET request with id as path variable and returns account by id
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
        Account account = accountDao.findById(id);
        return ResponseEntity.ok(account);
    }

    // 5. Implement method that handles POST request, receives account as request body, saves account and returns it
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountDao.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount); // Configure HTTP response status code 201 - CREATED
    }

    // 6. Implement method that handles PUT request with id as path variable and receives account as request body.
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAccount(@PathVariable long id, @RequestBody Account account) {
        // Verifica se o ID no caminho da URL é o mesmo que o ID da conta recebida
        if (account.getId() == null || id != account.getId()) {
            throw new IllegalStateException("Account ID in the path and body must match");
        }
        accountDao.save(account); // Salva a conta recebida
        return ResponseEntity.noContent().build(); // Retorna 204 - NO CONTENT
    }

    // 7. Implement method that handles DELETE request with id as path variable removes an account by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id) {
        Account account = accountDao.findById(id); // Verifica se a conta existe
        accountDao.remove(account);
        return ResponseEntity.noContent().build(); // Configure HTTP response status code 204 - NO CONTENT
    }
}
