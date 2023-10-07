package org.example.request;

import lombok.Getter;
import java.util.Random;

@Getter
public enum PasswordOptions {
    Antimateria("Antimateria"),
    Proton("Proton"),
    Izotop("Izotop");

   public final String name;

    PasswordOptions(String name) {
        this.name = name;
    }

    public static PasswordOptions getRandomPassword() {
        PasswordOptions[] values = PasswordOptions.values();
        return values[new Random().nextInt(values.length)];
    }
}
