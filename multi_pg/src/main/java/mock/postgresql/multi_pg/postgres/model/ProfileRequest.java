package mock.postgresql.multi_pg.postgres.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProfileRequest(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        @Min(1)
        Integer age
) {
}
