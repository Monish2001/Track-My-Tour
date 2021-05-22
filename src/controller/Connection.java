package controller;
import java.text.ParseException;
import java.util.Scanner;

import entities.*;
import utils.*;

public class Connection {
	Scanner sc = new Scanner(System.in);
	
	public ConnectionEntity connections() throws ParseException
	{
		ConnectionEntity connection = new ConnectionEntity();
		
		System.out.println("******PLEASE ENTER THE CONNECTIONS**********");
		
		System.out.println("Please Enter the tour id");
		connection.setTourId(sc.nextLine());
		
		UUIDGenerator id = new UUIDGenerator();
		String connectionId = id.uuid();
		connection.setConnectionId(connectionId);
		
		System.out.println("Person id:");
		connection.setPersonId(sc.nextLine());
		
		System.out.println("Connected to person id:");
		connection.setConnectedToPersonId(sc.nextLine());
		
		
		System.out.println("Behaviour:");
		connection.setBehaviour(sc.nextLine());
		
		System.out.println("Notes:");
		connection.setNotes(sc.nextLine());
		
		System.out.println("Intermediate friends");
		connection.setIntermediateFriends(sc.nextLine());
		
		return connection;
		
	}
}
