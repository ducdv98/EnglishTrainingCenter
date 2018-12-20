/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.ClassDto;
import dtos.CourseDto;
import dtos.StaffDto;
import dtos.TraineeDto;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IClassListener {
    void onGetListClassSuccess(ArrayList<ClassDto> list);
    void onGetListClassFail(String err);
    void onGetListTraineeInClassSuccess(ArrayList<TraineeDto> list);
    void onGetListTraineeInClassFail(String err);
    void onUpdateTraineeMarkSuccess();
    void onUpdateTraineeMarkFail(String err);
    void onGetCoursesAndStaffsSuccess(ArrayList<CourseDto> courses, ArrayList<StaffDto> staffs );
    void onGetCoursesAndStaffsFail(String err);
    void onInsertClassSuccess();
    void onInsertClassFail(String err);
}