package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {
    /*
POJO = plain Old Java Object -----> Perfect template to create instances

    1.  Create private variables for each field
    2. Create constructors with parameters and without parameter
    3.  Create Getters and Setter
    4.  Create ToString
 */
    //Create private variables for each field
    //Create constructors with parameters and without parameters
    //Create Getters and Setters
    //Create ToString


    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;


    public JsonPlaceHolderPojo(){

    }


    public JsonPlaceHolderPojo(Integer userId,String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;

    }
    public JsonPlaceHolderPojo(Integer userId, Integer id ,String title, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}