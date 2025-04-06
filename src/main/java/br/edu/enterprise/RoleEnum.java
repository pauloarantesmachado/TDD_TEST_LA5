package br.edu.enterprise;

import lombok.Getter;

@Getter
public enum RoleEnum {
    DBA(2000.0, 0.75, 0.85),
    TESTER(2000.0, 0.75, 0.85),
    MANAGER(5000.0, 0.7, 0.8),
    DEVELOPER(3000.0, 0.8, 0.9);

    private Double limit;
    private Double rateSuperior;
    private Double lowerRate;

    RoleEnum(Double limit, Double rateSuperior, Double lowerRate) {
        this.limit = limit;
        this.rateSuperior = rateSuperior;
        this.lowerRate = lowerRate;
    }
}
