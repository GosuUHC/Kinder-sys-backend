package backend.infrastructure.builder;

import backend.service.user.interfaces.in.IUserService;
import backend.service.user.interfaces.out.repository.IUserRepository;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class UserBuilder {

    @Inject
    @Default
    private IUserRepository userRepository;

    @Inject
    @Default
    private IUserService userService;

    @Produces
    @Built
    public IUserService buildUserService() {
        userService.injectUserRepository(userRepository);
        return userService;
    }
}
