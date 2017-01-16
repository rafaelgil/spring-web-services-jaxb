//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.5-2 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: PM.01.12 às 04:49:06 PM BRST 
//


package org.estudospringwebservice.pessoa.schema.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pessoa" type="{http://www.estudospringwebservice.org/pessoa/schema/beans}pessoa" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pessoa"
})
@XmlRootElement(name = "pessoas-response")
public class PessoasResponse {

    protected List<Pessoa> pessoa;

    /**
     * Gets the value of the pessoa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pessoa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPessoa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pessoa }
     * 
     * 
     */
    public List<Pessoa> getPessoa() {
        if (pessoa == null) {
            pessoa = new ArrayList<Pessoa>();
        }
        return this.pessoa;
    }

    public PessoasResponse withPessoa(Pessoa... values) {
        if (values!= null) {
            for (Pessoa value: values) {
                getPessoa().add(value);
            }
        }
        return this;
    }

    public PessoasResponse withPessoa(Collection<Pessoa> values) {
        if (values!= null) {
            getPessoa().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the pessoa property.
     * 
     * @param pessoa
     *     allowed object is
     *     {@link Pessoa }
     *     
     */
    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

}
