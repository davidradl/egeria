/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.accessservices.assetmanager.properties;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * MetadataCorrelationProperties describes the common properties used to pass the properties of metadata elements
 * to the metadata repositories (aka properties server).  It includes details of the external source of the
 * metadata and any properties that assists in the mapping of the open metadata elements to the external
 * asset manager's copy.
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataCorrelationProperties implements Serializable
{
    private static final long   serialVersionUID = 1L;

    private String                   assetManagerGUID           = null;
    private String                   assetManagerName           = null;
    private SynchronizationDirection synchronizationDirection   = null;
    private String                   synchronizationDescription = null;
    private String                   externalIdentifier         = null;
    private String                   externalIdentifierName     = null;
    private String                   externalIdentifierUsage    = null;
    private String                   externalIdentifierSource   = null;
    private KeyPattern               keyPattern                 = null;
    private Map<String, String>      mappingProperties          = null;

    /**
     * Default constructor
     */
    public MetadataCorrelationProperties()
    {
        super();
    }


    /**
     * Copy/clone constructor.
     *
     * @param template template object to copy.
     */
    public MetadataCorrelationProperties(MetadataCorrelationProperties template)
    {
        if (template != null)
        {
            assetManagerGUID = template.getAssetManagerGUID();
            assetManagerName = template.getAssetManagerName();
            synchronizationDirection = template.getSynchronizationDirection();
            synchronizationDescription = template.getSynchronizationDescription();
            externalIdentifier = template.getExternalIdentifier();
            externalIdentifierName = template.getExternalIdentifierName();
            externalIdentifierUsage = template.getExternalIdentifierUsage();
            externalIdentifierSource = template.getExternalIdentifierSource();
            keyPattern = template.getKeyPattern();
            mappingProperties = template.getMappingProperties();
        }
    }


    /**
     * Return the unique identifier of the software server capability that represents the asset manager.
     *
     * @return string guid
     */
    public String getAssetManagerGUID()
    {
        return assetManagerGUID;
    }


    /**
     * Set up the unique identifier of the software server capability that represents the asset manager.
     *
     * @param assetManagerGUID string guid
     */
    public void setAssetManagerGUID(String assetManagerGUID)
    {
        this.assetManagerGUID = assetManagerGUID;
    }


    /**
     * Return the qualified name of the software server capability that represents the asset manager.
     *
     * @return string name
     */
    public String getAssetManagerName()
    {
        return assetManagerName;
    }


    /**
     * Set up the qualified name of the software server capability that represents the asset manager.
     *
     * @param assetManagerName string name
     */
    public void setAssetManagerName(String assetManagerName)
    {
        this.assetManagerName = assetManagerName;
    }


    /**
     * Return details of the synchronization direction.
     *
     * @return enum
     */
    public SynchronizationDirection getSynchronizationDirection()
    {
        return synchronizationDirection;
    }


    /**
     * Set up details of the synchronization direction.
     *
     * @param synchronizationDirection enum
     */
    public void setSynchronizationDirection(SynchronizationDirection synchronizationDirection)
    {
        this.synchronizationDirection = synchronizationDirection;
    }


    /**
     * Return optional short description of the asset manager.
     *
     * @return string summary
     */
    public String getSynchronizationDescription()
    {
        return synchronizationDescription;
    }


    /**
     * Set up optional short description of the asset manager.
     *
     * @param synchronizationDescription string summary
     */
    public void setSynchronizationDescription(String synchronizationDescription)
    {
        this.synchronizationDescription = synchronizationDescription;
    }


    /**
     * Return the unique identifier used in the external asset manager for this element.
     *
     * @return string identifier
     */
    public String getExternalIdentifier()
    {
        return externalIdentifier;
    }


    /**
     * Set up the unique identifier used in the external asset manager for this element.
     *
     * @param externalIdentifier string identifier
     */
    public void setExternalIdentifier(String externalIdentifier)
    {
        this.externalIdentifier = externalIdentifier;
    }


    /**
     * Return a short description of the external identifier (such as style or property name).
     *
     * @return string summary
     */
    public String getExternalIdentifierName()
    {
        return externalIdentifierName;
    }


    /**
     * Set up a short description of the external identifier (such as style or property name).
     *
     * @param externalIdentifierName string summary
     */
    public void setExternalIdentifierName(String externalIdentifierName)
    {
        this.externalIdentifierName = externalIdentifierName;
    }


    /**
     * Return a short description of how the external identifier is used.
     *
     * @return string description
     */
    public String getExternalIdentifierUsage()
    {
        return externalIdentifierUsage;
    }


    /**
     * Set up a short description of how the external identifier is used.
     *
     * @param externalIdentifierUsage string description
     */
    public void setExternalIdentifierUsage(String externalIdentifierUsage)
    {
        this.externalIdentifierUsage = externalIdentifierUsage;
    }


    /**
     * Return the component (connector/client) that created/maintained this external identifier and its relationship
     * to the open metadata element(s).
     *
     * @return component name
     */
    public String getExternalIdentifierSource()
    {
        return externalIdentifierSource;
    }


    /**
     * Set up the component (connector/client) that created/maintained this external identifier and its relationship
     * to the open metadata element(s).
     *
     * @param externalIdentifierSource component name
     */
    public void setExternalIdentifierSource(String externalIdentifierSource)
    {
        this.externalIdentifierSource = externalIdentifierSource;
    }


    /**
     * Set up the key pattern used in the asset manager for the external identifier.
     *
     * @param keyPattern String name
     */
    public void setKeyPattern(KeyPattern keyPattern)
    {
        this.keyPattern = keyPattern;
    }


    /**
     * Returns the key pattern used in the asset manager  for the external identifier.
     *
     * @return String name
     */
    public KeyPattern getKeyPattern()
    {
        return keyPattern;
    }


    /**
     * Return any additional properties to help with the mapping of the external identifier to open
     * metadata elements.
     *
     * @return name-value pairs
     */
    public Map<String, String> getMappingProperties()
    {
        if (mappingProperties == null)
        {
            return null;
        }
        else if (mappingProperties.isEmpty())
        {
            return null;
        }

        return mappingProperties;
    }


    /**
     * Set up any additional properties to help with the mapping of the external identifier to open
     * metadata elements.
     *
     * @param mappingProperties name-value pairs
     */
    public void setMappingProperties(Map<String, String> mappingProperties)
    {
        this.mappingProperties = mappingProperties;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "MetadataCorrelationProperties{" +
                       "assetManagerGUID='" + assetManagerGUID + '\'' +
                       ", assetManagerName='" + assetManagerName + '\'' +
                       ", synchronizationDirection=" + synchronizationDirection +
                       ", synchronizationDescription='" + synchronizationDescription + '\'' +
                       ", externalIdentifier='" + externalIdentifier + '\'' +
                       ", externalIdentifierName='" + externalIdentifierName + '\'' +
                       ", externalIdentifierUsage='" + externalIdentifierUsage + '\'' +
                       ", externalIdentifierSource='" + externalIdentifierSource + '\'' +
                       ", keyPattern=" + keyPattern +
                       ", mappingProperties=" + mappingProperties +
                       '}';
    }


    /**
     * Compare the values of the supplied object with those stored in the current object.
     *
     * @param objectToCompare supplied object
     * @return boolean result of comparison
     */
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
        {
            return true;
        }
        if (objectToCompare == null || getClass() != objectToCompare.getClass())
        {
            return false;
        }
        MetadataCorrelationProperties that = (MetadataCorrelationProperties) objectToCompare;
        return Objects.equals(getAssetManagerGUID(), that.getAssetManagerGUID()) &&
                       Objects.equals(getAssetManagerName(), that.getAssetManagerName()) &&
                       getSynchronizationDirection() == that.getSynchronizationDirection() &&
                       Objects.equals(getSynchronizationDescription(), that.getSynchronizationDescription()) &&
                       Objects.equals(getExternalIdentifier(), that.getExternalIdentifier()) &&
                       Objects.equals(getExternalIdentifierName(), that.getExternalIdentifierName()) &&
                       Objects.equals(getExternalIdentifierUsage(), that.getExternalIdentifierUsage()) &&
                       Objects.equals(getExternalIdentifierSource(), that.getExternalIdentifierSource()) &&
                       getKeyPattern() == that.getKeyPattern() &&
                       Objects.equals(getMappingProperties(), that.getMappingProperties());
    }


    /**
     * Return has code based on properties.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getAssetManagerGUID(), getAssetManagerName(), getSynchronizationDescription(), getExternalIdentifier(),
                            getExternalIdentifierName(), getExternalIdentifierUsage(), getExternalIdentifierSource(), getKeyPattern(), getMappingProperties());
    }
}
