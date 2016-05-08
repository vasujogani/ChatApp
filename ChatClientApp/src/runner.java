public class runner
{
	public static void main(String args[])
	{
		int a = 0;
		Donald d = new Donald();
		for(int i = 0; i < 10; i++)
		{
			a = 0;
				try{
				Client c = new Client("10.99.84.23",9091);
				c.send("SETHANDLE Donald-Trump");
				while(a<10)
				{
					c.send("SAY " + d.talk());
					a++;
				}
			}catch(Exception e)
			{
				System.out.println("Error is : " + e.getMessage());
			}
				
		}
	}
}