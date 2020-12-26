package com.ecom.ecommerse.config;

import com.ecom.ecommerse.entity.Product;
import com.ecom.ecommerse.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyDataRestConfig implements RepositoryRestConfigurer
{
    @Autowired
    private EntityManager entityManager;

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

        exposeIds(config);


    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<Class> entityClasses = new ArrayList<>();
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }




}
