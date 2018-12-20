/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.ui;

import dtos.ClassDto;
import dtos.CourseDto;
import dtos.ParticipationDto;
import dtos.TraineeDto;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IDistributionForm extends IChildPanel{
    void displayTraineeInfo(TraineeDto trainee, ArrayList<ParticipationDto> listParticipations);
    void displayListClassInCourse(CourseDto course, ArrayList<ClassDto> list);
    void displayMessage(String msg, int flag);
}
