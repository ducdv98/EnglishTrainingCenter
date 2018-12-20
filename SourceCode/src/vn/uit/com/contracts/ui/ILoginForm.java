/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.contracts.ui;

import dtos.StaffDto;

/**
 *
 * @author Admin
 */
public interface ILoginForm {
    void onLoginSuccessful(StaffDto employee);
    void onLoginFailure(String errorMsg);
}
