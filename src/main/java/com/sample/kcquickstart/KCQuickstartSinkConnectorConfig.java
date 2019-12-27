package com.sample.kcquickstart;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

public class KCQuickstartSinkConnectorConfig extends AbstractConfig {

	public static final String TOPICS = "topics";

	static final String TOPICS_DOC = "Topic the connector is listening from.";

	public final String topic;

	public KCQuickstartSinkConnectorConfig(Map<String, String> parsedConfig) {
	    super(conf(), parsedConfig);
	    this.topic = this.getString(TOPICS);
	  }

	public static ConfigDef conf() {
		return new ConfigDef()
				.define(TOPICS, Type.STRING, Importance.HIGH, TOPICS_DOC);
	}

}
