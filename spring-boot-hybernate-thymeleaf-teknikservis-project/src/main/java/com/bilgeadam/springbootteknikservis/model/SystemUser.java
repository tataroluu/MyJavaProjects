package com.bilgeadam.springbootteknikservis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(length = 100)
    private String NAME;

    @Column(unique = true, nullable = false, length = 200)
    private String EMAIL;

    @Column(nullable = false)
    private String PASSWORD;

    private String CODE;
    
    @ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
}
