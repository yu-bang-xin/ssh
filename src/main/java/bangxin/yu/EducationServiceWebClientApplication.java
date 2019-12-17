package bangxin.yu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient    //这个注解代表你是Eureka客户端,即注册在Eureka上面
public class EducationServiceWebClientApplication {
	/**
	 * @Bean注释被用于指示一个方法实例，配置和初始化为通过Spring IoC容器进行管理的新对象
	 * @LoadBalanced负载均衡开始
	 * RestTemplate是Spring提供的用于访问Rest服务的客户端，
	 * RestTemplate提供了多种便捷访问远程Http服务的方法,能够大大提高客户端的编写效率
	 * RestTemplate能大幅简化了提交表单数据的难度，并且附带了自动转换JSON数据的功能
	 **/
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EducationServiceWebClientApplication.class, args);
	}
}
