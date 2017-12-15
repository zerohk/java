//多态
//·1.必须存在继承
//2、必须重写
//3.父类引用对象指向子类对象

class Animal
{
	String name;
	Animal(String name)
	{
		this.name = name;
	}
	
	void enjoy()
	{
		System.out.println("Animal voice");
	}
}

class Dog extends Animal
{
	String furCorlor;
	Dog(String name,String furCorlor)
	{
		super(name);
		this.furCorlor = furCorlor;
	}
	
	void enjoy()
	{
		System.out.println("Dog voice");
	}
}

class Cat extends Animal
{
	private String name;
	private String eyeColor;
	
	Cat(String name,String eyeColor)
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
	
	public void myPetEnjoy()
	{
		pet.enjoy();
	}
}


public class TestPoly
{
	public static void main(String[] args)
	{
		Dog d = new Dog("doggy","black");
		Lady l1 = new Lady("l1",d);
		l1.myPetEnjoy();
		Cat c = new Cat("catty","blue");
		Lady l2 = new Lady("l2",c);
		l2.myPetEnjoy();
	}
