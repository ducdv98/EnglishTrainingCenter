/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Admin
 */
public class ParticipationDto {
    private int courseId;
    private String courseName;
    private int classId;
    private String className;
    private float mark;

    public ParticipationDto() {
    }

    public ParticipationDto(int courseId, String courseName, int classId, String className, float mark) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.classId = classId;
        this.className = className;
        this.mark = mark;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
    
    
}
