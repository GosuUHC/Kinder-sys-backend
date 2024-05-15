package backend.service.group.dto;

public class GroupDTO {
    private Long id;

    public GroupDTO() {
    }

    public GroupDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
