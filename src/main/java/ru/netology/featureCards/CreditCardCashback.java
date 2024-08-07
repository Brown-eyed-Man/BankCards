package ru.netology.featureCards;

import ru.netology.CreditCard;

public class CreditCardCashback extends CreditCard {
    private int cashback = 5;
    private long necessaryAmountForCashback = 5_000;

    public CreditCardCashback(long creditLimit) {
        super(creditLimit);
        System.out.printf("Создана новая кредитная кэшбэк карта с %d%% для покупок от %d.\n", cashback, necessaryAmountForCashback);
    }

    @Override
    public boolean pay(long amount) {
        if (amount >= necessaryAmountForCashback) {
            if (super.pay(amount)) {
                long cashback = (long) Math.floor((double) (amount * this.cashback) / 100);
                replenish(cashback);
                System.out.printf("Начислен кэшбек в размере %d.\n", cashback);
                return true;
            }
        }
        return super.pay(amount);
    }

    // Установка необходимой суммы, при оплате от которой вы получаете установленный кэшбэк.
    public void setNecessaryAmountForCashback(long necessaryAmountForCashback) {
        this.necessaryAmountForCashback = necessaryAmountForCashback;
        System.out.println("Изменена сумма для получения кэшбека на " + necessaryAmountForCashback);
    }

    // Установка кэшбэка
    public void setCashback(int cashback) {
        if (cashback > 0 && cashback < 100) {
            this.cashback = cashback;
            System.out.printf("Кэшбэк изменён на %d%%.\n", cashback);
        } else {
            System.out.println("Кэшбэк не изменён.");
        }
    }
}