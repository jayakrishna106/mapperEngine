package com.jkb.transformationservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Connectors {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Basic
    @Column(name = "type", nullable = false)
    private String type;

    @Basic
    @Column(name = "service_type", length = 128)
    private String serviceType;

    @Basic
    @Column(name = "status")
    private Byte status;

    @Basic
    @Column(name = "version", nullable = false)
    private int version;

    @Basic
    @Column(name = "environment", length = 255)
    private String environment;

    @Basic
    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;

    @Basic
    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Basic
    @Column(name = "updated_on")
    private Timestamp updatedOn;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "connector")
    private Collection<ConnectorConfigs> connectorConfigs;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "connector")
    private Collection<ConnectorExtraOptions> connectorExtraOptions;


}
