import java.util.*;
import java.util.Map.Entry;
class Books {
	String title,author,publisher;
	int price;
	Books(String title,String author,String publisher,int price)
	{
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
	}
	public String toString()
	{
		return title+"\n"+author+"\n"+publisher+"\n"+price;
	}	
}

class priceCompare implements Comparator<Books>
{
	public int compare(Books b1,Books b2)
	{
		return (int)(b1.price-b2.price);
	}
}

public class Book
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Books> al=new ArrayList<Books>();
		al.add(new Books("Harry Potter","JK Rowling","Bloomsbury",799));
		al.add(new Books("TNGS","Enid Blyton","Scholastic",699));
		
		for(Books b:al)
		{
			System.out.println(b);
			System.out.println("-----");
		}
		
		Collections.sort(al,new priceCompare());
		for(Books b:al)
		{
			System.out.println(b);
			System.out.println("-----");
		}
		
		HashMap<Integer,Books> hm=new HashMap<Integer,Books>();
		int i=1;
		for(Books b:al)
		{
			hm.put(i, b);
			i++;
		}
		
		Set<Map.Entry<Integer, Books>> set=hm.entrySet();
		System.out.println("Enter author's name : ");
		String auth=sc.nextLine();
		for(Map.Entry<Integer,Books> setv: set)
		{
			if(setv.getValue().author.equals(auth))
			{
				System.out.println(setv.getValue());
			}
		}
		
		ArrayList<Books> higher=new ArrayList<Books>();
		System.out.println("Enter the required price  : ");
		int price1=sc.nextInt();
		for(Map.Entry<Integer, Books> setv:set)
		{
			if(setv.getValue().price>price1)
			{
				higher.add(setv.getValue());
			}
		}
		System.out.println("Books that cost more than Rs."+price1);
		for(Books b:higher)
		{
			System.out.println(b);
		}
		
		System.out.println("Enter the title : ");
		String title1=sc.nextLine();
		for(Map.Entry<Integer, Books> setv:set)
		{
			if(setv.getValue().title.contains(title1))
			{
				System.out.println(setv.getValue());
			}
		}
		
		System.out.println("Enter publisher : ");
		String publisher1=sc.nextLine();
		for(Map.Entry<Integer,Books> setv:set)
		{
			if(setv.getValue().publisher.equals(publisher1))
			{
				System.out.println(setv.getValue());
			}
		}
		System.out.println("Enter the title for which you want to update the publisher : ");
		String titlePublisherUpdate=sc.nextLine();
		String newPublisher =sc.nextLine();
		for(Map.Entry<Integer,Books> setv:set)
		{
			if(setv.getValue().title.equals(titlePublisherUpdate))
			{
				setv.getValue().publisher=newPublisher;
				hm.put(setv.getKey(), setv.getValue());
			}
		}
		for(Map.Entry<Integer, Books> setv:set)
		{
			System.out.println(setv.getValue());
		}
	}
}
