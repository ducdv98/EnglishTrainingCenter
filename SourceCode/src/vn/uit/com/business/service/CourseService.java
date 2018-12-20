/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.business.service;

import dtos.CourseDto;
import java.util.ArrayList;
import vn.com.uit.common.Constants;
import vn.com.uit.data.repository.CourseRepository;
import vn.uit.com.contracts.data.ICourseRepository;
import vn.uit.com.contracts.service.ICourseListener;
import vn.uit.com.contracts.service.ICourseService;
import vn.uit.com.contracts.ui.ICourseForm;
import vn.uit.com.contracts.ui.IDialogForm;

/**
 *
 * @author Admin
 */
public class CourseService implements ICourseService, ICourseListener{

    private ICourseForm _courseForm;
    private ICourseRepository _db;
    private IDialogForm _courseEdit;
    private IDialogForm _courseNew;
    
    
    public CourseService(ICourseForm courseForm){
        this._courseForm = courseForm;
        _db = new CourseRepository(this);
    }
    
    public CourseService(IDialogForm inst, int type){
        if (type == Constants.MODE_MODIFY){
            _courseEdit = inst;
        }
        else if (type == Constants.MODE_NEW){
            _courseNew = inst;
        }
        _db = new CourseRepository(this);
    }
    
    
    @Override
    public void loadListCourse() {
        _db.getListCourse();
    }

    @Override
    public void onGetListCourseSuccess(ArrayList<CourseDto> list) {
        _courseForm.displayListCourse(list);
    }

    @Override
    public void onGetListCourseFail(String err) {
        
    }

    @Override
    public void editCourse(CourseDto course) {
        _db.updateCourse(course);
    }

    @Override
    public void onUpdateCourseSuccess() {
        _courseEdit.displayMessage(Constants.STATUS_OK, "");
    }

    @Override
    public void onUpdateCourseFail(String err) {
        _courseEdit.displayMessage(Constants.STATUS_ERROR, err);
    }

    @Override
    public void closeCourse(int id) {
        _db.deactiveCourse(id);
    }

    @Override
    public void addCourse(CourseDto course) {
       _db.insertCourse(course);
    }

    @Override
    public void onInsertCourseSuccess() {
        _courseNew.displayMessage(Constants.STATUS_OK, "");
    }

    @Override
    public void onInsertCourseFail(String err) {
        _courseNew.displayMessage(Constants.STATUS_ERROR, err);
    }
    
}
