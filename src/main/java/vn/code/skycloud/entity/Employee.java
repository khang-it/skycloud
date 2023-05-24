package vn.code.skycloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	Long employeeId;
	String employeeName;
	String employeeEmail;
	String employeeAddress;
	String departmentName;
}
