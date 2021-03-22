package com.example.demoprojection;


import javax.persistence.*;

@Table(name = "REPORT", schema = "TEST_OWNER")
@Entity
class ReportEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ReportId")
    @SequenceGenerator(name = "ReportId", sequenceName = "REPORT_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "FORMAT", nullable = false)
    private ReportFormat reportFormat;

    public Long getId() {
        return id;
    }

    public ReportFormat getReportFormat() {
        return reportFormat;
    }

    public void setReportFormat(ReportFormat reportFormat) {
        this.reportFormat = reportFormat;
    }
}
