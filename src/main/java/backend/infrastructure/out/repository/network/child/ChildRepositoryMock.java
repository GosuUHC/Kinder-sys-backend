package backend.infrastructure.out.repository.network.child;

import java.util.ArrayList;
import java.util.List;

import backend.infrastructure.out.repository.network.group.GroupRepositoryMock;
import backend.service.child.dto.ChildDTO;
import backend.service.child.interfaces.out.IChildRepository;
import backend.service.group.dto.GroupDTO;
import jakarta.inject.Inject;

public class ChildRepositoryMock implements IChildRepository {

    @Inject
    private GroupRepositoryMock groupRepository;

    @Override
    public List<ChildDTO> findChildrenByGroupId(Long groupId) {
        List<ChildDTO> children = new ArrayList<ChildDTO>();

        GroupDTO groupDTO = groupRepository.findGroupById(groupId);

        children.add(new ChildDTO(1L, groupDTO, "Иван" + groupDTO.getId(), "Иванович", "Иванов"));
        children.add(new ChildDTO(2L, groupDTO, "Петр" + groupDTO.getId(), "Петрович", "Петров"));
        children.add(new ChildDTO(3L, groupDTO, "Мария" + groupDTO.getId(), "Ивановна", "Сидорова"));

        return children;
    }

}
