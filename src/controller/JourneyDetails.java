package controller;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import entities.*;
import utils.*;

public class JourneyDetails {
	Scanner sc = new Scanner(System.in);
	
	public JourneyDetailsEntity journeyDetails() throws ParseException
	{
		JourneyDetailsEntity journeyDetailsData = new JourneyDetailsEntity();
		
		System.out.println("******PLEASE ENTER THE JOURNEY DETAILS**********");
		
		System.out.println("Please Enter the tour id");
		journeyDetailsData.setTourId(sc.nextLine());
		
		UUIDGenerator id = new UUIDGenerator();
		String journeyDetailsId = id.uuid();
		journeyDetailsData.setJourneyDetailsId(journeyDetailsId);
		
		System.out.println("Journey starting time in \"yyyy-MM-dd HH:mm:ss.SSSSSS format:");
		DateFormatter dateObj = new DateFormatter();
		Date journeyStartTime = dateObj.dateFormatter(sc.nextLine());
		journeyDetailsData.setStartTime(journeyStartTime);
		
		System.out.println("Journey reached time in \"yyyy-MM-dd HH:mm:ss.SSSSSS format:");
		Date journeyReachedTime = dateObj.dateFormatter(sc.nextLine());
		journeyDetailsData.setReachedTime(journeyReachedTime);
		
		System.out.println("Mode of transport:");
		journeyDetailsData.setModeOfTransport(sc.nextLine());
		
		System.out.println("Drive Mode:");
		journeyDetailsData.setDriveMode(sc.nextLine());
		
		System.out.println("Weather:");
		journeyDetailsData.setWeather(sc.nextLine());
		
		System.out.println("Duration:");
		journeyDetailsData.setDuration(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Journey Type:");
		journeyDetailsData.setJourneyType(sc.nextLine());
		
		System.out.println("**********************************************************");
		System.out.println("\n");
	
		return journeyDetailsData;
	}
}
