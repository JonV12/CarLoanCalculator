package com.practice.carloancalculator;

public class UserInputStorage{
    static double loanAmount;
    static double apr;
    static int loanLength;
    static double downPayment;

    public UserInputStorage() {
        this.loanAmount = loanAmount;
        this.apr = apr;
        this.loanLength = loanLength;
        this.downPayment = downPayment;
    }

    public static double getLoanAmount() {
        return loanAmount;
    }

    public static void setLoanAmount(double mLoanAmount) {
        loanAmount = mLoanAmount;
    }

    public static double getApr() {
        return apr;
    }

    public static void setApr(double mApr) {
        apr = mApr;
    }

    public static int getLoanLength() {
        return loanLength;
    }

    public static void setLoanLength(int mLoanLength) {
        loanLength = mLoanLength;
    }

    public static double getDownPayment() {
        return downPayment;
    }

    public static void setDownPayment(double mDownPayment) {
        downPayment = mDownPayment;
    }
}
