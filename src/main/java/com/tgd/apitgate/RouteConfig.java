package com.tgd.apitgate;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@Configuration
public class RouteConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route("emproute",r -> r.path("/v1/emp/getAllEmployees")
						.and()
						.method(HttpMethod.GET)
						.uri("lb://EMPLOYEE-MS"))
				.route("product-catalog-service",r->r.path("/v1/products/**").uri("lb://PRODUCT-CATALOG"))
				.route("customer-ms",r->r.path("/v1/customers/**").uri("lb://CUSTOMER-MS"))
				.route("order-ms",r->r.path("/orderms/**").uri("lb://ORDER-MS"))
				.build();
	}
}
