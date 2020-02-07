package com.hase.huatuo.admin.dao.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Data
public class StaffList implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    private String staffId;
    private String mobileNum;
    private String emailAddress;
}
