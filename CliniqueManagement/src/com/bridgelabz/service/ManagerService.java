/********************************************************************************* *

 * Purpose: To make Manager Service Interface 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 11/06/2018
 *********************************************************************************/
package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * @author Saurav:
 * Interface ManagerServices
 */
public interface ManagerService {
	
	public void addDoctor();
	
	public void addPatient();
	
	public void updatePatientAge(String patientName);
	
	public void updatePatientMobNumber(String patientName);
	
	public void deletePatient(String patientID);

	public void updateAvailTime(String doctorID) throws JsonParseException, JsonMappingException, IOException;

	public void updateSpecialisation(String doctorID) throws JsonParseException, JsonMappingException, IOException;
	
	public void deleteDoctor(String doctorID) throws JsonParseException, JsonMappingException, IOException;
}
