/**
 * 
 */
package org.mordeth.multiTenantBatch.batch.model;

import java.io.Serializable;



/**
 * @author   MSE
 * @version  1.0
 * @since    2017-06-22	
 *
 *
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850989040379474377L;
	
	private String employeeId;
	
	private String firstName;

	private String lastName;
	

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

}
