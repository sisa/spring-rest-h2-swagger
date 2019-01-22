package io.sisa.demo.api.v1;

import brave.Tracer;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
@AllArgsConstructor
public class RestErrorAttributes extends DefaultErrorAttributes{

    private final Tracer tracer;

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {


        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("tracId",tracer.currentSpan().context().traceIdString());

        return errorAttributes;
    }
}
