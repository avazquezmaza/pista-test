package ke.com.kcbgroup.service.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Fund Transfer Request Route Builder Class
 * 
 * @author Francisco Osorio | Bring Global
 * @version 1.0.0
 * @since June 22, 2020
 */
@Component
public class HelloWordRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// Rest Endpoints
		rest("/sayHi").description("REST service")
			.get().description("Its only Hello World")
			.to("direct:dispatch");

		/* Routes Configuration */
		from("direct:dispatch").routeId("pista-test.dispatch")
		.log(LoggingLevel.INFO, "Hello World Headers IN: \n ${in.headers}")
		.log(LoggingLevel.INFO, "Hello World Body IN: \n ${in.body}")
		.setHeader("Content-Type",simple("application/json"))
		.setBody(constant("{\"Hello \" : \"World\"}"))
		.log(LoggingLevel.INFO, "Hello World Body OUT: \n ${body}")
;
				

	}
}
