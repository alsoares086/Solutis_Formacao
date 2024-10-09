package com.bobocode.model;

public class Account {
    private Long id; // ID pode ser nulo
    private String firstName; // Novo campo para o primeiro nome
    private String lastName; // Novo campo para o sobrenome
    private String email; // Novo campo para o email
    private double balance; // Campo existente para o saldo

    // Construtor padrão
    public Account() {
    }

    // Construtor com parâmetros
    public Account(String firstName, String lastName, String email, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.balance = balance;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', email='" + email + "', balance=" + balance + "}";
    }
}
