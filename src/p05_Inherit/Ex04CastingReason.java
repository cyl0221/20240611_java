package p05_Inherit;

public class Ex04CastingReason {
  public static void main(String[] args) {
    Buyer b = new Buyer();

    Laptop laptop = new Laptop();
    Tv tv = new Tv();
    Audio audio = new Audio();


    b.buy(tv); b.buy(audio); b.buy(laptop);


  /*  Product l1 = new Laptop();
    Product t1 = new Tv();
    Product a1 = new Audio();*/

  }
}

class Buyer {
  int money= 1000;

  void buy(Product product) {
    money -= product.price;

  }


/*  void buy(Tv tv) {
   money -= tv.Price;}
  void buy(Audio audio) {
    money -= audio.Price;}
  void buy(Tv tv) {
    money -= tv.Price;}
 }*/

}

abstract class Product {
    int price;
  public Product(int price) {
  this.price = price;
  }
}


class Laptop extends Product {
  public Laptop() {super (300);}


}
class Tv extends Product {
  public Tv() {super (400);}
}

class Audio extends Product {
  public Audio () {super (200);}
}
