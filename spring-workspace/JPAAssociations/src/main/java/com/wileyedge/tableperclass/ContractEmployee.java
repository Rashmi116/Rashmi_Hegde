package com.wileyedge.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="contra5")

public class ContractEmployee extends Employe {

	private String contractorname;

	public String getContractorname() {
		return contractorname;
	}

	public void setContractorname(String contractorname) {
		this.contractorname = contractorname;
	}

	public ContractEmployee(String fname, String lname, String contractorname) {
		super(fname, lname);
		this.contractorname = contractorname;
	}

}
