package com.jkb.transformationservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Routes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", length = 255)
    private String name;
    @Basic
    @Column(name = "source_name", length = 255)
    private String sourceName;
    @Basic
    @Column(name = "direction", nullable = false)
    private DIRECTIONS direction;

    @Basic
    @Column(name = "environment", length = 255)
    private String environment;

    @Basic
    @Column(name = "in_connector_id")
    private Integer inConnectorId;
    @Basic
    @Column(name = "out_connector_id")
    private Integer outConnectorId;

    @Basic
    @Column(name = "msg_type", length = 255)
    private String msgType;

    @Basic
    @Column(name = "is_dynamic")
    private Byte isDynamic;

    @Basic
    @Column(name = "workflow_id", nullable = false)
    private int workflowId;

    @Basic
    @Column(name = "next_route_id")
    private Integer nextRouteId;

    @Basic
    @Column(name = "status")
    private Byte status;

    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;

    @Basic
    @Column(name = "updated_on")
    private Timestamp updatedOn;

    private enum DIRECTIONS{
        IN, OUT;
    }
}
