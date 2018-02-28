//TestSort.java
public class TestSort
{
	public static void main(String[] args)
	{
		int a[] = {2,5,6,3,7,9,8,4,1,10};
		int temp[] = new int[a.length];
		int length = a.length;
		int j = 0;
		int count = 0;
    
		do
		{
			temp[count] = a[0];
			for(int i = 0;i < length;i++)
			{
				if(a[i] <= temp[count])
				{
					temp[count] = a[i];
					j = i;
				}
			}
			a[j] = a[length - 1];
				count++;
				length--;
		}while(length > 0);

		for(int k = 0;k < temp.length;k++)
			System.out.println(temp[k]);
	}
}
