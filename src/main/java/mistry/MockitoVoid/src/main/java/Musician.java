package mistry.MockitoVoid.src.main.java;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;


@EqualsAndHashCode
@ToString
public class Musician {

    private BigDecimal score;

    public BigDecimal getScore() {
        return score;
    }
}
