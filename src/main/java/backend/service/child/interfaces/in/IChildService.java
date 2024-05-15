package backend.service.child.interfaces.in;

import java.util.List;

import backend.service.child.dto.ChildDTO;
import backend.service.child.interfaces.out.IChildRepository;

public interface IChildService {

    List<ChildDTO> findChildrenByGroupId(Long groupId);

    public void injectChildRepository(IChildRepository childRepository);
}
