/*
 */
package tech.lacambra.hello;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author airhacks.com
 */
public class HelloResourceIT {

    static final String SERVICE_URI = "SERVICE_URI";
    private WebTarget tut;

    @Before
    public void initClient() {
        this.tut = ClientBuilder.newClient().target(serviceUri() + "/hello/resources/hello");
        System.out.println("Using service uri: " + this.tut.getUri().toString());
    }

    static String serviceUri() {
        return System.getenv().getOrDefault(SERVICE_URI, System.getProperty(SERVICE_URI, "http://localhost:8080"));
    }

    @Test
    public void get() {

        Response response = tut.
                request().
                get();

        assertThat(response.getStatus(), is(200));

    }
}
