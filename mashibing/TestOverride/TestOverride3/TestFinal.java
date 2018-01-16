class Parent
{
  final public void m()
  {
    System.out.println("Final methods can not be overridden");
  }

  public void show()
  {
    System.out.println("Parent show()");
  }
}

class Child extends Parent
{
  /*public void m()
  {

  }
*/
  public void show()
  {
    System.out.println("Child show()");
  }
}

class TestFinal
{
  public static void main(String args[])
  {
    Parent p = new Parent();
    Parent c = new Child();
    p.m();
    p.show();
    c.m();
    c.show();
  }
}
