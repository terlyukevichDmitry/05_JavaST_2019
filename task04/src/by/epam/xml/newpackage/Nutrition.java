//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.28 at 03:52:27 PM MSK 
//


package by.epam.xml.newpackage;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Nutrition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Nutrition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="HB"/>
 *     &lt;enumeration value="AL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Nutrition")
@XmlEnum
public enum Nutrition {

    BB,
    HB,
    AL;

    public String value() {
        return name();
    }

    public static Nutrition fromValue(String v) {
        return valueOf(v);
    }

}
