package telephone;

import java.io.*;
import java.util.*;

public class TelephoneClass
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in)
				;
		
		ArrayList<MissedCall> al=new ArrayList<MissedCall>();
		al.add("9900565593", "Pappa");
		al.add("9741366563","Mom");
		al.add("7795101595","Me");
		al.add("8197652968","Yashu");
		int i=0;
		while(true)
		{
			System.out.println("Enter\n1:Call\n2:Display\n3:Delete based on request\n4:Display all details\n5:Exit\nEnter choice : ");
			int ch;
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter the time of call : ");
				String time=sc.nextLine();
				System.out.println("Enter the number : ");
				String number=sc.nextLine();
				String name;
				if(calls.containsKey(number))
				{
					name=calls.get(number);
				}
				else
				{
					name="Private caller";
				}
				System.out.println("Incoming call : "+name);
				MissedCall mc=new MissedCall(name,time,number);
				
				if(al.size()==10)
				{
					al.remove(0);
					al.add(mc);
				}
				else
				{
					al.add(mc);
				}
				break;
			case 2:
				int index=0;
				for(i=al.size()-1;i>=0;i--)
				{
					System.out.println(al.get(i).number);
					System.out.println("\nEnter\n1:Delete\n2:Next all\n3:Display details\n");
					int c=sc.nextInt();
					switch(c)
					{
					case 1:
						al.remove(i);
						break;
					case 2:
						continue;
					case 3:
						System.out.println(al.get(i));
						break;
					}
					
				}
				break;
			case 3:
				System.out.println("Enter the number to be deleed from the list : ");
				String num=sc.nextLine();
				MissedCall rem=null;
				for(MissedCall m:al)
				{
					if(m.number.equals(num))
					{
						rem=m;
					}
				}
				al.remove(rem);
				break;
			case 4:
				for(MissedCall m:al)
				{
					System.out.println(m);
				}
				break;
				
			case 5:
				System.exit(0);
				
			}
		}
	}
}

class MissedCall
{
	String name,number,time;
	MissedCall(String name,String number,String time)
	{
		this.name=name;
		this.number=number;
		this.time=time;
	}
	public String toString()
	{
		return name+"\t"+number+"\t"+time;
	}

}
