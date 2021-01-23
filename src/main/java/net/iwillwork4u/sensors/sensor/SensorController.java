package net.iwillwork4u.sensors.sensor;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.iwillwork4u.sensors.dto.SensorDataDto;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "sensors/")
public class SensorController {

    private final SensorRepository repository;

    private final SensorModelAssembler assembler;

    SensorController(SensorRepository repository, SensorModelAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping()
    CollectionModel<EntityModel<Sensor>> all() {
        List<EntityModel<Sensor>> sensors = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(sensors,
                linkTo(methodOn(SensorController.class).all()).withSelfRel());
    }

    @PostMapping()
    ResponseEntity<EntityModel<Sensor>> newSensor(@RequestBody Sensor newSensor) {

        EntityModel<Sensor> entityModel = assembler.toModel(repository.save(newSensor));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @GetMapping("/{id}")
    EntityModel<Sensor> one(@PathVariable Long id) {
        Sensor sensor = repository.findById(id).orElseThrow(() ->
                new SensorNotFoundException(id));
        return assembler.toModel(sensor);
    }

    @PostMapping("/data/{id}")
    public void addData(@PathVariable Long id, @RequestBody SensorDataDto sensorData) {
    }

}
