package p03_method;

public class Ex03ConstructorA {
  public static void main(String[] args) {
    Employee E1 = new Employee("최유리", 01,"24-05-10",30,"여자");

    System.out.println(E1 .getEname());
    System.out.println(E1 .getEmpno());
    System.out.println(E1 .getHiredate());
    System.out.println(E1 .getAge());
    System.out.println(E1 .getGender());
    Employee employee1 = new Employee();
    Employee employee2 = new Employee();
  }
}

class Employee {
  {
    System.out.println("Initial Block instance");} //초기화 블럭

  public Employee(String ename, int empno, String hiredate, int age, String gender) {
    this.ename = ename;
    this.empno = empno;
    this.hiredate = hiredate;
    this.age = age;
    this.gender = gender;
  }
  static {
    System.out.println("Initial Block static");
  }
  private String ename;
  private int empno;
  private String hiredate;
  private int age;
  private String gender;

  public Employee () {

  }


  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public int getEmpno() {
    return empno;
  }

  public void setEmpno(int empno) {
    this.empno = empno;
  }

  public String getHiredate() {
    return hiredate;
  }

  public void setHiredate(String hiredate) {
    this.hiredate = hiredate;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}







