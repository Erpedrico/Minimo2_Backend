package edu.upc.dsa.services;

import edu.upc.dsa.PeticionesManager;
import edu.upc.dsa.PeticionesManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.Peticiones;
import edu.upc.dsa.models.VOCredenciales;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/Peticiones", description = "Endpoint to peticiones Service")
@Path("/Peticiones")

public class PeticionesService {
    private PeticionesManager pm;

    public PeticionesService(){
        this.pm = PeticionesManagerImpl.getInstance();
        if (pm.sizeP()==0) {
            this.pm.addPeticiones("hoy","prueba","prueba","prueba");
        }
    }

    @POST
    @ApiOperation(value = "addPeticiones", notes = "ole")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Succesfull", response=Peticiones.class),
    })
    @Path("/question")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPeticiones(Peticiones p){
        int n = this.pm.addPeticiones(p);
        if (n==0) return Response.status(201).build();

        //En caso de un valor inesperado, devolver código de Internal Server Error
        return Response.status(500).build();
    }
    @GET
    @ApiOperation(value = "get all Peticiones", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Peticiones.class, responseContainer="List"),
    })
    @Path("/peticiones")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        List<Peticiones> peticiones = this.pm.getallpeticiones();

        GenericEntity<List<Peticiones>> entity = new GenericEntity<List<Peticiones>>(peticiones) {};
        return Response.status(201).entity(entity).build();

    }
}
