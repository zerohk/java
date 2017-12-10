public class iFab {
	public static void main(String[] args) {
		System.out.println(iFab(0));
		
	}
	
	public static long iFab(int n){
		if(n < 1)
		{
			System.out.println("Error!");
			return -1;
		}
		long f1 = 1L;
		long f2 = 2L;
		long f = 0L;
		
		if(n == 1 || n == 2)
		{
			return 1;
		}
		else
		{
			for(int i = 1;i < n-2;i++)
				{
					f = f1 + f2;
					f1 = f2;
					f2 = f;
				}
				return f;
		}
		
	}
}
