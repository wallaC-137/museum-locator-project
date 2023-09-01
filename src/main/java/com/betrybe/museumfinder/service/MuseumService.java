package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.betrybe.museumfinder.database.MuseumFakeDatabase;

@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase museumFakeDatabase;

  @Autowired
  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    if (CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      return museumFakeDatabase.saveMuseum(museum);
    }
    throw new InvalidCoordinateException();
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
