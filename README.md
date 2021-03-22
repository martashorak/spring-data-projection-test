Projection with enum conversion test
==================
Test com.example.demoprojection.ProjectionConverterTest.enumConversionNativeQueyrJpa is failing with spring version 2.4.4 but failing with version 2.3.9.RELEASE

In native query projection it was possible to register converter via share converter instance. Since version 2.4.x it is not possible anymore
Issue tracking
https://github.com/spring-projects/spring-data-commons/issues/2335


Before com.example.demoprojection.ReportFormat.ReportFormatConverter was registered in default conversion service com.example.demoprojection.DefaultConversionServiceInitializer.afterPropertiesSet and projection used it to convert result value to ReportFormat enum. 
