package p09_Thread;

public class Ex07Synchronized {
  public static void main(String[] args) {
    Customer customer = new Customer(); // 어카운트가 가지고 있는 상태
    new Thread(customer).start();
  }
}

class Account {
  int balance = 1000;

  public int getBalance() {
    return balance;
  }

  public void withdraw(int money) {
    if (balance >= money) {
      try {
        Thread.sleep(300); //sleep(300) ::  0.3초
      } catch (Exception e) {
      }
      balance -= money;
    }
  }
}

class Customer implements Runnable {  // class이지만 interface 타입 , 형변환 타입
  Account acc = new Account();

  @Override
  public void run() {
    while (acc.getBalance() > 0) {
      int money = (int) (Math.random() * 3 + 1) * 100;
      acc.withdraw(money);
      System.out.println("잔액: " + acc.getBalance());
    }
  }
}
