package p09_Thread;

public class Ex02Synchronized {
  public static void main(String[] args) { //main 이 Thread 기능을 가진다.
    Customer customer = new Customer(); // 어카운트가 가지고 있는 상태
    new Thread(customer).start();
    new Thread(customer).start();
  }
}

class Account {
  int balance = 1000;

  public int getBalance() {
    return balance;}

  synchronized public void withdraw(int money) { //synchronized 를 method에 붙여서 동기화시킨다.
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
      acc.withdraw(money); //withdraw 인출하다
      System.out.println("잔액: " + acc.getBalance());
    }
  }
}
