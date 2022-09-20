package com.testapp.municipalitytax.repository;

import com.testapp.municipalitytax.entity.TaxEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaxesJpaRepository extends CrudRepository<TaxEntity, UUID>, QuerydslPredicateExecutor<TaxEntity> {
}
