package mobile.backend;
import mobile.backend.aws.S3Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import mobile.backend.aop.AopConfig;
import mobile.backend.interceptor.LogInterceptor;
import mobile.backend.annotation.redis.RedisConfig;

@Configuration
@Import({AopConfig.class, RedisConfig.class, S3Config.class})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/css/**", "/*.ico"
                        , "/error", "/error-page/**" //오류 페이지 경로
                );
    }
}