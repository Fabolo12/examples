package lesson26.exp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Account {
    private String id;
    private String ownerId;
    private Float amount;

    public Account(Float amount) {
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
