/********************************************************************************* *
 * Purpose: POJO class Appointment holding Doctor name, doctor ID, patient Name, patient ID,
 * timeStamp.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 11/06/2018
 *********************************************************************************/
package com.bridgelabz.model;

/**
 * @author Saurav:
 * Class to make Appointment POJO class
 */
public class Appointment {
	private String doctorName;
	private String doctorID;
	private String patientName;
	private String patientID;
	private String timeStamp;
	/**
	 * Method to get the doctor name
	 * @return
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * Method to set the Doctor name
	 * @param doctorName
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * Method to get the doctor name
	 * @return DoctorID
	 */
	public String getDoctorID() {
		return doctorID;
	}
	/**
	 * Method to set the Doctor name
	 * @param doctorID
	 */
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	/**
	 * Method to get the Patient Name
	 * @return Patient Name
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * Method to set the patient Name	
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * Method to get the Patient ID
	 * @return
	 */
	public String getPatientID() {
		return patientID;
	}
	/**
	 * Method to set the patient ID
	 * @param patientID
	 */
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	/**
	 * Method to get the Time Stamp
	 * @return
	 */
	public String getTimeStamp() {
		
		return timeStamp;
	}
	/**
	 * Method to set the TimeStamp
	 * @param timeStamp
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp= timeStamp;
		}
	

}
