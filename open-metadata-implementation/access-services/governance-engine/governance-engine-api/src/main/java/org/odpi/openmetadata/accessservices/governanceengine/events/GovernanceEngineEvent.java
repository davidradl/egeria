/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.governanceengine.events;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * GovernanceEngineEvent provides a common base for all events from the access service.
 * It implements Serializable and a version Id.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes({
                      @JsonSubTypes.Type(value = GovernanceEngineConfigurationEvent.class, name = "GovernanceEngineConfigurationEvent"),
                      @JsonSubTypes.Type(value = WatchdogGovernanceServiceEvent.class, name = "WatchdogGovernanceServiceEvent"),
                      @JsonSubTypes.Type(value = GovernanceActionEvent.class, name = "GovernanceActionEvent")
})
public abstract class GovernanceEngineEvent implements Serializable
{
    private static final long serialVersionUID = 1L;

    private long                      eventVersionId = 1L;
    private GovernanceEngineEventType eventType      = null;


    /**
     * Default Constructor sets the properties to nulls
     */
    GovernanceEngineEvent()
    {
        /*
         * Nothing to do.
         */
    }


    /**
     * Copy/clone constructor set values from the template
     *
     * @param template object to copy
     */
    GovernanceEngineEvent(GovernanceEngineEvent template)
    {
        if (template != null)
        {
            this.eventVersionId = template.getEventVersionId();
            this.eventType = template.getEventType();
        }
    }


    /**
     * Return the event version id for this event structure.
     *
     * @return long
     */
    public long getEventVersionId()
    {
        return eventVersionId;
    }


    /**
     * Set up the event version id for this event structure.
     *
     * @param eventVersionId long
     */
    public void setEventVersionId(long eventVersionId)
    {
        this.eventVersionId = eventVersionId;
    }


    /**
     * Return the type of event.
     *
     * @return event type enum
     */
    public GovernanceEngineEventType getEventType()
    {
        return eventType;
    }


    /**
     * Set up the type of event.
     *
     * @param eventType - event type enum
     */
    public void setEventType(GovernanceEngineEventType eventType)
    {
        this.eventType = eventType;
    }



    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "GovernanceEngineEvent{" +
                "eventVersionId=" + eventVersionId +
                ", eventType=" + eventType +
                '}';
    }


    /**
     * Return comparison result based on the content of the properties.
     *
     * @param objectToCompare test object
     * @return result of comparison
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
        GovernanceEngineEvent that = (GovernanceEngineEvent) objectToCompare;
        return getEventVersionId() == that.getEventVersionId() &&
                getEventType() == that.getEventType();
    }



    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getEventVersionId(), getEventType());
    }
}
