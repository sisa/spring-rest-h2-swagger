package io.sisa.demo.api.v1;

import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class RestErrorAttributes extends DefaultErrorAttributes{

    private final Tracer tracer;

    @Autowired
    public RestErrorAttributes(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {


        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("tracId",tracer.currentSpan().context().traceIdString());

        return errorAttributes;
    }
}
