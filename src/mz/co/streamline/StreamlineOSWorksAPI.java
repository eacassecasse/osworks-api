/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import mz.co.streamline.osworks.core.connection.ConnectionFactoryBuilder;
import mz.co.streamline.osworks.domain.model.Client;
import mz.co.streamline.osworks.domain.model.Gender;
import mz.co.streamline.osworks.domain.model.Physical;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

/**
 *
 * @author edmilson.cassecasse
 */
public class StreamlineOSWorksAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Physical physical = new Physical();
        physical.setName("Ed");
        physical.setSurname("Cassecasse");
        physical.setId(1L);
        physical.setGender(Gender.M);
        physical.setIdentificationNo("110204986669N");
        physical.setVatNumber(150155551);
        
        showMessages(physical);
        
    }
    
    private static void showMessages(Object object) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("Messages_pt_PT")))
                .buildValidatorFactory().getValidator();
        
        String lang = "pt";
        String country = "PT";
        Locale locale = new Locale(lang, country);
      
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        
        if (constraintViolations.size() > 0) {
            constraintViolations.forEach((constraint) -> 
                    System.out.println(constraint.getMessage())
            );
        }
    }
    
}
