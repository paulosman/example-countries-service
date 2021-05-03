package ca.lifornia.countries;

import io.honeycomb.opentelemetry.HoneycombSdk;
import io.honeycomb.opentelemetry.sdk.trace.samplers.DeterministicTraceSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	public HoneycombSdk getOpenTelemetry() {
		return HoneycombSdk.builder()
				.setApiKey("foobar")
			        .setServiceName("countries-service")
				.setDataset("java-sdk-honeycomb")
				.setSampler(new DeterministicTraceSampler(5))
				.build();
	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
