/********************************************************************************* *
 * Purpose: Implementation of Patient Services
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

import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.utility.ClinicUtility;

/**
 * @author Saurav:
 * Class Patient Services Implementation
 */
public class PatientServiceImplementation {
	File doctorFileLoc = new File(
			"/home/bridgelabz/JavaWorkspace/CliniqueManagement/src/com/bridgelabz/files/Doctors.json");
	File patientFileLoc = new File(
			"/home/bridgelabz/JavaWorkspace/CliniqueManagement/src/com/bridgelabz/files/Patients.json");
	File appointmentFile =new File("/home/bridgelabz/saurav/CliniqueManagement/src/com/bridgelabz/files/Appointment.json");
	ArrayList<Patient> patientList = new ArrayList<Patient>();
	ArrayList<Patient> foundpatientList = new ArrayList<Patient>();
	public ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	ArrayList<Doctor> fixedDoctor = new ArrayList<Doctor>();
	Doctor doctor = new Doctor();
	ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	ObjectMapper mapper = new ObjectMapper();
	Patient patient = new Patient();
	Appointment appointment = new Appointment();
	static Doctor popular;
	static int index = 0;
	static String popSpecialisation;
	
	
	/**
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void showPatient() throws JsonParseException, JsonMappingException, IOException {
		patientList = ClinicUtility.parseJSONArray(patientFileLoc, Patient.class);
		for (int i = 0; i < patientList.size(); i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((patientList.get(i))));
		}

	}

	/**
	 * @param Name
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchPatientByName(String Name) throws JsonGenerationException, JsonMappingException, IOException {
		String patientName = Name.replaceAll(" ", "");
		patientList = ClinicUtility.parseJSONArray(patientFileLoc, Patient.class);
		boolean found = false;

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().replaceAll(" ", "").equals(patientName)) {
				// take appointment method
				foundpatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			for (int i = 0; i < foundpatientList.size(); i++) {
				System.out
						.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundpatientList.get(i))));
			}
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	/**
	 * @param ID
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchPatientByID(String ID) throws JsonGenerationException, JsonMappingException, IOException {
		String patientID = ID.replaceAll(" ", "");
		patientList = ClinicUtility.parseJSONArray(patientFileLoc, Patient.class);

		boolean found = false;

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientID().replaceAll(" ", "").equals(patientID)) {
				// take appointment method
				foundpatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			for (int i = 0; i < foundpatientList.size(); i++) {
				System.out
						.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundpatientList.get(i))));
			}
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	/**
	 * @param MobNumber
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchPatientMobNumber(String MobNumber)
			throws JsonGenerationException, JsonMappingException, IOException {
		patientList = ClinicUtility.parseJSONArray(patientFileLoc, Patient.class);

		boolean found = false;

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientMobNumber().replaceAll(" ", "").equals(MobNumber)) {
				// take appointment method
				foundpatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			for (int i = 0; i < foundpatientList.size(); i++) {
				System.out
						.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundpatientList.get(i))));
			}
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}



	/**Method to provide patient with the appointment process
	 * @param foundDoctorList   List of doctors chosen by patient
	 * @param patientDetails1 	Patient's name
	 * @param patientDetails2 	Patient's ID
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void takeAppointment(ArrayList<Doctor> foundDoctorList, String patientDetails1, String patientDetails2)
			throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Doctor> fixedDoctor = new ArrayList<Doctor>();
		System.out.println("Kindly provide the doctor's ID to fix your choice");
		String fixDoctor = ClinicUtility.userInputString();
		appointmentList = ClinicUtility.parseJSONArray(appointmentFile, Appointment.class);

		
		for (int i = 0; i < foundDoctorList.size(); i++) {
			if (foundDoctorList.get(i).getDoctorID().equals(fixDoctor)) {
				fixedDoctor.add(foundDoctorList.get(i));
				foundDoctorList.remove(foundDoctorList.get(i));
			}
		}

		
		doctorList = ClinicUtility.parseJSONArray(doctorFileLoc, Doctor.class);
		int count = fixedDoctor.get(0).getCountOfPatient();
		if (count < 5) {
			fixedDoctor.get(0).setCountOfPatient(count + 1);
			for (int index1 = 0; index1 < doctorList.size(); index1++) {
				if (doctorList.get(index1).getDoctorID().equals(fixDoctor)) {
					index = index1;
					break;
				}
			}

			doctorList.add(index, fixedDoctor.get(0));
			doctorList.remove(index + 1);
			mapper.writeValue(doctorFileLoc, doctorList);
			appointment.setPatientName(patientDetails1);
			appointment.setPatientID(patientDetails2);
			appointment.setDoctorID(fixDoctor);
			appointment.setDoctorName(fixedDoctor.get(0).getDoctorName());
			appointment.setTimeStamp(ClinicUtility.timeStamp());
			appointmentList.add(appointment);
			mapper.writeValue(appointmentFile, appointmentList);
			System.out.println("Your appointment has been fixed");
		}

		
		else {
			System.out.println("Doctor's intake of patient is filled..!! Kindly look for someother doctors!!");
			System.out.println("The other doctors available as per your requirement:");
			if (!foundDoctorList.isEmpty()) {
				for (int index2 = 0; index2 < foundDoctorList.size(); index2++) {
				System.out.println(
					mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundDoctorList.get(index2))));
				}
				System.out.println("You may continue with your appointment");
				takeAppointment(foundDoctorList, patientDetails1, patientDetails2);
			} else {
				System.out.println("No doctors available!! Kindly visit again");
			}
		}
	}

	/**
	 * Method to find popular doctor
	 * 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void popularDoctor() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Popular Doctor of the clinic is:");
		System.out.println(findPopular().getDoctorName());
		System.out.println("Popular Doctor id is");
		System.out.println(findPopular().getDoctorID());
		System.out.println("He/She is speacialist in:");
		System.out.println(findPopular().getDoctorSpecialisation());
		System.out.println("Availaibility of this doctor:");
		System.out.println(findPopular().getDoctorAvailability());
	}

	
	/**
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void popularSpecialisation() throws JsonParseException, JsonMappingException, IOException {
		System.out.println(findPopular().getDoctorSpecialisation());
	}
	
	
	/**
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Doctor findPopular() throws JsonParseException, JsonMappingException, IOException {
		doctorList = ClinicUtility.parseJSONArray(doctorFileLoc, Doctor.class);
		Doctor popular = doctorList.get(0);

		for (int i = 0; i < doctorList.size(); i++) {
			if (popular.getCountOfPatient() <= doctorList.get(i).getCountOfPatient()) {
				popular = doctorList.get(i);
			}
		}
		return popular;
	}
}
