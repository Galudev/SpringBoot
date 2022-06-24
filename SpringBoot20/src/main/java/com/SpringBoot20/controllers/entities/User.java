package com.SpringBoot20.controllers.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable{
	private static final long serialVersionUID = -4584950849413175548L;
	private Long id;
	private String name;
	private String surname;
}