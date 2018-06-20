/********************************************************************************* *
 * Purpose: POJO class Doctor holding Doctor Name, Doctor ID, Doctor Availability,Doctor Specialization and the count of Patient he is having
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 11/06/2018
 *********************************************************************************/
package com.bridgelabz.model;

/**
 * @author Saurav:
 * POJO class of Doctor
 */
public class Doctor {
	private String doctorName;
	private String doctorID;
	private String doctorAvailability;
	private String doctorSpecialisation;
	private int countOfPatient=0;
	/**
	 * Default Constructor
	 */
	public Doctor(){}
	/**
	 * Parametrized Constructor
	 * @param doctorName
	 * @param doctorID
	 * @param doctorSpecialisation
	 * @param doctorAvailability
	 */
	public Doctor(String doctorName,String doctorID,String doctorSpecialisation,String doctorAvailability) {
		this.doctorName=doctorName;
		this.doctorID=doctorID;
		this.doctorSpecialisation=doctorSpecialisation;
		this.doctorAvailability=doctorAvailability;
	}
	
	/**
	 * Method to get the Doctor Name
	 * @return Doctor Name
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * Method to set the Doctor Name
	 * @param doctorName
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * Method to get the Doctor ID
	 * @return
	 */
	public String getDoctorID() {
		return doctorID;
	}
	/**
	 * Method to set the doctor ID
	 * @param doctorID
	 */
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	/**
	 * Method to get Doctor Availability
	 * @return DoctorAvailability
	 */
	public String getDoctorAvailability() {
		return doctorAvailability;
	}
	/**
	 * Method to set the doctor Availability
	 * @param doctorAvailability
	 */
	public void setDoctorAvailability(String doctorAvailability) {
		this.doctorAvailability = doctorAvailability;
	}
	/**
	 * Method getDoctorSpecialization
	 * @return
	 */
	public String getDoctorSpecialisation() {
		return doctorSpecialisation;
	}
	/**
	 * Method setDoctorSpecialization
	 * @param doctorSpecialisation
	 */
	public void setDoctorSpecialisation(String doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}
	/**
	 * Method to get the count of patient
	 * @return
	 */
	public int getCountOfPatient() {
		return countOfPatient;
	}
	/**
	 * Method to set the count of patient
	 * @param countOfPatient
	 */
	public void setCountOfPatient(int countOfPatient) {
		this.countOfPatient = countOfPatient;
	}
	
	
	


}
