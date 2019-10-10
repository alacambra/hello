package tech.lacambra.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloResource {

  @GET
  public String checkReady() {
    return "+";
  }

}
