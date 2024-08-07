package ru.netology.featureCards;

import ru.netology.DebitCard;

import java.text.DecimalFormat;

public class DebitCardPaymentBonusWithAccumulation extends DebitCard {
    private long bonusPoints;
    private int bonusPercent;
    private double accumulatedPercent;
    private boolean accumulatedPercentActivated;

    public DebitCardPaymentBonusWithAccumulation(int bonusPercent) {
        setBonusPercent(bonusPercent);
    }

    @Override
    public boolean pay(long amount) {
        if (super.pay(amount)) {
            long addPoints = amount * bonusPercent / 100;
            bonusPoints += addPoints;
            System.out.printf("Вам начислено %d бонусных баллов.\n", addPoints);
            return true;
        }
        return false;
    }

    @Override
    public void getAvailableFunds() {
        getBalance();
        System.out.printf("Баланс бонусных баллов: %d.\n", bonusPoints);
        if (accumulatedPercentActivated) {
            String formattedNumber = formatAccumulationPercent(accumulatedPercent);
            System.out.printf("Подключено накопление в размере %s%% от суммы пополнения.\n", formattedNumber);
        }
    }

    // Установка размера бонусного процента
    public void setBonusPercent(int bonusPercent) {
        if (bonusPercent > 0 && bonusPercent < 100) {
            this.bonusPercent = bonusPercent;
            System.out.printf("Установлен процент (%d%%) для получения бонусных баллов при оплате.\n", bonusPercent);
        } else {
            System.out.println("Введён некорректный бонусный процент. (Он должен быть больше 0 и меньше 100)");
        }
    }

    // Установка значения накопительного процента.
    public void setAccumulatedPercent(double accumulatedPercent) {
        if (accumulatedPercent > 0 && accumulatedPercent < 100) {
            this.accumulatedPercent = accumulatedPercent;
            String formattedNumber = formatAccumulationPercent(accumulatedPercent);
            System.out.printf("Изменен накопительный процент на %s%%.\n", formattedNumber);
        }
    }

    // Подключение накопительного процента при уже установленном проценте.
    public void setAccumulatedPercentActivated(boolean accumulationActivation) {
        if (accumulatedPercent != 0) {
            if (accumulationActivation) {
                this.accumulatedPercentActivated = accumulationActivation;
                String formattedNumber = formatAccumulationPercent(accumulatedPercent);
                System.out.printf("Вы подключили накопительный процент в размере %s%%.\n", formattedNumber);
            } else {
                this.accumulatedPercentActivated = accumulationActivation;
                System.out.println("Вы отключили накопительный процент.");
            }
        } else {
            System.out.println("Установите размер накопительного процента для подключения данной услуги.");
        }
    }

    @Override
    public boolean replenish(long amount) {
        if (accumulatedPercentActivated) {
            if (super.replenish(amount)) {
                long accumulationAmount = (long) (amount * accumulatedPercent / 100);
                balance += accumulationAmount;
                System.out.printf("Получено накопление в размере %d.\n", accumulationAmount);
            }
        } else {
            super.replenish(amount);
        }
        return true;
    }

    // Форматирование процента для вывода на экран, чтобы не было лишних нулей после плавающей точки. (+ отсутствие дублирования кода).
    public String formatAccumulationPercent(double accumulatedPercent) {
        DecimalFormat df = new DecimalFormat("0.#");
        return df.format(accumulatedPercent);
    }
}