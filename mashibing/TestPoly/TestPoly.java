class Animal
{
  String name;
  public Animal(String name)
  {
    this.name = name;
  }
  public void enjoy()
  {
    System.out.println("叫声");
  }
}

class Dog extends Animal
{
  String furColor;
  public Dog(String name,String furColor)
  {
    super(name);
    this.furColor = furColor;
  }

  public void enjoy()
  {
    System.out.println("Dog voice");
  }
}

class Cat extends Animal
{
  String eyeColor;
  public Cat(String name,String eyeColor)
  {
    super(name);
    this.eyeColor = eyeColor;
  }

  public void enjoy()
  {
    System.out.println("Cat voice");
  }
}

class Lady
{
  private String name;
  private Animal pet;
  Lady(String name,Animal pet)
  {
    this.name = name;
    this.pet = pet;
  }

  public void mypetEnjoy()
  {
    pet.enjoy();
  }
}

public class TestPoly
{
   public static void main(String[] args) {
     Animal c = new Cat("cat","black");
    Lady l1 = new Lady("l1",c);
    l1.mypetEnjoy();
  }
}
