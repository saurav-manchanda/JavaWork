/********************************************************************************* *
 * Purpose: To make Doctor Service Interface 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 11/06/2018
 *********************************************************************************/
package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * @author Saurav:
 * Interface DoctorServices
 */
public interface DoctorService {

public  void showDoctors() throws JsonParseException, JsonMappingException, IOException;

	public void searchDoctorsByName(String doctorName,String patientDetails1,String patientDetails2) throws JsonGenerationException, JsonMappingException, IOException, NoSuchMethodException, SecurityException, ClassNotFoundException;

	public void searchDoctorsByID(String ID,String patientDetails1,String patientDetails2) throws JsonParseException, JsonMappingException, IOException;

	public void searchDoctorsBySpecialisation(String specialisation,String patientDetails1,String patientDetails2) throws JsonParseException, JsonMappingException, IOException;

	public void searchDoctorsByAvailability(String availability,String patientDetails1,String patientDetails2) throws JsonParseException, JsonMappingException, IOException;
}
