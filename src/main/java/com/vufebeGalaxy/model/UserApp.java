package com.vufebeGalaxy.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;
import com.sun.istack.NotNull;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TUSERS")
public class UserApp {
	
	@Id
	@NotNull
    @Column (name ="ID")
    private Integer id;
	
    @NotNull
    @Column (name ="DSUSERNAME", length = 20)
    private  String username;

    @NotNull
    @Column (name ="DSNOMBRE", length = 255)
    private String dsnombre;

    @NotNull
    @Column (name ="PASS", length = 255)
    private String pass;

    @NotNull
    @Column (name ="SNACTIVO", length = 1)
    private String snActivo;

    @NotNull
    @Column (name ="SINGUPDATE")
    private  Date singUpDate;

	public String getDsNombre() {return this.dsnombre;}
    public String getPass() {return this.pass;}

}
