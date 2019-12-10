import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "email")
public class Account {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public LocalDate birthday;
    public Sex sex;
    public LocalDate creationDate;
    public BigDecimal balance = BigDecimal.ZERO;
}

enum Sex {
    MALE,
    FEMALE
}