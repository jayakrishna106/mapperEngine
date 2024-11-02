package com.jkb.transformationservice.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "connector_configs", schema = "tps", catalog = "")
public class ConnectorConfigs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "connector_id", nullable = false)
    private int connectorId;

    @Basic
    @Column(name = "config_key", nullable = false, length = 255)
    private String configKey;

    @Basic
    @Column(name = "config_value", nullable = false, length = 1024)
    private String configValue;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Connectors connector;

}
