package com.jkb.transformationservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "connector_extra_options", schema = "tps", catalog = "")
@Data
public class ConnectorExtraOptions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "connector_id", nullable = false)
    private int connectorId;


    @Basic
    @Column(name = "option_key", nullable = false, length = 255)
    private String optionKey;


    @Basic
    @Column(name = "option_value", nullable = false, length = 255)
    private String optionValue;

    @ManyToOne(cascade = CascadeType.ALL)
    private Connectors connector;

    public Connectors getConnector() {
        return connector;
    }

    public void setConnector(Connectors connector) {
        this.connector = connector;
    }

}
