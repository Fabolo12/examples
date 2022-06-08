package lesson35.simple.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public final class User {
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
