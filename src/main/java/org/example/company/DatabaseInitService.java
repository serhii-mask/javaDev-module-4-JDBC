package org.example.company;

import org.example.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DatabaseInitService {

    public static void main(String[] args) {
        try {
            String sql = Files.readString(Path.of("./sql/init_db.sql"));

            Database.getInstance().initDB(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}