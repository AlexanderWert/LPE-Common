/**
 * Copyright 2014 SAP AG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aim.artifacts.records;

import org.aim.api.measurement.AbstractRecord;
import org.aim.api.measurement.RecordValue;

/**
 * Records for monitoring waiting times, like monitor waits.
 * 
 * @author Henning Schulz
 * 
 */
public class EventTimeStampRecord extends AbstractRecord {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8172433493460433334L;

	public static final String PAR_EVENT_TYPE = "eventType";

	public static final String PAR_LOCATION = "location";

	public static final String PAR_MICRO_TIMESTAMP = "eventNanoTimestamp";

	/**
	 * Default constructor required for programmatic instantiation.
	 */
	public EventTimeStampRecord() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param timestamp
	 *            timestamp of record
	 * @param location
	 *            location of the monitor
	 * @param waitingTime
	 *            timespan the thread had to wait
	 */
	public EventTimeStampRecord(long timestamp, String eventType, String location, long microTimestamp) {
		super(timestamp);
		this.eventType = eventType;
		this.location = location;
		this.eventNanoTimestamp = microTimestamp;
	}

	@RecordValue(name = PAR_EVENT_TYPE)
	String eventType;

	@RecordValue(name = PAR_LOCATION)
	String location;

	@RecordValue(name = PAR_MICRO_TIMESTAMP)
	long eventNanoTimestamp;

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the monitorClass
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the monitorClass to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the microTimestamp
	 */
	public long getEventNanoTimestamp() {
		return eventNanoTimestamp;
	}

	/**
	 * @param microTimestamp
	 *            the microTimestamp to set
	 */
	public void setEventNanoTimestamp(long microTimestamp) {
		this.eventNanoTimestamp = microTimestamp;
	}

}
