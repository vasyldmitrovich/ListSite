package org.list_of_deals.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        filterName = "CharsetFilter",
        urlPatterns = "/*",
        initParams = @WebInitParam(name = "requestEncoding", value = "UTF-8")
)
public class CharsetFilter implements Filter {

    private String encoding;

    @Override
    public void init(FilterConfig config) throws ServletException {

        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {

        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        next.doFilter(request, response);
    }

    public void destroy() {
    }
}
