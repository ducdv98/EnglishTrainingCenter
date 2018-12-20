/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class ClassDto {
    private int id;
    private String name;
    private int capacity;
    private int currentQuantity;
    private String time;
    private Date startedDate;
    private Date endedDate;
    private boolean status;
    private String room;
    private int courseId;
    private String courseName;
    private int teacherId;
    private String teacherName;

    public ClassDto() {
    }

    public ClassDto(int id, String name, int capacity, int currentQuantity, String time, Date startedDate, Date endedDate, boolean status, String room, int courseId, String courseName, int teacherId, String teacherName) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentQuantity = currentQuantity;
        this.time = time;
        this.startedDate = startedDate;
        this.endedDate = endedDate;
        this.status = status;
        this.room = room;
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(Date endedDate) {
        this.endedDate = endedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
    
    
    
}
