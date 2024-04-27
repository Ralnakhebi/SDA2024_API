package HW.day03.HwPojo.HW5;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetPojo_HW5 {

    private Integer id;
    private PetCategoryPojo_HW5 category;
    private String name;
    private List<String> photoUrls;
    private List<PetTagPojo_HW5> tags;
    private String status;

    public PetPojo_HW5() {
    }

    public PetPojo_HW5(Integer id, PetCategoryPojo_HW5 category, String name, List<String> photoUrls, List<PetTagPojo_HW5> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PetCategoryPojo_HW5 getCategory() {
        return category;
    }

    public void setCategory(PetCategoryPojo_HW5 category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<PetTagPojo_HW5> getTags() {
        return tags;
    }

    public void setTags(List<PetTagPojo_HW5> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
