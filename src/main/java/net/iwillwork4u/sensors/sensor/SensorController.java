package net.iwillwork4u.sensors.sensor;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SensorController {

    private final SensorRepository repository;

    SensorController(SensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sensors")
    CollectionModel<EntityModel<Sensor>> all() {
        List<EntityModel<Sensor>> sensors = repository.findAll().stream()
                .map(sensor -> EntityModel.of(sensor,
                        linkTo(methodOn(SensorController.class).one(sensor.getSid())).withSelfRel(),
                        linkTo(methodOn(SensorController.class).all()).withRel("sensors"))).collect(Collectors.toList());
        return CollectionModel.of(sensors,
                linkTo(methodOn(SensorController.class).all()).withSelfRel());
    }

    @PostMapping("/sensors")
    Sensor newSensor(@RequestBody Sensor newSensor) {
        return repository.save(newSensor);
    }

    @GetMapping("/sensors/{id}")
    EntityModel<Sensor> one(@PathVariable Long id) {
        Sensor sensor = repository.findById(id).orElseThrow(() ->
                new SensorNotFoundException(id));
        return EntityModel.of(sensor,
                linkTo(methodOn(SensorController.class).one(id)).withSelfRel(),
                linkTo(methodOn(SensorController.class).all()).withRel("sensors"));
    }

}
