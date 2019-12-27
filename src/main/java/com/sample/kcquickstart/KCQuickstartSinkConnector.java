package com.sample.kcquickstart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.utils.AppInfoParser;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KCQuickstartSinkConnector extends SinkConnector {

	private static Logger log = LoggerFactory.getLogger(KCQuickstartSinkConnector.class);

	Map<String, String> settings;
	
	private KCQuickstartSinkConnectorConfig config;

	@Override
	public String version() {
		return AppInfoParser.getVersion();
	}

	@Override
	public void start(Map<String, String> props) {
		log.info("Starting KCQuickstartSinkConnectorConfig");
		this.config = new KCQuickstartSinkConnectorConfig(props);
		this.settings = props;

	}

	@Override
	public Class<? extends Task> taskClass() {

		return KCQuickstartSinkTask.class;
	}

	@Override
	public List<Map<String, String>> taskConfigs(int maxTasks) {
		List<Map<String, String>> configs = new ArrayList();
		for (int i = 0; i < maxTasks; i++) {
			configs.add(this.settings);
		}
		return configs;
	}

	@Override
	public void stop() {
		
	}

	@Override
	public ConfigDef config() {
		return KCQuickstartSinkConnectorConfig.conf();
	}

}
