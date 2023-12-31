package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Museum controller.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  private final MuseumServiceInterface museumServiceInterface;

  /**
   * Instantiates a new Museum controller.
   *
   * @param museumServiceInterface the museum service interface
   */
  @Autowired
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  /**
   * New museum response entity.
   *
   * @param newMuseum the new museum
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Museum> newMuseum(
      @RequestBody MuseumCreationDto newMuseum) {
    Museum museum = ModelDtoConverter.dtoToModel(newMuseum);

    this.museumServiceInterface.createMuseum(museum);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(museum);
  }


  /**
   * Gets closest museum.
   *
   * @param lat         the lat
   * @param lng         the lng
   * @param maxDistance the max distance
   * @return the closest museum
   */
  @GetMapping("/closest")
  public ResponseEntity<Museum> getClosestMuseum(
      @RequestParam Double lat, Double lng, @RequestParam("max_dist_km") Double maxDistance) {
    Museum museum = this.museumServiceInterface.getClosestMuseum(new Coordinate(lat, lng),
        maxDistance);
    return ResponseEntity.ok(museum);
  }

  /**
   * Gets museum.
   *
   * @param id the id
   * @return the museum
   */
  @GetMapping("/{id}")
  public ResponseEntity<Museum> getMuseum(@PathVariable Long id) {
    Museum museum = this.museumServiceInterface.getMuseum(id);
    return ResponseEntity.ok(museum);
  }
}
