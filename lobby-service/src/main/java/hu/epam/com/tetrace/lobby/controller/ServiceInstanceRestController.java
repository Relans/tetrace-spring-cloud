package hu.epam.com.tetrace.lobby.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
class ServiceInstanceRestController {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/service-instances")
	public List<String> serviceInstancesByApplicationName() {
		Application application = eurekaClient.getApplication("lobby-service");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort()
				+ "/service-instances/lobby-service/";
		String[] instances = restTemplate.getForObject(url, String[].class);
		return Arrays.asList(instances);
	}

	@RequestMapping("/service-instances/{applicationName}")
	public List<String> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName).stream().map(i -> i.getHost())
				.collect(Collectors.toList());
	}
}