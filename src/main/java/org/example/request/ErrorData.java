package org.example.request;

import lombok.*;
import org.example.BaseBodyEntity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorData extends BaseBodyEntity {
    private String email;
}
