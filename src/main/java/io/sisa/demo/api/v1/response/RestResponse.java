package io.sisa.demo.api.v1.response;

import io.sisa.demo.api.v1.dto.UIMessage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isaozturk on 16.03.2019
 */
@Data
@NoArgsConstructor
public class RestResponse<T> {

    private T content;

    private List<UIMessage> messages = new ArrayList<>();

    private RestResponse(T content) {
        this.content = content;
    }

    private RestResponse(T content, List<UIMessage> messages) {
        this.content = content;
        this.messages = messages;
    }

    public static <T> RestResponse<T> of(T t) {
        return new RestResponse<>(t);
    }

    public static <T> RestResponse<T> of(T t, List<UIMessage> messages) {
        return new RestResponse<>(t, messages);
    }
}
