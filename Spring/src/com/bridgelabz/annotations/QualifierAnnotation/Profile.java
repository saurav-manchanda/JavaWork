/********************************************************************************* *
 * Purpose: To show the proper use of qualifier annotation   
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz.annotations.QualifierAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Saurav:
 * Class Profile
 */
public class Profile {
    @Autowired
    @Qualifier("student2")
    private Student student;
   /**
    * default constructor
    */
    public Profile()
    {
        System.out.println("Profile constructor");
    }
    /**
     * Method to print the age
     */
    public void printAge()
    {
        System.out.println("Age:"+student.getAge());
    }
    /**
     * Method to print the name
     */
    public void printName()
    {
        System.out.println("Name:"+student.getName());
    }
}
