package backend.service.child.interfaces.out;

import java.util.List;

import backend.service.child.dto.ChildDTO;

public interface IChildRepository {
    List<ChildDTO> findChildrenByGroupId(Long groupId);
}
