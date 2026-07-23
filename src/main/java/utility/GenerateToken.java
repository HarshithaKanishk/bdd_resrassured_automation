package utility;



import config.Constants;
import pojo.Auth;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

import utility.GenerateToken;

import endpoints.Routes; 

public class GenerateToken {

    public static String generateToken() {
     
        Auth auth=JsonUtil.readJsonFile(Constants.AUTH_JSON_PATH, Auth.class);   

      return given()    
            .contentType(ContentType.JSON)
            .body(auth).when()
            .post(Routes.AUTH).then()
            .statusCode(200)
            .extract().jsonPath().getString("token");    

            

      
    }

    
    
}
