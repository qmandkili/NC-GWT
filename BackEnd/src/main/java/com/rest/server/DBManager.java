package com.rest.server;

import java.math.BigInteger;
import java.util.List;

import com.model.shared.Device;

public interface DBManager {

	public void addDevice(Device device);

	public List<Device> getAllDevices();

	public Device getDevice(BigInteger id);

	public void updateDevice(Device device);

	public void deleteDevice(BigInteger id);
}
