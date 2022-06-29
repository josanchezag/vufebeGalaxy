package com.vufebeGalaxy.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


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


    @Column (name ="PERIMETER")
    private double perimeter;

}
