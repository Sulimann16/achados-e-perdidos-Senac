package br.com.senac.achadosperdidos.model;

public class Item {

    private Long id;
    private String name;
    private String description;
    private String location;
    private String foundDate;
    private String status;

    public Item() {
    }

    public Item(Long id, String name, String description,
                String location, String foundDate, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.foundDate = foundDate;
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

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}