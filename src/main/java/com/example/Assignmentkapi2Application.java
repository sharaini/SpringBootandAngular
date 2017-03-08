package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.cache.CacheManager;

import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
@SpringBootApplication
@EnableCaching
public class Assignmentkapi2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignmentkapi2Application.class, args);
	}
	
	@Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
      @Override
      public void customize(CacheManager cacheManager)
      {
        cacheManager.createCache("applicants", new MutableConfiguration<>()
          .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 10)))
          .setStoreByValue(false)
          .setStatisticsEnabled(true));
      }
    }
}
