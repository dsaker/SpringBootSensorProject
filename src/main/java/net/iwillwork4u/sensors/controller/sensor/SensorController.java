package net.iwillwork4u.sensors.controller.sensor;

import net.iwillwork4u.sensors.entity.Sensor;
import net.iwillwork4u.sensors.entity.User;
import net.iwillwork4u.sensors.repository.sensor.SensorRepository;
import net.iwillwork4u.sensors.repository.user.UserRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "sensors/")
public class SensorController {

    private final SensorRepository sensorRepository;
    private final UserRepository userRepository;
    private final SensorModelAssembler assembler;

    SensorController(SensorRepository sensorRepository, UserRepository userRepository, SensorModelAssembler assembler) {
        this.sensorRepository = sensorRepository;
        this.userRepository = userRepository;
        this.assembler = assembler;
    }

    @GetMapping()
    public CollectionModel<EntityModel<Sensor>> all() {
        List<EntityModel<Sensor>> sensors = sensorRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(sensors,
                linkTo(methodOn(SensorController.class).all()).withSelfRel());
    }

    @PostMapping()
    ResponseEntity<EntityModel<Sensor>> newSensor(@RequestParam long userId,
                                                  @RequestParam String sensorName) {
        Sensor newSensor = newSensor(sensorName);
        EntityModel<Sensor> entityModel = assembler.toModel(sensorRepository.save(newSensor));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @GetMapping("/{id}")
    public EntityModel<Sensor> one(@PathVariable Long id) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() ->
                new SensorNotFoundException(id));
        return assembler.toModel(sensor);
    }

}
