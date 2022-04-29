package com.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Study {
	
@SuppressWarnings("unused")

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="vr")
private String vr;


@SuppressWarnings("unused")
@Column(name="value")
private String value;
public String getVr() {
	return vr;
}
public void setVr(String vr) {
	this.vr = vr;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}

}
