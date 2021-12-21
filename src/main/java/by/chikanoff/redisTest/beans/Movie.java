package by.chikanoff.redisTest.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RedisHash(value = "Movie", timeToLive = 300)
public class Movie implements Serializable {

    private String id;
    private String name;
}
