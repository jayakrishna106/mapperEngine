package com.jkb.transformationservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(com.jkb.transformationservice.entity.RulesPK.class)
public class Rules {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rule_id", nullable = false, length = 255)
    private String ruleId;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rule_namespace", nullable = false, length = 255)
    private String ruleNamespace;

    public String getRuleNamespace() {
        return ruleNamespace;
    }

    public void setRuleNamespace(String ruleNamespace) {
        this.ruleNamespace = ruleNamespace;
    }

    @Basic
    @Column(name = "action", length = 255)
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "condition", length = 255)
    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "description", length = 255)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "priority")
    private Integer priority;

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rules rules = (Rules) o;
        return Objects.equals(ruleId, rules.ruleId) && Objects.equals(ruleNamespace, rules.ruleNamespace) && Objects.equals(action, rules.action) && Objects.equals(condition, rules.condition) && Objects.equals(description, rules.description) && Objects.equals(priority, rules.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleId, ruleNamespace, action, condition, description, priority);
    }
}
