package backend.service.child.dto;

import backend.service.group.dto.GroupDTO;

public class ChildDTO {
    private Long id;
    private GroupDTO group;
    private String firstName;
    private String middleName;
    private String lastName;

    public ChildDTO() {
    }

    public ChildDTO(Long id, GroupDTO group, String firstName, String middleName, String lastName) {
        this.id = id;
        this.group = group;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
