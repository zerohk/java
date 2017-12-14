//TestEquals
class Cat
{
	int color;
	int height;
	int weight;
	public Cat(int color,int height,int weight)
	{
		this.color = color;
		this.height = height;
		this.weight = weight;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		else
			if(obj instanceof Cat)//操作符instanceof
			{
				Cat c = (Cat) obj;//强制转换
				if(c.color == this.color && c.height == this.height && c.weight == this.weight)
					return true;
			}
			return false;
	}
}

public class TestEquals
{
	public static void main(String[] args)
	{
		Cat c1 = new Cat(1,2,5);
		Cat c2 = new Cat(1,2,3);
		System.out.println(c1.equals(c2));
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1==s2);//不等，指向两个不同对象
		System.out.println(s1.equals(s2));//相等，string重写了equals方法
	}
}
