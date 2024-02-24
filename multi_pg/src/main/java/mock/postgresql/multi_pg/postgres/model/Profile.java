package mock.postgresql.multi_pg.postgres.model;

public record Profile(
        int id,
        String firstName,
        String lastName,
        int age
) {
}
