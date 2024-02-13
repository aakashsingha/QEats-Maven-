package Personal.project.QEats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import Personal.project.QEats.exchanges.GetRestaurantsRequest;
import Personal.project.QEats.exchanges.GetRestaurantsResponse;
import Personal.project.QEats.models.RestaurantEntity;
import Personal.project.QEats.repositories.RestaurantRepository;
import Personal.project.QEats.services.RestaurantService;
import jakarta.validation.Valid;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;


@RestController
public class RestaurantController {

  public static final String RESTAURANT_API_ENDPOINT = "/qeats/v1";
  public static final String RESTAURANTS_API = "/restaurants";
  public static final String MENU_API = "/menu";
  public static final String CART_API = "/cart";
  public static final String CART_ITEM_API = "/cart/item";
  public static final String CART_CLEAR_API = "/cart/clear";
  public static final String POST_ORDER_API = "/order";
  public static final String GET_ORDERS_API = "/orders";

  @Autowired
  private RestaurantService restaurantService;

  @Autowired
  private RestaurantRepository restaurantRepository;
  
  @PostMapping("/qeats/menu")
  public String  postRestaurant()
  {
     RestaurantEntity ent= new RestaurantEntity();
     ent.setId("1");
     ent.setRestaurantId("1");
     ent.setName("ajju da restaurant");
     ent.setCity("Haldwani");
     ent.setImageUrl("aakash");
     ent.setLatitude(19.157034);
     ent.setLongitude(72.932744);
     ent.setOpensAt("10:00:00.00");
     ent.setClosesAt("23:59:59.59");
     List<String> l= new ArrayList<String>();
     l.add("good area");
     l.add("good view");
     ent.setAttributes(l);
     
     RestaurantEntity savedEntitiy = restaurantRepository.save(ent);
      return savedEntitiy.getCity();
  }
  // @DeleteMapping("/qeats/delete")
  // public String deleteall()
  // {
  //   restaurantRepository.deleteAll();
  //    return "Delted";
  // }

  @GetMapping("/qeats/v1/restaurants")
  public ResponseEntity<GetRestaurantsResponse> getRestaurants(
       @Valid GetRestaurantsRequest getRestaurantsRequest) {

        if(getRestaurantsRequest.getLatitude() <-90 || getRestaurantsRequest.getLatitude() > 90 )
        {
          return ResponseEntity.badRequest().build();
        }
        if(getRestaurantsRequest.getLongitude() <-180 || getRestaurantsRequest.getLongitude() > 180)
        {
           return ResponseEntity.badRequest().build();
        }
    GetRestaurantsResponse getRestaurantsResponse;

      getRestaurantsResponse = restaurantService
          .findAllRestaurantsCloseBy(getRestaurantsRequest, LocalTime.now());

    return ResponseEntity.ok().body(getRestaurantsResponse);
  }











}
