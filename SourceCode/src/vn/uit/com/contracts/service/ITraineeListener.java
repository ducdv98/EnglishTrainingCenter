/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.TraineeDto;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ITraineeListener {
    void onGetListTraineeSuccessful(ArrayList<TraineeDto> list);
    void onGetListTraineeFail(String err);
    void onUpdateTraineeSuccess();
    void onUpdateTraineeFail(String err);
    void onInsertTraineeSuccess();
    void onInsertTraineeFail(String err);
}
