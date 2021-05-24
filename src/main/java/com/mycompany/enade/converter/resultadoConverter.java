/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.converter;

import com.mycompany.enade.model.Resultado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author Octávio
 */
@FacesConverter("resultadoConverter")
@Named
public class resultadoConverter implements Converter {

     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Resultado) {
            Resultado obj = (Resultado) value;
            if (obj != null) {
                uic.getAttributes().put(obj.getIdResultado().toString(), obj);
                return obj.getIdResultado().toString();
            }
            return "";
        }
        return "";
    }

}
