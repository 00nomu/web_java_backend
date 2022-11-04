package mobile.backend.aop.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.util.ObjectUtils;
import mobile.backend.annotation.redis.RedisListCacheEvict;
import mobile.backend.annotation.redis.RedisListCacheable;

@Slf4j
@Aspect
@RequiredArgsConstructor
@Order(0)
public class RedisAspect {

    private final RedisCacheUtils redisCacheUtils;

    @Around("@annotation(redisListCacheable)")
    public Object listCacheable(ProceedingJoinPoint joinPoint, RedisListCacheable redisListCacheable) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String key = redisListCacheable.value();
        Object[] args = joinPoint.getArgs();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            str.append(args[i]);
            if(i != args.length)
                str.append(":");

        }
        if (args.length > 0) {

            key = key + str;

        } else {
            key = key + "noArgs[]";
        }

        log.info("key {}   , join point args : {}", key, joinPoint.getArgs());
        Object result = redisCacheUtils.get(key);
        if (ObjectUtils.isEmpty(result)) {
            result = joinPoint.proceed();
            redisCacheUtils.set(key, result, redisListCacheable.value());
        }
        return result;
    }

    @Around("@annotation(redisListCacheEvict)")
    public Object listCacheEvict(ProceedingJoinPoint joinPoint, RedisListCacheEvict redisListCacheEvict) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("RedisListCacheEvict value : {}", redisListCacheEvict.value());
        redisCacheUtils.evict(redisListCacheEvict.value());
        return joinPoint.proceed();

    }
}
