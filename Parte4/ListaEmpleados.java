package reto2.Parte4;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class ListaEmpleados {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "record")
    private List<EmpleadoPojo> record;

    public List<EmpleadoPojo> getRecord() {
        return record;
    }

    public void setRecord(List<EmpleadoPojo> record) {
        this.record = record;
    }
}
