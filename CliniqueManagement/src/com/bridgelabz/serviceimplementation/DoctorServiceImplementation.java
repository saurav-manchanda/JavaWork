/********************************************************************************* *
 * Purpose: Implementation of all Doctor Services
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 11/06/2018
 *********************************************************************************/
package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.service.DoctorService;
import com.bridgelabz.utility.ClinicUtility;

/**
 * @author Saurav:
 * Class that implements all doctor services
 */
public class DoctorServiceImplementation implements DoctorService {
	PatientServiceImplementation patientServiceImplementation = new PatientServiceImplementation();
	Doctor doctor = new Doctor();
	ObjectMapper mapper = new ObjectMapper();
	public ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	ArrayList<Doctor> foundDoctorList = new ArrayList<Doctor>();
	File doctorFileLoc = new File("/home/bridgelabz/JavaWorkspace/CliniqueManagement/src/com/bridgelabz/files/Doctors.json");

	/**
	 * Method to display doctor's availability list
	 */
	public void showDoctors() throws JsonParseException, JsonMappingException, IOException {
		doctorList = ClinicUtility.parseJSONArray(doctorFileLoc, Doctor.class);
		for (int i = 0; i < doctorList.size(); i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((doctorList.get(i))));
		}
	}

	/**
	 * Method to search doctor's based on name
	 * 
	 * @param Name
	 *            Doctors name
	 * @param patientDetails1
	 *            Patient's name
	 * @param patientDetails2
	 *            Paient's id
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchDoctorsByName(String Name, String patientDetails1, String patientDetails2)
			throws JsonGenerationException, JsonMappingException, IOException, NoSuchMethodException, SecurityException,
			ClassNotFoundException {
		doctorList = ClinicUtility.parseJSONArray(doctorFileLoc, Doctor.class);
		boolean found = false;
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).getDoctorName().replaceAll(" ", "").equals(Name.replaceAll(" ", ""))) {
				foundDoctorList.add(doctorList.get(i));
				found = true;
			}
		}
		searchReturn(found, patientDetails1, patientDetails2, foundDoctorList);
	}

	/**
	 * Method to search doctor's based on ID
	 * 
	 * @param ID
	 *            doctor's ID
	 * @param patientDetails1
	 *            Patient's name
	 * @param patientDetails2
	 *            PAtient's id
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchDoctorsByID(String ID, String patientDetails1, String patientDetails2)
			throws JsonParseException, JsonMappingException, IOException {
		doctorList = ClinicUtility.parseJSONArray(doctorFileLoc, Doctor.class);
		boolean found = false;
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).getDoctorID().equals(ID)) {
				foundDoctorList.add(doctorList.get(i));
				found = true;
			}
		}
		searchReturn(found, patientDetails1, patientDetails2, foundDoctorList);
	}

	/**
	 * Method to search doctor's based on specialization
	 * 
	 * @param specialization
	 * @param patientDetails1
	 *            Patient's name
	 * @param patientDetails2
	 *            PAtient's id
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchDoctorsBySpecialisation(String specialisation, String patientDetails1, String patientDetails2)
			throws JsonParseException, JsonMappingException, IOException {
		doctorList = ClinicUtility.parseJSONArray(doctorFileLoc, Doctor.class);
		boolean found = false;
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).getDoctorSpecialisation().equals(specialisation)) {
				foundDoctorList.add(doctorList.get(i));
				found = true;
			}
		}
		searchReturn(found, patientDetails1, patientDetails2, foundDoctorList);
	}

	/**
	 * Method to search doctor's based on availability
	 * 
	 * @param availability
	 *            Time lot
	 * @param patientDetails1
	 *            Patient's name
	 * @param patientDetails2
	 *            PAtient's id
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchDoctorsByAvailability(String availability, String patientDetails1, String patientDetails2)
			throws JsonParseException, JsonMappingException, IOException {
		doctorList = ClinicUtility.parseJSONArray(doctorFileLoc, Doctor.class);
		boolean found = false;
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).getDoctorAvailability().equals(availability)) {
				foundDoctorList.add(doctorList.get(i));
				found = true;
			}
		}
		searchReturn(found, patientDetails1, patientDetails2, foundDoctorList);
	}

	/**
	 * Method to perform further operations if object found in the clinic's record
	 * 
	 * @param found
	 *            true if element present in record
	 * @param patientDetails1
	 *            Patient's name
	 * @param patientDetails2
	 *            PAtient's id
	 * @param foundDoctorList
	 *            Selected docto's list
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchReturn(boolean found, String patientDetails1, String patientDetails2,
			ArrayList<Doctor> foundDoctorList) throws JsonGenerationException, JsonMappingException, IOException {
		if (found) {
			for (int i = 0; i < foundDoctorList.size(); i++) {
				System.out.println("Doctor Name: " + foundDoctorList.get(i).getDoctorName() + "\nSpecialisation:"
						+ foundDoctorList.get(i).getDoctorSpecialisation() + "\nDoctor ID:"
						+ foundDoctorList.get(i).getDoctorID() + "\nPatient Count:"
						+ foundDoctorList.get(i).getCountOfPatient());
			}
			patientServiceImplementation.takeAppointment(foundDoctorList, patientDetails1, patientDetails2);
		} else {
			System.out.println("Sorry!! The doctor you are searching for is not found in our record!!");
		}
	}

}
