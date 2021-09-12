package com.generation.model;

import com.generation.service.StudentService;

import java.util.*;

public class Student
        extends Person //inherit Person class, attributes of a Student in terms of name, id, email, DOB.
        implements Evaluation { //use Evaluation interface, for Grade computation later
    private double average; //for getAverage() under Evaluation interface

    private final List<Course> Passed_courses = new ArrayList<>(); //List to place all courses which Student has passed

    private final Map<String, Course> approvedCourses = new HashMap<>(); //courses which student has successfully registered

    private final Map<String, Integer> CourseGrades = new HashMap<>(); //Hashmap to store grade tied to registered courses

    public Student(String id, String name, String email, Date birthDate) {
        super(id, name, email, birthDate);
    }
    //above is constructor method inherited from Person class

    public void enrollToCourse(Course course) {
        //TODO implement this method

        if (!approvedCourses.containsValue(course)){
            approvedCourses.put(course.getCode(), course);

        } else {
            System.out.println("Student has already enrolled for this course. Ignore later message");
        }
    }

    public void showApprovedCourses(){
        for (Course i:approvedCourses.values()){
            System.out.print(i + "\n");
        }
    }

    public boolean checkApprovedCourse(String course_id){
       if (approvedCourses.containsKey(course_id)){
           return true;
       } else {
           return false;
       }

    }

    public void registerApprovedCourse(Course course) {
        approvedCourses.put(course.getCode(), course);
    }

    public boolean isCourseApproved(String courseCode) { //???
        //TODO implement this method

        if (approvedCourses.containsKey(courseCode)){
            return true;
        } else {
        return false; }
    }

    //added method for Grade assignment
    public void assignGrade(String course_id, int grade) {

        //TODO implement this method
        CourseGrades.put(course_id,grade);
        System.out.println(CourseGrades);
        if (grade >=3){ //if Student got grade 3 and above, the course will automatically be added to Passed Courses list
            Passed_courses.add(approvedCourses.get(course_id));
        }

    }

    public int getGrade(String course_id1) { //this variable course_id1 only works within the scope method
        if (CourseGrades.containsKey(course_id1)) {
            return CourseGrades.get(course_id1);
        } else {return 0;}
    }

    public List<Course> findPassedCourses(Course course) {


        //TODO implement this method

        if (Passed_courses.contains(course)){
          return Passed_courses;
        } else {
        return null; }
    }

    public void getPassedCourses() {
        //TODO implement this method
        System.out.println(Passed_courses);
    }

    public boolean isAttendingCourse(String courseCode) {
        //TODO implement this method - NO NEED
        return false;
    }

    @Override //have to include this as Student implement Evaluation interface
    public double getAverage() {
        return average;
    }

    @Override //have to include this as Student implement Evaluation interface
    public List<Course> getApprovedCourses() {
        //TODO implement this method - NO NEED
        return null;
    }

    @Override
    public String toString() {
        return "Student {" + super.toString() + "}";
    }
}
