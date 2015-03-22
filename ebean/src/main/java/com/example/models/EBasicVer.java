package com.example.models;

import com.avaje.ebean.bean.EntityBean;
import com.avaje.ebean.bean.EntityBeanIntercept;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * A simple entity bean. This table does not have to exist if
 * you use Ebean's DDL generation.
 */
@Entity
@Table(name="e_junktable")
public class EBasicVer implements Serializable/*, EntityBean*/ {

    @Id
    Integer id;

    String name;

    String description;

    @Version
    Timestamp lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //com.avaje.ebeaninternal.server.deploy.BeanDescriptorManager.setEntityBeanClass()
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /*@Override
    public String _ebean_getMarker() {
        return null;
    }

    @Override
    public Object _ebean_newInstance() {
        return null;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {

    }

    @Override
    public void _ebean_setEmbeddedLoaded() {

    }

    @Override
    public boolean _ebean_isEmbeddedNewOrDirty() {
        return false;
    }

    @Override
    public EntityBeanIntercept _ebean_getIntercept() {
        return null;
    }

    @Override
    public EntityBeanIntercept _ebean_intercept() {
        return null;
    }

    @Override
    public Object _ebean_createCopy() {
        return null;
    }

    @Override
    public String[] _ebean_getFieldNames() {
        return new String[0];
    }

    @Override
    public void _ebean_setField(int i, Object o, Object o1) {

    }

    @Override
    public void _ebean_setFieldIntercept(int i, Object o, Object o1) {

    }

    @Override
    public Object _ebean_getField(int i, Object o) {
        return null;
    }

    @Override
    public Object _ebean_getFieldIntercept(int i, Object o) {
        return null;
    }*/
}