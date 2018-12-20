/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.service;

import dtos.StaffDto;


/**
 *
 * @author Admin
 */
public interface IStaffService {

    void loadListStaff();
    void editStaff(StaffDto staff);
    void deleteStaff(int id);
    void addStaff(StaffDto staff);
}
