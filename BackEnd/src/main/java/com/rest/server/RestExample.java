package com.rest.server;

import java.math.BigInteger;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.shared.Device;
import com.model.shared.TestDto;


@RestController
public class RestExample {
	
	@RequestMapping(value = "/device/create", method = RequestMethod.POST)
	public String addDevice(@RequestBody Device device) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        PgManagerImpl pg = (PgManagerImpl)context.getBean("OracleDB");
		PgManagerImpl dbWorker = new PgManagerImpl();
		pg.addDevice(device);
		return HttpStatus.OK.toString();
	}
	
	@RequestMapping(value = "/device/get/{id}", method = RequestMethod.GET)
	public Device getDevice(@PathVariable("id") BigInteger id) {
		PgManagerImpl dbWorker = new PgManagerImpl();
		return dbWorker.getDevice(id);		
	}
	
	@RequestMapping(value = "/device/get", method = RequestMethod.GET)
	public List<Device> getAllDevices() {
		PgManagerImpl dbWorker = new PgManagerImpl();
		return dbWorker.getAllDevices();
	}
	
	@RequestMapping(value = "/device/delete", method = RequestMethod.DELETE)
	public String deleteDevice(@RequestBody BigInteger id) {
		PgManagerImpl dbWorker = new PgManagerImpl();
		dbWorker.deleteDevice(id);
		return HttpStatus.OK.toString();
	}
	
	@RequestMapping(value = "/device/update", method = RequestMethod.PUT)
	public String updateDevice(@RequestBody Device device) {
		PgManagerImpl dbWorker = new PgManagerImpl();
		dbWorker.updateDevice(device);
		return HttpStatus.OK.toString();
	}

    @RequestMapping("/test")
    public TestDto test() {
        TestDto dto = createDto();
        dto.setMessage("It's a test string from server");
        return dto;
    }

    @RequestMapping("/test/{someText}")
    public TestDto testAdditional(@PathVariable String someText) {
        TestDto dto = createDto();
        dto.setMessage("It's a test string from server and you've given me " + someText);
        return dto;
    }

    //Это нужно будет создавать через фабрику сприга
    protected TestDto createDto() {
        return new TestDto();
    }

}
