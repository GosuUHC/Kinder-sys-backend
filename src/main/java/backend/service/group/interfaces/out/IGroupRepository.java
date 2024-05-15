package backend.service.group.interfaces.out;

import java.util.List;

import backend.service.group.dto.GroupDTO;

public interface IGroupRepository {

    List<GroupDTO> findAllGroups();

    GroupDTO findGroupById(Long groupId);
}
