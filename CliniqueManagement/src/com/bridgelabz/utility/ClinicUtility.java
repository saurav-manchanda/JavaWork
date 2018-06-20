/********************************************************************************* *
 * Purpose: Utility class for CliniqueManagementProgram 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 11/06/2018
 *********************************************************************************/
package com.bridgelabz.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
/**
 * @author Saurav:
 * Class that consists basic methods that are frequently used in the projetc
 */
public class ClinicUtility {
    static ObjectMapper mapper=new ObjectMapper();
   
    static Scanner scanner=new Scanner(System.in);

   /**
    * Method to take string input
    * @return
    */
    public static String userInputString() {
        return scanner.next();

    }

    /**
     * Method to take user input as long
     */
    public static Long userInputLong() {
        return scanner.nextLong();

    }
    /**
     * Method that takes a strng line
     * @return
     */
    public static String userInputStringLine() {
        return scanner.nextLine();
    }

    /**
     * Method to take user input as integer
     */
    public static int userInputInteger() {
        return scanner.nextInt();
    }

    /**
     * Method to take user input as double
     */
    public static Double userInputDouble() {
        return scanner.nextDouble();
    }

    /**
     * Method to take user input as boolean
     */
    public static boolean userInputBoolean() {
        return scanner.nextBoolean();
    }
   
   /**
    * Method to parse the content from the file and write that in ArrayList
    * @param file
    * @param clazz
    * @return
    * @throws JsonParseException
    * @throws JsonMappingException
    * @throws IOException
    */
    public static <T> ArrayList<T> parseJSONArray(File file, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ArrayList<T> arrayList = new ArrayList<T>();
        CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class,clazz);
        arrayList = mapper.readValue(file, javaType);
        return arrayList;

    }
   /**
    * Method to take Doctor Inputs in the String array
    * @return the string array
    */
    public static String[] takeDoctorInputs() {
        System.out.println("Kindly enter the doctor's details: ");
        System.out.println("Enter doctor's name: ");
        ClinicUtility.userInputStringLine();
        String doctorName=ClinicUtility.userInputStringLine();
        System.out.println("Enter doctor's ID: ");
        String doctorID=ClinicUtility.userInputString();
        System.out.println("Enter doctor's specialisation: ");
        ClinicUtility.userInputStringLine();
        String doctorSpecialisation=ClinicUtility.userInputStringLine();
        System.out.println("Enter doctor's availability slot(AM/PM/Both): ");
        String doctorAvailability=ClinicUtility.userInputString();
        String doctorsDetails[]= {doctorName,doctorID,doctorSpecialisation,doctorAvailability};
        return doctorsDetails;
    }
   /**
    * Method to takePatientInputs
    * @return
    */
    public static String[] takePatientInputs() {
        System.out.println("Kindly enter the patient's details: ");
        System.out.println("Enter patient's name: ");
        ClinicUtility.userInputStringLine();
        String patientName=ClinicUtility.userInputStringLine();
        System.out.println("Enter patient's ID: ");
        String patientID=ClinicUtility.userInputString();
        System.out.println("Enter patients's mobile number: ");
        ClinicUtility.userInputStringLine();
        String patientMobileNumber=ClinicUtility.userInputStringLine();
        System.out.println("Enter patient's age ");
        int patientAge=ClinicUtility.userInputInteger();
        String patientDetails[]= {patientName,patientID,patientMobileNumber,Integer.toString(patientAge)};
        return patientDetails;
    }
    /**
     * Method to return the present timeStamp
     * @return
     */
    public static String timeStamp() {
        Date date = new Date(); 
        Timestamp ts=new Timestamp(date.getTime()); 
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return (formatter.format(ts));
    }
}
