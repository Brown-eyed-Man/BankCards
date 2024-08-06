package ru.netology;

public class DebitCard extends BankCard {
    public DebitCard() {
    }

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
        if (balance > amount) {
            balance -= amount;
            System.out.printf("Произведена оплата в размере %d.\n", amount);
            return true;
        }
        System.out.println("Недостаточно средств для совершения оплаты.");
        return false;
    }

    @Override
    public boolean replenish(long amount) {
        balance += amount;
        System.out.printf("Произведено пополнение в размере %d.\n", amount);
        return true;
    }
}
