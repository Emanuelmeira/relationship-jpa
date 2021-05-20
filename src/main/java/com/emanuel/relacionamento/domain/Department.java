package com.emanuel.relacionamento.domain;

import javax.persistence.*;
;

@Entity
@Table(name = "DEPARTAMENTO", schema = "public")
public class Department  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_departamento")
    private Long id;

    @Column(name = "nome_departamento")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
