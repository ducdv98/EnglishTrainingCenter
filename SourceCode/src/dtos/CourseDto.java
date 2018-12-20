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
public class CourseDto {
    private int id;
    private String name;
    private BigDecimal fee;
    private int duration;
    private float benchmark;
    private boolean status;

    public CourseDto() {
    }

    public CourseDto(int id, String name, BigDecimal fee, int duration, float benchmark, boolean status) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.duration = duration;
        this.benchmark = benchmark;
        this.status = status;
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

   

    public float getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(float benchmark) {
        this.benchmark = benchmark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
