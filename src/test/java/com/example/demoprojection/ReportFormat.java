package com.example.demoprojection;

import org.springframework.core.convert.converter.Converter;

import javax.persistence.AttributeConverter;
import java.math.BigDecimal;
import java.math.BigInteger;

enum ReportFormat {
    CSV(2, "Csv report"),
    XML(4, "XML report");

    private final Integer code;
    private final String description;

    ReportFormat(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static class ReportFormatConverter implements Converter<BigInteger, ReportFormat> {
        @Override
        public ReportFormat convert(BigInteger reportTypeCode) {
            return fromCode(reportTypeCode.intValue());
        }
    }

    @javax.persistence.Converter(autoApply = true)
    public static class ReportSubscriptionStateEnumJpaConverter implements AttributeConverter<ReportFormat, Long> {
        @Override
        public Long convertToDatabaseColumn(ReportFormat reportSubscriptionStateEnum) {
            return Long.valueOf(reportSubscriptionStateEnum.code);
        }

        @Override
        public ReportFormat convertToEntityAttribute(Long enumCode) {
            return fromCode(enumCode.intValue());
        }
    }

    private static ReportFormat fromCode(Integer reportTypeCode) {
        for (ReportFormat value : ReportFormat.values()) {
            if (value.code.equals(reportTypeCode)) {
                return value;
            }
        }
        return null;
    }
}
