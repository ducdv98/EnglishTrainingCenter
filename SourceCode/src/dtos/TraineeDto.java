/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class TraineeDto {
    private int id;
    private String name;
    private String address;
    private String phoneNum;
    private Date birthday;
    private Date dateCreated;
    private BigDecimal feePaid;
    private float testMark;
    private float courseMark;
    private Date startedDate;
    

    public TraineeDto() {
    }

    public TraineeDto(int id, String name, String address, String phoneNum, Date birthday, Date dateCreated, BigDecimal feePaid, float testMark, float courseMark, Date startedDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
        this.dateCreated = dateCreated;
        this.feePaid = feePaid;
        this.testMark = testMark;
        this.courseMark = courseMark;
        this.startedDate = startedDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public BigDecimal getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(BigDecimal feePaid) {
        this.feePaid = feePaid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public float getTestMark() {
        return testMark;
    }

    public void setTestMark(float testMark) {
        this.testMark = testMark;
    }

    public float getCourseMark() {
        return courseMark;
    }

    public void setCourseMark(float courseMark) {
        this.courseMark = courseMark;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }
    
    
    
}
