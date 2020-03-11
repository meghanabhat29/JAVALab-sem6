package com.student;
import java.util.*;
import java.io.*;
public class MainClass {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String name,usn,type;
		int credits,sem;
		System.out.println("Enter the name,usn,type,credits and semester");
		name=sc.nextLine();
		usn=sc.nextLine();
		type=sc.nextLine();
		credits=sc.nextInt();
		sem=sc.nextInt();
		UG u=new UG(name,usn,type,credits,sem);
		u.display();
	}

}
class UG extends Student{
	int credits,semester;
	UG(String name,String usn,String type,int credits,int semester)
	{
		super(name,usn,type);
		this.credits=credits;
		this.semester=semester;
		
	}
	void display()
	{
		super.display();
		try
		{
			if(type.equals("Regular") || type.equals("COB")) {
				if(credits<200)
				{
					throw new CreditException(credits,type);
				}
			}
			if(type.equals("Diploma"))
			{
				if(credits<100)
				{
					throw new CreditException(credits,type);
				}
			}
					
		}
		catch(CreditException e)
		{
			System.out.println(e);
		}
		
		System.out.println("Credits : "+credits);
		System.out.println("Semester : "+semester);
		
	}
	

}

class PG extends Student{
	int credits,semester;
	PG(int credits,int semester)
	{
		super(name,usn,type);
		this.credits=credits;
		this.semester=semester;
	}
	void display()
	{
		super.display();
		try
		{
		if(type.equals("Regular")|| type.equals("COB"))
		{
			if(credits<200)
			{
				throw new CreditException(credits,type);
			}
		}
		else if(type.equals("Diploma"))
			
		{
			if(credits<100)
			{
				throw new CreditException(credits,type);
			}
		}
		else
		{
			System.out.println("Invalid type");
		}
		}
		catch(CreditException e)
		{
			System.out.println(e);
		}
		
	
	System.out.println("Credits : "+credits);
	System.out.println("Semester : "+semester);
	
	}
}

class CreditException extends Exception {
	
	String val;
	CreditException(int credits,String type)
	{
		val=credits+" "+type;
	}
	public String toString()
	{
		return "Exception : "+val;
	}
}
