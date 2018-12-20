/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.business.service;

import dtos.TraineeDto;
import java.util.ArrayList;
import vn.com.uit.common.Constants;
import vn.com.uit.data.repository.TraineeRepository;
import vn.uit.com.contracts.data.ITraineeRepository;
import vn.uit.com.contracts.service.ITraineeService;
import vn.uit.com.contracts.ui.ITraineeForm;
import vn.uit.com.contracts.service.ITraineeListener;
import vn.uit.com.contracts.ui.IDialogForm;

/**
 *
 * @author Admin
 */
public class TraineeService implements ITraineeService, ITraineeListener{

    private ITraineeForm _traineeForm;
    private ITraineeRepository _db;
    private IDialogForm _traineeEditForm;
    private IDialogForm _traineeNewForm;
    
    public TraineeService(ITraineeForm ui){
        this._traineeForm = ui;
        _db = new TraineeRepository(this);
    }
    
    public TraineeService(IDialogForm inst, int type){
        if (type == Constants.MODE_MODIFY){
            _traineeEditForm = inst;
        }
        else if(type == Constants.MODE_NEW){
            _traineeNewForm = inst;
        }
        _db = new TraineeRepository(this);
        
    }
    
    @Override
    public void loadListTrainee() {
        _db.getListTrainee();
    }
    
     @Override
    public void editTrainee(TraineeDto trainee) {
        _db.updateTrainee(trainee);
    }
    

    @Override
    public void onGetListTraineeSuccessful(ArrayList<TraineeDto> list) {
        _traineeForm.displayListTrainee(list);
    }

    @Override
    public void onGetListTraineeFail(String err) {
        _traineeForm.displayErrorMsg(err);
    }

    @Override
    public void onUpdateTraineeSuccess() {
        _traineeEditForm.displayMessage(Constants.STATUS_OK, "");
    }

    @Override
    public void onUpdateTraineeFail(String err) {
        _traineeEditForm.displayMessage(Constants.STATUS_ERROR, err);
    }

    @Override
    public void addTrainee(TraineeDto trainee) {
        _db.insertTrainee(trainee);
    }

    @Override
    public void onInsertTraineeSuccess() {
        _traineeNewForm.displayMessage(Constants.STATUS_OK, "");
    }

    @Override
    public void onInsertTraineeFail(String err) {
        _traineeNewForm.displayMessage(Constants.STATUS_ERROR, err);
    }

   
    
}
