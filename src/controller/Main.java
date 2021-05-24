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
					System.out.println("************PLEASE ENTER THE PERSON DETAILS************");
					if (person == null) {
						person = new Person();
					}
					personList.add(person.personDetails());
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;
				case "1":
					if (tour == null) {
						tour = new Tour();
					}
					TourEntity tourData = new TourEntity();

					tourData = tour.tourDetails();

					List<PersonEntity> personlist = new ArrayList<PersonEntity>();
					List<ActivityEntity> activitylist = new ArrayList<ActivityEntity>();
					List<ConnectionEntity> connectionlist = new ArrayList<ConnectionEntity>();
					List<JourneyDetailsEntity> journeylist = new ArrayList<JourneyDetailsEntity>();
					List<ResortEntity> resortlist = new ArrayList<ResortEntity>();
					List<TourEntity> tourlist = new ArrayList<TourEntity>();

					JourneyDetails journeyDetails = new JourneyDetails();
					Resort resortDetails = new Resort();
					Activity tourActivity = new Activity();
					Connection tourConnections = new Connection();
					Person personDate = new Person();

					System.out.println("\n");
					System.out.println("****************PLEASE ENTER THE JOURNEY DETAILS****************");
					System.out.println("How many journey details do you need to add");
					int totalJourneyCount = Integer.parseInt(sc.nextLine());
					int journeyAdded = 0;
					while (journeyAdded < totalJourneyCount) {
						JourneyDetailsEntity journeyData = journeyDetails.journeyDetails();
						journeylist.add(journeyData);
						journeyList.add(journeyData);
						journeyAdded++;
					}
					System.out.println("\n");

					// System.out.println("****************PLEASE ENTER THE RESORT
					// DETAILS****************");
					// System.out.println("How many resort entries do you need to add");
					// int totalResortCount = Integer.parseInt(sc.nextLine());
					// int resortsAdded = 0;
					// while (resortsAdded < totalResortCount) {
					// resortlist.add(resortDetails.resortDetails());
					// resortsAdded++;
					// }
					// System.out.println("\n");

					// System.out.println("****************PLEASE ENTER THE TOUR
					// ACTIVITIES****************");
					// System.out.println("How many activity entries do you need to add");
					// int totalActivitiesCount = Integer.parseInt(sc.nextLine());
					// int activitiesAdded = 0;
					// while (activitiesAdded < totalActivitiesCount) {
					// activitylist.add(tourActivity.activities());
					// activitiesAdded++;
					// }
					// System.out.println("\n");

					// System.out.println("BEFORE ADDING CONNECTIONS PLEASE ENTER THE PERSON DETAILS
					// TO WHOM YOU HAVE CONNECTED");
					// System.out.println("How many person details do you need to add");
					// int totalPersonCount = Integer.parseInt(sc.nextLine());
					// int personsAdded = 0;
					// while (personsAdded < totalPersonCount) {
					// personlist.add(personData.personDetails());
					// personsAdded++;
					// }
					// System.out.println("\n");

					// System.out.println("****************PLEASE ENTER CONNECTIONS MADE IN A
					// TOUR****************");
					// System.out.println("How many connections do you need to add");
					// int totalConnectionsCount = Integer.parseInt(sc.nextLine());
					// int connectionsAdded = 0;
					// while (connectionsAdded < totalConnectionsCount) {
					// connectionlist.add(tourConnections.connections());
					// connectionsAdded++;
					// }
					// System.out.println("\n");

					// tourData.setJourneyDetails(journeylist);

					// tourData.setResort(resortlist);
					// tourData.setActivities(activitylist);
					// tourData.setConnections(connectionlist);

					tourData.setJourneyDetails(journeylist);
					tourList.add(tourData);

					System.out.println("\n");

					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "2":
					if (tourList.size() == 0) {
						System.out.println("There is no tour entries. Please add some tour entry!!");
					} else {
						System.out.println("**********************PRINT ENTRIES*************************");
						for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

							TourEntity tourEntity = tourList.get(tourVariable);
							System.out.println("**********************TOUR DETAILS*************************");
							System.out.println("Person ID: " + tourEntity.getPersonId());
							System.out.println("Tour ID: " + tourEntity.getTourId());
							System.out.println("Tour Origin: " + tourEntity.getOrigin());
							System.out.println("Tour Destination: " + tourEntity.getDestination());
							System.out.println("Tour Start Date: " + tourEntity.getTourStartDate());
							System.out.println("Tour End Date: " + tourEntity.getTourEndDate());
							System.out.println("Type of location: " + tourEntity.getTypeOfLocation());
							System.out.println("**********************************************************");
							System.out.println("\n");

							for (int journey = 0; journey < tourEntity.getJourneyDetails().size(); journey++) {
								System.out.println("**********************JOURNEY DETAILS*************************");
								JourneyDetailsEntity journeyDetailsEntity = tourEntity.getJourneyDetails().get(journey);
								System.out.println("Journey Details ID: " + journeyDetailsEntity.getJourneyDetailsId());
								System.out.println("Tour ID: " + journeyDetailsEntity.getTourId());
								System.out.println("Journey Start Time: " + journeyDetailsEntity.getStartTime());
								System.out.println("Journey Reached Time:" + journeyDetailsEntity.getReachedTime());
								System.out.println("Mode of Transport: " + journeyDetailsEntity.getModeOfTransport());
								System.out.println("Drive Mode: " + journeyDetailsEntity.getDriveMode());
								System.out.println("Weather: " + journeyDetailsEntity.getWeather());
								System.out.println("Duration: " + journeyDetailsEntity.getDuration());
								System.out.println("Journey Type: " + journeyDetailsEntity.getJourneyType());
								System.out.println("**********************************************************");
								System.out.println("\n");
							}

							for (int resort = 0; resort < tourEntity.getResort().size(); resort++) {
								System.out.println("**********************RESORT DETAILS*************************");
								ResortEntity resortEntity = tourEntity.getResort().get(resort);
								System.out.println("Resort ID: " + resortEntity.getResortId());
								System.out.println("Tour ID: " + resortEntity.getTourid());
								System.out.println("Resort From Date: " + resortEntity.getFromDate());
								System.out.println("Resort To Date: " + resortEntity.getToDate());
								System.out.println("Resort Name: " + resortEntity.getResortName());
								System.out.println("Location: " + resortEntity.getResortLocation());
								System.out.println("\n");
								System.out.println("**********************ROOM DETAILS*************************");

								for (int room = 0; room < resortEntity.getRoom().size(); room++) {
									RoomEntity roomEntity = resortEntity.getRoom().get(room);
									System.out.println("Room ID: " + roomEntity.getRoomId());
									System.out.println("Resort ID: " + roomEntity.getResortId());
									// System.out.println("Room From Date: " + roomEntity.getRoomFromDate());
									// System.out.println("Room To Date: " + roomEntity.getRoomToDate());
									System.out.println("Room Type: " + roomEntity.getRoomType());
									System.out.println("Room Cost Per Day: " + roomEntity.getCostPerDay());
									System.out.println("Room No: " + roomEntity.getRoomNo());
									System.out.println("\n");
								}
							}

							for (int activity = 0; activity < tourEntity.getActivities().size(); activity++) {
								System.out.println("**********************ACTIVITIES*************************");
								ActivityEntity activityEntity = tourEntity.getActivities().get(activity);
								System.out.println("Activity ID: " + activityEntity.getActivityId());
								System.out.println("Tour ID: " + activityEntity.getTourid());
								System.out.println("Activity Name: " + activityEntity.getActivityName());
								System.out.println("Activity Start Time: " + activityEntity.getStartTime());
								System.out.println("Activity End Time: " + activityEntity.getEndTime());
								System.out.println("Activity Duration: " + activityEntity.getDuration());
								System.out.println("Activity Cost: " + activityEntity.getCost());
								System.out.println("Location: " + activityEntity.getLocation());
								System.out.println("\n");
							}

							for (int connection = 0; connection < tourEntity.getConnections().size(); connection++) {
								System.out.println("**********************CONNECTIONS*************************");
								ConnectionEntity connectionEntity = tourEntity.getConnections().get(connection);
								System.out.println("Connection ID: " + connectionEntity.getConnectionId());
								System.out.println("Person ID: " + connectionEntity.getPersonId());
								System.out.println(
										"Connected to Person ID: " + connectionEntity.getConnectedToPersonId());
								System.out.println("Tour ID: " + connectionEntity.getTourId());
								System.out.println("Behaviour: " + connectionEntity.getBehaviour());
								System.out
										.println("Intermediate Friends: " + connectionEntity.getIntermediateFriends());
								System.out.println("Notes: " + connectionEntity.getNotes());
								System.out.println("\n");
							}
						}
					}
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					break;

				case "3":
					if (resortList.isEmpty() || activityList.isEmpty()) {
						System.out.println("Entries not found in resort and activities list!!");
					} else {
						System.out.println("Total cost of a single trip");
						System.out.println("\n");
						System.out.println("Refer the tour id listed here");
						mainObj.printTourId(tourList);
						System.out.println("Please enter the tour id:");
						String tourId = sc.nextLine();
						if (tour == null) {
							tour = new Tour();
						}

						int totalCost = 0;
						for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
							if (tourList.isEmpty()) {
								System.out.println("There is no tour entries yet");
								break;
							}

							TourEntity tourEntity = tourList.get(tourVariable);
							if (tourId.equals(tourEntity.getTourId())) {
								for (int resort = 0; resort < tourEntity.getResort().size(); resort++) {
									ResortEntity resortEntity = tourEntity.getResort().get(resort);
									for (int room = 0; room < resortEntity.getRoom().size(); room++) {
										RoomEntity roomEntity = resortEntity.getRoom().get(room);
										totalCost += roomEntity.getTotalCost();
									}
								}
								for (int activities = 0; activities < tourEntity.getActivities().size(); activities++) {
									ActivityEntity activityEntity = tourEntity.getActivities().get(activities);
									totalCost += activityEntity.getCost();
								}
								break;
							}
						}
						System.out.println("Total cost of a single trip: " + totalCost);
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "4":
					if (resortList.isEmpty()) {
						System.out.println("No entries is found in resort list");
					} else {
						System.out.println("Cost for a single trip stay in hotel");
						System.out.println("\n");
						System.out.println("Refer the tour id listed here");
						mainObj.printTourId(tourList);
						System.out.println("Please enter the tour id:");
						String tourIdForTripStay = sc.nextLine();
						if (tour == null) {
							tour = new Tour();
						}
						int costForTripStay = 0;
						for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
							if (tourList.size() == 0) {
								System.out.println("There is no tour entries yet");
								break;
							}

							TourEntity tourEntity = tourList.get(tourVariable);
							if (tourIdForTripStay.equals(tourEntity.getTourId())) {
								for (int resort = 0; resort < tourEntity.getResort().size(); resort++) {
									ResortEntity resortEntity = tourEntity.getResort().get(resort);
									for (int room = 0; room < resortEntity.getRoom().size(); room++) {
										RoomEntity roomEntity = resortEntity.getRoom().get(room);
										costForTripStay += roomEntity.getTotalCost();
									}
								}
								break;
							}
						}
						System.out.println("Total cost for a trip in hotel is: " + costForTripStay);
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "5":
					System.out.println("Trips based on type of location");
					System.out.println("Please enter the type of location");
					String typeOfLocation = sc.nextLine().toLowerCase();

					int tourCountOnLocation = 0;
					for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
						TourEntity tourDetails = tourList.get(tourVariable);
						if (typeOfLocation.equals(tourDetails.getTypeOfLocation())) {
							System.out.println("Tour ID: " + tourDetails.getTourId());
							System.out.println("Person Id: " + tourDetails.getPersonId());
							System.out.println("Origin: " + tourDetails.getOrigin());
							System.out.println("Destination: " + tourDetails.getDestination());
							System.out.println("Tour Start Date: " + tourDetails.getTourStartDate());
							System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
							System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
							tourCountOnLocation++;
							System.out.println("\n\n");
						}
					}
					if (tourCountOnLocation == 0) {
						System.out.println("No trips is based on the type of location given");
					}

					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "6":
					System.out.println("List trips based on transport");
					System.out.println("Please enter the type of transport");
					String modeOfTransport = "car";
					// sc.nextLine().toLowerCase();
					ArrayList<String> tourIdList = new ArrayList<String>();
					if (journeyDetailsData == null) {
						journeyDetailsData = new JourneyDetails();
					}
					/* GETTING THE TOUR ID FROM THE JOURNEYLIST WITH THE GIVEN MODE OF TRANSPORT */
					for (int journey = 0; journey < journeyList.size(); journey++) {
						System.out.println("hello");
						if (journeyList.size() <= 0) {
							System.out.println("No journey detail entry is found!!");
							break;
						}
						JourneyDetailsEntity journeyDetailsEntity = journeyList.get(journey);
						if (modeOfTransport.equals(journeyDetailsEntity.getModeOfTransport())) {
							System.out.println("inside mod");
							System.out.println("mot: " + journeyDetailsEntity.getModeOfTransport());
							tourIdList.add(journeyDetailsEntity.getTourId());
						}
					}
					System.out.println(tourIdList);
					/*
					 * ITERATING THE TOURID LIST AND CHECKING EACH TOURID WITH THE TOURLIST AND
					 * PRINTING THE DETAILS IF IT MATCHES
					 */
					for (int tourid = 0; tourid < tourIdList.size(); tourid++) {
						String tourIdBasedOnTransport = tourIdList.get(tourid);
						for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
							TourEntity tourDetails = tourList.get(tourVariable);
							if (tourIdBasedOnTransport.equals(tourDetails.getTourId())) {
								System.out.println("Tour ID: " + tourDetails.getTourId());
								System.out.println("Person Id: " + tourDetails.getPersonId());
								System.out.println("Origin: " + tourDetails.getOrigin());
								System.out.println("Destination: " + tourDetails.getDestination());
								System.out.println("Tour Start Date: " + tourDetails.getTourStartDate());
								System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
								System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
								System.out.println("\n");
							}
						}
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "7":
					if (connectionList.isEmpty()) {
						System.out.println("Entries not found in connections list");
					} else {
						System.out.println("DIRECT FRIEND IN A TRIP");
						System.out.println("\n");
						System.out.println("Refer the tour id listed here");
						mainObj.printTourId(tourList);
						System.out.println("Please enter the tour id:");
						String tourIdForDirectFriends = sc.nextLine();
						if (tour == null) {
							tour = new Tour();
						}

						for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
							if (tourList.size() == 0) {
								System.out.println("There is no tour entries yet");
								System.out.println("\n");
								System.out.println(
										"If you want to perform any operation again please press no from 0 to 12");
								System.out.println("\n");
								break;
							}
							TourEntity tourEntity = tourList.get(tourVariable);
							if (tourIdForDirectFriends.equals(tourEntity.getTourId())) {
								int friendsCount = 0;
								System.out.println("DIRECT CONNECTIONS MADE IN A TOUR");
								String personId = tourEntity.getConnections().get(0).getPersonId();
								String personName = mainObj.getPersonName(personId, personList);
								System.out.println(personName + "Made direct connections with: ");
								for (int connection = 0; connection < tourEntity.getConnections()
										.size(); connection++) {
									ConnectionEntity connectionVar = tourEntity.getConnections().get(connection);
									if (connectionVar.getIntermediateFriends().equals("0")) {
										String connectedWithPersonId = connectionVar.getConnectedToPersonId();
										String connectedPersonName = mainObj.getPersonName(connectedWithPersonId,
												personList);
										System.out.println("Connected Person Name" + ": " + connectedPersonName);
										friendsCount++;
									}
								}
								if (friendsCount == 0) {
									System.out.println("No direct friends in the trip");
								}
								System.out.println("\n");
								System.out.println(
										"If you want to perform any operation again please press no from 0 to 12");
								System.out.println("\n");
								break;
							}
						}
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "8":
					if (connectionList.isEmpty()) {
						System.out.println("Entries not found in connections list");
					} else {
						System.out.println("FRIENDS OF FRIENDS IN A TRIP");
						System.out.println("\n");
						System.out.println("Refer the tour id listed here");
						mainObj.printTourId(tourList);
						System.out.println("Please enter the tour id:");
						String tourIdForFriendsOfFriends = sc.nextLine();
						if (tour == null) {
							tour = new Tour();
						}
						for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
							if (tourList.size() == 0) {
								System.out.println("There is no tour entries yet");
								System.out.println("\n");
								System.out.println(
										"If you want to perform any operation again please press no from 0 to 12");
								System.out.println("\n");
								break;
							}
							TourEntity tourEntity = tourList.get(tourVariable);
							if (tourIdForFriendsOfFriends.equals(tourEntity.getTourId())) {
								int inDirectFriendsCount = 0;
								System.out.println("INDIRECT CONNECTIONS MADE IN A TOUR");
								String personId = tourEntity.getConnections().get(0).getPersonId();
								String personName = mainObj.getPersonName(personId, personList);
								System.out.println(personName + "Made indirect connections with: ");
								for (int connection = 0; connection < tourEntity.getConnections()
										.size(); connection++) {
									ConnectionEntity connectionVar = tourEntity.getConnections().get(connection);
									if (!connectionVar.getIntermediateFriends().equals("0")) {
										String connectedWithPersonId = connectionVar.getConnectedToPersonId();
										String connectedPersonName = mainObj.getPersonName(connectedWithPersonId,
												personList);
										System.out.println("Connected Person Name" + ": " + connectedPersonName);
										inDirectFriendsCount++;
									}
								}
								if (inDirectFriendsCount == 0) {
									System.out.println("No direct friends in the trip");
								}
								System.out.println("\n");
								System.out.println(
										"If you want to perform any operation again please press no from 0 to 12");
								System.out.println("\n");
								break;
							}
						}
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
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
					for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {
						if (tourList.size() <= 0) {
							System.out.println("No journey detail entry is found!!");
							break;
						}
						TourEntity tourDetails = tourList.get(tourVariable);
						Date tourStartDate = tourDetails.getTourStartDate();
						Date tourEndDate = tourDetails.getTourEndDate();
						if (tourStartDate.compareTo(startDateObj) >= 0 && tourEndDate.compareTo(endDateObj) <= 0) {
							System.out.println("Tour ID: " + tourDetails.getTourId());
							System.out.println("Person Id: " + tourDetails.getPersonId());
							System.out.println("Origin: " + tourDetails.getOrigin());
							System.out.println("Destination: " + tourDetails.getDestination());
							System.out.println("Tour Start Date: " + tourDetails.getTourStartDate());
							System.out.println("Tour End Date: " + tourDetails.getTourEndDate());
							System.out.println("Type of location: " + tourDetails.getTypeOfLocation());
							System.out.println("\n");
							tourCount++;
						}
					}
					if (tourCount == 0) {
						System.out.println("No such tour entries is found between the given date range");
					}
					System.out.println("\n");
					System.out.println("If you want to perform any operation again please press no from 0 to 12");
					System.out.println("\n");
					break;

				case "10":
					System.out.println("ACTIVITIES AND TOTAL ACTIVITIES COST IN A TOUR");
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
		String personName = "None";
		for (int person = 0; person < personList.size(); person++) {
			PersonEntity personVar = personList.get(person);
			if (personId.equals(personVar.getPersonId())) {
				personName = personVar.getName();
				return personName;
			}
		}
		return personName;
	}

	public void printTourId(List<TourEntity> tourList) {
		for (int tourVariable = 0; tourVariable < tourList.size(); tourVariable++) {

			TourEntity tourEntity = tourList.get(tourVariable);
			System.out.println("**********************PLEASE REFER FOR TOUR ID*************************");
			System.out.println("Tour ID: " + tourEntity.getTourId());
			System.out.println("Tour Origin: " + tourEntity.getOrigin());
			System.out.println("Tour Destination: " + tourEntity.getDestination());
			System.out.println("**********************************************************");
			System.out.println("\n");
		}
	}
}
