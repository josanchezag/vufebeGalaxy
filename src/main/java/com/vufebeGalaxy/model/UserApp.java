package com.vufebeGalaxy.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import java.sql.Date;

import javax.persistence.Column;
import com.sun.istack.NotNull;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TUSERS")
@Data
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
    private Integer snActivo;

    @NotNull
    @Column (name ="SINGUPDATE")
    private  Date singUpDate;
	
    
    public UserApp(int id, String username, String dsnombre, String pass, int snActivo, java.util.Date singUpDate) {
		this.id=id;
		this.username=username;
		this.dsnombre=dsnombre;
		this.pass=pass;
		this.snActivo=snActivo;
		this.singUpDate=(Date) singUpDate;
	}
    
    public UserApp() {
    	this.id=0;
		this.username="";
		this.dsnombre="";
		this.pass="";
		this.snActivo=0;
		this.singUpDate=(Date) singUpDate;
    }
	public String getDsNombre() {return this.dsnombre;}
    public String getPass() {return this.pass;}

}
