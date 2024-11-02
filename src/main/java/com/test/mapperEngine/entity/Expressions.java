package com.jkb.transformationservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
public class Expressions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "route_id", nullable = false)
    private int routeId;

    @Basic
    @Column(name = "expression_text", length = -1)
    private String expressionText;

    @Basic
    @Column(name = "expression_type", length = 64)
    private String expressionType;

    @Basic
    @Column(name = "results", length = -1)
    private String results;

    @Basic
    @Column(name = "exec_sequence")
    private Integer execSequence;

    @Basic
    @Column(name = "status")
    private Byte status;

    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;

    @Basic
    @Column(name = "updated_on")
    private Timestamp updatedOn;

}
