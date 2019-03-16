package io.sisa.demo.api.v1.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by isaozturk on 16.03.2019
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BaseDTO implements Serializable {

    private Long id;
}
