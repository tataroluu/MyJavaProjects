package com.bilgeadam.springbootteknikservis.model;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserData implements Serializable {

  
    private String NAME;

    private String EMAIL;

    private String PASSWORD;
    
    private String REPASSWORD;
    
    private String CODE;
  
	

    
}