public class Account {

    private long money;
    private String accNumber;
    private boolean isBlocked;

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
    public void withdrawMoney(long money) {
        if (!isBlocked) {
            if (this.money >= money) {
                this.money -= money;
            } else {
                System.out.println("Недостаточно средств для совершения данной операции");
            }
        } else {
            System.out.println("Аккаунт " + getAccNumber() + "  заблокирован. Обратитесь в ближайшее отделение банка или позвоните по телефону горячей линии");
        }
    }
    public void putMoney(long money) {
        if (!isBlocked) {
            this.money += money;
        } else {
            System.out.println("Аккаунт " + getAccNumber() + "   заблокирован. Обратитесь в ближайшее отделение банка или позвоните по телефону горячей линии");
        }
    }
}
