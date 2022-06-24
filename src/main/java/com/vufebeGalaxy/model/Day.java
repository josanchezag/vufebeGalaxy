package com.vufebeGalaxy.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TDAYS")
public class Day {
	@Id
    @NotNull
    @Column (name ="NRO_DIA", length = 5)
    private  Integer dia;

    @NotNull
    @Column (name ="DS_CLIMA", length = 20)
    private String dsClima;

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDsClima() {
		return dsClima;
	}

	public void setDsClima(String dsClima) {
		this.dsClima = dsClima;
	}

	public Day() {
		this.dia = 0;
		this.dsClima = "";
	}

	public Day(Integer dia, String dsClima) {
		this.dia = dia;
		this.dsClima = dsClima;
	}
    
    

}
