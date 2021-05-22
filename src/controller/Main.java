package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.*;
import utils.DateFormatter;

public class Main {
	public static void main(String[] args) throws ParseException {
		System.out.println("****************************OPERATIONS PERFORMED*****************************************");
		System.out.println(
				"1.Add a trip entry\n 2.List the trip entries\n 3.Total cost of single trip\n 4.Cost for trip stay in hotel\n 5.List trips based on type of location\n 6.List trips based on transport\n 7.List direct friend in a trip\n 8.List friends of friends in a trip\n 9.List the trip with given date range\n 10.List the activities and total activities cost in a trip");
		System.out.println("If you want to close the please type as 'exit'");
		System.out.println("Before adding tour details please enter the person details to know your ID");
		System.out.println("*****************************************************************************************");

		List<PersonEntity> personList = new ArrayList<PersonEntity>();
		List<ActivityEntity> activityList = new ArrayList<ActivityEntity>();
		List<ConnectionEntity> connectionList = new ArrayList<ConnectionEntity>();
		List<JourneyDetailsEntity> journeyList = new ArrayList<JourneyDetailsEntity>();
		List<ResortEntity> resortList = new ArrayList<ResortEntity>();
		List<TourEntity> tourList = new ArrayList<TourEntity>();

		Scanner sc = new Scanner(System.in);
		String operation;
		int condition = 1;

		Main mainObj = new Main();
		Person person = null;
		JourneyDetails journeyDetailsData = null;
		Resort resortDetailsData = null;
		Activity tourActivities = null;
		Connection connectionsMade = null;

		Tour tour = null;

		while (condition == 1) {
			operation = sc.nextLine();
			switch (operation) {
				case "0":
					System.out.println("Add Person");
					if (person == null) {
						person = new Person();
					}
					personList.add(person.personDetails());
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n\n\n");
					break;
				case "1":
					System.out.println("**********************ADD TOUR*************************");
					if (tour == null) {
						tour = new Tour();
					}
					tourList.add(tour.tourDetails());
					System.out.println("\n\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "2":
					System.out.println("**********************PRINT ENTRIES*************************");
					for (int i = 0; i < tourList.size(); i++) {

						TourEntity tourVar = tourList.get(i);
						System.out.println("**********************TOUR DETAILS*************************");
						System.out.println("Person ID: " + tourVar.getPersonId());
						System.out.println("Tour ID: " + tourVar.getTourId());
						System.out.println("Tour Origin: " + tourVar.getOrigin());
						System.out.println("Tour Destination: " + tourVar.getDestination());
						System.out.println("Tour Start Date: " + tourVar.getTourStartDate());
						System.out.println("Tour End Date: " + tourVar.getTourEndDate());
						System.out.println("Type of location: " + tourVar.getTypeOfLocation());
						System.out.println("**********************************************************");
						System.out.println("\n\n\n");

						for (int j = 0; j < tourVar.getJourneyDetails().size(); j++) {
							System.out.println("**********************JOURNEY DETAILS*************************");
							JourneyDetailsEntity journeyDetailsVar = tourVar.getJourneyDetails().get(j);
							System.out.println("Journey Details ID: " + journeyDetailsVar.getJourneyDetailsId());
							System.out.println("Tour ID: " + journeyDetailsVar.getTourId());
							System.out.println("Journey Start Time: " + journeyDetailsVar.getStartTime());
							System.out.println("Journey Reached Time:" + journeyDetailsVar.getReachedTime());
							System.out.println("Mode of Transport: " + journeyDetailsVar.getModeOfTransport());
							System.out.println("Drive Mode: " + journeyDetailsVar.getDriveMode());
							System.out.println("Weather: " + journeyDetailsVar.getWeather());
							System.out.println("Duration: " + journeyDetailsVar.getDuration());
							System.out.println("Journey Type: " + journeyDetailsVar.getJourneyType());
							System.out.println("**********************************************************");
							System.out.println("\n\n\n");
						}

						for (int resort = 0; resort < tourVar.getResort().size(); resort++) {
							System.out.println("**********************RESORT DETAILS*************************");
							ResortEntity resortVar = tourVar.getResort().get(resort);
							System.out.println("Resort ID: " + resortVar.getResortId());
							System.out.println("Tour ID: " + resortVar.getTourid());
							System.out.println("Resort From Date: " + resortVar.getFromDate());
							System.out.println("Resort To Date: " + resortVar.getToDate());
							System.out.println("Resort Name: " + resortVar.getResortName());
							System.out.println("Location: " + resortVar.getResortLocation());
							System.out.println("\n\n");
							System.out.println("**********************ROOM DETAILS*************************");

							for (int room = 0; room < resortVar.getRoom().size(); room++) {
								RoomEntity roomVar = resortVar.getRoom().get(room);
								System.out.println("Room ID: " + roomVar.getRoomId());
								System.out.println("Resort ID: " + roomVar.getResortId());
								System.out.println("Room From Date: " + roomVar.getRoomFromDate());
								System.out.println("Room To Date: " + roomVar.getRoomToDate());
								System.out.println("Room Type: " + roomVar.getRoomType());
								System.out.println("Room Cost Per Day: " + roomVar.getCostPerDay());
								System.out.println("Room No: " + roomVar.getRoomNo());
								System.out.println("\n\n\n");
							}
						}

						for (int activity = 0; activity < tourVar.getActivities().size(); activity++) {
							System.out.println("**********************ACTIVITIES*************************");
							ActivityEntity activitiesVar = tourVar.getActivities().get(activity);
							System.out.println("Activity ID: " + activitiesVar.getActivityId());
							System.out.println("Tour ID: " + activitiesVar.getTourid());
							System.out.println("Activity Name: " + activitiesVar.getActivityName());
							System.out.println("Activity Start Time: " + activitiesVar.getStartTime());
							System.out.println("Activity End Time: " + activitiesVar.getEndTime());
							System.out.println("Activity Duration: " + activitiesVar.getDuration());
							System.out.println("Activity Cost: " + activitiesVar.getCost());
							System.out.println("Location: " + activitiesVar.getLocation());
							System.out.println("\n\n\n");
						}

						for (int connection = 0; connection < tourVar.getConnections().size(); connection++) {
							System.out.println("**********************CONNECTIONS*************************");
							ConnectionEntity connectionsVar = tourVar.getConnections().get(connection);
							System.out.println("Connection ID: " + connectionsVar.getConnectionId());
							System.out.println("Person ID: " + connectionsVar.getPersonId());
							System.out.println("Connected to Person ID: " + connectionsVar.getConnectedToPersonId());
							System.out.println("Tour ID: " + connectionsVar.getTourId());
							System.out.println("Behaviour: " + connectionsVar.getBehaviour());
							System.out.println("Intermediate Friends: " + connectionsVar.getIntermediateFriends());
							System.out.println("Notes: " + connectionsVar.getNotes());
							System.out.println("\n\n\n");
						}
					}
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "3":
					System.out.println("Total cost of a single trip");
					System.out.println("Please enter the tour id:");
					String tourId = sc.nextLine();
					if (tour == null) {
						tour = new Tour();
					}
					int cost = 0;
					for (int tourVar = 0; tourVar < tourList.size(); tourVar++) {
						if (tourList.size() == 0) {
							System.out.println("There is no tour entries yet");
							break;
						}

						TourEntity tourIdVar = tourList.get(tourVar);
						if (tourId.equals(tourIdVar.getTourId())) {
							for (int resort = 0; resort < tourIdVar.getResort().size(); resort++) {
								ResortEntity resortVar = tourIdVar.getResort().get(resort);
								for (int room = 0; room < resortVar.getRoom().size(); room++) {
									RoomEntity roomVar = resortVar.getRoom().get(room);
									cost += roomVar.getTotalCost();
								}
							}
							for (int activities = 0; activities < tourIdVar.getActivities().size(); activities++) {
								ActivityEntity activityVar = tourIdVar.getActivities().get(activities);
								cost += activityVar.getCost();
							}
							break;
						}
					}
					System.out.println("Total cost of a single trip: " + cost);
					System.out.println("\n\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n\n\n");
					break;

				case "4":
					System.out.println("Cost for a single trip stay in hotel");
					System.out.println("Please enter the tour id:");
					String tourIdForTripStay = sc.nextLine();
					if (tour == null) {
						tour = new Tour();
					}
					int costForTripStay = 0;
					for (int tourVar = 0; tourVar < tourList.size(); tourVar++) {
						if (tourList.size() == 0) {
							System.out.println("There is no tour entries yet");
							break;
						}

						TourEntity tourIdVar = tourList.get(tourVar);
						if (tourIdForTripStay.equals(tourIdVar.getTourId())) {
							for (int resort = 0; resort < tourIdVar.getResort().size(); resort++) {
								ResortEntity resortVar = tourIdVar.getResort().get(resort);
								for (int room = 0; room < resortVar.getRoom().size(); room++) {
									RoomEntity roomVar = resortVar.getRoom().get(room);
									costForTripStay += roomVar.getTotalCost();
								}
							}
							break;
						}
					}
					System.out.println("Total cost for a trip in hotel is: " + costForTripStay);
					System.out.println("\n\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n\n\n");
					break;

				case "5":
					System.out.println("Trips based on type of location");
					System.out.println("Please enter the type of location");
					String typeOfLocation = sc.nextLine();

					int tourCountOnLocation = 0;
					for (int tourVar = 0; tourVar < tourList.size(); tourVar++) {
						TourEntity tourDetails = tourList.get(tourVar);
						if (typeOfLocation.equals(tourDetails.getTypeOfLocation())) {
							System.out.println("Tour ID: " + tourDetails.getTourId());
							System.out.println("Person Id: " + tourDetails.getPersonId());
							System.out.println("Origin: " + tourDetails.getOrigin());
							System.out.println("Destination: " + tourDetails.getDestination());
							System.out.println("Tour Start Date: " + tourDetails.getTourEndDate());
							System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
							System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
							tourCountOnLocation++;
							System.out.println("\n\n");
						}
					}
					if (tourCountOnLocation == 0) {
						System.out.println("No trips is based on the type of location given");
					}

					System.out.println("\n\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n\n\n");
					break;

				case "6":
					System.out.println("List trips based on transport");
					System.out.println("Please enter the type of transport");
					String modeOfTransport = sc.nextLine();
					List<String> tourIdList = new ArrayList<String>();
					if (journeyDetailsData == null) {
						journeyDetailsData = new JourneyDetails();
					}
					/* GETTING THE TOUR ID FROM THE JOURNEYLIST WITH THE GIVEN MODE OF TRANSPORT */
					for (int journey = 0; journey < journeyList.size(); journey++) {
						if (journeyList.size() <= 0) {
							System.out.println("No journey detail entry is found!!");
							break;
						}
						JourneyDetailsEntity journeyDetailsVar = journeyList.get(journey);
						if (modeOfTransport.equals(journeyDetailsVar.getModeOfTransport())) {
							tourIdList.add(journeyDetailsVar.getTourId());
						}
					}
					/*
					 * ITERATING THE TOURID LIST AND CHECKING EACH TOURID WITH THE TOURLIST AND
					 * PRINTING THE DETAILS IF IT MATCHES
					 */
					for (int tourid = 0; tourid < tourIdList.size(); tourid++) {
						String tourIdBasedOnTransport = tourIdList.get(tourid);
						for (int tourVar = 0; tourVar < tourList.size(); tourVar++) {
							TourEntity tourDetails = tourList.get(tourVar);
							if (tourIdBasedOnTransport.equals(tourDetails.getTourId())) {
								System.out.println("Tour ID: " + tourDetails.getTourId());
								System.out.println("Person Id: " + tourDetails.getPersonId());
								System.out.println("Origin: " + tourDetails.getOrigin());
								System.out.println("Destination: " + tourDetails.getDestination());
								System.out.println("Tour Start Date: " + tourDetails.getTourEndDate());
								System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
								System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
								System.out.println("\n\n");
							}
						}
					}
					System.out.println("\n\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n\n\n");
					break;

				case "7":
					System.out.println("DIRECT FRIEND IN A TRIP");
					System.out.println("Please enter the tour id:");
					String tourIdForDirectFriends = sc.nextLine();
					if (tour == null) {
						tour = new Tour();
					}

					for (int tourVar = 0; tourVar < tourList.size(); tourVar++) {
						if (tourList.size() == 0) {
							System.out.println("There is no tour entries yet");
							System.out.println("\n\n");
							System.out
									.println("If you want to perform any operation again please press no from 0 to 12");
							System.out.println("\n\n\n");
							break;
						}
						TourEntity tourIdVar = tourList.get(tourVar);
						if (tourIdForDirectFriends.equals(tourIdVar.getTourId())) {
							int friendsCount = 0;
							System.out.println("DIRECT CONNECTIONS MADE IN A TOUR");
							String personId = tourIdVar.getConnections().get(0).getPersonId();
							String personName = mainObj.getPersonName(personId, personList);
							System.out.println(personName + "Made direct connections with: ");
							for (int connection = 0; connection < tourIdVar.getConnections().size(); connection++) {
								ConnectionEntity connectionVar = tourIdVar.getConnections().get(connection);
								if (connectionVar.getIntermediateFriends().equals("0")) {
									String connectedWithPersonId = connectionVar.getConnectedToPersonId();
									String connectedPersonName = mainObj.getPersonName(connectedWithPersonId,
											personList);
									System.out.println("Connection NO" + connection + 1 + ": " + connectedPersonName);
									friendsCount++;
								}
							}
							if (friendsCount == 0) {
								System.out.println("No direct friends in the trip");
							}
							System.out.println("\n\n");
							System.out
									.println("If you want to perform any operation again please press no from 0 to 12");
							System.out.println("\n\n\n");
							break;
						}
					}
					System.out.println("\n\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n\n\n");
					break;

				case "8":
					System.out.println("FRIENDS OF FRIENDS IN A TRIP");
					System.out.println("Please enter the tour id:");
					String tourIdForFriendsOfFriends = sc.nextLine();
					if (tour == null) {
						tour = new Tour();
					}
					for (int tourVar = 0; tourVar < tourList.size(); tourVar++) {
						if (tourList.size() == 0) {
							System.out.println("There is no tour entries yet");
							System.out.println("\n\n");
							System.out
									.println("If you want to perform any operation again please press no from 0 to 12");
							System.out.println("\n\n\n");
							break;
						}
						TourEntity tourIdVar = tourList.get(tourVar);
						if (tourIdForFriendsOfFriends.equals(tourIdVar.getTourId())) {
							int inDirectFriendsCount = 0;
							System.out.println("INDIRECT CONNECTIONS MADE IN A TOUR");
							String personId = tourIdVar.getConnections().get(0).getPersonId();
							String personName = mainObj.getPersonName(personId, personList);
							System.out.println(personName + "Made indirect connections with: ");
							for (int connection = 0; connection < tourIdVar.getConnections().size(); connection++) {
								ConnectionEntity connectionVar = tourIdVar.getConnections().get(connection);
								if (!connectionVar.getIntermediateFriends().equals("0")) {
									String connectedWithPersonId = connectionVar.getConnectedToPersonId();
									String connectedPersonName = mainObj.getPersonName(connectedWithPersonId,
											personList);
									System.out.println("Connection NO" + connection + 1 + ": " + connectedPersonName);
									inDirectFriendsCount++;
								}
							}
							if (inDirectFriendsCount == 0) {
								System.out.println("No direct friends in the trip");
							}
							System.out.println("\n\n");
							System.out
									.println("If you want to perform any operation again please press no from 0 to 12");
							System.out.println("\n\n\n");
							break;
						}
					}
					System.out.println("\n\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n\n\n");
					break;

				case "9":
					System.out.println("TRIPS WITH THE GIVEN DATE RANGE");
					System.out.println("Please enter the date range");
					System.out.println("Start Date---Please enter in this pattern yyyy-MM-dd HH:mm:ss format:");
					String startDate = sc.nextLine();
					System.out.println("End date---Please enter in this pattern yyyy-MM-dd HH:mm:ss format:");
					String endDate = sc.nextLine();

					DateFormatter dateObj = new DateFormatter();
					Date startDateObj = dateObj.dateFormatter(startDate);
					Date endDateObj = dateObj.dateFormatter(endDate);

					if (tour == null) {
						tour = new Tour();
					}
					int tourCount = 0;
					for (int tourVar = 0; tourVar < tourList.size(); tourVar++) {
						if (tourList.size() <= 0) {
							System.out.println("No journey detail entry is found!!");
							break;
						}
						TourEntity tourDetails = tourList.get(tourVar);
						Date tourStartDate = tourDetails.getTourStartDate();
						Date tourEndDate = tourDetails.getTourEndDate();
						if (tourStartDate.compareTo(startDateObj) >= 0 && tourEndDate.compareTo(endDateObj) <= 0) {
							System.out.println("Tour ID: " + tourDetails.getTourId());
							System.out.println("Person Id: " + tourDetails.getPersonId());
							System.out.println("Origin: " + tourDetails.getOrigin());
							System.out.println("Destination: " + tourDetails.getDestination());
							System.out.println("Tour Start Date: " + tourDetails.getTourEndDate());
							System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
							System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
							System.out.println("\n\n");
							tourCount++;
						}
					}
					if (tourCount == 0) {
						System.out.println("No such tour entries is found between the given date range");
					}
					System.out.println("\n\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n\n\n");
					break;

				case "10":
					System.out.println("ACTIVITIES AND TOTAL ACTIVITIES COST IN A TOUR");
					break;

				case "13":
					System.out.println("Add Resort Details");
					if (resortDetailsData == null) {
						resortDetailsData = new Resort();
					}
					resortList.add(resortDetailsData.resortDetails());
					for (int i = 0; i < resortList.size(); i++) {
						ResortEntity resortVar = resortList.get(i);
						System.out.println("name: " + resortVar.getResortName());

						for (int j = 0; j < resortVar.getRoom().size(); j++) {
							RoomEntity roomVar = resortVar.getRoom().get(j);
							// System.out.println("roomId: " + roomVar.getRoomId());
							// System.out.println("room type: " + roomVar.getRoomType());
							System.out.println("Room ID: " + roomVar.getRoomId());
							System.out.println("Resort ID: " + roomVar.getResortId());
							System.out.println("Room From Date: " + roomVar.getRoomFromDate());
							System.out.println("Room To Date: " + roomVar.getRoomToDate());
							System.out.println("Room Type: " + roomVar.getRoomType());
							System.out.println("Room Cost Per Day: " + roomVar.getCostPerDay());
							System.out.println("No of night: " + roomVar.getNoOfNights());
							System.out.println("Total cost: " + roomVar.getTotalCost());
							System.out.println("Room No: " + roomVar.getRoomNo());
						}
					}
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;
				case "exit":
					condition = 0;
					break;
				default:
					System.out.println("Please enter a valid input from 0 to 12");
					break;
			}
		}
	}

	public String getPersonName(String personId, List<PersonEntity> personList) {
		String personName;
		for (int person = 0; person < personList.size(); person++) {
			PersonEntity personVar = personList.get(person);
			if (personId.equals(personVar.getPersonId())) {
				personName = personVar.getName();
			}
		}
		return personName;
	}
}
