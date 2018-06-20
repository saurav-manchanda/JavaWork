/********************************************************************************* *
 * Purpose:   This   programme   is   used   to   manage   a   list   of  
Doctors   associated   with   the   Clinique.   This   also   manages   the   list   of   patients   who   use   the  
clinique.   It   manages   Doctors   by   Name,   Id,   Specialization   and   Availability   (AM,   PM   or  
both).   It   manages   Patients   by   Name,   ID,   Mobile   Number   and   Age.   The   Program   allows  
users   to   search   Doctor   by   name,   id,   Specialization   or   Availability.   Also   the   programs  
allows   users   to   search   patient   by   name,   mobile   number   or   id.   The   programs   allows  
patients   to   take   appointment   with   the   doctor.   A   doctor   at   any   availability   time   can   see  
only   5   patients.   If   exceeded   the   user   can   take   appointment   for   patient   at   different   date   or  
availability   time.   Print   the   Doctor   Patient   Report.   Also   show   which   Specialization   is  
popular   in   the   Clinique   as   well   as   which   Doctor   is   popular.

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 12/06/2018
 *********************************************************************************/
package com.bridgelabz.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import com.bridgelabz.serviceimplementation.DoctorServiceImplementation;
import com.bridgelabz.serviceimplementation.ManagerServiceImplementation;
import com.bridgelabz.serviceimplementation.PatientServiceImplementation;
import com.bridgelabz.utility.ClinicUtility;
/**
 * @author bridgelabz
 * Class to manage Clinique Management
 */
