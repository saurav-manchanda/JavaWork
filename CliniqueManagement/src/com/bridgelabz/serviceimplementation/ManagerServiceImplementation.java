/********************************************************************************* *
 * Purpose: Implementing all the Manager Services 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 11/06/2018
 *********************************************************************************/
package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.utility.ClinicUtility;

/**
 * @author Saurav:
 * Class to implement Manager Services
 */
public class ManagerServiceImplementation {
	ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	ArrayList<Patient> patientList=new ArrayList<>();
	ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	ObjectMapper mapper=new ObjectMapper();
	File doctorFileLoc = new File("/home/bridgelabz/JavaWorkspace/CliniqueManagement/src/com/bridgelabz/files/Doctors.json");
	File patientFileLoc=new File("/home/bridgelabz/JavaWorkspace/CliniqueManagement/src/com/bridgelabz/files/Patients.json");
	File appointmentFile =new File("/home/bridgelabz/JavaWorkspace/CliniqueManagement/src/com/bridgelabz/files/Appointment.json");
	ArrayList<Doctor> foundDoctorList = new ArrayList<Doctor>();
	ArrayList<Patient> foundPatientList = new ArrayList<Patient>();
	
	
	
	/**Method to add doctor to the list
	 * @param doctorName
	 * @param doctorID
	 * @param doctorSpecialisation
	 * @param doctorAvailability
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void addDoctor(String doctorName,String doctorID,String doctorSpecialisation,String doctorAvailability) throws JsonMappingException, IOException {
		doctorList = ClinicUtility.parseJSONArray(doctorFileLoc, Doctor.class);
		Doctor doctor=new Doctor( doctorName, doctorID, doctorSpecialisation, doctorAvailability);
		doctorList.add(doctor);
		for(int i=0 ;i<doctorList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((doctorList.get(i))));
		}
		mapper.writeValue((doctorFileLoc), doctorList);
		System.out.println("Doctor added successfully!!");
		}
	
	

	
	/**Method to add patient
	 * @param patientName
	 * @param patientID
	 * @param patientMobNumber
	 * @param patientAge
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void addPatient(String patientName,String patientID,String patientMobNumber,int patientAge) throws JsonParseException, JsonMappingException, IOException {
		patientList = ClinicUtility.parseJSONArray(patientFileLoc, Patient.class);
		Patient patient=new Patient(patientName,patientID,patientMobNumber, patientAge);
	
		patientList.add(patient);
		for(int i=0 ;i<patientList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((patientList.get(i))));
		}
		
		mapper.writeValue((patientFileLoc), patientList);
		System.out.println("Patient added successfully!!");
	}
	
	
	
	
	/**Method to update doctor's availability time
	 * @param doctorID
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void updateAvailTime(String doctorID) throws JsonParseException, JsonMappingException, IOException {
		
		foundDoctorList=searchDoctorID(doctorID);
		if(foundDoctorList==null) {
			System.out.println("Please visit again!!");
		}
			System.out.println("Enter new availiability time: ");
			String newAvailTime=ClinicUtility.userInputString() ;
			for(int i = 0; i < foundDoctorList.size(); i++) {
				foundDoctorList.get(i).setDoctorAvailability(newAvailTime);
				}
			
			System.out.println("Successfully updated!!");
			mapper.writeValue(( doctorFileLoc),doctorList);
			}
	
 
 
 /**
 * @param doctorID
 * @throws JsonParseException
 * @throws JsonMappingException
 * @throws IOException
 */
public void updateSpecialisation(String doctorID) throws JsonParseException, JsonMappingException, IOException {
	 foundDoctorList=searchDoctorID(doctorID);
	 if(foundDoctorList==null) {
			System.out.println("Please visit again!!");
		}
			System.out.println("Enter new specialisation: ");
			String newSpecialisation=ClinicUtility.userInputString() ;
			for(int i = 0; i < foundDoctorList.size(); i++) {
				foundDoctorList.get(i).setDoctorSpecialisation(newSpecialisation);
				}
			System.out.println("Successfully updated!!");
			mapper.writeValue(( doctorFileLoc),doctorList);
			} 
	 

 
 /**
 * @param doctorID
 * @throws JsonParseException
 * @throws JsonMappingException
 * @throws IOException
 */
public void deleteDoctor(String doctorID) throws JsonParseException, JsonMappingException, IOException {
	 

	 foundDoctorList=searchDoctorID(doctorID);
	 if(foundDoctorList==null) {
			System.out.println("Please visit again!!");
		}
	System.out.println("Successfully deleted!!");
			mapper.writeValue(( doctorFileLoc), doctorList);
			} 
		
	
 
 
 
 /**
 * @param doctorID
 * @return
 * @throws JsonParseException
 * @throws JsonMappingException
 * @throws IOException
 */
public ArrayList<Doctor> searchDoctorID(String doctorID) throws JsonParseException, JsonMappingException, IOException {
	 doctorList = ClinicUtility.parseJSONArray( doctorFileLoc, Doctor.class);
	 boolean found=false;
		for(int i=0 ; i<doctorList.size();i++) {
			if(doctorList.get(i).getDoctorID().equals(doctorID)) {
				foundDoctorList.add(doctorList.get(i));
				found=true;
			}
		}
		if(found) {
			return foundDoctorList;
		}
		
		else {
			System.out.println("Sorry!! The doctor you are searching for is not found in our record!!");
				}
		return null;
		
 }


	/**
	 * @param patientName
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void updatePatientAge(String patientName) throws JsonParseException, JsonMappingException, IOException {
		patientList = ClinicUtility.parseJSONArray(patientFileLoc, Patient.class);

		boolean found = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().equals(patientName)) {
				 foundPatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			System.out.println("Enter patient's new age: ");
			int patientNewAge = ClinicUtility.userInputInteger();
			for (int i = 0; i <  foundPatientList.size(); i++) {
				 foundPatientList.get(i).setPatientAge(patientNewAge);
			}
			System.out.println("Successfully updated!!");
			mapper.writeValue((patientFileLoc), patientList);
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	/**
	 * @param patientName
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void updatePatientMobNumber(String patientName)
			throws JsonParseException, JsonMappingException, IOException {
		patientList = ClinicUtility.parseJSONArray(patientFileLoc, Patient.class);

		boolean found = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().equals(patientName)) {
				 foundPatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			System.out.println("Enter patient's new mobile number: ");
			String patientNewMobNumber = ClinicUtility.userInputString();
			for (int i = 0; i < foundPatientList.size(); i++) {
				 foundPatientList.get(i).setPatientMobNumber(patientNewMobNumber);
			}
			System.out.println("Successfully updated!!");
			mapper.writeValue((patientFileLoc), patientList);
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	
	
	/**
	 * @param patientID
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void deletePatient(String patientID) throws JsonParseException, JsonMappingException, IOException {
		patientList = ClinicUtility.parseJSONArray(patientFileLoc, Patient.class);

		boolean found = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientID().equals(patientID)) {
				patientList.remove(i);
				found = true;
			}
		}

		if (found) {
			System.out.println("Successfully deleted!!");
			mapper.writeValue((patientFileLoc), patientList);
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}
	}

	/**Method to print doctor patient report
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void printReport() throws JsonParseException, JsonMappingException, IOException {
		appointmentList=ClinicUtility.parseJSONArray(appointmentFile, Appointment.class);
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(appointmentList));
	}
	

}
