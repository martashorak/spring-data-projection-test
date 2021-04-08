package com.example.demoprojection;

import org.assertj.core.api.Assertions;
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
        final ReportProjection report = reportRepository.getReportById(1L);
        Assertions.assertThat(report).isNotNull();
        Assertions.assertThat(report.getReportFormat()).isEqualTo(ReportFormat.CSV);

    }

    @Test
    void enumConversionNativeQueryJpa() {

        final ReportProjection report = reportRepository.getReportByIdNativeQuery(1L);
        Assertions.assertThat(report).isNotNull();
        Assertions.assertThat(report.getReportFormat()).isEqualTo(ReportFormat.CSV);
    }

}