public class ClinicManager {
	static ManagerServiceImplementation managerServiceImplementation=new ManagerServiceImplementation();
	static DoctorServiceImplementation doctorServiceImplementation=new DoctorServiceImplementation();
	static PatientServiceImplementation patientServiceImplementation=new PatientServiceImplementation();
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		boolean keepOn=true;
		while(keepOn) {
		System.out.println("WELCOME TO SAURAV'S CLINIC..!! ");
		System.out.println("Enter the choice....");
		System.out.println("1. TAKE APPOINTMENT");
		System.out.println("2. PATIENTS RELATED TASK");
		System.out.println("3. DOCTOR RELATED TASK");
		System.out.println("4. POPULAR DOCTOR");
		System.out.println("5. POPULAR SPECIALISATION");
		System.out.println("6. PRINT REPORT");
		System.out.println("7. QUIT CLINIC");
		
		int choice=ClinicUtility.userInputInteger();
		switch(choice) {
		case 1: 
			
			String patientDetails[]=ClinicUtility.takePatientInputs(); 
			managerServiceImplementation.addPatient(patientDetails[0],patientDetails[1],patientDetails[2],Integer.parseInt(patientDetails[3]) );

			System.out.println("Kindly proceed further to fix your appointment ");
			System.out.println("We have following doctors available in the clinic..");
			doctorServiceImplementation.showDoctors();
			System.out.println("1. SEARCH DOCTOR BY NAME");
			System.out.println("2. SEARCH DOCTOR BY ID");
			System.out.println("3.- SEARCH DOCTOR BY SPECIALISATION");
			System.out.println("4.- SEARCH DOCTOR BY AVAILABILITY");
			int choiceOfSearch=ClinicUtility.userInputInteger();
			switch(choiceOfSearch) {
		
			case 1: 
				System.out.println("Enter doctor's name");
				ClinicUtility.userInputStringLine();
				doctorServiceImplementation.searchDoctorsByName(ClinicUtility.userInputStringLine(),patientDetails[0],patientDetails[1]);
				
				break;
				
			case 2:
				System.out.println("Enter doctor's ID");
				doctorServiceImplementation.searchDoctorsByID(ClinicUtility.userInputString(),patientDetails[0],patientDetails[1]);
				break;
			case 3:
				System.out.println("Enter doctor's specialisation");
				ClinicUtility.userInputStringLine();
				doctorServiceImplementation.searchDoctorsBySpecialisation(ClinicUtility.userInputStringLine(),patientDetails[0],patientDetails[1]);
				
				break;
			case 4:
				System.out.println("Enter doctor's availability(AM/PM/Both)");
				ClinicUtility.userInputStringLine();
				doctorServiceImplementation.searchDoctorsByAvailability(ClinicUtility.userInputStringLine(),patientDetails[0],patientDetails[1]);
				break;
			}
			break;
		case 2:
			
			System.out.println("1. VIEW PATIENT LIST");
			System.out.println("2. SEARCH PATIENT");
			System.out.println("3. ADD PATIENT");
			System.out.println("4. UPDATE PATIENT");
			System.out.println("5. DELETE PATIENT");
			int choiceOfSearch1=ClinicUtility.userInputInteger();
			switch(choiceOfSearch1) {
			
				case 1:
				System.out.println("Patient Record.... :");
				patientServiceImplementation.showPatient();
				break;
				
				case 2:
				System.out.println("Kindly proceed further to search for the patient ");
				System.out.println("The list of patient in the record is..");
				patientServiceImplementation.showPatient();
				System.out.println("1. SEARCH PATIENT BY NAME");
				System.out.println("2. SEARCH PATIENT BY ID");
				System.out.println("3. SEARCH PATIENT BY MOBILE NUMBER");
				int choiceOfSearch2=ClinicUtility.userInputInteger();
				switch(choiceOfSearch2) {
				case 1: 
					System.out.println("Enter patient's name");
					ClinicUtility.userInputStringLine();
					patientServiceImplementation.searchPatientByName(ClinicUtility.userInputStringLine());
					break;
					
				case 2:
					System.out.println("Enter patient's ID");
					patientServiceImplementation.searchPatientByID(ClinicUtility.userInputString());
					break;
				case 3:
					System.out.println("Enter patient's mobileNumber");
					ClinicUtility.userInputStringLine();
					patientServiceImplementation.searchPatientMobNumber(ClinicUtility.userInputStringLine());
					break;
				}
				break;
				
				
				case 3:
					String patientDetails1[]=ClinicUtility.takePatientInputs(); 
					managerServiceImplementation.addPatient(patientDetails1[0],patientDetails1[1],patientDetails1[2],Integer.parseInt(patientDetails1[3]) );
					break;
				
				case 4:
					System.out.println("Kindly proceed further to update patient details ");
					System.out.println("The list of patient in the record is..");
					patientServiceImplementation.showPatient();
					System.out.println("Please provide patient's name whose details you wish to update: ");
					ClinicUtility.userInputStringLine();
					String patientName=ClinicUtility.userInputStringLine();
					System.out.println("You can update "+patientName+"'s following details:");
					System.out.println("1. UPDATE PATIENT'S AGE");
					System.out.println("2. UPDATE PATIENT'S MOBILE NUMBER");
					System.out.println("Enter your choice: ");
					
					int choiceOfSearch3=ClinicUtility.userInputInteger();
					switch(choiceOfSearch3) {
					case 1:
					managerServiceImplementation.updatePatientAge(patientName) ;
						break;
						
					case 2:
						managerServiceImplementation.updatePatientMobNumber(patientName) ;
						break;
						
					}
					break;
				
				case 5:
					System.out.println("The list of patient in the record is..");
					patientServiceImplementation.showPatient();
					System.out.println("Please provide patient's id whom you wish to delete from the record: ");
					managerServiceImplementation.deletePatient(ClinicUtility.userInputString()) ;
					break;
					}
			break;
			
		case 3:
			System.out.println("1. VIEW DOCTOR'S LIST");
			System.out.println("2. ADD DOCTOR");
			System.out.println("3. UPDATE DOCTOR");
			System.out.println("4. DELETE DOCTOR");	
			System.out.println("Enter your choice:");
			int choiceOfSearch4=ClinicUtility.userInputInteger();
			switch(choiceOfSearch4) {
			case 1:
			System.out.println("Doctor's Record.... :");
			doctorServiceImplementation.showDoctors();
			break;
			
			case 2:
			String doctorDetails[]=ClinicUtility.takeDoctorInputs(); 
			managerServiceImplementation.addDoctor(doctorDetails[0], doctorDetails[1], doctorDetails[2],doctorDetails[3]);
			break;
			
			case 3:
				System.out.println("Kindly proceed further to update doctor's details ");
				System.out.println("The list of doctor's in the record ..");
				doctorServiceImplementation.showDoctors();
				System.out.println("Please provide doctor's ID whose details you wish to update: ");
				ClinicUtility.userInputStringLine();
				String doctorID=ClinicUtility.userInputStringLine();
				System.out.println("You can update following details:");
				System.out.println("1. UPDATE DOCTOR'S AVAILABILITY TIME");
				System.out.println("2. UPDATE DOCTOR'S SPECIALISATION");
				System.out.println("Enter your choice: ");
				int choiceOfSearch5=ClinicUtility.userInputInteger();
				switch(choiceOfSearch5) {
				case 1: 
					managerServiceImplementation.updateAvailTime(doctorID);
				break;
				
				case 2:
					managerServiceImplementation.updateSpecialisation(doctorID);
				break;
				}
				break;
				
			case 4:
				System.out.println("The list of doctors in the record is..");
				doctorServiceImplementation.showDoctors();
				System.out.println("Please provide doctor's id whom you wish to delete from the record: ");
				managerServiceImplementation.deleteDoctor(ClinicUtility.userInputString()) ;
				break;
				}
			break;
		 
		case 4:patientServiceImplementation.popularDoctor();
		break;
		case 5: patientServiceImplementation.popularSpecialisation();
		break;
		case 6:
			managerServiceImplementation.printReport();
			break;
		default:System.out.println("Quiting Clinic... ThankYou Visit Again!!");
			keepOn=false;
		}
				
		}
	}
	}

