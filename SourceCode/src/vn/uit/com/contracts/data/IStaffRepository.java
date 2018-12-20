/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.data;

import dtos.StaffDto;

/**
 *
 * @author Admin
 */
public interface IStaffRepository {
    void getListStaff();
    void updateStaff(StaffDto staff);
    void deactiveStaff(int id);
    void insertStaff(StaffDto staff);
}
