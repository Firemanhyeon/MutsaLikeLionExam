package org.example.profile;

public class DataService {
    private String enviroment;

    public DataService(String enviroment) {
        this.enviroment = enviroment;
    }

    public String getEnviroment() {
        return enviroment;
    }
}
