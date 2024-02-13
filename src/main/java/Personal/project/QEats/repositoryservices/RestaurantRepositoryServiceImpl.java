package Personal.project.QEats.repositoryservices;

 //import ch.hsr.geohash.GeoHash;
 import Personal.project.QEats.dto.Restaurant;
 import Personal.project.QEats.globals.GlobalConstants;
 import Personal.project.QEats.models.RestaurantEntity;
 import Personal.project.QEats.repositories.RestaurantRepository;
 import Personal.project.QEats.utils.GeoLocation;
 import Personal.project.QEats.utils.GeoUtils;
 import com.fasterxml.jackson.core.JsonProcessingException;
 import com.fasterxml.jackson.core.type.TypeReference;
 import com.fasterxml.jackson.databind.ObjectMapper;
 import java.io.IOException;
 import java.time.LocalTime;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Optional;
 import java.util.Set;
 import java.util.concurrent.Future;
 import java.util.regex.Pattern;
 import java.util.stream.Collectors;
 import javax.inject.Provider;
 import org.modelmapper.ModelMapper;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.mongodb.core.MongoTemplate;
 import org.springframework.data.mongodb.core.query.Criteria;
 import org.springframework.data.mongodb.core.query.Query;
 import org.springframework.scheduling.annotation.AsyncResult;
 import org.springframework.stereotype.Component;
 import org.springframework.stereotype.Service;
 
 
 @Service
 public class RestaurantRepositoryServiceImpl implements RestaurantRepositoryService {
 
 
 @Autowired
 private RestaurantRepository restaurantRepository;
 
   @Autowired
   private MongoTemplate mongoTemplate;
 
   private boolean isOpenNow(LocalTime time, RestaurantEntity res) {
     LocalTime openingTime = LocalTime.parse(res.getOpensAt());
     LocalTime closingTime = LocalTime.parse(res.getClosesAt());
 
     return time.isAfter(openingTime) && time.isBefore(closingTime);
   }
 
   public List<Restaurant> findAllRestaurantsCloseBy(Double latitude,
       Double longitude, LocalTime currentTime, Double servingRadiusInKms) {
 
     List<RestaurantEntity> restaurants = restaurantRepository.findAll();
     List<Restaurant> res=new ArrayList<Restaurant>();
     for(RestaurantEntity i:restaurants)
     {
        if(isRestaurantCloseByAndOpen(i,currentTime,latitude,longitude,servingRadiusInKms))
        {
         ModelMapper modelmapper= new ModelMapper();
         Restaurant re= modelmapper.map(i,Restaurant.class);
         res.add(re);
        }
     }
     return res;
 
   }
 
   private boolean isRestaurantCloseByAndOpen(RestaurantEntity restaurantEntity,
       LocalTime currentTime, Double latitude, Double longitude, Double servingRadiusInKms) {
     if (isOpenNow(currentTime, restaurantEntity)) {
       return GeoUtils.findDistanceInKm(latitude, longitude,
           restaurantEntity.getLatitude(), restaurantEntity.getLongitude())
           < servingRadiusInKms;
     }
 
     return false;
   }
 
 
 
 }
 
 
