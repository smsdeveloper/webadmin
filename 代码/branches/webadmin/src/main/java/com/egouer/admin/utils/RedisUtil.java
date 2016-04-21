package com.egouer.admin.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("redisUtil")
public class RedisUtil {

	private RedisTemplate<?, ?> redisTemplate;

	public RedisTemplate<?, ?> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<?, ?> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public void setEx(final String key,final long seconds,final String value)
	{
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) {
				connection.setEx(key.getBytes(), seconds, value.getBytes());
				return null;
			}
		}, true);
	}
	
	public String get(final String key)
	{
		return redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] b = connection.get(key.getBytes());
				if(null == b)
				{
					return null;
				}
				return new String(b);
			}
		});
	}
	
	public boolean remove(final String key)
	{
		Long num = redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) {
				return connection.del(key.getBytes());
			}
		}, true);
		if(num != null && num == 0)
		{
			return true;
		}
		return false;
	}
}
