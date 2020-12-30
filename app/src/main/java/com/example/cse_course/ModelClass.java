package com.example.cse_course;

public class ModelClass {
    private String CourseTitle;
    private String CourseCode;

    public ModelClass() {
    }

    public ModelClass(String courseTitle, String courseCode) {
        CourseTitle = courseTitle;
        CourseCode = courseCode;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        CourseTitle = courseTitle;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }
}
