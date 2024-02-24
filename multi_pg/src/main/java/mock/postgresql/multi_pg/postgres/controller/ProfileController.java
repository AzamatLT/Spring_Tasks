package mock.postgresql.multi_pg.postgres.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import mock.postgresql.multi_pg.postgres.model.Profile;
import mock.postgresql.multi_pg.postgres.model.ProfileRequest;
import mock.postgresql.multi_pg.postgres.service.ProfileService;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    private final ProfileService profileService;

    //Считает количество запросов
    private final AtomicLong counter_get = new AtomicLong();
    private final AtomicLong counter_put = new AtomicLong();
    private final AtomicLong counter_post = new AtomicLong();
    private final AtomicLong counter_delete = new AtomicLong();

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{personId:\\d+}")
    public Profile getProfile(@PathVariable int personId) {
    //    System.out.println("increment_get - " + counter_get.incrementAndGet());
        return profileService.getProfile(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody ProfileRequest request) {
        System.out.println("increment_post - " + counter_post.incrementAndGet());
        profileService.createProfile(
                request.firstName(),
                request.lastName(),
                request.age()
        );
    }

    @PutMapping(value = "/{personId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(
            @Valid @RequestBody ProfileRequest request,
            @PathVariable int personId
    ) {
        System.out.println("increment_put - " + counter_put.incrementAndGet());
        profileService.updateProfile(
                request.firstName(),
                request.lastName(),
                request.age(),
                personId
        );
    }

    @DeleteMapping(value = "/{personId:\\d+}")
    public void deleteProfile(@PathVariable int personId) {
        System.out.println("increment_delete - " + counter_delete.incrementAndGet());
        profileService.deleteProfile(personId);
    }
}
