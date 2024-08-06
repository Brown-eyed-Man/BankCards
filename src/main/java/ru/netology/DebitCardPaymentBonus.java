package ru.netology;

public class DebitCardPaymentBonus extends DebitCard {
    private long bonusPoints;
    private int bonusPercent;

    public DebitCardPaymentBonus(int bonusPercent) {
        this.bonusPercent = bonusPercent;
    }


}
