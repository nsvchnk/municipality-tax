package com.testapp.municipalitytax.repository;

import com.testapp.municipalitytax.entity.TaxesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaxesJpaRepository extends CrudRepository<TaxesEntity, UUID> {
}
