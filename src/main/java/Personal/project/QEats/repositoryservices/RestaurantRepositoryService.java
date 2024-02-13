package Personal.project.QEats.repositoryservices;


 import Personal.project.QEats.dto.Restaurant;
 import java.time.LocalTime;
 import java.util.List;
 import java.util.concurrent.Future;
 import org.springframework.scheduling.annotation.Async;
 import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
 
 @Service
 public interface RestaurantRepositoryService {
 
   List<Restaurant> findAllRestaurantsCloseBy(Double latitude, Double longitude,
       LocalTime currentTime, Double servingRadiusInKms);
 
 }
 
 
 