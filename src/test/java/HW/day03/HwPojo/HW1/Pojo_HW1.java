package HW.day03.HwPojo.HW1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pojo_HW1 {
    public Pojo_HW1() {
    }

    private String name;
    private String job;

    public Pojo_HW1(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
