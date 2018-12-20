/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.uit.com.business.service;

import dtos.StaffDto;
import vn.com.uit.common.PasswordEncryptor;
import vn.com.uit.data.repository.LoginRepository;
import vn.uit.com.contracts.data.ILoginRepository;
import vn.uit.com.contracts.service.ILoginService;
import vn.uit.com.contracts.ui.ILoginForm;
import vn.uit.com.contracts.service.ILoginListener;


/**
 *
 * @author Duc DV
 */
public class LoginService implements ILoginService, ILoginListener {

    private ILoginForm _ui;
    private ILoginRepository _db;
       
    public LoginService(){
        
    }
    
    public LoginService(ILoginForm ui){
        this._ui = ui;
        _db = new LoginRepository(this);
    }
    
    
    @Override
    public void login(String username, String password) {
        String passwordHash = PasswordEncryptor.getMd5(password);
        _db.checkCredential(username, passwordHash);
    }

    @Override
    public void onCredentialIsNotValid(String msg) {
        _ui.onLoginFailure(msg);
    }

    @Override
    public void onGetCredentialSuccessful(StaffDto employee) {
        _ui.onLoginSuccessful(employee);
    }
    
}
