package ru.netology;

import ru.netology.featureCards.CreditCardCashback;
import ru.netology.featureCards.DebitCardPaymentBonusWithAccumulation;

/*  1) В задании использовался тип переменной long для денежных значений, так как в банках могут использоваться
большие суммы для хранения средств крупных компаний, значения которых превышают диапозоны значения int;
    2) Некоторые методы возвращают значения boolean, так как операции могут срываться и дальнейшие действия будут
зависеть от возвращаемого значения (при полной работе банковского приложения, так как я полагаю, что оно так работает);
    3) Пример с накопительным процентом показался с опечаткой (0,005% = 0,00005, что при пополнении на 300 000 рублей
даёт всего лишь 15 рублей), поэтому код писался под 0,5%;
    4) Класс CreditCardCashback подразумевает под собой кредитную карту с возможностью получать кэшбек;
    5) Класс DebitCardPaymentBonusWithAccumulation подразумевает под собой дебетовую карту с получением бонусных баллов
при оплате на определенную сумму, а также возможность подключить/отключить накопительный процент.
*/
public class Main {
    public static void main(String[] args) {

//         CREDIT CARD

        CreditCard creditCard = new CreditCard(10_000);
        creditCard.pay(15000);
        creditCard.replenish(5000);
        creditCard.getAvailableFunds();
        creditCard.pay(5000);
        creditCard.getAvailableFunds();
        creditCard.pay(3000);
        creditCard.getAvailableFunds();
        creditCard.replenish(2000);
        creditCard.getAvailableFunds();
        creditCard.replenish(2000);
        creditCard.getAvailableFunds();
        System.out.println();

//         DEBIT CARD

        DebitCard debitCard = new DebitCard();
        debitCard.pay(1000);
        debitCard.replenish(3000);
        debitCard.getBalance();
        debitCard.pay(1000);
        debitCard.getBalance();
        System.out.println();

//         CREDIT CASHBACK CARD

        CreditCardCashback cardCashback = new CreditCardCashback(10_000);
        cardCashback.pay(3000);
        cardCashback.getAvailableFunds();
        cardCashback.replenish(20000);
        cardCashback.getAvailableFunds();
        cardCashback.pay(10000);
        cardCashback.getAvailableFunds();
        cardCashback.pay(5000);
        cardCashback.getAvailableFunds();
        cardCashback.setNecessaryAmountForCashback(1000);
        cardCashback.setCashback(1);
        cardCashback.pay(4999);
        cardCashback.getAvailableFunds();
        System.out.println();

//         DEBIT CARD PAYMENT BONUS

        DebitCardPaymentBonusWithAccumulation debitCardPaymentBonusWithAccumulation = new DebitCardPaymentBonusWithAccumulation(1);
        debitCardPaymentBonusWithAccumulation.pay(1000);
        debitCardPaymentBonusWithAccumulation.replenish(15000);
        debitCardPaymentBonusWithAccumulation.getAvailableFunds();
        debitCardPaymentBonusWithAccumulation.pay(2400);
        debitCardPaymentBonusWithAccumulation.getAvailableFunds();
        debitCardPaymentBonusWithAccumulation.pay(2600);
        debitCardPaymentBonusWithAccumulation.getAvailableFunds();
        debitCardPaymentBonusWithAccumulation.setBonusPercent(10);
        debitCardPaymentBonusWithAccumulation.pay(10000);
        debitCardPaymentBonusWithAccumulation.getAvailableFunds();
        //Установка накопительного процента и его подключение
        debitCardPaymentBonusWithAccumulation.setAccumulatedPercent(0.5);
        debitCardPaymentBonusWithAccumulation.setAccumulatedPercentActivated(true);
        debitCardPaymentBonusWithAccumulation.getAvailableFunds();
        //Проверка на работоспособность накопительного процента
        debitCardPaymentBonusWithAccumulation.replenish(10000);
        debitCardPaymentBonusWithAccumulation.getAvailableFunds();
        //Отключение накопительного процента
        debitCardPaymentBonusWithAccumulation.setAccumulatedPercentActivated(false);
        //Проверка на работоспособность после отключения накопительного процента
        debitCardPaymentBonusWithAccumulation.replenish(10000);
        debitCardPaymentBonusWithAccumulation.getAvailableFunds();
    }
}