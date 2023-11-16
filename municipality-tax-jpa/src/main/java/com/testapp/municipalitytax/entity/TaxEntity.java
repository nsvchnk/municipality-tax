package com.testapp.municipalitytax.entity;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "taxes")
public class TaxEntity {

  @Id
  @Column(name = "id", updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "random_uuid()")
  private UUID id;

  @Column(name = "municipality")
  private String municipality;

  @Column(name = "tax")
  private Double tax;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  protected TaxEntity() {
    // JPA constructor
  }

  public TaxEntity(
      UUID id, String municipality, Double tax, LocalDate startDate, LocalDate endDate) {
    this.id = id;
    this.municipality = municipality;
    this.tax = tax;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public TaxEntity(TaxEntity taxEntity, String municipality) {
    this.id = taxEntity.getId();
    this.municipality = municipality;
    this.tax = taxEntity.getTax();
    this.startDate = taxEntity.getStartDate();
    this.endDate = taxEntity.getEndDate();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TaxEntity taxes = (TaxEntity) o;

    return id.equals(taxes.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  public UUID getId() {
    return id;
  }

  public String getMunicipality() {
    return municipality;
  }

  public Double getTax() {
    return tax;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }
}
