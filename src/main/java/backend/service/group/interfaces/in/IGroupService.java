package backend.service.group.interfaces.in;

import java.util.List;

import backend.service.group.dto.GroupDTO;
import backend.service.group.interfaces.out.IGroupRepository;

public interface IGroupService {

    List<GroupDTO> findAllGroups();

    GroupDTO findGroupById(Long groupId);

    public void injectGroupRepository(IGroupRepository groupRepository);
}
