//package com.hyouka.school.utils;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPool,
//                                                         RedisStandaloneConfiguration jedisConfig) {
//        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(jedisConfig);
//        connectionFactory.setPoolConfig(jedisPool);
//        return connectionFactory;
//    }
//
//    @Configuration
//    public static class JedisConfig {
//        @Value("${spring.redis.host:127.0.0.1}")
//        private String host;
//        @Value("${spring.redis.port:6379}")
//        private Integer port;
//        @Value("${spring.redis.password:baobao123}")
//        private String password;
//        @Value("${spring.redis.database:0}")
//        private Integer database;
//
//        @Value("${spring.redis.jedis.pool.max-active:8}")
//        private Integer maxActive;
//        @Value("${spring.redis.jedis.pool.max-idle:8}")
//        private Integer maxIdle;
//        @Value("${spring.redis.jedis.pool.max-wait:-1}")
//        private Long maxWait;
//        @Value("${spring.redis.jedis.pool.min-idle:0}")
//        private Integer minIdle;
//
//        @Bean
//        public JedisPoolConfig jedisPool() {
//            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//            jedisPoolConfig.setMaxIdle(maxIdle);
//            jedisPoolConfig.setMaxTotal(maxActive);
//            jedisPoolConfig.setMaxWaitMillis(maxWait);
//            jedisPoolConfig.setMinIdle(minIdle);
//            return jedisPoolConfig;
//
//        }
//
//        @Bean
//        public RedisStandaloneConfiguration jedisConfig() {
//            RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
//            config.setHostName(host);
//            config.setPort(port);
//            config.setPassword(password);
//            config.setDatabase(database);
//            return config;
//        }
//
//
//    }
//
//}
