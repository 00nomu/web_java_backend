package web.backend.aop.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisCacheUtils<K, V> {

    private final RedisTemplate redisTemplate;
    private final static long MAX_SET_SIZE = 20;

    public V get(K key) {
        return (V) redisTemplate.opsForValue().get(key.toString());
    }

    public void set(K key, V value, String listName) {
        // 리스트에 저장
        // find all

        List<String> keys = redisTemplate.opsForList().range(listName, 0, -1);
        log.info("keys : {}" , keys);
        if (! keys.contains(key) ) {
            redisTemplate.opsForList().leftPush(listName, key.toString());
            if ( keys.size() > MAX_SET_SIZE) {
                // 가장 오래된 아이템 제거
                Object pop = redisTemplate.opsForList().rightPop(listName);
                redisTemplate.delete(pop);
            }
        }

        redisTemplate.opsForValue().set(key.toString() , value, Duration.ofMinutes(1L));
    }

    public void evict(String setName) {
        List<String> keys =  redisTemplate.opsForList().range(setName, 0, -1);

        log.info("evict keys {}" , keys);
        for (String key : keys) {
            redisTemplate.delete(key);
        }
        log.info("redisTemplate.delete {}" , setName);
        redisTemplate.delete(setName);
    }

}