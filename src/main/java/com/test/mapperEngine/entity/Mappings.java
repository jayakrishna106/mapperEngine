package com.jkb.transformationservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Mappings {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "version", nullable = false)
    private int version;

    @Basic
    @Column(name = "mapper_data", length = -1)
    private String mapperData;

    @Basic
    @Column(name = "target_template", length = -1)
    private String targetTemplate;

    @Basic
    @Column(name = "template_name", length = 255)
    private String templateName;

    @Basic
    @Column(name = "template_type", length = 32)
    private String templateType;

    @Basic
    @Column(name = "priority")
    private Integer priority;

    @Basic
    @Column(name = "status")
    private Byte status;

    @Basic
    @Column(name = "sample_input", length = -1)
    private String sampleInput;

    @Basic
    @Column(name = "sample_output", length = -1)
    private String sampleOutput;

    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;

    @Basic
    @Column(name = "updated_on")
    private Timestamp updatedOn;

}
