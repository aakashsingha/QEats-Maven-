package Personal.project.QEats.services;


 import Personal.project.QEats.exchanges.GetRestaurantsRequest;
 import Personal.project.QEats.exchanges.GetRestaurantsResponse;
 import java.time.LocalTime;

import org.springframework.stereotype.Service;
 
 @Service
 public interface RestaurantService {
 
   GetRestaurantsResponse findAllRestaurantsCloseBy(
       GetRestaurantsRequest getRestaurantsRequest, LocalTime currentTime);
 
 
 }
 
