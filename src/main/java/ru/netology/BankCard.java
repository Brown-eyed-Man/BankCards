package ru.netology;

public abstract class BankCard {
    protected long balance;

    protected void getBalance() {
        System.out.printf("Текущий баланс: %d.\n", balance);
    }

    abstract protected void getAvailableFunds();

    abstract public boolean pay(long amount);

    abstract public boolean replenish(long amount);
}
