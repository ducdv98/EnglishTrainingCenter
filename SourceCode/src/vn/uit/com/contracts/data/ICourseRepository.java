/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.data;

import dtos.CourseDto;

/**
 *
 * @author Admin
 */
public interface ICourseRepository {
    void getListCourse();
    void updateCourse(CourseDto course);
    void deactiveCourse(int id);
    void insertCourse(CourseDto course);
}
