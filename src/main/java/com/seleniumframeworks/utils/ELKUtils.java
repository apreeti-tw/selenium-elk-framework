package com.seleniumframeworks.utils;

import com.seleniumframeworks.builder.ELKReportData;
import com.seleniumframeworks.enums.CategoryTypes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.time.LocalDateTime;
import java.util.Arrays;

import static com.seleniumframeworks.utils.RandomUtils.getElasticsearchURL;

public final class ELKUtils {
    private ELKUtils(){}

    public static void sendResultsToELK(String methodName, String status, String[] authors, CategoryTypes[] categories) {
        ELKReportData elkReportData = new ELKReportData();
        elkReportData.setTestname(methodName);
        elkReportData.setStatus(status);
        elkReportData.setAuthors(Arrays.toString(authors));
        elkReportData.setCategories(Arrays.toString(categories));
        elkReportData.setExecutionTime(LocalDateTime.now().toString());

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(elkReportData)
                .post(getElasticsearchURL())
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);
    }
}
