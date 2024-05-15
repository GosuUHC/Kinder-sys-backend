package backend.service.group.impl;

import java.util.List;

import backend.service.group.dto.GroupDTO;
import backend.service.group.interfaces.in.IGroupService;
import backend.service.group.interfaces.out.IGroupRepository;

public class GroupService implements IGroupService {

    private IGroupRepository groupRepository;

    @Override
    public List<GroupDTO> findAllGroups() {
        return groupRepository.findAllGroups();
    }

    @Override
    public GroupDTO findGroupById(Long groupId) {
        return groupRepository.findGroupById(groupId);
    }

    @Override
    public void injectGroupRepository(IGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

}
