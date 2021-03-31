package ca.lifornia.countries;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.opentelemetry.context.propagation.ContextPropagators;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	public OpenTelemetry getOpenTelemetry() {
		SpanExporter exporter = OtlpGrpcSpanExporter.builder()
				.setEndpoint("https://api.honeycomb.io")
				.addHeader("X-Honeycomb-Team", "fdjskalfdsajklfdsajkflds;a")
				.addHeader("X-Honeycomb-Dataset", "java-sdk-manual")
				.build();
		SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
			.addSpanProcessor(BatchSpanProcessor.builder(exporter).build()).build();

		return OpenTelemetrySdk.builder().setTracerProvider(tracerProvider)
				.setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
				.buildAndRegisterGlobal();
	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
