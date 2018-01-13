//重载
//重载
//参数不同：1、参数类型不同 2、参数个数不同的方法，返回值类型相同
public class TestOverload{
	
	
	public void max(int a,int b){
			System.out.println(a > b ? a : b);
		}
		
		public void max(double a,double b){
			System.out.println(a > b ? a : b);
		}
		
		
	public static void main(String[] args){
		
		
		TestOverload t = new TestOverload();
		
		t.max(3,4);
		t.max(3.0,5.0);
	}
}


//几天没练，java的基本框架都快忘了，惭愧惭愧
