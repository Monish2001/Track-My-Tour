package classes;

public class Connection {
	private String connectionId;
	private String personId;
	private String ConnectedToPersonId;
	private String tourId;
	private String behaviour;
	private String intermediateFriends;
	private String notes;
	
	
	public String getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
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
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
