package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Person {
	Scanner sc = new Scanner(System.in);
	
	public PersonEntity personDetails() {
		PersonEntity personData = new PersonEntity();
		List<String> rawNumbers = new ArrayList<String>();
		
		System.out.println("******PLEASE ENTER THE PERSON DETAILS**********");
		
		UUIDGenerator id = new UUIDGenerator();
		String personId = id.uuid();
		personData.setPersonId(personId);
		
		System.out.println("Name:");
		personData.setName(sc.nextLine());
		
		System.out.println("Age:");
		personData.setAge(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Passion:");
		personData.setPassion(sc.nextLine());
		
	
		System.out.println("Occupation:");
		personData.setOccupation(sc.nextLine());
		
		
		System.out.println("How many phone numbers do you need to ad");
		int count = Integer.parseInt(sc.nextLine());
		int index = 0;
		
		
		while(index<count)
		{
			rawNumbers.add(sc.nextLine());
			index++;
		}
		
		personData.setPhoneNum(rawNumbers);
		
		System.out.println("For your information Person id is: "+ personId);
		return personData;
	}
}