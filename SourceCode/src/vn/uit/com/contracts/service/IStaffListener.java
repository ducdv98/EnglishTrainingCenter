/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.StaffDto;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IStaffListener {
    void onGetListStaffSuccess(ArrayList<StaffDto> list);
    void onGetListStaffFail(String err);
    void onUpdateStaffSuccess();
    void onUpdateStaffFail(String err);
    void onCreateStaffSuccess();
    void onCreateStaffFail(String err);
}
