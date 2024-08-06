package ru.netology;

public class CreditCard extends BankCard {
    private long creditLimit;
    private long creditFunds;

    public CreditCard(long creditLimit) {
        this.creditLimit = creditLimit;
        creditFunds = creditLimit;
        System.out.println("Кредитная карта с лимитом " + creditLimit);
        getAvailableFunds();
    }

    @Override
    public boolean replenish(long amount) {
        if (creditFunds < creditLimit) {
            if (creditFunds + amount <= creditLimit) {
                creditFunds += amount;
            } else {
                long balanceReplenishment = creditFunds + amount - creditLimit;
                creditFunds = creditLimit;
                balance += balanceReplenishment;
            }
        } else {
            balance += amount;
        }
        return true;
    }

    @Override
    public void getAvailableFunds() {
        System.out.printf("Кредитные средства: %d.\n", creditFunds);
        System.out.printf("Собственные средства: %d.\n", balance);
    }

    @Override
    public boolean pay(long amount) {
        if (amount > creditLimit + creditFunds) {
            System.out.printf("Недостаточно средств для совершения оплаты на сумму %d.\n", amount);
            return false;
        } else if (balance > 0 && balance > amount) {
            balance -= amount;
        } else if (balance > 0) {
            long fundsPayment = amount - balance;
            balance = 0;
            creditFunds -= fundsPayment;
        } else {
            creditFunds -= amount;
        }
        return true;
    }

    public boolean setCreditLimit(long creditLimit) {
        if (creditLimit > 0) {
            this.creditLimit = creditLimit;
            System.out.printf("Кредитный лимит изменен на %d.\n", creditLimit);
            return true;
        } else {
            System.out.println("Не удалось заменить кредитный лимит.");
            return false;
        }
    }
}