package com.example.demoprojection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;


@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest(includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class, Component.class})})
@ActiveProfiles("test")
@Sql(scripts = {"/data.sql"})
class ProjectionConverterTest {

    @Autowired
    ReportRepository reportRepository;

    @Test
    void enumConversionJpa() {
        final ReportProjection reportEntityById = reportRepository.getReportById(1L);
        System.out.println(reportEntityById.getReportFormat());
    }

    @Test
    void enumConversionNativeQueyrJpa() {

        final ReportProjection report = reportRepository.getReportByIdNativeQuery(1L);
        System.out.println(report.getReportFormat());
    }

}
