package mock.postgresql.multi_pg.postgres.service;

import mock.postgresql.multi_pg.postgres.model.Profile;

public interface ProfileService {

    Profile getProfile(int personId);

    void createProfile(String firstName, String secondName, int age);

    void updateProfile(String firstName, String secondName, int age, int id);

    void deleteProfile(int id);
}
