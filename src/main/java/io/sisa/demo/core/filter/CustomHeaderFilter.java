package io.sisa.demo.core.filter;

import brave.Tracer;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by isaozturk on 16.03.2019
 */
@Component
public class CustomHeaderFilter implements Filter {

    private final Tracer tracer;

    private static String TRACE_ID = "X-B3-TraceId";

    public CustomHeaderFilter(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.addHeader(TRACE_ID, tracer.currentSpan().context().traceIdString());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }
}
