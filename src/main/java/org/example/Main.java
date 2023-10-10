package org.example;

import org.example.company.DatabaseQueryService;
import org.example.database.Database;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        DatabaseQueryService queryService = new DatabaseQueryService(database);

        System.out.println("FindMaxProjectsClient() = " + queryService.findMaxProjectsClient());
        System.out.println("FindMaxSalaryWorker() = " + queryService.findMaxSalaryWorker());
        System.out.println("FindLongestProject() = " + queryService.findLongestProject());
        System.out.println("FindYoungestEldestWorkers() = " + queryService.findYoungestEldestWorkers());
        System.out.println("PrintProjectPrices() = " + queryService.printProjectPrices());

        database.close();
    }
}