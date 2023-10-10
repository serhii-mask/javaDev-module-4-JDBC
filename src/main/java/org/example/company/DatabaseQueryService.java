package org.example.company;

import org.example.database.Database;
import org.example.elements.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Database database;

    public DatabaseQueryService(Database database) {
        this.database = database;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("./sql/find_max_salary_worker.sql"));

            try (Statement statement = database.getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int salary = resultSet.getInt("salary");

                    MaxSalaryWorker worker = new MaxSalaryWorker(name, salary);

                    result.add(worker);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("./sql/find_max_projects_client.sql"));

            try (Statement statement = database.getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int projectCount = resultSet.getInt("projects_client");

                    MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);

                    result.add(client);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("./sql/find_longest_project.sql"));


            try (Statement statement = database.getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int monthCount = resultSet.getInt("month_count");

                    LongestProject project = new LongestProject(name, monthCount);

                    result.add(project);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("./sql/find_youngest_eldest_workers.sql"));


            try (Statement statement = database.getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    String name = resultSet.getString("name");
                    String birthday = resultSet.getString("birthday");

                    YoungestEldestWorkers worker = new YoungestEldestWorkers(type, name, birthday);

                    result.add(worker);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<ProjectPrices> printProjectPrices() {
        List<ProjectPrices> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("./sql/print_project_prices.sql"));


            try (Statement statement = database.getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");

                    ProjectPrices project = new ProjectPrices(name, price);

                    result.add(project);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
