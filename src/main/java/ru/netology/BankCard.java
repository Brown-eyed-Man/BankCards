package ru.netology;

public abstract class BankCard {
    protected long balance;
    // Получить информацию о балансе
    protected void getBalance() {
        System.out.printf("Текущий баланс: %d.\n", balance);
    }
    // Получить информации о доступных средствах
    abstract protected void getAvailableFunds();

    //Произведение оплаты
    abstract public boolean pay(long amount);

    //Произведение пополнения карты
    abstract public boolean replenish(long amount);
}