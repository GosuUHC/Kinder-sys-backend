package backend.infrastructure.out.repository.network.group;

import java.util.ArrayList;
import java.util.List;

import backend.service.group.dto.GroupDTO;
import backend.service.group.interfaces.out.IGroupRepository;

public class GroupRepositoryMock implements IGroupRepository {

    @Override
    public List<GroupDTO> findAllGroups() {
        List<GroupDTO> groups = new ArrayList<GroupDTO>();

        groups.add(new GroupDTO(1L));
        groups.add(new GroupDTO(2L));
        groups.add(new GroupDTO(3L));

        return groups;
    }

    @Override
    public GroupDTO findGroupById(Long groupId) {
        return new GroupDTO(groupId);
    }

}
