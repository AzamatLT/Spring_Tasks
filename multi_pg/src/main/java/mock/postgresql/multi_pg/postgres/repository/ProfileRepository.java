package mock.postgresql.multi_pg.postgres.repository;

import mock.postgresql.multi_pg.postgres.model.Profile;

import java.util.Optional;

public interface ProfileRepository {

    Optional<Profile> getProfileById(int id);

    void insertProfile(String firstName, String secondName, int age);

    void updateProfile(String firstName, String secondName, int age, int id);

    void deleteProfileById(int id);
}
