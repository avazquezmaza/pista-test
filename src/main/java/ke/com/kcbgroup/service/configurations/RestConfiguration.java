package ke.com.kcbgroup.service.configurations;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Rest Route Builder Class
 * 
 * @author Francisco Osorio | Bring Global
 * @version 1.0.0
 * @since June 22, 2020
 * @implNote This class configures the rest component for all endpoints
 */
@Component
public class RestConfiguration extends RouteBuilder {
	@Value("${camel.component.servlet.name}")
	private String camelComponent;

	@Value("${pista-test.api.path}")
	private String apiPath;

	@Value("${pista-test.api.enableCors}")
	private Boolean apiEnableCors;

	@Value("${pista-test.api-docs.path}")
	private String apiDocsPath;

	@Value("${pista-test.api-docs.version}")
	private String apiDocsVersion;

	@Value("${pista-test.api-docs.title}")
	private String apiDocsTitle;

	@Override
	public void configure() throws Exception {
		// Rest Configuration
		restConfiguration()
			.component(camelComponent)
			.contextPath(apiPath)
			.bindingMode(RestBindingMode.off)
			.enableCORS(apiEnableCors)
				.apiContextPath(apiDocsPath).apiProperty("api.title", apiDocsTitle)
				.apiProperty("api.version", apiDocsVersion).apiProperty("cors", apiEnableCors.toString())
				.apiVendorExtension(true);
	}
}
