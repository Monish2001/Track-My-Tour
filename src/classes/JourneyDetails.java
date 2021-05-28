package classes;

import java.util.Date;;

public class JourneyDetails {
	private String journeyDetailsId;
	private Date startTime;
	private Date reachedTime;
	private String modeOfTransport;
	private String driveMode;
	private String weather;
	private String duration;
	private String journeyType;
	private String tourId;

	public String getJourneyDetailsId() {
		return journeyDetailsId;
	}

	public void setJourneyDetailsId(String journeyDetailsId) {
		this.journeyDetailsId = journeyDetailsId;
	}

	public Date getStartTime() {

		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getReachedTime() {
		return reachedTime;
	}

	public void setReachedTime(Date reachedTime) {
		this.reachedTime = reachedTime;
	}

	public String getModeOfTransport() {
		return modeOfTransport;
	}

	public void setModeOfTransport(String modeOfTransport) {
		this.modeOfTransport = modeOfTransport;
	}

	public String getDriveMode() {
		return driveMode;
	}

	public void setDriveMode(String driveMode) {
		this.driveMode = driveMode;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getJourneyType() {
		return journeyType;
	}

	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
	}

	public String getTourId() {
		return tourId;
	}

	public void setTourId(String tourId) {
		this.tourId = tourId;
	}

}
