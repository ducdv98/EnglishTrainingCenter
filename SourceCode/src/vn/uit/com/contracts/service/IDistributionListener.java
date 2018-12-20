/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.ClassDto;
import dtos.CourseDto;
import dtos.ParticipationDto;
import dtos.TraineeDto;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IDistributionListener {
    void onGetTraineeInfoSuccess(TraineeDto trainee, ArrayList<ParticipationDto> listParticipations);
    void onGetTraineeFail(String err);
    void onGetListClassSuccess(CourseDto course, ArrayList<ClassDto> list);
    void onGetListClassFail(String err);
    void onAddTraineeToClassSuccess();
    void onAddTraineeToClassFail(String err);
}
