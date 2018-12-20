/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.business.service;

import dtos.StaffDto;
import java.util.ArrayList;
import vn.com.uit.common.Constants;
import vn.com.uit.common.PasswordEncryptor;
import vn.com.uit.data.repository.StaffRepository;
import vn.uit.com.contracts.data.IStaffRepository;
import vn.uit.com.contracts.service.IStaffService;
import vn.uit.com.contracts.ui.IStaffForm;
import vn.uit.com.contracts.service.IStaffListener;
import vn.uit.com.contracts.ui.IDialogForm;

/**
 *
 * @author Admin
 */
public class StaffService implements IStaffService, IStaffListener {

    private IStaffForm _staffForm;
    private IDialogForm _staffEdit = null;
    private IDialogForm _staffNew = null;
    private IStaffRepository _staffRepository;
    

    public StaffService(IStaffForm staffForm) {
        this._staffForm = staffForm;
        _staffRepository = new StaffRepository(this);
    }
    
    public StaffService(IDialogForm inst, int type) {
        if(type == Constants.MODE_MODIFY){
            _staffEdit = inst;
        }
        else if (type == Constants.MODE_NEW){
            _staffNew = inst;
        }
        
        _staffRepository = new StaffRepository(this);
    }

    @Override
    public void loadListStaff() {
        _staffRepository.getListStaff();
    }

    @Override
    public void onGetListStaffSuccess(ArrayList<StaffDto> list) {
        _staffForm.displayListStaff(list);
    }

    @Override
    public void onGetListStaffFail(String err) {
        _staffForm.displayErrorMsg(err);
    }

    @Override
    public void deleteStaff(int id) {
        _staffRepository.deactiveStaff(id);
    }

    @Override
    public void editStaff(StaffDto staff) {
        _staffRepository.updateStaff(staff);
    }

    @Override
    public void onUpdateStaffSuccess() {
        _staffEdit.displayMessage(Constants.STATUS_OK,"");
    }

    @Override
    public void onUpdateStaffFail(String err) {
        _staffEdit.displayMessage(Constants.STATUS_OK, err);
    }

    @Override
    public void addStaff(StaffDto staff) {
        staff.setPassword(PasswordEncryptor.getMd5(staff.getPassword()));
        _staffRepository.insertStaff(staff);
    }

    @Override
    public void onCreateStaffSuccess() {
        _staffNew.displayMessage(Constants.STATUS_OK, "");
    }

    @Override
    public void onCreateStaffFail(String err) {
        _staffNew.displayMessage(Constants.STATUS_ERROR, err);
    }

    

}
