/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.ui;

import dtos.TraineeDto;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ITraineeForm extends IChildPanel{
    void displayListTrainee(ArrayList<TraineeDto> list);
    void displayErrorMsg(String msg);
}
