package com.sample.kcquickstart;

import java.util.Collection;
import java.util.Map;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.utils.AppInfoParser;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KCQuickstartSinkTask extends SinkTask {

	private static Logger log = LoggerFactory.getLogger(KCQuickstartSinkTask.class);

	private KCQuickstartSinkConnectorConfig connectorConfig;

	public String version() {
		return AppInfoParser.getVersion();
	}

	@Override
	public void start(Map<String, String> props) {
		this.connectorConfig = new KCQuickstartSinkConnectorConfig(props);
		log.warn("KCQuickstartSinkTask Started..");

	}

	@Override
	public void put(Collection<SinkRecord> records) {
		System.out.println("Total records fetched: " + records.size());
		for (SinkRecord sr : records) {
			System.out.println("Record value: " + sr.value());
		}
		// More logic goes here, which will send these records to a target system
		log.info("KCQuickstartSinkTask Completed..");
	}

	@Override
	public void flush(Map<TopicPartition, OffsetAndMetadata> offsets) {
	}

	@Override
	public void stop() {
		log.warn("KCQuickstartSinkTask Stopping..");

	}

}
