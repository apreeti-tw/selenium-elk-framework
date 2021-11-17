package com.seleniumframeworks.builder;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ELKReportData {
    private String testname;
    private String status;
    private String executionTime;
    private String authors;
    private String categories;
}
