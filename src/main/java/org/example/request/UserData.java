package org.example.request;

import lombok.*;
import org.example.BaseBodyEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserData extends BaseBodyEntity {
    private String email;
    private String password;
}
