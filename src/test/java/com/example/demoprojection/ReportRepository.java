package com.example.demoprojection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

interface ReportRepository extends CrudRepository<ReportEntity, Long> {
    @Query(value = "select ID, FORMAT reportFormat from report where id = :id", nativeQuery = true)
    ReportProjection getReportByIdNativeQuery(@Param("id") long id);


    @Query(value = "select re from ReportEntity re where re.id = :id")
    ReportProjection getReportById(@Param("id") long id);
}
