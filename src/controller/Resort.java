package controller;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Resort {
	Scanner sc = new Scanner(System.in);
	
	
	public ResortEntity resortDetails() throws ParseException
	{
		
		ResortEntity resortData = new ResortEntity();
		Room room = new Room();
		List<RoomEntity> roomList = new ArrayList<RoomEntity>();
		
		System.out.println("******PLEASE ENTER THE RESORT DETAILS**********");
		
		System.out.println("Please Enter the tour id");
		resortData.setTourid(sc.nextLine());
		
		UUIDGenerator id = new UUIDGenerator();
		String resortId = id.uuid();
		resortData.setResortId(resortId);
		
		System.out.println("Resort fromDate in \"yyyy-MM-dd HH:mm:ss format:");
		DateFormatter dateObj = new DateFormatter();
		Date resortFromDate = dateObj.dateFormatter(sc.nextLine());
		resortData.setFromDate(resortFromDate);
		
		System.out.println("Resort toDate in \"yyyy-MM-dd HH:mm:ss format:");
		Date resortToDate = dateObj.dateFormatter(sc.nextLine());
		resortData.setToDate(resortToDate);
		
		System.out.println("Resort Name:");
		resortData.setResortName(sc.nextLine());
		
		System.out.println("Location:");
		resortData.setResortLocation(sc.nextLine());
		
		System.out.println("\n");
		System.out.println("Your resort id is: "+ resortData.getResortId());
		System.out.println("\n");
		
		System.out.println("*****************PLEASE ENTER ROOM DETAILS***************");
		System.out.println("How many rooms do you need to add");
		int count = Integer.parseInt(sc.nextLine());
		int index = 0;
		while(index<count)
		{
			roomList.add(room.roomDetails());
			index++;
		}	
		resortData.setRoom(roomList);
		System.out.println("****************************************************");
		System.out.println("\n");
		return resortData;
		
	
	
	}
	
}
