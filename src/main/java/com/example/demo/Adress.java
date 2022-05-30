package com.example.demo;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {

	private String city;
	private String street;
	private String state;
    private String zipcode;

}