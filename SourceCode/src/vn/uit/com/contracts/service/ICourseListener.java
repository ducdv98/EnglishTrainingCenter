/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.CourseDto;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ICourseListener {
    void onGetListCourseSuccess(ArrayList<CourseDto> list);
    void onGetListCourseFail(String err);
    void onUpdateCourseSuccess();
    void onUpdateCourseFail(String err);
    void onInsertCourseSuccess();
    void onInsertCourseFail(String err);
}
