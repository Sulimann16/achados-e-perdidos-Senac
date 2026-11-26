package br.com.senac.achadosperdidos.model;

public class LostItem {

    private Long id;
    private String name;
    private String description;
    private String location;
    private String lostDate;
    private String status;

    public LostItem() {
    }

    public LostItem(Long id, String name, String description,
                    String location, String lostDate, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.lostDate = lostDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLostDate() {
        return lostDate;
    }

    public void setLostDate(String lostDate) {
        this.lostDate = lostDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}