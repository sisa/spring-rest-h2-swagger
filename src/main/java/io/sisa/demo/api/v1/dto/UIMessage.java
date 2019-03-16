package io.sisa.demo.api.v1.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by isaozturk on 16.03.2019
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UIMessage implements Serializable {

    private String field;

    private String code;

    private String message;
}