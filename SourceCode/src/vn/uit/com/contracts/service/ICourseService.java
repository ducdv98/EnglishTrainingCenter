/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.CourseDto;

/**
 *
 * @author Admin
 */
public interface ICourseService {
    void loadListCourse();
    void editCourse(CourseDto course);
    void closeCourse(int id);
    void addCourse(CourseDto course);
}
