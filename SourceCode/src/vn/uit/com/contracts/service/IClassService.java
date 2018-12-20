/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.ClassDto;

/**
 *
 * @author Admin
 */
public interface IClassService {
    void loadListClass();
    void loadListTraineeInClass(int classId, int courseId);
    void updateMarkOfTrainee(int classId, int courseId, int traineeId, float mark);
    void loadCourseAndStaffAvailable();
    void addClass(ClassDto classDto);
}
