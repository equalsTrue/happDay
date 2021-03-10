package com.cloud.alibaba.config.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author david
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host:127.0.0.1}")
    private String host;
    @Value("${spring.redis.port:6379}")
    private int port;
    @Value("${spring.redis.timeout:6000}")
    private int timeout;
    @Value("${spring.redis.database:10}")
    private int database;

    /**
     * pool映射
     */
    @Value("${spring.redis.lettuce.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.lettuce.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.lettuce.pool.min-idle}")
    private int minIdle;
    @Value("${spring.redis.lettuce.pool.max-wait}")
    private int maxWait;

//
//    /**
//     * sentinel
//     */
//    @Value("${spring.redis.sentinel.master:mymaster}")
//    private String master;
//
//
//    @Value("${spring.redis.sentinel.nodes}")
//    private String sentinelNodes;

    /**
     * 1.设置连接池
     * 2.设置config
     * 3.创建工厂
     * 4.创建Redistemplate
     */

//    /**
//     * 设置连接池
//     * @return
//     */
//    @Bean("redisPool")
//    public GenericObjectPoolConfig redisPool(){
//        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//        config.setMaxIdle(maxIdle);
//        config.setMinIdle(minIdle);
//        config.setMaxWaitMillis(maxWait);
//        config.setMaxTotal(maxActive);
//        return config;
//    }


//    /**
//     * 集群配置
//     * @return
//     */
//    @Bean("redisClusterConfig")
//    public RedisClusterConfiguration redisClusterConfig(){
//        List<String> redisNodeList = Arrays.asList(cluterNodes.split(","));
//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisNodeList);
//        redisClusterConfiguration.setMaxRedirects(maxRedirects);
//        redisClusterConfiguration.setPassword(RedisPassword.of(password));
//        return redisClusterConfiguration;
//    }
//
//    /**
//     * 集群工厂
//     * @param poolConfig
//     * @param redisClusterConfig
//     * @return
//     */
//    @Bean("clusterFactory")
//    public LettuceConnectionFactory factory(@Qualifier("redisPool") GenericObjectPoolConfig poolConfig,@Qualifier("redisClusterConfig") RedisClusterConfiguration redisClusterConfig){
//        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(poolConfig).build();
//        return new LettuceConnectionFactory(redisClusterConfig,clientConfiguration);
//    }
//
//    /**
//     * 集群模式下的redisTemplate
//     * @param factory
//     * @return
//     */
//    @Bean("clusterTemplate")
//    public StringRedisTemplate redisClusterTemplate(@Qualifier("clusterFactory")RedisConnectionFactory factory){
//        return new StringRedisTemplate(factory);
//    }
//
    /**
     * 单例模式连接池配置
     * @return
     */
    @Bean("singlePoolConfig")
    public GenericObjectPoolConfig singlePoolConfig(){
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        return poolConfig;
    }

    /**
     * 单例模式redis配置
     * @return
     */
    @Bean("singleRedisConfig")
    public RedisStandaloneConfiguration redisStandaloneConfig(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setPort(port);
        configuration.setHostName(host);
        configuration.setDatabase(database);
        return configuration;
    }

    /**
     * 单例模式工厂
     * @param poolConfig
     * @param redisConfig
     * @return
     */
    @Bean("singleFactory")
    public LettuceConnectionFactory singleFactory(@Qualifier("singlePoolConfig")GenericObjectPoolConfig poolConfig,@Qualifier("singleRedisConfig")RedisStandaloneConfiguration redisConfig){
        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(poolConfig).build();
        return new LettuceConnectionFactory(redisConfig,clientConfiguration);
    }

    /**
     * 单例模式template
     * @param singleFactory
     * @return
     */
    @Bean("singleTemplate")
    public StringRedisTemplate stringRedisTemplate(@Qualifier("singleFactory")RedisConnectionFactory singleFactory){
        return new StringRedisTemplate(singleFactory);
    }


//    /**
//     * 哨兵模式连接池
//     */
//
//    @Bean("sentinelPoolConfig")
//    @Primary
//    public GenericObjectPoolConfig sentinelPoolConfig(){
//        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//        poolConfig.setMaxWaitMillis(maxWait);
//        poolConfig.setMaxTotal(maxActive);
//        poolConfig.setMaxIdle(maxIdle);
//        poolConfig.setMinIdle(minIdle);
//        return poolConfig;
//    }
//
//
//    /**
//     * 哨兵模式redis 配置
//     */
//    @Bean("sentinelRedisConfig")
//    @Primary
//    public RedisSentinelConfiguration sentineConfig(){
//        RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();
//        redisConfig.setMaster(master);
//        redisConfig.setDatabase(database);
//        redisConfig.setPassword(RedisPassword.of(password));
//        List<RedisNode> redisNodeList = new ArrayList<RedisNode>();
//        List<String> sentinelNodeList = Arrays.asList(sentinelNodes.split(","));
//        for(String node:sentinelNodeList){
//            String[] arr = node.split(":");
//            redisNodeList.add(new RedisNode(arr[0],Integer.valueOf(arr[1])));
//        }
//        redisConfig.setSentinels(redisNodeList);
//        return redisConfig;
//    }
//
//
//    /**
//     * 哨兵模式连接工厂
//     * @param poolConfig
//     * @param redisConfig
//     * @return
//     */
//    @Bean("sentineFactory")
//    @Primary
//    public LettuceConnectionFactory sentineFactory(@Qualifier("sentinelPoolConfig")GenericObjectPoolConfig poolConfig,
//                                                   @Qualifier("sentinelRedisConfig")RedisSentinelConfiguration redisConfig){
//        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(poolConfig).build();
//        return new LettuceConnectionFactory(redisConfig,clientConfiguration);
//    }
//
//    /**
//     * 哨兵模式redisTemplate
//     * @param factory
//     * @return
//     */
//    @Bean("sentineTemplate")
//    @Primary
//    public StringRedisTemplate sentineTemplate(@Qualifier("sentineFactory")RedisConnectionFactory factory){
//        return new StringRedisTemplate(factory);
//    }






}
