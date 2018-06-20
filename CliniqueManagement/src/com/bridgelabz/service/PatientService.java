/********************************************************************************* *
 * Purpose: To make Patient Service Interface 
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
 * Class Patient Services
 */
public interface PatientService {
	
	public  void showPatient() throws JsonParseException, JsonMappingException, IOException;

	public void searchPatientByName(String patientName) throws JsonGenerationException, JsonMappingException, IOException;

	public void searchPatientByID(String patientID) throws JsonParseException, JsonMappingException, IOException;

	public void searchPatientMobNumber(String patientMobNumber) throws JsonParseException, JsonMappingException, IOException;

	public void takeAppointment();
}
