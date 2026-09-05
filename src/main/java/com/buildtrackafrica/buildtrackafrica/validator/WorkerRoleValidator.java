package com.buildtrackafrica.buildtrackafrica.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.Arrays;
import java.util.List;

@FacesValidator("workerRoleValidator")
public class WorkerRoleValidator implements Validator<String> {

    private static final List<String> ALLOWED_ROLES =
            Arrays.asList("Site Manager", "Engineer", "Supervisor", "Laborer", "Contractor");

    @Override
    public void validate(FacesContext context, UIComponent component, String value)
            throws ValidatorException {
        if (value != null && !ALLOWED_ROLES.contains(value)) {
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Invalid role",
                    "Role must be one of: " + ALLOWED_ROLES
            );
            throw new ValidatorException(msg);
        }
    }
}