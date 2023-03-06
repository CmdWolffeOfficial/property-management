package dev.wolffe.property_management_example.core.AlphabetHyphen;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AlphabetHyphenValidator  implements ConstraintValidator<AlphabetHyphen, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null){
            return false;
        }
        return value.matches("^[A-Za-z-]+$");
    }
}
