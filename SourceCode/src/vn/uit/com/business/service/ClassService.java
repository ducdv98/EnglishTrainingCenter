/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.business.service;

import dtos.ClassDto;
import dtos.CourseDto;
import dtos.StaffDto;
import dtos.TraineeDto;
import java.util.ArrayList;
import vn.com.uit.common.Constants;
import vn.com.uit.data.repository.ClassRepository;
import vn.uit.com.contracts.data.IClassRepository;
import vn.uit.com.contracts.service.IClassListener;
import vn.uit.com.contracts.service.IClassService;
import vn.uit.com.contracts.ui.IChildPanel;
import vn.uit.com.contracts.ui.IClassForm;
import vn.uit.com.contracts.ui.IClassNewForm;
import vn.uit.com.contracts.ui.IDialogForm;
import vn.uit.com.contracts.ui.IListClassForm;

/**
 *
 * @author Admin
 */
public class ClassService implements IClassService, IClassListener {

    private IClassForm _classForm;
    private IClassRepository _db;
    private IListClassForm _listClassForm;
    private IClassNewForm _classNewForm;
    private IDialogForm _classNew;
    
        public ClassService(IClassForm classForm) {
        this._classForm = classForm;
        _db = new ClassRepository(this);
    }

    public ClassService(IListClassForm listClassForm) {
        _listClassForm = listClassForm;
        _db = new ClassRepository(this);
    }
    
    public ClassService(IClassNewForm classNewForm, IDialogForm classNew){
        _classNewForm = classNewForm;
        _classNew = classNew;
        _db = new ClassRepository(this);
    }

    @Override
    public void loadListClass() {
        _db.getListClass();
    }

    @Override
    public void onGetListClassSuccess(ArrayList<ClassDto> list) {
        _classForm.displayListClass(list);
    }

    @Override
    public void onGetListClassFail(String err) {
         //TODO: Log error!
    }

    @Override
    public void updateMarkOfTrainee(int classId, int courseId, int traineeId, float mark) {
        _db.updateTraineeMark(classId, courseId, traineeId, mark);
    }

    @Override
    public void loadListTraineeInClass(int classId, int courseId) {
        _db.getListTraineeInClass(classId, courseId);
    }

    @Override
    public void onGetListTraineeInClassSuccess(ArrayList<TraineeDto> list) {
        _listClassForm.displayListTraineeInClass(list);
    }

    @Override
    public void onGetListTraineeInClassFail(String err) {
        //TODO: Log error!
    }

    @Override
    public void onUpdateTraineeMarkSuccess() {
        _listClassForm.displayMessage("Cập nhật thành công!");
    }

    @Override
    public void onUpdateTraineeMarkFail(String err) {
        _listClassForm.displayMessage("Cập nhật thất bại!");
    }

    @Override
    public void loadCourseAndStaffAvailable() {
        _db.getListCourseAndListStaff();
    }

    @Override
    public void onGetCoursesAndStaffsSuccess(ArrayList<CourseDto> courses, ArrayList<StaffDto> staffs) {
        _classNewForm.bindDataToUI(courses, staffs);
    }

    @Override
    public void onGetCoursesAndStaffsFail(String err) {
        //TODO: Log error!
    }

    @Override
    public void addClass(ClassDto classDto) {
        _db.insertClass(classDto);
    }

    @Override
    public void onInsertClassSuccess() {
       _classNew.displayMessage(Constants.STATUS_OK, "");
    }

    @Override
    public void onInsertClassFail(String err) {
        _classNew.displayMessage(Constants.STATUS_ERROR, err);
    }

   

}
