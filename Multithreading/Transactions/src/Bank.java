import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }
    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException
    {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        if(fromAccount == toAccount){
            System.out.println("Ошибка: Указан один и тот же аккаунт");
        }else {
            synchronized (fromAccount){
                synchronized (toAccount){
                    if (fromAccount.isBlocked() == true){
                        System.out.println("Ошибка: Ваш аккаунт заблокирован");
                    } else if (toAccount.isBlocked() == true) {
                        System.out.println("Ошибка: Аккаунт получателя заблокирован");
                    }
                    if (fromAccount.getMoney() < amount){
                        System.out.println("Ошибка: Недостаточно средств на счете");
                    }else {
                        System.out.println("Перевод " + amount + " с " + fromAccountNum + " на " + toAccountNum);
                        fromAccount.withdrawMoney(amount);
                        toAccount.putMoney(amount);
                        if (amount > 50_000){
                            if (isFraud(fromAccountNum,toAccountNum,amount)){
                                fromAccount.setBlocked(true);
                                toAccount.setBlocked(true);
                                System.out.println("Произошла блокировка");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts(String accountNum) {
        return 0;
    }
}
