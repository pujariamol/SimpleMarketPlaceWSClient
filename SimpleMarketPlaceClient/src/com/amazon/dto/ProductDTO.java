/**
 * ProductDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.amazon.dto;

public class ProductDTO  implements java.io.Serializable {
    private java.lang.String brand;

    private int categoryId;

    private java.lang.String description;

    private int identifier;

    private double price;

    private java.lang.String productName;

    private int productOwnerId;

    private java.lang.String productOwnerName;

    private int quantity;

    private java.lang.String sellerInformation;

    public ProductDTO() {
    }

    public ProductDTO(
           java.lang.String brand,
           int categoryId,
           java.lang.String description,
           int identifier,
           double price,
           java.lang.String productName,
           int productOwnerId,
           java.lang.String productOwnerName,
           int quantity,
           java.lang.String sellerInformation) {
           this.brand = brand;
           this.categoryId = categoryId;
           this.description = description;
           this.identifier = identifier;
           this.price = price;
           this.productName = productName;
           this.productOwnerId = productOwnerId;
           this.productOwnerName = productOwnerName;
           this.quantity = quantity;
           this.sellerInformation = sellerInformation;
    }


    /**
     * Gets the brand value for this ProductDTO.
     * 
     * @return brand
     */
    public java.lang.String getBrand() {
        return brand;
    }


    /**
     * Sets the brand value for this ProductDTO.
     * 
     * @param brand
     */
    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }


    /**
     * Gets the categoryId value for this ProductDTO.
     * 
     * @return categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }


    /**
     * Sets the categoryId value for this ProductDTO.
     * 
     * @param categoryId
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    /**
     * Gets the description value for this ProductDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ProductDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the identifier value for this ProductDTO.
     * 
     * @return identifier
     */
    public int getIdentifier() {
        return identifier;
    }


    /**
     * Sets the identifier value for this ProductDTO.
     * 
     * @param identifier
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }


    /**
     * Gets the price value for this ProductDTO.
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }


    /**
     * Sets the price value for this ProductDTO.
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }


    /**
     * Gets the productName value for this ProductDTO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this ProductDTO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the productOwnerId value for this ProductDTO.
     * 
     * @return productOwnerId
     */
    public int getProductOwnerId() {
        return productOwnerId;
    }


    /**
     * Sets the productOwnerId value for this ProductDTO.
     * 
     * @param productOwnerId
     */
    public void setProductOwnerId(int productOwnerId) {
        this.productOwnerId = productOwnerId;
    }


    /**
     * Gets the productOwnerName value for this ProductDTO.
     * 
     * @return productOwnerName
     */
    public java.lang.String getProductOwnerName() {
        return productOwnerName;
    }


    /**
     * Sets the productOwnerName value for this ProductDTO.
     * 
     * @param productOwnerName
     */
    public void setProductOwnerName(java.lang.String productOwnerName) {
        this.productOwnerName = productOwnerName;
    }


    /**
     * Gets the quantity value for this ProductDTO.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this ProductDTO.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the sellerInformation value for this ProductDTO.
     * 
     * @return sellerInformation
     */
    public java.lang.String getSellerInformation() {
        return sellerInformation;
    }


    /**
     * Sets the sellerInformation value for this ProductDTO.
     * 
     * @param sellerInformation
     */
    public void setSellerInformation(java.lang.String sellerInformation) {
        this.sellerInformation = sellerInformation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductDTO)) return false;
        ProductDTO other = (ProductDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.brand==null && other.getBrand()==null) || 
             (this.brand!=null &&
              this.brand.equals(other.getBrand()))) &&
            this.categoryId == other.getCategoryId() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.identifier == other.getIdentifier() &&
            this.price == other.getPrice() &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            this.productOwnerId == other.getProductOwnerId() &&
            ((this.productOwnerName==null && other.getProductOwnerName()==null) || 
             (this.productOwnerName!=null &&
              this.productOwnerName.equals(other.getProductOwnerName()))) &&
            this.quantity == other.getQuantity() &&
            ((this.sellerInformation==null && other.getSellerInformation()==null) || 
             (this.sellerInformation!=null &&
              this.sellerInformation.equals(other.getSellerInformation())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getBrand() != null) {
            _hashCode += getBrand().hashCode();
        }
        _hashCode += getCategoryId();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getIdentifier();
        _hashCode += new Double(getPrice()).hashCode();
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        _hashCode += getProductOwnerId();
        if (getProductOwnerName() != null) {
            _hashCode += getProductOwnerName().hashCode();
        }
        _hashCode += getQuantity();
        if (getSellerInformation() != null) {
            _hashCode += getSellerInformation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.amazon.com", "ProductDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("brand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "brand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoryId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "categoryId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "productName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productOwnerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "productOwnerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productOwnerName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "productOwnerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "quantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sellerInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.amazon.com", "sellerInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
