package p03_method;

public class Ex02GetterSetter {
  public static void main(String[] args) {
    Person p1 = new Person();

    /*p1.id = "admin";
    p1.pass ="1234";
    p1.mobile = "1111"; */ // 아래에 private를 사용했기 때문에 외부에서접근이 불가하다
    System.out.println(p1.getName());
    System.out.println(p1.getId());
    System.out.println(p1.getPass());
    System.out.println(p1.getMobile());

    p1.setName("LGH");
    p1.setId("admin");
    p1.setPass("1111");
    p1.setMobile("010-3446-7374");

    System.out.println(p1.getName());
    System.out.println(p1.getId());
    System.out.println(p1.getPass());
    System.out.println(p1.getMobile());
  }
}

class Person{
  // 속성에 private 을 붙이면 외부에서 접근 불가
  private String name;
  private String id;
  private String pass;
  private String mobile;

  public String getName() {
    return name;
  }

 public void setName(String name) {
    this.name = name;
  } // name = name 은 못쓴다. 그래서 this name 만들어준다


  // alt + insert  누르면 밑에 내용들을 자동으로 생성해준다.
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


}
