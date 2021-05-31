package classes;

public class Connection {
	private String connectionId;
	private String connectionCode;
	private String personId;
	private String ConnectedToPersonId;
	private String tourId;
	private String tourCode;
	private String behaviour;
	private String intermediateFriends;
	private String intermediateFriendsCode;
	private String notes;

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getConnectionCode() {
		return this.connectionCode;
	}

	public void setConnectionCode(String connectionCode) {
		this.connectionCode = connectionCode;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getConnectedToPersonId() {
		return ConnectedToPersonId;
	}

	public void setConnectedToPersonId(String connectedToPersonId) {
		ConnectedToPersonId = connectedToPersonId;
	}

	public String getTourId() {
		return tourId;
	}

	public void setTourId(String tourId) {
		this.tourId = tourId;
	}

	public String getTourCode() {
		return this.tourCode;
	}

	public void setTourCode(String tourCode) {
		this.tourCode = tourCode;
	}

	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public String getIntermediateFriends() {
		return intermediateFriends;
	}

	public void setIntermediateFriends(String intermediateFriends) {
		this.intermediateFriends = intermediateFriends;
	}

	public String getIntermediateFriendsCode() {
		return this.intermediateFriendsCode;
	}

	public void setIntermediateFriendsCode(String intermediateFriendsCode) {
		this.intermediateFriendsCode = intermediateFriendsCode;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
