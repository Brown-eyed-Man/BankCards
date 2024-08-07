package ru.netology;

public class DebitCard extends BankCard {
    @Override
    public void getBalance() {
        System.out.printf("Текущий баланс дебетовой карты: %d.\n", balance);
    }

    @Override
    protected void getAvailableFunds() {
        getBalance();
        System.out.println("Дополнительные какие-либо средства отсутствуют.");
    }

    @Override
    public boolean pay(long amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        System.out.printf("Недостаточно средств для совершения оплаты в размере %d.\n", amount);
        return false;
    }

    @Override
    public boolean replenish(long amount) {
        balance += amount;
        return true;
    }
}