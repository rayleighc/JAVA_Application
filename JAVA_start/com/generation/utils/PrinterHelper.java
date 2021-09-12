package com.generation.utils;

import com.generation.model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrinterHelper
{

    public static void showMainMenu(){
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Select 1 option:              |" );
        System.out.println( "| . 1 Register Student          |" );
        System.out.println( "| . 2 Find Student              |" );
        System.out.println( "| . 3 Grade Student             |" );
        System.out.println( "| . 4 Enroll Student to Course  |" );
        System.out.println( "| . 5 Show Students Summary     |" );
        System.out.println( "| . 6 Show Courses Summary      |" );
        System.out.println( "| . 7 Show Passed Courses       |" ); //added new option and change the index
        System.out.println( "| . 8 Show Average Grade        |" ); //added new option and change the index
        System.out.println( "| . 9 Exit                      |" );
        System.out.println( "|-------------------------------|" );
    }

    public static Student createStudentMenu(Scanner scanner )
        throws ParseException
    {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 1 Register Student                |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter student name:                 |" );
        String name = scanner.next();
        System.out.println( "| Enter student ID:                   |" );
        String id = scanner.next();
        System.out.println( "| Enter student email:                |" );
        String email = scanner.next();

//TODO validate date format and catch exception to avoid crash
        Date birthDate = null;
while(birthDate == null) {
    try {
        System.out.println("| Enter student birth date(mm/dd/yyyy)|");
        DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        birthDate = formatter.parse(scanner.next());
    } catch (Exception e) {
        System.out.println("ERROR! Re-enter student birth date in this format (mm/dd/yyyy)");
    }
}

        System.out.println( "|-------------------------------------|" );
        Student student = new Student( id, name, email, birthDate );
        System.out.println( "Student Successfully Registered! " );
        System.out.println(student);
        return student;
    }

}
