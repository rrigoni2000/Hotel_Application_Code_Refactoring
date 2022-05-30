package it.unibz.src.extra;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Extra {
    private final int code;
    private final double unitaryPrice;
    private final String name;

    public Extra(@JsonProperty("code") int code, @JsonProperty("unitaryPrice") double unitaryPrice, @JsonProperty("name") String name) {
        this.code = code;
        this.unitaryPrice = unitaryPrice;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public double getUnitaryPrice() {
        return unitaryPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Extra)) return false;
        Extra extra = (Extra) o;
        return getCode() == extra.getCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    public String getExtraDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(this.name).append("\n");
        builder.append("Code: ").append(this.code).append("\n");
        builder.append("Unitary Price: ").append(this.unitaryPrice).append("\n");
        return builder.toString();
    }
}
