package Personal.project.QEats.models;


 import java.util.ArrayList;
 import java.util.List;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 import org.springframework.data.annotation.Id;
 import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
 
 // Java class that maps to Mongo collection.
 @Data
 @Document(collection = "Rest.")
 @NoArgsConstructor
 public class RestaurantEntity {
 
   @Id
   private String id;
 
   @NotNull
   private String restaurantId;
 
   @NotNull
   private String name;
 
   @NotNull
   private String city;
 
   @NotNull
   private String imageUrl;
 
   @NotNull
   private Double latitude;
 
   @NotNull
   private Double longitude;
 
   @NotNull
   private String opensAt;
 
   @NotNull
   private String closesAt;
 
   @NotNull
   private List<String> attributes = new ArrayList<>();
 
 }
 
 
