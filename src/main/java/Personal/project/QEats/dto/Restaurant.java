package Personal.project.QEats.dto;


 import com.fasterxml.jackson.annotation.JsonAutoDetect;
 import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
 import java.util.List;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
import lombok.NonNull;
 
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 public class Restaurant {
 
     @NotNull @JsonIgnore
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
 
 
