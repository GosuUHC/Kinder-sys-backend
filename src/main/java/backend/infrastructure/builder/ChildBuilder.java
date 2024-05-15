package backend.infrastructure.builder;

import backend.service.child.interfaces.in.IChildService;
import backend.service.child.interfaces.out.IChildRepository;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class ChildBuilder {

    @Inject
    @Default
    private IChildRepository childRepository;

    @Inject
    @Default
    private IChildService childService;

    @Produces
    @Built
    public IChildService buildChildService() {
        childService.injectChildRepository(childRepository);
        return childService;
    }
}
