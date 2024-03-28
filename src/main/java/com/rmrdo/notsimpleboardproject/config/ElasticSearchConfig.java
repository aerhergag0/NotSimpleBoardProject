package com.rmrdo.notsimpleboardproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.mapping.model.FieldNamingStrategy;
import org.springframework.data.mapping.model.SnakeCaseFieldNamingStrategy;

@PropertySource(value = "classpath:application-key.yml", factory = YamlPropertySourceFactory.class)
@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {

	@Value("${elasticsearch.url}")
	String url;

	@Value("${elasticsearch.username}")
	String esUserName;

	@Value("${elasticsearch.password}")
	String esPassword;

	@Override
	public ClientConfiguration clientConfiguration() {
		return ClientConfiguration.builder()
				.connectedTo(url)
				.withBasicAuth(esUserName, esPassword)
				.build();
	}

	@Override
	protected FieldNamingStrategy fieldNamingStrategy() {
		return new SnakeCaseFieldNamingStrategy();
	}
}
