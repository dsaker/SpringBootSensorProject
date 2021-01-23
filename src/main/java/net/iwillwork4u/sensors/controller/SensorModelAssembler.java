package net.iwillwork4u.sensors.controller;

import net.iwillwork4u.sensors.entity.Sensor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class SensorModelAssembler implements RepresentationModelAssembler<Sensor, EntityModel<Sensor>> {

    @Override
    public  EntityModel<Sensor> toModel(Sensor sensor) {
        return EntityModel.of(sensor,
                linkTo(methodOn(SensorController.class).one(sensor.getSid())).withSelfRel(),
                linkTo(methodOn(SensorController.class).all()).withRel("sensors"));
    }
}

