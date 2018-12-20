package dtos;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class StaffDto {

    private int id;
    private String name;
    private String identityCardNumber;
    private String phoneNum;
    private BigDecimal salary;
    private Date startedDate;
    private int idRole;
    private String role;
    private String username;
    private String password;
    private boolean status;
    private int claim;

    public StaffDto() {
    }

    public StaffDto(int id, String name, String identityCardNumber, String phoneNum, BigDecimal salary, Date startedDate, int idRole, String role, String username, String password, boolean status, int claim) {
        this.id = id;
        this.name = name;
        this.identityCardNumber = identityCardNumber;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.startedDate = startedDate;
        this.idRole = idRole;
        this.role = role;
        this.username = username;
        this.password = password;
        this.status = status;
        this.claim = claim;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getClaim() {
        return claim;
    }

    public void setClaim(int claim) {
        this.claim = claim;
    }
    
    

    @Override
    public String toString() {
        return name;
    }

}
