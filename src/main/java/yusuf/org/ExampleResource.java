package yusuf.org;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @ResourcePath("/Users/mac/Downloads/template/emailtemplate")
    Template report;


    @GET
    @Path("/template")
    public TemplateInstance get() {
        return report.data("now", "Qute Template");
    }

}