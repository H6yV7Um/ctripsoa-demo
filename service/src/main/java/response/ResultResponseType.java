package response;

import com.ctriposs.baiji.exception.BaijiRuntimeException;
import com.ctriposs.baiji.rpc.common.*;
import com.ctriposs.baiji.rpc.common.types.ResponseStatusType;
import com.ctriposs.baiji.schema.*;
import com.ctriposs.baiji.specific.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.io.Serializable;

@SuppressWarnings("all")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE) 
@JsonPropertyOrder({
    "message",
    "success",
    "responseStatus"
})
public class ResultResponseType implements SpecificRecord, HasResponseStatus, Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    public static final transient Schema SCHEMA = Schema.parse("{\"type\":\"record\",\"name\":\"ResultResponseType\",\"namespace\":\"" + ResultResponseType.class.getPackage().getName() + "\",\"doc\":null,\"fields\":[{\"name\":\"message\",\"type\":[\"string\",\"null\"]},{\"name\":\"success\",\"type\":[\"boolean\",\"null\"]},{\"name\":\"ResponseStatus\",\"type\":[{\"type\":\"record\",\"name\":\"ResponseStatusType\",\"namespace\":\"com.ctriposs.baiji.rpc.common.types\",\"doc\":null,\"fields\":[{\"name\":\"Timestamp\",\"type\":[\"datetime\",\"null\"]},{\"name\":\"Ack\",\"type\":[{\"type\":\"enum\",\"name\":\"AckCodeType\",\"namespace\":\"com.ctriposs.baiji.rpc.common.types\",\"doc\":null,\"symbols\":[\"Success\",\"Failure\",\"Warning\",\"PartialFailure\"]},\"null\"]},{\"name\":\"Errors\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ErrorDataType\",\"namespace\":\"com.ctriposs.baiji.rpc.common.types\",\"doc\":null,\"fields\":[{\"name\":\"Message\",\"type\":[\"string\",\"null\"]},{\"name\":\"ErrorCode\",\"type\":[\"string\",\"null\"]},{\"name\":\"StackTrace\",\"type\":[\"string\",\"null\"]},{\"name\":\"SeverityCode\",\"type\":[{\"type\":\"enum\",\"name\":\"SeverityCodeType\",\"namespace\":\"com.ctriposs.baiji.rpc.common.types\",\"doc\":null,\"symbols\":[\"Error\",\"Warning\"]},\"null\"]},{\"name\":\"ErrorFields\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ErrorFieldType\",\"namespace\":\"com.ctriposs.baiji.rpc.common.types\",\"doc\":null,\"fields\":[{\"name\":\"FieldName\",\"type\":[\"string\",\"null\"]},{\"name\":\"ErrorCode\",\"type\":[\"string\",\"null\"]},{\"name\":\"Message\",\"type\":[\"string\",\"null\"]}]}},\"null\"]},{\"name\":\"ErrorClassification\",\"type\":[{\"type\":\"enum\",\"name\":\"ErrorClassificationCodeType\",\"namespace\":\"com.ctriposs.baiji.rpc.common.types\",\"doc\":null,\"symbols\":[\"ServiceError\",\"ValidationError\",\"FrameworkError\",\"SLAError\",\"SecurityError\"]},\"null\"]}]}},\"null\"]},{\"name\":\"Build\",\"type\":[\"string\",\"null\"]},{\"name\":\"Version\",\"type\":[\"string\",\"null\"]},{\"name\":\"Extension\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ExtensionType\",\"namespace\":\"com.ctriposs.baiji.rpc.common.types\",\"doc\":null,\"fields\":[{\"name\":\"Id\",\"type\":[\"string\",\"null\"]},{\"name\":\"Version\",\"type\":[\"string\",\"null\"]},{\"name\":\"ContentType\",\"type\":[\"string\",\"null\"]},{\"name\":\"Value\",\"type\":[\"string\",\"null\"]}]}},\"null\"]}]},\"null\"]}]}");

    @Override
    @JsonIgnore
    public Schema getSchema() { return SCHEMA; }

    public ResultResponseType(
        String message,
        Boolean success,
        ResponseStatusType responseStatus) {
        this.message = message;
        this.success = success;
        this.responseStatus = responseStatus;
    }

    public ResultResponseType() {
    }

    @JsonProperty("message") 
    public String message;

    @JsonProperty("success") 
    public Boolean success;

    @JsonProperty("ResponseStatus") 
    public ResponseStatusType responseStatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }
    public ResponseStatusType getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(final ResponseStatusType responseStatus) {
        this.responseStatus = responseStatus;
    }

    // Used by DatumWriter. Applications should not call.
    public Object get(int fieldPos) {
        switch (fieldPos) {
            case 0: return this.message;
            case 1: return this.success;
            case 2: return this.responseStatus;
            default: throw new BaijiRuntimeException("Bad index " + fieldPos + " in get()");
        }
    }

    // Used by DatumReader. Applications should not call.
    @SuppressWarnings(value="unchecked")
    public void put(int fieldPos, Object fieldValue) {
        switch (fieldPos) {
            case 0: this.message = (String)fieldValue; break;
            case 1: this.success = (Boolean)fieldValue; break;
            case 2: this.responseStatus = (ResponseStatusType)fieldValue; break;
            default: throw new BaijiRuntimeException("Bad index " + fieldPos + " in put()");
        }
    }

    @Override
    public Object get(String fieldName) {
        Schema schema = getSchema();
        if (!(schema instanceof RecordSchema)) {
            return null;
        }
        Field field = ((RecordSchema) schema).getField(fieldName);
        return field != null ? get(field.getPos()) : null;
    }

    @Override
    public void put(String fieldName, Object fieldValue) {
        Schema schema = getSchema();
        if (!(schema instanceof RecordSchema)) {
            return;
        }
        Field field = ((RecordSchema) schema).getField(fieldName);
        if (field != null) {
            put(field.getPos(), fieldValue);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final ResultResponseType other = (ResultResponseType)obj;
        return 
            Objects.equal(this.message, other.message) &&
            Objects.equal(this.success, other.success) &&
            Objects.equal(this.responseStatus, other.responseStatus);
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + (this.message == null ? 0 : this.message.hashCode());
        result = 31 * result + (this.success == null ? 0 : this.success.hashCode());
        result = 31 * result + (this.responseStatus == null ? 0 : this.responseStatus.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("message", message)
            .add("success", success)
            .add("responseStatus", responseStatus)
            .toString();
    }
}
