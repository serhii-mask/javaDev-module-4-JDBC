package org.example.company;

import org.example.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DatabasePopulateService {

    public static void main(String[] args) {
        try {
            String sql = Files.readString(Path.of("./sql/populate_db.sql"));

            Database.getInstance().executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}