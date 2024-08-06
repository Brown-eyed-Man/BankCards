package ru.netology;

public class Main {
    public static void main(String[] args) {
//        CreditCard creditCard = new CreditCard();
//        creditCard.replenish(5000);
//        creditCard.getAvailableFunds();
//        creditCard.pay(5000);
//        creditCard.getAvailableFunds();
//        creditCard.pay(3000);
//        creditCard.getAvailableFunds();
//        creditCard.replenish(2000);
//        creditCard.getAvailableFunds();
//        creditCard.replenish(2000);
//        creditCard.getAvailableFunds();
//        System.out.println(creditCard.pay(12000));
//        creditCard.getAvailableFunds();
//        creditCard.getBalance();
//        System.out.println();
//
//        DebitCard debitCard = new DebitCard();
//        debitCard.pay(1000);
//        debitCard.replenish(3000);
//        debitCard.getBalance();
//        debitCard.pay(1000);
//        debitCard.getBalance();

        CreditCardCashback cardCashback = new CreditCardCashback(10_000);
        cardCashback.pay(3000);
        cardCashback.getAvailableFunds();
        cardCashback.replenish(20000);
        cardCashback.getAvailableFunds();
        cardCashback.pay(10000);
        cardCashback.getAvailableFunds();
        cardCashback.pay(5000);
        cardCashback.getAvailableFunds();
        cardCashback.pay(4999);
        cardCashback.getAvailableFunds();

    }
}