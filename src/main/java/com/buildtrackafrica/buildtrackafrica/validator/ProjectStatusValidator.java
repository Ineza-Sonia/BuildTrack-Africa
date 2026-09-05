package com.buildtrackafrica.buildtrackafrica.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.Arrays;
import java.util.List;

@FacesValidator("projectStatusValidator")
public class ProjectStatusValidator implements Validator<String> {

    private static final List<String> ALLOWED_STATUSES =
            Arrays.asList("Not Started", "In Progress", "Completed", "On Hold");

    @Override
    public void validate(FacesContext context, UIComponent component, String value)
            throws ValidatorException {
        if (value != null && !ALLOWED_STATUSES.contains(value)) {
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Invalid status",
                    "Status must be one of: " + ALLOWED_STATUSES
            );
            throw new ValidatorException(msg);
        }
    }
}