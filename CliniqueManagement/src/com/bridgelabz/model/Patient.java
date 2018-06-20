/********************************************************************************* *
 * Purpose: POJO class Patient having Patient Name, Patient ID, Patient Mobile Number, patientAge
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 11/06/2018
 *********************************************************************************/
package com.bridgelabz.model;

/**
 * @author Saurav:
 * POJO class Patient
 */
public class Patient {
	private String patientName;
	private String patientID;
	private String patientMobNumber;
	private int patientAge;
	
	
	public Patient() {}
	
	public Patient(String patientName, String patientID,String patientMobNumber,int patientAge ) {
		 this.patientName= patientName;
	     this.patientID= patientID;
	     this.patientMobNumber=patientMobNumber;
	     this.patientAge=patientAge;
	}
	
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getPatientMobNumber() {
		return patientMobNumber;
	}

	public void setPatientMobNumber(String patientMobNumber) {
		this.patientMobNumber = patientMobNumber;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	/*Patient(String patientName, int patientAge,int patientID, String patientMobNumber)
    {
        this.patientName= patientName;
        this.patientID= patientID;
        this.patientAge=patientAge;
        this.patientMobNumber=patientMobNumber;
    }   */

 
    public String toString()
    {
        return (patientMobNumber+" "+patientName+""+patientAge+""+patientMobNumber );
    }

	
}
