package MyDate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;
public class MyDate {
	private int day;
	private int month;
	private int year;
	private Scanner keyboard;
	
	public MyDate(){
		 this.getCurDate();
	}
	
	// Kiem tra ngay thang
	boolean legalDate(int d, int m, int y)
	{
		if(m<1||m>12||d<1||d>31) return false;
		else
		switch(m)
		{
		case 4:
		case 6:
		case 9:
		case 11:
			if(d>30) return false;
			break;
		case 2:
			if(y%400==0 && d>29) 
				return false;
			else if(y%100==0 && d>28) 
				return false;
			else if(y%4==0 && d>29) 
				return false;
			else if(d>28) 
				return false;
			break;
		}
		return true;
	}
	
	void getCurDate()
	{
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		year  = localDate.getYear();
		month = localDate.getMonthValue();
		day   = localDate.getDayOfMonth();
	}
	public void acceptDate()
	{
		keyboard = new Scanner(System.in);
		
		System.out.print("Ngay: ");
		day = keyboard.nextInt();
		System.out.print("Thang: ");
		month = keyboard.nextInt();
		System.out.print("Nam: ");
		year = keyboard.nextInt();
		
		if(legalDate(day,month,year)==false)
		{
			System.out.println("Loi: ngay thang khong hop le.");
			this.getCurDate();
		}
	}
	
	void newDate(int d, int m, int y) {
		year = y;
		month = m;
		day = d;
		if(legalDate(day,month,year)==false)
		{
			System.out.println("Loi: ngay thang khong hop le.");
			this.getCurDate();
		}
	}
	
	
	
	public String printDate()
	{
		String strDate = "";
	
		String strMonth = Integer.toString(month);
		String strDay = Integer.toString(day);
		String strYear = Integer.toString(year);
		strDate+="Ngay " + strDay +" Thang " + strMonth+ " Nam " + strYear;
		
		System.out.println(strDate);
		return null;	
	}
	
	
	
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

}
