package com.ecom.ecommerse.config;

import com.ecom.ecommerse.entity.Product;
import com.ecom.ecommerse.entity.ProductCategory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class MyDataRestConfig implements RepositoryRestConfigurer
{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {
                HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.DELETE
        };

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) ->( httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure((metdata, httpMethods) -> (httpMethods.disable(theUnsupportedActions)));


        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) ->( httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure((metdata, httpMethods) -> (httpMethods.disable(theUnsupportedActions)));



    }




}
