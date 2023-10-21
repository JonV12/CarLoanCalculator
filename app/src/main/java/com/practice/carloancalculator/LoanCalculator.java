package com.practice.carloancalculator;

public class LoanCalculator extends MainActivity{
    double payment;
    double monthlyBalance;
    double remainingBalance;
    double interest;

    public LoanCalculator() {
        this.payment = payment;
        this.monthlyBalance = monthlyBalance;
        this.remainingBalance = remainingBalance;
        this.interest = interest;
    }

    public double getPayment() {
        payment = getMonthlyBalance() + getInterest();
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getMonthlyBalance() {
        monthlyBalance = getRemainingBalance()/UserInputStorage.getLoanLength();
        return monthlyBalance;
    }

    public void setMonthlyBalance(double monthlyBalance) {
        this.monthlyBalance = monthlyBalance;
    }

    public double getRemainingBalance() {
        remainingBalance = UserInputStorage.getLoanAmount() - UserInputStorage.getDownPayment();
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public double getInterest() {
        interest = (UserInputStorage.getApr() * monthlyBalance)/100;
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
