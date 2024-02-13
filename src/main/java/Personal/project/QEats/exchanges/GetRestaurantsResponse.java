package Personal.project.QEats.exchanges;

 import Personal.project.QEats.dto.Restaurant;
 import java.util.List;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 public class GetRestaurantsResponse {
 
     List<Restaurant> restaurants;
 
 }
 
 