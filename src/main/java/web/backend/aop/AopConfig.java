package web.backend.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.backend.aop.trace.logtrace.LogTrace;
import web.backend.aop.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class AopConfig {

    @Bean
    public BasicAspect basicAspect() {
        return new BasicAspect();
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

    @Bean
    public LogTraceAspect logTraceAspect() {
        return new LogTraceAspect(logTrace());
    }

    @Bean
    public RetryAspect retryAspect() { return new RetryAspect(); }
}
