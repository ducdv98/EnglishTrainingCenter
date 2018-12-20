/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.data;

import dtos.ClassDto;

/**
 *
 * @author Admin
 */
public interface IClassRepository {
    void getListClass();
    void getListTraineeInClass(int classId, int courseId);
    void updateTraineeMark(int classId, int courseId, int traineeId, float mark);
    void getListCourseAndListStaff();
    void insertClass(ClassDto classDto);
}
